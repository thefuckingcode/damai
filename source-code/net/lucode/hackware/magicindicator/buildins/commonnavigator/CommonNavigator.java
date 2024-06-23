package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.NavigatorHelper;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;
import net.lucode.hackware.magicindicator.abs.IPagerNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import tb.ok;
import tb.sr1;

/* compiled from: Taobao */
public class CommonNavigator extends FrameLayout implements NavigatorHelper.OnNavigatorScrollListener, IPagerNavigator {
    private ok mAdapter;
    private boolean mAdjustMode;
    private boolean mEnablePivotScroll;
    private boolean mFollowTouch = true;
    private IPagerIndicator mIndicator;
    private LinearLayout mIndicatorContainer;
    private boolean mIndicatorOnTop;
    private int mLeftPadding;
    private NavigatorHelper mNavigatorHelper;
    private DataSetObserver mObserver = new a();
    private List<sr1> mPositionDataList = new ArrayList();
    private boolean mReselectWhenLayout = true;
    private int mRightPadding;
    private float mScrollPivotX = 0.5f;
    private HorizontalScrollView mScrollView;
    private boolean mSkimOver;
    private boolean mSmoothScroll = true;
    private LinearLayout mTitleContainer;

    /* compiled from: Taobao */
    class a extends DataSetObserver {
        a() {
        }

        public void onChanged() {
            CommonNavigator.this.mNavigatorHelper.m(CommonNavigator.this.mAdapter.a());
            CommonNavigator.this.init();
        }

        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        NavigatorHelper navigatorHelper = new NavigatorHelper();
        this.mNavigatorHelper = navigatorHelper;
        navigatorHelper.k(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void init() {
        View view;
        removeAllViews();
        if (this.mAdjustMode) {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        }
        this.mScrollView = (HorizontalScrollView) view.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.title_container);
        this.mTitleContainer = linearLayout;
        linearLayout.setPadding(this.mLeftPadding, 0, this.mRightPadding, 0);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.indicator_container);
        this.mIndicatorContainer = linearLayout2;
        if (this.mIndicatorOnTop) {
            linearLayout2.getParent().bringChildToFront(this.mIndicatorContainer);
        }
        initTitlesAndIndicator();
    }

    private void initTitlesAndIndicator() {
        LinearLayout.LayoutParams layoutParams;
        int g = this.mNavigatorHelper.g();
        for (int i = 0; i < g; i++) {
            IPagerTitleView c = this.mAdapter.c(getContext(), i);
            if (c instanceof View) {
                View view = (View) c;
                if (this.mAdjustMode) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.mAdapter.d(getContext(), i);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.mTitleContainer.addView(view, layoutParams);
            }
        }
        ok okVar = this.mAdapter;
        if (okVar != null) {
            IPagerIndicator b = okVar.b(getContext());
            this.mIndicator = b;
            if (b instanceof View) {
                this.mIndicatorContainer.addView((View) this.mIndicator, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void preparePositionData() {
        this.mPositionDataList.clear();
        int g = this.mNavigatorHelper.g();
        for (int i = 0; i < g; i++) {
            sr1 sr1 = new sr1();
            View childAt = this.mTitleContainer.getChildAt(i);
            if (childAt != null) {
                sr1.a = childAt.getLeft();
                sr1.b = childAt.getTop();
                sr1.c = childAt.getRight();
                int bottom = childAt.getBottom();
                sr1.d = bottom;
                if (childAt instanceof IMeasurablePagerTitleView) {
                    IMeasurablePagerTitleView iMeasurablePagerTitleView = (IMeasurablePagerTitleView) childAt;
                    sr1.e = iMeasurablePagerTitleView.getContentLeft();
                    sr1.f = iMeasurablePagerTitleView.getContentTop();
                    sr1.g = iMeasurablePagerTitleView.getContentRight();
                    sr1.h = iMeasurablePagerTitleView.getContentBottom();
                } else {
                    sr1.e = sr1.a;
                    sr1.f = sr1.b;
                    sr1.g = sr1.c;
                    sr1.h = bottom;
                }
            }
            this.mPositionDataList.add(sr1);
        }
    }

    public ok getAdapter() {
        return this.mAdapter;
    }

    public int getLeftPadding() {
        return this.mLeftPadding;
    }

    public IPagerIndicator getPagerIndicator() {
        return this.mIndicator;
    }

    public IPagerTitleView getPagerTitleView(int i) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout == null) {
            return null;
        }
        return (IPagerTitleView) linearLayout.getChildAt(i);
    }

    public int getRightPadding() {
        return this.mRightPadding;
    }

    public float getScrollPivotX() {
        return this.mScrollPivotX;
    }

    public LinearLayout getTitleContainer() {
        return this.mTitleContainer;
    }

    public boolean isAdjustMode() {
        return this.mAdjustMode;
    }

    public boolean isEnablePivotScroll() {
        return this.mEnablePivotScroll;
    }

    public boolean isFollowTouch() {
        return this.mFollowTouch;
    }

    public boolean isIndicatorOnTop() {
        return this.mIndicatorOnTop;
    }

    public boolean isReselectWhenLayout() {
        return this.mReselectWhenLayout;
    }

    public boolean isSkimOver() {
        return this.mSkimOver;
    }

    public boolean isSmoothScroll() {
        return this.mSmoothScroll;
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void notifyDataSetChanged() {
        ok okVar = this.mAdapter;
        if (okVar != null) {
            okVar.e();
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onAttachToMagicIndicator() {
        init();
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onDeselected(int i, int i2) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onDeselected(i, i2);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onDetachFromMagicIndicator() {
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onEnter(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onEnter(i, i2, f, z);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter != null) {
            preparePositionData();
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPositionDataProvide(this.mPositionDataList);
            }
            if (this.mReselectWhenLayout && this.mNavigatorHelper.f() == 0) {
                onPageSelected(this.mNavigatorHelper.e());
                onPageScrolled(this.mNavigatorHelper.e(), 0.0f, 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onLeave(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onLeave(i, i2, f, z);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onPageScrollStateChanged(int i) {
        if (this.mAdapter != null) {
            this.mNavigatorHelper.h(i);
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPageScrollStateChanged(i);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onPageScrolled(int i, float f, int i2) {
        if (this.mAdapter != null) {
            this.mNavigatorHelper.i(i, f, i2);
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPageScrolled(i, f, i2);
            }
            if (this.mScrollView != null && this.mPositionDataList.size() > 0 && i >= 0 && i < this.mPositionDataList.size() && this.mFollowTouch) {
                int min = Math.min(this.mPositionDataList.size() - 1, i);
                int min2 = Math.min(this.mPositionDataList.size() - 1, i + 1);
                float a2 = ((float) this.mPositionDataList.get(min).a()) - (((float) this.mScrollView.getWidth()) * this.mScrollPivotX);
                this.mScrollView.scrollTo((int) (a2 + (((((float) this.mPositionDataList.get(min2).a()) - (((float) this.mScrollView.getWidth()) * this.mScrollPivotX)) - a2) * f)), 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.abs.IPagerNavigator
    public void onPageSelected(int i) {
        if (this.mAdapter != null) {
            this.mNavigatorHelper.j(i);
            IPagerIndicator iPagerIndicator = this.mIndicator;
            if (iPagerIndicator != null) {
                iPagerIndicator.onPageSelected(i);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.NavigatorHelper.OnNavigatorScrollListener
    public void onSelected(int i, int i2) {
        LinearLayout linearLayout = this.mTitleContainer;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).onSelected(i, i2);
            }
            if (!this.mAdjustMode && !this.mFollowTouch && this.mScrollView != null && this.mPositionDataList.size() > 0) {
                sr1 sr1 = this.mPositionDataList.get(Math.min(this.mPositionDataList.size() - 1, i));
                if (this.mEnablePivotScroll) {
                    float a2 = ((float) sr1.a()) - (((float) this.mScrollView.getWidth()) * this.mScrollPivotX);
                    if (this.mSmoothScroll) {
                        this.mScrollView.smoothScrollTo((int) a2, 0);
                    } else {
                        this.mScrollView.scrollTo((int) a2, 0);
                    }
                } else {
                    int scrollX = this.mScrollView.getScrollX();
                    int i3 = sr1.a;
                    if (scrollX <= i3) {
                        int scrollX2 = this.mScrollView.getScrollX() + getWidth();
                        int i4 = sr1.c;
                        if (scrollX2 >= i4) {
                            return;
                        }
                        if (this.mSmoothScroll) {
                            this.mScrollView.smoothScrollTo(i4 - getWidth(), 0);
                        } else {
                            this.mScrollView.scrollTo(i4 - getWidth(), 0);
                        }
                    } else if (this.mSmoothScroll) {
                        this.mScrollView.smoothScrollTo(i3, 0);
                    } else {
                        this.mScrollView.scrollTo(i3, 0);
                    }
                }
            }
        }
    }

    public void setAdapter(ok okVar) {
        ok okVar2 = this.mAdapter;
        if (okVar2 != okVar) {
            if (okVar2 != null) {
                okVar2.g(this.mObserver);
            }
            this.mAdapter = okVar;
            if (okVar != null) {
                okVar.f(this.mObserver);
                this.mNavigatorHelper.m(this.mAdapter.a());
                if (this.mTitleContainer != null) {
                    this.mAdapter.e();
                    return;
                }
                return;
            }
            this.mNavigatorHelper.m(0);
            init();
        }
    }

    public void setAdjustMode(boolean z) {
        this.mAdjustMode = z;
    }

    public void setEnablePivotScroll(boolean z) {
        this.mEnablePivotScroll = z;
    }

    public void setFollowTouch(boolean z) {
        this.mFollowTouch = z;
    }

    public void setIndicatorOnTop(boolean z) {
        this.mIndicatorOnTop = z;
    }

    public void setLeftPadding(int i) {
        this.mLeftPadding = i;
    }

    public void setReselectWhenLayout(boolean z) {
        this.mReselectWhenLayout = z;
    }

    public void setRightPadding(int i) {
        this.mRightPadding = i;
    }

    public void setScrollPivotX(float f) {
        this.mScrollPivotX = f;
    }

    public void setSkimOver(boolean z) {
        this.mSkimOver = z;
        this.mNavigatorHelper.l(z);
    }

    public void setSmoothScroll(boolean z) {
        this.mSmoothScroll = z;
    }
}
