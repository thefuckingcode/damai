package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.widgetlib.ailpbaselib.framework.AILPAdapterFactory;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.OnCellClickListener;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPChatListProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Map;

/* compiled from: Taobao */
public class AILPChatListComponent extends ProxyWXComponent<View> implements OnCellClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoChatListComponent";
    private AILPChatListProtocol mChatList;
    private String mTag = null;
    private String topMaskHeightScale;
    private String topMaskStartAlpha;

    public AILPChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        initTag(basicComponentData);
    }

    private String checkNull(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1877052942")) {
            return TextUtils.isEmpty(str) ? str2 : str;
        }
        return (String) ipChange.ipc$dispatch("1877052942", new Object[]{this, str, str2});
    }

    private void initTag(BasicComponentData basicComponentData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2038146048")) {
            ipChange.ipc$dispatch("-2038146048", new Object[]{this, basicComponentData});
            return;
        }
        try {
            this.mTag = (String) basicComponentData.getAttrs().get("tag");
        } catch (Exception e) {
            e.printStackTrace();
        }
        parseTipStyle(basicComponentData);
    }

    private void parseTipStyle(BasicComponentData basicComponentData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609428319")) {
            ipChange.ipc$dispatch("-1609428319", new Object[]{this, basicComponentData});
            return;
        }
        try {
            this.topMaskHeightScale = (String) basicComponentData.getAttrs().get("topMaskHeightScale");
            this.topMaskStartAlpha = (String) basicComponentData.getAttrs().get("topMaskStartAlpha");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.topMaskHeightScale = checkNull(this.topMaskHeightScale, "");
        this.topMaskStartAlpha = checkNull(this.topMaskStartAlpha, "");
    }

    @JSMethod(uiThread = false)
    public void addChatListMessage(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580788690")) {
            ipChange.ipc$dispatch("-580788690", new Object[]{this, str, map});
            return;
        }
        insertMessage(map, false);
    }

    @JSMethod(uiThread = false)
    public void clearChatListMessage(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2076771074")) {
            ipChange.ipc$dispatch("2076771074", new Object[]{this, str, map});
            return;
        }
        clearMessage();
    }

    public void clearMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259931421")) {
            ipChange.ipc$dispatch("-1259931421", new Object[]{this});
            return;
        }
        AILPChatListProtocol aILPChatListProtocol = this.mChatList;
        if (aILPChatListProtocol != null) {
            aILPChatListProtocol.clearMessage();
        }
    }

    /* access modifiers changed from: protected */
    public AILPChatListProtocol createAdapter(Context context) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2066448027")) {
            return (AILPChatListProtocol) AILPAdapterFactory.getInstance().createInterface(AILPChatListComponent.class, context);
        }
        return (AILPChatListProtocol) ipChange.ipc$dispatch("-2066448027", new Object[]{this, context});
    }

    public AILPChatListProtocol getChatList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2116370094")) {
            return this.mChatList;
        }
        return (AILPChatListProtocol) ipChange.ipc$dispatch("-2116370094", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1865197577")) {
            return (View) ipChange.ipc$dispatch("-1865197577", new Object[]{this, context});
        }
        String str = this.mTag;
        if (str != null) {
            this.mChatList = createAdapter(context, str);
        } else {
            this.mChatList = createAdapter(context);
        }
        AILPChatListProtocol aILPChatListProtocol = this.mChatList;
        if (aILPChatListProtocol == null) {
            return null;
        }
        aILPChatListProtocol.setMaskLayer(this.topMaskHeightScale, this.topMaskStartAlpha);
        this.mChatList.setOnCellClickListener(this);
        return this.mChatList.getView();
    }

    public void insertMessage(Map<String, Object> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586859538")) {
            ipChange.ipc$dispatch("-586859538", new Object[]{this, map, Boolean.valueOf(z)});
            return;
        }
        AILPChatListProtocol aILPChatListProtocol = this.mChatList;
        if (aILPChatListProtocol == null) {
            return;
        }
        if (z) {
            aILPChatListProtocol.mergeLastMessage(map);
        } else {
            aILPChatListProtocol.insert(map);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.OnCellClickListener
    public void onCellClick(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "245568245")) {
            ipChange.ipc$dispatch("245568245", new Object[]{this, str, map});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, str);
        if ("onAttentionClicked".equals(str)) {
            getInstance().fireGlobalEventCallback("chatListClickEvent", map);
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "key:" + ((Object) entry.getKey()) + " value:" + entry.getValue());
        }
        fireEvent(str, map);
    }

    @WXComponentProp(name = "limit")
    public void setLimitSize(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800532685")) {
            ipChange.ipc$dispatch("800532685", new Object[]{this, str});
        }
    }

    @WXComponentProp(name = "limit-size")
    public void setMaxSize(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574796228")) {
            ipChange.ipc$dispatch("574796228", new Object[]{this, str});
            return;
        }
        AILPChatListProtocol aILPChatListProtocol = this.mChatList;
        if (aILPChatListProtocol != null) {
            aILPChatListProtocol.setLimitSize(str);
        }
    }

    @WXComponentProp(name = "message-delay")
    public void setMessageDelay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733272025")) {
            ipChange.ipc$dispatch("1733272025", new Object[]{this, str});
            return;
        }
        AILPChatListProtocol aILPChatListProtocol = this.mChatList;
        if (aILPChatListProtocol != null) {
            aILPChatListProtocol.setMessageDelay(str);
        }
    }

    @WXComponentProp(name = "tag")
    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734760399")) {
            ipChange.ipc$dispatch("734760399", new Object[]{this, str});
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateAttrs(WXComponent wXComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150373305")) {
            ipChange.ipc$dispatch("1150373305", new Object[]{this, wXComponent});
            return;
        }
        super.updateAttrs(wXComponent);
    }

    @JSMethod(uiThread = false)
    public void updateLastMessage(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801921056")) {
            ipChange.ipc$dispatch("1801921056", new Object[]{this, map});
            return;
        }
        insertMessage(map, true);
    }

    /* access modifiers changed from: protected */
    public AILPChatListProtocol createAdapter(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1742742181")) {
            return (AILPChatListProtocol) AILPAdapterFactory.getInstance().createInterface(AILPChatListComponent.class, context, str, true);
        }
        return (AILPChatListProtocol) ipChange.ipc$dispatch("-1742742181", new Object[]{this, context, str});
    }

    public AILPChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        initTag(basicComponentData);
    }

    public AILPChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        initTag(basicComponentData);
    }

    public AILPChatListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        initTag(basicComponentData);
    }
}
