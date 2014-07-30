package day03.phase3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Counter extends Observable {
    
    private int count;
    private List<java.util.Observer> observers;

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

    public void addObserver(java.util.Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(java.util.Observer obj) {
        // TODO
    }

    @Override
    public void notifyObservers() {
        for(java.util.Observer observer: observers) {
            observer.update(this, count);
        }
    }
}
