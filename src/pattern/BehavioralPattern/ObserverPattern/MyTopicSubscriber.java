package pattern.BehavioralPattern.ObserverPattern;

/**
 * Created by Manik on 9/3/2018.
 */
public class MyTopicSubscriber implements Observer {

    private String name;
    private Subject topic;

    public MyTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);

        if(msg == null){
            System.out.println(":: No new Msg");
        }else {
            System.out.println(":: Consuming message::"+msg);
        }
    }

    @Override
    public void setSubject(Subject subject) {

        this.topic = subject;
    }
}
