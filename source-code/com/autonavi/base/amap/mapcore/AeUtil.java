package com.autonavi.base.amap.mapcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.mapcore.util.eq;
import com.amap.api.mapcore.util.gb;
import com.amap.api.mapcore.util.gm;
import com.amap.api.mapcore.util.hd;
import com.amap.api.mapcore.util.hm;
import com.amap.api.mapcore.util.ho;
import com.amap.api.mapcore.util.jj;
import com.amap.api.mapcore.util.jk;
import com.amap.api.mapcore.util.jn;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public class AeUtil {
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    public static final String SO_FILENAME = "AMapSDK_MAP_v7_4_0";
    public static final String SO_FILENAME_NAVI = "AMapSDK_NAVI_v6_5_0";
    public static boolean isNaviSoLoaded;

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        return listFiles != null && listFiles.length > 0;
    }

    public static void initCrashHandle(Context context, boolean z) {
        gm e;
        ho.a().a(context);
        if (hm.a(eq.e()).a(context) && (e = eq.e()) != null) {
            MsgProcessor.nativeInitInfo(context, hm.a(e).b(context), e.a(), e.b(), e.c(), e.g());
        }
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/" + ROOT_DATA_PATH_NAME + "/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                jj.a(1).a(new jk() {
                    /* class com.autonavi.base.amap.mapcore.AeUtil.AnonymousClass1 */

                    @Override // com.amap.api.mapcore.util.jk
                    public void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (gb e) {
                e.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                String str2 = new String(readFileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str2;
                if (!str2.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        initParam.mOfflineDataPath = str + "/" + "map/";
        initParam.mP3dCrossPath = str;
        return initParam;
    }

    /* access modifiers changed from: private */
    public static void loadEngineRes(String str, Context context) {
        File file = new File(str, "res");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        if (!checkEngineRes(file)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open("ae/res.zip");
                FileUtil.decompress(inputStream, file.getAbsolutePath());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                eq.a(e2);
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                eq.a(e3);
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static boolean loadLib(Context context) {
        String str = SO_FILENAME;
        try {
            if (jn.a) {
                str = jn.b;
                if (isNaviSoLoaded) {
                    return false;
                }
            }
            System.loadLibrary(str);
            if (jn.a) {
                isNaviSoLoaded = true;
            }
            return true;
        } catch (Throwable th) {
            hd.c(th, "AeUtil", "loadLib");
            eq.a(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057 A[SYNTHETIC, Splitter:B:34:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    public static void readAssetsFileAndSave(String str, String str2, Context context) {
        Throwable th;
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                InputStream open = context.getAssets().open(str);
                try {
                    File file = new File(str2);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = open.read(bArr, 0, 1024);
                            if (read > 0) {
                                fileOutputStream2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        open.close();
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        inputStream = open;
                        fileOutputStream = fileOutputStream2;
                        th = th2;
                        try {
                            th.printStackTrace();
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                        } catch (Throwable th3) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = open;
                    fileOutputStream = null;
                    th.printStackTrace();
                    if (inputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                th.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
    }
}
