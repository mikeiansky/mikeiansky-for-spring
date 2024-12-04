package com.winson.spring.aop.features.v2;

import com.winson.spring.aop.overviewv2.DefaultEchoService;
import com.winson.spring.aop.overviewv2.EchoService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

import java.lang.reflect.Method;

/**
 * @author winson
 * @date 2022/4/17
 **/
public class PointCutApiDemo {

    public static class MyMethodInterceptor extends MethodBeforeAdviceInterceptor implements MethodBeforeAdvice {

        private MethodBeforeAdvice advice;

        /**
         * Create a new MethodBeforeAdviceInterceptor for the given advice.
         *
         * @param advice the MethodBeforeAdvice to wrap
         */
        public MyMethodInterceptor(MethodBeforeAdvice advice) {
            super(advice);
            this.advice = advice;
        }

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            this.advice.before(method, args, target);
        }

    }

    public static void main(String[] args) {

        DefaultEchoService service = new DefaultEchoService();

        Advisor advisor = new PointcutAdvisor() {
            @Override
            public Pointcut getPointcut() {
                return new Pointcut() {
                    @Override
                    public ClassFilter getClassFilter() {
                        return new ClassFilter() {
                            @Override
                            public boolean matches(Class<?> clazz) {
                                System.out.println("ClassFilter : clazz : " + clazz);
                                return EchoService.class.isAssignableFrom(clazz);
                            }
                        };
                    }

                    @Override
                    public MethodMatcher getMethodMatcher() {
                        return new MethodMatcher() {
                            @Override
                            public boolean matches(Method method, Class<?> targetClass) {
                                System.out.println("MethodMatcher : targetClass : " + targetClass);
//                                System.out.println("MethodMatcher : matches : " + EchoService.class.isAssignableFrom(MethodMatcher.class));
                                return method.getName().equals("sayHello") && EchoService.class.isAssignableFrom(targetClass);
                            }

                            @Override
                            public boolean isRuntime() {
                                return false;
                            }

                            @Override
                            public boolean matches(Method method, Class<?> targetClass, Object... args) {
                                return false;
                            }
                        };
                    }
                };
            }

            @Override
            public Advice getAdvice() {
                return new MethodBeforeAdviceInterceptor(new MethodBeforeAdvice() {
                    @Override
                    public void before(Method method, Object[] args, Object target) throws Throwable {
//                        System.out.println("MethodBeforeAdvice ---> method : " + method.getName());
                    }
                });

//                return new MyMethodInterceptor(new MethodBeforeAdvice() {
//                    @Override
//                    public void before(Method method, Object[] args, Object target) throws Throwable {
//                        System.out.println("MethodBeforeAdvice ---> method : " + method.getName());
//                    }
//                });
            }

            @Override
            public boolean isPerInstance() {
                return true;
            }
        };


        ProxyFactory factory = new ProxyFactory(service);
        factory.addAdvisor(advisor);

        EchoService target = (EchoService) factory.getProxy();
        target.sayHello("winson");


    }

}
