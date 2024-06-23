package com.youku.gaiax.js.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.po2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/youku/gaiax/js/utils/GaiaXJSTaskQueue$initTaskQueue$1", "Landroid/os/Handler;", "Landroid/os/Message;", "oldMsg", "Ltb/ur2;", "handleMessage", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GaiaXJSTaskQueue$initTaskQueue$1 extends Handler {
    final /* synthetic */ GaiaXJSTaskQueue this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GaiaXJSTaskQueue$initTaskQueue$1(GaiaXJSTaskQueue gaiaXJSTaskQueue, Looper looper) {
        super(looper);
        this.this$0 = gaiaXJSTaskQueue;
    }

    public void handleMessage(@NotNull Message message) {
        k21.i(message, "oldMsg");
        super.handleMessage(message);
        int i = message.arg2;
        if (i == 0) {
            Object obj = message.obj;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            Function0 function0 = (Function0) po2.e(obj, 0);
            function0.invoke();
            Message message2 = this.this$0.createIntervalMsg(message.what, message.arg1, function0);
            Handler handler = this.this$0.taskQueue;
            if (handler != null) {
                handler.sendMessageDelayed(message2, (long) message.arg1);
            }
        } else if (i == 1) {
            Object obj2 = message.obj;
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
            ((Function0) po2.e(obj2, 0)).invoke();
        }
    }
}
