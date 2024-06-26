package cn.damai.tetris.component.drama.viewholder;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.search.bean.MarketTagBean;
import cn.damai.commonbusiness.util.DMRGBUtil;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import tb.lk1;
import tb.m42;
import tb.xs0;
import tb.zy2;

/* compiled from: Taobao */
public class ProjectBroadCastViewHolder extends BaseViewHolder<ProjectShowBean> implements WeakRefCountDownTimer.OnTickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMPosterView a;
    private TextView b;
    private View c;
    private View d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private FlowLayout k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;
    private int r = m42.a(xs0.a(), 86.0f);
    private int s = m42.a(xs0.a(), 115.0f);
    private ProjectShowBean t;
    private int u;
    private OnItemClickListener<ProjectShowBean> v;
    private List<View> w;

    /* compiled from: Taobao */
    public class a implements View.OnAttachStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onViewAttachedToWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "299589625")) {
                ipChange.ipc$dispatch("299589625", new Object[]{this, view});
            }
        }

        public void onViewDetachedFromWindow(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "266324534")) {
                ipChange.ipc$dispatch("266324534", new Object[]{this, view});
                return;
            }
            Object tag = ProjectBroadCastViewHolder.this.d.getTag();
            if (tag instanceof zy2) {
                ((zy2) tag).cancel();
                ProjectBroadCastViewHolder.this.d.setTag(null);
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1007447842")) {
                ipChange.ipc$dispatch("-1007447842", new Object[]{this, view});
            } else if (ProjectBroadCastViewHolder.this.v != null && ProjectBroadCastViewHolder.this.t != null) {
                ProjectBroadCastViewHolder.this.v.onItemClick(ProjectBroadCastViewHolder.this.t, ProjectBroadCastViewHolder.this.u);
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        /* compiled from: Taobao */
        public class a implements DMRGBUtil.OnFetchColorListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // cn.damai.commonbusiness.util.DMRGBUtil.OnFetchColorListener
            public void onFetchColor(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "212982192")) {
                    ipChange.ipc$dispatch("212982192", new Object[]{this, Integer.valueOf(i)});
                } else if (ProjectBroadCastViewHolder.this.t != null) {
                    c cVar = c.this;
                    if (TextUtils.equals(cVar.a, ProjectBroadCastViewHolder.this.t.verticalPic)) {
                        ProjectBroadCastViewHolder.this.t.postColor = i;
                        Drawable background = ProjectBroadCastViewHolder.this.itemView.getBackground();
                        if (background instanceof GradientDrawable) {
                            ((GradientDrawable) background).setColor(i);
                        }
                    }
                }
            }
        }

        c(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1853594277")) {
                ipChange.ipc$dispatch("1853594277", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap != null && !bitmap.isRecycled()) {
                DMRGBUtil.g(1.0f, bitmap, this.a, new a());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public ProjectBroadCastViewHolder(View view, OnItemClickListener<ProjectShowBean> onItemClickListener) {
        super(view);
        this.v = onItemClickListener;
        this.a = (DMPosterView) view.findViewById(R$id.dc_project_poster);
        this.o = (TextView) view.findViewById(R$id.dc_project_title);
        this.n = (TextView) view.findViewById(R$id.dc_project_date);
        this.m = (TextView) view.findViewById(R$id.dc_project_addr);
        this.l = (TextView) view.findViewById(R$id.dc_project_ipuv);
        this.j = view.findViewById(R$id.project_with_price_ui);
        this.p = (TextView) view.findViewById(R$id.dc_project_price);
        this.k = (FlowLayout) view.findViewById(R$id.project_with_price_promotion);
        this.q = view.findViewById(R$id.project_with_price_pending);
        View findViewById = view.findViewById(R$id.project_state_count_down);
        this.d = findViewById;
        findViewById.addOnAttachStateChangeListener(new a());
        this.e = (TextView) view.findViewById(R$id.project_state_count_down_day);
        this.f = (TextView) view.findViewById(R$id.project_state_count_down_day_tag);
        this.g = (TextView) view.findViewById(R$id.project_state_count_down_hour);
        this.h = (TextView) view.findViewById(R$id.project_state_count_down_minute);
        this.i = (TextView) view.findViewById(R$id.project_state_count_down_second);
        this.c = view.findViewById(R$id.project_state_buy);
        this.b = (TextView) view.findViewById(R$id.project_state_none_ticket);
        view.setOnClickListener(new b());
    }

    private void h(ProjectShowBean projectShowBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "89704674")) {
            ipChange.ipc$dispatch("89704674", new Object[]{this, projectShowBean, str});
        } else if (projectShowBean.postColor != -1) {
            Drawable background = this.itemView.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(projectShowBean.postColor);
            }
        } else {
            cn.damai.common.image.a.b().f(str, this.r, this.s).n(new c(str)).f();
        }
    }

    private void i(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1123434432")) {
            ipChange.ipc$dispatch("1123434432", new Object[]{this, view});
            return;
        }
        if (this.w == null) {
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            arrayList.add(this.d);
            this.w.add(this.c);
            this.w.add(this.b);
        }
        for (View view2 : this.w) {
            if (view2 == view) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    /* renamed from: g */
    public void a(ProjectShowBean projectShowBean, int i2) {
        long j2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736226573")) {
            ipChange.ipc$dispatch("-736226573", new Object[]{this, projectShowBean, Integer.valueOf(i2)});
        } else if (projectShowBean != null) {
            this.t = projectShowBean;
            this.u = i2;
            String str = projectShowBean.verticalPic;
            this.a.setImageUrlForWebp(str, this.r, this.s);
            this.a.setCategoryTagName(projectShowBean.categoryName);
            this.a.setScoreStar(projectShowBean.getItemScoreValue(), true);
            h(projectShowBean, str);
            this.o.setText(projectShowBean.name);
            this.n.setText(TextUtils.isEmpty(projectShowBean.showTime) ? "时间待定" : projectShowBean.showTime);
            this.m.setText((TextUtils.isEmpty(projectShowBean.cityName) ? "城市待定" : projectShowBean.cityName) + " | " + (TextUtils.isEmpty(projectShowBean.venueName) ? "场馆待定" : projectShowBean.venueName));
            this.l.setText(lk1.f(projectShowBean.ipvuv, -1, -1));
            String str2 = projectShowBean.priceLow;
            if (TextUtils.isEmpty(str2) || str2.contains("待定")) {
                this.j.setVisibility(8);
                this.q.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.k.getLayoutParams()).addRule(1, R$id.project_with_price_pending);
            } else {
                this.q.setVisibility(8);
                this.j.setVisibility(0);
                this.p.setText(str2);
                ((RelativeLayout.LayoutParams) this.k.getLayoutParams()).addRule(1, R$id.project_with_price_ui);
            }
            this.k.removeAllViews();
            this.k.setVisibility(8);
            MarketTagBean gotTopTag = projectShowBean.gotTopTag(true);
            if (gotTopTag != null) {
                this.k.setVisibility(0);
                gotTopTag.addMarketTagView(this.k, true);
            }
            Object tag = this.d.getTag();
            if (tag instanceof zy2) {
                ((zy2) tag).cancel();
                this.d.setTag(null);
            }
            if (projectShowBean.status == 1) {
                j2 = projectShowBean.getCountdownTime();
                if (j2 <= 0) {
                    projectShowBean.status = 2;
                }
            } else {
                j2 = 0;
            }
            int i3 = projectShowBean.status;
            if (i3 == 1) {
                zy2 zy2 = new zy2(j2, 1000, this);
                zy2.start();
                this.d.setTag(zy2);
                i(this.d);
            } else if (i3 == 2) {
                i(this.c);
            } else if (i3 != 3) {
                i(null);
            } else {
                this.b.setText("很遗憾没票了");
                i(this.b);
            }
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66393651")) {
            ipChange.ipc$dispatch("-66393651", new Object[]{this});
            return;
        }
        ProjectShowBean projectShowBean = this.t;
        if (projectShowBean != null) {
            projectShowBean.status = 2;
            a(projectShowBean, this.u);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j2) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        boolean z = true;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "944461793")) {
            ipChange.ipc$dispatch("944461793", new Object[]{this, Long.valueOf(j2)});
            return;
        }
        long j3 = j2 / 86400000;
        long j4 = (j2 % 86400000) / DateUtils.MILLIS_PER_HOUR;
        long j5 = j2 % DateUtils.MILLIS_PER_HOUR;
        long j6 = j5 / DateUtils.MILLIS_PER_MINUTE;
        long j7 = (j5 % DateUtils.MILLIS_PER_MINUTE) / 1000;
        if (j4 >= 10) {
            str = String.valueOf(j4);
        } else {
            str = "0" + j4;
        }
        if (j6 >= 10) {
            str2 = String.valueOf(j6);
        } else {
            str2 = "0" + j6;
        }
        if (j7 >= 10) {
            str3 = String.valueOf(j7);
        } else {
            str3 = "0" + j7;
        }
        if (j3 <= 0) {
            z = false;
        }
        this.e.setVisibility(z ? 0 : 8);
        TextView textView = this.f;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (z) {
            if (j3 >= 10) {
                str4 = String.valueOf(j3);
            } else {
                str4 = "0" + j3;
            }
            this.e.setText(str4);
        }
        this.g.setText(str);
        this.h.setText(str2);
        this.i.setText(str3);
    }
}
