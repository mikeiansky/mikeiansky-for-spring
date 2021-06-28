package com.winson.study.spring.configuration.metadata;

import com.winson.study.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author winson
 * @date 2021/6/28
 **/
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
//        System.out.println("get bean class");
        return User.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        setPropertiesValue(element, "id", builder);
        setPropertiesValue(element, "name", builder);
    }

    private void setPropertiesValue(Element element, String attributeName, BeanDefinitionBuilder builder){
        String av = element.getAttribute(attributeName);
//        System.out.println("an : " + attributeName + " , av : " + av);
        if(StringUtils.hasText(av)){
            builder.addPropertyValue(attributeName, av);
        }
    }

}
