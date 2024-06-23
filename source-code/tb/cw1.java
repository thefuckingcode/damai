package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.pictures.share.qqshare.QQShareActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class cw1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public static final class a implements ShareManager.IApplyPermission.IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ cw1 a;
        final /* synthetic */ Context b;
        final /* synthetic */ ShareContent c;
        final /* synthetic */ boolean d;

        a(cw1 cw1, Context context, ShareContent shareContent, boolean z) {
            this.a = cw1;
            this.b = context;
            this.c = shareContent;
            this.d = z;
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionDenied() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1133673045")) {
                ipChange.ipc$dispatch("1133673045", new Object[]{this});
                return;
            }
            ShareUtil.n("保存图片异常，请授予存储权限");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1860480479")) {
                ipChange.ipc$dispatch("1860480479", new Object[]{this});
                return;
            }
            this.a.c(this.b, this.c, this.d);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void c(Context context, ShareContent shareContent, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891447412")) {
            ipChange.ipc$dispatch("-891447412", new Object[]{this, context, shareContent, Boolean.valueOf(z)});
            return;
        }
        Intent intent = new Intent(context, QQShareActivity.class);
        intent.putExtra("IsQQZone", z);
        intent.putExtra("ShareParams", shareContent);
        context.startActivity(intent);
    }

    public final void b(@NotNull Context context, @Nullable ShareContent shareContent, boolean z, @Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1532175337")) {
            ipChange.ipc$dispatch("-1532175337", new Object[]{this, context, shareContent, Boolean.valueOf(z), shareChannel});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (!k21.d(Environment.getExternalStorageState(), "mounted")) {
            ShareUtil.n("请插入外部SD存储卡，否则无法进行分享");
            if (z) {
                df.a(ShareChannel.QZONE, 1003);
            } else {
                df.a(ShareChannel.QQ, 1003);
            }
        } else if (!d7.a("com.tencent.mobileqq")) {
            String string = context.getString(R$string.qq_not_install);
            k21.h(string, "context.getString(R.string.qq_not_install)");
            ShareUtil.n(string);
            if (z) {
                df.a(ShareChannel.QZONE, ShareException.APP_UNINSTALL);
            } else {
                df.a(ShareChannel.QQ, ShareException.APP_UNINSTALL);
            }
        } else if (z) {
            c(context, shareContent, z);
        } else {
            ShareManager.IApplyPermission f = ShareManager.INSTANCE.b().f();
            if (f != null) {
                f.requestStoragePermission(new a(this, context, shareContent, z), (Activity) context);
            }
        }
    }
}
