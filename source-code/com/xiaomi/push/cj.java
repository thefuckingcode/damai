package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.service.ba;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class cj {
    private static volatile cj a;

    /* renamed from: a  reason: collision with other field name */
    private Context f154a;

    /* renamed from: a  reason: collision with other field name */
    private ci f155a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f156a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, ch> f157a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f158a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* compiled from: Taobao */
    public static abstract class a implements Runnable {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        protected ch f159a = null;

        /* renamed from: a  reason: collision with other field name */
        private a f160a;

        /* renamed from: a  reason: collision with other field name */
        private String f161a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f162a;

        /* renamed from: a  reason: collision with other field name */
        private Random f163a = new Random();
        protected String b;

        public a(String str) {
            this.f161a = str;
        }

        public SQLiteDatabase a() {
            return this.f159a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m325a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m326a() {
            return this.f161a;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            a aVar = this.f160a;
            if (aVar != null) {
                aVar.a(context, m325a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cj.a(context).a(this);
        }

        /* access modifiers changed from: package-private */
        public void a(ch chVar, Context context) {
            this.f159a = chVar;
            this.b = chVar.a();
            this.f162a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f160a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m327a() {
            return this.f159a == null || TextUtils.isEmpty(this.b) || this.f162a == null;
        }

        public void b(Context context) {
        }

        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f162a;
            if (weakReference != null && (context = weakReference.get()) != null && context.getFilesDir() != null && this.f159a != null && !TextUtils.isEmpty(this.f161a)) {
                File file = new File(this.f161a);
                y.a(context, new File(file.getParentFile(), bo.b(file.getAbsolutePath())), new cl(this, context));
            }
        }
    }

    /* compiled from: Taobao */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f164a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f165a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f166a;
        private List<T> b = new ArrayList();
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f165a = list;
            this.f164a = str2;
            this.f166a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cj.a, com.xiaomi.push.cj.a, com.xiaomi.push.cj.a, com.xiaomi.push.cj.a
        public SQLiteDatabase a() {
            return ((a) this).f159a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f165a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f165a.size()];
                this.f165a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.a;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(super.b, strArr, this.f164a, this.f166a, this.c, this.d, this.e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* compiled from: Taobao */
    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cj.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* compiled from: Taobao */
    public static class d extends a {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f167a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f167a = strArr;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f167a);
        }
    }

    /* compiled from: Taobao */
    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.cj.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private cj(Context context) {
        this.f154a = context;
    }

    private ch a(String str) {
        ch chVar = this.f157a.get(str);
        if (chVar == null) {
            synchronized (this.f157a) {
                if (chVar == null) {
                    chVar = this.f155a.a(this.f154a, str);
                    this.f157a.put(str, chVar);
                }
            }
        }
        return chVar;
    }

    public static cj a(Context context) {
        if (a == null) {
            synchronized (cj.class) {
                if (a == null) {
                    a = new cj(context);
                }
            }
        }
        return a;
    }

    private void a() {
        al.a(this.f154a).b(new ck(this), ba.a(this.f154a).a(ho.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m324a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        ch chVar;
        if (aVar != null) {
            if (this.f155a != null) {
                String a2 = aVar.m326a();
                synchronized (this.f157a) {
                    chVar = this.f157a.get(a2);
                    if (chVar == null) {
                        chVar = this.f155a.a(this.f154a, a2);
                        this.f157a.put(a2, chVar);
                    }
                }
                if (!this.f158a.isShutdown()) {
                    aVar.a(chVar, this.f154a);
                    synchronized (this.f156a) {
                        this.f156a.add(aVar);
                        a();
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void a(Runnable runnable) {
        if (!this.f158a.isShutdown()) {
            this.f158a.execute(runnable);
        }
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f155a != null) {
            HashMap hashMap = new HashMap();
            if (!this.f158a.isShutdown()) {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.m327a()) {
                        next.a(a(next.m326a()), this.f154a);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.m326a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.m326a(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        c cVar = new c(str, arrayList3);
                        cVar.a(((a) arrayList3.get(0)).f159a, this.f154a);
                        this.f158a.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    public void b(a aVar) {
        ch chVar;
        if (aVar != null) {
            if (this.f155a != null) {
                String a2 = aVar.m326a();
                synchronized (this.f157a) {
                    chVar = this.f157a.get(a2);
                    if (chVar == null) {
                        chVar = this.f155a.a(this.f154a, a2);
                        this.f157a.put(a2, chVar);
                    }
                }
                if (!this.f158a.isShutdown()) {
                    aVar.a(chVar, this.f154a);
                    a((Runnable) aVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }
}
