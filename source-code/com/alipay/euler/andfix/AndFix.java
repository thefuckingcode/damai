package com.alipay.euler.andfix;

import android.os.Build;
import com.alipay.euler.andfix.exception.AndFixException;
import com.alipay.euler.andfix.log.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: Taobao */
public class AndFix {
    public static void addReplaceConstructor(Constructor<?> constructor, Constructor<?> constructor2) {
        try {
            replaceConstructor(constructor, constructor2);
            makeConstructorPublic(constructor);
            initFields(constructor2.getDeclaringClass());
            initFields(constructor.getDeclaringClass());
        } catch (Throwable th) {
            throw new AndFixException("addReplaceConstructor failed", th);
        }
    }

    public static void addReplaceMethod(Method method, Method method2) {
        if (method != null && method2 != null) {
            try {
                Log.i("AndFix", "addReplaceMethod  src : " + method.getName() + " dest : " + method2.getName());
                replaceMethod(method, method2);
                makeMethodPublic(method);
                initFields(method2.getDeclaringClass());
                initFields(method.getDeclaringClass());
            } catch (Throwable th) {
                Log.e("AndFix", "addReplaceMethod failed : " + method.getName() + " exception : " + th.getMessage());
                throw new AndFixException("addReplaceMethod failed : " + method.getName(), th);
            }
        }
    }

    public static int getAOCAPILevel(int i, String str) {
        if (i > 22 || i <= 21) {
            return i;
        }
        Log.d("AndFix", "vmVersion: " + str);
        if (str != null && str.startsWith("2.1")) {
            return i;
        }
        if (str == null || !str.startsWith("v1.2")) {
            return 21;
        }
        return i;
    }

    public static void initFields(Class<?> cls) {
        for (Field field : cls.getDeclaredFields()) {
            setFieldFlag(field);
        }
    }

    public static Class<?> initTargetClass(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Class<?> cls2 = Class.forName(cls.getName(), true, cls.getClassLoader());
            initFields(cls2);
            return cls2;
        } catch (Throwable th) {
            throw new AndFixException("initTargetClass failed : " + cls.getName(), th);
        }
    }

    public static void makeClassPublic(Class cls) {
        boolean z;
        Field[] declaredFields;
        Constructor<?>[] declaredConstructors;
        if (cls != null) {
            AndFixVM andFixVM = Compat.getAndFixVM();
            if (andFixVM == AndFixVM.AOC || andFixVM == AndFixVM.ART) {
                int i = Build.VERSION.SDK_INT;
                if (i == 24 || i == 25) {
                    Method[] declaredMethods = cls.getDeclaredMethods();
                    boolean z2 = true;
                    if (declaredMethods == null || declaredMethods.length <= 0 || declaredMethods[0] == null) {
                        z = false;
                    } else {
                        setClassPublicFromMethod(declaredMethods[0]);
                        z = true;
                    }
                    if (z || (declaredConstructors = cls.getDeclaredConstructors()) == null || declaredConstructors.length <= 0 || declaredConstructors[0] == null) {
                        z2 = z;
                    } else {
                        setClassPublicFromMethod(declaredConstructors[0]);
                    }
                    if (!z2 && (declaredFields = cls.getDeclaredFields()) != null && declaredFields.length > 0 && declaredFields[0] != null) {
                        setClassPublicFromField(declaredFields[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                setClassPublic(cls);
            } catch (Throwable th) {
                Log.e("AndFix", "makeClassPublic failed : " + cls.getName() + " exception : " + th.getMessage());
                throw new AndFixException("makeClassPublic failed : " + cls.getSimpleName(), th);
            }
        }
    }

    public static void makeConstructorPublic(Constructor constructor) {
        if (constructor != null) {
            AndFixVM andFixVM = Compat.getAndFixVM();
            if (andFixVM != AndFixVM.AOC && andFixVM != AndFixVM.ART) {
                try {
                    setConstructorPublic(constructor);
                } catch (Throwable th) {
                    Log.e("AndFix", "makeConstructorPublic failed");
                    throw new AndFixException("makeConstructorPublic failed : " + constructor.getDeclaringClass().getName(), th);
                }
            } else if (Build.VERSION.SDK_INT <= 22) {
                try {
                    Field declaredField = Class.forName("java.lang.reflect.AbstractMethod").getDeclaredField("artMethod");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(constructor);
                    Field declaredField2 = obj.getClass().getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    int i = declaredField2.getInt(obj);
                    if ((i & 1) == 0) {
                        declaredField2.set(obj, Integer.valueOf(1 | i));
                    }
                } catch (Throwable th2) {
                    Log.e("AndFix", "makeConstructorPublic failed");
                    throw new AndFixException("makeConstructorPublic failed : " + constructor.getDeclaringClass().getName(), th2);
                }
            } else {
                try {
                    setConstructorPublic(constructor);
                } catch (Throwable th3) {
                    Log.e("AndFix", "makeConstructorPublic failed");
                    throw new AndFixException("makeConstructorPublic failed : " + constructor.getDeclaringClass().getName(), th3);
                }
            }
        }
    }

    public static void makeMethodPublic(Method method) {
        if (method != null) {
            Log.i("AndFix", "makeMethodPublic method : " + method.getName());
            AndFixVM andFixVM = Compat.getAndFixVM();
            if (andFixVM != AndFixVM.AOC && andFixVM != AndFixVM.ART) {
                try {
                    setMethodPublic(method);
                } catch (Throwable th) {
                    throw new AndFixException("makeMethodPublic failed : " + method.getName(), th);
                }
            } else if (Build.VERSION.SDK_INT <= 22) {
                try {
                    Field declaredField = Class.forName("java.lang.reflect.AbstractMethod").getDeclaredField("artMethod");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(method);
                    Field declaredField2 = obj.getClass().getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    int i = declaredField2.getInt(obj);
                    if ((i & 1) == 0) {
                        declaredField2.set(obj, Integer.valueOf(1 | i));
                    }
                } catch (Throwable th2) {
                    throw new AndFixException("makeMethodPublic failed : " + method.getName(), th2);
                }
            } else {
                try {
                    setMethodPublic(method);
                } catch (Throwable th3) {
                    throw new AndFixException("makeMethodPublic failed : " + method.getName(), th3);
                }
            }
        }
    }

    private static native void replaceConstructor(Constructor constructor, Constructor constructor2);

    private static native void replaceMethod(Method method, Method method2);

    public static void rollback() {
        rollbackMethods();
    }

    private static native void rollbackMethods();

    private static native void setClassPublic(Class<?> cls);

    private static native void setClassPublicFromField(Object obj);

    private static native void setClassPublicFromMethod(Object obj);

    private static native void setConstructorPublic(Constructor constructor);

    private static native void setFieldFlag(Field field);

    private static native void setMethodPublic(Method method);

    public static boolean setup() {
        int i;
        AndFixVM andFixVM = Compat.getAndFixVM();
        Log.i("mytest", "getAndFixVM: " + Compat.getAndFixVM());
        try {
            Runtime.getRuntime().loadLibrary("andfix");
            String property = System.getProperty("java.vm.version");
            int i2 = Build.VERSION.SDK_INT;
            if (andFixVM == AndFixVM.Lemur) {
                i = 0;
            } else if (andFixVM == AndFixVM.AOC) {
                i = 3;
                i2 = getAOCAPILevel(i2, property);
            } else {
                i = andFixVM == AndFixVM.ART ? 2 : 1;
            }
            return setup(i, i2);
        } catch (Throwable th) {
            Log.e("AndFix", "loadLibrary & setup failed.", th);
            return false;
        }
    }

    private static native boolean setup(int i, int i2);
}
