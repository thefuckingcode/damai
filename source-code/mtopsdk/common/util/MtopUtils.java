package mtopsdk.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Character;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.xstate.XState;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONObject;
import tb.u91;

/* compiled from: Taobao */
public final class MtopUtils {
    private static final char[] LOWER_CASE_ENCRYPT_CHARS = {'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'l', 'd', 'c', 'u', 'm', 'f', 'p', 'g', 'w', 'y', 'b', 'v', 'k', 'x', 'j', 'q', 'z'};
    public static final int MTOP_BIZID = 4099;
    private static final char[] NUMBER_ENCRYPT_CHARS = {'8', '6', '1', '5', YKUpsConvert.CHAR_NINE, '2', '3', YKUpsConvert.CHAR_ZERO, '4', '7'};
    private static final String TAG = "mtopsdk.MtopUtils";
    private static final char[] UPPER_CASE_ENCRYPT_CHARS = {u91.LEVEL_E, 'T', YKUpsConvert.CHAR_A, 'O', u91.LEVEL_I, 'N', 'S', 'R', 'H', u91.LEVEL_L, u91.LEVEL_D, 'C', 'U', 'M', YKUpsConvert.CHAR_F, 'P', 'G', u91.LEVEL_W, 'Y', 'B', u91.LEVEL_V, 'K', 'X', 'J', 'Q', 'Z'};
    public static final List<String> apiWhiteList = Collections.singletonList("mtop.common.gettimestamp$*");
    private static AtomicInteger counter = new AtomicInteger();
    private static volatile Context mContext = null;
    private static volatile String mProcessName = null;
    private static final int mask = Integer.MAX_VALUE;

    public static String caesarEncrypt(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                charAt = UPPER_CASE_ENCRYPT_CHARS[charAt - 'A'];
            } else if (charAt >= 'a' && charAt <= 'z') {
                charAt = LOWER_CASE_ENCRYPT_CHARS[charAt - 'a'];
            } else if (charAt >= '0' && charAt <= '9') {
                charAt = NUMBER_ENCRYPT_CHARS[charAt - '0'];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static long convertTimeFormatGMT2Long(String str) {
        if (StringUtils.isBlank(str)) {
            return -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception unused) {
            TBSdkLog.e(TAG, "[convertTimeFormatGMT2Long]parse gmt timeformat error");
        }
        if (date != null) {
            return date.getTime() / 1000;
        }
        return -1;
    }

    public static String convertUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(WVUtils.URL_SEPARATOR)) {
                str = "http:" + str;
            }
            try {
                int indexOf = str.indexOf("?");
                if (indexOf != -1) {
                    return str.substring(0, indexOf);
                }
                int indexOf2 = str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                return indexOf2 != -1 ? str.substring(0, indexOf2) : str;
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static int createIntSeqNo() {
        return counter.incrementAndGet() & Integer.MAX_VALUE;
    }

    public static Context getContext() {
        if (mContext == null) {
            synchronized (MtopUtils.class) {
                if (mContext == null) {
                    try {
                        Class<?> cls = Class.forName("android.app.ActivityThread");
                        Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                        mContext = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        TBSdkLog.e(TAG, "getContext through reflection error.");
                    }
                }
            }
        }
        return mContext;
    }

    @TargetApi(3)
    public static String getCurrentProcessName(Context context) {
        if (context == null) {
            return mProcessName;
        }
        if (mProcessName == null) {
            synchronized (MtopUtils.class) {
                if (mProcessName == null) {
                    try {
                        int myPid = Process.myPid();
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    mProcessName = next.processName;
                                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                        TBSdkLog.i(TAG, "get current processName succeed,processName=" + mProcessName);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        TBSdkLog.e(TAG, "get current processName failed.", e);
                    }
                }
            }
        }
        return mProcessName;
    }

    @TargetApi(4)
    public static boolean isApkDebug(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (context == null) {
            TBSdkLog.e(TAG, "[isApkDebug] context is null!");
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isAppOpenMock(Context context) {
        if (context == null) {
            context = getContext();
        }
        if (context == null) {
            TBSdkLog.e(TAG, "[isAppOpenMock] context is null!");
            return false;
        }
        try {
            byte[] readFile = readFile(context.getFilesDir().getCanonicalPath() + "/mock/openMock.json");
            if (readFile != null) {
                try {
                    return new JSONObject(new String(readFile)).getBoolean("openMock");
                } catch (Exception e) {
                    TBSdkLog.e(TAG, "[isAppOpenMock]parse openMock flag error in isOpenMock.json .", e);
                }
            }
            return false;
        } catch (IOException e2) {
            TBSdkLog.e(TAG, "[isAppOpenMock] parse ExternalFilesDir/mock/openMock.json filePath error.", e2);
            return false;
        }
    }

    public static final boolean isContainChineseCharacter(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            try {
                Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
                if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                    return true;
                }
            } catch (Throwable unused) {
                if (c >= 19968 && c <= 40959) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCurrentProcessBackground(Context context) {
        if (!SwitchConfig.getInstance().getProcessBgMethodNew()) {
            return XState.isAppBackground();
        }
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        if (runningAppProcessInfo.importance >= 400) {
                            z = true;
                        }
                        TBSdkLog.e(TAG, "get current process is background succeed, result=" + z);
                    }
                }
            }
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "get current process whether background exception, " + th.getMessage());
        }
        return z;
    }

    @TargetApi(3)
    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (r5 == null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0065, code lost:
        if (r5 == null) goto L_0x0068;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047 A[SYNTHETIC, Splitter:B:27:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A[SYNTHETIC, Splitter:B:36:0x0060] */
    public static byte[] readFile(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (FileNotFoundException unused) {
                byteArrayOutputStream = null;
                TBSdkLog.w(TAG, String.format("readFile error.filePath={%s} is not found.", str));
                if (byteArrayOutputStream != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                try {
                    TBSdkLog.w(TAG, String.format("readFile error.filePath={%s}", str), th);
                    if (byteArrayOutputStream != null) {
                    }
                } catch (Throwable th3) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (FileNotFoundException unused4) {
                TBSdkLog.w(TAG, String.format("readFile error.filePath={%s} is not found.", str));
                if (byteArrayOutputStream != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                TBSdkLog.w(TAG, String.format("readFile error.filePath={%s}", str), th);
                if (byteArrayOutputStream != null) {
                }
            }
        } catch (FileNotFoundException unused5) {
            byteArrayOutputStream = null;
            fileInputStream = null;
            TBSdkLog.w(TAG, String.format("readFile error.filePath={%s} is not found.", str));
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused6) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            fileInputStream = null;
            TBSdkLog.w(TAG, String.format("readFile error.filePath={%s}", str), th);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused7) {
                }
            }
        }
        try {
            fileInputStream.close();
        } catch (IOException unused8) {
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (r2 == null) goto L_0x0049;
     */
    public static Serializable readObject(File file, String str) {
        Serializable serializable;
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        ObjectInputStream objectInputStream;
        try {
            File file2 = new File(file, str);
            if (!file2.exists()) {
                return null;
            }
            fileInputStream = new FileInputStream(file2);
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
                serializable = (Serializable) objectInputStream.readObject();
            } catch (Throwable th3) {
                th2 = th3;
                serializable = null;
                th = th2;
                try {
                    TBSdkLog.w(TAG, String.format("readObject error.fileDir={%s},fileName={%s}", file, str), th);
                } catch (Throwable th4) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
            try {
                objectInputStream.close();
            } catch (Throwable th5) {
                th = th5;
                TBSdkLog.w(TAG, String.format("readObject error.fileDir={%s},fileName={%s}", file, str), th);
            }
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
            }
            return serializable;
        } catch (Throwable th6) {
            th2 = th6;
            fileInputStream = null;
            serializable = null;
            th = th2;
            TBSdkLog.w(TAG, String.format("readObject error.fileDir={%s},fileName={%s}", file, str), th);
        }
    }

    public static String urlDecode(String str, String str2) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (Exception e) {
            TBSdkLog.e(TAG, "[urlDecode] URLDecoder decode error. input=" + str + ", charset= " + str2, e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:? */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.io.File */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.io.File */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[SYNTHETIC, Splitter:B:22:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    public static boolean writeObject(Serializable serializable, File file, String str) {
        File file2;
        Throwable th;
        FileOutputStream fileOutputStream;
        boolean z = true;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            file2 = new File(file, str + new Random().nextInt(10));
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                file2 = file2;
                try {
                    TBSdkLog.w(TAG, String.format("writeObject error.fileDir={%s},fileName={%s},object={%s}", file, str, serializable), th);
                    z = false;
                    if (!z) {
                    }
                } finally {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                }
            }
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                objectOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                file2 = file2;
                TBSdkLog.w(TAG, String.format("writeObject error.fileDir={%s},fileName={%s},object={%s}", file, str, serializable), th);
                z = false;
                if (!z) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            file2 = fileOutputStream2;
            TBSdkLog.w(TAG, String.format("writeObject error.fileDir={%s},fileName={%s},object={%s}", file, str, serializable), th);
            z = false;
            if (!z) {
            }
        }
        return !z ? file2.renameTo(new File(file, str)) : z;
    }
}
