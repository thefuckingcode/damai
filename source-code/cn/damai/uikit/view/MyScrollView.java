package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import tb.s50;

/* compiled from: Taobao */
public class MyScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean b;
    private Context context;
    private float lastX;
    private float lastY;
    public ScrollYListener mScrollListener;
    private View view;
    private float xDistance;
    private float yDistance;

    /* compiled from: Taobao */
    public interface ScrollYListener {
        void onScroll(View view, int i);
    }

    public MyScrollView(Context context2) {
        super(context2);
        this.context = context2;
    }

    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801429423")) {
            ipChange.ipc$dispatch("-1801429423", new Object[]{this});
            return;
        }
        super.computeScroll();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944072016")) {
            return ((Boolean) ipChange.ipc$dispatch("-1944072016", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.xDistance += Math.abs(x - this.lastX);
            float abs = this.yDistance + Math.abs(y - this.lastY);
            this.yDistance = abs;
            this.lastX = x;
            this.lastY = y;
            if (this.xDistance > abs) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309545875")) {
            ipChange.ipc$dispatch("-309545875", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        if (this.view != null) {
            int a = s50.a(this.context, 176.0f);
            int a2 = s50.a(this.context, 4.0f);
            if (getScrollY() >= a) {
                this.view.setBackgroundColor(-1);
            } else if (getScrollY() <= a2) {
                this.view.setBackgroundResource(R$drawable.main_top_cover_bg);
            } else {
                String hexString = Integer.toHexString((int) ((((((double) getScrollY()) * 0.8d) / ((double) a)) * 255.0d) + 51.0d));
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                try {
                    this.view.setBackgroundColor(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + hexString + "ffffff"));
                } catch (Exception e) {
                    e.printStackTrace();
                    this.view.setBackgroundColor(Color.parseColor("#33ffffff"));
                }
            }
        }
        ScrollYListener scrollYListener = this.mScrollListener;
        if (scrollYListener != null) {
            scrollYListener.onScroll(this, getScrollY());
        }
    }

    public void setHeadAlpha(View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724976793")) {
            ipChange.ipc$dispatch("1724976793", new Object[]{this, view2});
            return;
        }
        this.view = view2;
    }

    public void setOnScrollYListener(ScrollYListener scrollYListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545281673")) {
            ipChange.ipc$dispatch("1545281673", new Object[]{this, scrollYListener});
            return;
        }
        this.mScrollListener = scrollYListener;
    }

    public MyScrollView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public MyScrollView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
    }
}
