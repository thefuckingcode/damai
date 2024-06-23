package cn.damai.commonbusiness.share;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.view.View;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedList;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fp1;
import tb.jp1;
import tb.k21;
import tb.lk2;
import tb.t92;
import tb.u92;
import tb.ur2;

/* compiled from: Taobao */
public final class ShareInit$init$1 extends Lambda implements Function1<ShareManager.a, ur2> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Application $application;

    /* compiled from: Taobao */
    public static final class a implements ShareManager.IApplyPermission {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Application a;

        /* renamed from: cn.damai.commonbusiness.share.ShareInit$init$1$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public static final class C0020a implements IPermissionListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ShareManager.IApplyPermission.IPermissionListener a;
            final /* synthetic */ Activity b;

            C0020a(ShareManager.IApplyPermission.IPermissionListener iPermissionListener, Activity activity) {
                this.a = iPermissionListener;
                this.b = activity;
            }

            /* access modifiers changed from: private */
            public static final void c(Activity activity, DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1738337069")) {
                    ipChange.ipc$dispatch("1738337069", new Object[]{activity, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                jp1.f(activity);
            }

            /* access modifiers changed from: private */
            public static final void d(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1123071866")) {
                    ipChange.ipc$dispatch("1123071866", new Object[]{dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }

            @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
            public void onPermissionDenied(@NotNull String[] strArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-831646505")) {
                    ipChange.ipc$dispatch("-831646505", new Object[]{this, strArr});
                    return;
                }
                k21.i(strArr, "permission");
                this.a.onPermissionDenied();
            }

            @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
            public void onPermissionGranted() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1906944844")) {
                    ipChange.ipc$dispatch("1906944844", new Object[]{this});
                    return;
                }
                this.a.onPermissionGranted();
            }

            @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
            public void onShowRationale(@NotNull String[] strArr) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1998028063")) {
                    ipChange.ipc$dispatch("-1998028063", new Object[]{this, strArr});
                    return;
                }
                k21.i(strArr, "deniedPermissions");
                Activity activity = this.b;
                if (activity != null) {
                    fp1.a(activity, "才能保存图片～", ArraysKt___ArraysKt.g0(strArr), false, new t92(this.b), u92.a);
                }
            }
        }

        a(Application application) {
            this.a = application;
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission
        public void requestStoragePermission(@NotNull ShareManager.IApplyPermission.IPermissionListener iPermissionListener, @Nullable Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "819346954")) {
                ipChange.ipc$dispatch("819346954", new Object[]{this, iPermissionListener, activity});
                return;
            }
            k21.i(iPermissionListener, "iPermissionListener");
            PermissionModel permissionModel = new PermissionModel(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, "储存权限说明", Integer.valueOf(R$drawable.permission_store_pic), "获取手机中的图片、媒体文件在大麦内使用");
            LinkedList linkedList = new LinkedList();
            linkedList.add(permissionModel);
            new Permission(this.a, linkedList).a(new C0020a(iPermissionListener, activity)).b();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements ShareManager.IShareMenu {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IShareMenu
        public void share(@NotNull ShareManager.IShareMenu.IShareListener iShareListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "47314584")) {
                ipChange.ipc$dispatch("47314584", new Object[]{this, iShareListener});
                return;
            }
            k21.i(iShareListener, "iReportListener");
        }
    }

    /* compiled from: Taobao */
    public static final class c implements ShareManager.IOrangeConfig {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IOrangeConfig
        @NotNull
        public String getShareChannelConfig() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1929682047")) {
                return "12654";
            }
            return (String) ipChange.ipc$dispatch("-1929682047", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static final class d implements ShareManager.IReport {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IReport
        public void report(int i, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull ShareManager.IReport.IReportListener iReportListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-317057432")) {
                ipChange.ipc$dispatch("-317057432", new Object[]{this, Integer.valueOf(i), str, str2, num, iReportListener});
                return;
            }
            k21.i(str, "reason");
            k21.i(iReportListener, "iReportListener");
        }
    }

    /* compiled from: Taobao */
    public static final class e implements ShareManager.IShareMonitor {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IShareMonitor
        public void shareResult(@NotNull ShareChannel shareChannel, int i, @Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1295741072")) {
                ipChange.ipc$dispatch("-1295741072", new Object[]{this, shareChannel, Integer.valueOf(i), str});
                return;
            }
            k21.i(shareChannel, "shareChannel");
        }
    }

    /* compiled from: Taobao */
    public static final class f implements ShareManager.IToast {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IToast
        public void showToast(@Nullable String str, boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "118139740")) {
                ipChange.ipc$dispatch("118139740", new Object[]{this, str, Boolean.valueOf(z)});
            } else if (str != null) {
                ToastUtil.i(str);
            }
        }
    }

    /* compiled from: Taobao */
    public static final class g implements ShareManager.IDogCat {
        private static transient /* synthetic */ IpChange $ipChange;

        g() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDogCat
        public void click(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1786134386")) {
                ipChange.ipc$dispatch("-1786134386", new Object[]{this, view, str, str2, map});
                return;
            }
            k21.i(view, "view");
            k21.i(str, "ctrlName");
            k21.i(str2, "spm");
            k21.i(map, "args");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDogCat
        public void click(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1077934498")) {
                ipChange.ipc$dispatch("1077934498", new Object[]{this, str, str2, map});
                return;
            }
            k21.i(str, "ctrlName");
            k21.i(str2, "spm");
            k21.i(map, "args");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDogCat
        public void custom(@NotNull String str, @NotNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1328411879")) {
                ipChange.ipc$dispatch("-1328411879", new Object[]{this, str, map});
                return;
            }
            k21.i(str, "eventName");
            k21.i(map, "args");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDogCat
        public void expose(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "951093006")) {
                ipChange.ipc$dispatch("951093006", new Object[]{this, view, str, str2, map});
                return;
            }
            k21.i(view, "view");
            k21.i(str, "ctrlName");
            k21.i(str2, "spm");
            k21.i(map, "args");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDogCat
        public void expose(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1456094430")) {
                ipChange.ipc$dispatch("-1456094430", new Object[]{this, str, str2, map});
                return;
            }
            k21.i(str, "ctrlName");
            k21.i(str2, "spm");
            k21.i(map, "args");
        }
    }

    /* compiled from: Taobao */
    public static final class h implements ShareManager.IDownloadImage {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage
        public void download(@Nullable String str, @NotNull ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1645296653")) {
                ipChange.ipc$dispatch("1645296653", new Object[]{this, str, iDownloadListener});
                return;
            }
            k21.i(iDownloadListener, "iDownloadListener");
            ShareInit.INSTANCE.a(str, iDownloadListener);
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage
        public void download(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @NotNull ShareManager.IDownloadImage.IDownloadListener iDownloadListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1794063827")) {
                ipChange.ipc$dispatch("-1794063827", new Object[]{this, str, num, num2, iDownloadListener});
                return;
            }
            k21.i(iDownloadListener, "iDownloadListener");
            ShareInit.INSTANCE.a(str, iDownloadListener);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareInit$init$1(Application application) {
        super(1);
        this.$application = application;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ur2 invoke(ShareManager.a aVar) {
        invoke(aVar);
        return ur2.INSTANCE;
    }

    public final void invoke(@NotNull ShareManager.a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903527688")) {
            ipChange.ipc$dispatch("903527688", new Object[]{this, aVar});
            return;
        }
        k21.i(aVar, "$this$init");
        aVar.D(2);
        aVar.C("大麦");
        aVar.B(Integer.valueOf(R$drawable.damai_small_logo));
        aVar.G(AppConfig.v());
        aVar.F(lk2.c().a());
        String h2 = lk2.c().h();
        String str = "";
        if (h2 == null) {
            h2 = str;
        }
        aVar.Q(h2);
        aVar.R(lk2.d);
        String f2 = lk2.c().f();
        if (f2 == null) {
            f2 = str;
        }
        aVar.M(f2);
        String k = lk2.c().k();
        if (k != null) {
            str = k;
        }
        aVar.S(str);
        aVar.T("/pages/home/index?url=");
        aVar.A("2015092200310865");
        aVar.I(this.$application.getPackageName() + ".interactProvider");
        aVar.E(new a(this.$application));
        aVar.O(new b());
        aVar.L(new c());
        aVar.N(new d());
        aVar.P(new e());
        aVar.K(new f());
        aVar.J(new g());
        aVar.H(new h());
    }
}
