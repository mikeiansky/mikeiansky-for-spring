package com.winson.spring.utils;

import com.winson.spring.utils.annotation.User;
import com.winson.spring.utils.domain.Student;
import com.winson.spring.utils.domain.TopStudent;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;

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
    }

}
