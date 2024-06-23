package com.alibaba.android.ultron.vfw.web;

import com.taobao.vessel.VesselView;

/* compiled from: Taobao */
class WebLoadListener$1 implements Runnable {
    final /* synthetic */ b this$0;
    final /* synthetic */ VesselView val$mVesselView;

    WebLoadListener$1(b bVar, VesselView vesselView) {
        this.this$0 = bVar;
        this.val$mVesselView = vesselView;
    }

    public void run() {
        this.val$mVesselView.removeAllViews();
        WebMaskView webMaskView = new WebMaskView(this.val$mVesselView, this.this$0.a);
        this.val$mVesselView.setOnLoadListener(new b(webMaskView, this.this$0.a, this.this$0.b));
        webMaskView.setErrorTextVisible(true);
    }
}
