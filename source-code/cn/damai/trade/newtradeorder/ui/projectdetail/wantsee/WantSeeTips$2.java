package cn.damai.trade.newtradeorder.ui.projectdetail.wantsee;

import android.widget.PopupWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ny2;

/* compiled from: Taobao */
public class WantSeeTips$2 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ ny2 this$0;
    final /* synthetic */ PopupWindow val$popupWindow;

    WantSeeTips$2(ny2 ny2, PopupWindow popupWindow) {
        this.val$popupWindow = popupWindow;
    }

    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1411883014")) {
            ipChange.ipc$dispatch("-1411883014", new Object[]{this});
            return;
        }
        this.val$popupWindow.dismiss();
    }
}
