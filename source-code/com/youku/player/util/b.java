package com.youku.player.util;

import android.util.Log;

/* compiled from: Taobao */
public class b {
    private AbstractC0261b a = new AbstractC0261b() {
        /* class com.youku.player.util.b.AnonymousClass1 */

        @Override // com.youku.player.util.b.AbstractC0261b
        public int a(String str, String str2) {
            return Log.d(str, str2);
        }

        @Override // com.youku.player.util.b.AbstractC0261b
        public int a(String str, String str2, Throwable th) {
            return Log.d(str, str2, th);
        }

        @Override // com.youku.player.util.b.AbstractC0261b
        public int b(String str, String str2) {
            return Log.e(str, str2);
        }

        @Override // com.youku.player.util.b.AbstractC0261b
        public int b(String str, String str2, Throwable th) {
            return Log.e(str, str2, th);
        }
    };

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static final b a = new b();
    }

    /* renamed from: com.youku.player.util.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public interface AbstractC0261b {
        int a(String str, String str2);

        int a(String str, String str2, Throwable th);

        int b(String str, String str2);

        int b(String str, String str2, Throwable th);
    }

    b() {
    }

    public static b a() {
        return a.a;
    }

    public AbstractC0261b b() {
        return this.a;
    }
}
