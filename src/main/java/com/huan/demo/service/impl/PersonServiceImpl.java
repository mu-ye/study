package com.huan.demo.service.impl;

import com.huan.demo.domain.Person;
import com.huan.demo.mapper.PersonMapper;
import com.huan.demo.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MuBaiSama
 * @since 2021-01-15
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
