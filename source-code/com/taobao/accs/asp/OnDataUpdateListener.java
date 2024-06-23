package com.taobao.accs.asp;

import androidx.annotation.Keep;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.exception.IPCException;

/* access modifiers changed from: package-private */
@Callback
@Keep
/* compiled from: Taobao */
public interface OnDataUpdateListener {
    @Keep
    void onDataUpdate(ModifiedRecord modifiedRecord) throws IPCException;
}
