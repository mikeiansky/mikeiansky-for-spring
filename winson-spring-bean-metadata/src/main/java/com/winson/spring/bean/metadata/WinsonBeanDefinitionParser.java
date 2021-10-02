package com.winson.spring.bean.metadata;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author winson
 * @date 2021/10/2
 **/
public class WinsonBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
//        setPropertyValue("id", element, builder);
        setPropertyValue("name", element, builder);
        setPropertyValue("age", element, builder);
        setPropertyValue("city", element, builder);
//        builder.addPropertyValue("id", 111);
    }

    private void setPropertyValue(String attributeName, Element element, BeanDefinitionBuilder builder) {
        String attributeValue = element.getAttribute(attributeName);
        if (StringUtils.hasText(attributeValue)) {
            builder.addPropertyValue(attributeName, attributeValue); // -> <property name="" value=""/>

        }
    }

}
