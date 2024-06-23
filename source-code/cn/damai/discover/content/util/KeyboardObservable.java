package cn.damai.discover.content.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class KeyboardObservable {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private boolean b = true;
    private OnSoftKeyboardChangeListener c;

    /* compiled from: Taobao */
    public interface OnSoftKeyboardChangeListener {
        void onSoftKeyBoardChange(int i, boolean z);
    }

    /* compiled from: Taobao */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "1211756692")) {
                ipChange.ipc$dispatch("1211756692", new Object[]{this});
                return;
            }
            Rect rect = new Rect();
            KeyboardObservable.this.a.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int height = KeyboardObservable.this.a.getHeight();
            int i2 = height - i;
            if (((double) i) / ((double) height) > 0.8d) {
                z = true;
            }
            if (KeyboardObservable.this.b != z) {
                KeyboardObservable.this.b = z;
                if (KeyboardObservable.this.c != null) {
                    KeyboardObservable.this.c.onSoftKeyBoardChange(i2, !z);
                }
            }
        }
    }

    public void e(Activity activity, OnSoftKeyboardChangeListener onSoftKeyboardChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-787620855")) {
            ipChange.ipc$dispatch("-787620855", new Object[]{this, activity, onSoftKeyboardChangeListener});
        } else if (activity != null && activity.getWindow() != null) {
            this.c = onSoftKeyboardChangeListener;
            View decorView = activity.getWindow().getDecorView();
            this.a = decorView;
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        }
    }
}
