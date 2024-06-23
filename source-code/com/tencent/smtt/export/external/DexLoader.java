package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DexLoader {
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAF_PACKAGE_PREFIX = "com.taf";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
    static boolean mCanUseDexLoaderProviderService = true;
    private static boolean mMttClassUseCorePrivate = false;
    private static boolean mUseSpeedyClassLoader = false;
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    /* access modifiers changed from: private */
    public static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            ClassLoader parent;
            if (str == null) {
                return super.loadClass(str, z);
            }
            boolean startsWith = str.startsWith(DexLoader.JAVACORE_PACKAGE_PREFIX);
            if (DexLoader.mMttClassUseCorePrivate) {
                startsWith = startsWith || str.startsWith(DexLoader.TENCENT_PACKAGE_PREFIX) || str.startsWith(DexLoader.TAF_PACKAGE_PREFIX);
            }
            if (!startsWith) {
                return super.loadClass(str, z);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                Log.d(DexLoader.TAG, "WebCoreClassLoader - loadClass(" + str + "," + z + ")...");
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return (findLoadedClass != null || (parent = getParent()) == null) ? findLoadedClass : parent.loadClass(str);
        }
    }

    public static void initTbsSettings(Map<String, Object> map) {
        Log.d(TAG, "initTbsSettings - " + map);
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
                Object obj2 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER);
                if (obj2 instanceof Boolean) {
                    mUseSpeedyClassLoader = ((Boolean) obj2).booleanValue();
                }
                Object obj3 = map.get(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE);
                if (obj3 instanceof Boolean) {
                    mCanUseDexLoaderProviderService = ((Boolean) obj3).booleanValue();
                }
                Object obj4 = map.get(TbsCoreSettings.TBS_SETTINGS_PRAVITE_MTT_CLASSES);
                if (obj4 instanceof Boolean) {
                    mMttClassUseCorePrivate = ((Boolean) obj4).booleanValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (!mUseTbsCorePrivateClassLoader) {
            return false;
        }
        if (str.contains(TBS_FUSION_DEX) || str.contains(TBS_WEBVIEW_DEX)) {
            return true;
        }
        return false;
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        callingClassLoader = callingClassLoader == null ? context.getClassLoader() : callingClassLoader;
        Log.d("dexloader", "Set base classLoader for DexClassLoader: " + callingClassLoader);
        DexClassLoader dexClassLoader = callingClassLoader;
        for (String str3 : strArr) {
            dexClassLoader = createDexClassLoader(str3, str2, str, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this((String) null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        str3 = !TextUtils.isEmpty(str2) ? str3 + File.pathSeparator + str2 : str3;
        DexClassLoader dexClassLoader = classLoader;
        for (String str4 : strArr) {
            dexClassLoader = createDexClassLoader(str4, str, str3, dexClassLoader, context);
            this.mClassLoader = dexClassLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        DexClassLoader classLoader = dexLoader.getClassLoader();
        for (String str2 : strArr) {
            classLoader = createDexClassLoader(str2, str, context.getApplicationInfo().nativeLibraryDir, classLoader, context);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        DexClassLoader dexClassLoader;
        Log.d("dexloader", "createDexClassLoader: " + str);
        if (shouldUseTbsCorePrivateClassLoader(str)) {
            dexClassLoader = new TbsCorePrivateClassLoader(str, str2, str3, classLoader);
        } else if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 25 || !mUseSpeedyClassLoader) {
            Log.d("dexloader", "sync odex...new DexClassLoader");
            dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
        } else {
            Log.d("dexloader", "async odex...DexClassLoaderProvider.createDexClassLoader");
            try {
                dexClassLoader = DexClassLoaderProvider.createDexClassLoader(str, str2, str3, classLoader, context);
            } catch (Throwable th) {
                Log.e("dexloader", "createDexClassLoader exception: " + th);
                Log.d("dexloader", "sync odex...new DexClassLoader#2");
                dexClassLoader = new DexClassLoader(str, str2, str3, classLoader);
            }
        }
        Log.d("dexloader", "createDexClassLoader result: " + dexClassLoader);
        return dexClassLoader;
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public Object newInstance(String str) {
        try {
            return this.mClassLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "create " + str + " instance failed", th);
            return null;
        }
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                String simpleName = getClass().getSimpleName();
                Log.e(simpleName, "'newInstance " + str + " failed", th);
                return th;
            }
            String simpleName2 = getClass().getSimpleName();
            Log.e(simpleName2, "create '" + str + "' instance failed", th);
            return null;
        }
    }

    public Class<?> loadClass(String str) {
        try {
            return this.mClassLoader.loadClass(str);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "loadClass '" + str + "' failed", th);
            return null;
        }
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                String simpleName = getClass().getSimpleName();
                Log.e(simpleName, "'" + str + "' invoke static method '" + str2 + "' failed", th);
                return null;
            }
            String simpleName2 = getClass().getSimpleName();
            Log.e(simpleName2, "'" + str + "' invoke static method '" + str2 + "' failed", th);
            return th;
        }
    }

    public Object invokeMethod(Object obj, String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "'" + str + "' invoke method '" + str2 + "' failed", th);
            return null;
        }
    }

    public Object getStaticField(String str, String str2) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "'" + str + "' get field '" + str2 + "' failed", th);
            return null;
        }
    }

    public void setStaticField(String str, String str2, Object obj) {
        try {
            Field field = this.mClassLoader.loadClass(str).getField(str2);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th) {
            String simpleName = getClass().getSimpleName();
            Log.e(simpleName, "'" + str + "' set field '" + str2 + "' failed", th);
        }
    }
}
