package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.animation.AnimationError;
import com.youku.live.animation.IAnimationCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.ParseUtils;
import com.youku.live.dago.widgetlib.interactive.gift.lottery.MineLotteryData;
import com.youku.live.dago.widgetlib.interactive.resource.resource.ResourceConstants;
import com.youku.live.dago.widgetlib.protocol.YKLAnimationViewProtocol;
import com.youku.live.dago.widgetlib.wedome.framework.YKLAdapterFactory;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class YKLAnimationViewComponent extends ProxyWXComponent<View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoAnimationComponent";
    private String autoPlay = "1";
    private String comboNum = "1";
    private String giftData = "";
    private String id = "";
    private boolean isZip = true;
    private String localPath = "";
    private String loop = "1";
    private YKLAnimationViewProtocol mAnimationViewProtocol = null;
    private Map<String, String> properties = new HashMap();
    private String type = ResourceConstants.FILE_TYPE_SVGA;
    private String url = "";

    /* renamed from: com.youku.live.dago.widgetlib.component.YKLAnimationViewComponent$2  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType;

        static {
            int[] iArr = new int[YKLAnimationViewProtocol.GiftType.values().length];
            $SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType = iArr;
            try {
                iArr[YKLAnimationViewProtocol.GiftType.GRAFFITI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public YKLAnimationViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
    }

    private YKLAnimationViewProtocol getAdapter(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-665908979")) {
            return (YKLAnimationViewProtocol) YKLAdapterFactory.getInstance().createInterface(YKLAnimationViewComponent.class, context);
        }
        return (YKLAnimationViewProtocol) ipChange.ipc$dispatch("-665908979", new Object[]{this, context});
    }

    private void initAttrs() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35244632")) {
            ipChange.ipc$dispatch("-35244632", new Object[]{this});
            return;
        }
        this.mAnimationViewProtocol.setAnimationCallback(new IAnimationCallback() {
            /* class com.youku.live.dago.widgetlib.component.YKLAnimationViewComponent.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationCancel() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-414557618")) {
                    ipChange.ipc$dispatch("-414557618", new Object[]{this});
                }
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationEnd() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "932760071")) {
                    ipChange.ipc$dispatch("932760071", new Object[]{this});
                    return;
                }
                YKLAnimationViewComponent.this.fireEvent("animationend");
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationError(AnimationError animationError) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1754497687")) {
                    ipChange.ipc$dispatch("-1754497687", new Object[]{this, animationError});
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("code", Integer.valueOf(animationError.errorCode));
                hashMap.put("msg", animationError.errorMessage);
                YKLAnimationViewComponent.this.fireEvent("animationerror", hashMap);
            }

            @Override // com.youku.live.animation.IAnimationCallback
            public void onAnimationStart() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1621496352")) {
                    ipChange.ipc$dispatch("-1621496352", new Object[]{this});
                    return;
                }
                YKLAnimationViewComponent.this.fireEvent("animationstart");
            }
        });
        if (!(getBasicComponentData() == null || getBasicComponentData().getAttrs() == null)) {
            Object obj = getBasicComponentData().getAttrs().get("id");
            String str6 = null;
            if (obj == null) {
                str = null;
            } else {
                str = String.valueOf(obj);
            }
            this.id = str;
            Object obj2 = getBasicComponentData().getAttrs().get("url");
            if (obj2 == null) {
                str2 = null;
            } else {
                str2 = String.valueOf(obj2);
            }
            this.url = str2;
            Object obj3 = getBasicComponentData().getAttrs().get("giftData");
            if (obj3 == null) {
                str3 = null;
            } else {
                str3 = String.valueOf(obj3);
            }
            this.giftData = str3;
            Object obj4 = getBasicComponentData().getAttrs().get(IWXAudio.KEY_LOOP);
            if (obj4 == null) {
                str4 = null;
            } else {
                str4 = String.valueOf(obj4);
            }
            this.loop = str4;
            Object obj5 = getBasicComponentData().getAttrs().get(Constants.Name.AUTO_PLAY);
            if (obj5 == null) {
                str5 = null;
            } else {
                str5 = String.valueOf(obj5);
            }
            this.autoPlay = str5;
            this.type = String.valueOf(getBasicComponentData().getAttrs().get("type"));
            this.isZip = "1".equals(String.valueOf(getBasicComponentData().getAttrs().get("iszip")));
            Object obj6 = getBasicComponentData().getAttrs().get("localPath");
            if (obj6 != null) {
                str6 = String.valueOf(obj6);
            }
            this.localPath = str6;
            ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animaview  init ");
        }
        this.properties.put(IWXAudio.KEY_LOOP, this.loop);
    }

    @JSMethod
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111425546")) {
            ipChange.ipc$dispatch("-2111425546", new Object[]{this});
            return;
        }
        YKLAnimationViewProtocol yKLAnimationViewProtocol = this.mAnimationViewProtocol;
        if (yKLAnimationViewProtocol != null) {
            yKLAnimationViewProtocol.cancel();
        }
    }

    @JSMethod(uiThread = true)
    public void defaultPlay() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448378341")) {
            ipChange.ipc$dispatch("448378341", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("YKLAnimtion", "animation defaultPlay");
        if (this.mAnimationViewProtocol != null) {
            YKLAnimationViewProtocol.GiftAnimationItem giftAnimationItem = new YKLAnimationViewProtocol.GiftAnimationItem();
            giftAnimationItem.type = YKLAnimationViewProtocol.GiftType.toGiftType(this.type);
            giftAnimationItem.id = this.id;
            giftAnimationItem.data = this.url;
            giftAnimationItem.localPath = this.localPath;
            giftAnimationItem.autoPlay = this.autoPlay;
            giftAnimationItem.isZip = this.isZip;
            giftAnimationItem.properties = this.properties;
            this.mAnimationViewProtocol.defaultPlay(giftAnimationItem);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("code", "2001");
        hashMap.put("msg", "mAnimationViewProtocol is null");
        fireEvent("animationerror", hashMap);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1456908448")) {
            ipChange.ipc$dispatch("-1456908448", new Object[]{this});
            return;
        }
        super.destroy();
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597015242")) {
            return (View) ipChange.ipc$dispatch("1597015242", new Object[]{this, context});
        }
        YKLAnimationViewProtocol adapter = getAdapter(context);
        this.mAnimationViewProtocol = adapter;
        if (adapter == null) {
            return null;
        }
        initAttrs();
        return this.mAnimationViewProtocol.getView();
    }

    @JSMethod(uiThread = true)
    public void play() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "902559676")) {
            ipChange.ipc$dispatch("902559676", new Object[]{this});
        } else if (this.mAnimationViewProtocol != null) {
            YKLAnimationViewProtocol.GiftAnimationItem giftAnimationItem = new YKLAnimationViewProtocol.GiftAnimationItem();
            YKLAnimationViewProtocol.GiftType giftType = YKLAnimationViewProtocol.GiftType.toGiftType(this.type);
            giftAnimationItem.type = giftType;
            giftAnimationItem.autoPlay = this.autoPlay;
            giftAnimationItem.id = this.id;
            giftAnimationItem.properties = this.properties;
            giftAnimationItem.isZip = this.isZip;
            if (AnonymousClass2.$SwitchMap$com$youku$live$dago$widgetlib$protocol$YKLAnimationViewProtocol$GiftType[giftType.ordinal()] != 1) {
                giftAnimationItem.data = this.url;
            } else {
                giftAnimationItem.data = this.giftData;
            }
            this.mAnimationViewProtocol.play(giftAnimationItem);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("code", "2001");
            hashMap.put("msg", "mAnimationViewProtocol is null");
            fireEvent("animationerror", hashMap);
        }
    }

    @JSMethod(uiThread = true)
    public void playLottery(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1840937824")) {
            ipChange.ipc$dispatch("1840937824", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "playLottery");
        if (map != null) {
            List list = null;
            if (map.containsKey("lotteryArray")) {
                list = (List) map.get("lotteryArray");
            }
            int size = (list == null || list.size() <= 1) ? 1 : list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                MineLotteryData mineLotteryData = new MineLotteryData();
                if (list != null) {
                    Map map2 = (Map) list.get(i);
                    if (map2.containsKey("lotteryCount")) {
                        mineLotteryData.lotteryCount = ParseUtils.parse2Int(String.valueOf(map2.get("lotteryCount")));
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "lotteryArray count = " + String.valueOf(map2.get("lotteryCount")));
                    }
                    if (map2.containsKey("lotteryTimes")) {
                        mineLotteryData.lotteryTimes = ParseUtils.parse2Int(String.valueOf(map2.get("lotteryTimes")));
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "lotteryArray lotteryTimes = " + String.valueOf(map2.get("lotteryTimes")));
                    }
                }
                String str = "";
                String valueOf = map.containsKey("userId") ? String.valueOf(map.get("userId")) : str;
                String valueOf2 = map.containsKey("roomId") ? String.valueOf(map.get("roomId")) : str;
                String str2 = (!map.containsKey("lotteryUserName") || map.get("lotteryUserName") == null) ? str : (String) map.get("lotteryUserName");
                String valueOf3 = map.containsKey("lotteryUserId") ? String.valueOf(map.get("lotteryUserId")) : str;
                if (map.containsKey("lotteryUserIcon")) {
                    String.valueOf(map.get("lotteryUserIcon"));
                }
                if (map.containsKey("anchorId")) {
                    String.valueOf(map.get("anchorId"));
                }
                if (map.containsKey("anchorName")) {
                    str2 = map.get("lotteryUserName") == null ? str : (String) map.get("lotteryUserName");
                    mineLotteryData.actorName = String.valueOf(map.get("anchorName"));
                }
                if (map.containsKey("anchorIcon")) {
                    String.valueOf(map.get("anchorIcon"));
                }
                if (map.containsKey("anchorRoomId")) {
                    str = String.valueOf(map.get("anchorRoomId"));
                }
                if (!TextUtils.isEmpty(valueOf2)) {
                    mineLotteryData.roomId = valueOf2;
                }
                mineLotteryData.isPushMsg = !valueOf2.equals(str);
                mineLotteryData.setViewerName(str2);
                if (!valueOf.equals(valueOf3)) {
                    ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "!userId.equals(lotteryUserId)");
                    if (mineLotteryData.lotteryTimes >= 5000) {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-lottery", "lotteryData.lotteryTimes > 5000");
                        mineLotteryData.isPushMsg = true;
                        mineLotteryData.setThirdView();
                        mineLotteryData.setViewer(true);
                        arrayList.add(mineLotteryData);
                    }
                } else {
                    mineLotteryData.setViewer(false);
                    arrayList.add(mineLotteryData);
                }
            }
            if (this.mAnimationViewProtocol != null && arrayList.size() > 0) {
                this.mAnimationViewProtocol.playLottery(arrayList);
            }
        }
    }

    @WXComponentProp(name = "id")
    public void setAnimId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-817179050")) {
            ipChange.ipc$dispatch("-817179050", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.id = str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0067, code lost:
        if (r7 <= 0) goto L_0x0069;
     */
    @WXComponentProp(name = "size")
    public void setAnimViewSize(Map<String, String> map) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202863204")) {
            ipChange.ipc$dispatch("202863204", new Object[]{this, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i("liulei-anim", "set size");
        int i2 = -1;
        if (map != null) {
            int parse2Int = ParseUtils.parse2Int(map.get("width"));
            i = ParseUtils.parse2Int(map.get("height"));
            ((ILog) Dsl.getService(ILog.class)).i("liulei-anim", "set width = " + parse2Int + "   height = " + i);
            if (parse2Int <= 0) {
                parse2Int = -1;
            }
            i2 = parse2Int;
        }
        i = -1;
        YKLAnimationViewProtocol yKLAnimationViewProtocol = this.mAnimationViewProtocol;
        if (yKLAnimationViewProtocol != null) {
            yKLAnimationViewProtocol.setSize(i2, i);
        }
    }

    @WXComponentProp(name = Constants.Name.AUTO_PLAY)
    public void setAutoPlay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-849901697")) {
            ipChange.ipc$dispatch("-849901697", new Object[]{this, str});
            return;
        }
        this.autoPlay = str;
    }

    @WXComponentProp(name = "giftData")
    public void setGiftData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091199080")) {
            ipChange.ipc$dispatch("1091199080", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "Play GiftData = " + str);
        this.giftData = str;
    }

    @WXComponentProp(name = "localPath")
    public void setLocalPath(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1176590580")) {
            ipChange.ipc$dispatch("-1176590580", new Object[]{this, str});
            return;
        }
        this.localPath = str;
    }

    @WXComponentProp(name = IWXAudio.KEY_LOOP)
    public void setLoop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280205361")) {
            ipChange.ipc$dispatch("-280205361", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        String str = i + "";
        this.loop = str;
        this.properties.put(IWXAudio.KEY_LOOP, str);
    }

    @WXComponentProp(name = "type")
    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-559646808")) {
            ipChange.ipc$dispatch("-559646808", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "animation type = " + str);
        this.type = str;
    }

    @WXComponentProp(name = "url")
    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285925613")) {
            ipChange.ipc$dispatch("1285925613", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d("liulei-anim", "Play Url = " + str);
        this.url = str;
    }

    @WXComponentProp(name = "iszip")
    public void setZip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1224344453")) {
            ipChange.ipc$dispatch("-1224344453", new Object[]{this, str});
            return;
        }
        this.isZip = "1".equals(str);
    }

    @WXComponentProp(name = "comboNum")
    public void setcomboNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "667229091")) {
            ipChange.ipc$dispatch("667229091", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        String str = i + "";
        this.comboNum = str;
        this.properties.put("comboNum", str);
    }

    @JSMethod(uiThread = true)
    public void stepToFrame(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1427267909")) {
            ipChange.ipc$dispatch("1427267909", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        YKLAnimationViewProtocol yKLAnimationViewProtocol = this.mAnimationViewProtocol;
        if (yKLAnimationViewProtocol != null) {
            yKLAnimationViewProtocol.stepToFrame(i, z);
        }
    }

    @JSMethod(uiThread = true)
    public void stepToPercentage(double d, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209537413")) {
            ipChange.ipc$dispatch("209537413", new Object[]{this, Double.valueOf(d), Boolean.valueOf(z)});
            return;
        }
        YKLAnimationViewProtocol yKLAnimationViewProtocol = this.mAnimationViewProtocol;
        if (yKLAnimationViewProtocol != null) {
            yKLAnimationViewProtocol.stepToPercentge(d, z);
        }
    }

    private YKLAnimationViewProtocol getAdapter(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "182261911")) {
            return (YKLAnimationViewProtocol) YKLAdapterFactory.getInstance().createInterface(YKLAnimationViewComponent.class, context, str, false);
        }
        return (YKLAnimationViewProtocol) ipChange.ipc$dispatch("182261911", new Object[]{this, context, str});
    }

    public YKLAnimationViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public YKLAnimationViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public YKLAnimationViewComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
    }
}
