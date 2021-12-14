package cn.itcast.xianyu.gateway.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import cn.itcast.xianyu.domain.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
    public static void writerError(RestResponse restResponse, HttpServletResponse response) throws IOException {
        response.setContentType("application/json,charset=utf-8");
        response.setStatus(restResponse.getCode());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),restResponse);
    }
}
