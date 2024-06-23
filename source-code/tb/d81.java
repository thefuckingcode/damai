package tb;

import android.graphics.drawable.Drawable;
import cn.damai.commonbusiness.share.live.LiveShareImageViewHolder;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
public final /* synthetic */ class d81 implements Function1 {
    public final /* synthetic */ LiveShareImageViewHolder a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ LiveShareImageViewHolder.IFinishCallBack c;

    public /* synthetic */ d81(LiveShareImageViewHolder liveShareImageViewHolder, AtomicInteger atomicInteger, LiveShareImageViewHolder.IFinishCallBack iFinishCallBack) {
        this.a = liveShareImageViewHolder;
        this.b = atomicInteger;
        this.c = iFinishCallBack;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return LiveShareImageViewHolder.d(this.a, this.b, this.c, (Drawable) obj);
    }
}
