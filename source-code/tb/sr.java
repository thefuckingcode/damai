package tb;

import android.app.Application;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.comment.R$drawable;
import cn.damai.comment.R$id;
import cn.damai.common.image.a;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class sr {
    private static transient /* synthetic */ IpChange $ipChange;
    public View a;
    private RoundImageView b;
    private TextView c = ((TextView) this.a.findViewById(R$id.id_store_or_script_title));
    private TextView d = ((TextView) this.a.findViewById(R$id.id_store_or_script_desc));

    public sr(View view) {
        this.a = view;
        this.b = (RoundImageView) view.findViewById(R$id.id_store_or_script_img);
    }

    public void a(String str, String str2, String str3, boolean z, String str4) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-990110208")) {
            ipChange.ipc$dispatch("-990110208", new Object[]{this, str, str2, str3, Boolean.valueOf(z), str4});
            return;
        }
        this.a.setVisibility(0);
        if (z) {
            ik.I().g(this.a, null, str4, 1);
        } else {
            ik.I().g(this.a, str4, null, 1);
        }
        float f = 41.0f;
        int a2 = m42.a(xs0.a(), 41.0f);
        this.b.getLayoutParams().width = a2;
        Application a3 = xs0.a();
        if (!z) {
            f = 55.0f;
        }
        int a4 = m42.a(a3, f);
        this.b.getLayoutParams().height = a4;
        this.b.setBorder(0.5f, Color.parseColor("#1A000000"));
        a.b().f(str, a2, a4).i(z ? R$drawable.store_defult_img : R$drawable.uikit_default_image_bg_grey).g(this.b);
        this.c.setText(str2);
        this.d.setText(str3);
        TextView textView = this.d;
        if (TextUtils.isEmpty(str3)) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439974949")) {
            ipChange.ipc$dispatch("-439974949", new Object[]{this});
            return;
        }
        this.a.setVisibility(8);
    }

    public void c(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786047881")) {
            ipChange.ipc$dispatch("-1786047881", new Object[]{this, onClickListener});
            return;
        }
        this.a.setOnClickListener(onClickListener);
    }
}
