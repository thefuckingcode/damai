package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.youku.resource.R;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.utils.SkinUtils;
import com.youku.style.IStyle;
import com.youku.style.StyleVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.u91;

/* compiled from: Taobao */
public class YKTitleTabIndicator extends HorizontalScrollView implements IStyle {
    public static final float PARSE_FIRST = 0.3f;
    public static final float PARSE_SECOND = 0.7f;
    public static final int POSITION_ORIGIN = 0;
    public static final String TAG = "YKTitleTabIndicator";
    protected boolean ableTextAnim;
    protected int currentPosition;
    protected float currentPositionOffset;
    protected int currentX;
    protected boolean enableSmoothScroll;
    protected boolean isDefaultColor;
    protected int itemViewLayout;
    protected int leftEndPadding;
    LinearGradient lg;
    private List<YKTitleTabItemView> mCachedTabs;
    protected int mClickedPosition;
    protected LinearLayout mContainer;
    protected Context mContext;
    private volatile boolean mCreateCachedTabsFinished;
    protected Map mCurrentStyleMap;
    protected List mDataList;
    protected int mGradientIndicatorEndColor;
    protected int mGradientIndicatorStartColor;
    protected int mGradientTextEndColorDef;
    protected int mGradientTextStartColorDef;
    protected Handler mHandler;
    protected int mIndicatorColor;
    protected boolean mIsClicked;
    protected OnTabClickListener mOnTabClickListener;
    protected int mScreenWidth;
    protected ScrollViewListener mScrollViewListener;
    private Scroller mScroller;
    protected int mSliderBottomMargin;
    protected float mSliderCompat;
    protected int mSliderHeightMoving;
    protected int mSliderHeightStill;
    protected float mSliderRadius;
    protected float mSliderWidthMax;
    protected float mSliderWidthMin;
    protected int mTextColorDef;
    protected int mTextColorSelected;
    protected int mTextSelectedBottomPadding;
    protected int mTextSizeDef;
    protected int mTextSizeSelected;
    protected ViewPager mViewPager;
    private OverScroller myScroller;
    protected Paint rectPaint;
    protected int rightEndPadding;
    protected int sIndicatorColor;
    protected int sTextColorDef;
    protected int sTextColorSelected;
    protected int scrollAnimDuring;
    public Runnable scrollRunnable;
    protected ScrollType scrollType;
    protected YKTitleTabItemView selectedItemView;
    protected int textAnimDuring;
    protected StyleVisitor visitor;

    /* compiled from: Taobao */
    public interface ItemSelectListener {
        void onSelected();

        void onUnSelected();
    }

    /* compiled from: Taobao */
    public interface OnTabClickListener {
        void onTabClick(View view, int i);
    }

    /* compiled from: Taobao */
    public enum ScrollType {
        IDLE,
        TOUCH_SCROLL,
        FLING
    }

    /* compiled from: Taobao */
    public interface ScrollViewListener {
        void onScrollChanged(ScrollType scrollType);
    }

    public YKTitleTabIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int blend(float f) {
        return ColorUtils.blendARGB(this.mTextColorDef, this.mTextColorSelected, f);
    }

    private int dp2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01b7  */
    private void drawLine(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        YKTitleTabItemView yKTitleTabItemView;
        if (!AppPerfABUtils.isOpenDegrade() && this.mContainer.getChildCount() != 0 && this.mContainer.getChildAt(this.currentPosition) != null) {
            int height = getHeight();
            YKTitleTabItemView yKTitleTabItemView2 = (YKTitleTabItemView) this.mContainer.getChildAt(this.currentPosition);
            if (yKTitleTabItemView2 != null) {
                float mainRight = (float) ((yKTitleTabItemView2.getMainRight() - (yKTitleTabItemView2.getMainWidth() / 2)) + getPaddingLeft());
                float f = this.mSliderWidthMin;
                float f2 = mainRight - (f / 2.0f);
                float f3 = (f / 2.0f) + mainRight;
                boolean z = true;
                if (this.currentPositionOffset > 0.0f && this.currentPosition < this.mContainer.getChildCount() - 1 && this.mContainer.getChildAt(this.currentPosition + 1) != null && (yKTitleTabItemView = (YKTitleTabItemView) this.mContainer.getChildAt(this.currentPosition + 1)) != null) {
                    float mainRight2 = (float) ((yKTitleTabItemView.getMainRight() - (yKTitleTabItemView.getMainWidth() / 2)) + getPaddingLeft());
                    float f4 = this.currentPositionOffset;
                    if (f4 < 0.3f) {
                        f3 += (this.mSliderWidthMax - this.mSliderWidthMin) * (f4 / 0.3f);
                    } else if (f4 < 0.3f || f4 >= 0.7f) {
                        float f5 = this.mSliderWidthMax;
                        float f6 = this.mSliderWidthMin;
                        f2 = (mainRight2 - f5) + (f6 / 2.0f) + ((f5 - f6) * ((f4 - 0.7f) / 0.3f));
                        f3 = mainRight2 + (f6 / 2.0f);
                    } else {
                        float f7 = mainRight2 - mainRight;
                        float f8 = this.mSliderWidthMax;
                        f2 += ((f7 - f8) + this.mSliderWidthMin) * ((f4 - 0.3f) / 0.39999998f);
                        f3 = f8 + f2;
                    }
                    if (!this.mIsClicked) {
                        int blend = blend(1.0f - f4);
                        int blend2 = blend(this.currentPositionOffset);
                        TextView textView = ((YKTitleTabItemView) this.mContainer.getChildAt(this.currentPosition)).getTextView();
                        TextView textView2 = ((YKTitleTabItemView) this.mContainer.getChildAt(this.currentPosition + 1)).getTextView();
                        if (textView != null) {
                            textView.setTextColor(blend);
                        }
                        if (textView2 != null) {
                            textView2.setTextColor(blend2);
                        }
                    }
                }
                int i5 = this.mGradientIndicatorStartColor;
                int i6 = this.mGradientIndicatorEndColor;
                StyleVisitor styleVisitor = this.visitor;
                if (styleVisitor == null || !styleVisitor.hasStyleStringValue(IStyle.NAV_INDICATOR_COLOR)) {
                    YKTitleTabItemView yKTitleTabItemView3 = this.selectedItemView;
                    if (yKTitleTabItemView3 == null || (i3 = yKTitleTabItemView3.startColor) == 0 || (i4 = yKTitleTabItemView3.endColor) == 0) {
                        StyleVisitor styleVisitor2 = this.visitor;
                        if (styleVisitor2 == null || !styleVisitor2.hasStyleStringValue("navTextSelectColor")) {
                            i2 = i5;
                            i = i6;
                            if (z) {
                                this.lg = null;
                                if (f3 - f2 <= this.mSliderWidthMin + this.mSliderCompat) {
                                    int i7 = this.mSliderBottomMargin;
                                    this.lg = new LinearGradient(f2, (float) ((height - i7) - this.mSliderHeightStill), f3, (float) (height - i7), i2, i, Shader.TileMode.CLAMP);
                                } else {
                                    int i8 = this.mSliderBottomMargin;
                                    int i9 = this.mSliderHeightStill;
                                    int i10 = this.mSliderHeightMoving;
                                    this.lg = new LinearGradient(f2, (float) ((height - i8) - ((i9 + i10) / 2)), f3, (float) ((height - i8) - ((i9 - i10) / 2)), i2, i, Shader.TileMode.CLAMP);
                                }
                                this.rectPaint.setShader(this.lg);
                            } else if (this.lg != null) {
                                this.lg = null;
                                this.rectPaint.setShader(null);
                            }
                            if (f3 - f2 <= this.mSliderWidthMin + this.mSliderCompat) {
                                int i11 = this.mSliderBottomMargin;
                                RectF rectF = new RectF(f2, (float) ((height - i11) - this.mSliderHeightStill), f3, (float) (height - i11));
                                float f9 = this.mSliderRadius;
                                canvas.drawRoundRect(rectF, f9, f9, this.rectPaint);
                            } else {
                                int i12 = this.mSliderBottomMargin;
                                int i13 = this.mSliderHeightStill;
                                int i14 = this.mSliderHeightMoving;
                                RectF rectF2 = new RectF(f2, (float) ((height - i12) - ((i13 + i14) / 2)), f3, (float) ((height - i12) - ((i13 - i14) / 2)));
                                float f10 = this.mSliderRadius;
                                canvas.drawRoundRect(rectF2, f10, f10, this.rectPaint);
                            }
                            u91.a("YKTitleTabIndicator", "drawline, position = " + this.currentPosition + " offset = " + this.currentPositionOffset + " left = " + f2 + " right = " + f3, new Object[0]);
                        }
                    } else {
                        i = i4;
                        i2 = i3;
                        if (z) {
                        }
                        if (f3 - f2 <= this.mSliderWidthMin + this.mSliderCompat) {
                        }
                        u91.a("YKTitleTabIndicator", "drawline, position = " + this.currentPosition + " offset = " + this.currentPositionOffset + " left = " + f2 + " right = " + f3, new Object[0]);
                    }
                }
                i2 = i5;
                i = i6;
                z = false;
                if (z) {
                }
                if (f3 - f2 <= this.mSliderWidthMin + this.mSliderCompat) {
                }
                u91.a("YKTitleTabIndicator", "drawline, position = " + this.currentPosition + " offset = " + this.currentPositionOffset + " left = " + f2 + " right = " + f3, new Object[0]);
            }
        }
    }

    private YKTitleTabItemView getTab(List<YKTitleTabItemView> list) {
        if (this.mCachedTabs != null) {
            int size = list.size();
            if (size > 0) {
                return list.remove(size - 1);
            }
            synchronized (this.mCachedTabs) {
                list.addAll(this.mCachedTabs);
                this.mCachedTabs.clear();
                if (this.mCreateCachedTabsFinished) {
                    this.mCachedTabs = null;
                }
            }
        }
        int size2 = list.size();
        if (size2 > 0) {
            return list.remove(size2 - 1);
        }
        YKTitleTabItemView yKTitleTabItemView = (YKTitleTabItemView) LayoutInflater.from(this.mContext).inflate(this.itemViewLayout, (ViewGroup) null);
        yKTitleTabItemView.initView(this);
        yKTitleTabItemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        return yKTitleTabItemView;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mScroller = new Scroller(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YKTitleTabIndicator, i, 0);
        try {
            this.mSliderWidthMax = obtainStyledAttributes.getDimension(R.styleable.YKTitleTabIndicator_slider_max_width, (float) dp2px(60.0f));
            this.mSliderWidthMin = obtainStyledAttributes.getDimension(R.styleable.YKTitleTabIndicator_slider_min_width, (float) dp2px(9.0f));
            this.mSliderHeightStill = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_still_height, dp2px(3.0f));
            this.mSliderHeightMoving = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_moving_height, dp2px(3.0f));
            this.mSliderBottomMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_bottom_margin, dp2px(5.0f));
            this.mSliderRadius = (float) obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_radius, this.mSliderHeightStill / 2);
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.YKTitleTabIndicator_able_text_anim, false);
            this.ableTextAnim = z;
            if (z) {
                this.mTextSizeDef = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_default_size, SkinUtils.getTextDefaultSizeInPx(context));
                this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_selected_size, SkinUtils.getTextSelectedSizeInPx(context));
            } else {
                this.mTextSizeDef = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_default_size, SkinUtils.getTextDefaultSizeInPx(context));
                this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_selected_size, SkinUtils.getTextDefaultSizeInPx(context));
            }
            int color = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_slider_color, SkinUtils.getTabIndicatorColor());
            this.mIndicatorColor = color;
            this.sIndicatorColor = color;
            int color2 = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_text_selected_color, SkinUtils.getTabTextColorSelected());
            this.mTextColorSelected = color2;
            this.sTextColorSelected = color2;
            int color3 = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_text_default_color, SkinUtils.getTabTextColorDef());
            this.mTextColorDef = color3;
            this.sTextColorDef = color3;
            this.rightEndPadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_right_end_padding, dp2px(6.0f));
            this.leftEndPadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_left_end_padding, 0);
            this.itemViewLayout = obtainStyledAttributes.getResourceId(R.styleable.YKTitleTabIndicator_item_view_layout, 0);
            this.mScreenWidth = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
            this.textAnimDuring = obtainStyledAttributes.getInteger(R.styleable.YKTitleTabIndicator_text_anim_during, 200);
            this.scrollAnimDuring = obtainStyledAttributes.getInteger(R.styleable.YKTitleTabIndicator_scroll_anim_during, 500);
            this.mTextSelectedBottomPadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_text_selected_bottom_padding, dp2px(9.0f));
            this.mGradientTextStartColorDef = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_gradient_text_start_color_def, 0);
            this.mGradientTextEndColorDef = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_gradient_text_end_color_def, 0);
            this.mGradientIndicatorStartColor = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_gradient_indicator_start_color, SkinUtils.getTabIndicatorColorStartColor());
            this.mGradientIndicatorEndColor = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_gradient_indicator_end_color, SkinUtils.getTabIndicatorColorEndColor());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void setTextViewClicked(TextView textView, boolean z) {
        textView.getPaint().setFakeBoldText(z);
        if (z) {
            if ((textView.getParent() instanceof YKTitleTabItemView) && !((YKTitleTabItemView) textView.getParent()).hasGradientText()) {
                textView.setTextColor(this.mTextColorSelected);
            } else if ((textView.getParent() instanceof YKTitleTabItemView) && ((YKTitleTabItemView) textView.getParent()).hasGradientText()) {
                textView.setTextColor(ColorUtils.setAlphaComponent(this.mTextColorSelected, 255));
            }
            if (!this.ableTextAnim) {
                textView.setTextSize(0, (float) this.mTextSizeSelected);
            }
        } else {
            textView.setTextColor(this.mTextColorDef);
            if (!this.ableTextAnim) {
                textView.setTextSize(0, (float) this.mTextSizeDef);
            }
        }
        textView.invalidate();
    }

    public void adjustCenterPosition() {
        adjustTitleColor();
        adjustPosition();
    }

    public void adjustPosition() {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout != null && this.mClickedPosition < linearLayout.getChildCount()) {
            scrollToPosition(this.mClickedPosition);
        }
    }

    public void adjustTitleColor() {
        TextView textView;
        for (int i = 0; i < this.mContainer.getChildCount(); i++) {
            YKTitleTabItemView yKTitleTabItemView = (YKTitleTabItemView) this.mContainer.getChildAt(i);
            if (!(yKTitleTabItemView == null || (textView = yKTitleTabItemView.getTextView()) == null)) {
                if (i == this.mClickedPosition) {
                    yKTitleTabItemView.setStyle(this.mCurrentStyleMap);
                    setTextViewClicked(textView, true);
                    yKTitleTabItemView.onSelected();
                    this.selectedItemView = yKTitleTabItemView;
                } else {
                    yKTitleTabItemView.resetStyle();
                    setTextViewClicked(textView, false);
                    yKTitleTabItemView.onUnSelected();
                }
            }
        }
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawLine(canvas);
    }

    public void fling(int i) {
        super.fling(i / 4);
    }

    public int getClickedPosition() {
        return this.mClickedPosition;
    }

    public LinearLayout getContainer() {
        return this.mContainer;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public float getCurrentPositionOffset() {
        return this.currentPositionOffset;
    }

    public int getCurrentX() {
        return this.currentX;
    }

    public List getDataList() {
        return this.mDataList;
    }

    public int getGradientIndicatorEndColor() {
        return this.mGradientIndicatorEndColor;
    }

    public int getGradientIndicatorStartColor() {
        return this.mGradientIndicatorStartColor;
    }

    public int getGradientTextEndColorDef() {
        return this.mGradientTextEndColorDef;
    }

    public int getGradientTextStartColorDef() {
        return this.mGradientTextStartColorDef;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Deprecated
    public int getIndecatorColor() {
        return this.mIndicatorColor;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public int getItemViewLayout() {
        return this.itemViewLayout;
    }

    public int getLeftEndPadding() {
        return this.leftEndPadding;
    }

    public OnTabClickListener getOnTabClickListener() {
        return this.mOnTabClickListener;
    }

    public int getRightEndPadding() {
        return this.rightEndPadding;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getScrollAnimDuring() {
        return this.scrollAnimDuring;
    }

    public YKTitleTabItemView getSelectedItemView() {
        return this.selectedItemView;
    }

    public int getSliderBottomMargin() {
        return this.mSliderBottomMargin;
    }

    public float getSliderCompat() {
        return this.mSliderCompat;
    }

    public int getSliderHeightMoving() {
        return this.mSliderHeightMoving;
    }

    public int getSliderHeightStill() {
        return this.mSliderHeightStill;
    }

    public float getSliderWidthMax() {
        return this.mSliderWidthMax;
    }

    public float getSliderWidthMin() {
        return this.mSliderWidthMin;
    }

    public StyleVisitor getStyleVisitor() {
        return this.visitor;
    }

    public int getTextAnimDuring() {
        return this.textAnimDuring;
    }

    public int getTextColorDef() {
        return this.mTextColorDef;
    }

    public int getTextColorSelected() {
        return this.mTextColorSelected;
    }

    public int getTextSelectedBottomPadding() {
        return this.mTextSelectedBottomPadding;
    }

    public int getTextSizeDef() {
        return this.mTextSizeDef;
    }

    public int getTextSizeSelected() {
        return this.mTextSizeSelected;
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public float getmSliderRadius() {
        return this.mSliderRadius;
    }

    public int getsIndicatorColor() {
        return this.sIndicatorColor;
    }

    public int getsTextColorDef() {
        return this.sTextColorDef;
    }

    public int getsTextColorSelected() {
        return this.sTextColorSelected;
    }

    public boolean isAbleTextAnim() {
        return this.ableTextAnim;
    }

    public boolean isEnableSmoothScroll() {
        return this.enableSmoothScroll;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            this.mHandler.post(this.scrollRunnable);
        } else if (action == 2) {
            ScrollType scrollType2 = ScrollType.TOUCH_SCROLL;
            this.scrollType = scrollType2;
            ScrollViewListener scrollViewListener = this.mScrollViewListener;
            if (scrollViewListener != null) {
                scrollViewListener.onScrollChanged(scrollType2);
            }
            this.mHandler.removeCallbacks(this.scrollRunnable);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void preCreateTabs(int i) {
        int size;
        this.mCreateCachedTabsFinished = false;
        if (this.mCachedTabs == null) {
            this.mCachedTabs = new ArrayList(i);
        }
        synchronized (this.mCachedTabs) {
            size = i - this.mCachedTabs.size();
        }
        for (int i2 = 0; i2 < size; i2++) {
            YKTitleTabItemView yKTitleTabItemView = (YKTitleTabItemView) LayoutInflater.from(this.mContext).inflate(this.itemViewLayout, (ViewGroup) null);
            yKTitleTabItemView.initView(this);
            yKTitleTabItemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
            synchronized (this.mCachedTabs) {
                this.mCachedTabs.add(yKTitleTabItemView);
            }
        }
        this.mCreateCachedTabsFinished = true;
    }

    @Override // com.youku.style.IStyle
    public void resetStyle() {
        this.mCurrentStyleMap = null;
        this.visitor = null;
        setCustomClor(this.sTextColorDef, this.sTextColorSelected, this.sIndicatorColor);
    }

    public void scaleTab(boolean z) {
        if (!AppPerfABUtils.isOpenDegrade() && this.mContainer.getChildCount() != 0) {
            getHeight();
            try {
                YKTitleTabItemView yKTitleTabItemView = (YKTitleTabItemView) this.mContainer.getChildAt(this.currentPosition);
                if (this.currentPositionOffset > 0.0f && this.currentPosition < this.mContainer.getChildCount() - 1) {
                    YKTitleTabItemView yKTitleTabItemView2 = (YKTitleTabItemView) this.mContainer.getChildAt(this.currentPosition + 1);
                    float f = this.currentPositionOffset;
                    if (f > 0.6f) {
                        yKTitleTabItemView2.getTextView().getPaint().setFakeBoldText(true);
                        yKTitleTabItemView.getTextView().getPaint().setFakeBoldText(false);
                    } else if (f < 0.4f) {
                        yKTitleTabItemView.getTextView().getPaint().setFakeBoldText(true);
                        yKTitleTabItemView2.getTextView().getPaint().setFakeBoldText(false);
                    }
                    if (z) {
                        yKTitleTabItemView2.invalidate();
                    }
                }
                if (z) {
                    yKTitleTabItemView.invalidate();
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void scrollToPosition(final int i) {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout != null && i < linearLayout.getChildCount()) {
            final View childAt = this.mContainer.getChildAt(i);
            if (childAt.getWidth() > 0) {
                int left = childAt.getLeft() - ((this.mScreenWidth - childAt.getWidth()) / 2);
                u91.a("YKTitleTabIndicator", "scroll 1, position = " + i + " viewleft = " + childAt.getLeft(), new Object[0]);
                smoothScrollToSlow(left, 0, this.scrollAnimDuring);
                this.mHandler.postDelayed(this.scrollRunnable, 50);
                return;
            }
            childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.youku.resource.widget.YKTitleTabIndicator.AnonymousClass3 */

                public void onGlobalLayout() {
                    int left = childAt.getLeft() - ((YKTitleTabIndicator.this.mScreenWidth - childAt.getWidth()) / 2);
                    YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabIndicator.this;
                    yKTitleTabIndicator.smoothScrollToSlow(left, 0, yKTitleTabIndicator.scrollAnimDuring);
                    YKTitleTabIndicator yKTitleTabIndicator2 = YKTitleTabIndicator.this;
                    yKTitleTabIndicator2.mHandler.postDelayed(yKTitleTabIndicator2.scrollRunnable, 50);
                    u91.a("YKTitleTabIndicator", "scroll 2, position = " + i + " viewleft = " + childAt.getLeft(), new Object[0]);
                    ViewTreeObserver viewTreeObserver = childAt.getViewTreeObserver();
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    public void setAbleTextAnim(boolean z) {
        this.ableTextAnim = z;
    }

    public void setClickedPosition(int i) {
        this.mClickedPosition = i;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public void setCurrentPositionOffset(float f) {
        this.currentPositionOffset = f;
    }

    public void setCurrentX(int i) {
        this.currentX = i;
    }

    public void setCustomClor(int i, int i2, int i3) {
        this.mTextColorDef = i;
        this.mTextColorSelected = i2;
        this.mIndicatorColor = i3;
        if (i == this.sTextColorDef && i2 == this.sTextColorSelected && i3 == this.sIndicatorColor) {
            this.isDefaultColor = true;
        } else {
            this.isDefaultColor = false;
        }
        this.rectPaint.setColor(i3);
        adjustCenterPosition();
        invalidate();
    }

    public void setEnableSmoothScroll(boolean z) {
        this.enableSmoothScroll = z;
    }

    public void setGradientIndicatorEndColor(int i) {
        this.mGradientIndicatorEndColor = i;
    }

    public void setGradientIndicatorStartColor(int i) {
        this.mGradientIndicatorStartColor = i;
    }

    public void setGradientTextEndColorDef(int i) {
        this.mGradientTextEndColorDef = i;
    }

    public void setGradientTextStartColorDef(int i) {
        this.mGradientTextStartColorDef = i;
    }

    public void setIsClicked(boolean z) {
        this.mIsClicked = z;
    }

    public void setItemViewLayout(int i) {
        this.itemViewLayout = i;
    }

    public void setLeftEndPadding(int i) {
        this.leftEndPadding = i;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    public void setRightEndPadding(int i) {
        this.rightEndPadding = i;
    }

    public void setScrollAnimDuring(int i) {
        this.scrollAnimDuring = i;
    }

    public void setScrollRunnable(Runnable runnable) {
        this.scrollRunnable = runnable;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.mScrollViewListener = scrollViewListener;
    }

    public void setSliderWidthMax(float f) {
        this.mSliderWidthMax = f;
    }

    @Override // com.youku.style.IStyle
    public void setStyle(Map map) {
        this.mCurrentStyleMap = map;
        StyleVisitor styleVisitor = new StyleVisitor(this.mCurrentStyleMap);
        this.visitor = styleVisitor;
        if (this.mCurrentStyleMap != null) {
            int i = this.sTextColorSelected;
            int i2 = this.sTextColorDef;
            int i3 = this.sIndicatorColor;
            if (styleVisitor.hasStyleStringValue("navTextSelectColor")) {
                i = this.visitor.getStyleColor("navTextSelectColor", i);
                i3 = i;
            }
            if (this.visitor.hasStyleStringValue("navTextUnSelectColor")) {
                i2 = this.visitor.getStyleColor("navTextUnSelectColor", i2);
            }
            if (this.visitor.hasStyleStringValue(IStyle.NAV_INDICATOR_COLOR)) {
                i3 = this.visitor.getStyleColor(IStyle.NAV_INDICATOR_COLOR, i3);
            }
            setCustomClor(i2, i, i3);
        }
    }

    public void setTextAnimDuring(int i) {
        this.textAnimDuring = i;
    }

    public void setTextSelectedBottomPadding(int i) {
        this.mTextSelectedBottomPadding = i;
    }

    public void setTextSizeSelected(int i) {
        this.mTextSizeSelected = i;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.youku.resource.widget.YKTitleTabIndicator.AnonymousClass2 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    YKTitleTabIndicator.this.mIsClicked = false;
                }
                u91.a("YKTitleTabIndicator", " page state = " + i, new Object[0]);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabIndicator.this;
                yKTitleTabIndicator.currentPosition = i;
                yKTitleTabIndicator.currentPositionOffset = f;
                double d = (double) f;
                if (d > 0.05d && d < 0.95d) {
                    yKTitleTabIndicator.mIsClicked = false;
                }
                yKTitleTabIndicator.invalidate();
                YKTitleTabIndicator.this.scaleTab(false);
                u91.a("YKTitleTabIndicator", "position = " + i + " offset = " + f + " pxoff = " + i2, new Object[0]);
                YKTitleTabIndicator yKTitleTabIndicator2 = YKTitleTabIndicator.this;
                yKTitleTabIndicator2.mHandler.postDelayed(yKTitleTabIndicator2.scrollRunnable, 50);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                u91.a("YKTitleTabIndicator", "onPageSelected position:" + i + "  mClickedPosition:" + YKTitleTabIndicator.this.mClickedPosition, new Object[0]);
                YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabIndicator.this;
                yKTitleTabIndicator.mClickedPosition = i;
                yKTitleTabIndicator.adjustCenterPosition();
            }
        });
    }

    public void setmSliderRadius(float f) {
        this.mSliderRadius = f;
    }

    public void smoothScrollBySlow(int i, int i2, int i3) {
        this.mScroller.startScroll(getScrollX(), getScrollY(), i, i2, i3);
        invalidate();
    }

    public void smoothScrollToSlow(int i, int i2, int i3) {
        smoothScrollBySlow(i - getScrollX(), i2 - getScrollY(), i3);
    }

    public void updateTabs(List list) {
        int size = list.size();
        try {
            ArrayList arrayList = new ArrayList(32);
            for (int i = 0; i < size; i++) {
                if (this.mContainer.getChildCount() > i && ((YKTitleTabItemView) this.mContainer.getChildAt(i)).needUpdate(list.get(i))) {
                    YKTitleTabItemView tab = getTab(arrayList);
                    tab.mPosition = i;
                    tab.bindData(list.get(i));
                    ViewGroup.LayoutParams layoutParams = tab.getLayoutParams();
                    tab.setTag(list.get(i));
                    this.mContainer.removeViewAt(i);
                    this.mContainer.addView(tab, i, layoutParams);
                } else if (this.mContainer.getChildCount() <= i) {
                    YKTitleTabItemView tab2 = getTab(arrayList);
                    tab2.mPosition = i;
                    tab2.bindData(list.get(i));
                    ViewGroup.LayoutParams layoutParams2 = tab2.getLayoutParams();
                    tab2.setTag(list.get(i));
                    this.mContainer.addView(tab2, layoutParams2);
                }
            }
            if (this.mContainer.getChildCount() > size) {
                LinearLayout linearLayout = this.mContainer;
                linearLayout.removeViews(size, linearLayout.getChildCount() - size);
            }
            adjustTitleColor();
        } catch (Exception e) {
            u91.b("YKTitleTabIndicator", e.getLocalizedMessage(), new Object[0]);
        }
    }

    public YKTitleTabIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContainer = null;
        this.mDataList = new ArrayList();
        this.enableSmoothScroll = false;
        this.currentX = -99;
        this.scrollType = ScrollType.IDLE;
        this.currentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mClickedPosition = 0;
        this.mSliderCompat = 1.0f;
        this.mSliderWidthMin = 50.0f;
        this.mSliderWidthMax = 120.0f;
        this.mSliderHeightStill = 10;
        this.mSliderHeightMoving = 5;
        this.mScreenWidth = 800;
        this.mSliderBottomMargin = 4;
        this.mSliderRadius = 1.5f;
        this.mTextColorDef = SkinUtils.getTabTextColorDef();
        this.mTextColorSelected = SkinUtils.getTabTextColorSelected();
        this.mGradientTextStartColorDef = 0;
        this.mGradientTextEndColorDef = 0;
        this.mGradientIndicatorStartColor = SkinUtils.getTabIndicatorColorStartColor();
        this.mGradientIndicatorEndColor = SkinUtils.getTabIndicatorColorEndColor();
        this.mIndicatorColor = SkinUtils.getTabIndicatorColor();
        this.mTextSizeDef = 40;
        this.mTextSizeSelected = 40;
        this.rightEndPadding = 100;
        this.leftEndPadding = 0;
        this.itemViewLayout = 0;
        this.ableTextAnim = false;
        this.textAnimDuring = 200;
        this.scrollAnimDuring = 500;
        this.mTextSelectedBottomPadding = 11;
        this.scrollRunnable = new Runnable() {
            /* class com.youku.resource.widget.YKTitleTabIndicator.AnonymousClass1 */

            public void run() {
                int scrollX = YKTitleTabIndicator.this.getScrollX();
                YKTitleTabIndicator yKTitleTabIndicator = YKTitleTabIndicator.this;
                if (scrollX == yKTitleTabIndicator.currentX) {
                    ScrollType scrollType = ScrollType.IDLE;
                    yKTitleTabIndicator.scrollType = scrollType;
                    ScrollViewListener scrollViewListener = yKTitleTabIndicator.mScrollViewListener;
                    if (scrollViewListener != null) {
                        scrollViewListener.onScrollChanged(scrollType);
                    }
                    YKTitleTabIndicator.this.mHandler.removeCallbacks(this);
                    return;
                }
                ScrollType scrollType2 = ScrollType.FLING;
                yKTitleTabIndicator.scrollType = scrollType2;
                ScrollViewListener scrollViewListener2 = yKTitleTabIndicator.mScrollViewListener;
                if (scrollViewListener2 != null) {
                    scrollViewListener2.onScrollChanged(scrollType2);
                }
                YKTitleTabIndicator yKTitleTabIndicator2 = YKTitleTabIndicator.this;
                yKTitleTabIndicator2.currentX = yKTitleTabIndicator2.getScrollX();
                YKTitleTabIndicator.this.mHandler.postDelayed(this, 50);
            }
        };
        this.mCachedTabs = null;
        this.mCreateCachedTabsFinished = false;
        this.lg = null;
        this.isDefaultColor = true;
        this.mHandler = new Handler();
        setWillNotDraw(false);
        this.mContext = context;
        init(context, attributeSet, i);
        this.mContainer = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mContainer.setPadding(this.leftEndPadding, 0, this.rightEndPadding, 0);
        addView(this.mContainer, layoutParams);
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(2);
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.rectPaint.setColor(this.mIndicatorColor);
    }

    public void scaleTab() {
        scaleTab(true);
    }
}
