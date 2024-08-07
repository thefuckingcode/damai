package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.utility.SetupTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: Taobao */
final class r implements ValueCallback<SetupTask> {
    LinkedList<Pair<String, HashMap<String, String>>> a = new LinkedList<>();
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ o c;

    r(o oVar, ValueCallback valueCallback) {
        this.c = oVar;
        this.b = valueCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(SetupTask setupTask) {
        SetupTask setupTask2 = setupTask;
        if (setupTask2.getStat().second == null) {
            IWaStat.WaStat.stat((String) setupTask2.getStat().first);
            return;
        }
        this.a.add(setupTask2.getStat());
        boolean z = true;
        boolean z2 = UCSetupTask.getTotalLoadedUCM() != null;
        boolean z3 = z2 && UCSetupTask.getTotalLoadedUCM().coreType == 2;
        if (!z2 || UCSetupTask.getTotalLoadedUCM().coreType == 2) {
            z = false;
        }
        if (((String) setupTask2.getStat().first).equals(IWaStat.SETUP_TOTAL_EXCEPTION) || z3 || Log.enabled()) {
            Iterator<Pair<String, HashMap<String, String>>> it = this.a.iterator();
            while (it.hasNext()) {
                Pair<String, HashMap<String, String>> next = it.next();
                if (!"sdk_7z".equals(next.first) && !IWaStat.SETUP_TASK_VERIFY_DETAIL.equals(next.first)) {
                    IWaStat.SETUP_TASK_VERIFY.equals(next.first);
                }
                ValueCallback valueCallback = this.b;
                if (valueCallback == null) {
                    IWaStat.WaStat.statAKV(next);
                } else {
                    setupTask2.mStat = next;
                    valueCallback.onReceiveValue(setupTask2);
                }
            }
            this.a.clear();
        } else if (z) {
            this.a.clear();
        }
    }
}
