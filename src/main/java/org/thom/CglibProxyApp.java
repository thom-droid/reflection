package org.thom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.thom.proxy.Car;

import java.lang.reflect.Method;

public class CglibProxyApp {

    public static void main(String[] args) {

        MethodInterceptor methodInterceptor = new MethodInterceptor() {

            Car car = new Car();

            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("print before method");
                Object invoke = method.invoke(car, objects);
                System.out.println("print after method");
                return invoke;
            }

        };

        Car carService = (Car) Enhancer.create(Car.class, methodInterceptor);

        carService.printCarName();

    }
}
