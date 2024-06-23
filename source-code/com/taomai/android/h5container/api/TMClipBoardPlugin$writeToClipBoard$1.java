package com.taomai.android.h5container.api;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
final class TMClipBoardPlugin$writeToClipBoard$1 implements Runnable {
    final /* synthetic */ WVCallBackContext $callback;
    final /* synthetic */ JSONObject $jsonParam;
    final /* synthetic */ TMClipBoardPlugin this$0;

    TMClipBoardPlugin$writeToClipBoard$1(TMClipBoardPlugin tMClipBoardPlugin, JSONObject jSONObject, WVCallBackContext wVCallBackContext) {
        this.this$0 = tMClipBoardPlugin;
        this.$jsonParam = jSONObject;
        this.$callback = wVCallBackContext;
    }

    public final void run() {
        Context access$getMContext$p = TMClipBoardPlugin.access$getMContext$p(this.this$0);
        String str = null;
        Object systemService = access$getMContext$p != null ? access$getMContext$p.getSystemService("clipboard") : null;
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (clipboardManager != null) {
            JSONObject jSONObject = this.$jsonParam;
            if (jSONObject != null) {
                str = jSONObject.getString("text");
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("taomai", str));
            WVCallBackContext wVCallBackContext = this.$callback;
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
            }
        }
    }
}
