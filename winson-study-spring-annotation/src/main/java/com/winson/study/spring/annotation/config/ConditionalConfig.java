package com.winson.study.spring.annotation.config;

import com.winson.study.spring.annotation.bean.Person;
import com.winson.study.spring.annotation.demo.conditional.LinuxConditional;
import com.winson.study.spring.annotation.demo.conditional.WindowsConditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * @author winson
 * @date 2021/7/16
 **/
@Conditional(WindowsConditional.class)
public class ConditionalConfig {

    @Bean("winson")
    public Person person() {
        return new Person("winson", 30);
    }

    @Conditional({WindowsConditional.class})
    @Bean("bill")
    public Person bill() {
        return new Person("bill", 66);
    }

    @Conditional({LinuxConditional.class})
    @Bean("linus")
    public Person linus() {
        return new Person("linus", 47);
    }

}
