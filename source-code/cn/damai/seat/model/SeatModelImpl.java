package cn.damai.seat.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.utils.Cancelable;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.seat.contract.BaseSeatModel;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import java.util.Map;
import tb.dr;
import tb.h72;
import tb.r72;

/* compiled from: Taobao */
public class SeatModelImpl implements BaseSeatModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isReported = false;
    private RequestHolder mHolder = new RequestHolder();
    private h72 mProvider;
    private Map<String, String> pageAlarmExt = new HashMap();

    @Override // cn.damai.seat.contract.BaseSeatModel
    public void addBusiness(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628406885")) {
            ipChange.ipc$dispatch("-1628406885", new Object[]{this, mtopBusiness});
            return;
        }
        this.mHolder.a(mtopBusiness);
    }

    @Override // cn.damai.seat.contract.BaseSeatModel
    public void addCancelable(Cancelable cancelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751850276")) {
            ipChange.ipc$dispatch("-1751850276", new Object[]{this, cancelable});
            return;
        }
        this.mHolder.b(cancelable);
    }

    @Override // cn.damai.seat.contract.BaseSeatModel
    public h72 getIconProvider() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-954203895")) {
            return this.mProvider;
        }
        return (h72) ipChange.ipc$dispatch("-954203895", new Object[]{this});
    }

    public void initPageAlarmExt(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995064431")) {
            ipChange.ipc$dispatch("1995064431", new Object[]{this, tbParams});
            return;
        }
        this.pageAlarmExt.put("firstPayChooseSeat", String.valueOf(tbParams.firstPayChooseSeat));
        this.pageAlarmExt.put("projectId", String.valueOf(tbParams.projectId));
        this.pageAlarmExt.put("itemId", String.valueOf(tbParams.itemId));
        this.pageAlarmExt.put(TicketDetailExtFragment.PERFORM_ID, String.valueOf(tbParams.performId));
    }

    public void newIconProvider(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458808273")) {
            ipChange.ipc$dispatch("-458808273", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mProvider = new h72(i);
    }

    @Override // cn.damai.seat.contract.BaseSeatModel
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1183574179")) {
            ipChange.ipc$dispatch("1183574179", new Object[]{this});
            return;
        }
        this.mHolder.c();
        h72 h72 = this.mProvider;
        if (h72 != null) {
            h72.o();
        }
    }

    public void pageAlarm(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713991031")) {
            ipChange.ipc$dispatch("1713991031", new Object[]{this, str, str2, str3, str4, str5, map});
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.putAll(this.pageAlarmExt);
        dr.INSTANCE.a().a(str).c(str3).d(str4).g(str2).j(str5).e(this.pageAlarmExt).f(false).b();
    }

    public void utExposureDiscountInfo(String str, long j, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285350285")) {
            ipChange.ipc$dispatch("1285350285", new Object[]{this, str, Long.valueOf(j), str2});
        } else if (!this.isReported) {
            this.isReported = true;
            if (!TextUtils.isEmpty(str2)) {
                r72.n().m(str, j, str2);
            }
        }
    }
}
