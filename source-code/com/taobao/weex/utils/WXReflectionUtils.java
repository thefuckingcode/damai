package com.taobao.weex.utils;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* compiled from: Taobao */
public class WXReflectionUtils {
    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object parseArgument(Type type, Object obj) {
        if (obj != null) {
            if (obj.getClass() == type) {
                return obj;
            }
            if ((type instanceof Class) && ((Class) type).isAssignableFrom(obj.getClass())) {
                return obj;
            }
        }
        if (type == String.class) {
            return obj instanceof String ? obj : JSON.toJSONString(obj);
        }
        Class<?> cls = Integer.TYPE;
        if (type == cls) {
            return obj.getClass().isAssignableFrom(cls) ? obj : Integer.valueOf(WXUtils.getInt(obj));
        }
        Class<?> cls2 = Long.TYPE;
        if (type == cls2) {
            return obj.getClass().isAssignableFrom(cls2) ? obj : Long.valueOf(WXUtils.getLong(obj));
        }
        if (type == Double.TYPE) {
            return obj.getClass().isAssignableFrom(Double.TYPE) ? obj : Double.valueOf(WXUtils.getDouble(obj));
        }
        Class<?> cls3 = Float.TYPE;
        if (type == cls3) {
            return obj.getClass().isAssignableFrom(cls3) ? obj : Float.valueOf(WXUtils.getFloat(obj));
        }
        if (type == JSONArray.class && obj != null && obj.getClass() == JSONArray.class) {
            return obj;
        }
        if (type == JSONObject.class && obj != null && obj.getClass() == JSONObject.class) {
            return obj;
        }
        return JSON.parseObject(obj instanceof String ? (String) obj : JSON.toJSONString(obj), type, new Feature[0]);
    }

    public static void setProperty(Object obj, Field field, Object obj2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (obj != null && field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, obj2);
            } catch (Exception unused) {
            }
        }
    }

    public static void setValue(Object obj, String str, Object obj2) {
        Object obj3;
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                Field declaredField = getDeclaredField(obj, str);
                if ((obj2 instanceof BigDecimal) || (obj2 instanceof Number) || (obj2 instanceof String)) {
                    if (declaredField.getType() != Float.class) {
                        if (declaredField.getType() != Float.TYPE) {
                            if (declaredField.getType() != Double.class) {
                                if (declaredField.getType() != Double.TYPE) {
                                    if (declaredField.getType() != Integer.class) {
                                        if (declaredField.getType() != Integer.TYPE) {
                                            if (declaredField.getType() != Boolean.class) {
                                                if (declaredField.getType() == Boolean.TYPE) {
                                                }
                                            }
                                            obj3 = Boolean.valueOf(obj2.toString());
                                            if ((declaredField.getType() == Boolean.TYPE || declaredField.getType() == Boolean.class) && obj2 != null) {
                                                obj3 = Boolean.valueOf(obj2.toString());
                                            }
                                            setProperty(obj, declaredField, obj3);
                                        }
                                    }
                                    obj3 = Integer.valueOf((int) Double.parseDouble(obj2.toString()));
                                    obj3 = Boolean.valueOf(obj2.toString());
                                    setProperty(obj, declaredField, obj3);
                                }
                            }
                            obj3 = Double.valueOf(Double.parseDouble(obj2.toString()));
                            obj3 = Boolean.valueOf(obj2.toString());
                            setProperty(obj, declaredField, obj3);
                        }
                    }
                    obj3 = Float.valueOf(Float.parseFloat(obj2.toString()));
                    obj3 = Boolean.valueOf(obj2.toString());
                    setProperty(obj, declaredField, obj3);
                }
                obj3 = obj2;
                obj3 = Boolean.valueOf(obj2.toString());
                setProperty(obj, declaredField, obj3);
            } catch (Exception unused) {
            }
        }
    }
}
