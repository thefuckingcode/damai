package com.alipay.euler.andfix;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.alipay.euler.andfix.annotation.MethodReplace;
import com.alipay.euler.andfix.exception.AndFixException;
import com.alipay.euler.andfix.log.Log;
import com.alipay.euler.andfix.security.SecurityChecker;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jl1;
import tb.o70;

/* compiled from: Taobao */
public class AndFixManager {
    private static Map<String, Class<?>> e = new ConcurrentHashMap();
    private static String f;
    private final Context a;
    private boolean b;
    private SecurityChecker c;
    private File d;

    public AndFixManager(Context context, boolean z) {
        this(context, z, "apatch_opt");
    }

    private String a(Method method, String str) {
        Class<?>[] parameterTypes;
        String str2;
        String str3;
        if (method == null || str == null || (parameterTypes = method.getParameterTypes()) == null) {
            return null;
        }
        if (parameterTypes.length == 0) {
            str2 = "[]";
        } else {
            String str4 = jl1.ARRAY_START_STR;
            for (Class<?> cls : parameterTypes) {
                String name = cls.getName();
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    str3 = str4 + "Z";
                } else if (name.equals("char")) {
                    str3 = str4 + "C";
                } else if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    str3 = str4 + UTConstant.Args.UT_SUCCESS_F;
                } else if (name.equals("int")) {
                    str3 = str4 + "I";
                } else if (name.equals("long")) {
                    str3 = str4 + "J";
                } else if (name.equals("short")) {
                    str3 = str4 + ExifInterface.LATITUDE_SOUTH;
                } else if (name.equals("double")) {
                    str3 = str4 + "D";
                } else if (name.equals("byte")) {
                    str3 = str4 + "B";
                } else {
                    if (!name.endsWith(";") && !name.startsWith(jl1.ARRAY_START_STR)) {
                        name = "L" + name + ";";
                    }
                    str3 = str4 + name.replaceAll("\\.", "/");
                }
                str4 = str3 + "|";
            }
            if (str4.endsWith("|")) {
                str4 = str4.substring(0, str4.length() - 1);
            }
            str2 = str4 + jl1.ARRAY_END_STR;
        }
        return str + ":" + method.getName() + ":" + str2;
    }

    private void b(Class<?> cls, ClassLoader classLoader) {
        Log.d("AndFixManager", "fixClass : " + cls.getName());
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method method : declaredMethods) {
            MethodReplace methodReplace = (MethodReplace) method.getAnnotation(MethodReplace.class);
            if (methodReplace != null) {
                String clazz = methodReplace.clazz();
                String method2 = methodReplace.method();
                if (!c(clazz) && !c(method2)) {
                    f(classLoader, clazz, method2, method);
                }
            }
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors != null) {
            for (Constructor<?> constructor : declaredConstructors) {
                MethodReplace methodReplace2 = (MethodReplace) constructor.getAnnotation(MethodReplace.class);
                if (methodReplace2 != null) {
                    String clazz2 = methodReplace2.clazz();
                    String method3 = methodReplace2.method();
                    if (!c(clazz2) && !c(method3)) {
                        e(classLoader, clazz2, method3, constructor);
                    }
                }
            }
        }
    }

    private static boolean c(String str) {
        return str == null || str.length() <= 0;
    }

    private void d(Class cls) {
        if ((cls.getModifiers() & 1) == 0) {
            AndFix.makeClassPublic(cls);
        }
    }

    private void e(ClassLoader classLoader, String str, String str2, Constructor<?> constructor) {
        try {
            String str3 = str + o70.DINAMIC_PREFIX_AT + classLoader.toString();
            Class<?> cls = e.get(str3);
            if (cls == null) {
                cls = AndFix.initTargetClass(classLoader.loadClass(str));
            }
            if (cls != null) {
                e.put(str3, cls);
                AndFix.addReplaceConstructor(cls.getDeclaredConstructor(constructor.getParameterTypes()), constructor);
            }
        } catch (Throwable th) {
            throw new AndFixException("replaceMethod failed", th);
        }
    }

    private void f(ClassLoader classLoader, String str, String str2, Method method) {
        try {
            Log.i("AndFixManager", "replaceMathod -> class : " + str + " and method : " + str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(o70.DINAMIC_PREFIX_AT);
            sb.append(classLoader.toString());
            String sb2 = sb.toString();
            Class<?> cls = e.get(sb2);
            if (cls == null) {
                Log.i("AndFixManager", "load and init class : " + str);
                cls = AndFix.initTargetClass(classLoader.loadClass(str));
            }
            if (cls != null) {
                e.put(sb2, cls);
                AndFix.addReplaceMethod(cls.getDeclaredMethod(str2, method.getParameterTypes()), method);
            }
        } catch (Throwable th) {
            Log.e("AndFixManager", "replaceMethod failed : " + th.getMessage());
            throw new AndFixException("replaceMethod failed", th);
        }
    }

    public static synchronized void removeOptFile(Context context, File file) {
        File file2;
        synchronized (AndFixManager.class) {
            if (TextUtils.isEmpty(f)) {
                file2 = new File(context.getFilesDir(), "apatch_opt");
            } else {
                File filesDir = context.getFilesDir();
                file2 = new File(filesDir, f + File.separator + "apatch_opt");
            }
            File file3 = new File(file2, file.getName());
            if (file3.exists() && !file3.delete()) {
                Log.e("AndFixManager", file3.getName() + " delete error.");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    public synchronized void fix(File file, ClassLoader classLoader, List<String> list) {
        boolean z;
        Enumeration<String> entries;
        if (this.b) {
            if (!this.c.verifyApk(file)) {
                Log.e("AndFixManager", "AndFixManager.fix() verifyApk: failed, return.");
                return;
            }
            try {
                Log.i("AndFixManager", "start fix classes");
                File file2 = new File(this.d, file.getName().replace("jar", "odex"));
                if (file2.exists()) {
                    if (this.c.verifyOpt(file2)) {
                        z = false;
                        final DexFile loadDex = DexFile.loadDex(file.getAbsolutePath(), file2.getAbsolutePath(), 0);
                        if (z) {
                            this.c.saveOptSig(file2);
                        }
                        AnonymousClass1 r0 = new ClassLoader(this, classLoader) {
                            /* class com.alipay.euler.andfix.AndFixManager.AnonymousClass1 */

                            /* access modifiers changed from: protected */
                            @Override // java.lang.ClassLoader
                            public Class<?> findClass(String str) throws ClassNotFoundException {
                                Class<?> loadClass = loadDex.loadClass(str, getParent());
                                if (loadClass == null && str.startsWith(BuildConfig.APPLICATION_ID)) {
                                    return Class.forName(str);
                                }
                                if (loadClass != null) {
                                    return loadClass;
                                }
                                throw new ClassNotFoundException(str);
                            }

                            /* access modifiers changed from: protected */
                            @Override // java.lang.ClassLoader
                            public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
                                return super.loadClass(str, z);
                            }
                        };
                        entries = loadDex.entries();
                        while (entries.hasMoreElements()) {
                            String nextElement = entries.nextElement();
                            if (list == null || list.contains(nextElement)) {
                                try {
                                    Class<?> cls = Class.forName(nextElement, true, r0);
                                    if (cls != null) {
                                        b(cls, classLoader);
                                    }
                                } catch (Throwable th) {
                                    throw new AndFixException("init patch class failed", th);
                                }
                            }
                        }
                    }
                    Log.w("AndFixManager", "AndFixManager.fix() verifyOpt: failed, try to delete opt file.");
                    if (!file2.delete()) {
                        Log.e("AndFixManager", "AndFixManager.fix() verifyOpt: failed to delete opt file. return.");
                        return;
                    }
                }
                z = true;
                final DexFile loadDex2 = DexFile.loadDex(file.getAbsolutePath(), file2.getAbsolutePath(), 0);
                if (z) {
                }
                AnonymousClass1 r02 = new ClassLoader(this, classLoader) {
                    /* class com.alipay.euler.andfix.AndFixManager.AnonymousClass1 */

                    /* access modifiers changed from: protected */
                    @Override // java.lang.ClassLoader
                    public Class<?> findClass(String str) throws ClassNotFoundException {
                        Class<?> loadClass = loadDex2.loadClass(str, getParent());
                        if (loadClass == null && str.startsWith(BuildConfig.APPLICATION_ID)) {
                            return Class.forName(str);
                        }
                        if (loadClass != null) {
                            return loadClass;
                        }
                        throw new ClassNotFoundException(str);
                    }

                    /* access modifiers changed from: protected */
                    @Override // java.lang.ClassLoader
                    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
                        return super.loadClass(str, z);
                    }
                };
                entries = loadDex2.entries();
                while (entries.hasMoreElements()) {
                }
            } catch (IOException e2) {
                throw new AndFixException("Field to fix (file=" + file + ", classLoader=" + classLoader + jl1.BRACKET_END_STR, e2);
            }
        }
    }

    public void makeClassesPublic(List<String> list, ClassLoader classLoader) {
        if (list != null) {
            Log.d("AndFixManager", "makeClassesPublic start");
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Log.i("AndFixManager", "makeClassesPublic : " + str);
                        Class<?> loadClass = classLoader.loadClass(str);
                        if (loadClass != null) {
                            d(loadClass);
                            AndFix.initFields(loadClass);
                        } else {
                            throw new ClassNotFoundException(str + " can not be found!");
                        }
                    } catch (Throwable th) {
                        Log.e("AndFixManager", "makeClassesPublic failed " + str + " " + th.getMessage());
                        throw new AndFixException("makeClassesPublic failed " + str, th);
                    }
                }
            }
        }
    }

    public void makeMethodsPublic(List<String> list, ClassLoader classLoader) {
        if (list != null) {
            Log.d("AndFixManager", "makeMethodsPublic start");
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split("\\:");
                    if (split.length >= 4) {
                        String replace = str.replace(" ", "");
                        int i = 0;
                        if (split[1].equalsIgnoreCase("<init>")) {
                            try {
                                Class<?> loadClass = classLoader.loadClass(split[0]);
                                d(loadClass);
                                Constructor<?>[] declaredConstructors = loadClass.getDeclaredConstructors();
                                while (i < declaredConstructors.length) {
                                    if ((declaredConstructors[i].getModifiers() & 1) == 0) {
                                        AndFix.makeConstructorPublic(declaredConstructors[i]);
                                    }
                                    i++;
                                }
                            } catch (Throwable th) {
                                Log.e("AndFixManager", "makeMethodsPublic.construtor failed " + str + " exception : " + th.getMessage());
                                throw new AndFixException("makeMethodsPublic.construtor failed " + str, th);
                            }
                        } else {
                            try {
                                String str2 = split[0];
                                Class<?> loadClass2 = classLoader.loadClass(str2);
                                d(loadClass2);
                                Method[] declaredMethods = loadClass2.getDeclaredMethods();
                                while (true) {
                                    if (i >= declaredMethods.length) {
                                        break;
                                    }
                                    if (TextUtils.equals(split[1], declaredMethods[i].getName())) {
                                        if ((declaredMethods[i].getModifiers() & 1) == 0) {
                                            String a2 = a(declaredMethods[i], str2);
                                            if (replace.startsWith(a2)) {
                                                Log.i("AndFixManager", "make " + a2 + " public");
                                                AndFix.makeMethodPublic(declaredMethods[i]);
                                                break;
                                            }
                                        } else {
                                            continue;
                                        }
                                    }
                                    i++;
                                }
                            } catch (Throwable th2) {
                                Log.e("AndFixManager", "makeMethodsPublic.method failed : " + th2.getMessage());
                                throw new AndFixException("makeMethodsPublic.method failed", th2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    public synchronized void preLoadAddClasses(File file, ClassLoader classLoader, List<String> list) {
        boolean z;
        Enumeration<String> entries;
        if (!(file == null || classLoader == null || list == null)) {
            try {
                if (list.size() != 0) {
                    Log.i("AndFixManager", "start preLoadAddClasses");
                    File file2 = new File(this.d, file.getName().replace("jar", "odex"));
                    if (file2.exists()) {
                        if (this.c.verifyOpt(file2)) {
                            z = false;
                            final DexFile loadDex = DexFile.loadDex(file.getAbsolutePath(), file2.getAbsolutePath(), 0);
                            if (z) {
                                this.c.saveOptSig(file2);
                            }
                            AnonymousClass2 r0 = new ClassLoader(this, classLoader) {
                                /* class com.alipay.euler.andfix.AndFixManager.AnonymousClass2 */

                                /* access modifiers changed from: protected */
                                @Override // java.lang.ClassLoader
                                public Class<?> findClass(String str) throws ClassNotFoundException {
                                    Class<?> loadClass = loadDex.loadClass(str, getParent());
                                    if (loadClass != null) {
                                        return loadClass;
                                    }
                                    throw new ClassNotFoundException(str);
                                }
                            };
                            entries = loadDex.entries();
                            while (entries.hasMoreElements()) {
                                String nextElement = entries.nextElement();
                                if (list.contains(nextElement)) {
                                    try {
                                        Class.forName(nextElement, true, r0);
                                    } catch (Throwable th) {
                                        throw new AndFixException("preLoadAddClasses : init patch class failed", th);
                                    }
                                }
                            }
                        }
                        Log.w("AndFixManager", "AndFixManager.fix() verifyOpt: failed, try to delete opt file.");
                        if (!file2.delete()) {
                            Log.e("AndFixManager", "AndFixManager.fix() verifyOpt: failed to delete opt file. return.");
                            return;
                        }
                    }
                    z = true;
                    final DexFile loadDex2 = DexFile.loadDex(file.getAbsolutePath(), file2.getAbsolutePath(), 0);
                    if (z) {
                    }
                    AnonymousClass2 r02 = new ClassLoader(this, classLoader) {
                        /* class com.alipay.euler.andfix.AndFixManager.AnonymousClass2 */

                        /* access modifiers changed from: protected */
                        @Override // java.lang.ClassLoader
                        public Class<?> findClass(String str) throws ClassNotFoundException {
                            Class<?> loadClass = loadDex2.loadClass(str, getParent());
                            if (loadClass != null) {
                                return loadClass;
                            }
                            throw new ClassNotFoundException(str);
                        }
                    };
                    entries = loadDex2.entries();
                    while (entries.hasMoreElements()) {
                    }
                }
            } catch (IOException e2) {
                throw new AndFixException("Field to preLoadAddClasses (file=" + file + ", classLoader=" + classLoader + jl1.BRACKET_END_STR, e2);
            }
        }
    }

    public void prepareClass(List<String> list, ClassLoader classLoader) {
        if (list != null) {
            Log.d("AndFixManager", "prepareClass start");
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Log.i("AndFixManager", "prepareClass : " + str);
                        Class.forName(str, true, classLoader);
                    } catch (Throwable th) {
                        Log.e("AndFixManager", "prepareClass exception " + str + " " + th.getMessage());
                        throw new AndFixException("prepareClass exception " + str, th);
                    }
                }
            }
        }
    }

    public AndFixManager(Context context, boolean z, String str) {
        this.b = false;
        this.a = context;
        boolean isSupport = Compat.isSupport();
        this.b = isSupport;
        if (isSupport) {
            this.c = new SecurityChecker(context, z);
            if (TextUtils.isEmpty(str)) {
                this.d = new File(context.getFilesDir(), "apatch_opt");
            } else {
                f = str;
                this.d = new File(context.getFilesDir(), f);
            }
            if (!this.d.exists() && !this.d.mkdirs()) {
                this.b = false;
                Log.e("AndFixManager", "opt dir create error.");
            } else if (!this.d.isDirectory()) {
                this.d.delete();
                this.b = false;
            }
        }
    }
}
