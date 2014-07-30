package day03.phase1;

import java.util.ArrayList;
import java.util.List;

public class Counter implements Observable {
    
    private int count;
    private List<Observer> observers;

    public Counter() {
        observers = new ArrayList<>();
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        if (count > 0) {
            count--;
        }
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer obj) {
        // TODO
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return count;
    }
}
