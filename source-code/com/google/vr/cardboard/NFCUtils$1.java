package com.google.vr.cardboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

/* compiled from: Taobao */
class NFCUtils$1 extends BroadcastReceiver {
    final /* synthetic */ d a;

    public void onReceive(Context context, Intent intent) {
        Log.i(d.a, "Got an NFC tag!");
        this.a.b((Tag) intent.getParcelableExtra("android.nfc.extra.TAG"));
    }
}
