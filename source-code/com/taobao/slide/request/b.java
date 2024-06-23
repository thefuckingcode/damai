package com.taobao.slide.request;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.slide.core.SlideException;
import java.util.Map;
import tb.sa1;

/* compiled from: Taobao */
public abstract class b<T> {
    public static boolean d;
    protected Context a;
    protected String b;
    protected String c;

    public b(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    /* access modifiers changed from: protected */
    public abstract String a() throws Throwable;

    /* access modifiers changed from: protected */
    public abstract Map<String, String> b();

    /* access modifiers changed from: protected */
    public String c() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract T d(String str);

    public T e() throws SlideException {
        try {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                throw new SlideException(1011, "result is empty");
            } else if (TextUtils.isEmpty(this.c) || this.c.equals(sa1.d(a2))) {
                try {
                    return d(a2);
                } catch (Throwable unused) {
                    throw new SlideException(1013, "parse fail");
                }
            } else {
                throw new SlideException(1012, "md5 is not matched");
            }
        } catch (Throwable th) {
            throw new SlideException(1010, th);
        }
    }
}
