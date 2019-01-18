package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.User;

import java.io.IOException;

public interface UserMapper {

    public User findUserByAccount(String account) throws IOException;

    public void insertUser(User user) throws IOException;

}
