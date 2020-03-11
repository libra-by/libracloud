package sun.cloud.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sun.cloud.springcloud.entities.Payment;

/**
 * @author Libra-by
 * @create 2020-03-08 23:16
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment); //add save

    public Payment getPaymentById(@Param("id") Long id);
}
