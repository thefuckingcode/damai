package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftTrackCallback;
import com.youku.live.dago.widgetlib.protocol.YKLGiftTrackProtocol;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Map;

/* compiled from: Taobao */
public class YKLGiftTrackComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoGiftTrackComponent";
    private YKLGiftTrackProtocol mGiftTrackProtocol = null;

    public YKLGiftTrackComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
    }

    private YKLGiftTrackProtocol getAdapter(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "269388237")) {
            return (YKLGiftTrackProtocol) YKLAdapterFactory.getInstance().createInterface(YKLGiftTrackComponent.class, context);
        }
        return (YKLGiftTrackProtocol) ipChange.ipc$dispatch("269388237", new Object[]{this, context});
    }

    private void initAttrs() {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "1053469658")) {
            ipChange.ipc$dispatch("1053469658", new Object[]{this});
            return;
        }
        YKLGiftTrackProtocol yKLGiftTrackProtocol = this.mGiftTrackProtocol;
        if (yKLGiftTrackProtocol != null) {
            yKLGiftTrackProtocol.setCallback(new IGiftTrackCallback() {
                /* class com.youku.live.dago.widgetlib.component.YKLGiftTrackComponent.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftTrackCallback
                public void onEnd() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1124897955")) {
                        ipChange.ipc$dispatch("1124897955", new Object[]{this});
                        return;
                    }
                    YKLGiftTrackComponent.this.onEffectEnd();
                }
            });
        }
        if (getBasicComponentData() != null && getBasicComponentData().getAttrs() != null) {
            Map map = (Map) getBasicComponentData().getAttrs().get("style");
            if (map != null) {
                String str = (String) map.get("width");
                String str2 = (String) map.get("height");
                int intValue = !TextUtils.isEmpty(str) ? Integer.valueOf(str).intValue() : 0;
                if (!TextUtils.isEmpty(str2)) {
                    i = Integer.valueOf(str2).intValue();
                }
                YKLGiftTrackProtocol yKLGiftTrackProtocol2 = this.mGiftTrackProtocol;
                if (!(yKLGiftTrackProtocol2 == null || intValue == 0 || i == 0)) {
                    yKLGiftTrackProtocol2.setSize(intValue, i);
                }
            }
            String valueOf = String.valueOf(getBasicComponentData().getAttrs().get("line"));
            if (this.mGiftTrackProtocol != null && !TextUtils.isEmpty(valueOf) && !"null".equals(valueOf)) {
                this.mGiftTrackProtocol.setTrackCount(ParseUtils.parse2Int(valueOf));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onEffectEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603416447")) {
            ipChange.ipc$dispatch("-1603416447", new Object[]{this});
            return;
        }
        fireEvent("end");
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882605656")) {
            return (View) ipChange.ipc$dispatch("882605656", new Object[]{this, context});
        }
        YKLGiftTrackProtocol adapter = getAdapter(context);
        this.mGiftTrackProtocol = adapter;
        if (adapter == null) {
            return null;
        }
        initAttrs();
        return this.mGiftTrackProtocol.getView();
    }

    @JSMethod
    public void resume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512972175")) {
            ipChange.ipc$dispatch("-1512972175", new Object[]{this});
        }
    }

    @JSMethod
    public void sendMsg(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82926674")) {
            ipChange.ipc$dispatch("82926674", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-track", "sendMsg add track  ");
        if (map != null) {
            GiftTrackBean giftTrackBean = new GiftTrackBean();
            if (map.containsKey(ALBiometricsKeys.KEY_USERNAME)) {
                giftTrackBean.userName = String.valueOf(map.get(ALBiometricsKeys.KEY_USERNAME));
            }
            if (map.containsKey("userId")) {
                giftTrackBean.userId = String.valueOf(map.get("userId"));
            }
            if (map.containsKey("userIcon")) {
                giftTrackBean.userIcon = String.valueOf(map.get("userIcon"));
            }
            if (map.containsKey("anchorId")) {
                giftTrackBean.anchorId = String.valueOf(map.get("anchorId"));
            }
            if (map.containsKey("anchorName")) {
                giftTrackBean.anchorName = String.valueOf(map.get("anchorName"));
            }
            if (map.containsKey("anchorIcon")) {
                giftTrackBean.anchorIcon = String.valueOf(map.get("anchorIcon"));
            }
            if (map.containsKey("giftName")) {
                giftTrackBean.giftName = String.valueOf(map.get("giftName"));
            }
            if (map.containsKey("giftIcon")) {
                giftTrackBean.giftIcon = String.valueOf(map.get("giftIcon"));
            }
            if (map.containsKey("giftNum")) {
                giftTrackBean.giftNum = String.valueOf(map.get("giftNum"));
            }
            if (map.containsKey("continueNum")) {
                giftTrackBean.comboCount = ParseUtils.parse2Int(String.valueOf(map.get("continueNum")));
            }
            if (map.containsKey("isMe")) {
                giftTrackBean.isMe = "1".equals(String.valueOf(map.get("isMe")));
            }
            if (map.containsKey("lotteryCount")) {
                giftTrackBean.lotteryCount = ParseUtils.parse2Int(String.valueOf(map.get("lotteryCount")));
            }
            if (map.containsKey("isLottery")) {
                giftTrackBean.isLottery = "1".equals(String.valueOf(map.get("isLottery")));
            }
            if (map.containsKey("lotteryTimes")) {
                giftTrackBean.lotteryTimes = ParseUtils.parse2Int(String.valueOf(map.get("lotteryTimes")));
            }
            YKLGiftTrackProtocol yKLGiftTrackProtocol = this.mGiftTrackProtocol;
            if (yKLGiftTrackProtocol != null) {
                giftTrackBean.isMe = false;
                yKLGiftTrackProtocol.insertGiftTrackInfo(giftTrackBean);
            }
        }
    }

    @JSMethod
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "542741180")) {
            ipChange.ipc$dispatch("542741180", new Object[]{this});
        }
    }

    private YKLGiftTrackProtocol getAdapter(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-509549097")) {
            return (YKLGiftTrackProtocol) YKLAdapterFactory.getInstance().createInterface(YKLGiftTrackComponent.class, context, str, false);
        }
        return (YKLGiftTrackProtocol) ipChange.ipc$dispatch("-509549097", new Object[]{this, context, str});
    }

    public YKLGiftTrackComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public YKLGiftTrackComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public YKLGiftTrackComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
    }
}
