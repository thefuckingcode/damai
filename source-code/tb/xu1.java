package tb;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.regex.Pattern;

/* compiled from: Taobao */
public class xu1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMPosterView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private DMDigitTextView e;
    private DMDigitTextView f;
    private TextView g;
    private TextView h;

    public xu1(View view) {
        view.getContext();
        this.a = (DMPosterView) view.findViewById(R$id.poster);
        this.b = (TextView) view.findViewById(R$id.tv_title);
        this.c = (TextView) view.findViewById(R$id.tv_desc);
        this.d = (TextView) view.findViewById(R$id.tv_desc_line2);
        this.e = (DMDigitTextView) view.findViewById(R$id.tv_fuhao);
        this.f = (DMDigitTextView) view.findViewById(R$id.tv_price);
        this.g = (TextView) view.findViewById(R$id.tv_price_tip);
        this.h = (TextView) view.findViewById(R$id.tv_tag_new);
    }

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576576386")) {
            return ((Boolean) ipChange.ipc$dispatch("576576386", new Object[]{str})).booleanValue();
        } else if (str == null) {
            return false;
        } else {
            return Pattern.compile("^-?\\d+(\\.\\d+)?$").matcher(str).matches();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e5  */
    public void b(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7) {
        String str8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-311357010")) {
            ipChange.ipc$dispatch("-311357010", new Object[]{this, str, str2, str3, str4, str5, Integer.valueOf(i), str6, str7});
            return;
        }
        this.a.setImageUrl(str);
        this.a.setCategoryTagName(str2);
        if (TextUtils.isEmpty(str3)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setText(str3);
        }
        if (TextUtils.isEmpty(str4)) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setText(str4);
        }
        if (TextUtils.isEmpty(str6)) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            this.d.setText(str6);
        }
        if (TextUtils.isEmpty(str5)) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            if (i == 1) {
                str8 = "我想看";
                this.g.setText(str8);
                if (!TextUtils.isEmpty(str7)) {
                    this.h.setVisibility(0);
                    this.h.setText(str7);
                    return;
                }
                this.h.setVisibility(8);
                return;
            }
        } else if (a(str5)) {
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.f.setText(str5);
            str8 = "起";
            if (i == 1) {
                str8 = str8 + " | 我想看";
            }
            this.g.setText(str8);
            if (!TextUtils.isEmpty(str7)) {
            }
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setText(str5);
        }
        str8 = "";
        this.g.setText(str8);
        if (!TextUtils.isEmpty(str7)) {
        }
    }
}
