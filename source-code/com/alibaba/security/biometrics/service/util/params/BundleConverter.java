package com.alibaba.security.biometrics.service.util.params;

import java.lang.reflect.Type;

/* compiled from: Taobao */
public class BundleConverter {
    protected Type type;

    public Object deserialize(Object obj) {
        return obj;
    }

    public Object serialize(Object obj) {
        return obj;
    }

    public void setType(Type type2) {
        this.type = type2;
    }
}
