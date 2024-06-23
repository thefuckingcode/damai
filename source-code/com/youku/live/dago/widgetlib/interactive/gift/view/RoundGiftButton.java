package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.view.progressring.ProgressRing;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;

/* compiled from: Taobao */
public class RoundGiftButton extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DURATION_PROGRESS_DOWN = 200;
    public static final int DURATION_PROGRESS_UP = 1000;
    public static final int DURATION_RIPPLE = 1000;
    public static final int MAX_PROGRESS = 360;
    private static final int MSG_START_COUNTDOWNNUM = 1;
    private static final int MSG_START_EVEN_SEND = 3;
    private static final int MSG_START_PROGRESS = 2;
    private int mComboCount = 1;
    private TextView mComboCountView;
    private ImageView mComboIcon;
    private FrameLayout mComboIconLayout;
    private int mComboInterval = 10;
    private LinearLayout mComboTextLayout;
    private Context mContext;
    private int mCountDownNowNum = 100;
    public int mCountInterval = 100;
    private TextView mCountNumView;
    private ProgressRing mCountdownProgressView;
    private Animation mGiftIconBreathAnim;
    private Handler mHandler = new Handler() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "350865893")) {
                ipChange.ipc$dispatch("350865893", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i == 1) {
                RoundGiftButton.this.doCountDownNum();
            } else if (i == 2) {
                RoundGiftButton.this.setStartProgress();
            }
        }
    };
    private String mIconUrl;
    private Listener mListener;
    private View mOutterBgView;
    private int mProgressPadding;
    private View mRelayoutBt;
    private ValueAnimator mValueAnimatorDown;
    private ValueAnimator mValueAnimatorUp;
    private boolean showIcon = false;

    /* compiled from: Taobao */
    public interface Listener {
        void onCombSend();

        void onCountDownEnd();
    }

    public RoundGiftButton(Context context) {
        super(context);
        initView(context);
    }

    private void doActionDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838911593")) {
            ipChange.ipc$dispatch("1838911593", new Object[]{this});
            return;
        }
        this.mHandler.removeMessages(1);
        reSetCountNum();
        startScaleAnm(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doCountDownNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1062483764")) {
            ipChange.ipc$dispatch("-1062483764", new Object[]{this});
        } else if (this.mCountDownNowNum != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.mCountInterval;
            this.mHandler.sendEmptyMessageAtTime(1, uptimeMillis + (((long) i) - (uptimeMillis % ((long) i))));
            if (this.mCountdownProgressView != null) {
                Log.d("liulei", "set progress = " + this.mCountDownNowNum);
                ProgressRing progressRing = this.mCountdownProgressView;
                int i2 = this.mCountDownNowNum;
                this.mCountDownNowNum = i2 + -1;
                progressRing.setProgress(i2);
            }
        } else {
            Log.e("liulei", "progress = 0, countdown END");
            reSet();
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onCountDownEnd();
            }
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1475615217")) {
            ipChange.ipc$dispatch("1475615217", new Object[]{this, context});
            return;
        }
        this.mProgressPadding = DensityUtil.dip2px(context, 3.0f);
        Context context2 = getContext();
        this.mContext = context2;
        LayoutInflater.from(context2).inflate(R.layout.dago_pgc_ykl_round_gift_bt, this);
        this.mCountNumView = (TextView) findViewById(R.id.countnum);
        this.mRelayoutBt = findViewById(R.id.rel_bt);
        this.mOutterBgView = findViewById(R.id.out_bg);
        this.mCountdownProgressView = (ProgressRing) findViewById(R.id.countdown_progress);
        this.mCountNumView.setText(String.valueOf(this.mCountDownNowNum));
        this.mRelayoutBt.setOnTouchListener(this);
        this.mComboTextLayout = (LinearLayout) findViewById(R.id.combo_bt_text);
        this.mComboIconLayout = (FrameLayout) findViewById(R.id.combo_bt_image);
        this.mComboIcon = (ImageView) findViewById(R.id.combo_gift_icon);
        this.mComboCountView = (TextView) findViewById(R.id.combo_gift_count);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStartProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1860735007")) {
            ipChange.ipc$dispatch("1860735007", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mValueAnimatorUp;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.mValueAnimatorUp = valueAnimator2;
            valueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
            this.mValueAnimatorUp.setIntValues(0, 360);
            this.mValueAnimatorUp.setDuration(1000L);
            this.mValueAnimatorUp.addUpdateListener(this);
            this.mValueAnimatorUp.start();
        } else if (!valueAnimator.isRunning()) {
            this.mValueAnimatorUp.start();
        }
    }

    private void startScaleAnm(int i) {
        ImageView imageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107216419")) {
            ipChange.ipc$dispatch("-107216419", new Object[]{this, Integer.valueOf(i)});
        } else if (this.showIcon && (imageView = this.mComboIcon) != null && i == 1) {
            imageView.startAnimation(this.mGiftIconBreathAnim);
        }
    }

    public void doActionUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18188976")) {
            ipChange.ipc$dispatch("-18188976", new Object[]{this});
            return;
        }
        startCountDownNum();
        startScaleAnm(1);
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onCombSend();
            this.mComboCount++;
        }
    }

    public View getComboBt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1000357596")) {
            return this.mRelayoutBt;
        }
        return (View) ipChange.ipc$dispatch("-1000357596", new Object[]{this});
    }

    public int getCountdownNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "244928358")) {
            return this.mCountDownNowNum;
        }
        return ((Integer) ipChange.ipc$dispatch("244928358", new Object[]{this})).intValue();
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701181084")) {
            ipChange.ipc$dispatch("-701181084", new Object[]{this, valueAnimator});
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2092868033")) {
            ipChange.ipc$dispatch("2092868033", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-553637700")) {
            ipChange.ipc$dispatch("-553637700", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1808884457")) {
            ipChange.ipc$dispatch("1808884457", new Object[]{this});
            return;
        }
        super.onFinishInflate();
        invalidate();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700898669")) {
            return ((Boolean) ipChange.ipc$dispatch("1700898669", new Object[]{this, view, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            doActionDown();
        } else if (action == 1) {
            doActionUp();
        }
        return true;
    }

    public void reSet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862189809")) {
            ipChange.ipc$dispatch("-1862189809", new Object[]{this});
            return;
        }
        reSetCountNum();
        this.mComboCount = 1;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void reSetCountNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1715142760")) {
            ipChange.ipc$dispatch("-1715142760", new Object[]{this});
            return;
        }
        this.mCountDownNowNum = 100;
    }

    public void setComboInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482867064")) {
            ipChange.ipc$dispatch("-482867064", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mComboInterval = i;
        this.mCountDownNowNum = i * 10;
        this.mCountInterval = (i * 1000) / 100;
        Log.d("liulei", "setComboInterval = " + this.mComboInterval);
        Log.d("liulei", "set mCountDownNowNum = " + this.mCountDownNowNum);
        Log.d("liulei", "set mCountInterval = " + this.mCountInterval);
    }

    public void setCountDownNowNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124385750")) {
            ipChange.ipc$dispatch("2124385750", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mCountDownNowNum = i;
    }

    public void setIconUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-510279742")) {
            ipChange.ipc$dispatch("-510279742", new Object[]{this, str});
            return;
        }
        DagoImageLoader.getInstance().showDefault(this.mContext, str, this.mComboIcon);
    }

    public void setListener(Listener listener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531221298")) {
            ipChange.ipc$dispatch("-1531221298", new Object[]{this, listener});
            return;
        }
        this.mListener = listener;
    }

    public void setShowIcon(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1398250418")) {
            ipChange.ipc$dispatch("-1398250418", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.showIcon = z;
        if (z) {
            this.mGiftIconBreathAnim = AnimationUtils.loadAnimation(getContext(), R.anim.dago_pgc_gift_icon_breath_anim);
            this.mOutterBgView.setBackgroundResource(R.drawable.dago_pgc_ykl_gift_serial_send_bt_bg);
            this.mComboIconLayout.setVisibility(0);
            this.mComboTextLayout.setVisibility(8);
            return;
        }
        this.mComboTextLayout.setVisibility(0);
        this.mComboIconLayout.setVisibility(8);
    }

    public void startCountDownNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1189812537")) {
            ipChange.ipc$dispatch("-1189812537", new Object[]{this});
            return;
        }
        Log.e("liulei", "START countDown = " + this.mCountDownNowNum);
        ProgressRing progressRing = this.mCountdownProgressView;
        int i = this.mCountDownNowNum;
        this.mCountDownNowNum = i + -1;
        progressRing.setProgress(i);
        long uptimeMillis = SystemClock.uptimeMillis();
        int i2 = this.mCountInterval;
        this.mHandler.sendEmptyMessageAtTime(1, uptimeMillis + (((long) i2) - (uptimeMillis % ((long) i2))));
    }

    public void startProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252350607")) {
            ipChange.ipc$dispatch("252350607", new Object[]{this});
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(2, 300);
    }

    public RoundGiftButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public RoundGiftButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
