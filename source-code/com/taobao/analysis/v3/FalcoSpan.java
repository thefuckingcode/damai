package com.taobao.analysis.v3;

import androidx.annotation.NonNull;
import com.taobao.opentracing.api.Span;
import tb.qf2;

/* compiled from: Taobao */
public interface FalcoSpan extends Span {
    public static final qf2 ERROR_CODE = new qf2("errorCode");

    FalcoStage customStage(@NonNull String str);

    void debugLog(String str);

    void finish(long j, String str);

    void finish(String str);

    String getLayer();

    String getModule();

    String getScene();

    void releaseLog(String str);
}
