package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Taobao */
public final class r {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
