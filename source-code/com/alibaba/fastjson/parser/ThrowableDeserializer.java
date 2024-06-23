package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import tb.jl1;

/* compiled from: Taobao */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (java.lang.Throwable.class.isAssignableFrom(r2) != false) goto L_0x0036;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00d5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0184  */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer, com.alibaba.fastjson.parser.JavaBeanDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> cls;
        Constructor<?> constructor;
        T t;
        JavaBeanDeserializer javaBeanDeserializer;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token;
        if (i == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
        } else if (i != 12) {
            throw new JSONException("syntax error");
        }
        if (type != null && (type instanceof Class)) {
            cls = (Class) type;
        }
        cls = null;
        HashMap hashMap = null;
        Throwable th = null;
        String str = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
            if (scanSymbol == null) {
                int i2 = jSONLexer.token;
                if (i2 == 13) {
                    jSONLexer.nextToken(16);
                    constructor = null;
                    break;
                } else if (i2 == 16) {
                }
            }
            jSONLexer.nextTokenWithChar(jl1.CONDITION_IF_MIDDLE);
            if (!JSON.DEFAULT_TYPE_KEY.equals(scanSymbol)) {
                if (!"message".equals(scanSymbol)) {
                    if ("cause".equals(scanSymbol)) {
                        constructor = null;
                        th = (Throwable) deserialze(defaultJSONParser, null, "cause");
                    } else {
                        constructor = null;
                        if ("stackTrace".equals(scanSymbol)) {
                            stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class) StackTraceElement[].class);
                        } else {
                            if (hashMap == null) {
                                hashMap = new HashMap();
                            }
                            hashMap.put(scanSymbol, defaultJSONParser.parse());
                        }
                    }
                    if (jSONLexer.token != 13) {
                        jSONLexer.nextToken(16);
                        break;
                    }
                } else {
                    int i3 = jSONLexer.token;
                    if (i3 == 8) {
                        str = null;
                    } else if (i3 == 4) {
                        str = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                    jSONLexer.nextToken();
                }
            } else if (jSONLexer.token == 4) {
                cls = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader, false);
                jSONLexer.nextToken(16);
            } else {
                throw new JSONException("syntax error");
            }
            constructor = null;
            if (jSONLexer.token != 13) {
            }
        }
        if (cls == null) {
            t = (T) new Exception(str, th);
        } else {
            try {
                Constructor<?>[] constructors = cls.getConstructors();
                Constructor<?> constructor2 = constructor;
                Constructor<?> constructor3 = constructor2;
                Constructor<?> constructor4 = constructor3;
                for (Constructor<?> constructor5 : constructors) {
                    if (constructor5.getParameterTypes().length == 0) {
                        constructor4 = constructor5;
                    } else if (constructor5.getParameterTypes().length == 1 && constructor5.getParameterTypes()[0] == String.class) {
                        constructor3 = constructor5;
                    } else if (constructor5.getParameterTypes().length == 2 && constructor5.getParameterTypes()[0] == String.class && constructor5.getParameterTypes()[1] == Throwable.class) {
                        constructor2 = constructor5;
                    }
                }
                t = constructor2 != null ? (T) ((Throwable) constructor2.newInstance(str, th)) : constructor3 != null ? (T) ((Throwable) constructor3.newInstance(str)) : constructor4 != null ? (T) ((Throwable) constructor4.newInstance(new Object[0])) : null;
                if (t == null) {
                    t = (T) new Exception(str, th);
                }
            } catch (Exception e) {
                throw new JSONException("create instance error", e);
            }
        }
        if (stackTraceElementArr != null) {
            t.setStackTrace(stackTraceElementArr);
        }
        if (hashMap != null) {
            if (cls != null) {
                if (cls == this.clazz) {
                    javaBeanDeserializer = this;
                } else {
                    ObjectDeserializer deserializer = defaultJSONParser.config.getDeserializer(cls);
                    if (deserializer instanceof JavaBeanDeserializer) {
                        javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                    }
                }
                if (javaBeanDeserializer != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        Object value = entry.getValue();
                        FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer((String) entry.getKey());
                        if (fieldDeserializer != null) {
                            fieldDeserializer.setValue(t, value);
                        }
                    }
                }
            }
            javaBeanDeserializer = null;
            if (javaBeanDeserializer != null) {
            }
        }
        return t;
    }
}
