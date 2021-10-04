package com.winson.spring.bean.type.convert;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class StringToPropertiesEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(text));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        setValue(properties);
    }

    @Override
    public String getAsText() {

        Properties properties = (Properties) getValue();

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("\r\n");
        }

        return sb.toString();
    }
}
