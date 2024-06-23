package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class NestViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mLastY = 0.0f;

    public NestViewPager(Context context) {
        super(context, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r0 != 3) goto L_0x0049;
     */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966386925")) {
            return ((Boolean) ipChange.ipc$dispatch("966386925", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.mLastY = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public NestViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
