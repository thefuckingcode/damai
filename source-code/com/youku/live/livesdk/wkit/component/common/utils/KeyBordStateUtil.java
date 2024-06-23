package com.youku.live.livesdk.wkit.component.common.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class KeyBordStateUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private onKeyBordStateListener listener;
    private int mFirstVisibleHeight;
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class com.youku.live.livesdk.wkit.component.common.utils.KeyBordStateUtil.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-509569149")) {
                ipChange.ipc$dispatch("-509569149", new Object[]{this});
                return;
            }
            KeyBordStateUtil.this.calKeyBordState();
        }
    };
    private int mVisibleHeight;
    private View rootLayout;

    /* compiled from: Taobao */
    public interface onKeyBordStateListener {
        void onSoftKeyBoardHide();

        void onSoftKeyBoardShow(int i);
    }

    public KeyBordStateUtil(Activity activity) {
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        this.rootLayout = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void calKeyBordState() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2007598169")) {
            ipChange.ipc$dispatch("-2007598169", new Object[]{this});
            return;
        }
        Rect rect = new Rect();
        this.rootLayout.getWindowVisibleDisplayFrame(rect);
        int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
        int i = this.mVisibleHeight;
        if (i == 0) {
            this.mVisibleHeight = height;
            this.mFirstVisibleHeight = height;
        } else if (i != height) {
            this.mVisibleHeight = height;
            int i2 = this.mFirstVisibleHeight;
            if (height < i2) {
                z = true;
            }
            if (z) {
                int abs = Math.abs(height - i2);
                onKeyBordStateListener onkeybordstatelistener = this.listener;
                if (onkeybordstatelistener != null) {
                    onkeybordstatelistener.onSoftKeyBoardShow(abs);
                    return;
                }
                return;
            }
            onKeyBordStateListener onkeybordstatelistener2 = this.listener;
            if (onkeybordstatelistener2 != null) {
                onkeybordstatelistener2.onSoftKeyBoardHide();
            }
        }
    }

    public void addOnKeyBordStateListener(onKeyBordStateListener onkeybordstatelistener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954390123")) {
            ipChange.ipc$dispatch("1954390123", new Object[]{this, onkeybordstatelistener});
            return;
        }
        this.listener = onkeybordstatelistener;
    }

    public void removeOnKeyBordStateListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1135675016")) {
            ipChange.ipc$dispatch("-1135675016", new Object[]{this});
            return;
        }
        View view = this.rootLayout;
        if (!(view == null || this.mOnGlobalLayoutListener == null)) {
            if (Build.VERSION.SDK_INT < 16) {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
            } else {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
            }
        }
        if (this.listener != null) {
            this.listener = null;
        }
    }
}
