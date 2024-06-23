package cn.damai.category.discountticket.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.n42;
import tb.xs0;

/* compiled from: Taobao */
public abstract class Column3ProjectViewHolder extends DiscountTicketAdapter.BaseViewHolder<Column3WrapBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a = n42.a(xs0.a(), 103.0f);
    private final int b = n42.a(xs0.a(), 138.0f);
    private List<a> c = new ArrayList(3);

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        View a;
        private TextView b = ((TextView) this.a.findViewById(R$id.item_title));
        private TextView c = ((TextView) this.a.findViewById(R$id.item_price_tv));
        private ProjectItemBean d;
        private DMPosterView e;
        private View f = this.a.findViewById(R$id.item_price_layout);
        private View g = this.a.findViewById(R$id.item_price_pending);

        public a(View view) {
            this.a = view;
            this.e = (DMPosterView) view.findViewById(R$id.item_poster);
        }

        private boolean b(String str) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1593039826")) {
                return TextUtils.isEmpty(str) || str.contains("待定");
            }
            return ((Boolean) ipChange.ipc$dispatch("1593039826", new Object[]{this, str})).booleanValue();
        }

        public void a(ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "220330583")) {
                ipChange.ipc$dispatch("220330583", new Object[]{this, projectItemBean, Integer.valueOf(i)});
                return;
            }
            this.d = projectItemBean;
            if (projectItemBean == null) {
                this.a.setOnClickListener(null);
                this.a.setTag(null);
                this.a.setVisibility(4);
                return;
            }
            this.a.setVisibility(0);
            this.a.setOnClickListener(this);
            String str = projectItemBean.name;
            String str2 = projectItemBean.cityName;
            if (!TextUtils.isEmpty(str2)) {
                str = "【" + str2 + "】" + str;
            }
            this.b.setText(str);
            boolean b2 = b(projectItemBean.priceLow);
            if (!b2) {
                this.c.setText(projectItemBean.priceLow);
            }
            this.f.setVisibility(b2 ? 8 : 0);
            this.g.setVisibility(b2 ? 0 : 8);
            this.e.setImageUrlForWebp(projectItemBean.verticalPic, Column3ProjectViewHolder.this.a, Column3ProjectViewHolder.this.b);
            DMPosterView dMPosterView = this.e;
            if (!projectItemBean.hasVideo()) {
                i2 = 8;
            }
            dMPosterView.setVideoIconVisibility(i2);
            this.e.setCategoryTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
            String str3 = projectItemBean.discountRate;
            if (TextUtils.isEmpty(str3)) {
                this.e.setCategoryTagName(null);
            } else {
                this.e.setCategoryTagName(str3 + "折起");
            }
            this.e.setScoreStar(projectItemBean.itemScore, true);
            Column3ProjectViewHolder.this.e(this.a, projectItemBean, i);
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "406570957")) {
                ipChange.ipc$dispatch("406570957", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = this.d;
            if (projectItemBean != null) {
                Column3ProjectViewHolder.this.f(projectItemBean);
            }
        }
    }

    public Column3ProjectViewHolder(View view) {
        super(view);
        View findViewById = view.findViewById(R$id.item_1_layout);
        View findViewById2 = view.findViewById(R$id.item_2_layout);
        View findViewById3 = view.findViewById(R$id.item_3_layout);
        a aVar = new a(findViewById);
        a aVar2 = new a(findViewById2);
        a aVar3 = new a(findViewById3);
        this.c.add(aVar);
        this.c.add(aVar2);
        this.c.add(aVar3);
    }

    /* renamed from: d */
    public void a(Column3WrapBean column3WrapBean) {
        int i;
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-903788432")) {
            ipChange.ipc$dispatch("-903788432", new Object[]{this, column3WrapBean});
            return;
        }
        List<ProjectItemBean> list = column3WrapBean.list;
        if (list == null) {
            i = 0;
        } else {
            i = list.size();
        }
        while (i2 < 3) {
            ProjectItemBean projectItemBean = null;
            int i3 = i2 + 1;
            if (i3 <= i) {
                projectItemBean = list.get(i2);
            }
            this.c.get(i2).a(projectItemBean, i2);
            i2 = i3;
        }
    }

    public abstract void e(View view, ProjectItemBean projectItemBean, int i);

    public abstract void f(ProjectItemBean projectItemBean);
}
