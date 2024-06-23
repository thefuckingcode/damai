package com.youku.live.dago.widgetlib.interactive.gift.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;

/* compiled from: Taobao */
public class ParticleSendGiftButton extends RelativeLayout implements View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int MAX_PROGRESS = 100;
    private final int PROGRESS = 3;
    private final int PROGRESS_INTERVAL = 25;
    private int beginProgress = 0;
    private boolean canSend = true;
    private boolean comboSend = false;
    private int giftType;
    private boolean isCombo = true;
    private boolean isOldSend;
    private boolean isSending = false;
    private boolean isSetState = false;
    private boolean mCanCombo;
    public CombSendView mCombSendView;
    private int mComboCount = 0;
    private int mComboInterval = 25;
    private Context mContext;
    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new Handler() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "70747083")) {
                ipChange.ipc$dispatch("70747083", new Object[]{this, message});
            } else if (message.what == 3) {
                ParticleSendGiftButton.this.oldDoProgress();
            }
        }
    };
    private OnSendListener mOnSendListener;
    private LinearProgressSendButton mSendBtn;
    private CombSendView.OnCombSendListener onCombSendListener = new CombSendView.OnCombSendListener() {
        /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass4 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
        public void onCombSend(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "275882581")) {
                ipChange.ipc$dispatch("275882581", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            ParticleSendGiftButton.this.mOnSendListener.onCombSend(i);
            ParticleSendGiftButton.this.isSending = true;
        }

        @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
        public void onCombSendEnd() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-298681535")) {
                ipChange.ipc$dispatch("-298681535", new Object[]{this});
                return;
            }
            ParticleSendGiftButton.this.mOnSendListener.onRenew();
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mCombSendView, ofFloat, ofFloat2, ofFloat3);
            ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass4.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1264883318")) {
                        ipChange.ipc$dispatch("-1264883318", new Object[]{this, animator});
                        return;
                    }
                    ParticleSendGiftButton.this.mCombSendView.setVisibility(8);
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f);
                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f);
                    PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mSendBtn, ofFloat, ofFloat2, ofFloat3);
                    ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                        /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass4.AnonymousClass1.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onAnimationEnd(Animator animator) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1854561897")) {
                                ipChange.ipc$dispatch("-1854561897", new Object[]{this, animator});
                            }
                        }
                    });
                    ofPropertyValuesHolder.setDuration(200L).start();
                }
            });
            ofPropertyValuesHolder.setDuration(200L).start();
            ParticleSendGiftButton.this.mSendBtn.setVisibility(0);
            ParticleSendGiftButton.this.isSending = false;
        }

        @Override // com.youku.live.dago.widgetlib.interactive.gift.view.CombSendView.OnCombSendListener
        public void onTouchDown() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2139583022")) {
                ipChange.ipc$dispatch("-2139583022", new Object[]{this});
                return;
            }
            ParticleSendGiftButton.this.mOnSendListener.onTouchDown();
        }
    };

    /* compiled from: Taobao */
    public interface OnSendListener {
        boolean checkCost();

        void onCombSend(int i);

        void onRenew();

        void onSend();

        void onTouchDown();
    }

    public ParticleSendGiftButton(Context context) {
        super(context);
        initView();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean checkNet() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "752223221")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("752223221", new Object[]{this})).booleanValue();
    }

    private void doActionDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548517053")) {
            ipChange.ipc$dispatch("-1548517053", new Object[]{this});
        } else if (1 != this.giftType) {
            if (this.isOldSend) {
                resetProgress(false);
                return;
            }
            this.mCombSendView.reset();
            this.mCombSendView.setVisibility(0);
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f);
            PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f);
            PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mSendBtn, ofFloat, ofFloat2, ofFloat3);
            ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "383711292")) {
                        ipChange.ipc$dispatch("383711292", new Object[]{this, animator});
                        return;
                    }
                    ParticleSendGiftButton.this.mSendBtn.setVisibility(4);
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f);
                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f);
                    PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ParticleSendGiftButton.this.mCombSendView, ofFloat2, ofFloat3, ofFloat);
                    ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                        /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass3.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onAnimationEnd(Animator animator) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1896893385")) {
                                ipChange.ipc$dispatch("1896893385", new Object[]{this, animator});
                            }
                        }
                    });
                    ofPropertyValuesHolder.setDuration(200L).start();
                }
            });
            ofPropertyValuesHolder.setDuration(50L).start();
        }
    }

    private void doActionUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1206070102")) {
            ipChange.ipc$dispatch("-1206070102", new Object[]{this});
        } else if (this.isOldSend) {
            OnSendListener onSendListener = this.mOnSendListener;
            if (onSendListener != null) {
                this.comboSend = true;
                int i = this.mComboCount + 1;
                this.mComboCount = i;
                onSendListener.onCombSend(i);
                ((ILog) Dsl.getService(ILog.class)).i("oldSend ", "count= " + this.mComboCount);
            }
        } else {
            this.mCombSendView.touchUp(this.giftType);
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1914825617")) {
            ipChange.ipc$dispatch("1914825617", new Object[]{this});
            return;
        }
        Context context = getContext();
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_ykl_send_gift_linear_button, this);
        this.mSendBtn = (LinearProgressSendButton) findViewById(R.id.id_linear_send_bt);
        CombSendView combSendView = (CombSendView) findViewById(R.id.combSendView);
        this.mCombSendView = combSendView;
        combSendView.setOnCombSendListener(this.onCombSendListener);
        this.mSendBtn.setOnTouchListener(this);
        this.mSendBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.interactive.gift.view.ParticleSendGiftButton.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-615541627")) {
                    ipChange.ipc$dispatch("-615541627", new Object[]{this, view});
                } else if (!ParticleSendGiftButton.this.checkNet()) {
                    ParticleSendGiftButton.this.mOnSendListener.onSend();
                }
            }
        });
    }

    public int getCountdownNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-90277812")) {
            return this.beginProgress;
        }
        return ((Integer) ipChange.ipc$dispatch("-90277812", new Object[]{this})).intValue();
    }

    public void isOldSend(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123891435")) {
            ipChange.ipc$dispatch("-123891435", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isOldSend = z;
        setLayoutParams();
    }

    public void oldDoProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362551227")) {
            ipChange.ipc$dispatch("-362551227", new Object[]{this});
        } else if (this.beginProgress != 100) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.mComboInterval;
            this.mHandler.sendEmptyMessageAtTime(3, uptimeMillis + (((long) i) - (uptimeMillis % ((long) i))));
            this.mSendBtn.setSendText("连送");
            LinearProgressSendButton linearProgressSendButton = this.mSendBtn;
            int i2 = this.beginProgress;
            this.beginProgress = i2 + 1;
            linearProgressSendButton.setProgress(i2);
        } else {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-sendbtn", "resetProgress ");
            resetProgress(false);
            this.mComboCount = 0;
            this.comboSend = false;
            this.mOnSendListener.onRenew();
        }
    }

    public void oldStartShowProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-653161087")) {
            ipChange.ipc$dispatch("-653161087", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-combo", "on combo startShowProgress()");
        this.mSendBtn.setProgress(this.beginProgress);
        this.mHandler.sendEmptyMessage(3);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372054171")) {
            ipChange.ipc$dispatch("372054171", new Object[]{this});
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDetachedFromWindow();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1630418503")) {
            return ((Boolean) ipChange.ipc$dispatch("1630418503", new Object[]{this, view, motionEvent})).booleanValue();
        } else if (!this.isCombo) {
            ((ILog) Dsl.getService(ILog.class)).d("liulei-sendbtn", "isComboNOT ");
            return super.onTouchEvent(motionEvent);
        } else {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mOnSendListener.checkCost();
                if (!this.canSend) {
                    this.mOnSendListener.onCombSend(0);
                } else if (this.mCanCombo) {
                    doActionDown();
                }
            } else if (action == 1 && this.canSend) {
                if (this.mCanCombo) {
                    doActionUp();
                } else {
                    this.mOnSendListener.onSend();
                }
            }
            return true;
        }
    }

    public void resetProgress(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857453548")) {
            ipChange.ipc$dispatch("857453548", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.beginProgress = 0;
        this.mSendBtn.setSendText("赠送");
        this.mSendBtn.reset();
        if (this.isOldSend) {
            this.mHandler.removeMessages(3);
        } else if (this.isSending || z) {
            this.mCombSendView.stopCombSend();
            ((ILog) Dsl.getService(ILog.class)).i("", "checkState=  isSending= " + this.isSending);
        }
    }

    public void setCanCombo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451282512")) {
            ipChange.ipc$dispatch("-1451282512", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mCanCombo = z;
    }

    public void setCombo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-199750566")) {
            ipChange.ipc$dispatch("-199750566", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isCombo = z;
        setSendBtnSelect();
    }

    public void setComboInterval(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493449234")) {
            ipChange.ipc$dispatch("-493449234", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mComboInterval = (i * 1000) / 100;
    }

    public void setGiftType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879047989")) {
            ipChange.ipc$dispatch("-879047989", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.giftType = i;
    }

    public void setLayoutParams() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388839374")) {
            ipChange.ipc$dispatch("-1388839374", new Object[]{this});
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (this.isOldSend) {
            layoutParams.width = UIUtil.dip2px(67);
            layoutParams.height = UIUtil.dip2px(32);
            layoutParams.setMargins(0, 0, UIUtil.dip2px(14), UIUtil.dip2px(9));
        }
        setLayoutParams(layoutParams);
    }

    public void setOnSendListener(OnSendListener onSendListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094311436")) {
            ipChange.ipc$dispatch("1094311436", new Object[]{this, onSendListener});
            return;
        }
        this.mOnSendListener = onSendListener;
    }

    public void setSendBtnSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054006472")) {
            ipChange.ipc$dispatch("-2054006472", new Object[]{this});
        } else if (!this.isSetState) {
            this.isSetState = true;
        }
    }

    public void setSendText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600633679")) {
            ipChange.ipc$dispatch("-1600633679", new Object[]{this, charSequence});
            return;
        }
        LinearProgressSendButton linearProgressSendButton = this.mSendBtn;
        if (linearProgressSendButton != null) {
            linearProgressSendButton.setSendText(charSequence);
        }
    }

    public void setSendVisibility(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099696268")) {
            ipChange.ipc$dispatch("1099696268", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.canSend = z;
    }

    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308911081")) {
            ipChange.ipc$dispatch("308911081", new Object[]{this});
            return;
        }
        doActionDown();
        if (this.isOldSend) {
            oldDoProgress();
        }
    }

    public void switchSendBtnStyle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334564225")) {
            ipChange.ipc$dispatch("-1334564225", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mSendBtn.setButtonState(z);
    }

    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1661524936")) {
            ipChange.ipc$dispatch("1661524936", new Object[]{this, giftTheme});
            return;
        }
        this.mSendBtn.updateTheme(giftTheme);
    }

    public ParticleSendGiftButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ParticleSendGiftButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
