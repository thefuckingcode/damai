package com.taobao.updatecenter.hotpatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import java.util.Random;

/* compiled from: Taobao */
public class HotpatchReceiver extends BroadcastReceiver {
    public static final String ACTION_AGOO_MSG = "com.taobao.tao.msgcenter.agoo";
    public static final String AGOO_MSG_BODY = "taobao_agoo_msg";
    private String a;

    public HotpatchReceiver(String str) {
        this.a = str;
    }

    public static String a(String str) {
        try {
            return JSON.parseObject(str).getString("text").split(":")[1];
        } catch (Exception unused) {
            return "";
        }
    }

    public void onReceive(Context context, Intent intent) {
        Log.d("hotpatch_push", "receive intent" + intent.getAction());
        if (ACTION_AGOO_MSG.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(AGOO_MSG_BODY);
            Log.d("hotpatch_push", "get agoo push message " + stringExtra);
            if (stringExtra != null) {
                try {
                    String[] split = a(stringExtra).split(";");
                    if (split.length >= 3 && split[0].contains("hotpatch") && split[1].contains(this.a)) {
                        Log.d("hotpatch_push", "agoo query");
                        int parseInt = Integer.parseInt(split[2]);
                        if (parseInt == 0) {
                            HotPatchManager.getInstance().queryNewHotPatch(false);
                        } else {
                            new Handler().postDelayed(new Runnable() {
                                /* class com.taobao.updatecenter.hotpatch.HotpatchReceiver.AnonymousClass1 */

                                public void run() {
                                    HotPatchManager.getInstance().queryNewHotPatch(false);
                                }
                            }, (long) new Random().nextInt(parseInt * 1000));
                        }
                    }
                } catch (Exception unused) {
                    Log.d("hotpatch_push", "push hotpach query e");
                }
            }
        }
    }
}
