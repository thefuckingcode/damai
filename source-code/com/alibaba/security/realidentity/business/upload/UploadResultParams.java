package com.alibaba.security.realidentity.business.upload;

import android.text.TextUtils;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;
import com.alibaba.security.common.d.h;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.a.a;
import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.business.c;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.upload.UploadResultRequest;
import com.alibaba.security.realidentity.business.uploadresult.AbsUploadResultParams;
import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.BusinessRequest;
import com.alibaba.security.realidentity.http.model.HttpResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: Taobao */
public class UploadResultParams extends AbsUploadResultParams {
    public static final String[] NUMERIC_STR_ARRAY = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String TAG = UploadResultParams.class.getSimpleName();
    public ALBiometricsResult biometricsResult;
    private BusinessHeadParams mBusinessHeadParams;
    private StartHttpParams startHttpParams;
    public UploadResultResponse uploadResultResponse;
    private List<e> uploadTasks;

    /* compiled from: Taobao */
    public static class EdgeDetectResult implements Serializable {
        public String actionEight = null;
        public String actionFive = null;
        public String actionFour = null;
        public String actionNine = null;
        public String actionOne = null;
        public String actionSeven = null;
        public String actionSix = null;
        public String actionThree = null;
        public String actionTwo = null;
        public String actionZero = null;
        public String stare = null;
    }

    private String actionStringBaseOnActionType(int i) {
        if (i == 1) {
            return "Blink";
        }
        if (i == 2) {
            return "OpenMouth";
        }
        if (i == 3) {
            return "ShakeHead";
        }
        if (i != 10) {
            return i != 11 ? String.valueOf(i) : "KeepStill";
        }
        return "RaiseHeadDown";
    }

    private UploadResultRequest assemable() {
        ArrayList arrayList = new ArrayList();
        UploadResultRequest.Elements elements = new UploadResultRequest.Elements();
        UploadResultRequest.Data data = new UploadResultRequest.Data();
        if (this.biometricsResult.getRecognizeResult() == 1 || this.biometricsResult.getRecognizeResult() == 0) {
            data.localRecognize = Integer.valueOf(this.biometricsResult.getRecognizeResult());
            data.recognizeResultScore = this.biometricsResult.getRecognizeResultScore();
        }
        data.bigImagePath = getUploadTaskByType(this.uploadTasks, a.K);
        data.v = 2;
        data.isGaze = this.startHttpParams.mOnlyGaze;
        BusinessHeadParams businessHeadParams = this.mBusinessHeadParams;
        data.idCardAuthData = businessHeadParams == null ? null : businessHeadParams.getCtidParams();
        BusinessHeadParams businessHeadParams2 = this.mBusinessHeadParams;
        data.useCtid = businessHeadParams2 != null && businessHeadParams2.isCtidCalled();
        if (this.startHttpParams.mNeedActionImage) {
            for (int i = 0; i < this.biometricsResult.getAs().size(); i++) {
                String actionStringBaseOnActionType = actionStringBaseOnActionType(this.biometricsResult.getAs().get(i).getAt());
                UploadResultRequest.ActionType actionType = new UploadResultRequest.ActionType();
                actionType.type = actionStringBaseOnActionType;
                actionType.image_1 = getUploadTaskByType(this.uploadTasks, "action".concat(String.valueOf(i)));
                try {
                    UploadResultRequest.Data.class.getField(String.format("movement_%d", Integer.valueOf(i + 1))).set(data, actionType);
                } catch (NoSuchFieldException unused) {
                    com.alibaba.security.common.c.a.b();
                } catch (IllegalAccessException unused2) {
                    com.alibaba.security.common.c.a.b();
                }
            }
        }
        data.bigSmallPath = getUploadTaskByType(this.uploadTasks, a.M);
        data.bigSmallLocalPath = getUploadTaskByType(this.uploadTasks, a.L);
        data.originalImage = getUploadTaskByType(this.uploadTasks, a.N);
        int[] fr = this.biometricsResult.getQi().getFr();
        if (fr != null && fr.length == 4) {
            data.faceRect = String.format("%d,%d,%d,%d", Integer.valueOf(fr[0]), Integer.valueOf(fr[1]), Integer.valueOf(fr[2]), Integer.valueOf(fr[3]));
        }
        String bgDetectResult = this.biometricsResult.getBgDetectResult();
        if (bgDetectResult != null) {
            EdgeDetectResult edgeDetectResult = new EdgeDetectResult();
            String[] split = bgDetectResult.split(";");
            for (int i2 = 0; i2 < split.length; i2++) {
                try {
                    EdgeDetectResult.class.getField(i2 == 0 ? "stare" : "action" + NUMERIC_STR_ARRAY[i2]).set(edgeDetectResult, split[i2]);
                } catch (NoSuchFieldException unused3) {
                    com.alibaba.security.common.c.a.b();
                } catch (IllegalAccessException unused4) {
                    com.alibaba.security.common.c.a.b();
                }
            }
            data.backgroundDetectResult = h.a(edgeDetectResult);
        }
        data.processDetail = this.biometricsResult.toJson();
        UploadResultRequest uploadResultRequest = new UploadResultRequest();
        elements.value = data;
        uploadResultRequest.verifyToken = this.mVerifyToken;
        arrayList.add(elements);
        if (!TextUtils.isEmpty(this.biometricsResult.getDazzleVideoPath())) {
            UploadResultRequest.Elements elements2 = new UploadResultRequest.Elements();
            elements2.name = "BIOMETRIC_COLORFUL";
            UploadResultRequest.Data data2 = new UploadResultRequest.Data();
            UploadResultRequest.a aVar = new UploadResultRequest.a();
            aVar.a = this.biometricsResult.getDazzleVideoOssUrl();
            aVar.c = this.biometricsResult.getVideoHash();
            UploadResultRequest.b bVar = new UploadResultRequest.b();
            bVar.a = this.biometricsResult.getDazzleDataConfigs();
            aVar.b = bVar;
            String a = h.a(aVar);
            if (a != null) {
                data2.data = com.alibaba.security.common.d.a.a(ALBiometricsJni.makeResult(a.getBytes(), String.valueOf(new Date().getTime()), GetCacheDataManager.getInstance().getUmidToken()));
            }
            elements2.value = data2;
            arrayList.add(elements2);
        }
        arrayList.add(getRiskActionElements());
        uploadResultRequest.elements = h.a(arrayList);
        return uploadResultRequest;
    }

    private UploadResultRequest.Elements getRiskActionElements() {
        UploadResultRequest.Elements elements = new UploadResultRequest.Elements();
        elements.name = "RISK_ACTION";
        UploadResultRequest.Data data = new UploadResultRequest.Data();
        if (!TextUtils.isEmpty(this.biometricsResult.getCollectedData())) {
            data.sensorActionLog = this.biometricsResult.getCollectedData();
        }
        if (!TextUtils.isEmpty(this.biometricsResult.getBh())) {
            data.flActionLog = this.biometricsResult.getBh();
        }
        elements.value = data;
        return elements;
    }

    private String getUploadTaskByType(List<e> list, String str) {
        if (list == null) {
            return "";
        }
        for (e eVar : list) {
            if (TextUtils.equals(str, eVar.a)) {
                return eVar.a();
            }
        }
        return "";
    }

    @Override // com.alibaba.security.realidentity.business.bucket.HttpBucketParams
    public HttpBucketParams doTransform(HttpResponse httpResponse) {
        if (httpResponse instanceof UploadResultResponse) {
            this.uploadResultResponse = (UploadResultResponse) httpResponse;
        }
        return this;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BusinessHttpWrapper getRpcRequest() {
        return new BusinessHttpWrapper(UploadResultResponse.class, new BusinessRequest(UploadResultRequest.class, assemable()));
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public boolean onDelivering(c cVar) {
        this.startHttpParams = cVar.c;
        this.biometricsResult = cVar.d.biometricsResult;
        this.mBusinessHeadParams = cVar.b;
        this.uploadTasks = cVar.e.getUploadTaskList();
        return true;
    }

    @Override // com.alibaba.security.realidentity.business.bucket.BucketParams
    public BucketParams.ErrorCode parseErrorCode() {
        UploadResultResponse uploadResultResponse2 = this.uploadResultResponse;
        if (uploadResultResponse2 == null) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10300", "start api fail, response is null", GlobalErrorCode.ERROR_ONLINE_NET_ERROR);
        }
        if (uploadResultResponse2.isSuccessful()) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_PASS, "0", "upload result success", 0);
        }
        if (!TextUtils.isEmpty(this.uploadResultResponse.getRetCode())) {
            return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10303", this.uploadResultResponse.getRetMsg(), GlobalErrorCode.ERROR_UPLOAD_BIO_DATA);
        }
        return new BucketParams.ErrorCode(RPResult.AUDIT_NOT, "-10303", h.a(this.uploadResultResponse), GlobalErrorCode.ERROR_UPLOAD_BIO_DATA);
    }
}
