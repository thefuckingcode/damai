package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model.Shape;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class l40 extends i32 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.i32
    @NonNull
    public void d(@NonNull int[] iArr, @NonNull Shape shape) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1091290702")) {
            ipChange.ipc$dispatch("-1091290702", new Object[]{this, iArr, shape});
            return;
        }
        e(shape);
    }
}
