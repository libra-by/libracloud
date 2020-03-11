package sun.cloud.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回信息
 *
 * @author Libra-by
 * @blame 白云
 * @create 2020-03-08 23:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
