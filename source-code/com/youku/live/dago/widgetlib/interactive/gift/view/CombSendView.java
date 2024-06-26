package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
public class CombSendView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int INTERVAL = 5000;
    private static final int STOP_COMB_SEND = 1;
    private static final String TAG = "CombSendView";
    private int mCombNum = 0;
    private Button mCombSendBtn;
    private Context mContext;
    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.AnonymousClass2 */
        private static transient /* synthetic */ IpChange $ipChange;

        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1806462835")) {
                return ((Boolean) ipChange.ipc$dispatch("1806462835", new Object[]{this, view, motionEvent})).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                CombSendView.this.touchDown();
            } else if (action == 1) {
                CombSendView.this.touchUp(0);
            }
            return false;
        }
    };
    private Animation mRotateAnim;
    private ImageView mRotateView;
    private OnCombSendListener onCombSendListener;
    @SuppressLint({"HandlerLeak"})
    public Handler weakHandler = new Handler() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1415853869")) {
                ipChange.ipc$dispatch("1415853869", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            if (message.what == 1) {
                CombSendView.this.stopCombSend();
            }
        }
    };

    /* compiled from: Taobao */
    public interface OnCombSendListener {
        void onCombSend(int i);

        void onCombSendEnd();

        void onTouchDown();
    }

    public CombSendView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395771247")) {
            ipChange.ipc$dispatch("395771247", new Object[]{this});
            return;
        }
        Context context = getContext();
        this.mContext = context;
        View.inflate(context, R.layout.dago_pgc_combsend, this);
        this.mCombSendBtn = (Button) findViewById(R.id.comb_send_btn);
        this.mRotateView = (ImageView) findViewById(R.id.comb_loading_view);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.dago_pgc_combsend_progress);
        this.mRotateAnim = loadAnimation;
        loadAnimation.setInterpolator(new LinearInterpolator());
        this.mCombSendBtn.setOnTouchListener(this.mOnTouchListener);
    }

    private void stopRotateAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "38545334")) {
            ipChange.ipc$dispatch("38545334", new Object[]{this});
            return;
        }
        ImageView imageView = this.mRotateView;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void touchDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427049797")) {
            ipChange.ipc$dispatch("427049797", new Object[]{this});
            return;
        }
        Handler handler = this.weakHandler;
        if (handler != null) {
            handler.removeMessages(1);
        }
        this.onCombSendListener.onTouchDown();
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162507831")) {
            ipChange.ipc$dispatch("162507831", new Object[]{this});
            return;
        }
        stopRotateAnim();
        Handler handler = this.weakHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void setOnCombSendListener(OnCombSendListener onCombSendListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430644696")) {
            ipChange.ipc$dispatch("-1430644696", new Object[]{this, onCombSendListener2});
            return;
        }
        this.onCombSendListener = onCombSendListener2;
    }

    public void startRotateAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816381400")) {
            ipChange.ipc$dispatch("1816381400", new Object[]{this});
            return;
        }
        Animation animation = this.mRotateAnim;
        if (animation != null) {
            this.mRotateView.startAnimation(animation);
            return;
        }
        this.mRotateView.setAnimation(animation);
        this.mRotateView.startAnimation(this.mRotateAnim);
    }

    public void stopCombSend() {
        OnCombSendListener onCombSendListener2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443477063")) {
            ipChange.ipc$dispatch("-1443477063", new Object[]{this});
        } else if (this.weakHandler != null && (onCombSendListener2 = this.onCombSendListener) != null) {
            onCombSendListener2.onCombSendEnd();
            this.mCombNum = 0;
            reset();
        }
    }

    public void touchUp(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360458583")) {
            ipChange.ipc$dispatch("360458583", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Handler handler = this.weakHandler;
        if (handler == null || this.onCombSendListener == null || 1 == i) {
            this.onCombSendListener.onCombSend(0);
            return;
        }
        handler.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        int i2 = this.mCombNum + 1;
        this.mCombNum = i2;
        this.onCombSendListener.onCombSend(i2);
        startRotateAnim();
    }

    public CombSendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public CombSendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
