package sun.cloud.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Libra-by
 * @create 2020-03-09 12:02
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //让restTemplate开启负载均衡 默认是 轮询算法 ：1，2  1，2
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
