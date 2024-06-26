package tb;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$string;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.navigation.NavigatorManager;
import com.ali.user.mobile.rpc.login.model.LoginReturnData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class rp extends ClickableSpan {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYEP_SERVICE_TERMS = 0;
    public static final int TYEP_SPECIAL_BOOK_SERVICE_TERMS = 2;
    public static final int TYEP_SPECIAL_SERVICE_TERMS = 1;
    Activity a;
    int b;

    public rp(Activity activity, int i) {
        this.a = activity;
        this.b = i;
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1571056695")) {
            ipChange.ipc$dispatch("1571056695", new Object[]{this, view});
            return;
        }
        int i = this.b;
        if (i == 0) {
            NavigatorManager instance = NavigatorManager.getInstance();
            Activity activity = this.a;
            instance.navToWebViewPage(activity, activity.getString(R$string.aliuser_damai_protocol_url_new), (LoginParam) null, (LoginReturnData) null);
        } else if (i == 1) {
            NavigatorManager instance2 = NavigatorManager.getInstance();
            Activity activity2 = this.a;
            instance2.navToWebViewPage(activity2, activity2.getString(R$string.aliuser_damai_policy_protocol_url_new), (LoginParam) null, (LoginReturnData) null);
        } else if (i == 2) {
            NavigatorManager instance3 = NavigatorManager.getInstance();
            Activity activity3 = this.a;
            instance3.navToWebViewPage(activity3, activity3.getString(R$string.aliuser_damai_book_policy_protocol_url), (LoginParam) null, (LoginReturnData) null);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202215136")) {
            ipChange.ipc$dispatch("202215136", new Object[]{this, textPaint});
            return;
        }
        super.updateDrawState(textPaint);
        textPaint.setColor(this.a.getResources().getColor(R$color.main_color));
        textPaint.setUnderlineText(false);
    }
}
