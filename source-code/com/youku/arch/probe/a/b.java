package com.youku.arch.probe.a;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r5.getType() == 0) goto L_0x0038;
     */
    public static int a(Context context) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-880137961")) {
            return ((Integer) ipChange.ipc$dispatch("-880137961", new Object[]{context})).intValue();
        }
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
                if (activeNetworkInfo != null) {
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }
        i = 1;
        return i;
    }

    public static String a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330655104")) {
            return (String) ipChange.ipc$dispatch("-1330655104", new Object[]{Long.valueOf(j)});
        }
        int[] iArr = {(int) ((j >> 24) & 255), (int) ((j >> 16) & 255), (int) ((j >> 8) & 255), (int) (j & 255)};
        for (int i = 0; i < 4; i++) {
            if (iArr[i] < 0 || iArr[i] > 255) {
                return null;
            }
        }
        return Integer.toString(iArr[3]) + "." + Integer.toString(iArr[2]) + "." + Integer.toString(iArr[1]) + "." + Integer.toString(iArr[0]);
    }

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "743414770")) {
            return str != null && !str.equals("") && str.matches("([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}");
        }
        return ((Boolean) ipChange.ipc$dispatch("743414770", new Object[]{str})).booleanValue();
    }

    public static String b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116175259")) {
            return (String) ipChange.ipc$dispatch("2116175259", new Object[]{context});
        }
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo == null ? "unknown" : activeNetworkInfo.getType() == 1 ? c(context) : activeNetworkInfo.getType() == 0 ? "4G" : "unknown";
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0050 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.CharSequence] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8 A[SYNTHETIC, Splitter:B:57:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b2 A[SYNTHETIC, Splitter:B:62:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bc A[SYNTHETIC, Splitter:B:67:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00c9 A[SYNTHETIC, Splitter:B:74:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00d3 A[SYNTHETIC, Splitter:B:79:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00dd A[SYNTHETIC, Splitter:B:84:0x00dd] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static String c(Context context) {
        Throwable th;
        InputStreamReader inputStreamReader;
        InputStream inputStream;
        Exception e;
        ?? r3;
        WifiManager wifiManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932827962")) {
            return (String) ipChange.ipc$dispatch("932827962", new Object[]{context});
        }
        BufferedReader bufferedReader = 0;
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null || (wifiManager = (WifiManager) applicationContext.getSystemService("wifi")) == null) {
                return null;
            }
            String a = a((long) wifiManager.getDhcpInfo().gateway);
            Process exec = Runtime.getRuntime().exec("ip neigh show");
            exec.waitFor();
            inputStream = exec.getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            String str = bufferedReader;
                            if (readLine != null) {
                                if (readLine.contains(a)) {
                                    String[] split = readLine.split("\\s+");
                                    if (split.length >= 5) {
                                        bufferedReader = split[4];
                                        boolean isEmpty = TextUtils.isEmpty(bufferedReader);
                                        str = bufferedReader;
                                        if (isEmpty) {
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            try {
                                bufferedReader2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                inputStreamReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            if (inputStream == null) {
                                return str;
                            }
                            try {
                                inputStream.close();
                                return str;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return str;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            r3 = bufferedReader;
                            bufferedReader = bufferedReader2;
                            try {
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                return r3;
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e9) {
                    e = e9;
                    r3 = 0;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    return r3;
                }
            } catch (Exception e13) {
                e = e13;
                inputStreamReader = null;
                r3 = inputStreamReader;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (inputStream != null) {
                }
                return r3;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (inputStream != null) {
                }
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            inputStream = null;
            inputStreamReader = null;
            r3 = inputStreamReader;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            return r3;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStreamReader = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }
}
