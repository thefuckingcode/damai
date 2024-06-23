package com.heytap.msp.push.callback;

import android.content.Context;
import com.heytap.msp.push.mode.DataMessage;

/* compiled from: Taobao */
public interface IDataMessageCallBackService {
    void processMessage(Context context, DataMessage dataMessage);
}
