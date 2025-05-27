package io.github.mikeiansky.spring.v6.aop.base;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mike ian
 * @date 2025/5/26
 * @desc
 **/
public class CglibProxyDemo {

    public static class One {
        public void hello(){
            System.out.println("one say hello : " + this);
        }
        public void good(){
            System.out.println("one say good : " + this);
        }
    }

    public static void main(String[] args) {
        One realOne = new One();
//        System.out.println("realOne : " + realOne);
        AtomicInteger count = new AtomicInteger(0);
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(One.class.getClassLoader());
        enhancer.setSuperclass(One.class);
        enhancer.setCallbackFilter(new CallbackFilter() {

            @Override
            public int accept(Method method) {

                int index = count.getAndIncrement();
                System.out.println("accept index : " + index + ", method : " + method.getName());
                return index % 3; // 返回0,1,2
            }
        });
        enhancer.setCallbacks(new Callback[] {
//                new NoOp(){},
                new MethodInterceptor() {

                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        System.out.println("method interceptor 01 invoke method : " + method.getName());
//                        realOne.good();
                        return method.invoke(realOne, args);
//                        return proxy.invokeSuper(obj, args);
//                        return null;
                    }
                },
                new MethodInterceptor() {

                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        System.out.println("method interceptor 02 invoke method : " + method.getName());
                        return proxy.invokeSuper(obj, args);
                    }
                },
                new MethodInterceptor() {

                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        System.out.println("method interceptor 03 invoke method : " + method.getName());
                        return proxy.invokeSuper(obj, args);
                    }
                }
        });
        One one = (One) enhancer.create();
//        System.out.println("one : " + one);
//        System.out.println(one.getClass());
//        System.out.println(one.getClass().getClassLoader());
//        one.hello();
        one.good();

    }

}
