package cn.damai.seat.helper;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.seatbiz.common.bean.CreateOrderExParams;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.Region;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SeatCalcParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.SubPrice;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcBean;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCalcRes;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.biz.TicketCombineInfo;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.live.LiveActivity;
import cn.damai.seat.bean.BuyParam;
import cn.damai.seat.bean.IPriceManager;
import cn.damai.seat.bean.PriceBarInfo;
import cn.damai.seat.bean.PriceManagerImpl;
import cn.damai.seat.bean.SeatGroup;
import cn.damai.seat.bean.SeatInfoParams;
import cn.damai.seat.bean.biz.OrderAfterChooseSeatInfo;
import cn.damai.seat.bean.biz.Price;
import cn.damai.seat.helper.SeatDataSubmitter;
import cn.damai.seat.helper.SeatPreLocker;
import cn.damai.seat.listener.OnPriceBarListener;
import cn.damai.seat.listener.OnSubmitListener;
import cn.damai.seat.listener.SeatComputeListener;
import cn.damai.seat.listener.net.OnNetBizListener;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.f92;
import tb.g72;
import tb.o72;
import tb.u62;
import tb.wa;
import tb.xf2;
import tb.xs0;

/* compiled from: Taobao */
public class b extends wa {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ALL_REMOVED = 17;
    public static final int NONE_REMOVED = 51;
    public static final int PART_REMOVED = 34;
    private RequestHolder a = new RequestHolder();
    public final long b = System.currentTimeMillis();
    private final List<SeatNew> c = new ArrayList();
    private final List<SeatNew> d = new ArrayList();
    private final ArrayMap<String, ArrayList<SeatGroup>> e = new ArrayMap<>();
    private final TbParams f;
    private int g;
    private IPriceManager h;
    private SeatCalculator i;
    private SeatPreLocker j;
    private Map<Long, List<SeatNew>> k;
    private HashMap<String, Region> l = new HashMap<>();
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;

    /* compiled from: Taobao */
    public class a implements OnNetBizListener<TicketCalcRes> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SeatComputeListener a;

        a(SeatComputeListener seatComputeListener) {
            this.a = seatComputeListener;
        }

        /* renamed from: a */
        public void onNetSuccess(@NonNull TicketCalcRes ticketCalcRes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2105866501")) {
                ipChange.ipc$dispatch("2105866501", new Object[]{this, ticketCalcRes});
                return;
            }
            this.a.doNetWork(false);
            if (ticketCalcRes.isBizSuccess()) {
                b.this.n(ticketCalcRes.model, null, this.a);
            } else {
                b.this.n(null, "价格计算失败", this.a);
            }
        }

        @Override // cn.damai.seat.listener.net.OnNetBizListener
        public void onNetFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834297381")) {
                ipChange.ipc$dispatch("-1834297381", new Object[]{this, str, str2});
                return;
            }
            this.a.doNetWork(false);
            b.this.n(null, "价格计算失败", this.a);
        }
    }

    /* renamed from: cn.damai.seat.helper.b$b  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0040b implements SeatDataSubmitter.OnSubmitSeatDataListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSubmitListener a;

        C0040b(OnSubmitListener onSubmitListener) {
            this.a = onSubmitListener;
        }

        @Override // cn.damai.seat.helper.SeatDataSubmitter.OnSubmitSeatDataListener
        public void onSubmitFailed(String str, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-768502190")) {
                ipChange.ipc$dispatch("-768502190", new Object[]{this, str, str2, str3});
                return;
            }
            u62.g(str, str2, str3, b.this.f.itemId + "", b.this.f.performId + "");
            this.a.doNetWork(false, true);
            this.a.onSubmitFailed(str, str2, str3);
        }

        @Override // cn.damai.seat.helper.SeatDataSubmitter.OnSubmitSeatDataListener
        public void onSubmitSuccess(OrderAfterChooseSeatInfo orderAfterChooseSeatInfo) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1283378567")) {
                ipChange.ipc$dispatch("1283378567", new Object[]{this, orderAfterChooseSeatInfo});
                return;
            }
            this.a.doNetWork(false, true);
            this.a.onSubmitSuccess(b.this.f.orderId, orderAfterChooseSeatInfo);
        }
    }

    /* compiled from: Taobao */
    public class c implements OnNetBizListener<TicketCalcRes> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSubmitListener a;

        c(OnSubmitListener onSubmitListener) {
            this.a = onSubmitListener;
        }

        /* renamed from: a */
        public void onNetSuccess(@NonNull TicketCalcRes ticketCalcRes) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "147291715")) {
                ipChange.ipc$dispatch("147291715", new Object[]{this, ticketCalcRes});
            } else if (ticketCalcRes.isBizSuccess()) {
                if (!b.this.m) {
                    this.a.doNetWork(false, false);
                }
                b.this.n(ticketCalcRes.model, null, this.a);
                b.this.o(ticketCalcRes.model.ticketModuleDetailVOS, this.a);
            } else {
                this.a.doNetWork(false, false);
                b.this.n(null, "价格计算失败", this.a);
                ToastUtil.a().e(xs0.a(), "价格计算失败");
            }
        }

        @Override // cn.damai.seat.listener.net.OnNetBizListener
        public void onNetFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-295957351")) {
                ipChange.ipc$dispatch("-295957351", new Object[]{this, str, str2});
                return;
            }
            this.a.doNetWork(false, false);
            ToastUtil.a().e(xs0.a(), "价格计算失败");
        }
    }

    /* compiled from: Taobao */
    public class d implements SeatPreLocker.OnPreLockResultListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSubmitListener a;
        final /* synthetic */ List b;

        d(OnSubmitListener onSubmitListener, List list) {
            this.a = onSubmitListener;
            this.b = list;
        }

        @Override // cn.damai.seat.helper.SeatPreLocker.OnPreLockResultListener
        public void onOpenNextPage(boolean z, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1010139063")) {
                ipChange.ipc$dispatch("-1010139063", new Object[]{this, Boolean.valueOf(z), str, str2});
                return;
            }
            this.a.doNetWork(false, false);
            this.a.onOpenPurchase(b.this.m(this.b));
        }

        @Override // cn.damai.seat.helper.SeatPreLocker.OnPreLockResultListener
        public void onPreLockFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615588468")) {
                ipChange.ipc$dispatch("1615588468", new Object[]{this});
                return;
            }
            this.a.doNetWork(false, false);
            this.a.seatPreLockFailed();
        }
    }

    public b(TbParams tbParams) {
        this.f = tbParams;
        this.i = new SeatCalculator(tbParams.itemId, tbParams.performId);
        this.j = new SeatPreLocker(tbParams.projectId, tbParams.performId);
    }

    private void B(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "357508026")) {
            ipChange.ipc$dispatch("357508026", new Object[]{this, seatNew, Boolean.valueOf(z)});
        } else if (z) {
            this.d.add(seatNew);
        } else if (seatNew.isPackaged) {
            for (SeatNew seatNew2 : this.d) {
                if (seatNew2.packageCombinedId == seatNew.packageCombinedId) {
                    this.d.remove(seatNew2);
                    return;
                }
            }
        } else {
            this.d.remove(seatNew);
        }
    }

    private void i(SeatGroup seatGroup, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1697346981")) {
            ipChange.ipc$dispatch("1697346981", new Object[]{this, seatGroup, Boolean.valueOf(z)});
            return;
        }
        String str = seatGroup.kanTaiId;
        if (z) {
            ArrayList<SeatGroup> arrayList = this.e.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.e.put(str, arrayList);
            }
            arrayList.add(seatGroup);
        } else {
            ArrayList<SeatGroup> arrayList2 = this.e.get(str);
            if (!f92.d(arrayList2)) {
                arrayList2.remove(seatGroup);
            }
            if (f92.d(arrayList2)) {
                this.e.remove(str);
            }
        }
        if (seatGroup.isPackage) {
            List<SeatNew> list = seatGroup.packageList;
            if (!f92.d(list)) {
                if (z) {
                    this.c.addAll(list);
                } else {
                    this.c.removeAll(list);
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    k(list.get(i2), z);
                }
                return;
            }
            return;
        }
        SeatNew seatNew = seatGroup.single;
        if (z) {
            this.c.add(seatNew);
        } else {
            this.c.remove(seatNew);
        }
        k(seatNew, z);
    }

    private void k(SeatNew seatNew, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8852946")) {
            ipChange.ipc$dispatch("-8852946", new Object[]{this, seatNew, Boolean.valueOf(z)});
            return;
        }
        seatNew.isSelected = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r9v8. Raw type applied. Possible types: java.util.List<cn.damai.seat.bean.BuyParam> */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Bundle m(@Nullable List<TicketCombineInfo> list) {
        List list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299090607")) {
            return (Bundle) ipChange.ipc$dispatch("-299090607", new Object[]{this, list});
        } else if (f92.c(this.e) || f92.d(this.c)) {
            return null;
        } else {
            long j2 = this.f.itemId;
            if (!f92.d(list)) {
                BuyParam.bindItemId(list, j2);
                list2 = list;
            } else {
                list2 = BuyParam.toBuyParamList(j2, this.e, w());
            }
            if (f92.d(list2)) {
                return null;
            }
            String concatBuyParams = BuyParam.concatBuyParams(list2);
            String seatInfoJson = SeatInfoParams.toSeatInfoJson(this.c);
            CreateOrderExParams createOrderExParams = new CreateOrderExParams("damai_app", this.f.atomSplit + "", seatInfoJson);
            Bundle bundle = new Bundle();
            bundle.putString("buyParam", concatBuyParams);
            bundle.putBoolean("buyNow", false);
            bundle.putLong(LiveActivity.OPTION_DAMAI_ITEM_ID, j2);
            bundle.putString(Request.K_EXPARAMS, JSON.toJSONString(createOrderExParams));
            bundle.putBoolean("is_seat", true);
            return bundle;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void n(@Nullable TicketCalcBean ticketCalcBean, @Nullable String str, OnPriceBarListener onPriceBarListener) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "548285868")) {
            ipChange.ipc$dispatch("548285868", new Object[]{this, ticketCalcBean, str, onPriceBarListener});
            return;
        }
        if (r() <= 0) {
            z = false;
        }
        if (ticketCalcBean != null) {
            onPriceBarListener.onPriceBarV2InfoChanged(new PriceBarInfo(ticketCalcBean.realTotalAmtText, ticketCalcBean.reduceTotalAmtDesc, z, ticketCalcBean.usedPromotionList), ticketCalcBean.calculateModuleVOS);
            return;
        }
        onPriceBarListener.onPriceBarV2InfoChanged(new PriceBarInfo(xf2.c(g72.d(this.c)), str, z, null), g72.w(this.c, w().getPid2PriceLineMap()));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(@Nullable List<TicketCombineInfo> list, OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63750200")) {
            ipChange.ipc$dispatch("-63750200", new Object[]{this, list, onSubmitListener});
        } else if (!this.m) {
            onSubmitListener.onOpenPurchase(m(list));
        } else {
            onSubmitListener.doNetWork(true, false);
            this.a.a(this.j.f(this.c, new d(onSubmitListener, list)));
        }
    }

    private int q() {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494898240")) {
            return ((Integer) ipChange.ipc$dispatch("1494898240", new Object[]{this})).intValue();
        } else if (f92.c(this.e)) {
            return 0;
        } else {
            int i3 = 0;
            for (int i4 = 0; i4 < this.e.size(); i4++) {
                ArrayList<SeatGroup> valueAt = this.e.valueAt(i4);
                if (valueAt == null) {
                    i2 = 0;
                } else {
                    i2 = valueAt.size();
                }
                i3 += i2;
            }
            return i3;
        }
    }

    private int r() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1233514816")) {
            return this.c.size();
        }
        return ((Integer) ipChange.ipc$dispatch("1233514816", new Object[]{this})).intValue();
    }

    private int s(long j2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-109429426")) {
            return g72.v(this.c, j2);
        }
        return ((Integer) ipChange.ipc$dispatch("-109429426", new Object[]{this, Long.valueOf(j2)})).intValue();
    }

    private boolean t() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1727913527")) {
            return this.f != null && this.l.size() > 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1727913527", new Object[]{this})).booleanValue();
    }

    private IPriceManager w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1362506482")) {
            return (IPriceManager) ipChange.ipc$dispatch("1362506482", new Object[]{this});
        }
        if (this.h == null) {
            this.h = PriceManagerImpl.emptyManager();
        }
        return this.h;
    }

    public int A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-103947252")) {
            return ((Integer) ipChange.ipc$dispatch("-103947252", new Object[]{this})).intValue();
        }
        List<Long> d2 = this.j.d();
        this.j.c();
        if (!f92.d(d2) && !f92.d(this.c)) {
            for (SeatNew seatNew : this.c) {
                if (d2.contains(Long.valueOf(seatNew.sid))) {
                    seatNew.state = 8;
                }
            }
        }
        if (f92.d(this.c)) {
            return 51;
        }
        ArrayList arrayList = new ArrayList(this.c);
        boolean z = false;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            SeatNew seatNew2 = (SeatNew) arrayList.get(i2);
            if (seatNew2.state != o72.SEAT_STATUS_AVAILABLE.shortValue()) {
                j(seatNew2, false);
                z = true;
            }
        }
        if (!f92.d(this.c)) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                this.c.get(i3).isSelected = true;
            }
        }
        if (f92.d(this.c)) {
            return 17;
        }
        return z ? 34 : 51;
    }

    public void f(List<Region> list, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653096161")) {
            ipChange.ipc$dispatch("-1653096161", new Object[]{this, list, Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        this.g = i2;
        this.l.clear();
        this.m = z;
        if (!f92.d(list)) {
            for (Region region : list) {
                HashMap<String, Region> hashMap = this.l;
                hashMap.put(region.id + "", region);
            }
        }
    }

    public void g(Map<Long, List<SeatNew>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "589070440")) {
            ipChange.ipc$dispatch("589070440", new Object[]{this, map});
            return;
        }
        this.k = map;
    }

    public void h(boolean z, boolean z2, String str, IPriceManager iPriceManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527695335")) {
            ipChange.ipc$dispatch("-527695335", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2), str, iPriceManager});
            return;
        }
        this.n = z;
        this.o = z2;
        this.p = str;
        this.h = iPriceManager;
    }

    public boolean j(SeatNew seatNew, boolean z) {
        SeatGroup seatGroup;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046311608")) {
            return ((Boolean) ipChange.ipc$dispatch("-1046311608", new Object[]{this, seatNew, Boolean.valueOf(z)})).booleanValue();
        } else if (!t() || seatNew == null) {
            return false;
        } else {
            if (z && this.c.contains(seatNew)) {
                return false;
            }
            if (z) {
                if (this.f.firstPayChooseSeat) {
                    Price firstPriceLevel = w().firstPriceLevel();
                    if (firstPriceLevel == null) {
                        return false;
                    }
                    if (firstPriceLevel.isFreeCombineTiaoPiao()) {
                        long j2 = seatNew.priceLevel;
                        SubPrice subPrice = firstPriceLevel.getSubPrice(j2);
                        if (subPrice == null) {
                            return false;
                        }
                        if (r() >= g72.u(firstPriceLevel, this.g)) {
                            ToastUtil.a().e(xs0.a(), "已选完全部座位啦");
                            return false;
                        } else if (s(j2) >= subPrice.count * this.g) {
                            ToastUtil.a().e(xs0.a(), "该档位已选完，请选择其他档位");
                            return false;
                        }
                    } else if (q() >= this.g) {
                        ToastUtil.a().e(xs0.a(), "已选完全部座位啦");
                        return false;
                    }
                } else {
                    int r = r();
                    if (seatNew.isPackaged) {
                        List<SeatNew> l2 = g72.l(this.k, seatNew.packageCombinedId);
                        if (f92.d(l2)) {
                            return false;
                        }
                        i2 = xf2.e(l2);
                    } else {
                        i2 = 1;
                    }
                    if (r + i2 > this.g) {
                        ToastUtil.a().e(xs0.a(), "超出限购数量了哦");
                        return false;
                    }
                }
            }
            if (seatNew.isPackaged) {
                seatGroup = SeatGroup.makePackage(g72.l(this.k, seatNew.packageCombinedId));
            } else {
                seatGroup = SeatGroup.makeSingle(seatNew);
            }
            if (seatGroup == null) {
                return false;
            }
            i(seatGroup, z);
            B(seatNew, z);
            return true;
        }
    }

    public void l(@NonNull SeatComputeListener seatComputeListener) {
        List<SeatCalcParams> list;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-800939223")) {
            ipChange.ipc$dispatch("-800939223", new Object[]{this, seatComputeListener});
        } else if (t()) {
            seatComputeListener.onSeatListChanged(g72.r(this.c, this.l, w().getFullPriceList()));
            if (this.f.firstPayChooseSeat) {
                Price firstPriceLevel = w().firstPriceLevel();
                int i2 = this.g;
                if (firstPriceLevel != null) {
                    if (firstPriceLevel.isFreeCombineTiaoPiao() || firstPriceLevel.isTaoPiao()) {
                        i2 = g72.u(firstPriceLevel, this.g);
                    }
                    seatComputeListener.onPriceBarV2InfoChanged(new PriceBarInfo(i2, r()), null);
                    return;
                }
                return;
            }
            if (r() <= 0 || !this.n) {
                list = null;
            } else {
                list = g72.f(this.e, w().getPid2PriceLineMap());
                z = !f92.d(list);
            }
            if (!z) {
                n(null, null, seatComputeListener);
                return;
            }
            String G = g72.G(this.c);
            seatComputeListener.doNetWork(true);
            this.a.a(this.i.b(G, this.p, list, new a(seatComputeListener)));
        }
    }

    @Nullable
    public String p() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "998899971")) {
            return this.j.e();
        }
        return (String) ipChange.ipc$dispatch("998899971", new Object[]{this});
    }

    public boolean u() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-5047757")) {
            return g72.z(this.c);
        }
        return ((Boolean) ipChange.ipc$dispatch("-5047757", new Object[]{this})).booleanValue();
    }

    public SeatNew v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1289796615")) {
            return (SeatNew) ipChange.ipc$dispatch("-1289796615", new Object[]{this});
        } else if (f92.d(this.d)) {
            return null;
        } else {
            List<SeatNew> list = this.d;
            return list.get(list.size() - 1);
        }
    }

    public void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1154019597")) {
            ipChange.ipc$dispatch("-1154019597", new Object[]{this});
            return;
        }
        this.a.c();
    }

    public int y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387634111")) {
            return ((Integer) ipChange.ipc$dispatch("-387634111", new Object[]{this})).intValue();
        }
        int i2 = 51;
        if (!f92.d(this.c)) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                this.c.get(i3).isSelected = false;
            }
            i2 = 17;
        }
        this.e.clear();
        this.c.clear();
        return i2;
    }

    public void z(OnSubmitListener onSubmitListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "236891821")) {
            ipChange.ipc$dispatch("236891821", new Object[]{this, onSubmitListener});
        } else if (t() && !f92.d(this.c)) {
            if (this.f.firstPayChooseSeat) {
                onSubmitListener.doNetWork(true, true);
                new SeatDataSubmitter(this.f.orderId, this.c).b(new C0040b(onSubmitListener));
                return;
            }
            String G = g72.G(this.c);
            boolean e2 = this.i.e(G);
            if (!e2) {
                this.i.c();
            }
            if ((!this.n || this.o) ? false : !e2) {
                onSubmitListener.doNetWork(true, false);
                this.a.a(this.i.b(G, this.p, g72.f(this.e, w().getPid2PriceLineMap()), new c(onSubmitListener)));
                return;
            }
            List<TicketCombineInfo> list = null;
            if (e2) {
                list = this.i.d();
            }
            o(list, onSubmitListener);
        }
    }
}
