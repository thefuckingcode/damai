package anet.channel.strategy;

import anet.channel.entity.ConnType;
import anet.channel.statist.AmdcResultStat;
import anet.channel.strategy.b;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import tb.gm;
import tb.ju2;
import tb.w6;

/* compiled from: Taobao */
public class StrategyEntity implements Serializable {
    private static final String TAG = "awcn.StrategyEntity";
    private static final long serialVersionUID = 5740869364580937958L;
    private transient AmdcResultStat amdcResultStat = new AmdcResultStat();
    private boolean containsStaticIp = false;
    private transient Comparator<IPConnStrategy> defaultComparator = null;
    private Map<Integer, ConnHistoryItem> historyItemMap = new SerialLruCache(40);
    private List<IPConnStrategy> ipStrategyList = new ArrayList();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements Predicate<IPConnStrategy> {
        final /* synthetic */ b.c a;
        final /* synthetic */ String b;
        final /* synthetic */ ConnProtocol c;

        a(StrategyEntity strategyEntity, b.c cVar, String str, ConnProtocol connProtocol) {
            this.a = cVar;
            this.b = str;
            this.c = connProtocol;
        }

        /* renamed from: a */
        public boolean apply(IPConnStrategy iPConnStrategy) {
            return iPConnStrategy.getPort() == this.a.a && iPConnStrategy.getIp().equals(this.b) && iPConnStrategy.protocol.equals(this.c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements Comparator<IPConnStrategy> {
        b() {
        }

        /* renamed from: a */
        public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
            int i;
            int i2;
            ConnHistoryItem connHistoryItem = (ConnHistoryItem) StrategyEntity.this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            ConnHistoryItem connHistoryItem2 = (ConnHistoryItem) StrategyEntity.this.historyItemMap.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
            if (connHistoryItem == null) {
                connHistoryItem = new ConnHistoryItem();
                StrategyEntity.this.historyItemMap.put(Integer.valueOf(iPConnStrategy.getUniqueId()), connHistoryItem);
            }
            if (connHistoryItem2 == null) {
                connHistoryItem2 = new ConnHistoryItem();
                StrategyEntity.this.historyItemMap.put(Integer.valueOf(iPConnStrategy2.getUniqueId()), connHistoryItem2);
            }
            int countFail = connHistoryItem.countFail();
            int countFail2 = connHistoryItem2.countFail();
            if (countFail != countFail2) {
                return countFail - countFail2;
            }
            if (iPConnStrategy.ipType != iPConnStrategy2.ipType) {
                i = iPConnStrategy.ipType;
                i2 = iPConnStrategy2.ipType;
            } else {
                i = iPConnStrategy.protocol.isHttp;
                i2 = iPConnStrategy2.protocol.isHttp;
            }
            return i - i2;
        }
    }

    public StrategyEntity() {
    }

    private static <T> int find(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i = 0;
        Iterator<T> it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i++;
        }
        if (i == collection.size()) {
            return -1;
        }
        return i;
    }

    private Comparator getDefaultComparator() {
        if (this.defaultComparator == null) {
            this.defaultComparator = new b();
        }
        return this.defaultComparator;
    }

    private void handleUpdate(String str, int i, b.c cVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(cVar);
        int find = find(this.ipStrategyList, new a(this, cVar, str, valueOf));
        if (find != -1) {
            IPConnStrategy iPConnStrategy = this.ipStrategyList.get(find);
            iPConnStrategy.cto = cVar.c;
            iPConnStrategy.rto = cVar.d;
            iPConnStrategy.heartbeat = cVar.f;
            iPConnStrategy.ipType = i;
            iPConnStrategy.ipSource = 0;
            iPConnStrategy.isToRemove = false;
            if (!this.historyItemMap.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.historyItemMap.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
                return;
            }
            return;
        }
        IPConnStrategy create = IPConnStrategy.create(str, cVar);
        if (create != null) {
            create.ipType = i;
            create.ipSource = 0;
            if (!this.historyItemMap.containsKey(Integer.valueOf(create.getUniqueId()))) {
                this.historyItemMap.put(Integer.valueOf(create.getUniqueId()), new ConnHistoryItem());
            }
            this.ipStrategyList.add(create);
        }
        if (ju2.d(str)) {
            this.amdcResultStat.isContainIpv6 = true;
        }
        if (ConnType.HTTP3.equals(valueOf.protocol) || ConnType.HTTP3_PLAIN.equals(valueOf.protocol)) {
            this.amdcResultStat.isContainHttp3 = true;
        }
    }

    public void checkInit() {
        if (this.ipStrategyList == null) {
            this.ipStrategyList = new ArrayList();
        }
        if (this.historyItemMap == null) {
            this.historyItemMap = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.historyItemMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().isExpire()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            if (!this.historyItemMap.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.historyItemMap.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.ipStrategyList, getDefaultComparator());
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, ConnHistoryItem> getHistoryItemMap() {
        return this.historyItemMap;
    }

    /* access modifiers changed from: package-private */
    public List<IPConnStrategy> getIpStrategyList() {
        return this.ipStrategyList;
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.ipStrategyList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            ConnHistoryItem connHistoryItem = this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.shouldBan()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            } else {
                ALog.f(TAG, "strategy ban!", null, "strategy", iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    /* access modifiers changed from: package-private */
    public boolean isContainsStaticIp() {
        return this.containsStaticIp;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, gm gmVar) {
        try {
            if ((iConnStrategy instanceof IPConnStrategy) && this.ipStrategyList.indexOf(iConnStrategy) != -1) {
                IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
                iPConnStrategy.status = gmVar.a ? 1 : 0;
                this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId())).update(gmVar.a);
                Collections.sort(this.ipStrategyList, this.defaultComparator);
            }
        } catch (Exception unused) {
        }
    }

    public boolean shouldRefresh() {
        boolean z = true;
        boolean z2 = true;
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            if (!this.historyItemMap.get(Integer.valueOf(iPConnStrategy.getUniqueId())).latestFail()) {
                if (iPConnStrategy.ipType == 0) {
                    z = false;
                }
                z2 = false;
            }
        }
        if ((!this.containsStaticIp || !z) && !z2) {
            return false;
        }
        return true;
    }

    public String toString() {
        return new ArrayList(this.ipStrategyList).toString();
    }

    public void update(b.d dVar) {
        for (IPConnStrategy iPConnStrategy : this.ipStrategyList) {
            iPConnStrategy.isToRemove = true;
        }
        this.amdcResultStat = new AmdcResultStat();
        int i = 0;
        while (true) {
            b.i[] iVarArr = dVar.k;
            if (i >= iVarArr.length) {
                break;
            }
            boolean z = iVarArr[i].c;
            b.C0004b[] bVarArr = iVarArr[i].a;
            if (!(bVarArr == null || bVarArr.length == 0)) {
                for (int i2 = 0; i2 < bVarArr.length; i2++) {
                    b.c[] cVarArr = bVarArr[i2].b;
                    String[] strArr = bVarArr[i2].a;
                    if (!(cVarArr == null || cVarArr.length == 0 || strArr == null || strArr.length == 0)) {
                        for (int i3 = 0; i3 < cVarArr.length; i3++) {
                            for (String str : strArr) {
                                handleUpdate(str, !z ? 1 : 0, cVarArr[i3]);
                            }
                        }
                    }
                }
                if (z) {
                    this.containsStaticIp = true;
                }
            }
            i++;
        }
        ListIterator<IPConnStrategy> listIterator = this.ipStrategyList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().isToRemove) {
                listIterator.remove();
            }
        }
        try {
            Collections.sort(this.ipStrategyList, getDefaultComparator());
        } catch (Exception e) {
            this.amdcResultStat.code = -100;
            ALog.d(TAG, "strategy sort error!", null, e, new Object[0]);
        }
        AmdcResultStat amdcResultStat2 = this.amdcResultStat;
        amdcResultStat2.host = dVar.a;
        amdcResultStat2.trace = TAG;
        ALog.c(TAG, amdcResultStat2.toString(), null, new Object[0]);
        w6.b().commitStat(this.amdcResultStat);
    }

    StrategyEntity(List<IPConnStrategy> list) {
        this.ipStrategyList = list;
    }

    StrategyEntity(List<IPConnStrategy> list, Map<Integer, ConnHistoryItem> map, boolean z) {
        this.ipStrategyList = list;
        this.historyItemMap = map;
        this.containsStaticIp = z;
    }
}
