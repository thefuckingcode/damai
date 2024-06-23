package tb;

import android.view.View;
import com.alibaba.pictures.bricks.component.script.ScriptInfoPresent;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
public final /* synthetic */ class e52 implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ GenericItem b;

    public /* synthetic */ e52(String str, GenericItem genericItem) {
        this.a = str;
        this.b = genericItem;
    }

    public final void onClick(View view) {
        ScriptInfoPresent.m139init$lambda4$lambda0(this.a, this.b, view);
    }
}
