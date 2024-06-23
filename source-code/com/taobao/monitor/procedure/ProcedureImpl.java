package com.taobao.monitor.procedure;

import android.text.TextUtils;
import com.ali.user.mobile.login.model.LoginConstant;
import com.taobao.monitor.procedure.d;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tb.t91;
import tb.td2;
import tb.te0;
import tb.ts1;
import tb.us1;

/* compiled from: Taobao */
public class ProcedureImpl implements IProcedureGroup, IValueCallback {
    private static volatile long j = System.currentTimeMillis();
    private String a;
    private final String b;
    private final IProcedure c;
    private final f d;
    private Status e = Status.INIT;
    private final List<IProcedure> f;
    private IProcedureLifeCycle g;
    private final boolean h;
    private final Map<String, Long> i;

    /* compiled from: Taobao */
    public interface IProcedureLifeCycle {
        void begin(f fVar);

        void end(f fVar);

        void event(f fVar, te0 te0);

        void stage(f fVar, td2 td2);
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public enum Status {
        INIT,
        RUNNING,
        STOPPED
    }

    ProcedureImpl(String str, IProcedure iProcedure, boolean z, boolean z2) {
        long j2 = j;
        j = 1 + j2;
        String valueOf = String.valueOf(j2);
        this.b = valueOf;
        this.a = str;
        this.c = iProcedure;
        this.h = z;
        this.f = new LinkedList();
        f fVar = new f(str, z, z2);
        this.d = fVar;
        if (iProcedure != null) {
            fVar.d("parentSession", iProcedure.topicSession());
        }
        fVar.d(Preloader.KEY_SESSION, valueOf);
        fVar.e(valueOf);
        this.i = new HashMap();
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBiz(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            this.d.a(str, map);
            t91.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizAbTest(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            this.d.b(str, map);
            t91.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizStage(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            this.d.c(str, map);
            t91.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addProperty(String str, Object obj) {
        if (isAlive()) {
            this.d.d(str, obj);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addPropertyIfAbsent(String str, Object obj) {
        if (isAlive() && !this.d.m().containsKey(str)) {
            this.d.d(str, obj);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addStatistic(String str, Object obj) {
        if (isAlive()) {
            this.d.f(str, obj);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedureGroup
    public void addSubProcedure(IProcedure iProcedure) {
        if (iProcedure != null && isAlive()) {
            synchronized (this.f) {
                this.f.add(iProcedure);
            }
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addSubTask(String str, long j2, long j3) {
        return this;
    }

    public IProcedure b(String str, String str2, Map<String, Object> map, long j2, String str3, boolean z) {
        Long l = this.i.get(str);
        if (l != null && !TextUtils.isEmpty(str) && this.f != null && isAlive()) {
            d f2 = new d.b().g(false).k(false).i(false).h(this).f();
            ts1 ts1 = ts1.b;
            IProcedure createProcedure = ts1.createProcedure("/" + str, f2);
            createProcedure.begin();
            createProcedure.stage("taskStart", l.longValue());
            createProcedure.addProperty("isMainThread", Boolean.valueOf(z));
            createProcedure.addProperty("threadName", str3);
            createProcedure.stage("taskEnd", j2);
            if (!TextUtils.isEmpty(str2)) {
                createProcedure.addProperty("errorType", str2);
            }
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String valueOf = String.valueOf(entry.getKey());
                    if (!TextUtils.isEmpty(valueOf)) {
                        createProcedure.addProperty(valueOf, entry.getValue());
                    }
                }
            }
            createProcedure.end();
            t91.a("ProcedureImpl", "subTaskName", str, LoginConstant.START_TIME, l, "endTime", Long.valueOf(j2), "errorType", str2, "threadName", str3, "isMainThread", Boolean.valueOf(z));
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure begin() {
        if (this.e == Status.INIT) {
            this.e = Status.RUNNING;
            IProcedure iProcedure = this.c;
            if (iProcedure instanceof IProcedureGroup) {
                ((IProcedureGroup) iProcedure).addSubProcedure(this);
            }
            t91.d("ProcedureImpl", this.c, this.a, "begin()");
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.begin(this.d);
            }
        }
        return this;
    }

    public IProcedure c(String str, long j2) {
        if (!TextUtils.isEmpty(str)) {
            this.i.put(str, Long.valueOf(j2));
        }
        t91.a("ProcedureImpl", "name", str, LoginConstant.START_TIME, Long.valueOf(j2));
        return this;
    }

    @Override // com.taobao.monitor.procedure.IValueCallback
    public void callback(f fVar) {
        if (isAlive()) {
            this.d.g(fVar);
        }
    }

    public ProcedureImpl d(IProcedureLifeCycle iProcedureLifeCycle) {
        this.g = iProcedureLifeCycle;
        return this;
    }

    public f e() {
        return this.d;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end() {
        return end(false);
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure event(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            te0 te0 = new te0(str, map);
            this.d.j(te0);
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.event(this.d, te0);
            }
            t91.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public f f() {
        return this.d.t();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.e == Status.RUNNING) {
            t91.f(new RuntimeException("Please call end function first!"));
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public boolean isAlive() {
        return Status.STOPPED != this.e;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskBegin(String str) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskFail(String str, String str2, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskSuccess(String str, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure parent() {
        return this.c;
    }

    @Override // com.taobao.monitor.procedure.IProcedureGroup
    public void removeSubProcedure(IProcedure iProcedure) {
        if (iProcedure != null) {
            synchronized (this.f) {
                this.f.remove(iProcedure);
            }
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stage(String str, long j2) {
        if (str != null && isAlive()) {
            td2 td2 = new td2(str, j2);
            this.d.p(td2);
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.stage(this.d, td2);
            }
            t91.d("ProcedureImpl", this.c, this.a, td2);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stageIfAbsent(String str, long j2) {
        if (str != null && isAlive()) {
            td2 td2 = new td2(str, j2);
            if (this.d.q().contains(td2)) {
                return this;
            }
            this.d.p(td2);
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.stage(this.d, td2);
            }
            t91.d("ProcedureImpl", this.c, this.a, td2);
        }
        return this;
    }

    public String toString() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topic() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topicSession() {
        return this.b;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end(boolean z) {
        if (this.e == Status.RUNNING) {
            synchronized (this.f) {
                for (IProcedure iProcedure : this.f) {
                    if (iProcedure instanceof ProcedureProxy) {
                        IProcedure c2 = ((ProcedureProxy) iProcedure).c();
                        if (c2 instanceof ProcedureImpl) {
                            ProcedureImpl procedureImpl = (ProcedureImpl) c2;
                            if (procedureImpl.isAlive()) {
                                this.d.g(procedureImpl.f());
                            }
                            if (!procedureImpl.h || z) {
                                c2.end(z);
                            }
                        } else {
                            c2.end(z);
                        }
                    } else {
                        iProcedure.end(z);
                    }
                }
            }
            if (this.c instanceof IProcedureGroup) {
                us1.d().b().post(new Runnable() {
                    /* class com.taobao.monitor.procedure.ProcedureImpl.AnonymousClass1 */

                    public void run() {
                        ((IProcedureGroup) ProcedureImpl.this.c).removeSubProcedure(ProcedureImpl.this);
                    }
                });
            }
            IProcedure iProcedure2 = this.c;
            if (iProcedure2 instanceof IValueCallback) {
                ((IValueCallback) iProcedure2).callback(f());
            }
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.end(this.d);
            }
            this.e = Status.STOPPED;
            t91.d("ProcedureImpl", this.c, this.a, "end()");
        }
        return this;
    }
}
