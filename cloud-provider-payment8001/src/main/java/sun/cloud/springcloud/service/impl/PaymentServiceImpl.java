package sun.cloud.springcloud.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import sun.cloud.springcloud.dao.PaymentDao;
import sun.cloud.springcloud.entities.Payment;
import sun.cloud.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author Libra-by
 * @create 2020-03-08 23:41
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource //java自带的 autowired是spring的
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
       return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
