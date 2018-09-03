package pattern.BehavioralPattern.ObserverPattern;

import pattern.BehavioralPattern.ObserverPattern.Observer;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Manik on 9/3/2018.
 */
public class MyTopic implements Subject {
    private List<Observer> observers;
    private String message;
    private boolean change;
    private final Object MUTEX= new Object();

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {

        if(obj == null) throw  new NullPointerException("NULL OBSERVER");
        synchronized(MUTEX){
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer observer) {

        synchronized (MUTEX){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;

        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX){
            if(!change){
                return;
            }
            observersLocal = new ArrayList<>(this.observers);
            this.change=false;
        }
        for (Observer obj: observersLocal){
            obj.update();
        }

    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg) {
        System.out.println("Message Posted To: "+ msg);
        this.message = msg;
        this.change = true;
        notifyObservers();
    }
}
