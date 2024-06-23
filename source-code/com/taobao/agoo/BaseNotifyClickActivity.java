package com.taobao.agoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.taobao.accs.utl.ALog;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
public class BaseNotifyClickActivity extends Activity {
    private static final String TAG = "Naccs.BaseNotifyClickActivity";
    public static Set<INotifyListener> notifyListeners;
    private BaseNotifyClick baseNotifyClick = new a();

    /* compiled from: Taobao */
    public interface INotifyListener {
        String getMsgSource();

        String parseMsgFromIntent(Intent intent);
    }

    /* compiled from: Taobao */
    class a extends BaseNotifyClick {
        a() {
        }

        @Override // com.taobao.agoo.BaseNotifyClick
        public void onMessage(Intent intent) {
            BaseNotifyClickActivity.this.onMessage(intent);
        }
    }

    public static void addNotifyListener(INotifyListener iNotifyListener) {
        if (notifyListeners == null) {
            notifyListeners = new HashSet();
        }
        notifyListeners.add(iNotifyListener);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ALog.i(TAG, "onCreate", new Object[0]);
        this.baseNotifyClick.onCreate(this, getIntent());
    }

    public void onMessage(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ALog.i(TAG, "onNewIntent", new Object[0]);
        this.baseNotifyClick.onNewIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }
}
