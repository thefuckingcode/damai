package com.youku.resource.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.resource.R;
import tb.gd2;
import tb.ug2;

/* compiled from: Taobao */
public class YKPageRefreshHeader extends LinearLayout implements RefreshHeader {
    protected Context context;
    SpannableStringBuilder extraInfo;
    public int imageHeight;
    protected int[] imgs;
    protected ImageView mArrowImageView;
    public int mArrowRotateHeight;
    protected int mBgColor;
    protected TUrlImageView mBgImage;
    protected String mBgImageUrl;
    protected FrameLayout mContainer;
    protected boolean mEnablePullToCloseTwoLevel;
    protected boolean mEnableTwoLevel;
    protected int mFloorDuration;
    protected float mFloorRage;
    public float mHeaderTriggerRate;
    protected TextView mHintView;
    public int mInitHeight;
    protected View mLoadingContainer;
    protected YKLoading mLoadingView;
    public int mMaxPullDownDistance;
    protected float mMaxRage;
    protected float mPercent;
    protected RefreshKernel mRefreshKernel;
    protected float mRefreshRage;
    public int mRefreshingHeight;
    private gd2 mSpinnerStyle;
    protected OnTwoLevelListener mTwoLevelListener;

    /* renamed from: com.youku.resource.widget.YKPageRefreshHeader$4  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[RefreshState.values().length];
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = iArr;
            iArr[RefreshState.None.ordinal()] = 1;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.PullDownToRefresh.ordinal()] = 2;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.Refreshing.ordinal()] = 3;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.ReleaseToTwoLevel.ordinal()] = 5;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevelReleased.ordinal()] = 6;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevel.ordinal()] = 7;
            $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[RefreshState.TwoLevelFinish.ordinal()] = 8;
        }
    }

    public YKPageRefreshHeader(Context context2) {
        this(context2, null);
    }

    public YKPageRefreshHeader finishTwoLevel() {
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.finishTwoLevel();
        }
        return this;
    }

    public ImageView getBgImageView() {
        return this.mBgImage;
    }

    public ViewGroup getContainer() {
        if (this.mContainer == null) {
            initView();
        }
        return this.mContainer;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public gd2 getSpinnerStyle() {
        return this.mSpinnerStyle;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    public int getVisibleHeight() {
        return getLayoutParams().height;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.yk_page_refresh_header, (ViewGroup) null);
        this.mContainer = frameLayout;
        this.mLoadingContainer = frameLayout.findViewById(R.id.loading_container);
        this.mBgImage = (TUrlImageView) this.mContainer.findViewById(R.id.bg_image);
        if (getLayoutParams() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(marginLayoutParams);
        }
        setPadding(0, 0, 0, 0);
        addView(this.mContainer, new LinearLayout.LayoutParams(-1, this.mInitHeight));
        setGravity(80);
        TextView textView = (TextView) findViewById(R.id.listview_header_title);
        this.mHintView = textView;
        textView.setVisibility(8);
        this.mArrowImageView = (ImageView) findViewById(R.id.listview_header_arrow);
        measure(-2, this.mInitHeight);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void loading(boolean z) {
        if (this.mArrowImageView != null) {
            YKLoading yKLoading = (YKLoading) findViewById(R.id.loading);
            this.mLoadingView = yKLoading;
            if (yKLoading != null) {
                if (z) {
                    yKLoading.setVisibility(0);
                    this.mLoadingView.startAnimation();
                    return;
                }
                yKLoading.stopAnimation();
                this.mLoadingView.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean needOpenPerf() {
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        TextView textView;
        loading(false);
        ImageView imageView = this.mArrowImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        SpannableStringBuilder spannableStringBuilder = this.extraInfo;
        if (spannableStringBuilder == null || (textView = this.mHintView) == null) {
            return 500;
        }
        textView.setText(spannableStringBuilder);
        this.mHintView.setVisibility(0);
        return 500;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onHorizontalDrag(float f, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        this.mRefreshKernel = refreshKernel;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getVisibleHeight(), 1073741824));
    }

    public void onMove(float f) {
        if (getVisibleHeight() > this.mInitHeight || f > 0.0f) {
            setVisibleHeight((int) f);
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        RefreshKernel refreshKernel;
        ImageView imageView;
        if (z && (refreshKernel = this.mRefreshKernel) != null) {
            if (this.mEnableTwoLevel) {
                float f2 = this.mPercent;
                float f3 = this.mFloorRage;
                if (f2 < f3 && f >= f3) {
                    refreshKernel.setState(RefreshState.ReleaseToTwoLevel);
                } else if (f2 >= f3 && f < f3) {
                    refreshKernel.setState(RefreshState.PullDownToRefresh);
                }
            } else {
                onMove((float) i);
            }
            if (f / this.mHeaderTriggerRate >= 0.7f && (imageView = this.mArrowImageView) != null && imageView.getVisibility() == 0) {
                float f4 = this.mHeaderTriggerRate;
                if (f4 != 0.0f) {
                    final int i4 = (int) (((f / f4) * 200.0f) - 140.0f);
                    int[] iArr = this.imgs;
                    if (i4 < iArr.length - 1) {
                        this.mArrowImageView.post(new Runnable() {
                            /* class com.youku.resource.widget.YKPageRefreshHeader.AnonymousClass3 */

                            public void run() {
                                YKPageRefreshHeader yKPageRefreshHeader = YKPageRefreshHeader.this;
                                ImageView imageView = yKPageRefreshHeader.mArrowImageView;
                                if (imageView != null) {
                                    imageView.setImageResource(yKPageRefreshHeader.imgs[i4]);
                                }
                            }
                        });
                    } else {
                        this.mArrowImageView.setImageResource(iArr[iArr.length - 1]);
                    }
                } else {
                    this.mArrowImageView.setImageResource(this.imgs[0]);
                }
            }
            this.mPercent = f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        loading(true);
    }

    @Override // com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        if (this.mArrowImageView == null) {
            initView();
            setRefreshingHeight(this.mRefreshingHeight);
            setBgImage();
            setBgColor(this.mBgColor);
        }
        int i = AnonymousClass4.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                this.mArrowImageView.setVisibility(0);
            } else if (i == 3) {
                loading(true);
                this.mArrowImageView.setVisibility(8);
            } else if (i == 6) {
                if (getView() != this) {
                    getView().animate().alpha(0.0f).setDuration((long) (this.mFloorDuration / 2));
                }
                if (this.mContainer != null) {
                    for (int i2 = 0; i2 < this.mContainer.getChildCount(); i2++) {
                        if (this.mContainer.getChildAt(i2) != null) {
                            this.mContainer.getChildAt(i2).animate().alpha(0.0f).setDuration((long) (this.mFloorDuration / 2));
                        }
                    }
                }
                RefreshKernel refreshKernel = this.mRefreshKernel;
                if (refreshKernel != null) {
                    OnTwoLevelListener onTwoLevelListener = this.mTwoLevelListener;
                    if (onTwoLevelListener != null && !onTwoLevelListener.onTwoLevel(refreshLayout)) {
                        z = false;
                    }
                    refreshKernel.startTwoLevel(z);
                }
            } else if (i == 8) {
                if (getView() != this) {
                    getView().animate().alpha(1.0f).setDuration((long) (this.mFloorDuration / 2));
                }
                if (this.mContainer != null) {
                    for (int i3 = 0; i3 < this.mContainer.getChildCount(); i3++) {
                        if (this.mContainer.getChildAt(i3) != null) {
                            this.mContainer.getChildAt(i3).animate().alpha(1.0f).setDuration((long) (this.mFloorDuration / 2));
                        }
                    }
                }
            }
        } else {
            this.mHintView.setText("");
            this.mHintView.setVisibility(8);
        }
    }

    public void setArrowImageView(int i) {
        ImageView imageView = this.mArrowImageView;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public void setBgColor(String str) {
        int i;
        try {
            i = Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = Integer.MIN_VALUE;
        }
        if (i != Integer.MIN_VALUE) {
            setBgColor(i);
        }
    }

    public void setBgImage(String str) {
        this.mBgImageUrl = str;
        setBgImage();
    }

    public YKPageRefreshHeader setEnablePullToCloseTwoLevel(boolean z) {
        this.mEnablePullToCloseTwoLevel = z;
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestNeedTouchEventFor(this, !z);
        }
        return this;
    }

    public YKPageRefreshHeader setEnableTwoLevel(boolean z) {
        this.mEnableTwoLevel = z;
        return this;
    }

    public YKPageRefreshHeader setFloorDuration(int i) {
        this.mFloorDuration = i;
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestFloorDuration(i);
        }
        return this;
    }

    public YKPageRefreshHeader setFloorRage(float f) {
        this.mFloorRage = f;
        return this;
    }

    public YKPageRefreshHeader setOnTwoLevelListener(OnTwoLevelListener onTwoLevelListener) {
        this.mTwoLevelListener = onTwoLevelListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshInternal
    public void setPrimaryColors(int... iArr) {
    }

    public YKPageRefreshHeader setRefreshRage(float f) {
        this.mRefreshRage = f;
        return this;
    }

    public void setRefreshingHeight(int i) {
        this.mRefreshingHeight = i;
        View view = this.mLoadingContainer;
        if (view != null) {
            view.getLayoutParams().height = this.mRefreshingHeight;
        }
    }

    public void setSpinnerStyle(gd2 gd2) {
        this.mSpinnerStyle = gd2;
    }

    public void setVisibleHeight(int i) {
        int i2 = this.mInitHeight;
        if (i < i2) {
            i = i2;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            setLayoutParams(layoutParams);
            FrameLayout frameLayout = this.mContainer;
            if (frameLayout != null) {
                frameLayout.getLayoutParams().height = i;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void smoothScrollTo(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(getVisibleHeight(), i);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(300L).start();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.youku.resource.widget.YKPageRefreshHeader.AnonymousClass2 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                YKPageRefreshHeader.this.setVisibleHeight(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.start();
    }

    public YKPageRefreshHeader(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public YKPageRefreshHeader(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.mInitHeight = -1;
        this.mBgImageUrl = "";
        this.mBgColor = 0;
        this.imageHeight = -1;
        this.mHeaderTriggerRate = 0.0f;
        this.mPercent = 0.0f;
        this.mMaxRage = 2.5f;
        this.mFloorRage = 1.9f;
        this.mRefreshRage = 1.0f;
        this.mEnableTwoLevel = false;
        this.mEnablePullToCloseTwoLevel = true;
        this.mFloorDuration = 1000;
        this.imgs = new int[]{R.drawable.show_space_00000, R.drawable.show_space_00001, R.drawable.show_space_00002, R.drawable.show_space_00003, R.drawable.show_space_00004, R.drawable.show_space_00005, R.drawable.show_space_00006, R.drawable.show_space_00007, R.drawable.show_space_00008, R.drawable.show_space_00009, R.drawable.show_space_00010, R.drawable.show_space_00011, R.drawable.show_space_00012, R.drawable.show_space_00013, R.drawable.show_space_00014, R.drawable.show_space_00015, R.drawable.show_space_00016, R.drawable.show_space_00017, R.drawable.show_space_00018, R.drawable.show_space_00019, R.drawable.show_space_00020, R.drawable.show_space_00021, R.drawable.show_space_00022, R.drawable.show_space_00023, R.drawable.show_space_00024, R.drawable.show_space_00025, R.drawable.show_space_00026, R.drawable.show_space_00027, R.drawable.show_space_00028, R.drawable.show_space_00029, R.drawable.show_space_00030, R.drawable.show_space_00031, R.drawable.show_space_00032, R.drawable.show_space_00033, R.drawable.show_space_00034, R.drawable.show_space_00035, R.drawable.show_space_00036, R.drawable.show_space_00037, R.drawable.show_space_00038, R.drawable.show_space_00039, R.drawable.show_space_00040, R.drawable.show_space_00041, R.drawable.show_space_00042, R.drawable.show_space_00043, R.drawable.show_space_00044, R.drawable.show_space_00045, R.drawable.show_space_00046, R.drawable.show_space_00047, R.drawable.show_space_00048, R.drawable.show_space_00049, R.drawable.show_space_00050, R.drawable.show_space_00051, R.drawable.show_space_00052, R.drawable.show_space_00053, R.drawable.show_space_00054, R.drawable.show_space_00055, R.drawable.show_space_00056, R.drawable.show_space_00057, R.drawable.show_space_00058, R.drawable.show_space_00059};
        this.mSpinnerStyle = gd2.Translate;
        this.context = context2;
        this.mMaxPullDownDistance = DisplayMetrics.getheightPixels(getResources().getDisplayMetrics());
        this.mInitHeight = DensityUtil.dp2px(300.0f);
        this.mArrowRotateHeight = getResources().getDimensionPixelOffset(R.dimen.homepage_arrow_rotate_distance);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.homepage_refreshing_height);
        this.mRefreshingHeight = dimensionPixelOffset;
        this.imageHeight = this.mArrowRotateHeight + dimensionPixelOffset;
        if (!needOpenPerf()) {
            initView();
        }
    }

    public void setBgImage() {
        if (this.mBgImage != null && !TextUtils.isEmpty(this.mBgImageUrl) && this.mBgImage.getContext() != null) {
            try {
                this.mBgImage.succListener(new IPhenixListener<ug2>() {
                    /* class com.youku.resource.widget.YKPageRefreshHeader.AnonymousClass1 */

                    public boolean onHappen(ug2 ug2) {
                        if (ug2.f() == null || ug2.i() || YKPageRefreshHeader.this.mBgImage == null) {
                            return true;
                        }
                        BitmapDrawable f = ug2.f();
                        Matrix matrix = new Matrix();
                        int intrinsicWidth = f.getIntrinsicWidth();
                        int intrinsicHeight = f.getIntrinsicHeight();
                        float width = ((float) YKPageRefreshHeader.this.mBgImage.getWidth()) / ((float) intrinsicWidth);
                        matrix.setScale(width, width);
                        YKPageRefreshHeader.this.mBgImage.setScaleType(ImageView.ScaleType.MATRIX);
                        YKPageRefreshHeader.this.mBgImage.setImageMatrix(matrix);
                        ViewGroup.LayoutParams layoutParams = YKPageRefreshHeader.this.mBgImage.getLayoutParams();
                        int i = (int) (((float) intrinsicHeight) * width);
                        layoutParams.height = i;
                        YKPageRefreshHeader yKPageRefreshHeader = YKPageRefreshHeader.this;
                        yKPageRefreshHeader.imageHeight = i;
                        yKPageRefreshHeader.mBgImage.setLayoutParams(layoutParams);
                        int height = YKPageRefreshHeader.this.getHeight();
                        YKPageRefreshHeader yKPageRefreshHeader2 = YKPageRefreshHeader.this;
                        if (height >= yKPageRefreshHeader2.imageHeight) {
                            return true;
                        }
                        ViewGroup.LayoutParams layoutParams2 = yKPageRefreshHeader2.getLayoutParams();
                        YKPageRefreshHeader yKPageRefreshHeader3 = YKPageRefreshHeader.this;
                        layoutParams2.height = yKPageRefreshHeader3.imageHeight;
                        FrameLayout frameLayout = yKPageRefreshHeader3.mContainer;
                        if (frameLayout != null) {
                            ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
                            YKPageRefreshHeader yKPageRefreshHeader4 = YKPageRefreshHeader.this;
                            layoutParams3.height = yKPageRefreshHeader4.imageHeight;
                            yKPageRefreshHeader4.mContainer.requestLayout();
                        }
                        YKPageRefreshHeader.this.requestLayout();
                        return true;
                    }
                });
                this.mBgImage.setImageUrl(this.mBgImageUrl);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void setBgColor(int i) {
        int i2 = this.mBgColor;
        if (i2 == 0 || i2 != i) {
            this.mBgColor = i;
        }
        super.setBackgroundColor(this.mBgColor);
    }
}
