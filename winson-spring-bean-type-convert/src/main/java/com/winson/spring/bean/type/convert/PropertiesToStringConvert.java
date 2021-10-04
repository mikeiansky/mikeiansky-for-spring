package com.winson.spring.bean.type.convert;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class PropertiesToStringConvert implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        System.out.println("matches --------> sourceType : " + sourceType + " , targetType : " + targetType);
        return Properties.class.equals(sourceType.getObjectType()) && String.class.equals(targetType.getObjectType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        System.out.println("getConvertibleTypes --------> ");
        return Collections.singleton(new ConvertiblePair(Properties.class, String.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        System.out.println("convert --------> source : " + source + " , sourceType : " + sourceType + " , targetType : " + targetType);
        Properties properties = (Properties) source;

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("\r\n");
        }

        return sb.toString();
    }

}
