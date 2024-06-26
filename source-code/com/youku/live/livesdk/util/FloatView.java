package com.youku.live.livesdk.util;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v;

/* compiled from: Taobao */
public class FloatView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isAllowTouch = true;
    private IFloatViewClick listener;
    private float mTouchStartX;
    private float mTouchStartY;
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private float x;
    private float y;

    /* compiled from: Taobao */
    public interface IFloatViewClick {
        void onFloatViewClick();
    }

    public FloatView(Context context, int i, int i2, int i3) {
        super(context);
        init(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) null), i, i2);
    }

    private void init(View view, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172589729")) {
            ipChange.ipc$dispatch("172589729", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.wm = (WindowManager) getContext().getSystemService(v.ATTACH_MODE_WINDOW);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.wmParams = layoutParams;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.x = i;
        layoutParams.y = i2;
        if (view != null) {
            addView(view);
        }
    }

    public boolean addToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353611231")) {
            return ((Boolean) ipChange.ipc$dispatch("-353611231", new Object[]{this})).booleanValue();
        }
        if (this.wm != null) {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    if (getParent() == null) {
                        this.wm.addView(this, this.wmParams);
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (isAttachedToWindow()) {
                return false;
            } else {
                this.wm.addView(this, this.wmParams);
                return true;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1484177500")) {
            return this.isAllowTouch;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1484177500", new Object[]{this, motionEvent})).booleanValue();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "796857600")) {
            return ((Boolean) ipChange.ipc$dispatch("796857600", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchStartX = (float) (((int) motionEvent.getRawX()) - (getMeasuredWidth() / 2));
            this.mTouchStartY = (float) (((int) motionEvent.getRawY()) - (getMeasuredHeight() / 2));
            return true;
        } else if (action == 1) {
            this.y = (float) (((int) motionEvent.getRawY()) - (getMeasuredHeight() / 2));
            this.x = (float) (((int) motionEvent.getRawX()) - (getMeasuredWidth() / 2));
            if (Math.abs(this.y - this.mTouchStartY) > 10.0f || Math.abs(this.x - this.mTouchStartX) > 10.0f) {
                this.wm.updateViewLayout(this, this.wmParams);
            } else {
                IFloatViewClick iFloatViewClick = this.listener;
                if (iFloatViewClick != null) {
                    iFloatViewClick.onFloatViewClick();
                }
            }
            return true;
        } else if (action != 2) {
            return false;
        } else {
            this.wmParams.x = ((int) motionEvent.getRawX()) - (getMeasuredWidth() / 2);
            this.wmParams.y = ((int) motionEvent.getRawY()) - (getMeasuredHeight() / 2);
            if (Math.abs(((float) this.wmParams.y) - this.mTouchStartY) > 10.0f || Math.abs(((float) this.wmParams.x) - this.mTouchStartX) > 10.0f) {
                this.wm.updateViewLayout(this, this.wmParams);
            }
            return true;
        }
    }

    public boolean removeFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003664167")) {
            return ((Boolean) ipChange.ipc$dispatch("1003664167", new Object[]{this})).booleanValue();
        }
        if (this.wm != null) {
            if (Build.VERSION.SDK_INT < 19) {
                try {
                    if (getParent() != null) {
                        this.wm.removeViewImmediate(this);
                    }
                    return true;
                } catch (Exception unused) {
                }
            } else if (!isAttachedToWindow()) {
                return false;
            } else {
                this.wm.removeViewImmediate(this);
                return true;
            }
        }
        return false;
    }

    public void setFloatViewClickListener(IFloatViewClick iFloatViewClick) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892424955")) {
            ipChange.ipc$dispatch("-1892424955", new Object[]{this, iFloatViewClick});
            return;
        }
        this.listener = iFloatViewClick;
    }

    public void setIsAllowTouch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664087283")) {
            ipChange.ipc$dispatch("-664087283", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isAllowTouch = z;
    }

    public void updateFloatViewPosition(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140683976")) {
            ipChange.ipc$dispatch("2140683976", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        WindowManager.LayoutParams layoutParams = this.wmParams;
        layoutParams.x = i;
        layoutParams.y = i2;
        this.wm.updateViewLayout(this, layoutParams);
    }

    public FloatView(Context context, int i, int i2, View view) {
        super(context);
        init(view, i, i2);
    }
}
