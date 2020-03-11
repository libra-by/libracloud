package sun.cloud.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Libra-by
 * @create 2020-03-09 13:52
 */
@SpringBootApplication
@EnableEurekaServer //@EnableEurekaServer表示服务与注册都由7001来完成
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
