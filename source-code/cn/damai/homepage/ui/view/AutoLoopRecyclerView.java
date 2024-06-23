package cn.damai.homepage.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
public class AutoLoopRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long TIME_AUTO_LOOP = 3000;
    private AutoLoopTask autoLoopTask = new AutoLoopTask(this);
    private boolean autoPlay;
    private int currentIndex = 0;
    private long interval = 3000;
    private int itemCount = 1;
    private int lastY = 0;
    private final int mTouchSlop;
    private OnPageChangeListener onPageChangeListener;
    private boolean running;

    /* compiled from: Taobao */
    public static class AutoLoopTask implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final WeakReference<AutoLoopRecyclerView> mReference;

        public AutoLoopTask(AutoLoopRecyclerView autoLoopRecyclerView) {
            this.mReference = new WeakReference<>(autoLoopRecyclerView);
        }

        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1331771374")) {
                ipChange.ipc$dispatch("-1331771374", new Object[]{this});
                return;
            }
            AutoLoopRecyclerView autoLoopRecyclerView = this.mReference.get();
            if (autoLoopRecyclerView != null && autoLoopRecyclerView.isRunning() && autoLoopRecyclerView.isAutoPlay()) {
                autoLoopRecyclerView.smoothScrollToPosition(autoLoopRecyclerView.increaseCurrentIndex());
                OnPageChangeListener onPageChangeListener = autoLoopRecyclerView.getOnPageChangeListener();
                if (onPageChangeListener != null) {
                    onPageChangeListener.onChange(autoLoopRecyclerView.getChildAt(autoLoopRecyclerView.getCurrentIndex()), autoLoopRecyclerView.getCurrentIndex() % autoLoopRecyclerView.getItemCount());
                }
                autoLoopRecyclerView.postDelayed(autoLoopRecyclerView.autoLoopTask, autoLoopRecyclerView.getInterval());
            }
        }
    }

    /* compiled from: Taobao */
    public interface OnPageChangeListener {
        void onChange(View view, int i);
    }

    public AutoLoopRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1930413371")) {
            return ((Boolean) ipChange.ipc$dispatch("-1930413371", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastY = (int) motionEvent.getRawY();
            if (this.running) {
                stop();
            }
        } else if (action == 1 || action == 3 || action == 4) {
            int rawY = (int) motionEvent.getRawY();
            int i2 = this.lastY;
            int i3 = rawY - i2;
            int i4 = this.mTouchSlop;
            if (i3 > i4) {
                int i5 = this.currentIndex;
                if (i5 != 0) {
                    i = i5 - 1;
                    this.currentIndex = i;
                }
                smoothScrollToPosition(i);
                if (this.autoPlay) {
                    start();
                }
                return true;
            } else if (i2 - rawY > i4) {
                int i6 = this.currentIndex + 1;
                this.currentIndex = i6;
                smoothScrollToPosition(i6);
                if (this.autoPlay) {
                    start();
                }
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentIndex() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "500125741")) {
            return this.currentIndex;
        }
        return ((Integer) ipChange.ipc$dispatch("500125741", new Object[]{this})).intValue();
    }

    public long getInterval() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1704354242")) {
            return this.interval;
        }
        return ((Long) ipChange.ipc$dispatch("1704354242", new Object[]{this})).longValue();
    }

    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1172004178")) {
            return this.itemCount;
        }
        return ((Integer) ipChange.ipc$dispatch("-1172004178", new Object[]{this})).intValue();
    }

    public OnPageChangeListener getOnPageChangeListener() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "628148136")) {
            return this.onPageChangeListener;
        }
        return (OnPageChangeListener) ipChange.ipc$dispatch("628148136", new Object[]{this});
    }

    public int increaseCurrentIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874568537")) {
            return ((Integer) ipChange.ipc$dispatch("874568537", new Object[]{this})).intValue();
        }
        int i = this.currentIndex + 1;
        this.currentIndex = i;
        return i;
    }

    public boolean isAutoPlay() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "27214488")) {
            return this.autoPlay;
        }
        return ((Boolean) ipChange.ipc$dispatch("27214488", new Object[]{this})).booleanValue();
    }

    public boolean isRunning() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1273665944")) {
            return this.running;
        }
        return ((Boolean) ipChange.ipc$dispatch("1273665944", new Object[]{this})).booleanValue();
    }

    public void setAutoPlay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1185972112")) {
            ipChange.ipc$dispatch("1185972112", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.autoPlay = z;
    }

    public void setCurrentIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1075298069")) {
            ipChange.ipc$dispatch("1075298069", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.currentIndex = i;
    }

    public void setInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088811007")) {
            ipChange.ipc$dispatch("-2088811007", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.interval = (long) i;
    }

    public void setItemCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "491163164")) {
            ipChange.ipc$dispatch("491163164", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.itemCount = i;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "105035234")) {
            ipChange.ipc$dispatch("105035234", new Object[]{this, onPageChangeListener2});
            return;
        }
        this.onPageChangeListener = onPageChangeListener2;
    }

    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594223431")) {
            ipChange.ipc$dispatch("594223431", new Object[]{this});
            return;
        }
        if (this.running) {
            stop();
        }
        this.autoPlay = true;
        this.running = true;
        postDelayed(this.autoLoopTask, this.interval);
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "31965247")) {
            ipChange.ipc$dispatch("31965247", new Object[]{this});
            return;
        }
        this.running = false;
        removeCallbacks(this.autoLoopTask);
    }
}
