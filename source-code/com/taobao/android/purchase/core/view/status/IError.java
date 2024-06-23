package com.taobao.android.purchase.core.view.status;

import android.content.Context;
import mtopsdk.mtop.domain.MtopResponse;
import tb.aw1;

/* compiled from: Taobao */
public interface IError {
    void onError(aw1 aw1, Context context, int i, MtopResponse mtopResponse);
}
