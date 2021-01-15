package com.huan.demo.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 牟欢
 * @Classname UserParam
 * @Description TODO
 * @Date 2021-01-15 14:50
 */
@Data
public class UserParam {
    @NotBlank(message = "用户名不能为空")
    public String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    public String password;
}
