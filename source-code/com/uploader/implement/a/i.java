package com.uploader.implement.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import com.uploader.implement.a.c.a;
import com.uploader.implement.b.a.f;
import com.uploader.implement.b.a.g;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.android.agoo.message.MessageService;
import org.json.JSONException;
import tb.a33;
import tb.e13;
import tb.e23;
import tb.f13;
import tb.f63;
import tb.h13;

/* compiled from: Taobao */
public class i extends a {
    private ArrayList<Pair<Integer, Integer>> e = new ArrayList<>();
    private long f;
    private int g;
    private int h;
    private e i;
    private String j;
    private c k;
    private volatile e23 l;
    private final IUploaderTask m;
    private final ITaskListener n;
    private final Handler o;
    private final int p;
    private final com.uploader.implement.c q;

    /* compiled from: Taobao */
    static final class a implements Handler.Callback {
        static final int c = a.class.hashCode();
        private final WeakReference<com.uploader.implement.d.b> a;
        private final WeakReference<a> b;

        a(a aVar, com.uploader.implement.d.b bVar) {
            this.b = new WeakReference<>(aVar);
            this.a = new WeakReference<>(bVar);
        }

        public boolean handleMessage(Message message) {
            com.uploader.implement.d.b bVar;
            a aVar;
            if (message.what != c || (bVar = this.a.get()) == null || (aVar = this.b.get()) == null) {
                return false;
            }
            aVar.i(bVar, (h13) message.obj);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b implements ITaskResult {
        private Map<String, String> a;
        private String b;
        private String c;

        public b(Map<String, String> map, String str, String str2) {
            this.a = map;
            this.c = str;
            this.b = str2;
        }

        @Override // com.uploader.export.ITaskResult
        public String getBizResult() {
            return this.b;
        }

        @Override // com.uploader.export.ITaskResult
        public String getFileUrl() {
            return this.c;
        }

        @Override // com.uploader.export.ITaskResult
        public Map<String, String> getResult() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    private static final class c implements Runnable {
        final Handler.Callback a;
        private final WeakReference<i> b;
        private final WeakReference<Looper> c = new WeakReference<>(Looper.myLooper());

        c(i iVar, Handler.Callback callback) {
            this.b = new WeakReference<>(iVar);
            this.a = callback;
        }

        public void run() {
            i iVar = this.b.get();
            Looper looper = this.c.get();
            if (looper != null && iVar != null) {
                new Handler(looper, this.a).obtainMessage(a.c, iVar.E()).sendToTarget();
            }
        }
    }

    public i(com.uploader.implement.c cVar, IUploaderTask iUploaderTask, int i2, ITaskListener iTaskListener, Handler handler) {
        super(cVar.c);
        this.q = cVar;
        this.m = iUploaderTask;
        this.n = iTaskListener;
        this.o = handler;
        this.p = i2;
    }

    /* access modifiers changed from: package-private */
    public h13 A(com.uploader.implement.d.b bVar, @Nullable e eVar, boolean z) {
        long j2;
        long j3;
        long j4 = this.f;
        long j5 = this.l.f - this.f;
        if (j5 < 0) {
            j3 = this.l.f;
            j2 = 0;
        } else {
            j3 = j4;
            j2 = j5;
        }
        try {
            a33 a33 = new a33(this.q, this.l, j3 == 0 ? "put" : "patch", j3, j2, true);
            if (eVar == null) {
                bVar.a(a33);
            } else {
                bVar.a(eVar, a33, z);
            }
            f d = a33.a();
            c cVar = new c(false, this.k);
            this.k = cVar;
            cVar.d = this.l.e;
            this.k.p = this.l.d;
            this.k.q = (String) this.q.a.a().first;
            c cVar2 = this.k;
            cVar2.e = d.a;
            cVar2.f = d.b;
            cVar2.k = this.l.f;
            this.k.t = d.f ? 1 : 0;
            if (!com.uploader.implement.a.d(8)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" beginFile, request:");
            sb.append(eVar == null ? "" : Integer.valueOf(eVar.hashCode()));
            sb.append(" newRequest:");
            sb.append(Integer.valueOf(a33.hashCode()));
            sb.append(" statistics:");
            sb.append(this.k.hashCode());
            com.uploader.implement.a.a(8, "UploaderAction", sb.toString());
            return null;
        } catch (UnsupportedEncodingException e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionStartFile", e2);
            }
            return new h13("200", "1", e2.toString(), false);
        } catch (Exception e3) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionStartFile", e3);
            }
            return new h13("200", "5", e3.toString(), false);
        }
    }

    /* access modifiers changed from: package-private */
    public Pair<h13, ? extends Object> B(f13 f13) {
        String b2 = f13.b("x-arup-process");
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "UploaderAction", this.a + " progress :" + b2);
        }
        int i2 = 0;
        try {
            i2 = Integer.parseInt(b2);
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.b(8, "UploaderAction", this.a + "", e2);
            }
        }
        return new Pair<>(null, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public h13 C(com.uploader.implement.d.b bVar, e eVar, h13 h13) {
        if (this.h >= 5) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " retryFile, retry failed, request:" + eVar.hashCode() + " error:" + h13 + " fileRetryCounter:" + this.h);
            }
            return h13;
        }
        if (MessageService.MSG_DB_COMPLETE.equalsIgnoreCase(h13.a)) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " retryFile, try to connect next, request:" + eVar.hashCode());
            }
            this.q.a.h();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " ConnectionStrategy, after nextUploadTarget:" + this.q.a.toString());
            }
        }
        h13 A = A(bVar, eVar, false);
        if (A == null) {
            this.h++;
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " retryFile, request:" + eVar.hashCode() + " fileRetryCounter:" + this.h);
            }
            c cVar = this.k;
            if (cVar != null) {
                cVar.r = this.h;
            }
        }
        return A;
    }

    /* access modifiers changed from: package-private */
    public Pair<h13, ? extends Object> D(f13 f13) {
        try {
            Object[] objArr = f13.c;
            this.q.a.d((String) objArr[0], ((Long) objArr[1]).longValue(), (List) objArr[2], (List) objArr[3]);
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " ConnectionStrategy update:" + this.q.a.toString());
            }
            c cVar = this.k;
            if (cVar != null) {
                cVar.g = 1;
                cVar.q = (String) this.q.a.a().first;
                this.k.m = System.currentTimeMillis();
                this.j = "Declare" + this.k.a();
                if (com.uploader.implement.a.d(8)) {
                    com.uploader.implement.a.a(8, "UploaderAction", this.a + " retrieveDeclare, statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + this.k.m);
                }
            }
            return new Pair<>(null, null);
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(4)) {
                com.uploader.implement.a.a(4, "UploaderAction", e2.toString());
            }
            return new Pair<>(new h13("200", "8", e2.toString(), true), null);
        }
    }

    /* access modifiers changed from: package-private */
    public h13 E() {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<h13, e23> a2 = com.uploader.implement.a.c.b.a(this.m);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Object obj = a2.second;
        if (obj != null) {
            ((e23) obj).i = currentTimeMillis2;
            this.l = (e23) obj;
        }
        if (com.uploader.implement.a.d(8)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" createFileDescription, elapsed:");
            sb.append(currentTimeMillis2);
            sb.append(" error:");
            Object obj2 = a2.first;
            sb.append(obj2 == null ? "" : ((h13) obj2).toString());
            com.uploader.implement.a.a(8, "UploaderAction", sb.toString());
        }
        return (h13) a2.first;
    }

    @NonNull
    public final IUploaderTask F() {
        return this.m;
    }

    public final int G() {
        return this.p;
    }

    @Override // com.uploader.implement.d.a
    public void a(com.uploader.implement.d.b bVar, e eVar, int i2) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onUploading, session:" + bVar.hashCode() + " request:" + eVar.hashCode() + " fileSizeSent:" + i2 + ", sendOffset=" + this.f);
        }
        long j2 = ((long) i2) + eVar.b().c;
        this.f = j2;
        c cVar = this.k;
        if (cVar != null) {
            cVar.b = j2;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public Pair<h13, ? extends Object> b(com.uploader.implement.d.b bVar, e eVar, f13 f13) {
        String b2;
        if (!(this.k == null || (b2 = f13.b("divided_length")) == null)) {
            try {
                this.k.c += (long) Integer.parseInt(b2);
            } catch (Exception e2) {
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "UploaderAction", this.a + e2.toString());
                }
            }
        }
        switch (f13.a()) {
            case 1:
                return D(f13);
            case 2:
                return B(f13);
            case 3:
                return v(bVar, eVar, f13);
            case 4:
                return y(f13);
            case 5:
                return w(f13);
            case 6:
                return u(f13);
            default:
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public h13 c(com.uploader.implement.d.b bVar, e eVar, Pair<Integer, Integer> pair) {
        if (this.i != null) {
            this.e.add(pair);
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionContinue, add offset, session:" + bVar.hashCode());
            }
            return null;
        }
        try {
            a33 a33 = new a33(this.q, this.l, "patch", (long) ((Integer) pair.first).intValue(), (long) ((Integer) pair.second).intValue(), false);
            bVar.a(eVar, a33, true);
            if (!com.uploader.implement.a.d(4)) {
                return null;
            }
            com.uploader.implement.a.a(4, "UploaderAction", this.a + " onActionContinue, session:" + bVar.hashCode() + " send request:" + a33.hashCode());
            return null;
        } catch (UnsupportedEncodingException e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionContinue", e2);
            }
            return new h13("200", "1", e2.toString(), false);
        } catch (Exception e3) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionContinue", e3);
            }
            return new h13("200", "5", e3.toString(), false);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public h13 d(com.uploader.implement.d.b bVar, e eVar, h13 h13) {
        c cVar = this.k;
        if (cVar != null) {
            cVar.m = System.currentTimeMillis();
        }
        if (com.uploader.implement.a.d(8)) {
            com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionRetry, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        if (o() == 2) {
            return C(bVar, eVar, h13);
        }
        return z(bVar, eVar, h13);
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public h13 e(com.uploader.implement.d.b bVar, @Nullable e eVar, boolean z) {
        if (o() == 2) {
            return A(bVar, eVar, z);
        }
        return x(bVar, eVar, z);
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public void f() {
        this.i = null;
        this.e.clear();
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public void g(int i2, Object obj) {
        b.a(this.o, i2, this.m, this.n, obj);
        if (this.k != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionNotify, notifyType:" + i2 + " statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + currentTimeMillis);
            }
            if (i2 == 1) {
                c cVar = this.k;
                cVar.g = 2;
                cVar.m = currentTimeMillis;
                cVar.a();
                this.k = null;
            } else if (i2 == 2) {
                h13 h13 = (h13) obj;
                c cVar2 = this.k;
                cVar2.g = 0;
                cVar2.h = h13.a;
                cVar2.i = h13.b;
                cVar2.j = h13.c;
                cVar2.m = currentTimeMillis;
                cVar2.a();
                this.k = null;
            } else if (i2 == 7) {
                this.k.m = currentTimeMillis;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public boolean l(com.uploader.implement.d.b bVar) {
        boolean z = this.l == null;
        if (z) {
            com.uploader.implement.e.b.a(new c(this, new a(this, bVar)));
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public boolean n() {
        Pair<String, Long> a2 = this.q.a.a();
        if (a2 != null && this.q.a.i() + (System.currentTimeMillis() / 1000) < ((Long) a2.second).longValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Pair<h13, ? extends Object> u(f13 f13) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " retrieveStatus ,response=" + f13);
        }
        String b2 = f13.b("x-arup-session-status");
        if (!TextUtils.isEmpty(b2)) {
            return new Pair<>(null, b2);
        }
        return new Pair<>(null, null);
    }

    /* access modifiers changed from: package-private */
    public Pair<h13, ? extends Object> v(com.uploader.implement.d.b bVar, e eVar, f13 f13) {
        String b2 = f13.b("x-arup-offset");
        if (TextUtils.isEmpty(b2)) {
            return new Pair<>(new h13("200", "7", "onReceiveOffset:1", true), null);
        }
        int indexOf = b2.indexOf("=");
        if (indexOf == -1) {
            return new Pair<>(new h13("200", "7", "onReceiveOffset:2", true), null);
        }
        if (!this.l.d.equals(b2.substring(0, indexOf))) {
            return new Pair<>(new h13("200", "7", "onReceiveOffset:3", true), null);
        }
        int indexOf2 = b2.indexOf(",");
        int i2 = indexOf + 1;
        if (indexOf2 <= i2 || indexOf2 >= b2.length()) {
            return new Pair<>(new h13("200", "7", "onReceiveOffset:4", true), null);
        }
        try {
            return new Pair<>(null, new Pair(Integer.valueOf(Integer.parseInt(b2.substring(i2, indexOf2))), Integer.valueOf(Integer.parseInt(b2.substring(indexOf2 + 1, b2.length())))));
        } catch (Exception e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " parse offset error.", e2);
            }
            return new Pair<>(new h13("200", "7", e2.toString(), true), null);
        }
    }

    /* access modifiers changed from: package-private */
    public Pair<h13, ? extends Object> w(f13 f13) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onReceiveError ,response=" + f13);
        }
        String b2 = f13.b("x-arup-error-code");
        String b3 = f13.b("x-arup-error-msg");
        String b4 = f13.b("x-arup-server-timestamp");
        if (!TextUtils.isEmpty(b4)) {
            try {
                this.q.a.c(Long.parseLong(b4));
            } catch (Exception e2) {
                if (com.uploader.implement.a.d(2)) {
                    com.uploader.implement.a.a(2, "UploaderAction", this.a + " retrieveError " + e2);
                }
                b3 = b3 + " " + e2.toString();
            }
        }
        if (a.AbstractC0247a.C0248a.a.contains(b2)) {
            return new Pair<>(new h13("300", b2, b3, true), null);
        }
        if ("20021".equalsIgnoreCase(b2) || "20022".equalsIgnoreCase(b2) || "20020".equalsIgnoreCase(b2)) {
            return new Pair<>(new h13("300", "2", b3, true), null);
        }
        return new Pair<>(new h13("300", b2, b3, false), null);
    }

    /* access modifiers changed from: package-private */
    public h13 x(com.uploader.implement.d.b bVar, @Nullable e eVar, boolean z) {
        try {
            e13 e13 = new e13(this.q);
            if (eVar == null) {
                bVar.a(e13);
            } else {
                bVar.a(eVar, e13, z);
            }
            g d = e13.a();
            c cVar = new c(true, this.k);
            this.k = cVar;
            cVar.d = this.l.e;
            this.k.p = this.l.d;
            c cVar2 = this.k;
            cVar2.e = d.a;
            cVar2.f = d.b;
            cVar2.k = this.l.f;
            this.k.s = this.l.i;
            if (!com.uploader.implement.a.d(8)) {
                return null;
            }
            com.uploader.implement.a.a(8, "UploaderAction", this.a + " beginDeclare statistics create:" + this.k.hashCode());
            return null;
        } catch (JSONException e2) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionBegin", e2);
            }
            return new h13("200", "1", e2.toString(), false);
        } catch (Exception e3) {
            if (com.uploader.implement.a.d(16)) {
                com.uploader.implement.a.b(16, "UploaderAction", this.a + " onActionBegin", e3);
            }
            return new h13("200", "5", e3.toString(), false);
        }
    }

    /* access modifiers changed from: package-private */
    public Pair<h13, ? extends Object> y(f13 f13) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onReceiveResult ,response=" + f13.c());
        }
        if (!this.l.d.equals(f13.b("x-arup-file-id"))) {
            return new Pair<>(new h13("300", "1", "fileId!=", true), null);
        }
        b bVar = new b(f13.c(), f13.b("x-arup-file-url"), f13.b("x-arup-biz-ret"));
        c cVar = this.k;
        if (cVar != null) {
            cVar.g = 1;
            cVar.m = System.currentTimeMillis();
            this.j += ", File" + this.k.a();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " retrieveResult, statistics:" + this.k.hashCode() + " costTimeMillisEnd:" + this.k.m);
            }
        }
        Map<String, String> result = bVar.getResult();
        if (result != null) {
            result.put("", this.j);
        }
        return new Pair<>(null, bVar);
    }

    /* access modifiers changed from: package-private */
    public h13 z(com.uploader.implement.d.b bVar, e eVar, h13 h13) {
        if (this.g >= 4) {
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " retryDeclare, retry failed, request:" + eVar.hashCode() + " error:" + h13 + " declareRetryCounter:" + this.g);
            }
            return h13;
        }
        if (MessageService.MSG_DB_COMPLETE.equalsIgnoreCase(h13.a) || "400".equalsIgnoreCase(h13.a)) {
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onActionRetry, try to connect next, request:" + eVar.hashCode());
            }
            this.q.a.f();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " ConnectionStrategy, after nextDeclareTarget:" + this.q.a.toString());
            }
        }
        h13 x = x(bVar, eVar, false);
        if (x == null) {
            this.g++;
            if (com.uploader.implement.a.d(2)) {
                com.uploader.implement.a.a(2, "UploaderAction", this.a + " onActionRetry, retry, request:" + eVar.hashCode() + " declareRetryCounter:" + this.g);
            }
            c cVar = this.k;
            if (cVar != null) {
                cVar.r = this.g;
            }
        }
        return x;
    }

    @Override // com.uploader.implement.d.a
    public void e(com.uploader.implement.d.b bVar, e eVar) {
        long j2;
        String str;
        c cVar = this.k;
        if (cVar == null || cVar.l != 0) {
            j2 = 0;
        } else {
            j2 = System.currentTimeMillis();
            this.k.l = j2;
        }
        this.i = eVar;
        if (com.uploader.implement.a.d(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" onSendBegin, session:");
            sb.append(bVar.hashCode());
            sb.append(" request and set current:");
            sb.append(eVar.hashCode());
            if (j2 == 0) {
                str = "";
            } else {
                str = " statistics:" + this.k.hashCode() + " costTimeMillisStart:" + j2;
            }
            sb.append(str);
            com.uploader.implement.a.a(2, "UploaderAction", sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.uploader.implement.a.a
    public Pair<Integer, Integer> a(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(4)) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" onActionDeliver, session:");
            sb.append(bVar.hashCode());
            sb.append(" request:");
            sb.append(eVar.hashCode());
            sb.append(" currentRequest:");
            e eVar2 = this.i;
            sb.append(eVar2 == null ? "null" : Integer.valueOf(eVar2.hashCode()));
            com.uploader.implement.a.a(4, "UploaderAction", sb.toString());
        }
        if (this.k != null) {
            f63 b2 = eVar.b();
            byte[] bArr = b2.f;
            int length = bArr == null ? 0 : bArr.length;
            byte[] bArr2 = b2.g;
            this.k.b = b2.d + ((long) length) + ((long) (bArr2 == null ? 0 : bArr2.length));
        }
        if (this.i != eVar) {
            return null;
        }
        this.i = null;
        if (this.e.size() > 0) {
            return this.e.remove(0);
        }
        return null;
    }

    @Override // com.uploader.implement.d.a
    public void d(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onConnect, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.o = System.currentTimeMillis();
        }
    }

    @Override // com.uploader.implement.d.a
    public void c(com.uploader.implement.d.b bVar, e eVar) {
        if (com.uploader.implement.a.d(2)) {
            com.uploader.implement.a.a(2, "UploaderAction", this.a + " onConnectBegin, session:" + bVar.hashCode() + " request:" + eVar.hashCode());
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.n = System.currentTimeMillis();
            if (com.uploader.implement.a.d(8)) {
                com.uploader.implement.a.a(8, "UploaderAction", this.a + " onConnectBegin statistics:" + this.k.hashCode() + " connectedTimeMillisStart:" + this.k.n);
            }
        }
    }
}
