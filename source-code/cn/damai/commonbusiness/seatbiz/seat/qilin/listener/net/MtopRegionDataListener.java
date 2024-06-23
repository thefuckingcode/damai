package cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kf1;
import tb.lz1;
import tb.oz0;
import tb.x72;

/* compiled from: Taobao */
public abstract class MtopRegionDataListener extends DMMtopResultRequestListener<RegionDataNew> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String cityId;
    private boolean isRequest4Preload = false;
    private final long itemId;
    private lz1 mManager;
    private kf1 mMonitor = new kf1(true);
    private final long performId;
    private final long xorPerformId;

    public MtopRegionDataListener(long j, String str, long j2, long j3) {
        super(RegionDataNew.class);
        this.itemId = j;
        this.cityId = str;
        this.performId = j2;
        this.xorPerformId = j3;
    }

    public abstract void onBizFail(String str, String str2);

    @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "509346621")) {
            ipChange.ipc$dispatch("509346621", new Object[]{this, str, str2});
            return;
        }
        kf1.e("mtop.damai.wireless.project.getB2B2CAreaInfo", str, str2);
        if (!oz0.b().c(str)) {
            if (!this.isRequest4Preload || !TextUtils.equals("result为空", str2)) {
                z = false;
            }
            if (!z) {
                if (TextUtils.equals("数据异常，请退出重试!", str2)) {
                    x72.b("mtop.damai.wireless.project.getB2B2CAreaInfo", this.performId + "", this.itemId + "");
                } else {
                    String str3 = "unknown";
                    String str4 = TextUtils.isEmpty(str) ? str3 : str;
                    if (!TextUtils.isEmpty(str2)) {
                        str3 = str2;
                    }
                    x72.c("mtop.damai.wireless.project.getB2B2CAreaInfo", str4, str3, this.performId + "", this.itemId + "");
                }
            }
        }
        if (TextUtils.equals("1000", str) || TextUtils.equals(str2, "数据异常，请退出重试!") || TextUtils.equals(str2, "区域异常，请退出重试!")) {
            str2 = "麦麦开小差了，请稍后重试哦";
        }
        onBizFail(str, str2);
    }

    public abstract void onRegionData(@NonNull RegionData regionData);

    public void setRequest4Preload(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391132848")) {
            ipChange.ipc$dispatch("1391132848", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isRequest4Preload = z;
    }

    public void onSuccess(RegionDataNew regionDataNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "611373695")) {
            ipChange.ipc$dispatch("611373695", new Object[]{this, regionDataNew});
            return;
        }
        this.mMonitor.a("mtop.damai.wireless.project.getB2B2CAreaInfo");
        if (regionDataNew == null) {
            onFail("", "区域异常，请退出重试!");
            return;
        }
        if (this.mManager == null) {
            this.mManager = new lz1();
        }
        regionDataNew.cityId = this.cityId;
        long j = this.xorPerformId;
        regionDataNew.xorPerfromId = j;
        RegionData b = this.mManager.b(regionDataNew, j);
        if (b == null || !b.checkBaseValid()) {
            onFail("", "数据异常，请退出重试!");
            return;
        }
        kf1.f("mtop.damai.wireless.project.getB2B2CAreaInfo");
        onRegionData(b);
    }

    public MtopRegionDataListener(long j, String str, long j2, long j3, @Nullable lz1 lz1) {
        super(RegionDataNew.class);
        this.itemId = j;
        this.cityId = str;
        this.performId = j2;
        this.xorPerformId = j3;
        this.mManager = lz1;
    }
}
