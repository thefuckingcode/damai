package tb;

import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.bricks.component.home.HomeProjectItemPresent;

/* compiled from: Taobao */
public final /* synthetic */ class ex0 implements View.OnClickListener {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ HomeProjectItemPresent b;

    public /* synthetic */ ex0(TextView textView, HomeProjectItemPresent homeProjectItemPresent) {
        this.a = textView;
        this.b = homeProjectItemPresent;
    }

    public final void onClick(View view) {
        HomeProjectItemPresent.m102init$lambda3$lambda2(this.a, this.b, view);
    }
}
