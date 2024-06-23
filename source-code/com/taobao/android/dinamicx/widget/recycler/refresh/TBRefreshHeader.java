package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$color;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$string;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
public class TBRefreshHeader extends TBAbsRefreshHeader {
    private static Typeface sIconfont;
    private static int sReference;
    private TextView mArrowTextView = this.mRefreshHeadView.getArrow();
    private String[] mDefaultRefreshTips;
    private ObjectAnimator mFadeAnimationSet;
    private RefreshHeadView mRefreshHeadView;
    private FrameLayout mRefreshHeaderView;
    private CustomProgressBar mRefreshProgressView = this.mRefreshHeadView.getProgressbar();
    private TextView mRefreshTipView = this.mRefreshHeadView.getRefreshStateText();
    private String[] mRefreshTips;
    private View mSecondFloorView;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[TBAbsRefreshHeader.RefreshState.values().length];
            a = iArr;
            iArr[TBAbsRefreshHeader.RefreshState.NONE.ordinal()] = 1;
            a[TBAbsRefreshHeader.RefreshState.PULL_TO_REFRESH.ordinal()] = 2;
            a[TBAbsRefreshHeader.RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            a[TBAbsRefreshHeader.RefreshState.REFRESHING.ordinal()] = 4;
            a[TBAbsRefreshHeader.RefreshState.PREPARE_TO_SECOND_FLOOR.ordinal()] = 5;
            a[TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_START.ordinal()] = 6;
            try {
                a[TBAbsRefreshHeader.RefreshState.SECOND_FLOOR_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public TBRefreshHeader(Context context) {
        super(context);
        Context context2 = getContext();
        int i = R$string.uik_pull_to_refresh;
        Context context3 = getContext();
        int i2 = R$string.uik_release_to_refresh;
        Context context4 = getContext();
        int i3 = R$string.uik_refreshing;
        Context context5 = getContext();
        int i4 = R$string.uik_refresh_finished;
        this.mDefaultRefreshTips = new String[]{context2.getString(i), context3.getString(i2), context4.getString(i3), context5.getString(i4)};
        this.mRefreshTips = new String[]{getContext().getString(i), getContext().getString(i2), getContext().getString(i3), getContext().getString(i4)};
        this.mRefreshHeaderView = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.mRefreshHeaderView.setId(R$id.uik_refresh_header);
        addView(this.mRefreshHeaderView, layoutParams);
        this.mSecondFloorView = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.mSecondFloorView.setId(R$id.uik_refresh_header_second_floor);
        this.mRefreshHeaderView.addView(this.mSecondFloorView, layoutParams2);
        setBackgroundResource(R$color.uik_refresh_head_bg);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        RefreshHeadView refreshHeadView = new RefreshHeadView(context, R$string.uik_refresh_arrow, null, false);
        this.mRefreshHeadView = refreshHeadView;
        this.mRefreshHeaderView.addView(refreshHeadView, layoutParams3);
        changeToState(TBAbsRefreshHeader.RefreshState.NONE);
    }

    private void showArrow() {
        ObjectAnimator objectAnimator = this.mFadeAnimationSet;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mArrowTextView.setScaleX(1.0f);
        this.mArrowTextView.setScaleY(1.0f);
        this.mArrowTextView.setAlpha(1.0f);
        this.mArrowTextView.setVisibility(0);
    }

    private void startArrowAnim() {
        if (this.mFadeAnimationSet == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mArrowTextView, ofFloat, ofFloat2, ofFloat3);
            this.mFadeAnimationSet = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mFadeAnimationSet.setDuration(200L);
        }
        this.mFadeAnimationSet.start();
    }

    public void changeHeaderAlpha(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mRefreshHeadView.setAlpha(f);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void changeToState(TBAbsRefreshHeader.RefreshState refreshState) {
        TBAbsRefreshHeader.RefreshState refreshState2;
        if (this.mRefreshProgressView != null && (refreshState2 = this.mState) != refreshState) {
            TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener = this.mPullRefreshListener;
            if (onPullRefreshListener != null) {
                onPullRefreshListener.onRefreshStateChanged(refreshState2, refreshState);
            }
            this.mState = refreshState;
            int i = a.a[refreshState.ordinal()];
            if (i == 1) {
                this.mRefreshProgressView.stopLoadingAnimation();
                TextView textView = this.mRefreshTipView;
                String[] strArr = this.mRefreshTips;
                textView.setText(strArr == null ? this.mDefaultRefreshTips[3] : strArr[3]);
                this.mRefreshProgressView.stopLoadingAnimation();
                changeHeaderAlpha(1.0f);
            } else if (i == 2) {
                showArrow();
                this.mRefreshTipView.setVisibility(0);
                TextView textView2 = this.mRefreshTipView;
                String[] strArr2 = this.mRefreshTips;
                textView2.setText(strArr2 == null ? this.mDefaultRefreshTips[0] : strArr2[0]);
                this.mRefreshHeadView.setVisibility(0);
            } else if (i == 3) {
                startArrowAnim();
                TextView textView3 = this.mRefreshTipView;
                String[] strArr3 = this.mRefreshTips;
                textView3.setText(strArr3 == null ? this.mDefaultRefreshTips[1] : strArr3[1]);
                this.mRefreshHeadView.setVisibility(0);
            } else if (i == 4) {
                this.mRefreshProgressView.startLoadingAnimaton();
                this.mRefreshProgressView.setVisibility(0);
                this.mArrowTextView.setVisibility(4);
                TextView textView4 = this.mRefreshTipView;
                String[] strArr4 = this.mRefreshTips;
                textView4.setText(strArr4 == null ? this.mDefaultRefreshTips[2] : strArr4[2]);
                this.mRefreshHeadView.setVisibility(0);
            } else if (i == 5) {
                this.mRefreshHeadView.setVisibility(8);
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public View getRefreshView() {
        return this.mRefreshHeadView;
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public View getSecondFloorView() {
        return this.mSecondFloorView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mRefreshProgressView.setPullDownDistance(getMeasuredHeight());
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setProgress(float f) {
        if (this.mState == TBAbsRefreshHeader.RefreshState.PULL_TO_REFRESH) {
            if (getMeasuredHeight() != 0) {
                this.mRefreshProgressView.changeProgressBarState((int) (((float) getMeasuredHeight()) * f));
            }
            changeHeaderAlpha(f);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setRefreshAnimation(String[] strArr, @Nullable String str) {
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setRefreshTipColor(@ColorInt int i) {
        TextView textView = this.mRefreshTipView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setRefreshTipSize(int i) {
        TextView textView = this.mRefreshTipView;
        if (textView != null) {
            textView.setTextSize((float) i);
            this.mRefreshTipView.setSingleLine(true);
            this.mRefreshTipView.setMaxLines(1);
            ViewGroup.LayoutParams layoutParams = this.mRefreshTipView.getLayoutParams();
            layoutParams.width = -2;
            this.mRefreshTipView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setRefreshTips(String[] strArr) {
        if (strArr == null || strArr.length != 4) {
            this.mRefreshTips = null;
        } else {
            this.mRefreshTips = strArr;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader
    public void setSecondFloorView(View view) {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        if (this.mSecondFloorView != null) {
            if (this.mRefreshHeaderView != null) {
                if (view.getLayoutParams() == null) {
                    layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                } else {
                    layoutParams2 = new FrameLayout.LayoutParams(view.getLayoutParams());
                }
                layoutParams2.gravity = 80;
                this.mRefreshHeaderView.removeView(this.mSecondFloorView);
                this.mRefreshHeaderView.addView(view, 0, layoutParams2);
                this.mSecondFloorView = view;
                view.setId(R$id.uik_refresh_header_second_floor);
            }
        } else if (this.mRefreshHeaderView != null) {
            if (view.getLayoutParams() == null) {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
            }
            layoutParams.gravity = 80;
            this.mRefreshHeaderView.addView(view, 0, layoutParams);
            this.mSecondFloorView = view;
            view.setId(R$id.uik_refresh_header_second_floor);
        }
    }
}
