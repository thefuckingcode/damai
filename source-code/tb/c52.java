package tb;

import android.view.View;
import com.alibaba.pictures.bricks.component.script.ScriptInfoHeaderBean;
import com.alibaba.pictures.bricks.component.script.ScriptInfoPresent;

/* compiled from: Taobao */
public final /* synthetic */ class c52 implements View.OnClickListener {
    public final /* synthetic */ ScriptInfoPresent a;
    public final /* synthetic */ ScriptInfoHeaderBean b;

    public /* synthetic */ c52(ScriptInfoPresent scriptInfoPresent, ScriptInfoHeaderBean scriptInfoHeaderBean) {
        this.a = scriptInfoPresent;
        this.b = scriptInfoHeaderBean;
    }

    public final void onClick(View view) {
        ScriptInfoPresent.m140updateTopPlayLayout$lambda16(this.a, this.b, view);
    }
}
