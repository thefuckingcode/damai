package cn.damai.uikit.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import java.util.List;
import tb.i42;
import tb.s50;
import tb.ug2;

/* compiled from: Taobao */
public class ScrollSkipLinearView extends ScrollLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    IPhenixListener listener;
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

        a(ScrollSkipLinearView scrollSkipLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1581963080")) {
                ipChange.ipc$dispatch("1581963080", new Object[]{this, view});
                return;
            }
            this.a.onClick(view);
        }
    }

    /* compiled from: Taobao */
    public class b implements IPhenixListener<ug2> {
        private static transient /* synthetic */ IpChange $ipChange;

        b(ScrollSkipLinearView scrollSkipLinearView) {
        }

        /* renamed from: a */
        public boolean onHappen(ug2 ug2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-875667613")) {
                return ((Boolean) ipChange.ipc$dispatch("-875667613", new Object[]{this, ug2})).booleanValue();
            }
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) ug2.f();
            animatedImageDrawable.w();
            animatedImageDrawable.v(1);
            return false;
        }
    }

    public ScrollSkipLinearView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967636053")) {
            ipChange.ipc$dispatch("967636053", new Object[]{this});
            return;
        }
        this.listener = new b(this);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235937886")) {
            ipChange.ipc$dispatch("235937886", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007846667")) {
            ipChange.ipc$dispatch("-1007846667", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSelectIndex = i;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i2);
            TextView textView = (TextView) viewGroup.findViewById(R$id.tv_name);
            ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_line);
            if (i == i2) {
                textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                textView.setTextSize(1, (float) this.mDaSize);
                textView.setPadding(0, 0, 0, s50.a(getContext(), 1.0f));
                imageView.setVisibility(0);
                TUrlImageView tUrlImageView = (TUrlImageView) imageView;
                tUrlImageView.setImageUrl(i42.p("tab_indicator_anim.png"));
                tUrlImageView.succListener(this.listener);
            } else {
                textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                textView.setTextSize(1, (float) this.mXiaoSize);
                textView.setPadding(0, s50.a(getContext(), 2.0f), 0, 0);
                imageView.setVisibility(4);
                ((TUrlImageView) imageView).setImageUrl("");
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1754017868")) {
            ipChange.ipc$dispatch("-1754017868", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.anchor_index_item, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTextSize(1, (float) this.mXiaoSize);
                    inflate.setTag(scrollTitleBean);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.gravity = 16;
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
        if (AndroidInstantRuntime.support(ipChange, "553378518")) {
            ipChange.ipc$dispatch("553378518", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        }
    }

    public ScrollSkipLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }
}
