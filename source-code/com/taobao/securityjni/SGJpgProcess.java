package com.taobao.securityjni;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: Taobao */
public class SGJpgProcess {
    private static String[] DEFAULT_FILES = {"res/drawable/yw_1222.jpg", "res/drawable/yw_1222_mwua.jpg", "res/drawable/yw_1222_sharetoken.jpg"};
    private static String FINISHED_FILE_NAME = "SGJpgProcessFinished";
    private static String JPG_DIR_PREFIX = "jpgs_";
    private static String JPG_PREFIX = "yw_1222";
    private static String ROOT_FOLDER = "SGLib";
    private static final String TAG = "SG_Compatible";
    private static Method sOpenNonAssetMethod;
    private static boolean sOpenNonAssetMethodFetched;
    private Context ctx;

    public SGJpgProcess(Context context) {
        this.ctx = context;
    }

    private boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            int i = 0;
            while (list != null && i < list.length) {
                if (!deleteDir(new File(file, list[i]))) {
                    return false;
                }
                i++;
            }
        }
        return file.delete();
    }

    private void fetchOpenNonAssetMethod() {
        if (!sOpenNonAssetMethodFetched) {
            try {
                Method declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", String.class);
                sOpenNonAssetMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i(TAG, "Failed to retrieve openNonAsset method", e);
            }
            sOpenNonAssetMethodFetched = true;
        }
    }

    private static String getProcessName(Context context) {
        try {
            int myPid = Process.myPid();
            if (context == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    if (str != null) {
                        return str;
                    }
                    return "";
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean isMainProcess() {
        try {
            return getProcessName(this.ctx).equals(this.ctx.getPackageName());
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isPathSecurityValid(String str) {
        return !Pattern.compile("\\S*(\\.\\.)+(%)*\\S*").matcher(str).find();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0079 */
    private boolean unzipByAssetManager(String str, String str2, String[] strArr) {
        int indexOf;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        for (String str3 : strArr) {
            if (isPathSecurityValid(str3) && (indexOf = str3.indexOf(str2)) >= 0) {
                try {
                    InputStream openNonAsset = openNonAsset(this.ctx.getAssets(), str3);
                    if (openNonAsset == null) {
                        return false;
                    }
                    String substring = str3.substring(indexOf);
                    bufferedOutputStream = null;
                    try {
                        int available = openNonAsset.available();
                        fileOutputStream = new FileOutputStream(new File(str, substring));
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                            try {
                                byte[] bArr = new byte[available];
                                int i = 0;
                                while (i < available) {
                                    int read = openNonAsset.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream2.write(bArr, 0, read);
                                    i += read;
                                }
                                if (i != available) {
                                    try {
                                        bufferedOutputStream2.flush();
                                        bufferedOutputStream2.close();
                                        fileOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                    return false;
                                }
                                try {
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                    fileOutputStream.close();
                                } catch (Exception unused2) {
                                    return false;
                                }
                            } catch (Exception unused3) {
                                bufferedOutputStream = bufferedOutputStream2;
                                try {
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    fileOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedOutputStream = bufferedOutputStream2;
                                try {
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    fileOutputStream.close();
                                    throw th;
                                } catch (Exception unused5) {
                                    return false;
                                }
                            }
                        } catch (Exception unknown) {
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                            throw th;
                        }
                    } catch (Exception unused6) {
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = null;
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Exception unused7) {
                    if (str3.indexOf("sharetoken") == -1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0082 */
    private boolean unzipByPrefix(String str, String str2, String str3, String[] strArr) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        if (strArr != null) {
            try {
                if (strArr.length > 0) {
                    ZipFile zipFile = new ZipFile(str);
                    for (String str4 : strArr) {
                        if (isPathSecurityValid(str4)) {
                            ZipEntry entry = zipFile.getEntry(str4);
                            if (entry != null) {
                                int indexOf = str4.indexOf(str3);
                                if (indexOf >= 0) {
                                    InputStream inputStream = zipFile.getInputStream(entry);
                                    int size = (int) entry.getSize();
                                    String substring = str4.substring(indexOf);
                                    bufferedOutputStream = null;
                                    try {
                                        fileOutputStream = new FileOutputStream(new File(str2, substring));
                                        try {
                                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream, size);
                                            try {
                                                byte[] bArr = new byte[size];
                                                int i = 0;
                                                while (i < size) {
                                                    int read = inputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream2.write(bArr, 0, read);
                                                    i += read;
                                                }
                                                if (i != size) {
                                                    try {
                                                        bufferedOutputStream2.flush();
                                                        bufferedOutputStream2.close();
                                                        fileOutputStream.close();
                                                    } catch (Exception unused) {
                                                    }
                                                    return false;
                                                }
                                                try {
                                                    bufferedOutputStream2.flush();
                                                    bufferedOutputStream2.close();
                                                    fileOutputStream.close();
                                                } catch (Exception unused2) {
                                                }
                                            } catch (Exception unused3) {
                                                bufferedOutputStream = bufferedOutputStream2;
                                                try {
                                                    bufferedOutputStream.flush();
                                                    bufferedOutputStream.close();
                                                    fileOutputStream.close();
                                                } catch (Exception unused4) {
                                                }
                                                return false;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedOutputStream = bufferedOutputStream2;
                                                try {
                                                    bufferedOutputStream.flush();
                                                    bufferedOutputStream.close();
                                                    fileOutputStream.close();
                                                } catch (Exception unused5) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception unknown) {
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            fileOutputStream.close();
                                            throw th;
                                        }
                                    } catch (Exception unused6) {
                                        fileOutputStream = null;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileOutputStream = null;
                                        bufferedOutputStream.flush();
                                        bufferedOutputStream.close();
                                        fileOutputStream.close();
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
            } catch (IOException unused7) {
            }
        }
        return false;
    }

    private boolean writeEmptyFile(File file) {
        Throwable th;
        IOException e;
        FileOutputStream fileOutputStream = null;
        if (file != null) {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file.getAbsolutePath());
                try {
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        e.printStackTrace();
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (IOException unused2) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream.close();
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                fileOutputStream.close();
                return false;
            }
        } else {
            throw null;
        }
    }

    public InputStream openNonAsset(@NonNull AssetManager assetManager, @NonNull String str) {
        fetchOpenNonAssetMethod();
        Method method = sOpenNonAssetMethod;
        if (method == null) {
            return null;
        }
        try {
            return (InputStream) method.invoke(assetManager, str);
        } catch (IllegalAccessException unused) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public boolean unzipFinished() {
        return unzipFinished(DEFAULT_FILES);
    }

    public boolean unzipFinished(String[] strArr) {
        try {
            if (this.ctx != null) {
                if (isMainProcess()) {
                    String absolutePath = this.ctx.getDir(ROOT_FOLDER, 0).getAbsolutePath();
                    String str = this.ctx.getApplicationInfo().sourceDir;
                    String str2 = null;
                    if (str != null) {
                        File file = new File(str);
                        if (file.exists()) {
                            str2 = absolutePath + "/app_" + (file.lastModified() / 1000);
                        }
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                        str2 = str2 + "/pre_unzip_jpgs";
                        File file3 = new File(str2);
                        if (!file3.exists()) {
                            file3.mkdir();
                        }
                    }
                    File file4 = new File(str2, FINISHED_FILE_NAME);
                    if (file4.exists()) {
                        return true;
                    }
                    if (unzipByAssetManager(str2, JPG_PREFIX, strArr) || unzipByPrefix(str, str2, JPG_PREFIX, strArr)) {
                        return writeEmptyFile(file4);
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
