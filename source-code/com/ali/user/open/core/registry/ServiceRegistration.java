package com.ali.user.open.core.registry;

import java.util.Map;

/* compiled from: Taobao */
public interface ServiceRegistration {
    void setProperties(Map<String, String> map);

    void unregister();
}
