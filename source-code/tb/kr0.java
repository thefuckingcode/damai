package tb;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;
import com.alient.gaiax.container.gaiax.PictureGaiaXDelegate;

/* compiled from: Taobao */
public final /* synthetic */ class kr0 implements View.OnClickListener {
    public final /* synthetic */ PictureGaiaXDelegate a;
    public final /* synthetic */ View b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ int d;

    public /* synthetic */ kr0(PictureGaiaXDelegate pictureGaiaXDelegate, View view, JSONObject jSONObject, int i) {
        this.a = pictureGaiaXDelegate;
        this.b = view;
        this.c = jSONObject;
        this.d = i;
    }

    public final void onClick(View view) {
        GaiaXBuilder.m178renderGaiaX$lambda1$lambda0(this.a, this.b, this.c, this.d, view);
    }
}
