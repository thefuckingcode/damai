package com.youku.phone.xcdnengine;

import android.text.TextUtils;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
public class Utils {
    private static final String DEBUG_VERSION = "1.1.20210101.1";
    private static final String TAG = "XcdnEngine";

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|10|11|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[SYNTHETIC, Splitter:B:26:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[SYNTHETIC, Splitter:B:30:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0082 A[SYNTHETIC, Splitter:B:36:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0089 A[SYNTHETIC, Splitter:B:40:0x0089] */
    public static boolean copFile(String str, String str2) {
        Throwable th;
        FileChannel fileChannel;
        Exception e;
        boolean z = false;
        FileChannel fileChannel2 = 0;
        try {
            System.currentTimeMillis();
            FileChannel channel = new FileInputStream(new File(str)).getChannel();
            try {
                fileChannel2 = new FileOutputStream(new File(str2)).getChannel();
                if (fileChannel2.transferFrom(channel, 0, channel.size()) == channel.size()) {
                    z = true;
                }
                channel.close();
                fileChannel2.close();
                return z;
            } catch (Exception e2) {
                e = e2;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                try {
                    AdapterForTLog.loge(TAG, "copy file from " + str + " to " + str2 + " failed : " + e);
                    if (fileChannel2 != null) {
                        try {
                            fileChannel2.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileChannel2 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = fileChannel2;
                fileChannel2 = channel;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (Exception unused3) {
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileChannel = null;
            AdapterForTLog.loge(TAG, "copy file from " + str + " to " + str2 + " failed : " + e);
            if (fileChannel2 != null) {
            }
            if (fileChannel != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            if (fileChannel2 != null) {
            }
            if (fileChannel != null) {
            }
            throw th;
        }
    }

    public static String getDomain(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return "-1";
        }
    }

    public static String getFileName(String str) {
        return new File(str).getName();
    }

    public static String getVersion(String str) {
        try {
            int lastIndexOf = str.lastIndexOf("-");
            if (lastIndexOf > -1) {
                str = str.substring(0, lastIndexOf);
            }
            String[] split = str.split("\\.");
            if (split.length == 4) {
                for (String str2 : split) {
                    if (!TextUtils.isDigitsOnly(str2)) {
                        return DEBUG_VERSION;
                    }
                }
                return str;
            }
        } catch (Exception unused) {
        }
        return DEBUG_VERSION;
    }

    public static boolean isPathValid(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str.substring(0, str.lastIndexOf(47)));
                if (file.exists()) {
                    return true;
                }
                boolean mkdirs = file.mkdirs();
                AdapterForTLog.loge(TAG, "dir: " + file.getAbsolutePath() + " no exist, make dir: " + mkdirs);
                return mkdirs;
            }
        } catch (Exception e) {
            AdapterForTLog.loge(TAG, "check download path exception:" + e);
        }
        return false;
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } catch (Error e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
