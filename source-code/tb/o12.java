package tb;

import com.alibaba.pictures.bricks.coupon.view.RichTextAdapter;
import com.alibaba.pictures.bricks.coupon.view.RichTextViewHolder;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;

/* compiled from: Taobao */
public final /* synthetic */ class o12 implements IImageFailListener {
    public final /* synthetic */ RichTextAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ RichTextViewHolder c;

    public /* synthetic */ o12(RichTextAdapter richTextAdapter, int i, RichTextViewHolder richTextViewHolder) {
        this.a = richTextAdapter;
        this.b = i;
        this.c = richTextViewHolder;
    }

    @Override // com.alient.oneservice.image.IImageFailListener
    public final void onFail(FailEvent failEvent) {
        RichTextAdapter.h(this.a, this.b, this.c, failEvent);
    }
}
