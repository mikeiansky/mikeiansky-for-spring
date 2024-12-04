package com.winson.spring.bean.type.convert;

import com.winson.spring.overview.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @author winson
 * @date 2021/10/4
 **/
public class WinsonConvertRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        System.out.println("register custom editors ");
        registry.registerCustomEditor(User.class, new StringToPropertiesEditor());
    }

}
