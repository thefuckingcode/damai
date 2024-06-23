package com.uploader.implement;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.export.IUploaderDependency;
import com.uploader.export.IUploaderEnvironment;
import java.util.ArrayList;
import java.util.List;
import tb.ce0;
import tb.xs2;

/* compiled from: Taobao */
public class c {
    public final b a;
    public final xs2 b;
    public final Context c;
    IUploaderEnvironment d;

    /* compiled from: Taobao */
    class a extends xs2 {
        a(int i) {
            super(i);
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public byte[] decrypt(Context context, String str, byte[] bArr) {
            return c.this.d.decrypt(context, str, bArr);
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public boolean enableFlowControl() {
            return c.this.d.enableFlowControl();
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public String getAppVersion() {
            return c.this.d.getAppVersion();
        }

        @Override // tb.xs2
        public synchronized ce0 getCurrentElement() {
            ce0 currentElement = super.getCurrentElement();
            if (currentElement.a == c.this.d.getEnvironment() && currentElement.b.equals(c.this.d.getAppKey())) {
                return currentElement;
            }
            return new ce0(c.this.d.getEnvironment(), c.this.d.getAppKey(), TextUtils.isEmpty(c.this.d.getDomain()) ? currentElement.c : c.this.d.getDomain(), currentElement.d);
        }

        @Override // tb.xs2, com.uploader.export.IUploaderEnvironment
        public int getEnvironment() {
            return c.this.d.getEnvironment();
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public byte[] getSslTicket(Context context, String str) {
            return c.this.d.getSslTicket(context, str);
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public String getUserId() {
            return c.this.d.getUserId();
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public String getUtdid() {
            return c.this.d.getUtdid();
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public int putSslTicket(Context context, String str, byte[] bArr) {
            return c.this.d.putSslTicket(context, str, bArr);
        }

        @Override // com.uploader.export.IUploaderEnvironment
        public String signature(String str) {
            return c.this.d.signature(str);
        }
    }

    /* compiled from: Taobao */
    public static class b {
        a a = new a();
        a b = new a();
        a c = new a();
        final xs2 d;

        /* access modifiers changed from: package-private */
        /* compiled from: Taobao */
        public static class a {
            public List<Pair<String, Integer>> a = new ArrayList();
            public int b = 0;
            public List<Pair<Boolean, Pair<String, Integer>>> c = new ArrayList();
            public int d = 0;
            public Pair<String, Long> e;
            public long f = 0;

            a() {
            }
        }

        b(xs2 xs2) {
            this.d = xs2;
        }

        public Pair<String, Long> a() {
            return ((a) b(this.d.getCurrentElement()).first).e;
        }

        /* access modifiers changed from: package-private */
        public Pair<a, Integer> b(ce0 ce0) {
            int i = ce0.a;
            if (i == 1) {
                return new Pair<>(this.b, 80);
            }
            if (i != 2) {
                return new Pair<>(this.a, 443);
            }
            return new Pair<>(this.c, 80);
        }

        public void c(long j) {
            ce0 currentElement = this.d.getCurrentElement();
            Pair<a, Integer> b2 = b(currentElement);
            ((a) b2.first).f = j - (System.currentTimeMillis() / 1000);
            if (a.d(4)) {
                a.a(4, "UploaderConfig", "[updateTimestampOffset] update timestamp succeed.,environment:" + currentElement.a + ", offset=" + ((a) b2.first).f + " seconds");
            }
        }

        public void d(String str, long j, List<Pair<String, Integer>> list, List<Pair<Boolean, Pair<String, Integer>>> list2) {
            ce0 currentElement = this.d.getCurrentElement();
            Pair<a, Integer> b2 = b(currentElement);
            long currentTimeMillis = ((a) b2.first).f + (System.currentTimeMillis() / 1000) + 120;
            if (j < currentTimeMillis) {
                j = currentTimeMillis;
            }
            ((a) b2.first).e = new Pair<>(str, Long.valueOf(j));
            if (list2 != null && list2.size() > 0) {
                ((a) b2.first).c.clear();
                for (Pair<Boolean, Pair<String, Integer>> pair : list2) {
                    ((a) b2.first).c.add(pair);
                }
                ((a) b2.first).d = 0;
            }
            if (list != null && list.size() > 0) {
                ((a) b2.first).a.clear();
                Pair<String, Integer> pair2 = new Pair<>(currentElement.c, b2.second);
                Pair<String, Integer> pair3 = new Pair<>(currentElement.d, b2.second);
                for (Pair<String, Integer> pair4 : list) {
                    if (!pair2.equals(pair4) && !pair3.equals(pair4)) {
                        ((a) b2.first).a.add(pair4);
                    }
                }
                ((a) b2.first).a.add(pair2);
                ((a) b2.first).a.add(pair3);
                ((a) b2.first).b = 0;
            }
        }

        @NonNull
        public Pair<String, Integer> e() {
            ce0 currentElement = this.d.getCurrentElement();
            Pair<a, Integer> b2 = b(currentElement);
            if (((a) b2.first).a.size() == 0) {
                ((a) b2.first).a.add(new Pair<>(currentElement.c, b2.second));
                ((a) b2.first).a.add(new Pair<>(currentElement.d, b2.second));
            }
            Object obj = b2.first;
            if (((a) obj).b >= ((a) obj).a.size()) {
                ((a) b2.first).b = 0;
            }
            Object obj2 = b2.first;
            return ((a) obj2).a.get(((a) obj2).b);
        }

        public void f() {
            ((a) b(this.d.getCurrentElement()).first).b++;
        }

        @Nullable
        public Pair<Boolean, Pair<String, Integer>> g() {
            Pair<a, Integer> b2 = b(this.d.getCurrentElement());
            if (((a) b2.first).c.size() == 0) {
                return null;
            }
            Object obj = b2.first;
            if (((a) obj).d >= ((a) obj).c.size()) {
                ((a) b2.first).d = 0;
            }
            Object obj2 = b2.first;
            return ((a) obj2).c.get(((a) obj2).d);
        }

        public void h() {
            ((a) b(this.d.getCurrentElement()).first).d++;
        }

        public long i() {
            return ((a) b(this.d.getCurrentElement()).first).f;
        }

        public String j() {
            return this.d.getCurrentElement().c;
        }
    }

    c(Context context, IUploaderDependency iUploaderDependency) {
        this.c = context;
        IUploaderEnvironment environment = iUploaderDependency.getEnvironment();
        if (environment instanceof xs2) {
            this.b = (xs2) environment;
        } else {
            this.d = iUploaderDependency.getEnvironment();
            this.b = new a(0);
        }
        this.a = new b(this.b);
        b.a(iUploaderDependency.getStatistics());
        a.c(iUploaderDependency.getLog());
    }
}
