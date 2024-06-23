package tb;

import android.widget.CompoundButton;
import cn.damai.commonbusiness.yymember.view.MemberDamaiAuthView;

/* compiled from: Taobao */
public final /* synthetic */ class mc1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ MemberDamaiAuthView a;

    public /* synthetic */ mc1(MemberDamaiAuthView memberDamaiAuthView) {
        this.a = memberDamaiAuthView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MemberDamaiAuthView.c(this.a, compoundButton, z);
    }
}
