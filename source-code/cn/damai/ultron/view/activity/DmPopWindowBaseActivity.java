package cn.damai.ultron.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.ultron.R$anim;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ma0;
import tb.n42;

/* compiled from: Taobao */
public abstract class DmPopWindowBaseActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView cancelIcon;
    View mAnimView;
    private LinearLayout mBottomContentLayout;
    public TextView mLeftTitle;
    private LinearLayout mTitleBottomLayout;
    public View mTitleBottomLine;
    public TextView mTitleText;
    private TextView mTvTitleBottom;
    private RecyclerView recyclerView;
    private RelativeLayout rl_bottom;
    private View v_outside;

    /* compiled from: Taobao */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418126934")) {
                ipChange.ipc$dispatch("1418126934", new Object[]{this, animation});
                return;
            }
            DmPopWindowBaseActivity.this.finish();
            DmPopWindowBaseActivity.this.overridePendingTransition(0, 0);
        }

        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1608560990")) {
                ipChange.ipc$dispatch("1608560990", new Object[]{this, animation});
            }
        }

        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-189449169")) {
                ipChange.ipc$dispatch("-189449169", new Object[]{this, animation});
            }
        }
    }

    public void addErrorView(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683471345")) {
            ipChange.ipc$dispatch("1683471345", new Object[]{this, str, str2, str3});
            return;
        }
        onResponseError(str2, str, str3, this.mBottomContentLayout, true);
    }

    public void finishActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264022915")) {
            ipChange.ipc$dispatch("-264022915", new Object[]{this});
        } else if (this.mAnimView == null) {
            finish();
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R$anim.activity_item_animexit);
            this.mAnimView.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new a());
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-721027741")) {
            return R$layout.activity_pop;
        }
        return ((Integer) ipChange.ipc$dispatch("-721027741", new Object[]{this})).intValue();
    }

    public RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1522486184")) {
            return this.recyclerView;
        }
        return (RecyclerView) ipChange.ipc$dispatch("-1522486184", new Object[]{this});
    }

    public abstract boolean getRightTextVis();

    public abstract String getTitleContent();

    @Override // cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.SimpleBaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258784266")) {
            ipChange.ipc$dispatch("258784266", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.v_outside = findViewById(R$id.v_outside);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.rl_bottom);
        this.rl_bottom = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.height = (int) (((double) DisplayMetrics.getheightPixels(n42.b(this))) * 0.75d);
        this.rl_bottom.setLayoutParams(layoutParams);
        this.cancelIcon = (DMIconFontTextView) findViewById(R$id.text_ok);
        this.cancelIcon.setVisibility(getRightTextVis() ? 0 : 8);
        this.mTitleText = (TextView) findViewById(R$id.text_title);
        this.mLeftTitle = (TextView) findViewById(R$id.left_text_title);
        String titleContent = getTitleContent();
        TextView textView = this.mTitleText;
        if (titleContent == null) {
            titleContent = "";
        }
        textView.setText(titleContent);
        this.mTitleBottomLayout = (LinearLayout) findViewById(R$id.ll_title_bottom);
        this.mTitleBottomLine = findViewById(R$id.line_title);
        this.mTvTitleBottom = (TextView) findViewById(R$id.title_tip);
        this.mTitleBottomLayout.setVisibility(0);
        updateTitleBottomView(true, "");
        this.mBottomContentLayout = (LinearLayout) findViewById(R$id.ll_bottom_content);
        this.recyclerView = (RecyclerView) findViewById(R$id.rc);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setAnimationView(this.rl_bottom);
        this.rl_bottom.startAnimation(AnimationUtils.loadAnimation(this, R$anim.activity_item_animshow));
        this.rl_bottom.setOnClickListener(null);
        this.v_outside.setOnClickListener(this);
        this.cancelIcon.setOnClickListener(this);
        findViewById(R$id.rl_title).setOnClickListener(null);
    }

    public abstract boolean isLoadUt();

    @Override // androidx.activity.ComponentActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onBackPressed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576909361")) {
            ipChange.ipc$dispatch("-1576909361", new Object[]{this});
            return;
        }
        finishActivity();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739723408")) {
            ipChange.ipc$dispatch("-739723408", new Object[]{this, view});
        } else if (view.getId() == R$id.v_outside || view.getId() == R$id.text_ok) {
            finishActivity();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, cn.damai.common.app.base.BaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533830672")) {
            ipChange.ipc$dispatch("-533830672", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (isLoadUt()) {
            setDamaiUTKeyBuilder(ma0.u().s(this));
        }
    }

    public void onResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496664920")) {
            ipChange.ipc$dispatch("-496664920", new Object[]{this});
            return;
        }
        onResponseSuccess(this.mBottomContentLayout);
    }

    public void setAnimationView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787202502")) {
            ipChange.ipc$dispatch("-1787202502", new Object[]{this, view});
            return;
        }
        this.mAnimView = view;
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseActivity
    public String setTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-254592361")) {
            return null;
        }
        return (String) ipChange.ipc$dispatch("-254592361", new Object[]{this});
    }

    public void updateTitleBottomView(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2114028238")) {
            ipChange.ipc$dispatch("-2114028238", new Object[]{this, Boolean.valueOf(z), str});
        } else if (z || TextUtils.isEmpty(str)) {
            this.mTvTitleBottom.setVisibility(8);
            this.mTitleBottomLine.setVisibility(0);
        } else {
            this.mTvTitleBottom.setText(str);
            this.mTvTitleBottom.setVisibility(0);
            this.mTitleBottomLine.setVisibility(8);
        }
    }
}
