package com.youku.live.dago.widgetlib.wedome.adapter.gift;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftLinkInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftPropBean;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTargetInfoBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback;
import com.youku.live.dago.widgetlib.interactive.gift.config.GiftTheme;
import com.youku.live.dago.widgetlib.interactive.gift.manager.GiftDataManager;
import com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow;
import com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow;
import com.youku.live.dago.widgetlib.interactive.utils.DensityUtil;
import com.youku.live.dago.widgetlib.interactive.utils.GiftUTUtils;
import com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class YKLGiftBoardAdapter extends FrameLayout implements YKLGiftBoardProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String LIVE_GIFT_TAG = "liulei-gift";
    private String countdownTime = "10";
    Animation enterAnimation;
    Animation exitAnimation;
    private boolean firstRecharge;
    private boolean hasPack = false;
    private boolean hasPackTip;
    private boolean hasStarGift;
    private boolean isShow = false;
    private IGiftBoardCallback mCallback;
    private String mCoins = "0";
    private Context mContext;
    private GestureGiftWindow mGestureGiftWindow;
    private SendGiftWindow mGiftBoardWindow;
    private boolean mIsLandscape = false;
    private LayoutTransition mLayoutTransition = new LayoutTransition();
    private String mLine = "2";
    private Map<String, Object> mSpm;
    private String seletedGid = null;
    private int seletedNum = 1;
    private String seletedPid = null;
    private String seletedTid = null;
    private boolean showPack = false;

    public YKLGiftBoardAdapter(@NonNull Context context) {
        super(context);
        init(context);
    }

    private Animator getAppearingChangeAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-512683700")) {
            return (Animator) ipChange.ipc$dispatch("-512683700", new Object[]{this});
        }
        return ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("translationY", -1.0f, 0.0f));
    }

    private Animator getDisappearingChangeAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1157293780")) {
            return (Animator) ipChange.ipc$dispatch("-1157293780", new Object[]{this});
        }
        return ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("translationY", 0.0f, -1.0f));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Animation getEnterAnim(boolean z) {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733391605")) {
            return (Animation) ipChange.ipc$dispatch("733391605", new Object[]{this, Boolean.valueOf(z)});
        }
        if (z) {
            translateAnimation = new TranslateAnimation(2, 0.5f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.5f, 2, 0.0f);
        }
        translateAnimation.setDuration(250);
        return translateAnimation;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Animation getExitAnim(boolean z) {
        TranslateAnimation translateAnimation;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526239295")) {
            return (Animation) ipChange.ipc$dispatch("-1526239295", new Object[]{this, Boolean.valueOf(z)});
        }
        if (z) {
            translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        } else {
            translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        }
        translateAnimation.setDuration(200);
        return translateAnimation;
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1832630386")) {
            ipChange.ipc$dispatch("1832630386", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        int screenWidth = DensityUtil.getScreenWidth(context);
        int screenHeight = DensityUtil.getScreenHeight(context);
        int min = Math.min(screenWidth, screenHeight);
        if (screenWidth > screenHeight) {
            z = true;
        }
        this.mIsLandscape = z;
        LayoutInflater.from(context).inflate(R.layout.dago_pgc_layout_gift_board_component, this);
        setClickable(true);
        setOnClickListener(new View.OnClickListener() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "419232676")) {
                    ipChange.ipc$dispatch("419232676", new Object[]{this, view});
                }
            }
        });
        GestureGiftWindow gestureGiftWindow = new GestureGiftWindow(context);
        this.mGestureGiftWindow = gestureGiftWindow;
        gestureGiftWindow.setVisibility(4);
        addView(this.mGestureGiftWindow, new ViewGroup.LayoutParams(-1, -1));
        this.mGestureGiftWindow.setOnLifecycleListener(new GestureGiftWindow.OnLifecycleListener() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.OnLifecycleListener
            public void onDismiss() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1118505013")) {
                    ipChange.ipc$dispatch("-1118505013", new Object[]{this});
                    return;
                }
                YKLGiftBoardAdapter.this.mGestureGiftWindow.setVisibility(8);
                YKLGiftBoardAdapter yKLGiftBoardAdapter = YKLGiftBoardAdapter.this;
                Animation exitAnim = yKLGiftBoardAdapter.getExitAnim(yKLGiftBoardAdapter.mIsLandscape);
                exitAnim.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass2.AnonymousClass3 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationEnd(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1004830195")) {
                            ipChange.ipc$dispatch("-1004830195", new Object[]{this, animation});
                            return;
                        }
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setVisibility(8);
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(0);
                        if (YKLGiftBoardAdapter.this.mCallback != null) {
                            YKLGiftBoardAdapter.this.mCallback.onGestureBoardDisappear();
                        }
                        YKLGiftBoardAdapter.this.mGiftBoardWindow.dismiss();
                    }

                    public void onAnimationRepeat(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "513107527")) {
                            ipChange.ipc$dispatch("513107527", new Object[]{this, animation});
                        }
                    }

                    public void onAnimationStart(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-778975706")) {
                            ipChange.ipc$dispatch("-778975706", new Object[]{this, animation});
                            return;
                        }
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(4);
                    }
                });
                YKLGiftBoardAdapter.this.mGestureGiftWindow.startAnimation(exitAnim);
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.OnLifecycleListener
            public void onGiftSent(final int i, final int i2, final List<GestureGiftWindow.Coord> list, final long j, final List<GiftTargetInfoBean> list2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2057006327")) {
                    ipChange.ipc$dispatch("2057006327", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, Long.valueOf(j), list2});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter yKLGiftBoardAdapter = YKLGiftBoardAdapter.this;
                    Animation exitAnim = yKLGiftBoardAdapter.getExitAnim(yKLGiftBoardAdapter.mIsLandscape);
                    exitAnim.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass2.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onAnimationEnd(Animation animation) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "1903351691")) {
                                ipChange.ipc$dispatch("1903351691", new Object[]{this, animation});
                                return;
                            }
                            YKLGiftBoardAdapter.this.mCallback.onSendGestureGift(i, i2, list, j, list2);
                            YKLGiftBoardAdapter.this.mGestureGiftWindow.setVisibility(8);
                            YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(0);
                            YKLGiftBoardAdapter.this.mCallback.onGestureBoardDisappear();
                            YKLGiftBoardAdapter.this.mGiftBoardWindow.dismiss();
                        }

                        public void onAnimationRepeat(Animation animation) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "79378441")) {
                                ipChange.ipc$dispatch("79378441", new Object[]{this, animation});
                            }
                        }

                        public void onAnimationStart(Animation animation) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-2039892956")) {
                                ipChange.ipc$dispatch("-2039892956", new Object[]{this, animation});
                                return;
                            }
                            YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(4);
                        }
                    });
                    YKLGiftBoardAdapter.this.mGestureGiftWindow.startAnimation(exitAnim);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.GestureGiftWindow.OnLifecycleListener
            public void onRechargeTriggered() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "780537637")) {
                    ipChange.ipc$dispatch("780537637", new Object[]{this});
                    return;
                }
                GiftUTUtils.rechargeClick();
                YKLGiftBoardAdapter yKLGiftBoardAdapter = YKLGiftBoardAdapter.this;
                Animation exitAnim = yKLGiftBoardAdapter.getExitAnim(yKLGiftBoardAdapter.mIsLandscape);
                exitAnim.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass2.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationEnd(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1698222900")) {
                            ipChange.ipc$dispatch("-1698222900", new Object[]{this, animation});
                            return;
                        }
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setVisibility(8);
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(0);
                        if (YKLGiftBoardAdapter.this.mCallback != null) {
                            YKLGiftBoardAdapter.this.mCallback.onRecharge();
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1851240664")) {
                            ipChange.ipc$dispatch("-1851240664", new Object[]{this, animation});
                        }
                    }

                    public void onAnimationStart(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1409434331")) {
                            ipChange.ipc$dispatch("-1409434331", new Object[]{this, animation});
                            return;
                        }
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(4);
                    }
                });
                YKLGiftBoardAdapter.this.mGestureGiftWindow.startAnimation(exitAnim);
            }
        });
        SendGiftWindow sendGiftWindow = new SendGiftWindow(context, this.mIsLandscape);
        this.mGiftBoardWindow = sendGiftWindow;
        sendGiftWindow.setVisibility(4);
        this.mGiftBoardWindow.setBoardWidth(min);
        this.mGiftBoardWindow.setOnGestureGiftDetectedListener(new SendGiftWindow.OnGestureGiftDetectedListener() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass3 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.view.SendGiftWindow.OnGestureGiftDetectedListener
            public void onGestureGiftDetected(final List<GiftInfoBean> list, final int i, final List<GiftTargetInfoBean> list2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1020736490")) {
                    ipChange.ipc$dispatch("1020736490", new Object[]{this, list, Integer.valueOf(i), list2});
                    return;
                }
                if (YKLGiftBoardAdapter.this.mGiftBoardWindow != null) {
                    YKLGiftBoardAdapter yKLGiftBoardAdapter = YKLGiftBoardAdapter.this;
                    yKLGiftBoardAdapter.exitAnimation = yKLGiftBoardAdapter.getExitAnim(yKLGiftBoardAdapter.mIsLandscape);
                    YKLGiftBoardAdapter.this.exitAnimation.setAnimationListener(new Animation.AnimationListener() {
                        /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass3.AnonymousClass1 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void onAnimationEnd(Animation animation) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1761156980")) {
                                ipChange.ipc$dispatch("-1761156980", new Object[]{this, animation});
                                return;
                            }
                            if (YKLGiftBoardAdapter.this.mGiftBoardWindow != null) {
                                YKLGiftBoardAdapter.this.mGiftBoardWindow.setVisibility(4);
                                YKLGiftBoardAdapter.this.mGiftBoardWindow.setIndicatorVisibility(0);
                            }
                            YKLGiftBoardAdapter.this.isShow = false;
                            ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "gift board close Self");
                        }

                        public void onAnimationRepeat(Animation animation) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "180290408")) {
                                ipChange.ipc$dispatch("180290408", new Object[]{this, animation});
                            }
                        }

                        public void onAnimationStart(Animation animation) {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "-1759543067")) {
                                ipChange.ipc$dispatch("-1759543067", new Object[]{this, animation});
                                return;
                            }
                            YKLGiftBoardAdapter.this.mGiftBoardWindow.setIndicatorVisibility(4);
                        }
                    });
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "startAnimation close board");
                    YKLGiftBoardAdapter.this.mGiftBoardWindow.startAnimation(YKLGiftBoardAdapter.this.exitAnimation);
                }
                YKLGiftBoardAdapter yKLGiftBoardAdapter2 = YKLGiftBoardAdapter.this;
                Animation enterAnim = yKLGiftBoardAdapter2.getEnterAnim(yKLGiftBoardAdapter2.mIsLandscape);
                enterAnim.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass3.AnonymousClass2 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void onAnimationEnd(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1067764275")) {
                            ipChange.ipc$dispatch("-1067764275", new Object[]{this, animation});
                            return;
                        }
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setGiftItems(list, (GiftInfoBean) list.get(i), list2);
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setVisibility(0);
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(0);
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.bringToFront();
                        if (YKLGiftBoardAdapter.this.mCallback != null) {
                            YKLGiftBoardAdapter.this.mCallback.onGestureBoardAppear();
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1750328697")) {
                            ipChange.ipc$dispatch("-1750328697", new Object[]{this, animation});
                        }
                    }

                    public void onAnimationStart(Animation animation) {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "-1129084442")) {
                            ipChange.ipc$dispatch("-1129084442", new Object[]{this, animation});
                            return;
                        }
                        YKLGiftBoardAdapter.this.mGestureGiftWindow.setIndicatorVisibility(4);
                    }
                });
                YKLGiftBoardAdapter.this.mGestureGiftWindow.startAnimation(enterAnim);
            }
        });
        this.mGiftBoardWindow.setGiftBoardCallback(new IGiftBoardCallback() {
            /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass4 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void clickLink(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1664281468")) {
                    ipChange.ipc$dispatch("1664281468", new Object[]{this, str});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void close(final Map<String, Object> map) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-793837975")) {
                    ipChange.ipc$dispatch("-793837975", new Object[]{this, map});
                } else if (YKLGiftBoardAdapter.this.mGiftBoardWindow != null) {
                    if (YKLGiftBoardAdapter.this.mGiftBoardWindow.getVisibility() == 0) {
                        YKLGiftBoardAdapter yKLGiftBoardAdapter = YKLGiftBoardAdapter.this;
                        yKLGiftBoardAdapter.exitAnimation = yKLGiftBoardAdapter.getExitAnim(yKLGiftBoardAdapter.mIsLandscape);
                        YKLGiftBoardAdapter.this.exitAnimation.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass4.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void onAnimationEnd(Animation animation) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1130698355")) {
                                    ipChange.ipc$dispatch("-1130698355", new Object[]{this, animation});
                                    return;
                                }
                                if (YKLGiftBoardAdapter.this.mGiftBoardWindow != null) {
                                    YKLGiftBoardAdapter.this.mGiftBoardWindow.setVisibility(4);
                                    YKLGiftBoardAdapter.this.mGiftBoardWindow.setIndicatorVisibility(0);
                                    YKLGiftBoardAdapter.this.mGiftBoardWindow.release();
                                }
                                GiftDataManager.getInstance().clearData();
                                YKLGiftBoardAdapter.this.isShow = false;
                                ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "gift board close Self");
                                if (YKLGiftBoardAdapter.this.mCallback != null) {
                                    YKLGiftBoardAdapter.this.mCallback.close(map);
                                }
                            }

                            public void onAnimationRepeat(Animation animation) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "281202375")) {
                                    ipChange.ipc$dispatch("281202375", new Object[]{this, animation});
                                }
                            }

                            public void onAnimationStart(Animation animation) {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "-1479193178")) {
                                    ipChange.ipc$dispatch("-1479193178", new Object[]{this, animation});
                                    return;
                                }
                                YKLGiftBoardAdapter.this.mGiftBoardWindow.setIndicatorVisibility(4);
                            }
                        });
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "startAnimation close board");
                        YKLGiftBoardAdapter.this.mGiftBoardWindow.startAnimation(YKLGiftBoardAdapter.this.exitAnimation);
                    } else {
                        YKLGiftBoardAdapter.this.mGiftBoardWindow.release();
                        GiftDataManager.getInstance().clearData();
                        YKLGiftBoardAdapter.this.isShow = false;
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "gift board close Self");
                        if (YKLGiftBoardAdapter.this.mCallback != null) {
                            YKLGiftBoardAdapter.this.mCallback.close(map);
                        }
                    }
                    YKLGiftBoardAdapter.this.mGiftBoardWindow.removeFloatingView();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void morePropBtnClick() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1528021134")) {
                    ipChange.ipc$dispatch("-1528021134", new Object[]{this});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.morePropBtnClick();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onDoMission(GiftPropBean giftPropBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2089554824")) {
                    ipChange.ipc$dispatch("2089554824", new Object[]{this, giftPropBean});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.onDoMission(giftPropBean);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onGestureBoardAppear() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1659309445")) {
                    ipChange.ipc$dispatch("1659309445", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onGestureBoardDisappear() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "236728077")) {
                    ipChange.ipc$dispatch("236728077", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onRecharge() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-321334192")) {
                    ipChange.ipc$dispatch("-321334192", new Object[]{this});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.onRecharge();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onSendGestureGift(int i, int i2, List<GestureGiftWindow.Coord> list, long j, List<GiftTargetInfoBean> list2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1122846206")) {
                    ipChange.ipc$dispatch("-1122846206", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, Long.valueOf(j), list2});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.onSendGestureGift(i, i2, list, j, list2);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onSendGift(long j, GiftInfoBean giftInfoBean, List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1329345151")) {
                    ipChange.ipc$dispatch("-1329345151", new Object[]{this, Long.valueOf(j), giftInfoBean, list});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.onSendGift(j, giftInfoBean, list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void onSendProp(long j, GiftPropBean giftPropBean, List<GiftTargetInfoBean> list) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-823526113")) {
                    ipChange.ipc$dispatch("-823526113", new Object[]{this, Long.valueOf(j), giftPropBean, list});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.onSendProp(j, giftPropBean, list);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void openExchangeBroad() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "686230527")) {
                    ipChange.ipc$dispatch("686230527", new Object[]{this});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.openExchangeBroad();
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void openUserCard(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1487503621")) {
                    ipChange.ipc$dispatch("-1487503621", new Object[]{this, str});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.openUserCard(str);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void refresh(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2140515365")) {
                    ipChange.ipc$dispatch("-2140515365", new Object[]{this, Boolean.valueOf(z)});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.refresh(z);
                }
            }

            @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftBoardCallback
            public void switchToProp(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-886132240")) {
                    ipChange.ipc$dispatch("-886132240", new Object[]{this, Boolean.valueOf(z)});
                } else if (YKLGiftBoardAdapter.this.mCallback != null) {
                    YKLGiftBoardAdapter.this.mCallback.switchToProp(z);
                }
            }
        });
        addView(this.mGiftBoardWindow, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void addPropItem(int i, GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041753612")) {
            ipChange.ipc$dispatch("2041753612", new Object[]{this, Integer.valueOf(i), giftPropBean});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.addPropItem(i, giftPropBean);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void changeToGiftTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-47173927")) {
            ipChange.ipc$dispatch("-47173927", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.changeToGiftTab(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1487877356")) {
            ipChange.ipc$dispatch("1487877356", new Object[]{this});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.dismiss();
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "gift board close Other");
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void deletePropItem(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093732113")) {
            ipChange.ipc$dispatch("-1093732113", new Object[]{this, str});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.deletePropItem(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1268996395")) {
            return this;
        }
        return (View) ipChange.ipc$dispatch("1268996395", new Object[]{this});
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void notifyGiftDataChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335044947")) {
            ipChange.ipc$dispatch("1335044947", new Object[]{this});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.refreshGiftInfo();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void notifyLinkDataChange(List<GiftLinkInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "977901498")) {
            ipChange.ipc$dispatch("977901498", new Object[]{this, list});
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void notifyPropDataChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259578368")) {
            ipChange.ipc$dispatch("-1259578368", new Object[]{this});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.refreshPropData();
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void notifyTargetChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642783388")) {
            ipChange.ipc$dispatch("1642783388", new Object[]{this});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.refreshTargetData();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1958103704")) {
            ipChange.ipc$dispatch("1958103704", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "gift board onAttachedToWindow");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-367567941")) {
            ipChange.ipc$dispatch("-367567941", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isShow = false;
        ((ILog) Dsl.getService(ILog.class)).d("liulei-gift", "gift board onDetachedFromWindow");
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void open() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973409124")) {
            ipChange.ipc$dispatch("-973409124", new Object[]{this});
        } else if (!this.isShow) {
            this.isShow = true;
            if (this.hasPack) {
                this.mGiftBoardWindow.switchPropPannel(this.showPack);
                if (!this.showPack) {
                    this.mGiftBoardWindow.setHasPackTip(this.hasPackTip);
                }
            }
            Animation enterAnim = getEnterAnim(this.mIsLandscape);
            this.enterAnimation = enterAnim;
            this.mGiftBoardWindow.startAnimation(enterAnim);
            this.enterAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.youku.live.dago.widgetlib.wedome.adapter.gift.YKLGiftBoardAdapter.AnonymousClass5 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onAnimationEnd(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "990911809")) {
                        ipChange.ipc$dispatch("990911809", new Object[]{this, animation});
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "430870163")) {
                        ipChange.ipc$dispatch("430870163", new Object[]{this, animation});
                    }
                }

                public void onAnimationStart(Animation animation) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1573676122")) {
                        ipChange.ipc$dispatch("1573676122", new Object[]{this, animation});
                        return;
                    }
                    YKLGiftBoardAdapter.this.mGiftBoardWindow.setIndicatorVisibility(4);
                    YKLGiftBoardAdapter.this.mGiftBoardWindow.setVisibility(0);
                }
            });
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void openMultiSendMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "777684586")) {
            ipChange.ipc$dispatch("777684586", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.openMultiSendMode(z);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setCallback(IGiftBoardCallback iGiftBoardCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570649479")) {
            ipChange.ipc$dispatch("-570649479", new Object[]{this, iGiftBoardCallback});
            return;
        }
        this.mCallback = iGiftBoardCallback;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setCoinIcon(String str) {
        SendGiftWindow sendGiftWindow;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1272326718")) {
            ipChange.ipc$dispatch("-1272326718", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && (sendGiftWindow = this.mGiftBoardWindow) != null) {
            sendGiftWindow.setCoinIcon(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setCoins(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983471664")) {
            ipChange.ipc$dispatch("983471664", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mCoins = str;
            SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
            if (sendGiftWindow != null) {
                sendGiftWindow.updateUserCoins(str);
            }
            GestureGiftWindow gestureGiftWindow = this.mGestureGiftWindow;
            if (gestureGiftWindow != null) {
                gestureGiftWindow.updateCoins(str);
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setCountdownTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-339135468")) {
            ipChange.ipc$dispatch("-339135468", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.countdownTime = str;
            SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
            if (sendGiftWindow != null) {
                sendGiftWindow.setComboInterval(ParseUtils.parse2Int(str));
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setFirstRecharge(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "310130595")) {
            ipChange.ipc$dispatch("310130595", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.firstRecharge = z;
        this.mGiftBoardWindow.setFirstRecharge(z);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setGiftTrackXY(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "162013913")) {
            ipChange.ipc$dispatch("162013913", new Object[]{this, map});
        } else if (map != null) {
            if (map.containsKey("bottom")) {
                i = Double.valueOf(map.get("bottom")).intValue();
            }
            this.mGiftBoardWindow.setGiftFloatingEndXY(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setHasPack(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2062764609")) {
            ipChange.ipc$dispatch("-2062764609", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasPack = z;
        this.mGiftBoardWindow.setHasProp(z);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setHasPackTip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1460785466")) {
            ipChange.ipc$dispatch("1460785466", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasPackTip = z;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setLandscape(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860930407")) {
            ipChange.ipc$dispatch("860930407", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsLandscape = z;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setMultipleText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614590865")) {
            ipChange.ipc$dispatch("-1614590865", new Object[]{this, str});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.setMultipleText(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setPackTabName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-562412117")) {
            ipChange.ipc$dispatch("-562412117", new Object[]{this, str});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.setPackTabName(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setRoomId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-312520746")) {
            ipChange.ipc$dispatch("-312520746", new Object[]{this, str});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.setRoomId(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setRowNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "99307936")) {
            ipChange.ipc$dispatch("99307936", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.mLine = str;
            SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
            if (sendGiftWindow != null) {
                sendGiftWindow.setGiftRowNum(ParseUtils.parse2Int(str));
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setSelectGid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1193970164")) {
            ipChange.ipc$dispatch("-1193970164", new Object[]{this, str});
            return;
        }
        this.seletedGid = str;
        this.mGiftBoardWindow.setSelectGid(str);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setSelectNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606151237")) {
            ipChange.ipc$dispatch("1606151237", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.seletedNum = i;
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.setSelectNum(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setSelectPid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1797030941")) {
            ipChange.ipc$dispatch("-1797030941", new Object[]{this, str});
            return;
        }
        this.seletedGid = str;
        this.mGiftBoardWindow.setSelectPid(str);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setSelectTid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065057953")) {
            ipChange.ipc$dispatch("-2065057953", new Object[]{this, str});
            return;
        }
        this.seletedTid = str;
        this.mGiftBoardWindow.setSelectTid(str);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setShowPack(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-286847512")) {
            ipChange.ipc$dispatch("-286847512", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.showPack = z;
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setShowTargetDetails(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1619556192")) {
            ipChange.ipc$dispatch("-1619556192", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.setShowTargetDetails(z);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setSpm(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "778082893")) {
            ipChange.ipc$dispatch("778082893", new Object[]{this, map});
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void setStarGift(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372997676")) {
            ipChange.ipc$dispatch("-1372997676", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.hasStarGift = z;
        this.mGiftBoardWindow.setHasStarGift(z);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void switchVirtualCoinsExchange(boolean z, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1473149840")) {
            ipChange.ipc$dispatch("1473149840", new Object[]{this, Boolean.valueOf(z), str, str2});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.switchVirtualCoinsExchange(z, str, str2);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void updatePropItem(GiftPropBean giftPropBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-669994467")) {
            ipChange.ipc$dispatch("-669994467", new Object[]{this, giftPropBean});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.updatePropItem(giftPropBean);
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLGiftBoardProtocol
    public void updateTheme(GiftTheme giftTheme) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506511640")) {
            ipChange.ipc$dispatch("-506511640", new Object[]{this, giftTheme});
            return;
        }
        SendGiftWindow sendGiftWindow = this.mGiftBoardWindow;
        if (sendGiftWindow != null) {
            sendGiftWindow.updateTheme(giftTheme);
        }
        GestureGiftWindow gestureGiftWindow = this.mGestureGiftWindow;
        if (gestureGiftWindow != null) {
            gestureGiftWindow.updateGiftTheme(giftTheme);
        }
    }

    public YKLGiftBoardAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public YKLGiftBoardAdapter(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
