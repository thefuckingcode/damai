package com.alibaba.yymidservice.popup.request.requestparam;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.yymidservice.popup.request.PicBaseRequest;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.alient.gaiax.container.util.ChannelUtil;
import com.taobao.orange.OConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/alibaba/yymidservice/popup/request/requestparam/PopupRequestParam;", "Lcom/alibaba/yymidservice/popup/request/PicBaseRequest;", "Lcom/alibaba/yymidservice/popup/request/bean/PopupResponseBean;", "", "comboChannel", "Ljava/lang/String;", "getComboChannel", "()Ljava/lang/String;", "setComboChannel", "(Ljava/lang/String;)V", "comboCityId", "getComboCityId", "setComboCityId", "sceneType", "getSceneType", "setSceneType", "eventType", "getEventType", "setEventType", "Lcom/alibaba/fastjson/JSONObject;", "args", "Lcom/alibaba/fastjson/JSONObject;", "getArgs", "()Lcom/alibaba/fastjson/JSONObject;", "setArgs", "(Lcom/alibaba/fastjson/JSONObject;)V", "<init>", "()V", "yymidservice_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class PopupRequestParam extends PicBaseRequest<PopupResponseBean> {
    @Nullable
    private JSONObject args;
    @Nullable
    private String comboChannel;
    @Nullable
    private String comboCityId;
    @Nullable
    private String eventType;
    @Nullable
    private String sceneType;

    public PopupRequestParam() {
        ChannelUtil channelUtil = ChannelUtil.INSTANCE;
        if (channelUtil.isDamaiApp()) {
            this.API_NAME = "mtop.damai.mec.popup.get";
            this.comboChannel = "1";
        } else if (channelUtil.isTppApp()) {
            this.API_NAME = "mtop.film.life.popup.get";
            this.comboChannel = OConstant.CODE_POINT_EXP_BIND_SERVICE;
        }
        this.VERSION = "1.0";
        this.NEED_ECODE = false;
        this.NEED_SESSION = false;
    }

    @Nullable
    public final JSONObject getArgs() {
        return this.args;
    }

    @Nullable
    public final String getComboChannel() {
        return this.comboChannel;
    }

    @Nullable
    public final String getComboCityId() {
        return this.comboCityId;
    }

    @Nullable
    public final String getEventType() {
        return this.eventType;
    }

    @Nullable
    public final String getSceneType() {
        return this.sceneType;
    }

    public final void setArgs(@Nullable JSONObject jSONObject) {
        this.args = jSONObject;
    }

    public final void setComboChannel(@Nullable String str) {
        this.comboChannel = str;
    }

    public final void setComboCityId(@Nullable String str) {
        this.comboCityId = str;
    }

    public final void setEventType(@Nullable String str) {
        this.eventType = str;
    }

    public final void setSceneType(@Nullable String str) {
        this.sceneType = str;
    }
}
