
package cn.itcast.xianyu.account.service.impl;


import cn.itcast.xianyu.account.entity.SysCaptchaEntity;
import cn.itcast.xianyu.account.mapper.SysCaptchaDao;
import cn.itcast.xianyu.account.service.SysCaptchaService;
import cn.itcast.xianyu.exception.RRException;
import cn.itcast.xianyu.utils.DateUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {
    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new RRException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        SysCaptchaEntity captchaEntity = new SysCaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.save(captchaEntity);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        SysCaptchaEntity captchaEntity = this.getOne(new QueryWrapper<SysCaptchaEntity>().eq("uuid", uuid));
        if(captchaEntity == null){
            return false;
        }

        //删除验证码
        this.removeById(uuid);

        if(captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }

        return false;
    }
}