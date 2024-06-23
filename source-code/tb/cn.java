package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class cn extends ym2<ContentDetail> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView d;
    private View e;

    public cn(Context context) {
        super(context);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1833303570")) {
            return R$layout.live_content_detail_text;
        }
        return ((Integer) ipChange.ipc$dispatch("1833303570", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504980257")) {
            ipChange.ipc$dispatch("-504980257", new Object[]{this});
            return;
        }
        this.e = this.b.findViewById(R$id.live_content_detail_highlight_tag);
        this.d = (TextView) this.b.findViewById(R$id.live_content_detail_text);
    }

    public void d(ContentDetail contentDetail) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1656951066")) {
            ipChange.ipc$dispatch("-1656951066", new Object[]{this, contentDetail});
        } else if (contentDetail == null) {
            c(false);
        } else {
            ArrayList<ContentDetail.ContentText> arrayList = contentDetail.content;
            if (arrayList == null || xf2.e(arrayList) <= 0 || arrayList.get(0) == null || TextUtils.isEmpty(arrayList.get(0).value)) {
                c(false);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (TextUtils.isEmpty(contentDetail.relateTitle)) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = n42.a(xs0.a(), 15.0f);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = n42.a(xs0.a(), 9.0f);
                }
            }
            this.d.setText(arrayList.get(0).value.replaceAll("\n{2,}", StringUtils.LF).trim());
            View view = this.e;
            if (!contentDetail.isFeature()) {
                i = 8;
            }
            view.setVisibility(i);
            c(true);
        }
    }
}
