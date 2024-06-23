package com.youku.live.dago.widgetlib.module;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.widgetlib.component.DagoUserCardDialog;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.Map;

/* compiled from: Taobao */
public class YKLUserCardModule extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DAGO_LIVE_START_OR_STOP_PROP = "dagoLiveStartOrStopProp";
    private static final String TAG = "YKLUserCardModule";
    private String mAnchorId = "";
    private DagoUserCardDialog mDialog;
    private IEngineInstance mEngineInstance;
    private String mScreenId = "";

    private void closeDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056923118")) {
            ipChange.ipc$dispatch("2056923118", new Object[]{this});
            return;
        }
        DagoUserCardDialog dagoUserCardDialog = this.mDialog;
        if (dagoUserCardDialog != null) {
            dagoUserCardDialog.dismiss();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
        if (((java.lang.Boolean) r1).booleanValue() == false) goto L_0x0048;
     */
    private void showUserCardDialog(Context context, boolean z, String str, boolean z2, String str2, JSCallback jSCallback) {
        String str3;
        IProps options;
        IpChange ipChange = $ipChange;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "627726332")) {
            ipChange.ipc$dispatch("627726332", new Object[]{this, context, Boolean.valueOf(z), str, Boolean.valueOf(z2), str2, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            Object data = widgetEngineInstance.getData("dagoLiveStartOrStopProp");
            if (data instanceof Boolean) {
            }
        }
        z3 = false;
        String str4 = "";
        if (widgetEngineInstance == null || (options = widgetEngineInstance.getOptions()) == null) {
            str3 = str4;
        } else {
            String string = options.getString("pagename", str4);
            str3 = options.getString("spm-cnt", str4);
            str4 = string;
        }
        DagoUserCardDialog dagoUserCardDialog = new DagoUserCardDialog(context, z3);
        this.mDialog = dagoUserCardDialog;
        dagoUserCardDialog.setActor(z);
        this.mDialog.setShowChatEntrance(z2);
        this.mDialog.setUTPageName(str4);
        this.mDialog.setUTAnchorId(this.mAnchorId);
        this.mDialog.setUTScreenId(this.mScreenId);
        this.mDialog.setUTSpmCnt(str3);
        this.mDialog.setRoomId(str);
        this.mDialog.setTargetUserId(str2);
        this.mDialog.setJSCallback(jSCallback);
        this.mDialog.showDialog();
    }

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376295146")) {
            ipChange.ipc$dispatch("-1376295146", new Object[]{this});
            return;
        }
        closeDialog();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490042476")) {
            ipChange.ipc$dispatch("-490042476", new Object[]{this});
        } else if (this.mDialog != null) {
            this.mDialog = null;
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167009317")) {
            ipChange.ipc$dispatch("167009317", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str) && (obj instanceof LiveFullInfoData)) {
            LiveFullInfoData liveFullInfoData = (LiveFullInfoData) obj;
            this.mAnchorId = liveFullInfoData.anchorYtid + "";
            this.mScreenId = liveFullInfoData.screenId + "";
        }
    }

    @JSMethod
    public void open(Map<String, String> map, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904434283")) {
            ipChange.ipc$dispatch("-1904434283", new Object[]{this, map, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            this.mEngineInstance = widgetEngineInstance;
            widgetEngineInstance.addDataHandler("mtop.youku.live.com.livefullinfo", this);
            String str = map.get("userId");
            String str2 = map.get("isAnchor");
            String str3 = map.get("showChatEntrance");
            showUserCardDialog(this.mEngineInstance.getContext(), TextUtils.isEmpty(str2) ? false : "true".equals(str2), map.get("roomId"), TextUtils.isEmpty(str3) ? true : "true".equals(str3), str, jSCallback);
        }
    }
}
