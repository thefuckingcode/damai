package cn.damai.discover.main.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.dynamicx.customwidget.temp.DMUpMarqueeView;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.g91;
import tb.n42;

/* compiled from: Taobao */
public class DMThemeProjectItemView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int itemNum;
    private final Context mContext;
    private List<ProjectItemBean> mData;
    private TextView projectLabel;
    private DMUpMarqueeView projectLoopView;

    /* compiled from: Taobao */
    public interface ExposureCallBack {
        void exposure(View view, int i);
    }

    /* compiled from: Taobao */
    public interface ProjectLabelClickListener {
        void onClick(int i, ProjectItemBean projectItemBean, List<ProjectItemBean> list);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectLabelClickListener a;

        a(ProjectLabelClickListener projectLabelClickListener) {
            this.a = projectLabelClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "201714726")) {
                ipChange.ipc$dispatch("201714726", new Object[]{this, view});
                return;
            }
            this.a.onClick(DMThemeProjectItemView.this.itemNum, (ProjectItemBean) DMThemeProjectItemView.this.projectLoopView.getCurrentView().getTag(), DMThemeProjectItemView.this.mData);
        }
    }

    /* compiled from: Taobao */
    public class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ExposureCallBack a;

        b(ExposureCallBack exposureCallBack) {
            this.a = exposureCallBack;
        }

        public void onAnimationEnd(Animation animation) {
            View currentView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1761075328")) {
                ipChange.ipc$dispatch("1761075328", new Object[]{this, animation});
                return;
            }
            try {
                if (DMThemeProjectItemView.this.projectLoopView != null && (currentView = DMThemeProjectItemView.this.projectLoopView.getCurrentView()) != null) {
                    ProjectItemBean projectItemBean = (ProjectItemBean) currentView.getTag();
                    DMThemeProjectItemView.this.projectLabel.setTag(projectItemBean);
                    this.a.exposure(currentView, projectItemBean.pos);
                }
            } catch (Exception e) {
                g91.c("DMThemeProjectItemView", e.getMessage());
            }
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "656969460")) {
                ipChange.ipc$dispatch("656969460", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1328524327")) {
                ipChange.ipc$dispatch("-1328524327", new Object[]{this, animation});
            }
        }
    }

    public DMThemeProjectItemView(@NonNull Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    private View createView(int i, ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180351788")) {
            return (View) ipChange.ipc$dispatch("1180351788", new Object[]{this, Integer.valueOf(i), projectItemBean});
        } else if (projectItemBean == null) {
            return null;
        } else {
            View inflate = LayoutInflater.from(getContext()).inflate(R$layout.item_theme_project_loop, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.price_ui);
            RoundImageView roundImageView = (RoundImageView) inflate.findViewById(R$id.riv_item_theme_project);
            TextView textView = (TextView) inflate.findViewById(R$id.price_pending);
            DMDigitTextView dMDigitTextView = (DMDigitTextView) inflate.findViewById(R$id.tv_project_price);
            ((TextView) inflate.findViewById(R$id.tv_project_title)).setText(projectItemBean.name);
            String str = projectItemBean.priceLow;
            if (TextUtils.isEmpty(str) || str.contains("待定")) {
                linearLayout.setVisibility(8);
                textView.setVisibility(0);
            } else {
                dMDigitTextView.setText(str);
                linearLayout.setVisibility(0);
                textView.setVisibility(8);
            }
            roundImageView.setBorder(1, Color.parseColor("#1A000000"));
            DMImageCreator f = cn.damai.common.image.a.b().f(projectItemBean.verticalPic, n42.a(this.mContext, 33.0f), n42.a(this.mContext, 44.0f));
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            f.i(i2).c(i2);
            f.g(roundImageView);
            projectItemBean.pos = i;
            inflate.setTag(projectItemBean);
            return inflate;
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1785766963")) {
            ipChange.ipc$dispatch("1785766963", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.theme_project_loop, (ViewGroup) null);
        this.projectLabel = (TextView) inflate.findViewById(R$id.theme_project_btn);
        DMUpMarqueeView dMUpMarqueeView = (DMUpMarqueeView) inflate.findViewById(R$id.theme_project_rec);
        this.projectLoopView = dMUpMarqueeView;
        dMUpMarqueeView.setFlipInterval(3000);
        this.projectLoopView.setAnimationDuration(500);
        addView(inflate);
    }

    public void create(List<ProjectItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579446109")) {
            ipChange.ipc$dispatch("1579446109", new Object[]{this, list});
        } else if (list != null && list.size() != 0) {
            this.projectLabel.setText(list.size() < 2 ? "去看看" : list.size() + "个相关商品");
            this.mData = list;
            this.itemNum = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                View createView = createView(i, list.get(i));
                if (createView != null) {
                    arrayList.add(createView);
                }
            }
            this.projectLoopView.setItems(arrayList);
        }
    }

    public void setExposureCallBack(ExposureCallBack exposureCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885334306")) {
            ipChange.ipc$dispatch("-1885334306", new Object[]{this, exposureCallBack});
            return;
        }
        Animation inAnimation = this.projectLoopView.getInAnimation();
        if (inAnimation != null) {
            inAnimation.setAnimationListener(new b(exposureCallBack));
        }
    }

    public void setProjectLabelOnClick(ProjectLabelClickListener projectLabelClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1170421373")) {
            ipChange.ipc$dispatch("1170421373", new Object[]{this, projectLabelClickListener});
            return;
        }
        this.projectLabel.setOnClickListener(new a(projectLabelClickListener));
    }

    public void setProjectOnClick(DMUpMarqueeView.OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135733660")) {
            ipChange.ipc$dispatch("-135733660", new Object[]{this, onItemClickListener});
            return;
        }
        this.projectLoopView.setOnItemClickListener(onItemClickListener);
    }

    public DMThemeProjectItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public DMThemeProjectItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }
}
