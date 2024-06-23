package com.uc.webview.export.cyclone;

import android.annotation.SuppressLint;
import android.os.Build;
import dalvik.system.DexClassLoader;
import java.io.File;

@Constant
/* compiled from: Taobao */
public class UCLoader extends DexClassLoader {
    private static final boolean ENABLE_SPEEDUP_LOAD = true;
    private static final String TAG = "UCLoader";
    private static int sToken = UCLogger.createToken("v", TAG);

    public UCLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(beforeConstructor(str, str2), str2, str3, classLoader);
        doCheckOdexFile(str, str2, false);
    }

    private static String beforeConstructor(String str, String str2) {
        doCheckOdexFile(str, str2, true);
        int i = Build.VERSION.SDK_INT;
        return ((i == 30 || i == 31 || i == 32) && str.endsWith(".jar")) ? UCLoaderAndroid12.avoidAndroid12PreVerifyError(str) : str;
    }

    private static String doCheckOdexFile(String str, String str2, boolean z) {
        if (Build.VERSION.SDK_INT == 21) {
            for (String str3 : str.split(":")) {
                File optimizedFileFor = UCCyclone.optimizedFileFor(str3, str2);
                if (optimizedFileFor.exists()) {
                    File file = new File(str2, UCCyclone.getDecompressFileHash(optimizedFileFor));
                    if (!file.exists()) {
                        if (z) {
                            try {
                                optimizedFileFor.delete();
                                UCLogger.print(sToken, "File [" + optimizedFileFor + "] deleted.", new Throwable[0]);
                            } catch (Throwable th) {
                                UCLogger.print(sToken, "File [" + optimizedFileFor + "] delete but exception.", th);
                            }
                        } else {
                            try {
                                file.createNewFile();
                                UCLogger.print(sToken, "File [" + file + "] created.", new Throwable[0]);
                            } catch (Throwable th2) {
                                UCLogger.print(sToken, "File [" + file + "] create but exception.", th2);
                            }
                        }
                    }
                }
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    @SuppressLint({"NewApi"})
    public Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        synchronized (UCLoader.class) {
            try {
                cls = super.findClass(str);
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls == null) {
                cls = findLoadedClass(str);
            }
            if (cls != null) {
                return cls;
            }
            return getParent().loadClass(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> cls;
        synchronized (UCLoader.class) {
            if (!str.startsWith("com.uc.")) {
                if (!str.startsWith("org.chromium.")) {
                    cls = super.loadClass(str, z);
                }
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            cls = findLoadedClass == null ? findClass(str) : findLoadedClass;
        }
        return cls;
    }
}
