package com.youku.passport.util;

import android.util.Log;
import com.youku.passport.result.AbsResult;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: Taobao */
public class TypeUtil {
    public static Type getClassType(Object obj, Class<?> cls) {
        if (obj == null) {
            return null;
        }
        try {
            Type type = obj.getClass();
            while (type != null && type != Object.class) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() == cls) {
                        return parameterizedType.getActualTypeArguments()[0];
                    }
                }
                type = ((Class) type).getGenericSuperclass();
            }
            return null;
        } catch (Throwable th) {
            Log.e("YKLogin.PassportSDK-Api", "find T extends AbsResult fails");
            th.printStackTrace();
            return null;
        }
    }

    public static Type getInterfaceType(Object obj, Class<?> cls) {
        Type type = null;
        if (obj == null) {
            return null;
        }
        try {
            Class<?> cls2 = obj.getClass();
            while (cls2 != null && cls2 != Object.class) {
                Type[] genericInterfaces = cls2.getGenericInterfaces();
                int length = genericInterfaces.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Type type2 = genericInterfaces[i];
                    if (type2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) type2;
                        if (parameterizedType.getRawType() == cls) {
                            type = parameterizedType.getActualTypeArguments()[0];
                            break;
                        }
                    }
                    i++;
                }
                if (type != null) {
                    break;
                }
                cls2 = (Class) cls2.getGenericSuperclass();
            }
        } catch (Throwable th) {
            Log.e("YKLogin.PassportSDK-Api", "find T extends AbsResult fails");
            th.printStackTrace();
        }
        return type;
    }

    public static <T extends AbsResult> T initResult(Object obj, Class<?> cls) {
        Type type;
        if (obj == null || cls == null) {
            return null;
        }
        if (cls.isInterface()) {
            type = getInterfaceType(obj, cls);
        } else {
            type = getClassType(obj, cls);
        }
        return (T) initResultType(type);
    }

    public static <T extends AbsResult> T initResultType(Type type) {
        if (type instanceof Class) {
            try {
                return (T) ((AbsResult) ((Class) type).newInstance());
            } catch (Throwable th) {
                Log.e("YKLogin.PassportSDK-Api", "Initiate T extends AbsResult fails");
                th.printStackTrace();
            }
        } else {
            if (type instanceof ParameterizedType) {
                try {
                    return (T) ((AbsResult) ((Class) ((ParameterizedType) type).getRawType()).newInstance());
                } catch (Throwable th2) {
                    Log.e("YKLogin.PassportSDK-Api", "Initiate CommonResult<K> fails");
                    th2.printStackTrace();
                }
            }
            return null;
        }
    }
}
