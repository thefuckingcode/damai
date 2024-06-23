package com.orhanobut.logger;

import tb.k92;

/* compiled from: Taobao */
public interface Printer {
    void clear();

    void d(String str, Object... objArr);

    void e(String str, Object... objArr);

    void e(Throwable th, String str, Object... objArr);

    k92 getSettings();

    void i(String str, Object... objArr);

    k92 init(String str);

    void json(String str);

    Printer t(String str, int i);

    void v(String str, Object... objArr);

    void w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
