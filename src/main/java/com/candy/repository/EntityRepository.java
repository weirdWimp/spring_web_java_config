package com.candy.repository;

import com.candy.entity.MessageEntity;
import com.candy.entity.User;

import java.util.List;

public interface EntityRepository {
    List<MessageEntity> getMessageList(int numbs);

    List<MessageEntity> getMessageListByName(String name);

    void saveUser(User user);

    User getUserByUsername(String userName);
}
