package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;

/* compiled from: Taobao */
public class SendGiftButton extends RelativeLayout implements View.OnTouchListener, RoundGiftButton.Listener {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isCombo;
    boolean isNotCost = false;
    private boolean isSetState = false;
    private Context mContext;
    private OnSendListener mOnSendListener;
    private RoundGiftButton mRoundBt;
    private Button mTvSend;

    /* compiled from: Taobao */
    public interface OnSendListener {
        boolean checkCost();

        void onCombSend();

        void onRenew();

        void onSend();
    }

    public SendGiftButton(Context context) {
        super(context);
        initView();
    }

    private boolean checkNet() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1669047119")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("1669047119", new Object[]{this})).booleanValue();
    }

    private void doActionDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-983178339")) {
            ipChange.ipc$dispatch("-983178339", new Object[]{this});
            return;
        }
        RoundGiftButton roundGiftButton = this.mRoundBt;
        if (roundGiftButton != null) {
            roundGiftButton.reSet();
            this.mRoundBt.setVisibility(0);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f);
            ObjectAnimator.ofPropertyValuesHolder(this.mRoundBt, ofFloat).setDuration(100L).start();
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1463317781")) {
            ipChange.ipc$dispatch("-1463317781", new Object[]{this});
            return;
        }
        Context context = getContext();
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_send_gift_layout_button, this);
        Button button = (Button) findViewById(R.id.sendBt);
        this.mTvSend = button;
        button.setOnTouchListener(this);
        RoundGiftButton roundGiftButton = (RoundGiftButton) findViewById(R.id.roundBt);
        this.mRoundBt = roundGiftButton;
        roundGiftButton.setListener(this);
        this.mTvSend.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftButton.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1037977310")) {
                    ipChange.ipc$dispatch("1037977310", new Object[]{this, view});
                    return;
                }
                SendGiftButton.this.mOnSendListener.onSend();
            }
        });
    }

    public int getCountdownNum() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1348583346")) {
            return ((Integer) ipChange.ipc$dispatch("1348583346", new Object[]{this})).intValue();
        }
        RoundGiftButton roundGiftButton = this.mRoundBt;
        if (roundGiftButton != null) {
            return roundGiftButton.getCountdownNum();
        }
        return 100;
    }

    public View getRoundBt() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1189194840")) {
            return this.mRoundBt.getComboBt();
        }
        return (View) ipChange.ipc$dispatch("1189194840", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton.Listener
    public void onCombSend() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187968008")) {
            ipChange.ipc$dispatch("-187968008", new Object[]{this});
            return;
        }
        this.mOnSendListener.onCombSend();
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.view.RoundGiftButton.Listener
    public void onCountDownEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718900809")) {
            ipChange.ipc$dispatch("-718900809", new Object[]{this});
            return;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mRoundBt, ofFloat);
        ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftButton.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onAnimationEnd(Animator animator) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-992487275")) {
                    ipChange.ipc$dispatch("-992487275", new Object[]{this, animator});
                    return;
                }
                SendGiftButton.this.mRoundBt.setVisibility(8);
                SendGiftButton.this.mOnSendListener.onRenew();
            }
        });
        ofPropertyValuesHolder.setDuration(100L).start();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1200848651")) {
            ipChange.ipc$dispatch("-1200848651", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732528376")) {
            ipChange.ipc$dispatch("-732528376", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        RoundGiftButton roundGiftButton;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "698726049")) {
            return ((Boolean) ipChange.ipc$dispatch("698726049", new Object[]{this, view, motionEvent})).booleanValue();
        }
        if (!this.isCombo) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            doActionDown();
        } else if (action != 1 || (roundGiftButton = this.mRoundBt) == null || this.isNotCost) {
            return true;
        } else {
            roundGiftButton.doActionUp();
        }
        return true;
    }

    public void reSet() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101388197")) {
            ipChange.ipc$dispatch("-2101388197", new Object[]{this});
            return;
        }
        this.mRoundBt.reSet();
        if (this.mRoundBt.getVisibility() == 0) {
            onCountDownEnd();
        }
    }

    public void setBtnText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-868340355")) {
            ipChange.ipc$dispatch("-868340355", new Object[]{this, charSequence});
            return;
        }
        this.mTvSend.setText(charSequence);
    }

    public void setCombo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1842980800")) {
            ipChange.ipc$dispatch("-1842980800", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCombo = z;
    }

    public void setComboInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-727345708")) {
            ipChange.ipc$dispatch("-727345708", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        RoundGiftButton roundGiftButton = this.mRoundBt;
        if (roundGiftButton != null) {
            roundGiftButton.setComboInterval(i);
        }
    }

    public void setOnSendListener(OnSendListener onSendListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562102464")) {
            ipChange.ipc$dispatch("1562102464", new Object[]{this, onSendListener});
            return;
        }
        this.mOnSendListener = onSendListener;
    }

    public void setSendBtnNormal() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1553590983")) {
            ipChange.ipc$dispatch("1553590983", new Object[]{this});
            return;
        }
        this.isSetState = false;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTvSend.getLayoutParams();
        layoutParams.width = DensityUtil.dip2px(this.mContext, 50.0f);
        layoutParams.height = DensityUtil.dip2px(this.mContext, 25.0f);
        layoutParams.setMargins(layoutParams.leftMargin, 0, DensityUtil.dip2px(this.mContext, 12.0f), DensityUtil.dip2px(this.mContext, 17.0f));
        this.mTvSend.setLayoutParams(layoutParams);
        this.mTvSend.setTextColor(Color.parseColor("#4dffffff"));
        this.mTvSend.setBackgroundResource(R.drawable.dago_pgc_ykl_send_gift_d_3);
    }

    public void setSendBtnSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398983534")) {
            ipChange.ipc$dispatch("-398983534", new Object[]{this});
        } else if (!this.isSetState) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTvSend.getLayoutParams();
            int dip2px = DensityUtil.dip2px(this.mContext, 70.0f);
            layoutParams.height = dip2px;
            layoutParams.width = dip2px;
            layoutParams.setMargins(layoutParams.leftMargin, DensityUtil.dip2px(this.mContext, 5.0f), 0, 0);
            this.mTvSend.setLayoutParams(layoutParams);
            this.mTvSend.setTextColor(Color.parseColor("#D9000000"));
            this.mTvSend.setBackgroundResource(R.drawable.dago_pgc_ykl_send_gift_d_1);
            this.mTvSend.setBackgroundResource(R.drawable.dago_pgc_ykl_send_gift_d_2);
            this.isSetState = true;
        }
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423378365")) {
            ipChange.ipc$dispatch("-1423378365", new Object[]{this});
            return;
        }
        doActionDown();
        this.mRoundBt.startCountDownNum();
    }

    public SendGiftButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public SendGiftButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
