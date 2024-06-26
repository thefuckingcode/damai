package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.t;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import tb.k61;
import tb.la1;
import tb.na1;
import tb.o91;
import tb.oa1;
import tb.xt2;

/* compiled from: Taobao */
public class b {
    private static final Map<String, LottieTask<a>> a = new HashMap();
    private static final byte[] b = {80, 75, 3, 4};

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements LottieListener<a> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public void onResult(a aVar) {
            b.a.remove(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0067b implements LottieListener<Throwable> {
        final /* synthetic */ String a;

        C0067b(String str) {
            this.a = str;
        }

        /* renamed from: a */
        public void onResult(Throwable th) {
            b.a.remove(this.a);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements Callable<oa1<a>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        c(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public oa1<a> call() {
            oa1<a> c2 = k61.d(this.a).c(this.b, this.c);
            if (!(this.c == null || c2.b() == null)) {
                la1.b().c(this.c, c2.b());
            }
            return c2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements Callable<oa1<a>> {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        d(Context context, String str, String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public oa1<a> call() {
            return b.g(this.a, this.b, this.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e implements Callable<oa1<a>> {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        e(WeakReference weakReference, Context context, int i, String str) {
            this.a = weakReference;
            this.b = context;
            this.c = i;
            this.d = str;
        }

        /* renamed from: a */
        public oa1<a> call() {
            Context context = (Context) this.a.get();
            if (context == null) {
                context = this.b;
            }
            return b.r(context, this.c, this.d);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class f implements Callable<oa1<a>> {
        final /* synthetic */ InputStream a;
        final /* synthetic */ String b;

        f(InputStream inputStream, String str) {
            this.a = inputStream;
            this.b = str;
        }

        /* renamed from: a */
        public oa1<a> call() {
            return b.i(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    class g implements Callable<oa1<a>> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        g(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* renamed from: a */
        public oa1<a> call() {
            return b.n(this.a, this.b);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class h implements Callable<oa1<a>> {
        final /* synthetic */ a a;

        h(a aVar) {
            this.a = aVar;
        }

        /* renamed from: a */
        public oa1<a> call() {
            return new oa1<>(this.a);
        }
    }

    private static LottieTask<a> b(@Nullable String str, Callable<oa1<a>> callable) {
        a a2 = str == null ? null : la1.b().a(str);
        if (a2 != null) {
            return new LottieTask<>(new h(a2));
        }
        if (str != null) {
            Map<String, LottieTask<a>> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        LottieTask<a> lottieTask = new LottieTask<>(callable);
        if (str != null) {
            lottieTask.f(new a(str));
            lottieTask.e(new C0067b(str));
            a.put(str, lottieTask);
        }
        return lottieTask;
    }

    @Nullable
    private static na1 c(a aVar, String str) {
        for (na1 na1 : aVar.i().values()) {
            if (na1.b().equals(str)) {
                return na1;
            }
        }
        return null;
    }

    public static LottieTask<a> d(Context context, String str) {
        return e(context, str, "asset_" + str);
    }

    public static LottieTask<a> e(Context context, String str, @Nullable String str2) {
        return b(str2, new d(context.getApplicationContext(), str, str2));
    }

    @WorkerThread
    public static oa1<a> f(Context context, String str) {
        return g(context, str, "asset_" + str);
    }

    @WorkerThread
    public static oa1<a> g(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip")) {
                if (!str.endsWith(".lottie")) {
                    return i(context.getAssets().open(str), str2);
                }
            }
            return u(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e2) {
            return new oa1<>(e2);
        }
    }

    public static LottieTask<a> h(InputStream inputStream, @Nullable String str) {
        return b(str, new f(inputStream, str));
    }

    @WorkerThread
    public static oa1<a> i(InputStream inputStream, @Nullable String str) {
        return j(inputStream, str, true);
    }

    @WorkerThread
    private static oa1<a> j(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return k(JsonReader.p(okio.h.d(okio.h.k(inputStream))), str);
        } finally {
            if (z) {
                xt2.c(inputStream);
            }
        }
    }

    @WorkerThread
    public static oa1<a> k(JsonReader jsonReader, @Nullable String str) {
        return l(jsonReader, str, true);
    }

    private static oa1<a> l(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            a a2 = t.a(jsonReader);
            if (str != null) {
                la1.b().c(str, a2);
            }
            oa1<a> oa1 = new oa1<>(a2);
            if (z) {
                xt2.c(jsonReader);
            }
            return oa1;
        } catch (Exception e2) {
            oa1<a> oa12 = new oa1<>(e2);
            if (z) {
                xt2.c(jsonReader);
            }
            return oa12;
        } catch (Throwable th) {
            if (z) {
                xt2.c(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<a> m(String str, @Nullable String str2) {
        return b(str2, new g(str, str2));
    }

    @WorkerThread
    public static oa1<a> n(String str, @Nullable String str2) {
        return k(JsonReader.p(okio.h.d(okio.h.k(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static LottieTask<a> o(Context context, @RawRes int i) {
        return p(context, i, y(context, i));
    }

    public static LottieTask<a> p(Context context, @RawRes int i, @Nullable String str) {
        return b(str, new e(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    @WorkerThread
    public static oa1<a> q(Context context, @RawRes int i) {
        return r(context, i, y(context, i));
    }

    @WorkerThread
    public static oa1<a> r(Context context, @RawRes int i, @Nullable String str) {
        try {
            BufferedSource d2 = okio.h.d(okio.h.k(context.getResources().openRawResource(i)));
            if (x(d2).booleanValue()) {
                return u(new ZipInputStream(d2.inputStream()), str);
            }
            return i(d2.inputStream(), str);
        } catch (Resources.NotFoundException e2) {
            return new oa1<>(e2);
        }
    }

    public static LottieTask<a> s(Context context, String str) {
        return t(context, str, "url_" + str);
    }

    public static LottieTask<a> t(Context context, String str, @Nullable String str2) {
        return b(str2, new c(context, str, str2));
    }

    @WorkerThread
    public static oa1<a> u(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return v(zipInputStream, str);
        } finally {
            xt2.c(zipInputStream);
        }
    }

    @WorkerThread
    private static oa1<a> v(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            a aVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    aVar = l(JsonReader.p(okio.h.d(okio.h.k(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg")) {
                        if (!name.contains(".jpeg")) {
                            zipInputStream.closeEntry();
                        }
                    }
                    String[] split = name.split("/");
                    hashMap.put(split[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (aVar == null) {
                return new oa1<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                na1 c2 = c(aVar, (String) entry.getKey());
                if (c2 != null) {
                    c2.f(xt2.l((Bitmap) entry.getValue(), c2.e(), c2.c()));
                }
            }
            for (Map.Entry<String, na1> entry2 : aVar.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new oa1<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            if (str != null) {
                la1.b().c(str, aVar);
            }
            return new oa1<>(aVar);
        } catch (IOException e2) {
            return new oa1<>(e2);
        }
    }

    private static boolean w(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean x(BufferedSource bufferedSource) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b2 : b) {
                if (peek.readByte() != b2) {
                    return Boolean.FALSE;
                }
            }
            peek.close();
            return Boolean.TRUE;
        } catch (Exception e2) {
            o91.b("Failed to check zip file header", e2);
            return Boolean.FALSE;
        }
    }

    private static String y(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(w(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }
}
