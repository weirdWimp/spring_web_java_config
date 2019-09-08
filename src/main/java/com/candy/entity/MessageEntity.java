package com.candy.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public class MessageEntity {

    private String name;

    private String time;

    private String message;


    /**
     * 默认的构造器是必须的，RequestBody 将请求实体转换为 Java 对象时，会调用默认构造器
     */
    public MessageEntity() {
    }

    public MessageEntity(String name, String time, String message) {
        this.name = name;
        this.time = time;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "name", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "name", "time");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageEntity{");
        sb.append("name='").append(name).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
