package com.youku.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.StackView;
import androidx.viewpager.widget.ViewPager;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"NewApi"})
/* compiled from: Taobao */
public class YoukuHomePageStackView extends StackView {
    private static final int MSG_SLIDE = 10000110;
    private static final int PERIOD = 5000;
    public static final String TAG = "LXF";
    float dispatchDownXDistance = 0.0f;
    float dispatchDownYDistance = 0.0f;
    float dispatchUpXDistance = 0.0f;
    float dispatchUpYDistance = 0.0f;
    private Handler handler = new Handler() {
        /* class com.youku.widget.YoukuHomePageStackView.AnonymousClass1 */

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == YoukuHomePageStackView.MSG_SLIDE) {
                YoukuHomePageStackView.this.showNext();
                sendEmptyMessageDelayed(YoukuHomePageStackView.MSG_SLIDE, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
            }
        }
    };
    private boolean isAutoSlideMode;
    private TimerTask task;
    private Timer timer;
    private ViewPager viewPagerFragment;

    public YoukuHomePageStackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void cancleTask() {
        this.handler.removeMessages(MSG_SLIDE);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.viewPagerFragment = (ViewPager) getParent().getParent().getParent().getParent().getParent().getParent().getParent();
            this.dispatchDownXDistance = motionEvent.getX();
            this.dispatchDownYDistance = motionEvent.getY();
            cancleTask();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            this.dispatchUpXDistance = motionEvent.getX();
            float y = motionEvent.getY();
            this.dispatchUpYDistance = y;
            float f = this.dispatchUpXDistance;
            float f2 = this.dispatchDownXDistance;
            float f3 = f - f2;
            float f4 = f2 - f;
            float f5 = y - this.dispatchDownYDistance;
            getParent().requestDisallowInterceptTouchEvent(false);
            startAutoSlide();
            if (f3 > 100.0f && Math.abs(f5) < 30.0f) {
                this.viewPagerFragment.setCurrentItem(1);
                return false;
            } else if (f4 > 100.0f && Math.abs(f5) < 30.0f) {
                this.viewPagerFragment.setCurrentItem(3);
                return false;
            }
        } else if (action == 3) {
            startAutoSlide();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAutoSlide();
        } else {
            cancleTask();
        }
    }

    public void removeAllView() {
        removeAllViews();
    }

    public void startAutoSlide() {
        cancleTask();
        this.handler.sendEmptyMessageDelayed(MSG_SLIDE, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }
}
