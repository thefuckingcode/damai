package android.taobao.windvane.jsbridge.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVFileInfo;
import android.taobao.windvane.cache.WVFileInfoParser;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationManagerCompat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.ke1;

/* compiled from: Taobao */
public class WVUtils {
    public static final String LOCAL_CAPTURE_IMAGE = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=";
    public static final String URL_DATA_CHAR = "?";
    public static final String URL_SEPARATOR = "//";

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b A[SYNTHETIC, Splitter:B:14:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[SYNTHETIC, Splitter:B:19:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public static String bitmapToBase64(Bitmap bitmap) {
        String str;
        Throwable th;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    byteArrayOutputStream2 = byteArrayOutputStream;
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.flush();
                                byteArrayOutputStream2.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    return null;
                }
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayOutputStream2 != null) {
                }
                throw th;
            }
        } else {
            str = null;
        }
        if (byteArrayOutputStream2 != null) {
            try {
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
            } catch (Exception unused3) {
            }
        }
        return str;
    }

    public static String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        if (str.startsWith(URL_SEPARATOR)) {
            str = "http:" + str;
        } else if (!str.contains(ke1.SCHEME_SLASH)) {
            str = "http://" + str;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        return parse.getHost();
    }

    public static String getVirtualPath(Long l) {
        return "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + l;
    }

    public static boolean isNotificationEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    public static long saveBitmapToCache(Bitmap bitmap) throws IOException {
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        WVFileInfo wVFileInfo = new WVFileInfo();
        wVFileInfo.fileName = DigestUtils.md5ToHex("//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + currentTimeMillis);
        wVFileInfo.mimeType = "image/jpeg";
        wVFileInfo.expireTime = System.currentTimeMillis() + WVFileInfoParser.DEFAULT_MAX_AGE;
        WVCacheManager.getInstance().writeToFile(wVFileInfo, new byte[]{0});
        File file = new File(WVCacheManager.getInstance().getCacheDir(true), wVFileInfo.fileName);
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.close();
                return currentTimeMillis;
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                return 0;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused2) {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static long saveBitmapToCache(File file) {
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(WVCacheManager.getInstance().getCacheDir(true), DigestUtils.md5ToHex("//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + currentTimeMillis));
        if (file != null && file.exists() && FileManager.copy(file, file2)) {
            return currentTimeMillis;
        }
        TaoLog.w("WVUtils", "fail to copy " + file.getAbsolutePath());
        return 0;
    }
}
