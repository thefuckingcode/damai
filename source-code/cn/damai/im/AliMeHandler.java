package cn.damai.im;

import android.app.Activity;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class AliMeHandler extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1320625706")) {
            ipChange.ipc$dispatch("-1320625706", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        long j = 0;
        if (getIntent() != null) {
            j = getIntent().getLongExtra("projectId", 0);
        }
        AliMeUtil.l(this, AliMeUtil.FROM_ACT, j);
        finish();
    }
}
