package tb;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.taobao.tao.log.upload.TLogUploadDiagnoseListener;
import com.taobao.tlog.remote.TLogDiagnose;
import java.util.Map;

/* compiled from: Taobao */
public final /* synthetic */ class ii2 implements TLogUploadDiagnoseListener {
    public final /* synthetic */ TLogDiagnose a;
    public final /* synthetic */ WVCallBackContext b;

    public /* synthetic */ ii2(TLogDiagnose tLogDiagnose, WVCallBackContext wVCallBackContext) {
        this.a = tLogDiagnose;
        this.b = wVCallBackContext;
    }

    @Override // com.taobao.tao.log.upload.TLogUploadDiagnoseListener
    public final void onEvent(String str, String str2, String str3, Map map) {
        TLogDiagnose.a(this.a, this.b, str, str2, str3, map);
    }
}
