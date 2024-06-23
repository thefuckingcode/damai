package com.alibaba.pictures.share.qqshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.alibaba.wireless.security.SecExceptionCode;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.text.o;
import tb.df;
import tb.fj2;
import tb.k21;

public final class QQShareActivity extends Activity {
    private static transient /* synthetic */ IpChange $ipChange;
    private Tencent a;
    private boolean b;
    private ShareContent c;
    private IUiListener d = new a(this);

    public static final class a implements IUiListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ QQShareActivity a;

        a(QQShareActivity qQShareActivity) {
            this.a = qQShareActivity;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-405068635")) {
                ipChange.ipc$dispatch("-405068635", new Object[]{this});
                return;
            }
            df.a(this.a.b ? ShareChannel.QZONE : ShareChannel.QQ, 1001);
            this.a.finish();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2132386462")) {
                ipChange.ipc$dispatch("-2132386462", new Object[]{this, obj});
                return;
            }
            k21.i(obj, "o");
            df.b(this.a.b ? ShareChannel.QZONE : ShareChannel.QQ);
            this.a.finish();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "31778133")) {
                ipChange.ipc$dispatch("31778133", new Object[]{this, uiError});
                return;
            }
            k21.i(uiError, "uiError");
            String str = uiError.errorMessage;
            k21.h(str, "uiError.errorMessage");
            ShareUtil.n(str);
            df.a(this.a.b ? ShareChannel.QZONE : ShareChannel.QQ, uiError.errorCode);
            this.a.finish();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1581582540")) {
                ipChange.ipc$dispatch("-1581582540", new Object[]{this, Integer.valueOf(i)});
            } else {
                df.a(this.a.b ? ShareChannel.QZONE : ShareChannel.QQ, i);
            }
        }
    }

    public static final /* synthetic */ Tencent c(QQShareActivity qQShareActivity) {
        return qQShareActivity.a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    private final void f(Context context, ShareContent shareContent) {
        String str;
        String i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741849502")) {
            ipChange.ipc$dispatch("-1741849502", new Object[]{this, context, shareContent});
            return;
        }
        String str2 = null;
        if (TextUtils.isEmpty(shareContent != null ? shareContent.getTitle() : null)) {
            if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
                str = "";
            } else if (shareContent != null) {
                str = shareContent.getContent();
            }
            if (str != null && str.length() > 30) {
                str = str.substring(0, 29);
                k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
                str2 = "";
            } else if (shareContent != null) {
                str2 = shareContent.getContent();
            }
            if (str2 != null && str2.length() > 40) {
                str2 = str2.substring(0, 39);
                k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            i = i(shareContent);
            if (TextUtils.isEmpty(i)) {
                finish();
                return;
            } else if (shareContent != null && shareContent.getShareType() == 1) {
                Bundle bundle = new Bundle();
                bundle.putInt("req_type", 5);
                bundle.putString("imageLocalUrl", i);
                bundle.putString("appName", ShareManager.INSTANCE.b().d());
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new QQShareActivity$doQQContactRequest$3(this, context, bundle));
                return;
            } else if ((shareContent != null && shareContent.getShareType() == 2) || (shareContent != null && shareContent.getShareType() == 3)) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("req_type", 1);
                bundle2.putString("title", str);
                bundle2.putString("appName", ShareManager.INSTANCE.b().d());
                bundle2.putString("summary", str2);
                bundle2.putString("targetUrl", shareContent.getUrl());
                bundle2.putString("imageUrl", i);
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new QQShareActivity$doQQContactRequest$4(this, context, bundle2));
                return;
            } else {
                return;
            }
        } else if (shareContent != null) {
            str = shareContent.getTitle();
            str = str.substring(0, 29);
            k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
            }
            str2 = str2.substring(0, 39);
            k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            i = i(shareContent);
            if (TextUtils.isEmpty(i)) {
            }
        }
        str = null;
        str = str.substring(0, 29);
        k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
        }
        str2 = str2.substring(0, 39);
        k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i = i(shareContent);
        if (TextUtils.isEmpty(i)) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e8  */
    private final void g(Context context, ShareContent shareContent) {
        String str;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1819291946")) {
            ipChange.ipc$dispatch("1819291946", new Object[]{this, context, shareContent});
            return;
        }
        List<String> list = null;
        String str2 = "";
        if (TextUtils.isEmpty(shareContent != null ? shareContent.getTitle() : null)) {
            if (TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
                str = str2;
            } else if (shareContent != null) {
                str = shareContent.getContent();
            }
            if (str != null && str.length() > 200) {
                str = str.substring(0, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (!TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
                str2 = shareContent != null ? shareContent.getContent() : null;
            }
            if (str2 != null && str2.length() > 600) {
                str2 = str2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
                k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            ArrayList<String> arrayList = new ArrayList<>();
            if (shareContent != null) {
                list = shareContent.getImgUrls();
            }
            Objects.requireNonNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            ArrayList arrayList2 = (ArrayList) list;
            if (shareContent.getShareType() == 1) {
                Bundle bundle = new Bundle();
                bundle.putInt("req_type", 3);
                bundle.putString("summary", str);
                Bitmap e = ShareUtil.e(this, shareContent);
                String f = ShareUtil.f(this, e, true);
                ShareUtil.m(e);
                if (f == null || f.length() == 0) {
                    z = true;
                }
                if (!z) {
                    arrayList.add(f);
                }
                if (arrayList.isEmpty()) {
                    finish();
                }
                bundle.putStringArrayList("imageUrl", arrayList);
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new QQShareActivity$doQQZoneRequest$3(this, context, bundle));
                return;
            } else if (shareContent.getShareType() == 2 || shareContent.getShareType() == 3) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("req_type", 1);
                bundle2.putString("title", str);
                bundle2.putString("summary", str2);
                bundle2.putString("targetUrl", shareContent.getUrl());
                if (!arrayList.isEmpty()) {
                    arrayList.addAll(arrayList);
                } else {
                    Bitmap e2 = ShareUtil.e(this, shareContent);
                    String f2 = ShareUtil.f(this, e2, true);
                    ShareUtil.m(e2);
                    if (f2 == null || f2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        arrayList.add(f2);
                    }
                }
                bundle2.putStringArrayList("imageUrl", arrayList);
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new QQShareActivity$doQQZoneRequest$4(this, context, bundle2));
                return;
            } else {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("req_type", 3);
                bundle3.putString("summary", str);
                Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
                ((Activity) context).runOnUiThread(new QQShareActivity$doQQZoneRequest$5(this, context, bundle3));
                return;
            }
        } else if (shareContent != null) {
            str = shareContent.getTitle();
            str = str.substring(0, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
            k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (!TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
            }
            str2 = str2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
            k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            ArrayList<String> arrayList3 = new ArrayList<>();
            if (shareContent != null) {
            }
            Objects.requireNonNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
            ArrayList arrayList22 = (ArrayList) list;
            if (shareContent.getShareType() == 1) {
            }
        }
        str = null;
        str = str.substring(0, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
        k21.h(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (!TextUtils.isEmpty(shareContent != null ? shareContent.getContent() : null)) {
        }
        str2 = str2.substring(0, SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
        k21.h(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ArrayList<String> arrayList32 = new ArrayList<>();
        if (shareContent != null) {
        }
        Objects.requireNonNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        ArrayList arrayList222 = (ArrayList) list;
        if (shareContent.getShareType() == 1) {
        }
    }

    private final String i(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1110849431")) {
            return (String) ipChange.ipc$dispatch("-1110849431", new Object[]{this, shareContent});
        }
        List<String> imgUrls = shareContent != null ? shareContent.getImgUrls() : null;
        Bitmap e = ShareUtil.e(this, shareContent);
        if ((imgUrls == null || imgUrls.isEmpty()) && e == null) {
            return null;
        }
        if (!(imgUrls == null || imgUrls.isEmpty()) && !TextUtils.equals(imgUrls.get(0), ShareManager.INSTANCE.b().h())) {
            if (shareContent.getShareType() == 2 || shareContent.getShareType() == 3) {
                return imgUrls.get(0);
            }
            if (shareContent.getShareType() == 1 && !(o.L(imgUrls.get(0), "http", false, 2, null))) {
                return imgUrls.get(0);
            }
        }
        if (e != null) {
            return ShareUtil.g(this, e, false, 4, null);
        }
        return null;
    }

    public final IUiListener h() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-850618256")) {
            return this.d;
        }
        return (IUiListener) ipChange.ipc$dispatch("-850618256", new Object[]{this});
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-129447588")) {
            ipChange.ipc$dispatch("-129447588", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        Tencent.onActivityResultData(i, i2, intent, this.d);
    }

    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611060891")) {
            ipChange.ipc$dispatch("-611060891", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        ShareManager shareManager = ShareManager.INSTANCE;
        this.a = Tencent.createInstance(shareManager.b().p(), getApplicationContext(), shareManager.b().k());
        this.b = getIntent().getBooleanExtra("IsQQZone", false);
        Serializable serializableExtra = getIntent().getSerializableExtra("ShareParams");
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.alibaba.pictures.share.common.share.ShareContent");
        this.c = (ShareContent) serializableExtra;
        Tencent.setIsPermissionGranted(true);
        if (this.b) {
            fj2.INSTANCE.b(new QQShareActivity$onCreate$1(this));
        } else {
            fj2.INSTANCE.b(new QQShareActivity$onCreate$2(this));
        }
    }
}
