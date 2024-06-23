package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* compiled from: Taobao */
public class fs {
    public static int a = -1;
    private static AssetManager b = null;
    private static Resources c = null;
    private static Resources d = null;
    private static boolean e = true;
    private static Context f = null;
    private static String g = "amap_resource";
    private static String h = "1_0_0";
    private static String i = ".png";
    private static String j = ".jar";
    private static String k = (g + h + j);
    private static String l = (g + h + i);
    private static String m = "";
    private static String n = (m + k);
    private static Resources.Theme o = null;
    private static Resources.Theme p = null;
    private static Field q = null;
    private static Field r = null;
    private static Activity s = null;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a implements FilenameFilter {
        a() {
        }

        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(fs.h);
            sb.append(fs.j);
            return str.startsWith(fs.g) && !str.endsWith(sb.toString());
        }
    }

    public static boolean a(Context context) {
        try {
            f = context;
            File b2 = b(context);
            if (b2 != null) {
                m = b2.getAbsolutePath() + "/";
            }
            n = m + k;
            if (!e) {
                return true;
            }
            if (!c(context)) {
                return false;
            }
            AssetManager a2 = a(n);
            b = a2;
            c = a(context, a2);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void e() {
        File[] listFiles = new File(m).listFiles(new a());
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    private static File b(Context context) {
        File file;
        if (context == null) {
            if (context != null) {
                context.getFilesDir();
            }
            return null;
        }
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                file = context.getFilesDir();
            } else if (!Environment.getExternalStorageDirectory().canWrite()) {
                file = context.getFilesDir();
            } else {
                file = context.getExternalFilesDir("LBS");
            }
            if (file == null) {
                context.getFilesDir();
            }
            return file;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (0 == 0) {
                return context.getFilesDir();
            }
            return null;
        } catch (Throwable th) {
            if (0 == 0) {
                context.getFilesDir();
            }
            throw th;
        }
    }

    private static boolean c(Context context) {
        d(context);
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(l);
            if (b(inputStream)) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        hd.c(e2, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                    }
                }
                return true;
            }
            e();
            OutputStream a2 = a(inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    hd.c(e3, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return true;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    hd.c(e4, "ResourcesUtil", "copyResourceJarToAppFilesDir(Context ctx)");
                }
            }
            throw th;
        }
    }

    private static void d(Context context) {
        m = context.getFilesDir().getAbsolutePath();
        n = m + "/" + k;
    }

    public static Resources a() {
        Resources resources = c;
        return resources == null ? f.getResources() : resources;
    }

    private static Resources a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    private static boolean b(InputStream inputStream) throws IOException {
        File file = new File(n);
        long length = file.length();
        int available = inputStream.available();
        if (!file.exists() || length != ((long) available)) {
            return false;
        }
        inputStream.close();
        return true;
    }

    private static AssetManager a(String str) {
        Throwable th;
        AssetManager assetManager = null;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager2 = (AssetManager) cls.getConstructor(null).newInstance(null);
            try {
                cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager2, str);
                return assetManager2;
            } catch (Throwable th2) {
                th = th2;
                assetManager = assetManager2;
            }
        } catch (Throwable th3) {
            th = th3;
            hd.c(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager;
        }
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(m, k));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: finally extract failed */
    public static View a(Context context, int i2, ViewGroup viewGroup) {
        XmlResourceParser xml = a().getXml(i2);
        if (!e) {
            return LayoutInflater.from(context).inflate(xml, viewGroup);
        }
        try {
            int i3 = a;
            if (i3 == -1) {
                i3 = 0;
            }
            View inflate = LayoutInflater.from(new fr(context, i3, fs.class.getClassLoader())).inflate(xml, viewGroup);
            xml.close();
            return inflate;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
