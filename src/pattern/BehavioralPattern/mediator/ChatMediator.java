package pattern.BehavioralPattern.mediator;

/**
 * Created by Manik on 8/13/2018.
 */
public interface ChatMediator {
    public void sendMessage(String msg, User user);
    void addUser(User user);
}
