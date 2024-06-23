package tb;

import android.view.View;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.GenericFragment$initPageStateManager$1$1;
import com.youku.arch.v3.page.state.State;

/* compiled from: Taobao */
public final /* synthetic */ class ds0 implements View.OnClickListener {
    public final /* synthetic */ GenericFragment a;
    public final /* synthetic */ State b;

    public /* synthetic */ ds0(GenericFragment genericFragment, State state) {
        this.a = genericFragment;
        this.b = state;
    }

    public final void onClick(View view) {
        GenericFragment$initPageStateManager$1$1.m888onConfigStateView$lambda0(this.a, this.b, view);
    }
}
