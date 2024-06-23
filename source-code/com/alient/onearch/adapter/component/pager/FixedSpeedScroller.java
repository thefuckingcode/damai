package com.alient.onearch.adapter.component.pager;

import android.content.Context;
import android.widget.Scroller;
import com.taobao.weex.common.Constants;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/alient/onearch/adapter/component/pager/FixedSpeedScroller;", "Landroid/widget/Scroller;", "", "startX", "startY", "dx", Constants.Name.DISTANCE_Y, "duration", "Ltb/ur2;", "startScroll", "fixedDuration", "I", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;I)V", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class FixedSpeedScroller extends Scroller {
    private int fixedDuration;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FixedSpeedScroller(Context context, int i, int i2, m40 m40) {
        this(context, (i2 & 2) != 0 ? 1000 : i);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.fixedDuration);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedSpeedScroller(@NotNull Context context, int i) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.fixedDuration = i;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.fixedDuration);
    }
}
