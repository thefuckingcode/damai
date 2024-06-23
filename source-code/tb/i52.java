package tb;

import android.view.KeyEvent;
import android.widget.TextView;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;

/* compiled from: Taobao */
public final /* synthetic */ class i52 implements TextView.OnEditorActionListener {
    public final /* synthetic */ ScriptSelectFragment a;

    public /* synthetic */ i52(ScriptSelectFragment scriptSelectFragment) {
        this.a = scriptSelectFragment;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return ScriptSelectFragment.m175initView$lambda3(this.a, textView, i, keyEvent);
    }
}
