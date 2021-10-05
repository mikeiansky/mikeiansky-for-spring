package com.winson.spring.event.demo;

import java.util.Observable;
import java.util.Observer;

/**
 * @author winson
 * @date 2021/10/5
 **/
public class JavaObserverDemo {

    public static class MyObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("update o : " + o);
            System.out.println("update arg : " + arg);
        }
    }

    public static class MyObservable extends Observable{

        @Override
        public synchronized void setChanged() {
            super.setChanged();
        }
    }

    public static void main(String[] args) {

        MyObservable observable = new MyObservable();

        MyObserver myObserver = new MyObserver();
//        myObserver.update(observable, "hello event");

        observable.addObserver(myObserver);
        observable.setChanged();
        observable.notifyObservers("hello");


    }

}
