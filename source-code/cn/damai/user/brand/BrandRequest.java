package cn.damai.user.brand;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;

/* compiled from: Taobao */
public class BrandRequest extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange;
    public String brandId;
    public String comboDamaiCityId = d20.c();
    public String funcVersion = "2";
    public boolean needCoupon = true;
    public String pageNum = "1";
    public int pageSize = 15;

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1050736169")) {
            return "brandDetail";
        }
        return (String) ipChange.ipc$dispatch("-1050736169", new Object[]{this});
    }
}
