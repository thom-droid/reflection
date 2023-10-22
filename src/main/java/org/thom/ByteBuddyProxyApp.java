package org.thom;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.thom.proxy.Car;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ByteBuddyProxyApp {

    public static void main(String[] args) throws Exception {

        Class<? extends Car> carSubClass = new ByteBuddy().subclass(Car.class)
                .method(named("printCarName")).intercept(
                        InvocationHandlerAdapter.of(new InvocationHandler() {

                            Car car = new Car();

                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                System.out.println("before method");
                                Object invoke = method.invoke(car, args);
                                System.out.println("after method");
                                return invoke;
                            }

                        })
                ).make().load(Car.class.getClassLoader()).getLoaded();

        Car car = carSubClass.getConstructor().newInstance();

        car.printCarName();


    }
}
