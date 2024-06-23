package cn.damai.issue;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.damai.comment.R$id;
import cn.damai.comment.R$layout;
import cn.damai.comment.R$string;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.s50;

/* compiled from: Taobao */
public class IssueCircleSelect implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private PopupWindow b;
    private QueryThemeCliqueInfoBean c;
    private List<View> d = new ArrayList(3);
    private View e;
    private TextView f;
    private ImageView g;
    private DMIconFontTextView h;
    private View i;
    private int j;
    private int k;

    public IssueCircleSelect(Context context) {
        this.a = context;
        h();
    }

    private void g(View view) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841306280")) {
            ipChange.ipc$dispatch("841306280", new Object[]{this, view});
        } else if (view.getTag() == null) {
            view.setVisibility(8);
        } else {
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.iv_circle_check);
            QueryThemeCliqueInfoBean queryThemeCliqueInfoBean = (QueryThemeCliqueInfoBean) view.getTag();
            ((TextView) view.findViewById(R$id.tv_circle_content)).setText(queryThemeCliqueInfoBean.getName());
            if (this.c == queryThemeCliqueInfoBean) {
                j(view, true);
            } else {
                j(view, false);
            }
            if (this.c == queryThemeCliqueInfoBean) {
                str = this.a.getString(R$string.iconfont_yuangouxuanxuanzhong);
            } else {
                str = this.a.getString(R$string.iconfont_yuangouxuanweixuanzhong);
            }
            dMIconFontTextView.setText(str);
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076491444")) {
            ipChange.ipc$dispatch("2076491444", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.issue_circle_select_popwin, (ViewGroup) null);
        this.b = new PopupWindow(inflate);
        this.i = inflate.findViewById(R$id.select_null);
        View findViewById = inflate.findViewById(R$id.select_1);
        View findViewById2 = inflate.findViewById(R$id.select_2);
        View findViewById3 = inflate.findViewById(R$id.select_3);
        this.d.add(findViewById);
        this.d.add(findViewById2);
        this.d.add(findViewById3);
        this.i.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        this.b.setFocusable(true);
        this.b.setOnDismissListener(new PopupWindow.OnDismissListener() {
            /* class cn.damai.issue.IssueCircleSelect.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onDismiss() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "961779465")) {
                    ipChange.ipc$dispatch("961779465", new Object[]{this});
                    return;
                }
                IssueCircleSelect.this.h.setText(IssueCircleSelect.this.a.getString(R$string.iconfont_shaixuanxia12));
                IssueCircleSelect.this.l();
            }
        });
    }

    private void j(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584170638")) {
            ipChange.ipc$dispatch("-584170638", new Object[]{this, view, Boolean.valueOf(z)});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_circle_content);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) view.findViewById(R$id.iv_circle_check);
        if (z) {
            dMIconFontTextView.setText(this.a.getString(R$string.iconfont_yuangouxuanxuanzhong));
            textView.setTextColor(Color.parseColor("#FF2869"));
            dMIconFontTextView.setTextColor(Color.parseColor("#FF2869"));
            return;
        }
        dMIconFontTextView.setText(this.a.getString(R$string.iconfont_yuangouxuanweixuanzhong));
        textView.setTextColor(Color.parseColor("#333333"));
        dMIconFontTextView.setTextColor(Color.parseColor("#C8C8C8"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void l() {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "47518558")) {
            ipChange.ipc$dispatch("47518558", new Object[]{this});
            return;
        }
        TextView textView = this.f;
        QueryThemeCliqueInfoBean queryThemeCliqueInfoBean = this.c;
        textView.setText(queryThemeCliqueInfoBean == null ? "不关联" : queryThemeCliqueInfoBean.getName());
        this.f.setTextColor(Color.parseColor(this.c == null ? "#CCCCCC" : "#9C9CA5"));
        ImageView imageView = this.g;
        if (this.c == null) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    private void n(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304629338")) {
            ipChange.ipc$dispatch("-304629338", new Object[]{this, list});
        } else if (list == null || list.size() == 0) {
            this.c = null;
        } else if (!list.contains(this.c)) {
            this.c = list.get(0);
        }
    }

    public void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "216800536")) {
            ipChange.ipc$dispatch("216800536", new Object[]{this, view});
            return;
        }
        this.e = view;
        this.f = (TextView) view.findViewById(R$id.tv_circle_tip_content);
        this.g = (ImageView) view.findViewById(R$id.iv_circle_icon);
        this.h = (DMIconFontTextView) view.findViewById(R$id.iv_circle_screen);
    }

    public int e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2138294033")) {
            return this.k;
        }
        return ((Integer) ipChange.ipc$dispatch("-2138294033", new Object[]{this})).intValue();
    }

    public QueryThemeCliqueInfoBean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1432245655")) {
            return this.c;
        }
        return (QueryThemeCliqueInfoBean) ipChange.ipc$dispatch("1432245655", new Object[]{this});
    }

    public void i(QueryThemeCliqueInfoBean queryThemeCliqueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743285759")) {
            ipChange.ipc$dispatch("-743285759", new Object[]{this, queryThemeCliqueInfoBean});
            return;
        }
        this.c = queryThemeCliqueInfoBean;
        l();
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083631901")) {
            ipChange.ipc$dispatch("2083631901", new Object[]{this});
            return;
        }
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            g(this.d.get(i2));
        }
        if (this.c == null) {
            j(this.i, true);
        } else {
            j(this.i, false);
        }
        this.b.setWidth(s50.a(this.a, 225.0f));
        this.b.setHeight(-2);
        this.h.setText(this.a.getString(R$string.iconfont_shaixuanshang12));
        int[] iArr = new int[2];
        this.h.getLocationOnScreen(iArr);
        this.b.showAtLocation(this.h, 0, iArr[0], iArr[1] - this.j);
    }

    public void m(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "599352613")) {
            ipChange.ipc$dispatch("599352613", new Object[]{this, list});
            return;
        }
        n(list);
        if (list != null) {
            this.j = s50.a(this.a, 70.0f) + (list.size() * s50.a(this.a, 50.0f));
            this.k = list.size();
        }
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            if (list.size() > i2) {
                this.d.get(i2).setTag(list.get(i2));
            } else {
                this.d.get(i2).setTag(null);
            }
        }
        if (list == null || list.size() == 0) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        l();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037491302")) {
            ipChange.ipc$dispatch("-1037491302", new Object[]{this, view});
            return;
        }
        if (view.getId() == R$id.select_null) {
            this.c = null;
        } else if (view.getTag() != null && (view.getTag() instanceof QueryThemeCliqueInfoBean)) {
            this.c = (QueryThemeCliqueInfoBean) view.getTag();
        }
        this.b.dismiss();
    }
}
