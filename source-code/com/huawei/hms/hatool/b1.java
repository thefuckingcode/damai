package com.huawei.hms.hatool;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
public class b1 extends f {
    public static String c() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                y.c("hmsSdk", "getUDID success");
                return str3;
            } catch (ClassNotFoundException unused) {
                str2 = str3;
            } catch (AndroidRuntimeException unused2) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                y.f("hmsSdk", str);
                return str2;
            } catch (NoSuchMethodException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                y.f("hmsSdk", str);
                return str2;
            } catch (IllegalAccessException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                y.f("hmsSdk", str);
                return str2;
            } catch (IllegalArgumentException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                y.f("hmsSdk", str);
                return str2;
            } catch (InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                y.f("hmsSdk", str);
                return str2;
            }
        } catch (ClassNotFoundException unused7) {
            str = "getUDID method invoke failed";
            y.f("hmsSdk", str);
            return str2;
        } catch (AndroidRuntimeException unused8) {
            str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
            y.f("hmsSdk", str);
            return str2;
        } catch (NoSuchMethodException unused9) {
            str = "getUDID method invoke failed : NoSuchMethodException";
            y.f("hmsSdk", str);
            return str2;
        } catch (IllegalAccessException unused10) {
            str = "getUDID method invoke failed : Illegal AccessException";
            y.f("hmsSdk", str);
            return str2;
        } catch (IllegalArgumentException unused11) {
            str = "getUDID method invoke failed : Illegal ArgumentException";
            y.f("hmsSdk", str);
            return str2;
        } catch (InvocationTargetException unused12) {
            str = "getUDID method invoke failed : InvocationTargetException";
            y.f("hmsSdk", str);
            return str2;
        }
    }

    public static Pair<String, String> e(Context context) {
        if (q0.a(context, "android.permission.READ_PHONE_STATE")) {
            y.f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new Pair<>("", "");
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return new Pair<>("", "");
        }
        if (telephonyManager.getSimState() != 5) {
            return new Pair<>("", "");
        }
        String networkOperator = telephonyManager.getNetworkOperator();
        return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, "null")) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
    }
}
