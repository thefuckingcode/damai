package me.ele.altriax.launcher.real.time.data.bean;

import androidx.annotation.Nullable;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.ProcedureImpl;
import com.taobao.monitor.procedure.ProcedureProxy;
import com.taobao.monitor.procedure.f;
import java.util.List;
import java.util.Map;
import tb.td2;
import tb.te0;

/* compiled from: Taobao */
public class ApmBean {
    @Nullable
    public List<te0> events;
    @Nullable
    public String firstInstall;
    @Nullable
    public String firstLaunch;
    @Nullable
    public String launchType;
    @Nullable
    public Map<String, Object> properties;
    @Nullable
    public List<td2> stages;
    @Nullable
    public Map<String, Object> stats;

    /* compiled from: Taobao */
    public static final class Builder {
        @Nullable
        private final IProcedure iProcedure;

        public Builder(@Nullable IProcedure iProcedure2) {
            this.iProcedure = iProcedure2;
        }

        public ApmBean create() {
            return ApmBean.create(this.iProcedure);
        }
    }

    private ApmBean() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021  */
    @Nullable
    public static ApmBean create(@Nullable IProcedure iProcedure) {
        ProcedureImpl procedureImpl;
        if (iProcedure == null) {
            return null;
        }
        if (iProcedure instanceof ProcedureProxy) {
            IProcedure c = ((ProcedureProxy) iProcedure).c();
            if (c instanceof ProcedureImpl) {
                procedureImpl = (ProcedureImpl) c;
                if (iProcedure instanceof ProcedureImpl) {
                    procedureImpl = (ProcedureImpl) iProcedure;
                }
                if (procedureImpl != null) {
                    return null;
                }
                ApmBean apmBean = new ApmBean();
                f e = procedureImpl.e();
                if (e != null) {
                    List<td2> q = e.q();
                    List<te0> k = e.k();
                    Map<String, Object> r = e.r();
                    Map<String, Object> m = e.m();
                    apmBean.stages = q;
                    apmBean.events = k;
                    apmBean.stats = r;
                    apmBean.properties = m;
                    if (!isEmpty(m)) {
                        Object obj = m.get("launchType");
                        Object obj2 = m.get("isFirstLaunch");
                        Object obj3 = m.get("isFirstInstall");
                        if (obj != null) {
                            apmBean.launchType = String.valueOf(obj);
                        }
                        if (obj2 != null) {
                            apmBean.firstLaunch = String.valueOf(obj2);
                        }
                        if (obj3 != null) {
                            apmBean.firstInstall = String.valueOf(obj3);
                        }
                    }
                }
                return apmBean;
            }
        }
        procedureImpl = null;
        if (iProcedure instanceof ProcedureImpl) {
        }
        if (procedureImpl != null) {
        }
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
