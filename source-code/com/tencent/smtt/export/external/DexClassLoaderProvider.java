package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

public class DexClassLoaderProvider extends DexClassLoader {
    private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
    private static final long LOAD_DEX_DELAY = 3000;
    private static final String LOGTAG = "dexloader";
    protected static DexClassLoader mClassLoaderOriginal = null;
    private static Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static DexClassLoaderProvider mInstance;
    private static String mRealDexPath;
    protected static Service mService;
    private SpeedyDexClassLoader mClassLoader = null;

    /* access modifiers changed from: private */
    public static class SpeedyDexClassLoader extends BaseDexClassLoader {
        public SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Class<?> findClass(String str) throws ClassNotFoundException {
            return super.findClass(str);
        }

        public URL findResource(String str) {
            return super.findResource(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Enumeration<URL> findResources(String str) {
            return super.findResources(str);
        }

        public synchronized Package getPackage(String str) {
            return super.getPackage(str);
        }

        @Override // java.lang.ClassLoader
        public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
            return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        }

        public Package[] getPackages() {
            return super.getPackages();
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            return super.loadClass(str, z);
        }
    }

    private DexClassLoaderProvider(String str, String str2, String str3, ClassLoader classLoader, boolean z) {
        super(str, str2, str3, classLoader);
        if (z) {
            Log.e(LOGTAG, "SpeedyDexClassLoader: " + mRealDexPath);
            this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, str3, classLoader);
            return;
        }
        Log.e(LOGTAG, "DexClassLoader: " + mRealDexPath);
        this.mClassLoader = null;
    }

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        Log.i(LOGTAG, "new DexClassLoaderDelegate: " + str + ", context: " + context);
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int lastIndexOf = str.lastIndexOf("/") + 1;
        String str4 = str.substring(0, lastIndexOf) + "fake_dex.jar";
        String substring = str.substring(lastIndexOf);
        if (!supportSpeedyClassLoader() || !is_first_load_tbs_dex(str2, substring)) {
            Log.d(LOGTAG, "new DexClassLoaderDelegate -- real: " + str);
            mInstance = new DexClassLoaderProvider(str, str2, str3, classLoader, false);
        } else {
            Log.d(LOGTAG, "new DexClassLoaderDelegate -- fake: " + str4);
            set_first_load_tbs_dex(str2, substring);
            mInstance = new DexClassLoaderProvider(str4, str2, str3, classLoader, true);
            doAsyncDexLoad(substring, str, str2, str3, classLoader);
        }
        return mInstance;
    }

    private static boolean supportSpeedyClassLoader() {
        return Build.VERSION.SDK_INT != 21 || DexLoader.mCanUseDexLoaderProviderService;
    }

    private static boolean shouldUseDexLoaderService() {
        if (!mForceLoadDexFlag && DexLoader.mCanUseDexLoaderProviderService) {
            return true;
        }
        return false;
    }

    private static void doAsyncDexLoad(final String str, final String str2, final String str3, final String str4, final ClassLoader classLoader) {
        if (shouldUseDexLoaderService()) {
            new Timer().schedule(new TimerTask() {
                /* class com.tencent.smtt.export.external.DexClassLoaderProvider.AnonymousClass1 */

                public void run() {
                    try {
                        ArrayList<String> arrayList = new ArrayList<>(4);
                        arrayList.add(0, str);
                        arrayList.add(1, str2);
                        arrayList.add(2, str3);
                        arrayList.add(3, str4);
                        Intent intent = new Intent(DexClassLoaderProvider.mContext, DexClassLoaderProviderService.class);
                        intent.putStringArrayListExtra("dex2oat", arrayList);
                        DexClassLoaderProvider.mContext.startService(intent);
                        Log.d(DexClassLoaderProvider.LOGTAG, "shouldUseDexLoaderService(" + str + ", " + intent + ")");
                    } catch (SecurityException e) {
                        Log.e(DexClassLoaderProvider.LOGTAG, "start DexLoaderService exception", e);
                    } catch (Throwable th) {
                        Log.e(DexClassLoaderProvider.LOGTAG, "after shouldUseDexLoaderService exception: " + th);
                    }
                }
            }, LOAD_DEX_DELAY);
            return;
        }
        Log.d(LOGTAG, "Background real dex loading(" + str + ")");
        new Timer().schedule(new TimerTask() {
            /* class com.tencent.smtt.export.external.DexClassLoaderProvider.AnonymousClass2 */

            public void run() {
                boolean z;
                try {
                    File file = new File(str2.replace(".jar", ".dex"));
                    if (!file.exists() || file.length() == 0) {
                        Log.d(DexClassLoaderProvider.LOGTAG, "" + file + " does not existed!");
                        z = false;
                    } else {
                        Log.d(DexClassLoaderProvider.LOGTAG, "" + file + " existed!");
                        z = true;
                    }
                    File file2 = new File(str3);
                    File file3 = new File(str2);
                    boolean exists = file2.exists();
                    boolean isDirectory = file2.isDirectory();
                    boolean exists2 = file3.exists();
                    if (!exists || !isDirectory || !exists2) {
                        Log.d(DexClassLoaderProvider.LOGTAG, "dex loading exception(" + exists + ", " + isDirectory + ", " + exists2 + ")");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    new DexClassLoader(str2, str3, str4, classLoader);
                    String format = String.format("load_dex completed -- cl_cost: %d, existed: %b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
                    Log.d(DexClassLoaderProvider.LOGTAG, "" + format);
                    if (DexClassLoaderProvider.mForceLoadDexFlag && DexClassLoaderProvider.LAST_DEX_NAME.equals(str)) {
                        Log.d(DexClassLoaderProvider.LOGTAG, "Stop provider service after loading " + str);
                        if (DexClassLoaderProvider.mService != null) {
                            Log.d(DexClassLoaderProvider.LOGTAG, "##Stop service##... ");
                            DexClassLoaderProvider.mService.stopSelf();
                        }
                    }
                } catch (Throwable th) {
                    Log.e(DexClassLoaderProvider.LOGTAG, "@AsyncDexLoad task exception: " + th);
                }
            }
        }, LOAD_DEX_DELAY);
    }

    private static boolean is_first_load_tbs_dex(String str, String str2) {
        if (mForceLoadDexFlag) {
            return true;
        }
        if (!new File(str, str2 + "_" + IS_FIRST_LOAD_DEX_FLAG_FILE).exists()) {
            return true;
        }
        return false;
    }

    private static void set_first_load_tbs_dex(String str, String str2) {
        File file = new File(str, str2 + "_" + IS_FIRST_LOAD_DEX_FLAG_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        if (useSelfClassloader()) {
            return super.findClass(str);
        }
        return this.mClassLoader.findClass(str);
    }

    public String findLibrary(String str) {
        if (useSelfClassloader()) {
            return super.findLibrary(str);
        }
        return this.mClassLoader.findLibrary(str);
    }

    /* access modifiers changed from: protected */
    public URL findResource(String str) {
        if (useSelfClassloader()) {
            return super.findResource(str);
        }
        return this.mClassLoader.findResource(str);
    }

    /* access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        if (useSelfClassloader()) {
            return super.findResources(str);
        }
        return this.mClassLoader.findResources(str);
    }

    /* access modifiers changed from: protected */
    public synchronized Package getPackage(String str) {
        if (useSelfClassloader()) {
            return super.getPackage(str);
        }
        return this.mClassLoader.getPackage(str);
    }

    public String toString() {
        if (useSelfClassloader()) {
            return super.toString();
        }
        return this.mClassLoader.toString();
    }

    public void clearAssertionStatus() {
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
        } else {
            this.mClassLoader.clearAssertionStatus();
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
        if (useSelfClassloader()) {
            return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        }
        return this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
    }

    /* access modifiers changed from: protected */
    public Package[] getPackages() {
        if (useSelfClassloader()) {
            return super.getPackages();
        }
        return this.mClassLoader.getPackages();
    }

    public URL getResource(String str) {
        if (useSelfClassloader()) {
            return super.getResource(str);
        }
        return this.mClassLoader.getResource(str);
    }

    public InputStream getResourceAsStream(String str) {
        if (useSelfClassloader()) {
            return getResourceAsStream(str);
        }
        return this.mClassLoader.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        if (useSelfClassloader()) {
            return super.getResources(str);
        }
        return this.mClassLoader.getResources(str);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (useSelfClassloader()) {
            return super.loadClass(str, z);
        }
        return this.mClassLoader.loadClass(str, z);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (useSelfClassloader()) {
            return super.loadClass(str);
        }
        return this.mClassLoader.loadClass(str);
    }

    private boolean useSelfClassloader() {
        return this.mClassLoader == null;
    }

    public void setClassAssertionStatus(String str, boolean z) {
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z);
        } else {
            this.mClassLoader.setClassAssertionStatus(str, z);
        }
    }

    public void setDefaultAssertionStatus(boolean z) {
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z);
        } else {
            this.mClassLoader.setDefaultAssertionStatus(z);
        }
    }

    public void setPackageAssertionStatus(String str, boolean z) {
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z);
        } else {
            this.mClassLoader.setPackageAssertionStatus(str, z);
        }
    }

    static void setForceLoadDexFlag(boolean z, Service service) {
        mForceLoadDexFlag = z;
        mService = service;
    }
}
