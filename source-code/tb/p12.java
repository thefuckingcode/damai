package tb;

import com.alibaba.pictures.bricks.coupon.view.RichTextAdapter;
import com.alibaba.pictures.bricks.coupon.view.RichTextViewHolder;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.SuccessEvent;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Taobao */
public final /* synthetic */ class p12 implements IImageSuccListener {
    public final /* synthetic */ RichTextViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ RichTextAdapter c;
    public final /* synthetic */ Ref$ObjectRef d;

    public /* synthetic */ p12(RichTextViewHolder richTextViewHolder, int i, RichTextAdapter richTextAdapter, Ref$ObjectRef ref$ObjectRef) {
        this.a = richTextViewHolder;
        this.b = i;
        this.c = richTextAdapter;
        this.d = ref$ObjectRef;
    }

    @Override // com.alient.oneservice.image.IImageSuccListener
    public final void onSuccess(SuccessEvent successEvent) {
        RichTextAdapter.f(this.a, this.b, this.c, this.d, successEvent);
    }
}
