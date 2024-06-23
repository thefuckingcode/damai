package cn.wh.auth.server;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;

/* compiled from: Taobao */
public class ResultRequestService {
    private a a;

    /* compiled from: Taobao */
    public interface Callback {
        void onActivityResult(int i, int i2, Intent intent);
    }

    public ResultRequestService(Activity activity) {
        this.a = b(activity);
    }

    private a a(FragmentManager fragmentManager) {
        return (a) fragmentManager.findFragmentByTag(a.TAG);
    }

    private a b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        a a2 = a(fragmentManager);
        if (a2 != null) {
            return a2;
        }
        a aVar = new a();
        fragmentManager.beginTransaction().add(aVar, a.TAG).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return aVar;
    }

    public void c(Intent intent, Callback callback) {
        this.a.a(intent, callback);
    }
}
