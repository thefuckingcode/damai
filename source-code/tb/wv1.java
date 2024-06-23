package tb;

import android.view.View;
import android.widget.TextView;
import cn.damai.comment.view.PublishInputTipsAdapter;

/* compiled from: Taobao */
public final /* synthetic */ class wv1 implements View.OnClickListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ PublishInputTipsAdapter c;

    public /* synthetic */ wv1(TextView textView, int i, PublishInputTipsAdapter publishInputTipsAdapter) {
        this.a = textView;
        this.b = i;
        this.c = publishInputTipsAdapter;
    }

    public final void onClick(View view) {
        PublishInputTipsAdapter.a(this.a, this.b, this.c, view);
    }
}
