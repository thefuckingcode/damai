package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* compiled from: Taobao */
public interface FieldTypeResolver extends ParseProcess {
    Type resolve(Object obj, String str);
}
