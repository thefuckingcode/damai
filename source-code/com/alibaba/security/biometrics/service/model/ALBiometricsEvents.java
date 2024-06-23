package com.alibaba.security.biometrics.service.model;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;

/* compiled from: Taobao */
public class ALBiometricsEvents {

    /* compiled from: Taobao */
    public interface OnActionEndListener {
        void onActionEnd(ABDetectType aBDetectType, int i, int i2);
    }

    /* compiled from: Taobao */
    public interface OnActionStartListener {
        void onActionStart(ABDetectType aBDetectType, int i, int i2);
    }

    /* compiled from: Taobao */
    public interface OnAdjustEndListener {
        void onAdjustEnd();
    }

    /* compiled from: Taobao */
    public interface OnAdjustStartListener {
        void onAdjustStart();
    }

    /* compiled from: Taobao */
    public interface OnBeforeRetryListener {
        void onBeforeRetry(OnRetryListener onRetryListener, String str);
    }

    /* compiled from: Taobao */
    public interface OnCancelListener {
        void onCancel(int i);
    }

    /* compiled from: Taobao */
    public interface OnDetectContinueListener {
        void onDetectContinue(ABImageResult aBImageResult);
    }

    /* compiled from: Taobao */
    public interface OnDetectStartListener {
        void onDetectStart();
    }

    /* compiled from: Taobao */
    public interface OnFinishListener {
        void onFinish(int i, Bundle bundle);
    }

    /* compiled from: Taobao */
    public interface OnFrameDetectedListener {
        void onFrameDetected(ABDetectFrame aBDetectFrame);
    }

    /* compiled from: Taobao */
    public interface OnMessageListener {
        void onMessage(int i, Bundle bundle);
    }

    /* compiled from: Taobao */
    public interface OnRecognizeEndListener {
        void onRecognizeEnd();
    }

    /* compiled from: Taobao */
    public interface OnRecognizeStartListener {
        void onRecognizeStart();
    }

    /* compiled from: Taobao */
    public interface OnReflectEndListener {
        void onReflectEnd();
    }

    /* compiled from: Taobao */
    public interface OnReflectStartListener {
        void onReflectStart();
    }
}
