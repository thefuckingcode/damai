package tb;

import android.view.View;
import com.alibaba.pictures.bricks.coupon.view.RichTextAdapter;
import com.alibaba.pictures.bricks.coupon.view.RichTextViewHolder;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Taobao */
public final /* synthetic */ class n12 implements View.OnClickListener {
    public final /* synthetic */ RichTextViewHolder a;
    public final /* synthetic */ Ref$ObjectRef b;
    public final /* synthetic */ RichTextAdapter c;

    public /* synthetic */ n12(RichTextViewHolder richTextViewHolder, Ref$ObjectRef ref$ObjectRef, RichTextAdapter richTextAdapter) {
        this.a = richTextViewHolder;
        this.b = ref$ObjectRef;
        this.c = richTextAdapter;
    }

    public final void onClick(View view) {
        RichTextAdapter.g(this.a, this.b, this.c, view);
    }
}
