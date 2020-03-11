package sun.cloud.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.cloud.springcloud.entities.CommonResult;
import sun.cloud.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @author Libra-by
 * @blame 白云
 * @create 2020-03-09 11:55
 */
@RestController
@Slf4j
public class OrderController {

    /**
     * 单机版
     */
//    public static final String PAYMENT_URL = "http://localhost:8001";

    /**
     * provider集群，直接找eureka上的提供者的Application下的别名：CLOUD-PAYMENT-SERVICE
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
