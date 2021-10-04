package com.winson.spring.bean.type.convert;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class JavaPropertyEditorDemo {


    public static void main(String[] args) {

        StringToPropertiesEditor editor = new StringToPropertiesEditor();
        editor.setAsText("name=winson");
        System.out.println(editor.getValue());

        System.out.println(editor.getAsText());

    }

}
