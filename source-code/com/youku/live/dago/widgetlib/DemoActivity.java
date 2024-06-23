package com.youku.live.dago.widgetlib;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.component.DagoUserCardDialog;

/* compiled from: Taobao */
public class DemoActivity extends AppCompatActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private DagoUserCardDialog mDialog;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showUserCardDialog(Context context, String str, JSCallback jSCallback) {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455069978")) {
            ipChange.ipc$dispatch("-1455069978", new Object[]{this, context, str, jSCallback});
            return;
        }
        if (this.mDialog == null) {
            this.mDialog = new DagoUserCardDialog(context, false);
        }
        try {
            j = Long.parseLong(str);
        } catch (Exception unused) {
            j = 0;
        }
        if (j > 0) {
            this.mDialog.setTargetUserId(str);
            this.mDialog.setJSCallback(jSCallback);
            this.mDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469823905")) {
            ipChange.ipc$dispatch("-469823905", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R.layout.demo_activity_layout);
        findViewById(R.id.tv_show_dialog).setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.DemoActivity.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "600528366")) {
                    ipChange.ipc$dispatch("600528366", new Object[]{this, view});
                    return;
                }
                AppContextUtils.init(DemoActivity.this.getApplication());
                DemoActivity demoActivity = DemoActivity.this;
                demoActivity.showUserCardDialog(demoActivity, "331330505", null);
            }
        });
    }
}
