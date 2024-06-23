package tb;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.connect.api.ApiConstants;
import com.heytap.msp.push.mode.BaseMode;

/* compiled from: Taobao */
public class w03 extends y23 {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return b(intent, i);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public BaseMode b(Intent intent, int i) {
        try {
            a23 a23 = new a23();
            a23.b(Integer.parseInt(c23.f(intent.getStringExtra("command"))));
            a23.d(Integer.parseInt(c23.f(intent.getStringExtra("code"))));
            a23.g(c23.f(intent.getStringExtra("content")));
            a23.c(c23.f(intent.getStringExtra("appKey")));
            a23.e(c23.f(intent.getStringExtra(ApiConstants.APPSECRET)));
            a23.i(c23.f(intent.getStringExtra("appPackage")));
            w33.a("OnHandleIntent-message:" + a23.toString());
            return a23;
        } catch (Exception e) {
            w33.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
