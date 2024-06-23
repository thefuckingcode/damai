package tb;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.component.home.welfare.HomeWelfareContainerView;

/* compiled from: Taobao */
public final /* synthetic */ class lx0 implements View.OnClickListener {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ String b;
    public final /* synthetic */ HomeWelfareContainerView c;

    public /* synthetic */ lx0(JSONObject jSONObject, String str, HomeWelfareContainerView homeWelfareContainerView) {
        this.a = jSONObject;
        this.b = str;
        this.c = homeWelfareContainerView;
    }

    public final void onClick(View view) {
        HomeWelfareContainerView.m132bindView$lambda10$lambda5$lambda4$lambda2$lambda1(this.a, this.b, this.c, view);
    }
}
