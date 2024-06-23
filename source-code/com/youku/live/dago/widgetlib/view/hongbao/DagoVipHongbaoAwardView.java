package com.youku.live.dago.widgetlib.view.hongbao;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.interactive.gift.view.progressring.ProgressRing;
import com.youku.live.dago.widgetlib.util.AsyncInflaterUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener;

/* compiled from: Taobao */
public class DagoVipHongbaoAwardView extends FrameLayout implements IHongbaoCountdownView, IDestroyable, IAppearStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoVipHongbaoAwardView";
    private final int LAYOUT_ID;
    private ImageView mAnchorAvatarView;
    private String mAnchorId;
    private String mAnchorName;
    private TextView mAnchorNameView;
    private String mAnchorUrl;
    private ImageView mAttentionView;
    private ICallback mCallback;
    private Context mContext;
    private ProgressRing mCountdownProgressView;
    private TextView mCountdownTextView;
    private IEngineInstance mEngineInstance;
    private FrameLayout mGetHongbaoBtn;
    private FrameLayout mHongbaoAnimAStep;
    private ImageView mHongbaoAnimBStep;
    private ImageView mHongbaoAnimCStep;
    private FrameLayout mHongbaoAttentionLayout;
    private FrameLayout mHongbaoAwardResultInfoLayout;
    private ImageView mHongbaoCloseBtn;
    private TextView mHongbaoConfirmBtn;
    private FrameLayout mHongbaoConfirmLayout;
    private TextView mHongbaoCongirmInfoView;
    private FrameLayout mHongbaoContainer;
    private ImageView mHongbaoIconView;
    private ImageView mHongbaoResultBgView;
    private TextView mHongbaoResultMsg;
    private TextView mHongbaoResultTitle;
    private View mInflateRoot;
    private int mLeftTime;
    private int mTotalTime;
    private boolean supportAsyncInflater;

    /* compiled from: Taobao */
    public interface ICallback {
        void onAttention();

        void onClose();

        void onCountDownEnd();

        void onGetAward();

        void onKnown();
    }

    public DagoVipHongbaoAwardView(@NonNull Context context) {
        this(context, null);
    }

    private void initChildrenView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099608665")) {
            ipChange.ipc$dispatch("-1099608665", new Object[]{this, view});
            return;
        }
        this.mHongbaoIconView = (ImageView) findViewById(R.id.iv_hongbao_interact_icon);
        this.mHongbaoCloseBtn = (ImageView) findViewById(R.id.iv_hongbao_close);
        this.mCountdownTextView = (TextView) findViewById(R.id.dago_hongbao_countdown_num);
        this.mCountdownProgressView = (ProgressRing) findViewById(R.id.dago_hongbao_countdown_progress);
        this.mHongbaoContainer = (FrameLayout) findViewById(R.id.fl_parent_layout);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.iv_hongbao_interact_btn);
        this.mGetHongbaoBtn = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2015241027")) {
                    ipChange.ipc$dispatch("-2015241027", new Object[]{this, view});
                    return;
                }
                DagoVipHongbaoAwardView.this.mGetHongbaoBtn.setEnabled(false);
                DagoVipHongbaoAwardView.this.mCallback.onGetAward();
            }
        });
        this.mHongbaoAnimAStep = (FrameLayout) findViewById(R.id.fl_hongbao_anim_a);
        this.mHongbaoAnimBStep = (ImageView) findViewById(R.id.iv_hongbao_anim_b);
        this.mHongbaoAttentionLayout = (FrameLayout) findViewById(R.id.dago_hongbao_attention_layout);
        this.mAnchorAvatarView = (ImageView) findViewById(R.id.iv_anchor_avatar);
        this.mAttentionView = (ImageView) findViewById(R.id.iv_anchor_attention);
        this.mAnchorNameView = (TextView) findViewById(R.id.tv_anchor_name);
        this.mHongbaoAttentionLayout.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "96049342")) {
                    ipChange.ipc$dispatch("96049342", new Object[]{this, view});
                } else if (DagoVipHongbaoAwardView.this.mAttentionView.getVisibility() == 0 && DagoVipHongbaoAwardView.this.mCallback != null) {
                    DagoVipHongbaoAwardView.this.mCallback.onAttention();
                }
            }
        });
        this.mHongbaoConfirmLayout = (FrameLayout) findViewById(R.id.dago_hongbao_confirm_layout);
        this.mHongbaoCongirmInfoView = (TextView) findViewById(R.id.tv_confirm_info);
        TextView textView = (TextView) findViewById(R.id.tv_result_confirm);
        this.mHongbaoConfirmBtn = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2087627585")) {
                    ipChange.ipc$dispatch("-2087627585", new Object[]{this, view});
                } else if (DagoVipHongbaoAwardView.this.mCallback != null) {
                    DagoVipHongbaoAwardView.this.mCallback.onKnown();
                }
            }
        });
        this.mHongbaoCloseBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "23662784")) {
                    ipChange.ipc$dispatch("23662784", new Object[]{this, view});
                } else if (DagoVipHongbaoAwardView.this.mCallback != null) {
                    DagoVipHongbaoAwardView.this.mCallback.onClose();
                }
            }
        });
        this.mHongbaoAwardResultInfoLayout = (FrameLayout) findViewById(R.id.fl_hongbao_result_detail_layout);
        this.mHongbaoResultTitle = (TextView) findViewById(R.id.tv_result_detail_title);
        this.mHongbaoResultMsg = (TextView) findViewById(R.id.tv_result_detail_desc);
        this.mHongbaoResultBgView = (ImageView) findViewById(R.id.iv_result_detail_bg);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886401346")) {
            ipChange.ipc$dispatch("-1886401346", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        this.supportAsyncInflater = AsyncInflaterUtils.supportAsyncInflater();
        LayoutInflater.from(context).inflate(this.LAYOUT_ID, this);
        initChildrenView(this);
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void countdownEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789741077")) {
            ipChange.ipc$dispatch("1789741077", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "countdownEnd ");
        ProgressRing progressRing = this.mCountdownProgressView;
        if (progressRing != null) {
            progressRing.setVisibility(8);
        }
        this.mHongbaoIconView.setImageResource(R.drawable.dago_hongbao_btn_get_bg);
        this.mCountdownTextView.setText("抢");
        this.mCountdownTextView.setTextColor(Color.parseColor("#732F06"));
        ICallback iCallback = this.mCallback;
        if (iCallback != null) {
            iCallback.onCountDownEnd();
        }
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "260226353")) {
            ipChange.ipc$dispatch("260226353", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105776521")) {
            ipChange.ipc$dispatch("-105776521", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154680101")) {
            ipChange.ipc$dispatch("-154680101", new Object[]{this});
        }
    }

    public FrameLayout getHongbaoContainer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-55767019")) {
            return this.mHongbaoContainer;
        }
        return (FrameLayout) ipChange.ipc$dispatch("-55767019", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "301426132")) {
            ipChange.ipc$dispatch("301426132", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
    }

    public void setCallback(ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-20028161")) {
            ipChange.ipc$dispatch("-20028161", new Object[]{this, iCallback});
            return;
        }
        this.mCallback = iCallback;
    }

    public void setEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600155465")) {
            ipChange.ipc$dispatch("-1600155465", new Object[]{this, iEngineInstance});
            return;
        }
        this.mEngineInstance = iEngineInstance;
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void setMaxProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869682352")) {
            ipChange.ipc$dispatch("-869682352", new Object[]{this, Float.valueOf(f)});
            return;
        }
        ProgressRing progressRing = this.mCountdownProgressView;
        if (progressRing != null) {
            progressRing.setMaxProgress(f);
        }
    }

    public void updateAttentionInfo(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-872062376")) {
            ipChange.ipc$dispatch("-872062376", new Object[]{this, str, str2, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "updateAttentionInfo = " + z);
        DagoImageLoader.getInstance().showCircle(this.mContext, str2, this.mAnchorAvatarView);
        this.mAnchorNameView.setText(str);
        ImageView imageView = this.mAttentionView;
        if (z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void updateCountdownProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476373037")) {
            ipChange.ipc$dispatch("476373037", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ProgressRing progressRing = this.mCountdownProgressView;
        if (progressRing != null) {
            progressRing.setProgress(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.view.hongbao.IHongbaoCountdownView
    public void updateCountdownText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1757084128")) {
            ipChange.ipc$dispatch("1757084128", new Object[]{this, str});
            return;
        }
        TextView textView = this.mCountdownTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void updateHongbaoAward(DagoHongbaoResultInfo dagoHongbaoResultInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-143163134")) {
            ipChange.ipc$dispatch("-143163134", new Object[]{this, dagoHongbaoResultInfo});
        } else if (dagoHongbaoResultInfo == null) {
            this.mGetHongbaoBtn.setEnabled(true);
        } else {
            this.mGetHongbaoBtn.setVisibility(8);
            if (dagoHongbaoResultInfo.awardSuccess) {
                this.mHongbaoResultBgView.setImageResource(R.drawable.dago_hongbao_lucky_bg);
                this.mHongbaoResultTitle.setText(dagoHongbaoResultInfo.info);
                this.mHongbaoResultMsg.setVisibility(0);
                this.mHongbaoCongirmInfoView.setText("恭喜你，抢到红包");
            } else {
                this.mHongbaoResultMsg.setVisibility(8);
                this.mHongbaoResultTitle.setText("很遗憾");
                this.mHongbaoResultBgView.setImageResource(R.drawable.dago_hongbao_bad_luck_bg);
                this.mHongbaoCongirmInfoView.setText("手慢了，下次快点哦");
            }
            this.mHongbaoAttentionLayout.setVisibility(8);
            this.mHongbaoConfirmLayout.setVisibility(0);
            this.mHongbaoAnimAStep.setVisibility(8);
            this.mHongbaoAwardResultInfoLayout.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.dago_hongbao_anim_bottom_in));
            this.mHongbaoAwardResultInfoLayout.setVisibility(0);
            this.mHongbaoAnimBStep.setVisibility(0);
            this.mHongbaoAnimBStep.setImageResource(R.drawable.dago_hongbao_detail_anim_d_bg);
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290011048")) {
            ipChange.ipc$dispatch("-1290011048", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-824104614")) {
            ipChange.ipc$dispatch("-824104614", new Object[]{this});
        }
    }

    public DagoVipHongbaoAwardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DagoVipHongbaoAwardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.LAYOUT_ID = R.layout.dago_youku_vip_hongbao_large_layout;
        initView(context);
    }
}
