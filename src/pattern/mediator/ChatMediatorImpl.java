package pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manik on 8/13/2018.
 */
public class ChatMediatorImpl implements ChatMediator {

    private List<User> users;
    public ChatMediatorImpl(){
        this.users = new ArrayList<>();
    }
    @Override
    public void sendMessage(String msg, User user) {

        for (User u: this.users){
            if(u != user){
                u.receive(msg);
            }
        }

    }

    @Override
    public void addUser(User user) {

        this.users.add(user);
    }

    public void addUserTest(User user) {

        this.users.add(user);
    }
}
