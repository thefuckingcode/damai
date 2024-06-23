package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: Taobao */
public class DefaultFieldDeserializer extends FieldDeserializer {
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 2);
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        return this.fieldValueDeserilizer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        Object obj2;
        Class<?> cls;
        if (this.fieldValueDeserilizer == null) {
            ParserConfig parserConfig = defaultJSONParser.config;
            FieldInfo fieldInfo = this.fieldInfo;
            this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
        }
        Type type2 = this.fieldInfo.fieldType;
        boolean z = type instanceof ParameterizedType;
        if (z) {
            ParseContext parseContext = defaultJSONParser.contex;
            if (parseContext != null) {
                parseContext.type = type;
            }
            type2 = FieldInfo.getFieldType(this.clazz, type, type2);
            this.fieldValueDeserilizer = defaultJSONParser.config.getDeserializer(type2);
        }
        if ((type2 instanceof ParameterizedType) && z) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            ParameterizedType parameterizedType2 = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type rawType = parameterizedType2.getRawType();
            if ((rawType instanceof Class) && TypeUtils.getArgument(actualTypeArguments, ((Class) rawType).getTypeParameters(), parameterizedType2.getActualTypeArguments())) {
                type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
            }
        }
        FieldInfo fieldInfo2 = this.fieldInfo;
        String str = fieldInfo2.format;
        if (str != null) {
            ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
            if (objectDeserializer instanceof DateCodec) {
                obj2 = ((DateCodec) objectDeserializer).deserialze(defaultJSONParser, type2, fieldInfo2.name, str);
                if (defaultJSONParser.resolveStatus != 1) {
                    DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser.getLastResolveTask();
                    lastResolveTask.fieldDeserializer = this;
                    lastResolveTask.ownerContext = defaultJSONParser.contex;
                    defaultJSONParser.resolveStatus = 0;
                    return;
                } else if (obj == null) {
                    map.put(this.fieldInfo.name, obj2);
                    return;
                } else if (obj2 != null || ((cls = this.fieldInfo.fieldClass) != Byte.TYPE && cls != Short.TYPE && cls != Float.TYPE && cls != Double.TYPE)) {
                    setValue(obj, obj2);
                    return;
                } else {
                    return;
                }
            }
        }
        obj2 = this.fieldValueDeserilizer.deserialze(defaultJSONParser, type2, fieldInfo2.name);
        if (defaultJSONParser.resolveStatus != 1) {
        }
    }
}
