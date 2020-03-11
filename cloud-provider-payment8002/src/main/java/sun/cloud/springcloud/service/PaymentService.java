package sun.cloud.springcloud.service;

import org.apache.ibatis.annotations.Param;
import sun.cloud.springcloud.entities.Payment;

/**
 * @author Libra-by
 * @create 2020-03-08 23:39
 */
public interface PaymentService {
    public int create(Payment payment); //add save

    public Payment getPaymentById(@Param("id") Long id);

}
