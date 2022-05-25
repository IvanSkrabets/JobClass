package by.tms.servlet.storage;

import by.tms.servlet.entity.User;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImMemoryUserStorage {


    private final static List<User> userList = new ArrayList<>();

    public void save(User user){
        userList.add(user);
    }

    public Optional<User> findByUSername(String username) {
        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
