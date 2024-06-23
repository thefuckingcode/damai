package com.youku.live.dago.widgetlib.view.hongbao;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.DeviceUtils;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.view.hongbao.DagoHongbaoApi;
import com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.loading.ILoadingView;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import com.youku.live.widgets.WidgetSDKEngine;
import com.youku.live.widgets.protocol.Orientation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class DagoVipHongbaoHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MSG_START_PROGRESS_COUNTDOWNNUM = 2;
    private static final int MSG_START_TEXT_COUNTDOWNNUM = 1;
    private final String LOADING_TAG = "LOADING_TAG";
    private String mAnchorId;
    private String mAnchorName;
    private String mAnchorUrl;
    private ICallback mCallback;
    private Context mContext;
    private List<IHongbaoCountdownView> mCountdownViews = new ArrayList();
    private int mDefaultInterval = 100;
    private PopupWindow mGetHongbaoWindow;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-166810866")) {
                ipChange.ipc$dispatch("-166810866", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i == 1) {
                DagoVipHongbaoHelper.this.doTextCountDown();
            } else if (i == 2) {
                DagoVipHongbaoHelper.this.doProgressCountDown();
            }
        }
    };
    private DagoVipHongbaoAwardView mHongbaoAwardView;
    private boolean mIsAttention;
    private long mLeftTime;
    private float mMax = 100.0f;
    private String mPacketId;
    private int mProgress = 0;
    private DagoHongbaoResultInfo mResultInfo;
    private String mRoomId;
    private String mScreenId;
    private long mSmoothTime = 0;
    private long mTotalTime;
    private boolean mVideoLandscape;

    /* compiled from: Taobao */
    public interface ICallback {
        void onAttentionChange(boolean z);

        void onHongbaoFinish();
    }

    public DagoVipHongbaoHelper(Context context) {
        this.mContext = context;
    }

    private void attentionActor(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1959404857")) {
            ipChange.ipc$dispatch("1959404857", new Object[]{this, map});
            return;
        }
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop("mtop.tudou.subscribe.relation.RelationServiceMTOP.create", "1.1", map, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() {
                /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass4 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1363085353")) {
                        ipChange.ipc$dispatch("1363085353", new Object[]{this, iNetResponse});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i("hongbao", "Mtop code = " + iNetResponse.getRetCode());
                    ((ILog) Dsl.getService(ILog.class)).i("hongbao", "Mtop = " + iNetResponse.getRawData().toString());
                    try {
                        if ("SUCCESS".equals(iNetResponse.getRetCode())) {
                            DagoVipHongbaoHelper.this.mHandler.post(new Runnable() {
                                /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass4.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                public void run() {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "970423839")) {
                                        ipChange.ipc$dispatch("970423839", new Object[]{this});
                                        return;
                                    }
                                    if (DagoVipHongbaoHelper.this.mCallback != null) {
                                        DagoVipHongbaoHelper.this.mCallback.onAttentionChange(true);
                                    }
                                    DagoVipHongbaoHelper.this.updateAttention(true);
                                }
                            });
                            return;
                        }
                        String retMessage = iNetResponse.getRetMessage();
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "Mtop msg = " + retMessage);
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "Mtop msg ID = " + retMessage.indexOf("Relation Exists"));
                        if (!TextUtils.isEmpty(retMessage) && retMessage.indexOf("Relation Exists") >= 0) {
                            DagoVipHongbaoHelper.this.updateAttention(true);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void countdownEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1672037895")) {
            ipChange.ipc$dispatch("-1672037895", new Object[]{this});
            return;
        }
        for (IHongbaoCountdownView iHongbaoCountdownView : this.mCountdownViews) {
            iHongbaoCountdownView.countdownEnd();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void darkenBackground(Float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579719485")) {
            ipChange.ipc$dispatch("-579719485", new Object[]{this, f});
            return;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            WindowManager.LayoutParams attributes = ((Activity) context).getWindow().getAttributes();
            attributes.alpha = f.floatValue();
            ((Activity) this.mContext).getWindow().addFlags(2);
            ((Activity) this.mContext).getWindow().setAttributes(attributes);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doProgressCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967691278")) {
            ipChange.ipc$dispatch("967691278", new Object[]{this});
        } else if (this.mProgress != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.mDefaultInterval;
            this.mHandler.sendEmptyMessageAtTime(2, uptimeMillis + (((long) i) - (uptimeMillis % ((long) i))));
            setCountdownProgress(this.mProgress);
            this.mProgress--;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doTextCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "191968654")) {
            ipChange.ipc$dispatch("191968654", new Object[]{this});
            return;
        }
        setCountdownText(this.mLeftTime + "s");
        long j = this.mLeftTime;
        this.mLeftTime = j - 1;
        if (j > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.mHandler.sendEmptyMessageAtTime(1, uptimeMillis + (1000 - (uptimeMillis % 1000)));
            return;
        }
        setCountdownText("抢");
        countdownEnd();
    }

    private String getDirection() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "142925350")) {
            return WidgetSDKEngine.getOrientation() == Orientation.ORIENTATION_LANDSCAPE ? "fplayer" : "vplayer";
        }
        return (String) ipChange.ipc$dispatch("142925350", new Object[]{this});
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void hideLoadingView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279542600")) {
            ipChange.ipc$dispatch("1279542600", new Object[]{this});
            return;
        }
        DagoVipHongbaoAwardView dagoVipHongbaoAwardView = this.mHongbaoAwardView;
        if (dagoVipHongbaoAwardView != null && dagoVipHongbaoAwardView.getHongbaoContainer() != null) {
            FrameLayout hongbaoContainer = this.mHongbaoAwardView.getHongbaoContainer();
            if (hongbaoContainer.findViewWithTag("LOADING_TAG") != null) {
                hongbaoContainer.removeView(hongbaoContainer.findViewWithTag("LOADING_TAG"));
            }
        }
    }

    private void initLargeHongbaoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346232295")) {
            ipChange.ipc$dispatch("-1346232295", new Object[]{this});
        } else if (this.mHongbaoAwardView == null) {
            DagoVipHongbaoAwardView dagoVipHongbaoAwardView = new DagoVipHongbaoAwardView(this.mContext);
            this.mHongbaoAwardView = dagoVipHongbaoAwardView;
            dagoVipHongbaoAwardView.updateAttentionInfo(this.mAnchorName, this.mAnchorUrl, this.mIsAttention);
            if (this.mLeftTime <= 0) {
                ((ILog) Dsl.getService(ILog.class)).i("hongbao", "mLeftTime == 0");
                this.mHongbaoAwardView.countdownEnd();
            } else {
                ((ILog) Dsl.getService(ILog.class)).i("hongbao", "addCountDownView  = " + this.mLeftTime);
                addCountDownView(this.mHongbaoAwardView);
            }
            this.mHongbaoAwardView.setCallback(new DagoVipHongbaoAwardView.ICallback() {
                /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass3 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.ICallback
                public void onAttention() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-676944519")) {
                        ipChange.ipc$dispatch("-676944519", new Object[]{this});
                        return;
                    }
                    HongbaoUTUtils.awardHongbaoAttentionClick(DagoVipHongbaoHelper.this.mAnchorId, DagoVipHongbaoHelper.this.mRoomId, DagoVipHongbaoHelper.this.mScreenId);
                    DagoVipHongbaoHelper.this.requestAttention();
                }

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.ICallback
                public void onClose() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "755286879")) {
                        ipChange.ipc$dispatch("755286879", new Object[]{this});
                        return;
                    }
                    HongbaoUTUtils.awardHongbaoExitClick(DagoVipHongbaoHelper.this.mAnchorId, DagoVipHongbaoHelper.this.mRoomId, DagoVipHongbaoHelper.this.mScreenId);
                    if (DagoVipHongbaoHelper.this.mGetHongbaoWindow != null) {
                        DagoVipHongbaoHelper.this.mGetHongbaoWindow.dismiss();
                    }
                }

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.ICallback
                public void onCountDownEnd() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1518286007")) {
                        ipChange.ipc$dispatch("-1518286007", new Object[]{this});
                        return;
                    }
                    HongbaoUTUtils.awardHongbaoGetExpose(DagoVipHongbaoHelper.this.mAnchorId, DagoVipHongbaoHelper.this.mRoomId, DagoVipHongbaoHelper.this.mScreenId);
                }

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.ICallback
                public void onGetAward() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1001896268")) {
                        ipChange.ipc$dispatch("1001896268", new Object[]{this});
                    } else if (DagoVipHongbaoHelper.this.mLeftTime <= 0) {
                        DagoVipHongbaoHelper.this.showLoadingView();
                        HongbaoUTUtils.awardHongbaoGetClick(DagoVipHongbaoHelper.this.mAnchorId, DagoVipHongbaoHelper.this.mRoomId, DagoVipHongbaoHelper.this.mScreenId);
                        long random = (long) (((double) DagoVipHongbaoHelper.this.mSmoothTime) * Math.random());
                        ((ILog) Dsl.getService(ILog.class)).i("hongbao", " random mSmoothTime = " + random);
                        DagoVipHongbaoHelper.this.mHandler.postDelayed(new Runnable() {
                            /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass3.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "841341120")) {
                                    ipChange.ipc$dispatch("841341120", new Object[]{this});
                                    return;
                                }
                                DagoVipHongbaoHelper.this.requestHongbaoReward();
                            }
                        }, random);
                    }
                }

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoAwardView.ICallback
                public void onKnown() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-703130060")) {
                        ipChange.ipc$dispatch("-703130060", new Object[]{this});
                        return;
                    }
                    HongbaoUTUtils.awardHongbaoKnownClick(DagoVipHongbaoHelper.this.mAnchorId, DagoVipHongbaoHelper.this.mRoomId, DagoVipHongbaoHelper.this.mScreenId);
                    if (DagoVipHongbaoHelper.this.mGetHongbaoWindow != null) {
                        DagoVipHongbaoHelper.this.mGetHongbaoWindow.dismiss();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestAttention() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1497226868")) {
            ipChange.ipc$dispatch("1497226868", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("target_id", this.mAnchorId + "");
        hashMap.put("guid", DeviceUtils.getGUID(AppContextUtils.getApp()));
        hashMap.put("is_utdid", "false");
        hashMap.put("platform", "0");
        hashMap.put("did", "6");
        attentionActor(hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void requestHongbaoReward() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058905875")) {
            ipChange.ipc$dispatch("1058905875", new Object[]{this});
            return;
        }
        DagoHongbaoApi dagoHongbaoApi = new DagoHongbaoApi();
        dagoHongbaoApi.setCallback(new DagoHongbaoApi.HongbaoResultCallback() {
            /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass5 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoHongbaoApi.HongbaoResultCallback
            public void onGetHongbaoResult(final DagoHongbaoResultInfo dagoHongbaoResultInfo) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "403148471")) {
                    ipChange.ipc$dispatch("403148471", new Object[]{this, dagoHongbaoResultInfo});
                    return;
                }
                if (dagoHongbaoResultInfo != null) {
                    DagoVipHongbaoHelper.this.mResultInfo = dagoHongbaoResultInfo;
                    HongbaoUTUtils.awardHongbaoKnownExpose(DagoVipHongbaoHelper.this.mAnchorId, DagoVipHongbaoHelper.this.mRoomId, DagoVipHongbaoHelper.this.mScreenId);
                }
                DagoVipHongbaoHelper.this.mHandler.post(new Runnable() {
                    /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass5.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1099506558")) {
                            ipChange.ipc$dispatch("1099506558", new Object[]{this});
                            return;
                        }
                        DagoVipHongbaoHelper.this.hideLoadingView();
                        if (DagoVipHongbaoHelper.this.mHongbaoAwardView != null) {
                            DagoVipHongbaoHelper.this.mHongbaoAwardView.updateHongbaoAward(dagoHongbaoResultInfo);
                        }
                    }
                });
            }
        });
        dagoHongbaoApi.getHongbaoRequest(this.mPacketId);
    }

    private void setCountdownProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076662652")) {
            ipChange.ipc$dispatch("2076662652", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        for (IHongbaoCountdownView iHongbaoCountdownView : this.mCountdownViews) {
            iHongbaoCountdownView.updateCountdownProgress(i);
        }
    }

    private void setCountdownText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-605448463")) {
            ipChange.ipc$dispatch("-605448463", new Object[]{this, str});
            return;
        }
        for (IHongbaoCountdownView iHongbaoCountdownView : this.mCountdownViews) {
            iHongbaoCountdownView.updateCountdownText(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showLoadingView() {
        View loadingView;
        DagoVipHongbaoAwardView dagoVipHongbaoAwardView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888559043")) {
            ipChange.ipc$dispatch("1888559043", new Object[]{this});
        } else if (Dsl.getService(ILoadingView.class) != null && (loadingView = ((ILoadingView) Dsl.getService(ILoadingView.class)).getLoadingView(this.mContext)) != null && (dagoVipHongbaoAwardView = this.mHongbaoAwardView) != null && dagoVipHongbaoAwardView.getHongbaoContainer() != null) {
            FrameLayout hongbaoContainer = this.mHongbaoAwardView.getHongbaoContainer();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtil.dip2px(50), UIUtil.dip2px(50));
            layoutParams.gravity = 17;
            loadingView.setTag("LOADING_TAG");
            hongbaoContainer.addView(loadingView, layoutParams);
        }
    }

    public void addCountDownView(IHongbaoCountdownView iHongbaoCountdownView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-351414546")) {
            ipChange.ipc$dispatch("-351414546", new Object[]{this, iHongbaoCountdownView});
        } else if (this.mLeftTime > 0) {
            iHongbaoCountdownView.setMaxProgress(this.mMax);
            this.mCountdownViews.add(iHongbaoCountdownView);
        } else {
            iHongbaoCountdownView.countdownEnd();
        }
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1832258976")) {
            ipChange.ipc$dispatch("1832258976", new Object[]{this});
            return;
        }
        this.mCountdownViews.clear();
        PopupWindow popupWindow = this.mGetHongbaoWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mGetHongbaoWindow.dismiss();
        }
    }

    public void setCallback(ICallback iCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230332273")) {
            ipChange.ipc$dispatch("230332273", new Object[]{this, iCallback});
            return;
        }
        this.mCallback = iCallback;
    }

    public void setMaxProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "27674348")) {
            ipChange.ipc$dispatch("27674348", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mMax = f;
    }

    public void setRoomInfo(Long l, Long l2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008385510")) {
            ipChange.ipc$dispatch("-2008385510", new Object[]{this, l, l2, Boolean.valueOf(z)});
            return;
        }
        if (l == null || this.mScreenId == null) {
            this.mRoomId = l + "";
            String str = l2 + "";
            this.mScreenId = str;
            HongbaoUTUtils.smallHongbaoExpose(this.mAnchorId, this.mRoomId, str);
        }
        this.mVideoLandscape = z;
        HongbaoUTUtils.VIDEO_LANDSCAPE = z;
    }

    public void setSmoothTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340497900")) {
            ipChange.ipc$dispatch("-1340497900", new Object[]{this, str});
            return;
        }
        this.mSmoothTime = ParseUtils.parse2Long(str) * 1000;
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", " mSmoothTime = " + this.mSmoothTime);
    }

    public void showHongbaoWindow(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1107540942")) {
            ipChange.ipc$dispatch("1107540942", new Object[]{this, view});
            return;
        }
        initLargeHongbaoView();
        if (this.mGetHongbaoWindow == null) {
            PopupWindow popupWindow = new PopupWindow(this.mHongbaoAwardView, -2, -2);
            this.mGetHongbaoWindow = popupWindow;
            popupWindow.setFocusable(true);
            this.mGetHongbaoWindow.setOutsideTouchable(true);
            this.mGetHongbaoWindow.setAnimationStyle(R.style.dago_hongbao_window_show);
            this.mGetHongbaoWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                /* class com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onDismiss() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1040171218")) {
                        ipChange.ipc$dispatch("-1040171218", new Object[]{this});
                        return;
                    }
                    DagoVipHongbaoHelper.this.darkenBackground(Float.valueOf(1.0f));
                    if (DagoVipHongbaoHelper.this.mResultInfo != null && DagoVipHongbaoHelper.this.mCallback != null) {
                        DagoVipHongbaoHelper.this.mCallback.onHongbaoFinish();
                    }
                }
            });
        }
        if (this.mGetHongbaoWindow.isShowing()) {
            this.mGetHongbaoWindow.dismiss();
        }
        if (view != null) {
            HongbaoUTUtils.awardHongbaoExpose(this.mAnchorId, this.mRoomId, this.mScreenId);
            HongbaoUTUtils.awardHongbaoExitExpose(this.mAnchorId, this.mRoomId, this.mScreenId);
            if (this.mLeftTime <= 0) {
                HongbaoUTUtils.awardHongbaoGetExpose(this.mAnchorId, this.mRoomId, this.mScreenId);
            }
            if (!this.mIsAttention) {
                HongbaoUTUtils.awardHongbaoAttentionExpose(this.mAnchorId, this.mRoomId, this.mScreenId);
            }
            this.mGetHongbaoWindow.showAtLocation(view, 17, 0, 0);
            darkenBackground(Float.valueOf(0.6f));
        }
    }

    public void startCountDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806681396")) {
            ipChange.ipc$dispatch("1806681396", new Object[]{this});
        } else if (this.mLeftTime > 0) {
            doProgressCountDown();
            doTextCountDown();
        }
    }

    public void updateAttention(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2079545726")) {
            ipChange.ipc$dispatch("-2079545726", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mIsAttention != z) {
            this.mIsAttention = z;
            if (!z) {
                HongbaoUTUtils.awardHongbaoAttentionExpose(this.mAnchorId, this.mRoomId, this.mScreenId);
            }
            DagoVipHongbaoAwardView dagoVipHongbaoAwardView = this.mHongbaoAwardView;
            if (dagoVipHongbaoAwardView != null) {
                dagoVipHongbaoAwardView.updateAttentionInfo(this.mAnchorName, this.mAnchorUrl, z);
            }
        }
    }

    public DagoVipHongbaoHelper(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mContext = context;
        this.mAnchorId = str4;
        this.mAnchorName = str5;
        this.mAnchorUrl = str6;
        this.mPacketId = str;
        this.mTotalTime = ParseUtils.parse2Long(str2);
        this.mLeftTime = ParseUtils.parse2Long(str3);
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "mLeftTime = " + this.mLeftTime);
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "mTotalTime = " + this.mTotalTime);
        setMaxProgress(180.0f);
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "MAX = " + this.mMax);
        this.mDefaultInterval = ((int) (((float) (this.mTotalTime * 1000)) / this.mMax)) + 1;
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "mDefaultInterval = " + this.mDefaultInterval);
        this.mProgress = ((int) ((((float) this.mLeftTime) * this.mMax) / ((float) this.mTotalTime))) + 1;
        ((ILog) Dsl.getService(ILog.class)).i("hongbao", "mProgress = " + this.mProgress);
    }
}
