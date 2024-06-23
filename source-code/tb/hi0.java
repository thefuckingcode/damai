package tb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.projectfilter.bean.Type;
import cn.damai.projectfilter.filterbtn.BtnInfoProvider;
import cn.damai.projectfilter.filterbtn.FilterBtn;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class hi0 implements FilterBtn {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Type a;
    private View b;
    private TextView c = ((TextView) this.b.findViewById(R$id.filter_btn_arrow));
    private TextView d;
    private BtnInfoProvider e;

    public hi0(Context context, Type type, BtnInfoProvider btnInfoProvider) {
        this.a = type;
        this.e = btnInfoProvider;
        View inflate = LayoutInflater.from(context).inflate(R$layout.item_filter_btn_view, (ViewGroup) null);
        this.b = inflate;
        this.d = (TextView) inflate.findViewById(R$id.filter_btn_name);
        int a2 = (int) ((((float) (DisplayMetrics.getwidthPixels(n42.b(context)) - n42.a(context, 79.0f))) / ((float) Math.max(1, btnInfoProvider.getLeftBtnCount()))) - ((float) n42.a(context, 22.0f)));
        int a3 = n42.a(context, 35.0f);
        this.d.setMaxWidth(a2);
        this.d.setMinWidth(Math.min(a3, a2));
    }

    @Override // cn.damai.projectfilter.filterbtn.FilterBtn
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1169771611")) {
            return this.a;
        }
        return (Type) ipChange.ipc$dispatch("-1169771611", new Object[]{this});
    }

    @Override // cn.damai.projectfilter.filterbtn.FilterBtn
    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "108465015")) {
            return this.b;
        }
        return (View) ipChange.ipc$dispatch("108465015", new Object[]{this});
    }

    @Override // cn.damai.projectfilter.filterbtn.FilterBtn
    public void setState(boolean z) {
        zc btnText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472290551")) {
            ipChange.ipc$dispatch("-1472290551", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        BtnInfoProvider btnInfoProvider = this.e;
        if (btnInfoProvider != null && (btnText = btnInfoProvider.getBtnText(this.a)) != null) {
            this.d.setText(btnText.g());
            boolean z2 = btnText.b;
            int i = z2 ? ng0.C_FF2869 : ng0.C_333333;
            int i2 = z2 ? ng0.C_FF2869 : ng0.C_5F6672;
            this.d.setTextColor(i);
            this.c.setText(z ? R$string.iconfont_shaixuanshang12 : R$string.iconfont_shaixuanxia12);
            this.c.setTextColor(i2);
        }
    }
}
