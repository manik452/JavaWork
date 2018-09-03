package pattern.BehavioralPattern.ObserverPattern;

/**
 * Created by Manik on 8/29/2018.
 */
public interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject subject);
}
