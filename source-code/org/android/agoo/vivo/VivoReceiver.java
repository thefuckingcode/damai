package org.android.agoo.vivo;

import android.content.Context;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import org.android.agoo.assist.AssistManager;

/* compiled from: Taobao */
public class VivoReceiver extends OpenClientPushMessageReceiver {
    @Override // com.vivo.push.sdk.PushMessageCallback, com.vivo.push.sdk.OpenClientPushMessageReceiver
    public void onReceiveRegId(Context context, String str) {
        AssistManager.reportToken(str);
    }
}
