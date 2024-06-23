package com.alibaba.pictures.share;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.aliweex.adapter.module.WXUserTrackModule;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.taobao.login4android.constants.LoginConstants;
import com.uc.webview.export.extension.UCCore;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.ur2;
import tb.v92;

/* compiled from: Taobao */
public final class ShareManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final ShareManager INSTANCE = new ShareManager();
    @Nullable
    private static Application a;
    @NotNull
    private static a b = new a();
    @Nullable
    private static IWBAPI c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$EnvModeEnum;", "", "", "envMode", "I", "getEnvMode", "()I", "<init>", "(Ljava/lang/String;II)V", "ONLINE", "PREPARE", "TEST", "TEST_SANDBOX", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public enum EnvModeEnum {
        ONLINE(0),
        PREPARE(1),
        TEST(2),
        TEST_SANDBOX(3);
        
        private final int envMode;

        private EnvModeEnum(int i) {
            this.envMode = i;
        }

        public final int getEnvMode() {
            return this.envMode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IApplyPermission;", "", "Lcom/alibaba/pictures/share/ShareManager$IApplyPermission$IPermissionListener;", "iPermissionListener", "Landroid/app/Activity;", "activity", "Ltb/ur2;", "requestStoragePermission", "IPermissionListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IApplyPermission {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IApplyPermission$IPermissionListener;", "", "Ltb/ur2;", "onPermissionGranted", "onPermissionDenied", "share_release"}, k = 1, mv = {1, 4, 2})
        /* compiled from: Taobao */
        public interface IPermissionListener {
            void onPermissionDenied();

            void onPermissionGranted();
        }

        /* compiled from: Taobao */
        public static final class a {
            public static /* synthetic */ void a(IApplyPermission iApplyPermission, IPermissionListener iPermissionListener, Activity activity, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        activity = null;
                    }
                    iApplyPermission.requestStoragePermission(iPermissionListener, activity);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestStoragePermission");
            }
        }

        void requestStoragePermission(@NotNull IPermissionListener iPermissionListener, @Nullable Activity activity);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\t\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IBitmapManager;", "", "", "url", "Landroid/graphics/Bitmap;", "bitmap", "Ltb/ur2;", "saveBitmap", "getBitmap", Constants.TAG_CLEAR_STRING, "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IBitmapManager {
        void clear();

        @Nullable
        Bitmap getBitmap(@Nullable String str);

        void saveBitmap(@Nullable String str, @Nullable Bitmap bitmap);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J8\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J0\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J8\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&J&\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IDogCat;", "", "", "ctrlName", "spm", "", "args", "Ltb/ur2;", "click", "Landroid/view/View;", "view", WXUserTrackModule.EXPOSE, "eventName", "custom", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IDogCat {
        void click(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

        void click(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

        void custom(@NotNull String str, @NotNull Map<String, String> map);

        void expose(@NotNull View view, @NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

        void expose(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J5\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IDownloadImage;", "", "", "url", "Lcom/alibaba/pictures/share/ShareManager$IDownloadImage$IDownloadListener;", "iDownloadListener", "Ltb/ur2;", "download", "", "width", "height", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/alibaba/pictures/share/ShareManager$IDownloadImage$IDownloadListener;)V", "IDownloadListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IDownloadImage {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IDownloadImage$IDownloadListener;", "", "Landroid/graphics/Bitmap;", "bitmap", "Ltb/ur2;", "onSuccess", "onFailed", "share_release"}, k = 1, mv = {1, 4, 2})
        /* compiled from: Taobao */
        public interface IDownloadListener {
            void onFailed();

            void onSuccess(@Nullable Bitmap bitmap);
        }

        void download(@Nullable String str, @NotNull IDownloadListener iDownloadListener);

        void download(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @NotNull IDownloadListener iDownloadListener);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IOrangeConfig;", "", "", "getShareChannelConfig", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IOrangeConfig {
        @NotNull
        String getShareChannelConfig();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\rJ?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IReport;", "", "", "index", "", "reason", "targetId", "targetType", "Lcom/alibaba/pictures/share/ShareManager$IReport$IReportListener;", "iReportListener", "Ltb/ur2;", "report", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/alibaba/pictures/share/ShareManager$IReport$IReportListener;)V", "IReportListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IReport {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IReport$IReportListener;", "", "Ltb/ur2;", "onSuccess", "onFailed", "share_release"}, k = 1, mv = {1, 4, 2})
        /* compiled from: Taobao */
        public interface IReportListener {
            void onFailed();

            void onSuccess();
        }

        void report(int i, @NotNull String str, @Nullable String str2, @Nullable Integer num, @NotNull IReportListener iReportListener);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareInit;", "", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IShareInit {
        void init();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareMenu;", "", "Lcom/alibaba/pictures/share/ShareManager$IShareMenu$IShareListener;", "iReportListener", "Ltb/ur2;", "share", "IShareListener", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IShareMenu {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareMenu$IShareListener;", "", "Ltb/ur2;", "onSuccess", "onException", "share_release"}, k = 1, mv = {1, 4, 2})
        /* compiled from: Taobao */
        public interface IShareListener {
            void onException();

            void onSuccess();
        }

        void share(@NotNull IShareListener iShareListener);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IShareMonitor;", "", "Lcom/alibaba/pictures/share/common/share/ShareChannel;", "shareChannel", "", "status", "", "msg", "Ltb/ur2;", "shareResult", "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IShareMonitor {
        void shareResult(@NotNull ShareChannel shareChannel, int i, @Nullable String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/alibaba/pictures/share/ShareManager$IToast;", "", "", "msg", "", "isLongTime", "Ltb/ur2;", LoginConstants.SHOW_TOAST, "share_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface IToast {
        void showToast(@Nullable String str, boolean z);
    }

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String A;
        private int a = 1;
        private boolean b;
        @NotNull
        private EnvModeEnum c = EnvModeEnum.ONLINE;
        @Nullable
        private Integer d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private String g;
        @Nullable
        private String h;
        @Nullable
        private String i = "";
        @Nullable
        private String j = "";
        @Nullable
        private String k = "";
        @Nullable
        private String l = "";
        @Nullable
        private String m = "";
        @Nullable
        private String n;
        @Nullable
        private String o = "";
        @Nullable
        private IApplyPermission p;
        @Nullable
        private IShareMenu q;
        @Nullable
        private IReport r;
        @Nullable
        private IDownloadImage s;
        @Nullable
        private IOrangeConfig t;
        @Nullable
        private IShareMonitor u;
        @Nullable
        private IToast v;
        @Nullable
        private IDogCat w;
        @Nullable
        private String x;
        @Nullable
        private IBitmapManager y;
        private float z = 0.8f;

        public final void A(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1371907778")) {
                ipChange.ipc$dispatch("-1371907778", new Object[]{this, str});
                return;
            }
            this.o = str;
        }

        public final void B(@Nullable Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2037195820")) {
                ipChange.ipc$dispatch("2037195820", new Object[]{this, num});
                return;
            }
            this.d = num;
        }

        public final void C(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1878681796")) {
                ipChange.ipc$dispatch("1878681796", new Object[]{this, str});
                return;
            }
            this.f = str;
        }

        public final void D(int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1244799496")) {
                ipChange.ipc$dispatch("-1244799496", new Object[]{this, Integer.valueOf(i2)});
                return;
            }
            this.a = i2;
        }

        public final void E(@Nullable IApplyPermission iApplyPermission) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-350815369")) {
                ipChange.ipc$dispatch("-350815369", new Object[]{this, iApplyPermission});
                return;
            }
            this.p = iApplyPermission;
        }

        public final void F(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-108356047")) {
                ipChange.ipc$dispatch("-108356047", new Object[]{this, str});
                return;
            }
            this.g = str;
        }

        public final void G(boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "317491937")) {
                ipChange.ipc$dispatch("317491937", new Object[]{this, Boolean.valueOf(z2)});
                return;
            }
            this.b = z2;
        }

        public final void H(@Nullable IDownloadImage iDownloadImage) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2033050229")) {
                ipChange.ipc$dispatch("-2033050229", new Object[]{this, iDownloadImage});
                return;
            }
            this.s = iDownloadImage;
        }

        public final void I(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1800358746")) {
                ipChange.ipc$dispatch("1800358746", new Object[]{this, str});
                return;
            }
            this.A = str;
        }

        public final void J(@Nullable IDogCat iDogCat) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1968881480")) {
                ipChange.ipc$dispatch("1968881480", new Object[]{this, iDogCat});
                return;
            }
            this.w = iDogCat;
        }

        public final void K(@Nullable IToast iToast) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1584103978")) {
                ipChange.ipc$dispatch("1584103978", new Object[]{this, iToast});
                return;
            }
            this.v = iToast;
        }

        public final void L(@Nullable IOrangeConfig iOrangeConfig) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "976161601")) {
                ipChange.ipc$dispatch("976161601", new Object[]{this, iOrangeConfig});
                return;
            }
            this.t = iOrangeConfig;
        }

        public final void M(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1132986828")) {
                ipChange.ipc$dispatch("-1132986828", new Object[]{this, str});
                return;
            }
            this.l = str;
        }

        public final void N(@Nullable IReport iReport) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-415622591")) {
                ipChange.ipc$dispatch("-415622591", new Object[]{this, iReport});
                return;
            }
            this.r = iReport;
        }

        public final void O(@Nullable IShareMenu iShareMenu) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-800782219")) {
                ipChange.ipc$dispatch("-800782219", new Object[]{this, iShareMenu});
                return;
            }
            this.q = iShareMenu;
        }

        public final void P(@Nullable IShareMonitor iShareMonitor) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1242733663")) {
                ipChange.ipc$dispatch("-1242733663", new Object[]{this, iShareMonitor});
                return;
            }
            this.u = iShareMonitor;
        }

        public final void Q(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "94252831")) {
                ipChange.ipc$dispatch("94252831", new Object[]{this, str});
                return;
            }
            this.i = str;
        }

        public final void R(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1900639656")) {
                ipChange.ipc$dispatch("1900639656", new Object[]{this, str});
                return;
            }
            this.j = str;
        }

        public final void S(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-225075275")) {
                ipChange.ipc$dispatch("-225075275", new Object[]{this, str});
                return;
            }
            this.m = str;
        }

        public final void T(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1146124847")) {
                ipChange.ipc$dispatch("-1146124847", new Object[]{this, str});
                return;
            }
            this.n = str;
        }

        @Nullable
        public final String a() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2048273096")) {
                return this.o;
            }
            return (String) ipChange.ipc$dispatch("-2048273096", new Object[]{this});
        }

        public final float b() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "449304256")) {
                return this.z;
            }
            return ((Float) ipChange.ipc$dispatch("449304256", new Object[]{this})).floatValue();
        }

        @Nullable
        public final Integer c() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "47067998")) {
                return this.d;
            }
            return (Integer) ipChange.ipc$dispatch("47067998", new Object[]{this});
        }

        @Nullable
        public final String d() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-718544142")) {
                return this.f;
            }
            return (String) ipChange.ipc$dispatch("-718544142", new Object[]{this});
        }

        public final int e() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1645570990")) {
                return this.a;
            }
            return ((Integer) ipChange.ipc$dispatch("-1645570990", new Object[]{this})).intValue();
        }

        @Nullable
        public final IApplyPermission f() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "177071015")) {
                return this.p;
            }
            return (IApplyPermission) ipChange.ipc$dispatch("177071015", new Object[]{this});
        }

        @Nullable
        public final String g() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2094540211")) {
                return this.g;
            }
            return (String) ipChange.ipc$dispatch("-2094540211", new Object[]{this});
        }

        @Nullable
        public final String h() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "880699086")) {
                return this.x;
            }
            return (String) ipChange.ipc$dispatch("880699086", new Object[]{this});
        }

        @Nullable
        public final IDownloadImage i() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1204684775")) {
                return this.s;
            }
            return (IDownloadImage) ipChange.ipc$dispatch("1204684775", new Object[]{this});
        }

        @NotNull
        public final EnvModeEnum j() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1127805751")) {
                return this.c;
            }
            return (EnvModeEnum) ipChange.ipc$dispatch("1127805751", new Object[]{this});
        }

        @Nullable
        public final String k() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1173852004")) {
                return this.A;
            }
            return (String) ipChange.ipc$dispatch("-1173852004", new Object[]{this});
        }

        @Nullable
        public final IBitmapManager l() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "237710216")) {
                return this.y;
            }
            return (IBitmapManager) ipChange.ipc$dispatch("237710216", new Object[]{this});
        }

        @Nullable
        public final IDogCat m() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-56344302")) {
                return this.w;
            }
            return (IDogCat) ipChange.ipc$dispatch("-56344302", new Object[]{this});
        }

        @Nullable
        public final IToast n() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1953563800")) {
                return this.v;
            }
            return (IToast) ipChange.ipc$dispatch("-1953563800", new Object[]{this});
        }

        @Nullable
        public final IOrangeConfig o() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2077826149")) {
                return this.t;
            }
            return (IOrangeConfig) ipChange.ipc$dispatch("2077826149", new Object[]{this});
        }

        @Nullable
        public final String p() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "15589250")) {
                return this.l;
            }
            return (String) ipChange.ipc$dispatch("15589250", new Object[]{this});
        }

        @Nullable
        public final IReport q() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-592480803")) {
                return this.r;
            }
            return (IReport) ipChange.ipc$dispatch("-592480803", new Object[]{this});
        }

        @Nullable
        public final IShareMonitor r() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "838603087")) {
                return this.u;
            }
            return (IShareMonitor) ipChange.ipc$dispatch("838603087", new Object[]{this});
        }

        @Nullable
        public final String s() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1025008951")) {
                return this.i;
            }
            return (String) ipChange.ipc$dispatch("1025008951", new Object[]{this});
        }

        @Nullable
        public final String t() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-432598898")) {
                return this.j;
            }
            return (String) ipChange.ipc$dispatch("-432598898", new Object[]{this});
        }

        @Nullable
        public final String u() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-47163281")) {
                return this.k;
            }
            return (String) ipChange.ipc$dispatch("-47163281", new Object[]{this});
        }

        @Nullable
        public final String v() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1645137762")) {
                return this.e;
            }
            return (String) ipChange.ipc$dispatch("1645137762", new Object[]{this});
        }

        @Nullable
        public final String w() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1707444705")) {
                return this.m;
            }
            return (String) ipChange.ipc$dispatch("1707444705", new Object[]{this});
        }

        @Nullable
        public final String x() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1492931667")) {
                return this.n;
            }
            return (String) ipChange.ipc$dispatch("-1492931667", new Object[]{this});
        }

        @Nullable
        public final String y() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1441538941")) {
                return this.h;
            }
            return (String) ipChange.ipc$dispatch("1441538941", new Object[]{this});
        }

        public final boolean z() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2114738655")) {
                return this.b;
            }
            return ((Boolean) ipChange.ipc$dispatch("-2114738655", new Object[]{this})).booleanValue();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements SdkListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitFailure(@NotNull Exception exc) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-951341549")) {
                ipChange.ipc$dispatch("-951341549", new Object[]{this, exc});
                return;
            }
            k21.i(exc, "e");
            v92.e(null, "SDK初始化失败回调" + exc, 1, null);
        }

        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-17877702")) {
                ipChange.ipc$dispatch("-17877702", new Object[]{this});
                return;
            }
            v92.e(null, "DK初始化成功回调", 1, null);
        }
    }

    private ShareManager() {
    }

    @Nullable
    public final Application a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "333999721")) {
            return a;
        }
        return (Application) ipChange.ipc$dispatch("333999721", new Object[]{this});
    }

    @NotNull
    public final a b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1355317784")) {
            return b;
        }
        return (a) ipChange.ipc$dispatch("1355317784", new Object[]{this});
    }

    @Nullable
    public final IWBAPI c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "184449590")) {
            return c;
        }
        return (IWBAPI) ipChange.ipc$dispatch("184449590", new Object[]{this});
    }

    public final void d(@NotNull Application application, @NotNull Function1<? super a, ur2> function1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460235393")) {
            ipChange.ipc$dispatch("460235393", new Object[]{this, application, function1});
            return;
        }
        k21.i(application, "application");
        k21.i(function1, "configBlock");
        a = application;
        a aVar = b;
        function1.invoke(aVar);
        b = aVar;
        e(application);
        v92.e(null, "ShareManager init", 1, null);
    }

    public final void e(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645467448")) {
            ipChange.ipc$dispatch("-1645467448", new Object[]{this, application});
            return;
        }
        k21.i(application, "application");
        AuthInfo authInfo = new AuthInfo(application, b.s(), b.t(), b.u());
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(application);
        c = createWBAPI;
        if (createWBAPI != null) {
            createWBAPI.registerApp(application, authInfo, new b());
        }
    }

    public final boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-572108559")) {
            return b.z();
        }
        return ((Boolean) ipChange.ipc$dispatch("-572108559", new Object[]{this})).booleanValue();
    }
}
