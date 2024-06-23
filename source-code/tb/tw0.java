package tb;

import android.app.Activity;
import android.content.DialogInterface;
import cn.damai.homepage.ui.view.HomePageGuideBar;

/* compiled from: Taobao */
public final /* synthetic */ class tw0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity a;

    public /* synthetic */ tw0(Activity activity) {
        this.a = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        HomePageGuideBar.b.a(this.a, dialogInterface, i);
    }
}
