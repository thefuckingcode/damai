package tb;

import android.content.Context;
import android.view.View;
import com.alient.gaiax.container.gaiax.GaiaXBuilder;

/* compiled from: Taobao */
public final /* synthetic */ class lr0 implements View.OnLongClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public /* synthetic */ lr0(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    public final boolean onLongClick(View view) {
        return GaiaXBuilder.m177gaiaxModelInfo$lambda4(this.a, this.b, view);
    }
}
