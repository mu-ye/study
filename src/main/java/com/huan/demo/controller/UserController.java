package com.huan.demo.controller;


import com.huan.demo.domain.User;
import com.huan.demo.param.UserParam;
import com.huan.demo.service.UserService;
import com.huan.demo.util.AesUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MuBaiSama
 * @since 2020-12-15
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final StringRedisTemplate redisTemplate;
    private final UserService userService;

    @GetMapping("/getList")
    List<User> getList(){
        return  userService.list();
    }

    @PostMapping("/deleteById")
    Boolean deleteById(int id){
        return userService.removeById(id);
    }

    @PostMapping("/add")
    Boolean add (@Valid @RequestBody UserParam userParam){
        User user =  new User(userParam);
        user.setPassword(AesUtil.encrypt(user.getPassword(),AesUtil.AES_KEY));
        return userService.save(user);
    }


    /**
     * 将数据缓存进 redis , 并设置缓存时间
     */
    @GetMapping("/setRedis")
    String setRedis(){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set("hello","world",10, TimeUnit.SECONDS);
        return "设置缓存成功";
    }

    /**
     * 判断缓存是否过期，如果没有过期，返回redis 存放数据
     * @return
     */
    @GetMapping("/getRedis")
    String getRedis(){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        if(redisTemplate.hasKey("hello")){
            String redisText = operations.get("hello");
            System.out.println("获取缓存中数据"+redisText);
            return redisText;
        }else {
            log.info("缓存已过期");
            return "缓存已过期";
        }
    }

}

