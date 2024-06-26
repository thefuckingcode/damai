package tb;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.update.datasource.IUpdater;
import com.taobao.update.datasource.data.UpdateDataListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class u2 extends AccsAbstractDataListener implements IUpdater {
    public static final String SERVICE_ID = "mtl";
    private List<UpdateDataListener> a = new ArrayList();
    private fs2 b;

    public u2(fs2 fs2) {
        this.b = fs2;
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void dispatchUpdate(String str, boolean z, String str2, String... strArr) {
        for (UpdateDataListener updateDataListener : new ArrayList(this.a)) {
            updateDataListener.onUpdate(str, null, z, str2, strArr);
        }
    }

    @Override // com.taobao.update.datasource.IUpdater
    public String from() {
        return js2.ACCS_SOURCE;
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        String str4;
        if (bArr != null) {
            try {
                str4 = new String(bArr, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                str4 = null;
            }
            Log.i("AccsUpdater", "AccsUpdaterCenter.onData : " + str4);
            fs2 fs2 = this.b;
            if (fs2 != null) {
                fs2.commitSuccess("update_center_accs", "accs_message_receiver", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                dispatchUpdate(from(), true, str4, str3);
            }
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void registerDataListener(UpdateDataListener updateDataListener) {
        synchronized (this.a) {
            this.a.add(updateDataListener);
        }
    }

    @Override // com.taobao.update.datasource.IUpdater
    public void unRegisterDataListener(UpdateDataListener updateDataListener) {
        synchronized (this.a) {
            this.a.remove(updateDataListener);
        }
    }
}
