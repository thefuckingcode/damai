package com.alibaba.security.realidentity.business.upload;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import com.alibaba.security.realidentity.http.model.HttpRequest;
import com.taobao.weex.common.WXConfig;
import java.io.Serializable;

@Api(method = HttpMethod.POST, name = "mtop.verifycenter.rp.upload")
@Body
/* compiled from: Taobao */
public class UploadResultRequest extends HttpRequest {
    public String elements;
    public String verifyToken;

    /* compiled from: Taobao */
    public static class ActionType implements Serializable {
        @JSONField(name = "image_1")
        public String image_1;
        @JSONField(name = "type")
        public String type;
    }

    /* compiled from: Taobao */
    public static class Data implements Serializable {
        @JSONField(name = "backgroundDetectResult")
        public String backgroundDetectResult = "";
        @JSONField(name = com.alibaba.security.realidentity.a.a.K)
        public String bigImagePath;
        @JSONField(name = com.alibaba.security.realidentity.a.a.L)
        public String bigSmallLocalPath;
        @JSONField(name = "refImage")
        public String bigSmallPath;
        @JSONField(name = "data")
        public String data;
        @JSONField(name = "faceRect")
        public String faceRect;
        @JSONField(name = "flActionLog")
        public String flActionLog;
        @JSONField(name = "idCardAuthData")
        public String idCardAuthData;
        @JSONField(name = "isGaze")
        public boolean isGaze;
        @JSONField(name = "K_FACE_R_ENABLE")
        public Integer localRecognize = null;
        @JSONField(name = "movement_1")
        public ActionType movement_1 = null;
        @JSONField(name = "movement_2")
        public ActionType movement_2 = null;
        @JSONField(name = "movement_3")
        public ActionType movement_3 = null;
        @JSONField(name = "movement_4")
        public ActionType movement_4 = null;
        @JSONField(name = "movement_5")
        public ActionType movement_5 = null;
        @JSONField(name = "movement_6")
        public ActionType movement_6 = null;
        @JSONField(name = "movement_7")
        public ActionType movement_7 = null;
        @JSONField(name = "movement_8")
        public ActionType movement_8 = null;
        @JSONField(name = com.alibaba.security.realidentity.a.a.N)
        public String originalImage;
        @JSONField(name = "processDetail")
        public String processDetail;
        @JSONField(name = "recognizeResultScore")
        public float recognizeResultScore = 0.0f;
        @JSONField(name = "sensorActionLog")
        public String sensorActionLog;
        @JSONField(name = "smallImageMode")
        public int smallImageModel = 1;
        @JSONField(name = "useCtid")
        public boolean useCtid;
        @JSONField(name = "v")
        public int v = 1;
    }

    /* compiled from: Taobao */
    public static class Elements implements Serializable {
        @JSONField(name = "name")
        public String name = "Biometric";
        @JSONField(name = "value")
        public Data value;
        @JSONField(name = "valueMeta")
        public String valueMeta = "JsonType";
    }

    /* compiled from: Taobao */
    public static class a {
        @JSONField(name = "url")
        public String a;
        @JSONField(name = "videoExtra")
        public b b;
        @JSONField(name = "videoHash")
        public String c;
    }

    /* compiled from: Taobao */
    public static class b {
        @JSONField(name = "conf")
        public Object a;
        @JSONField(name = WXConfig.osName)
        public String b = "android";
    }
}
