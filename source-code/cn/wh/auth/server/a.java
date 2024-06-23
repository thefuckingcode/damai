package cn.wh.auth.server;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import cn.wh.auth.server.ResultRequestService;

/* compiled from: Taobao */
public class a extends Fragment {
    public static final String TAG = "on_wh_local_result_dispatcher";
    private SparseArray<ResultRequestService.Callback> a = new SparseArray<>();

    public void a(Intent intent, ResultRequestService.Callback callback) {
        this.a.put(120, callback);
        startActivityForResult(intent, 111);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ResultRequestService.Callback callback = this.a.get(120);
        this.a.remove(i);
        if (callback != null) {
            callback.onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
