package sun.cloud.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.cloud.springcloud.entities.CommonResult;
import sun.cloud.springcloud.entities.Payment;
import sun.cloud.springcloud.service.impl.PaymentServiceImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Libra-by
 * @create 2020-03-08 23:47
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentServiceImpl paymentServiceImpl;

    /**
     * 获取application.yml里的server：port：端口号
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现客户端：显示eureka上注册的微服务的信息
    */
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentServiceImpl.create(payment);
        log.info("*******插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentServiceImpl.getPaymentById(id);
        log.info("*******查询结果:" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element:services) {
            log.info("****element:" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return  this.discoveryClient;
    }
}
