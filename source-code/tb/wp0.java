package tb;

import android.view.View;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
public final /* synthetic */ class wp0 implements View.OnLongClickListener {
    public final /* synthetic */ wq0 a;
    public final /* synthetic */ up0 b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Object e;

    public /* synthetic */ wp0(wq0 wq0, up0 up0, JSONObject jSONObject, String str, Object obj) {
        this.a = wq0;
        this.b = up0;
        this.c = jSONObject;
        this.d = str;
        this.e = obj;
    }

    public final boolean onLongClick(View view) {
        return xp0.d(this.a, this.b, this.c, this.d, this.e, view);
    }
}
