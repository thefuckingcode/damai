package tb;

import android.view.View;
import com.alibaba.pictures.bricks.bean.SearchScriptCouponBean;
import com.alibaba.pictures.bricks.component.script.ScriptCouponView;

/* compiled from: Taobao */
public final /* synthetic */ class u42 implements View.OnClickListener {
    public final /* synthetic */ ScriptCouponView a;
    public final /* synthetic */ SearchScriptCouponBean b;

    public /* synthetic */ u42(ScriptCouponView scriptCouponView, SearchScriptCouponBean searchScriptCouponBean) {
        this.a = scriptCouponView;
        this.b = searchScriptCouponBean;
    }

    public final void onClick(View view) {
        ScriptCouponView.m137bindData$lambda0(this.a, this.b, view);
    }
}
