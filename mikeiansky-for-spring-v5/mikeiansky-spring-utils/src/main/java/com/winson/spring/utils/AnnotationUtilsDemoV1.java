package com.winson.spring.utils;

import com.winson.spring.utils.annotation.User;
import com.winson.spring.utils.domain.Student;
import com.winson.spring.utils.domain.TopStudent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author winson
 * @date 2021/10/12
 **/
public class AnnotationUtilsDemoV1 {

    public static void main(String[] args) {
        System.out.println("===== detail student =====");
        User studentAnnotation = AnnotationUtils.findAnnotation(Student.class, User.class);

        System.out.println(studentAnnotation);

        System.out.println("===== detail topStudent =====");
        User topStudentAnnotation = AnnotationUtils.findAnnotation(TopStudent.class, User.class);
        System.out.println(topStudentAnnotation);

//        User userAnnotation = Student.class.getAnnotation(User.class);
        Map<String, Object> userAnnotationAttributes = AnnotationUtils.getAnnotationAttributes(studentAnnotation);
        System.out.println("user annotation attributes : " + userAnnotationAttributes);
        Map<String, Object> userAnnotationAttributes2 = AnnotationUtils.getAnnotationAttributes(studentAnnotation, true);
        System.out.println("user annotation attributes2 : " + userAnnotationAttributes2);
        Map<String, Object> userAnnotationAttributes3 = AnnotationUtils.getAnnotationAttributes(studentAnnotation, true, true);
        System.out.println("user annotation attributes3 : " + userAnnotationAttributes3);

        BeanDefinition bf = null;

        System.out.println(" == class == ");
        System.out.println(Student.class.getComponentType());
        System.out.println(Student[].class.getTypeName());
    }

}
