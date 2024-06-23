package com.taobao.aranger.mit;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.update.datasource.mtop.MtopUpdater;
import tb.jz0;
import tb.kz0;

/* compiled from: Taobao */
public class IPCMonitor {
    private static boolean a = true;

    /* compiled from: Taobao */
    public static class IpcState {
        private static boolean i;
        private final int a;
        private String b;
        private String c;
        private int d;
        private int e;
        private long f;
        private long g;
        private long h;

        public IpcState(int i2) {
            this.a = i2;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean k() {
            if (!IPCMonitor.a) {
                return false;
            }
            synchronized (this) {
                if (i) {
                    return true;
                }
                try {
                    DimensionSet create = DimensionSet.create();
                    create.addDimension("type");
                    create.addDimension(MtopUpdater.DEGRADE);
                    create.addDimension("result");
                    create.addDimension("serviceName");
                    create.addDimension("methodName");
                    MeasureSet create2 = MeasureSet.create();
                    create2.addMeasure("costTime");
                    create2.addMeasure("invokeTime");
                    create2.addMeasure("dataSize");
                    AppMonitor.register("ARanger", "ipcState", create2, create, true);
                    i = true;
                } catch (Exception e2) {
                    jz0.c("IPCMonitor", "[register][AppMonitor register]", e2, new Object[0]);
                }
                return i;
            }
        }

        public void j() {
            if (IPCMonitor.a) {
                kz0.b(false, true, new Runnable() {
                    /* class com.taobao.aranger.mit.IPCMonitor.IpcState.AnonymousClass1 */

                    public void run() {
                        if (IpcState.this.k()) {
                            jz0.e("IPCMonitor", "[commit]", "IpcState", IpcState.this.toString());
                            try {
                                DimensionValueSet create = DimensionValueSet.create();
                                create.setValue("type", String.valueOf(IpcState.this.a));
                                create.setValue(MtopUpdater.DEGRADE, String.valueOf(IpcState.this.e));
                                create.setValue("result", String.valueOf(IpcState.this.d));
                                create.setValue("serviceName", IpcState.this.b);
                                create.setValue("methodName", IpcState.this.c);
                                MeasureValueSet create2 = MeasureValueSet.create();
                                create2.setValue("costTime", (double) IpcState.this.f);
                                create2.setValue("invokeTime", (double) IpcState.this.g);
                                create2.setValue("dataSize", (double) IpcState.this.h);
                                AppMonitor.Stat.commit("ARanger", "ipcState", create, create2);
                            } catch (Exception e) {
                                jz0.c("IPCMonitor", "[commit][AppMonitor Stat commit]", e, new Object[0]);
                            }
                        }
                    }
                });
            }
        }

        public void l(long j) {
            this.f = j;
        }

        public void m(long j) {
            this.h = j;
        }

        public void n(boolean z) {
            this.e = z ? 1 : 0;
        }

        public void o(long j) {
            this.g = j;
        }

        public void p(String str) {
            this.c = str;
        }

        public void q(int i2) {
            this.d = i2;
        }

        public void r(String str) {
            this.b = str;
        }

        public String toString() {
            return "IpcState{serviceName='" + this.b + '\'' + ", methodName='" + this.c + '\'' + ", type=" + this.a + ", result=" + this.d + ", degrade=" + this.e + ", costTime=" + this.f + ", invokeTime=" + this.g + ", dataSize=" + this.h + '}';
        }
    }
}
