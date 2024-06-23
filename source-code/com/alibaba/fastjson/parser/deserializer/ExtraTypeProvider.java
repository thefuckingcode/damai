package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

/* compiled from: Taobao */
public interface ExtraTypeProvider extends ParseProcess {
    Type getExtraType(Object obj, String str);
}
