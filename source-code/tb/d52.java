package tb;

import android.view.View;
import com.alibaba.pictures.bricks.component.script.ScriptInfoPresent;
import com.youku.arch.v3.core.item.GenericItem;

/* compiled from: Taobao */
public final /* synthetic */ class d52 implements View.OnClickListener {
    public final /* synthetic */ ScriptInfoPresent a;
    public final /* synthetic */ GenericItem b;

    public /* synthetic */ d52(ScriptInfoPresent scriptInfoPresent, GenericItem genericItem) {
        this.a = scriptInfoPresent;
        this.b = genericItem;
    }

    public final void onClick(View view) {
        ScriptInfoPresent.m138init$lambda10(this.a, this.b, view);
    }
}
