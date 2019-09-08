package com.candy.repository;

import com.candy.entity.MessageEntity;
import com.candy.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EntityRepositoryImpl implements EntityRepository {

    private static Map<String, User> usersMap = new HashMap<>();

    static {
        User user = new User();
        user.setFirstName("Tom");
        user.setLastName("Yang");
        user.setEmail("tomyang@gmail.com");
        user.setUsername("Tom");
        user.setPassword("********");
        usersMap.put(user.getUsername(), user);
    }

    @Override
    public List<MessageEntity> getMessageList(int numbs) {
        return createMsgEntities();
    }

    @Override
    public List<MessageEntity> getMessageListByName(String name) {
        return createMsgEntities();
    }

    @Override
    public void saveUser(User user) {
        usersMap.put(user.getUsername(), user);
    }

    @Override
    public User getUserByUsername(String userName) {
        return usersMap.get(userName);
    }


    private List<MessageEntity> createMsgEntities () {
        List<MessageEntity> list = new ArrayList<>(20);
        for (int i = 0; i <= 20; i++) {
            list.add(new MessageEntity("Tom", "", "Message:" + i));
        }
        return list;
    }
}
