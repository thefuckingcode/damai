package com.alient.gaiax.container.render;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0016"}, d2 = {"com/alient/gaiax/container/render/GenericGaiaxView$renderGaiax$1", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXEventProvider;", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Lcom/alibaba/fastjson/JSONObject;", "data", "", "pos", "Ltb/ur2;", "onGaiaXEvent", "Landroid/view/View;", "itemView", "onItemViewClick", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "targetView", "doViewUpdatedFun", "doViewInjectedFun", "", "type", "", "onMessage", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class GenericGaiaxView$renderGaiax$1 extends PictureGaiaXEventProvider {
    final /* synthetic */ GenericGaiaxView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GenericGaiaxView$renderGaiax$1(GenericGaiaxView genericGaiaxView, Context context) {
        super(context);
        this.this$0 = genericGaiaxView;
        k21.h(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void doViewInjectedFun(@NotNull GaiaX.Params params, @NotNull View view) {
        k21.i(params, "targetParams");
        k21.i(view, "targetView");
        this.this$0.doViewInjected(params, view);
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void doViewUpdatedFun(@NotNull GaiaX.Params params, @NotNull View view) {
        k21.i(params, "targetParams");
        k21.i(view, "targetView");
        this.this$0.doViewUpdated(params, view);
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onGaiaXEvent(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i) {
        k21.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        JSONObject data = eventParams.getData();
        String str = null;
        Object obj = data == null ? null : data.get("eventName");
        if (obj instanceof String) {
            str = (String) obj;
        }
        if (str != null) {
            ((GenericGaiaxPresenter) this.this$0.getPresenter()).processEvent(eventParams.getView(), str, eventParams.getData());
        }
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onItemViewClick(@NotNull View view, @Nullable JSONObject jSONObject, int i) {
        k21.i(view, "itemView");
        ((GenericGaiaxPresenter) this.this$0.getPresenter()).getViewCard().onItemClick(this.this$0.view);
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXEventProvider, com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public boolean onMessage(@NotNull String str, @Nullable JSONObject jSONObject) {
        k21.i(str, "type");
        return this.this$0.onCustomMessage(str, jSONObject);
    }
}
