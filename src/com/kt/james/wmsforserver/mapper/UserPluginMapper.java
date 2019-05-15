package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.bean.UserAccessBean;

import java.io.IOException;

public interface UserPluginMapper {

    UserAccessBean queryUserSingAccess(int user_id, int plugin_id) throws IOException;

    void updateUserAccess(UserAccessBean bean) throws IOException;

    void insertUserAccess(UserAccessBean bean) throws IOException;

}
