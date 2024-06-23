package tb;

import android.view.View;
import com.youku.gaiax.impl.register.GXMixNodeEvent;

/* compiled from: Taobao */
public final /* synthetic */ class qp0 implements View.OnLongClickListener {
    public final /* synthetic */ GXMixNodeEvent a;

    public /* synthetic */ qp0(GXMixNodeEvent gXMixNodeEvent) {
        this.a = gXMixNodeEvent;
    }

    public final boolean onLongClick(View view) {
        return GXMixNodeEvent.m895initViewLongClickEventDispatcher$lambda4(this.a, view);
    }
}
