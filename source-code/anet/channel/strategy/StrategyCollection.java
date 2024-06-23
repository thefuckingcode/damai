package anet.channel.strategy;

import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.b;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.time.DateUtils;
import tb.a90;
import tb.gm;
import tb.h9;
import tb.jl1;
import tb.w6;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class StrategyCollection implements Serializable {
    private static final long MAX_AVAILABLE_PERIOD = 172800000;
    private static final String TAG = "awcn.StrategyCollection";
    private static final int UPDATE_MODE_DEFAULT = 0;
    private static final int UPDATE_MODE_LAZY = 2;
    private static final int UPDATE_MODE_ONCE = 3;
    private static final int UPDATE_MODE_PRE = 1;
    private static transient boolean isStrategyUpgrade = h9.N();
    private static final long serialVersionUID = 1454976454894208229L;
    Map<String, Boolean> abStrategy;
    volatile String cname = null;
    String host;
    private transient boolean isFirstUsed = true;
    boolean isFixed = false;
    private transient boolean isUpdated = false;
    private transient long lastAmdcRequestSend = 0;
    private StrategyEntity strategyEntity = null;
    private StrategyList strategyList = null;
    volatile long ttl = 0;
    int updateMode = 0;
    int version = 0;

    public StrategyCollection() {
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.ttl > MAX_AVAILABLE_PERIOD) {
            this.strategyList = null;
            this.strategyEntity = null;
            return;
        }
        if (isStrategyUpgrade) {
            StrategyEntity strategyEntity2 = this.strategyEntity;
            if (strategyEntity2 != null) {
                strategyEntity2.checkInit();
            }
        } else {
            StrategyList strategyList2 = this.strategyList;
            if (strategyList2 != null) {
                strategyList2.checkInit();
            }
        }
    }

    public synchronized boolean getAbStrategyStatus(String str) {
        Map<String, Boolean> map = this.abStrategy;
        boolean z = false;
        if (map == null) {
            return false;
        }
        Boolean bool = map.get(str);
        if (bool != null) {
            z = bool.booleanValue();
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isAllowUpdate(boolean z) {
        if (!AmdcRuntimeInfo.e()) {
            return true;
        }
        int i = this.updateMode;
        if (!(i == 0 || i == 1)) {
            if (i != 2) {
                if (i == 3) {
                    z = !this.isUpdated;
                }
            }
            ALog.f(TAG, "[isAllowUpdate]", null, "host", this.host, "updateMode", Integer.valueOf(i), "status", Boolean.valueOf(z));
            return z;
        }
        z = true;
        ALog.f(TAG, "[isAllowUpdate]", null, "host", this.host, "updateMode", Integer.valueOf(i), "status", Boolean.valueOf(z));
        return z;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.ttl;
    }

    /* access modifiers changed from: package-private */
    public boolean isSupportUpdateMode(int i) {
        return i == 1 || i == 2 || i == 3;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, gm gmVar) {
        if (isStrategyUpgrade) {
            StrategyEntity strategyEntity2 = this.strategyEntity;
            if (strategyEntity2 != null) {
                strategyEntity2.notifyConnEvent(iConnStrategy, gmVar);
                if (!gmVar.a && this.strategyEntity.shouldRefresh()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.lastAmdcRequestSend > DateUtils.MILLIS_PER_MINUTE) {
                        a.a().forceRefreshStrategy(this.host);
                        this.lastAmdcRequestSend = currentTimeMillis;
                    }
                }
            }
        } else {
            StrategyList strategyList2 = this.strategyList;
            if (strategyList2 != null) {
                strategyList2.notifyConnEvent(iConnStrategy, gmVar);
                if (!gmVar.a && this.strategyList.shouldRefresh()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - this.lastAmdcRequestSend > DateUtils.MILLIS_PER_MINUTE) {
                        a.a().forceRefreshStrategy(this.host);
                        this.lastAmdcRequestSend = currentTimeMillis2;
                    }
                }
            }
        }
    }

    public boolean parseStrategyData() {
        StrategyEntity strategyEntity2;
        StrategyList strategyList2;
        boolean z = isStrategyUpgrade;
        if (z && this.strategyEntity == null && (strategyList2 = this.strategyList) != null) {
            this.strategyEntity = parseToStrategyEntity(strategyList2);
            this.strategyList = null;
            ALog.e(TAG, "parseStrategyData to strategyEntity success.", null, new Object[0]);
            return true;
        } else if (z || (strategyEntity2 = this.strategyEntity) == null || this.strategyList != null) {
            return false;
        } else {
            this.strategyList = parseToStrategyList(strategyEntity2);
            this.strategyEntity = null;
            ALog.e(TAG, "parseStrategyData to strategyList success.", null, new Object[0]);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public StrategyEntity parseToStrategyEntity(StrategyList strategyList2) {
        try {
            return new StrategyEntity(strategyList2.getIpStrategyList(), strategyList2.getHistoryItemMap(), strategyList2.isContainsStaticIp());
        } catch (Exception e) {
            ALog.d(TAG, "parseToStrategyEntity error!", null, e, new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public StrategyList parseToStrategyList(StrategyEntity strategyEntity2) {
        try {
            return new StrategyList(strategyEntity2.getIpStrategyList(), strategyEntity2.getHistoryItemMap(), strategyEntity2.isContainsStaticIp());
        } catch (Exception e) {
            ALog.d(TAG, "parseToStrategyList error!", null, e, new Object[0]);
            return null;
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (isStrategyUpgrade) {
            if (this.strategyEntity == null) {
                return Collections.EMPTY_LIST;
            }
        } else if (this.strategyList == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.isFirstUsed) {
            this.isFirstUsed = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.host, this.version);
            policyVersionStat.reportType = 0;
            w6.b().commitStat(policyVersionStat);
        }
        return isStrategyUpgrade ? this.strategyEntity.getStrategyList() : this.strategyList.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyCollection = ");
        sb.append(this.ttl);
        if (this.strategyList != null) {
            sb.append("\nStrategyList = ");
            sb.append(this.strategyList.toString());
        } else if (this.strategyEntity != null) {
            sb.append("\nstrategyEntity = ");
            sb.append(this.strategyEntity.toString());
        } else if (this.cname != null) {
            sb.append(jl1.ARRAY_START);
            sb.append(this.host);
            sb.append("=>");
            sb.append(this.cname);
            sb.append(jl1.ARRAY_END);
        } else {
            sb.append("[]");
        }
        return sb.toString();
    }

    public synchronized void update(b.e eVar) {
        b.j[] jVarArr;
        b.a[] aVarArr;
        this.ttl = System.currentTimeMillis() + (((long) eVar.b) * 1000);
        if (!eVar.a.equalsIgnoreCase(this.host)) {
            ALog.e(TAG, "update error!", null, "host", this.host, "dnsInfo.host", eVar.a);
            return;
        }
        int i = this.version;
        int i2 = eVar.l;
        if (i != i2) {
            this.version = i2;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.host, i2);
            policyVersionStat.reportType = 1;
            w6.b().commitStat(policyVersionStat);
        }
        this.cname = eVar.d;
        HashMap<String, Boolean> hashMap = eVar.n;
        if (hashMap != null && hashMap.size() > 0) {
            if (this.abStrategy == null) {
                this.abStrategy = new ConcurrentHashMap();
            }
            this.abStrategy.putAll(eVar.n);
        }
        if (isSupportUpdateMode(eVar.o)) {
            this.updateMode = eVar.o;
        }
        this.isUpdated = true;
        String[] strArr = eVar.f;
        if ((strArr == null || strArr.length == 0 || (aVarArr = eVar.h) == null || aVarArr.length == 0) && ((jVarArr = eVar.i) == null || jVarArr.length == 0)) {
            this.strategyList = null;
            return;
        }
        if (this.strategyList == null) {
            this.strategyList = new StrategyList();
        }
        this.strategyList.update(eVar);
    }

    public synchronized void updateStrategy(b.d dVar) {
        this.ttl = System.currentTimeMillis() + (((long) dVar.b) * 1000);
        if (!dVar.a.equalsIgnoreCase(this.host)) {
            ALog.e(TAG, "update error!", null, "host", this.host, "dnsInfo.host", dVar.a);
            return;
        }
        int i = this.version;
        int i2 = dVar.h;
        if (i != i2) {
            this.version = i2;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.host, i2);
            policyVersionStat.reportType = 1;
            w6.b().commitStat(policyVersionStat);
        }
        this.cname = dVar.d;
        HashMap<String, Boolean> hashMap = dVar.j;
        if (hashMap != null && hashMap.size() > 0) {
            if (this.abStrategy == null) {
                this.abStrategy = new ConcurrentHashMap();
            }
            this.abStrategy.putAll(dVar.j);
        }
        if (isSupportUpdateMode(dVar.l)) {
            this.updateMode = dVar.l;
        }
        this.isUpdated = true;
        b.i[] iVarArr = dVar.k;
        if (iVarArr == null || iVarArr.length == 0) {
            this.strategyEntity = null;
            return;
        }
        if (this.strategyEntity == null) {
            this.strategyEntity = new StrategyEntity();
        }
        this.strategyEntity.update(dVar);
    }

    protected StrategyCollection(String str) {
        this.host = str;
        this.isFixed = a90.d(str);
    }
}
