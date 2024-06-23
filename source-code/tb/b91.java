package tb;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class b91 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static b91 f;
    private PopupWindow a;
    private TextView b;
    private View c;
    private View d;
    private View e;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-862189090")) {
                ipChange.ipc$dispatch("-862189090", new Object[]{this, view});
                return;
            }
            b91.this.b.setText("");
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1249101279")) {
                ipChange.ipc$dispatch("1249101279", new Object[]{this, view});
                return;
            }
            b91.this.a.dismiss();
        }
    }

    public b91(Activity activity, View view) {
        this.c = view;
        View inflate = activity.getLayoutInflater().inflate(R$layout.live_popwindow_weexlog, (ViewGroup) null);
        this.b = (TextView) inflate.findViewById(R$id.console_tv);
        this.d = inflate.findViewById(R$id.clear_tv);
        this.e = inflate.findViewById(R$id.close_tv);
        if (this.a == null) {
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
            this.a = popupWindow;
            popupWindow.setBackgroundDrawable(new ColorDrawable(-1));
            this.a.setOutsideTouchable(true);
        }
        this.d.setOnClickListener(new a());
        this.e.setOnClickListener(new b());
    }

    public static b91 c(Activity activity, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-754526897")) {
            return (b91) ipChange.ipc$dispatch("-754526897", new Object[]{activity, view});
        }
        if (f == null) {
            f = new b91(activity, view);
        }
        return f;
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799600717")) {
            ipChange.ipc$dispatch("1799600717", new Object[]{this, str});
            return;
        }
        if (this.b.getText() != null) {
            str = this.b.getText().toString() + StringUtils.LF + str;
        }
        this.b.setText(str);
        PopupWindow popupWindow = this.a;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.c, 51, 0, 0);
        }
    }
}
