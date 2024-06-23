package com.taobao.accs.utl;

import tb.ao;
import tb.e4;
import tb.w6;

/* compiled from: Taobao */
public class AppMonitorAdapter {
    public static void commitAlarmFail(String str, String str2, String str3, String str4, String str5) {
        e4 e4Var = new e4();
        e4Var.e = str;
        e4Var.f = str2;
        e4Var.b = str3;
        e4Var.c = str4;
        e4Var.d = str5;
        e4Var.a = false;
        w6.b().commitAlarm(e4Var);
    }

    public static void commitAlarmSuccess(String str, String str2, String str3) {
        e4 e4Var = new e4();
        e4Var.e = str;
        e4Var.f = str2;
        e4Var.b = str3;
        e4Var.a = true;
        w6.b().commitAlarm(e4Var);
    }

    public static void commitCount(String str, String str2, String str3, double d) {
        ao aoVar = new ao();
        aoVar.c = str;
        aoVar.d = str2;
        aoVar.a = str3;
        aoVar.b = d;
        w6.b().commitCount(aoVar);
    }
}
