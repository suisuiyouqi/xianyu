package cn.itcast.xianyu.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = MongoAutoConfiguration.class,scanBasePackages = {"cn.itcast.xianyu.account"})
@EnableDiscoveryClient
@MapperScan("cn.itcast.xianyu.account.mapper") //设置mapper接口的扫描包
public class AccountService {
    public static void main(String[] args) {
        SpringApplication.run(AccountService.class,args);
    }
}
