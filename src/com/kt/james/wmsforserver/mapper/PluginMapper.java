package com.kt.james.wmsforserver.mapper;

import com.kt.james.wmsforserver.po.Plugin;

import java.io.IOException;
import java.util.List;

public interface PluginMapper {

    List<Plugin> queryPlugins() throws IOException;

    void updatePlugin(Plugin plugin) throws IOException;

}
