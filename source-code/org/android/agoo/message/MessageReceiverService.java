package org.android.agoo.message;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.BaseIntentService;
import org.android.agoo.service.SendMessage;

/* compiled from: Taobao */
public abstract class MessageReceiverService extends Service {
    private static final String TAG = "MessageReceiverService";
    SendMessage.Stub binderMsgRecv = new SendMessage.Stub() {
        /* class org.android.agoo.message.MessageReceiverService.AnonymousClass1 */

        @Override // org.android.agoo.service.SendMessage
        public int doSend(Intent intent) throws RemoteException {
            Context applicationContext = MessageReceiverService.this.getApplicationContext();
            MessageReceiverService messageReceiverService = MessageReceiverService.this;
            BaseIntentService.runIntentInService(applicationContext, intent, messageReceiverService.getIntentServiceClassName(messageReceiverService.getApplicationContext()));
            return 0;
        }
    };

    public abstract String getIntentServiceClassName(Context context);

    public IBinder onBind(Intent intent) {
        ALog.d(TAG, "Message receiver aidl was binded {}", intent.getAction());
        if (AgooConstants.BINDER_MSGRECEIVER_ACTION.equals(intent.getAction())) {
            return this.binderMsgRecv;
        }
        return this.binderMsgRecv;
    }

    public void onCreate() {
        super.onCreate();
    }
}
