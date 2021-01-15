package com.huan.demo.study;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 *  abstract Java 关键词： 修饰的类是抽象类，修饰的方法是抽象方法
 *  1. 抽象类不能够被实例化
 *  2. 抽象类中可以没有抽象方法，由抽象方法一定是抽象类
 *  3. 抽象方法只有声明，没有实现，由子类去实现
 *  4. 构造方法、类方法（static 修饰的方法，不能声明为抽象方法
 *  5. 抽象方法必须由子类实现，除非子类也是抽象类
 */








/**
 * @author 牟欢
 * @Classname ListDemo
 * @Description TODO
 * @Date 2021-01-12 14:24
 */
@Slf4j
public class ListDemo {





    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ni");
        arrayList.add("shi");
        arrayList.add("zhu");
        System.out.println(arrayList);

    }

}
