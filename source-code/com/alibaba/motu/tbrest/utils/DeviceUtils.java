package com.alibaba.motu.tbrest.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.ta.utdid2.device.UTDevice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import tb.jl1;

/* compiled from: Taobao */
public class DeviceUtils {
    private static final String NETWORK_CLASS_2_G = "2G";
    private static final String NETWORK_CLASS_3_G = "3G";
    private static final String NETWORK_CLASS_4_G = "4G";
    private static final String NETWORK_CLASS_UNKNOWN = "Unknown";
    public static final String NETWORK_CLASS_WIFI = "Wi-Fi";
    private static String[] arrayOfString = {"Unknown", "Unknown"};
    private static String carrier;
    private static String cpuName;
    private static String imei = null;
    private static String imsi = null;

    public static byte[] IntGetBytes(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i % 256);
        int i2 = i >> 8;
        bArr[2] = (byte) (i2 % 256);
        int i3 = i2 >> 8;
        bArr[1] = (byte) (i3 % 256);
        bArr[0] = (byte) ((i3 >> 8) % 256);
        return bArr;
    }

    public static String getCarrier(Context context) {
        try {
            String str = carrier;
            if (str != null) {
                return str;
            }
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            carrier = networkOperatorName;
            return networkOperatorName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getCountry() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Exception e) {
            LogUtil.e("get country error ", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0058, code lost:
        if (r0 != null) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0048 A[SYNTHETIC, Splitter:B:29:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004d A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0055  */
    public static String getCpuName() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        String str = cpuName;
        if (str != null) {
            return str;
        }
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                fileReader.close();
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return null;
                        }
                    } catch (IOException unused2) {
                        if (fileReader != null) {
                            fileReader.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } while (!readLine.contains("Hardware"));
                String str2 = readLine.split(":")[1];
                cpuName = str2;
                try {
                    fileReader.close();
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
                return str2;
            } catch (IOException unused5) {
                bufferedReader = null;
                if (fileReader != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (IOException unused6) {
            bufferedReader = null;
            fileReader = null;
            if (fileReader != null) {
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
            if (fileReader != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static String getImei(Context context) {
        String str = imei;
        if (str != null) {
            return str;
        }
        String uniqueID = getUniqueID();
        imei = uniqueID;
        return uniqueID;
    }

    public static String getImsi(Context context) {
        String str = imsi;
        if (str != null) {
            return str;
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    imsi = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSubscriberId(telephonyManager);
                }
            } catch (Exception unused) {
            }
        }
        if (StringUtils.isEmpty(imsi)) {
            imsi = getUniqueID();
        }
        return imsi;
    }

    public static String getLanguage() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            LogUtil.e("get country error ", e);
            return null;
        }
    }

    private static String getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "Unknown";
        }
    }

    @SuppressLint({"WrongConstant"})
    public static String[] getNetworkType(Context context) {
        if (context == null) {
            return arrayOfString;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return arrayOfString;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return arrayOfString;
            }
            NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo == null) {
                return arrayOfString;
            }
            if (activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    String[] strArr = arrayOfString;
                    strArr[0] = "Wi-Fi";
                    return strArr;
                } else if (activeNetworkInfo.getType() == 0) {
                    arrayOfString[0] = getNetworkClass(activeNetworkInfo.getSubtype());
                    arrayOfString[1] = activeNetworkInfo.getSubtypeName();
                    return arrayOfString;
                }
            }
            return arrayOfString;
        } catch (Throwable unused) {
        }
    }

    public static String getResolution() {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
            int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
            return i + jl1.MUL + i2;
        } catch (Exception e) {
            LogUtil.e("get resolution error", e);
            return null;
        }
    }

    public static final String getUniqueID() {
        try {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int nanoTime = (int) System.nanoTime();
            int nextInt = new Random().nextInt();
            int nextInt2 = new Random().nextInt();
            byte[] IntGetBytes = IntGetBytes(currentTimeMillis);
            byte[] IntGetBytes2 = IntGetBytes(nanoTime);
            byte[] IntGetBytes3 = IntGetBytes(nextInt);
            byte[] IntGetBytes4 = IntGetBytes(nextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(IntGetBytes, 0, bArr, 0, 4);
            System.arraycopy(IntGetBytes2, 0, bArr, 4, 4);
            System.arraycopy(IntGetBytes3, 0, bArr, 8, 4);
            System.arraycopy(IntGetBytes4, 0, bArr, 12, 4);
            return Base64.encodeBase64String(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getUtdid(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Exception e) {
            LogUtil.e("get utdid error ", e);
            return null;
        }
    }
}
