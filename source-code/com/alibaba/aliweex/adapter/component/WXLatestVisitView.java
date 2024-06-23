package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.view.NearlyAround;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import tb.kh1;

/* compiled from: Taobao */
public class WXLatestVisitView extends WXComponent {
    private NearlyAround mNearlyAround;

    /* compiled from: Taobao */
    class a implements NearlyAround.OnNearlyItemClickListener {
        a(WXLatestVisitView wXLatestVisitView) {
        }

        @Override // com.alibaba.aliweex.adapter.view.NearlyAround.OnNearlyItemClickListener
        public void OnNearlyItemClick(kh1 kh1) {
            if (kh1 != null && kh1.b() != null && WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("openUrl:" + kh1.b());
            }
        }
    }

    public WXLatestVisitView(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public View initComponentHostView(@NonNull Context context) {
        NearlyAround nearlyAround = new NearlyAround(context);
        this.mNearlyAround = nearlyAround;
        nearlyAround.e();
        this.mNearlyAround.d(new a(this));
        return this.mNearlyAround.b();
    }

    @Override // com.taobao.weex.IWXActivityStateListener, com.taobao.weex.ui.component.WXComponent
    public void onActivityResume() {
        super.onActivityResume();
        NearlyAround nearlyAround = this.mNearlyAround;
        if (nearlyAround != null) {
            nearlyAround.e();
        }
    }
}
