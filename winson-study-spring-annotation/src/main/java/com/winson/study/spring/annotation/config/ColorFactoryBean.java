package com.winson.study.spring.annotation.config;

import com.winson.study.spring.annotation.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author winson
 * @date 2021/7/16
 **/
public class ColorFactoryBean implements FactoryBean<Color> {

    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

}
