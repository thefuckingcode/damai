package tb;

import android.view.View;
import com.alibaba.pictures.bricks.bean.SearchScriptBean;
import com.alibaba.pictures.bricks.component.script.ScriptView;

/* compiled from: Taobao */
public final /* synthetic */ class l52 implements View.OnClickListener {
    public final /* synthetic */ ScriptView a;
    public final /* synthetic */ SearchScriptBean b;

    public /* synthetic */ l52(ScriptView scriptView, SearchScriptBean searchScriptBean) {
        this.a = scriptView;
        this.b = searchScriptBean;
    }

    public final void onClick(View view) {
        ScriptView.m142bindData$lambda0(this.a, this.b, view);
    }
}
