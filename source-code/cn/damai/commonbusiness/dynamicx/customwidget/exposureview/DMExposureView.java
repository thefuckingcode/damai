package cn.damai.commonbusiness.dynamicx.customwidget.exposureview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import tb.pc0;

/* compiled from: Taobao */
public class DMExposureView extends DXNativeFrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMExposureView(@NonNull Context context) {
        super(context);
    }

    public void updateSPM(String str, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005009795")) {
            ipChange.ipc$dispatch("-2005009795", new Object[]{this, str, jSONArray, jSONArray2, jSONArray3});
            return;
        }
        pc0.c(this, jSONArray, jSONArray2, jSONArray3);
    }

    public DMExposureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DMExposureView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
