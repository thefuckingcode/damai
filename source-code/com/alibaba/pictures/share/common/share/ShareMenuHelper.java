package com.alibaba.pictures.share.common.share;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.ui.dialog.DialogHelper;
import com.alibaba.pictures.share.common.ui.dialog.ReportDialog;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.ShareProvider;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.o;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aa2;
import tb.ba2;
import tb.bc1;
import tb.do2;
import tb.f90;
import tb.k21;
import tb.ur2;
import tb.w92;
import tb.x92;

/* compiled from: Taobao */
public final class ShareMenuHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private aa2 a;
    private long b;
    @NotNull
    private final Context c;

    /* compiled from: Taobao */
    public static final class a extends x92 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShareMenuHelper a;
        final /* synthetic */ ShareContent b;

        a(ShareMenuHelper shareMenuHelper, ShareContent shareContent) {
            this.a = shareMenuHelper;
            this.b = shareContent;
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionDenied() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1347215275")) {
                ipChange.ipc$dispatch("1347215275", new Object[]{this});
                return;
            }
            ShareUtil.n("保存图片异常，请授予存储权限");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-109644983")) {
                ipChange.ipc$dispatch("-109644983", new Object[]{this});
                return;
            }
            this.a.i(this.b);
        }
    }

    /* compiled from: Taobao */
    public static final class b implements ShareManager.IDownloadImage.IDownloadListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ShareMenuHelper a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(ShareMenuHelper shareMenuHelper) {
            this.a = shareMenuHelper;
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage.IDownloadListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1572558168")) {
                ipChange.ipc$dispatch("-1572558168", new Object[]{this});
                return;
            }
            ShareUtil.n("图片保存失败");
        }

        @Override // com.alibaba.pictures.share.ShareManager.IDownloadImage.IDownloadListener
        public void onSuccess(@Nullable Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1692623252")) {
                ipChange.ipc$dispatch("-1692623252", new Object[]{this, bitmap});
            } else if (bitmap != null) {
                this.a.s(bitmap);
            } else {
                ShareUtil.n("图片保存失败");
                ur2 ur2 = ur2.INSTANCE;
            }
        }
    }

    public ShareMenuHelper(@NotNull Context context) {
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.c = context;
        this.a = new aa2(context);
    }

    private final void b(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427154806")) {
            ipChange.ipc$dispatch("427154806", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_Alipay", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.c(shareContent);
        }
    }

    private final void c(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-694916777")) {
            ipChange.ipc$dispatch("-694916777", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_Alipay_Timeline", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.d(shareContent);
        }
    }

    private final void d(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992144440")) {
            ipChange.ipc$dispatch("992144440", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_CopyLink", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.e(shareContent);
        }
    }

    private final void f(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516511532")) {
            ipChange.ipc$dispatch("516511532", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_QQ", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.a(shareContent);
        }
    }

    private final void g(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399545563")) {
            ipChange.ipc$dispatch("-1399545563", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_QZone", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.b(shareContent);
        }
    }

    private final void h(ShareContent shareContent, android.util.Pair<String, Object>[] pairArr) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-561229960")) {
            ipChange.ipc$dispatch("-561229960", new Object[]{this, shareContent, pairArr});
            return;
        }
        String str = null;
        if (pairArr != null) {
            num = null;
            for (android.util.Pair<String, Object> pair : pairArr) {
                if (TextUtils.equals((CharSequence) pair.first, "targetId")) {
                    Object obj = pair.second;
                    if (obj instanceof String) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                        str = (String) obj;
                    }
                }
                if (TextUtils.equals((CharSequence) pair.first, "targetType")) {
                    Object obj2 = pair.second;
                    if (obj2 instanceof Integer) {
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                        num = (Integer) obj2;
                    }
                }
            }
        } else {
            num = null;
        }
        new ReportDialog(this.c, str, num).show();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void i(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1985966918")) {
            ipChange.ipc$dispatch("-1985966918", new Object[]{this, shareContent});
            return;
        }
        ba2.b(ba2.INSTANCE, "ShareMenu_SaveLocal", null, null, 6, null);
        if (shareContent != null) {
            Bitmap defaultImage = shareContent.getDefaultImage();
            if (defaultImage != null) {
                s(defaultImage);
                return;
            }
            List<String> imgUrls = shareContent.getImgUrls();
            if (!imgUrls.isEmpty()) {
                String str = imgUrls.get(0);
                if (!TextUtils.isEmpty(str)) {
                    if (!(o.L(str, "http", false, 2, null))) {
                        s(bc1.a(this.c, str));
                    } else {
                        n(str);
                    }
                    aa2 aa2 = this.a;
                    if (aa2 != null) {
                        aa2.g();
                    }
                }
            }
        }
    }

    private final void k(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "172032366")) {
            ipChange.ipc$dispatch("172032366", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_WeiXin", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.j(shareContent);
        }
    }

    private final void l(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138998417")) {
            ipChange.ipc$dispatch("-2138998417", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_WeiXinTimeLine", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.k(shareContent);
        }
    }

    private final void m(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1605808336")) {
            ipChange.ipc$dispatch("1605808336", new Object[]{this, shareContent});
            return;
        }
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_Weibo", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.h(shareContent);
        }
    }

    private final void n(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570553977")) {
            ipChange.ipc$dispatch("570553977", new Object[]{this, str});
            return;
        }
        ShareManager.IDownloadImage i = ShareManager.INSTANCE.b().i();
        if (i != null) {
            i.download(str, new b(this));
        }
    }

    public final void e(@NotNull ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-96459380")) {
            ipChange.ipc$dispatch("-96459380", new Object[]{this, shareContent});
            return;
        }
        k21.i(shareContent, "info");
        ba2 ba2 = ba2.INSTANCE;
        Pair[] pairArr = new Pair[1];
        String url = shareContent.getUrl();
        if (url == null) {
            url = "";
        }
        pairArr[0] = do2.a("ShareUrl", url);
        ba2.b(ba2, "ShareMenu_DD", null, u.m(pairArr), 2, null);
        aa2 aa2 = this.a;
        if (aa2 != null) {
            aa2.f(shareContent);
        }
    }

    public final void j(@Nullable Integer num, @Nullable ShareContent shareContent, @Nullable android.util.Pair<String, Object>[] pairArr) {
        String str;
        String str2;
        String str3;
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300440119")) {
            ipChange.ipc$dispatch("1300440119", new Object[]{this, num, shareContent, pairArr});
        } else if (!p() && shareContent != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (shareContent.getKind() != null) {
                ShareContent.ShareContentKind kind = shareContent.getKind();
                str = String.valueOf(kind != null ? kind.value : null);
            } else {
                str = "0";
            }
            linkedHashMap.put("type", str);
            linkedHashMap.put("channel", String.valueOf(num));
            String url4UT = shareContent.getUrl4UT();
            String str5 = "";
            if (url4UT == null) {
                url4UT = str5;
            }
            linkedHashMap.put("url", url4UT);
            Map<String, String> extraInfo = shareContent.getExtraInfo();
            if (extraInfo == null || (str2 = extraInfo.get("share_film_comment_template")) == null) {
                str2 = str5;
            }
            linkedHashMap.put("extra", str2);
            Map<String, String> extraInfo2 = shareContent.getExtraInfo();
            if (extraInfo2 == null || (str3 = extraInfo2.get("share_show_id")) == null) {
                str3 = str5;
            }
            linkedHashMap.put("show_id", str3);
            Map<String, String> extraInfo3 = shareContent.getExtraInfo();
            if (!(extraInfo3 == null || (str4 = extraInfo3.get(ShareProvider.SHARE_FROM)) == null)) {
                str5 = str4;
            }
            linkedHashMap.put("from", str5);
            ba2.b(ba2.INSTANCE, "ShareCommon", null, linkedHashMap, 2, null);
            int i = ShareChannel.WEIXIN.value;
            if (num != null && num.intValue() == i) {
                k(shareContent);
                return;
            }
            int i2 = ShareChannel.WEIXIN_FRIEND.value;
            if (num != null && num.intValue() == i2) {
                l(shareContent);
                return;
            }
            int i3 = ShareChannel.WEIBO.value;
            if (num != null && num.intValue() == i3) {
                m(shareContent);
                return;
            }
            int i4 = ShareChannel.ALIPAY.value;
            if (num != null && num.intValue() == i4) {
                b(shareContent);
                return;
            }
            int i5 = ShareChannel.ALIPAY_TIMELINE.value;
            if (num != null && num.intValue() == i5) {
                c(shareContent);
                return;
            }
            int i6 = ShareChannel.QQ.value;
            if (num != null && num.intValue() == i6) {
                f(shareContent);
                return;
            }
            int i7 = ShareChannel.QZONE.value;
            if (num != null && num.intValue() == i7) {
                g(shareContent);
                return;
            }
            int i8 = ShareChannel.COPYLINK.value;
            if (num != null && num.intValue() == i8) {
                d(shareContent);
                return;
            }
            int i9 = ShareChannel.SAVELOCAL.value;
            if (num != null && num.intValue() == i9) {
                ShareManager.IApplyPermission f = ShareManager.INSTANCE.b().f();
                if (f != null) {
                    ShareManager.IApplyPermission.a.a(f, new a(this, shareContent), null, 2, null);
                    return;
                }
                return;
            }
            int i10 = ShareChannel.DD.value;
            if (num != null && num.intValue() == i10) {
                e(shareContent);
                return;
            }
            int i11 = ShareChannel.REPORT.value;
            if (num != null && num.intValue() == i11) {
                h(shareContent, pairArr);
            }
        }
    }

    @NotNull
    public final Context o() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "735181085")) {
            return this.c;
        }
        return (Context) ipChange.ipc$dispatch("735181085", new Object[]{this});
    }

    public final synchronized boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "295266062")) {
            return ((Boolean) ipChange.ipc$dispatch("295266062", new Object[]{this})).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b < ((long) 3000)) {
            return true;
        }
        this.b = currentTimeMillis;
        return false;
    }

    public final void q(@Nullable ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948837990")) {
            ipChange.ipc$dispatch("1948837990", new Object[]{this, shareChannel});
        } else if (shareChannel != null) {
            switch (w92.$EnumSwitchMapping$0[shareChannel.ordinal()]) {
                case 1:
                    ba2.b(ba2.INSTANCE, "ShareMenu_Alipay_Success", null, null, 6, null);
                    return;
                case 2:
                    ba2.b(ba2.INSTANCE, "ShareMenu_Alipay_Timeline_Success", null, null, 6, null);
                    return;
                case 3:
                    ba2.b(ba2.INSTANCE, "ShareMenu_Weibo_Success", null, null, 6, null);
                    return;
                case 4:
                    ba2.b(ba2.INSTANCE, "ShareMenu_Weixin_Success", null, null, 6, null);
                    return;
                case 5:
                    ba2.b(ba2.INSTANCE, "ShareMenu_WeixinTimeLine_Success", null, null, 6, null);
                    return;
                case 6:
                    ba2.b(ba2.INSTANCE, "ShareMenu_QQ_Success", null, null, 6, null);
                    return;
                case 7:
                    ba2.b(ba2.INSTANCE, "ShareMenu_Qzone_Success", null, null, 6, null);
                    return;
                case 8:
                    ba2.b(ba2.INSTANCE, "ShareMenu_CopyLink_Success", null, null, 6, null);
                    return;
                case 9:
                    ba2.b(ba2.INSTANCE, "ShareMenu_DD_Success", null, null, 6, null);
                    return;
                default:
                    return;
            }
        }
    }

    public final void r(@Nullable ShareChannel shareChannel, @Nullable ShareException shareException) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987815632")) {
            ipChange.ipc$dispatch("987815632", new Object[]{this, shareChannel, shareException});
        }
    }

    public final void s(@Nullable Bitmap bitmap) {
        LifecycleCoroutineScope lifecycleScope;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641537269")) {
            ipChange.ipc$dispatch("641537269", new Object[]{this, bitmap});
            return;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Object obj = null;
        ref$ObjectRef.element = null;
        Context context = this.c;
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity != null) {
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            T t = (T) new DialogHelper(activity);
            ref$ObjectRef2.element = t;
            t.e("");
            Object obj2 = this.c;
            if (obj2 instanceof FragmentActivity) {
                obj = obj2;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) obj;
            if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
                Job unused = f.b(lifecycleScope, f90.b(), null, new ShareMenuHelper$saveCommentShareToLocal$1(this, ref$ObjectRef, bitmap, ref$ObjectRef2, null), 2, null);
            }
        }
    }
}
