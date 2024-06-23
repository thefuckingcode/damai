package com.youku.opengl.a;

import android.util.Log;

/* compiled from: Taobao */
public class a {
    public static boolean a = true;
    public static boolean b = true;
    public static boolean c = true;
    public static boolean d = true;
    public static boolean e = true;
    private static AbstractC0260a f;

    /* renamed from: com.youku.opengl.a.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0260a {
        void a(String str, String str2, String str3);
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Log.d(str, str2);
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        AbstractC0260a aVar = f;
        if (aVar != null) {
            aVar.a("YkGLWidget", str, str2);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        Log.e(str, str2);
    }
}
