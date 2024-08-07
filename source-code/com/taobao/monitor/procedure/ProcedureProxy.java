package com.taobao.monitor.procedure;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ali.user.mobile.login.model.LoginConstant;
import com.taobao.monitor.common.BundleMap;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;
import java.util.Map;
import tb.i20;
import tb.ss1;
import tb.us1;

/* compiled from: Taobao */
public class ProcedureProxy implements IProcedureGroup, IValueCallback {
    public static final int ADD_BIZ = 4;
    public static final int ADD_BIZ_AB_TEST = 5;
    public static final int ADD_BIZ_STAGE = 6;
    public static final int ADD_SUB_TASK = 9;
    public static final int BEGIN = 0;
    public static final int END = 10;
    public static final int EVENT = 1;
    public static final int STAGE = 2;
    private final ProcedureImpl a;
    private final Handler b;

    /* compiled from: Taobao */
    private static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((ProcedureImpl) message.obj).begin();
                        return;
                    case 1:
                        Bundle data = message.getData();
                        ((ProcedureImpl) message.obj).event(data.getString("name"), ((BundleMap) data.getSerializable("events")).getData());
                        return;
                    case 2:
                        Bundle data2 = message.getData();
                        ((ProcedureImpl) message.obj).stage(data2.getString("name"), data2.getLong("timestamp"));
                        return;
                    case 3:
                    case 7:
                    case 8:
                    default:
                        return;
                    case 4:
                        Bundle data3 = message.getData();
                        ((ProcedureImpl) message.obj).addBiz(data3.getString("bizID"), ((BundleMap) data3.getSerializable("properties")).getData());
                        return;
                    case 5:
                        Bundle data4 = message.getData();
                        ((ProcedureImpl) message.obj).addBizAbTest(data4.getString("bizID"), ((BundleMap) data4.getSerializable("abTest")).getData());
                        return;
                    case 6:
                        Bundle data5 = message.getData();
                        ((ProcedureImpl) message.obj).addBizStage(data5.getString("bizID"), ((BundleMap) data5.getSerializable(TLogEventConst.PARAM_UPLOAD_STAGE)).getData());
                        return;
                    case 9:
                        ProcedureImpl procedureImpl = (ProcedureImpl) message.obj;
                        Bundle data6 = message.getData();
                        procedureImpl.c(data6.getString("name"), data6.getLong(LoginConstant.START_TIME));
                        procedureImpl.b(data6.getString("name"), null, null, data6.getLong("endTime"), data6.getString("threadName"), data6.getBoolean("isMainThread"));
                        return;
                    case 10:
                        ((ProcedureImpl) message.obj).end();
                        return;
                    case 11:
                        ((ProcedureImpl) message.obj).end(message.getData().getBoolean("force"));
                        return;
                    case 12:
                        Bundle data7 = message.getData();
                        ((ProcedureImpl) message.obj).stageIfAbsent(data7.getString("name"), data7.getLong("timestamp"));
                        return;
                }
            } catch (Exception e) {
                i20.a("ProcedureProxy", e);
            }
        }
    }

    public ProcedureProxy(ProcedureImpl procedureImpl) {
        if (procedureImpl != null) {
            this.b = new a(us1.d().c().getLooper());
            this.a = procedureImpl;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void b(Runnable runnable) {
        us1.d().b().post(runnable);
    }

    private Map<String, Object> d(Map<String, Object> map) {
        if (!ss1.a) {
            return map;
        }
        if (map == null) {
            return null;
        }
        try {
            return new HashMap(map);
        } catch (Exception unused) {
            return new HashMap();
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBiz(String str, Map<String, Object> map) {
        Map<String, Object> d = d(map);
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("bizID", str);
        bundle.putSerializable("properties", new BundleMap(d));
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizAbTest(String str, Map<String, Object> map) {
        Map<String, Object> d = d(map);
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("bizID", str);
        bundle.putSerializable("abTest", new BundleMap(d));
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizStage(String str, Map<String, Object> map) {
        Map<String, Object> d = d(map);
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("bizID", str);
        bundle.putSerializable(TLogEventConst.PARAM_UPLOAD_STAGE, new BundleMap(d));
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addProperty(final String str, final Object obj) {
        b(new Runnable() {
            /* class com.taobao.monitor.procedure.ProcedureProxy.AnonymousClass1 */

            public void run() {
                ProcedureProxy.this.a.addProperty(str, obj);
            }
        });
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addPropertyIfAbsent(final String str, final Object obj) {
        b(new Runnable() {
            /* class com.taobao.monitor.procedure.ProcedureProxy.AnonymousClass2 */

            public void run() {
                ProcedureProxy.this.a.addPropertyIfAbsent(str, obj);
            }
        });
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addStatistic(final String str, final Object obj) {
        b(new Runnable() {
            /* class com.taobao.monitor.procedure.ProcedureProxy.AnonymousClass3 */

            public void run() {
                ProcedureProxy.this.a.addStatistic(str, obj);
            }
        });
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedureGroup
    public void addSubProcedure(IProcedure iProcedure) {
        this.a.addSubProcedure(iProcedure);
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addSubTask(String str, long j, long j2) {
        String name = Thread.currentThread().getName();
        boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
        Message obtain = Message.obtain();
        obtain.what = 9;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putLong(LoginConstant.START_TIME, j);
        bundle.putLong("endTime", j2);
        bundle.putString("threadName", name);
        bundle.putBoolean("isMainThread", z);
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure begin() {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = this.a;
        this.b.sendMessage(obtain);
        return this;
    }

    public IProcedure c() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IValueCallback
    public void callback(f fVar) {
        this.a.callback(fVar);
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end() {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = this.a;
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure event(String str, Map<String, Object> map) {
        Map<String, Object> d = d(map);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putSerializable("events", new BundleMap(d));
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public boolean isAlive() {
        return this.a.isAlive();
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskBegin(final String str) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        b(new Runnable() {
            /* class com.taobao.monitor.procedure.ProcedureProxy.AnonymousClass4 */

            public void run() {
                ProcedureProxy.this.a.c(str, uptimeMillis);
            }
        });
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskFail(final String str, final String str2, final Map<String, Object> map) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        final String name = Thread.currentThread().getName();
        final boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
        b(new Runnable() {
            /* class com.taobao.monitor.procedure.ProcedureProxy.AnonymousClass6 */

            public void run() {
                ProcedureProxy.this.a.b(str, TextUtils.isEmpty(str2) ? "UNKNOWN" : str2, map, uptimeMillis, name, z);
            }
        });
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskSuccess(final String str, final Map<String, Object> map) {
        final long uptimeMillis = SystemClock.uptimeMillis();
        final String name = Thread.currentThread().getName();
        final boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
        b(new Runnable() {
            /* class com.taobao.monitor.procedure.ProcedureProxy.AnonymousClass5 */

            public void run() {
                ProcedureProxy.this.a.b(str, null, map, uptimeMillis, name, z);
            }
        });
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure parent() {
        return this.a.parent();
    }

    @Override // com.taobao.monitor.procedure.IProcedureGroup
    public void removeSubProcedure(IProcedure iProcedure) {
        this.a.removeSubProcedure(iProcedure);
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stage(String str, long j) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putLong("timestamp", j);
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stageIfAbsent(String str, long j) {
        Message obtain = Message.obtain();
        obtain.what = 12;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putString("name", str);
        bundle.putLong("timestamp", j);
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topic() {
        return this.a.topic();
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topicSession() {
        return this.a.topicSession();
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end(boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = this.a;
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", z);
        obtain.setData(bundle);
        this.b.sendMessage(obtain);
        return this;
    }
}
