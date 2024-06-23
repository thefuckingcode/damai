package cn.damai.tetris;

import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.f92;
import tb.py2;
import tb.yz2;

/* compiled from: Taobao */
public abstract class DMMtopWarningListener<T> extends DMMtopRequestListener {
    private static transient /* synthetic */ IpChange $ipChange;
    String args;

    public DMMtopWarningListener(Class cls, String str) {
        super(cls);
        this.args = str;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972653256")) {
            ipChange.ipc$dispatch("-1972653256", new Object[]{this, str, str2});
            return;
        }
        onFailWithWarning(str, str2);
        if ("FAIL_BIZ_PATTERN_EMPTY".equals(str)) {
            py2.d(py2.TETRIS_CORE_ERROR_NOPATTREN_CODE, py2.TETRIS_CORE_ERROR_NOPATTREN_MSG, str, str2, this.args);
        } else {
            yz2.c(yz2.a, py2.BUSINESS_NAME_MONITORPOINT, yz2.i("Tetris", "mtop.damai.mec.aristotle.get", str, str2, this.args), str, str2);
        }
    }

    public abstract void onFailWithWarning(String str, String str2);

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onSuccess(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-636651135")) {
            ipChange.ipc$dispatch("-636651135", new Object[]{this, obj});
            return;
        }
        if (obj != 0 && (obj instanceof BaseResponse)) {
            ((BaseResponse) obj).args = this.args;
        }
        onSuccessWithWarning(obj);
        yz2.e(yz2.a, py2.BUSINESS_NAME_MONITORPOINT, yz2.i("Tetris", "mtop.damai.mec.aristotle.get", "", "", this.args));
        if (obj == 0 || ((obj instanceof BaseResponse) && f92.d(((BaseResponse) obj).layers))) {
            py2.d(py2.TETRIS_CORE_ERROR_NODATA_CODE, py2.TETRIS_CORE_ERROR_NODATA_MSG, "NODATA_NOLAYERS", "接口返回数据为空或楼层为空", this.args);
        }
    }

    public abstract void onSuccessWithWarning(T t);
}
