package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.kl1;

/* compiled from: Taobao */
public class UtExtra<Extra> implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String errorCode;
    public final String errorMsg;
    public final TbParams mParams;
    public final kl1<Extra> option;
    public final boolean success;

    public UtExtra(boolean z, TbParams tbParams, kl1<Extra> kl1, String str, String str2) {
        this.success = z;
        this.mParams = tbParams;
        this.option = kl1;
        this.errorCode = str;
        this.errorMsg = str2;
    }

    public static <Extra> UtExtra<Extra> fail(TbParams tbParams, kl1<Extra> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "680785954")) {
            return new UtExtra<>(false, tbParams, kl1, str, str2);
        }
        return (UtExtra) ipChange.ipc$dispatch("680785954", new Object[]{tbParams, kl1, str, str2});
    }

    public static <Extra> UtExtra<Extra> success(TbParams tbParams, kl1<Extra> kl1) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "178243855")) {
            return new UtExtra<>(true, tbParams, kl1, null, null);
        }
        return (UtExtra) ipChange.ipc$dispatch("178243855", new Object[]{tbParams, kl1});
    }
}
