package tb;

import com.taobao.update.adapter.Log;

/* compiled from: Taobao */
public class z81 implements Log {
    @Override // com.taobao.update.adapter.Log
    public void debug(String str, String str2) {
        android.util.Log.d(str, str2);
    }

    @Override // com.taobao.update.adapter.Log
    public void error(String str, String str2, Throwable... thArr) {
        if (thArr == null || thArr.length <= 0) {
            android.util.Log.e(str, str2);
        } else {
            android.util.Log.e(str, str2, thArr[0]);
        }
    }
}
