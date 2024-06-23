package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.utils.a;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.ut.device.UTDevice;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
public class z60 {
    private static b70 a;

    private static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Alvin3", 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("UTCommon", 0);
        if (sharedPreferences2 != null && sharedPreferences != null) {
            String string = sharedPreferences.getString("EI", null);
            String string2 = sharedPreferences.getString("SI", null);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                String string3 = sharedPreferences2.getString("EI", null);
                String string4 = sharedPreferences2.getString("SI", null);
                if (!string.equals(string3)) {
                    SharedPreferences.Editor edit = sharedPreferences2.edit();
                    edit.putString("EI", string);
                    edit.commit();
                }
                if (!string2.equals(string4)) {
                    SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                    edit2.putString("SI", string2);
                    edit2.commit();
                }
            }
        }
    }

    private static b70 b(Context context) {
        if (context == null) {
            return null;
        }
        b70 d = d(context);
        d.v(UTDevice.getUtdid(context));
        if (zf2.f(d.b())) {
            d.m(dq1.a(context));
        }
        if (zf2.f(d.c())) {
            d.n(dq1.b(context));
        }
        return d;
    }

    public static synchronized b70 c(Context context) {
        synchronized (z60.class) {
            b70 b70 = a;
            if (b70 != null) {
                return b70;
            }
            if (context == null) {
                return null;
            }
            b70 b = b(context);
            if (b != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        return null;
                    }
                    b.l(Build.getMODEL());
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        String str = packageInfo.versionName;
                        int i = packageInfo.versionCode;
                        b.w("" + i);
                        b.g(str);
                    } catch (Exception unused) {
                        b.w(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                        b.g(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                    }
                    b.h(Build.getBRAND());
                    b.p("Android");
                    if (e()) {
                        b.p("aliyunos");
                    }
                    b.q(Build.VERSION.getRELEASE());
                    Configuration configuration = new Configuration();
                    Settings.System.getConfiguration(context.getContentResolver(), configuration);
                    Locale locale = configuration.locale;
                    if (locale != null) {
                        b.j(locale.getCountry());
                        b.o(configuration.locale.toString());
                        Calendar instance = Calendar.getInstance(configuration.locale);
                        if (instance != null) {
                            TimeZone timeZone = instance.getTimeZone();
                            if (timeZone != null) {
                                b.u("" + (timeZone.getRawOffset() / 3600000));
                            } else {
                                b.u("8");
                            }
                        } else {
                            b.u("8");
                        }
                    } else {
                        b.j(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                        b.o(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                        b.u("8");
                    }
                    try {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
                        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                        int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
                        b.t(i2);
                        b.s(i3);
                        if (i2 > i3) {
                            int i4 = i2 ^ i3;
                            i3 ^= i4;
                            i2 = i4 ^ i3;
                        }
                        b.r(i3 + jl1.MUL + i2);
                    } catch (Exception unused2) {
                        b.r(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                    }
                    b.e(NetworkUtil.c(context));
                    b.f(NetworkUtil.c(context));
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (zf2.f(networkOperatorName)) {
                        networkOperatorName = "";
                    }
                    b.i(networkOperatorName);
                } catch (Exception unused3) {
                    return null;
                }
            }
            a = b;
            return b;
        }
    }

    static b70 d(Context context) {
        String str;
        UnsupportedEncodingException e;
        IOException e2;
        String str2;
        String str3;
        String str4;
        UnsupportedEncodingException e3;
        IOException e4;
        if (context != null) {
            a(context);
            mp1 b = zt0.b(context);
            String str5 = null;
            if (b != null) {
                String b2 = b.b("EI");
                String b3 = b.b("SI");
                if (!zf2.f(b2) && !zf2.f(b3) && !zf2.f(b2)) {
                    try {
                        str3 = new String(a.d(b2.getBytes("UTF-8")), "UTF-8");
                        try {
                            str2 = new String(a.d(b3.getBytes("UTF-8")), "UTF-8");
                            try {
                                str4 = new String(a.d(b2.getBytes("UTF-8")), "UTF-8");
                            } catch (UnsupportedEncodingException e5) {
                                e3 = e5;
                            } catch (IOException e6) {
                                e4 = e6;
                                e4.printStackTrace();
                                str4 = null;
                                b70 b70 = new b70();
                                b70.k(str4);
                                b70.m(str3);
                                b70.n(str2);
                                return b70;
                            }
                        } catch (UnsupportedEncodingException e7) {
                            e3 = e7;
                            str2 = null;
                            e3.printStackTrace();
                            str4 = null;
                            b70 b702 = new b70();
                            b702.k(str4);
                            b702.m(str3);
                            b702.n(str2);
                            return b702;
                        } catch (IOException e8) {
                            e4 = e8;
                            str2 = null;
                            e4.printStackTrace();
                            str4 = null;
                            b70 b7022 = new b70();
                            b7022.k(str4);
                            b7022.m(str3);
                            b7022.n(str2);
                            return b7022;
                        }
                    } catch (UnsupportedEncodingException e9) {
                        e3 = e9;
                        str3 = null;
                        str2 = null;
                        e3.printStackTrace();
                        str4 = null;
                        b70 b70222 = new b70();
                        b70222.k(str4);
                        b70222.m(str3);
                        b70222.n(str2);
                        return b70222;
                    } catch (IOException e10) {
                        e4 = e10;
                        str3 = null;
                        str2 = null;
                        e4.printStackTrace();
                        str4 = null;
                        b70 b702222 = new b70();
                        b702222.k(str4);
                        b702222.m(str3);
                        b702222.n(str2);
                        return b702222;
                    }
                    if (!zf2.f(str3) && !zf2.f(str2) && !zf2.f(str4)) {
                        b70 b7022222 = new b70();
                        b7022222.k(str4);
                        b7022222.m(str3);
                        b7022222.n(str2);
                        return b7022222;
                    }
                }
            }
            mp1 a2 = zt0.a(context);
            if (a2 != null) {
                String b4 = a2.b("EI");
                String b5 = a2.b("SI");
                String b6 = a2.b("DID");
                if (!zf2.f(b4) && !zf2.f(b5)) {
                    try {
                        str = new String(a.d(b4.getBytes("UTF-8")), "UTF-8");
                        try {
                            str5 = new String(a.d(b5.getBytes("UTF-8")), "UTF-8");
                        } catch (UnsupportedEncodingException e11) {
                            e = e11;
                            e.printStackTrace();
                            b70 b703 = new b70();
                            b703.k(b6);
                            b703.m(b4);
                            b703.n(b5);
                            f(context, str, str5);
                            return b703;
                        } catch (IOException e12) {
                            e2 = e12;
                            e2.printStackTrace();
                            b70 b7032 = new b70();
                            b7032.k(b6);
                            b7032.m(b4);
                            b7032.n(b5);
                            f(context, str, str5);
                            return b7032;
                        }
                    } catch (UnsupportedEncodingException e13) {
                        e = e13;
                        str = null;
                        e.printStackTrace();
                        b70 b70322 = new b70();
                        b70322.k(b6);
                        b70322.m(b4);
                        b70322.n(b5);
                        f(context, str, str5);
                        return b70322;
                    } catch (IOException e14) {
                        e2 = e14;
                        str = null;
                        e2.printStackTrace();
                        b70 b703222 = new b70();
                        b703222.k(b6);
                        b703222.m(b4);
                        b703222.n(b5);
                        f(context, str, str5);
                        return b703222;
                    }
                    b70 b7032222 = new b70();
                    b7032222.k(b6);
                    b7032222.m(b4);
                    b7032222.n(b5);
                    f(context, str, str5);
                    return b7032222;
                }
            }
        }
        b70 b704 = new b70();
        String a3 = dq1.a(context);
        String b7 = dq1.b(context);
        b704.m(a3);
        b704.n(b7);
        b704.k(a3);
        f(context, a3, b7);
        return b704;
    }

    private static boolean e() {
        String property = System.getProperty("java.vm.name");
        return (property != null && property.toLowerCase().contains("lemur")) || System.getProperty("ro.yunos.version") != null;
    }

    static void f(Context context, String str, String str2) {
        mp1 b;
        String str3;
        UnsupportedEncodingException e;
        if (context != null && !zf2.f(str) && !zf2.f(str2) && (b = zt0.b(context)) != null) {
            String str4 = null;
            try {
                str3 = a.i(str.getBytes("UTF-8"));
                try {
                    str4 = a.i(str2.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                }
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                str3 = null;
                e.printStackTrace();
                if (!zf2.f(str3)) {
                    return;
                }
            }
            if (!zf2.f(str3) && !zf2.f(str4)) {
                b.d("EI", str3);
                b.d("SI", str4);
                b.a();
            }
        }
    }
}
