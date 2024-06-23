package com.taobao.weex.ui.view.refresh.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar;

/* compiled from: Taobao */
public class WXRefreshView extends FrameLayout {
    private CircleProgressBar circleProgressBar;
    private LinearLayout linearLayout;

    public WXRefreshView(Context context) {
        super(context);
        setupViews();
    }

    private void setupViews() {
        this.linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.linearLayout.setOrientation(1);
        this.linearLayout.setGravity(17);
        addView(this.linearLayout, layoutParams);
    }

    public void setContentGravity(int i) {
        LinearLayout linearLayout2 = this.linearLayout;
        if (linearLayout2 != null) {
            linearLayout2.setGravity(i);
        }
    }

    public void setProgressBgColor(int i) {
        CircleProgressBar circleProgressBar2 = this.circleProgressBar;
        if (circleProgressBar2 != null) {
            circleProgressBar2.setBackgroundColor(i);
        }
    }

    public void setProgressColor(int i) {
        CircleProgressBar circleProgressBar2 = this.circleProgressBar;
        if (circleProgressBar2 != null) {
            circleProgressBar2.setColorSchemeColors(i);
        }
    }

    public void setProgressRotation(float f) {
        CircleProgressBar circleProgressBar2 = this.circleProgressBar;
        if (circleProgressBar2 != null) {
            circleProgressBar2.setProgressRotation(f);
        }
    }

    public void setRefreshView(final View view) {
        if (view != null) {
            post(WXThread.secure(new Runnable() {
                /* class com.taobao.weex.ui.view.refresh.core.WXRefreshView.AnonymousClass1 */

                public void run() {
                    View view = view;
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    int i = 0;
                    while (true) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        if (i < viewGroup.getChildCount()) {
                            View childAt = viewGroup.getChildAt(i);
                            if (childAt instanceof CircleProgressBar) {
                                WXRefreshView.this.circleProgressBar = (CircleProgressBar) childAt;
                            }
                            i++;
                        } else {
                            WXRefreshView.this.linearLayout.addView(view);
                            return;
                        }
                    }
                }
            }));
        }
    }

    public void setStartEndTrim(float f, float f2) {
        CircleProgressBar circleProgressBar2 = this.circleProgressBar;
        if (circleProgressBar2 != null) {
            circleProgressBar2.setStartEndTrim(f, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void startAnimation() {
        CircleProgressBar circleProgressBar2 = this.circleProgressBar;
        if (circleProgressBar2 != null) {
            circleProgressBar2.start();
        }
    }

    /* access modifiers changed from: protected */
    public void stopAnimation() {
        CircleProgressBar circleProgressBar2 = this.circleProgressBar;
        if (circleProgressBar2 != null) {
            circleProgressBar2.stop();
        }
    }

    public WXRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupViews();
    }

    public WXRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setupViews();
    }
}
