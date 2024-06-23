package cn.damai.uikit.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.s50;

/* compiled from: Taobao */
public class ScrollLottieLinearView extends ScrollLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mLineWidth = 0.0f;
    private Paint mPaint;
    private int mScrollX = 0;
    public int mSelectIndex = -1;
    private TextView mSelectTv;
    private float mStartX;
    private int mStartY = 0;
    private float mStopX;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        a(ScrollLottieLinearView scrollLottieLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "222884712")) {
                ipChange.ipc$dispatch("222884712", new Object[]{this, view});
                return;
            }
            this.a.onClick(view);
        }
    }

    public ScrollLottieLinearView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913989749")) {
            ipChange.ipc$dispatch("913989749", new Object[]{this});
            return;
        }
        setGravity(1);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588976190")) {
            ipChange.ipc$dispatch("588976190", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048403691")) {
            ipChange.ipc$dispatch("-2048403691", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSelectIndex = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            RelativeLayout relativeLayout = (RelativeLayout) getChildAt(i2);
            TextView textView = (TextView) relativeLayout.findViewById(R$id.tv_name);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) relativeLayout.findViewById(R$id.iv_line);
            if (i == i2) {
                textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                textView.setTextSize(1, (float) this.mDaSize);
                textView.setPadding(0, 0, 0, 0);
                lottieAnimationView.setVisibility(0);
                lottieAnimationView.setImageAssetsFolder("cc/images/");
                lottieAnimationView.setAnimation("cc/data.json");
                lottieAnimationView.playAnimation();
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                textView.setTextSize(1, (float) this.mXiaoSize);
                textView.setPadding(0, s50.a(getContext(), 2.0f), 0, 0);
                lottieAnimationView.setVisibility(4);
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709218412")) {
            ipChange.ipc$dispatch("-709218412", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.anchor_lottie_index_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTextSize(1, (float) this.mXiaoSize);
                    inflate.setTag(scrollTitleBean);
                    ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                    inflate.setPadding(dip2px((float) (this.mSpace / 2)), 0, dip2px((float) (this.mSpace / 2)), 0);
                    inflate.setLayoutParams(layoutParams);
                    inflate.setOnClickListener(new a(this, onClickListener));
                    addView(inflate);
                }
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void startAnim(int i, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305458422")) {
            ipChange.ipc$dispatch("1305458422", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
    }

    public ScrollLottieLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }
}
