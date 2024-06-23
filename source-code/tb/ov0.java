package tb;

import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.pictures.bricks.component.home.grabhotrecommend.HomeCardGrabView;
import com.alibaba.pictures.bricks.view.DMCountDownView;

/* compiled from: Taobao */
public final /* synthetic */ class ov0 implements DMCountDownView.CountDownEndListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ HomeCardGrabView b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ String d;

    public /* synthetic */ ov0(ViewGroup viewGroup, HomeCardGrabView homeCardGrabView, TextView textView, String str) {
        this.a = viewGroup;
        this.b = homeCardGrabView;
        this.c = textView;
        this.d = str;
    }

    @Override // com.alibaba.pictures.bricks.view.DMCountDownView.CountDownEndListener
    public final void onCountDownEnd() {
        HomeCardGrabView.m124onCountDownView$lambda6(this.a, this.b, this.c, this.d);
    }
}
