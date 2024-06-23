package tb;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.app.AppConfigItem;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class p8 implements Handler.Callback {
    private c7 a;
    private final Handler b = new Handler(Looper.getMainLooper(), this);

    public p8(c7 c7Var) {
        this.a = c7Var;
    }

    public void a(AppConfigItem appConfigItem) {
        try {
            long endTimeStamp = appConfigItem.getEndTimeStamp() - PopLayer.getReference().getCurrentTimeStamp();
            if (endTimeStamp < 0) {
                endTimeStamp = 0;
            }
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("config_uuid", appConfigItem.uuid);
            message.setData(bundle);
            cr1.b("AutoCloseMgr.installCloseTimer:config:{%s},delay:{%s}.", appConfigItem.toString(), Long.valueOf(endTimeStamp));
            this.b.sendMessageDelayed(message, endTimeStamp);
        } catch (Throwable th) {
            cr1.c("AutoCloseMgr.installCloseTimer.error.", th);
        }
    }

    public boolean handleMessage(Message message) {
        try {
            String string = message.getData().getString("config_uuid");
            cr1.b("AutoCloseMgr.cmtTimeMarkStop config uuid:{%s}.", string);
            this.a.E(string);
            return true;
        } catch (Throwable th) {
            cr1.c("DispatchManager.handleMessage.error.", th);
            return false;
        }
    }
}
