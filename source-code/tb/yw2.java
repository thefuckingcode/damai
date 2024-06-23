package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import cn.wh.auth.AuthService;
import cn.wh.auth.OnCallBack;
import cn.wh.auth.server.ResultRequestService;

/* compiled from: Taobao */
public abstract class yw2 implements AuthService {
    OnCallBack a;
    Activity b;
    ax2 c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements ResultRequestService.Callback {
        final /* synthetic */ j12 a;

        a(j12 j12) {
            this.a = j12;
        }

        @Override // cn.wh.auth.server.ResultRequestService.Callback
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 != -1 || i != 111) {
                this.a.d(com.alibaba.security.realidentity.a.y);
                this.a.e("数据处理异常");
            } else if (intent != null) {
                this.a.d(intent.getStringExtra("resultCode"));
                this.a.e(intent.getStringExtra("resultDesc"));
                this.a.b().d(intent.getStringExtra("idCardAuthData"));
                this.a.b().c(intent.getStringExtra("certPwdData"));
                this.a.b().e(intent.getStringExtra("verifyData"));
            } else {
                this.a.d(com.alibaba.security.realidentity.a.s);
                this.a.e("用户已取消");
            }
            yw2.this.a.onResult(this.a);
        }
    }

    public yw2(Activity activity, ax2 ax2) {
        this.b = activity;
        this.c = ax2;
    }

    @Override // cn.wh.auth.AuthService
    public void getAuthResult(OnCallBack onCallBack) {
        this.a = onCallBack;
        j12 j12 = new j12();
        if (TextUtils.isEmpty(this.c.a())) {
            j12.e("应用ID异常");
            j12.d(com.alibaba.security.realidentity.a.A);
            onCallBack.onResult(j12);
        } else if (TextUtils.isEmpty(this.c.c())) {
            j12.e("机构ID异常");
            j12.d(com.alibaba.security.realidentity.a.z);
            onCallBack.onResult(j12);
        } else if (!rh.a(this.b)) {
            j12.e("APP尚未安装");
            j12.d(com.alibaba.security.realidentity.a.r);
            onCallBack.onResult(j12);
        } else {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("cn.cyberIdentity.certification", "cn.wh.project.view.v.authorization.WAuthActivity"));
            intent.setFlags(8388608);
            intent.putExtra("orgID", this.c.c());
            intent.putExtra("appID", this.c.a());
            intent.putExtra("bizSeq", this.c.b());
            StringBuilder sb = new StringBuilder();
            sb.append(this.c.d());
            intent.putExtra("type", sb.toString());
            intent.putExtra("packageName", this.b.getApplication().getPackageName());
            try {
                new ResultRequestService(this.b).c(intent, new a(j12));
            } catch (Exception unused) {
                j12.e("APP尚未安装");
                j12.d(com.alibaba.security.realidentity.a.r);
                this.a.onResult(j12);
            }
        }
    }
}
