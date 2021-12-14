package cn.itcast.xianyu.gateway.filter;
import cn.itcast.xianyu.utils.EncryptUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";//前置过滤器，可以在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1.获取Spring Security OAuth2的认证信息对象
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if(authentication==null || !(authentication instanceof OAuth2Authentication)){
            return null;// 无token访问网关内资源，直接返回null
        }
        //2.将当前登录的用户以及接入客户端的信息放入Map中
        OAuth2Authentication oauth2Authentication=(OAuth2Authentication)authentication;

        Map<String,String> jsonToken = new HashMap<>
                (oauth2Authentication.getOAuth2Request().getRequestParameters());
        /*3.将jsonToken写入转发微服务的request中，这样微服务就能通过
            request.getParams("jsonToken")获取到了*/
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        request.getParameterMap();// 关键步骤，一定要get一下，下面这行代码才能取到值
        Map<String,List<String>> requestQueryParams = ctx.getRequestQueryParams();
        if (requestQueryParams == null) {
            requestQueryParams = new HashMap<>();
        }
        List<String> arrayList = new ArrayList<>();
        arrayList.add(EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        requestQueryParams.put("jsonToken", arrayList);
        ctx.setRequestQueryParams(requestQueryParams);
        return null;
    }
    }

