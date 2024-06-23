package com.alibaba.pictures.share.ddshare;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.android.dingtalk.share.ddsharemodule.DDShareApiFactory;
import com.android.dingtalk.share.ddsharemodule.IDDShareApi;
import com.android.dingtalk.share.ddsharemodule.message.DDImageMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDTextMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDWebpageMessage;
import com.android.dingtalk.share.ddsharemodule.message.SendMessageToDD;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.df;
import tb.j01;
import tb.k21;
import tb.v92;

/* compiled from: Taobao */
public final class DDApi {
    private static transient /* synthetic */ IpChange $ipChange;
    private IDDShareApi a;

    /* access modifiers changed from: private */
    public final void b(Context context, ShareContent shareContent, ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1136259410")) {
            ipChange.ipc$dispatch("1136259410", new Object[]{this, context, shareContent, shareChannel});
            return;
        }
        DDMediaMessage dDMediaMessage = new DDMediaMessage();
        if (shareContent.getShareType() == 1) {
            List<String> imgUrls = shareContent.getImgUrls();
            Objects.requireNonNull(imgUrls, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            ArrayList arrayList = (ArrayList) imgUrls;
            if ((!arrayList.isEmpty()) && TextUtils.equals((CharSequence) arrayList.get(0), ShareManager.INSTANCE.b().h())) {
                arrayList.remove(0);
            }
            Bitmap e = ShareUtil.e(context, shareContent);
            String str = null;
            String g = ShareUtil.g(context, e, false, 4, null);
            ShareUtil.m(e);
            if (!arrayList.isEmpty() || e != null) {
                DDImageMessage dDImageMessage = new DDImageMessage();
                if ((!arrayList.isEmpty()) && !TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
                    Object obj = arrayList.get(0);
                    k21.h(obj, "imgUrls[0]");
                    if (o.L((String) obj, "http", false, 2, null)) {
                        dDImageMessage.mImageUrl = (String) arrayList.get(0);
                        dDMediaMessage.mMediaObject = dDImageMessage;
                    }
                }
                if (g != null) {
                    if (g.length() <= 0) {
                        z = false;
                    }
                    if (z) {
                        str = g;
                    }
                    if (str != null) {
                        ShareManager shareManager = ShareManager.INSTANCE;
                        String k = shareManager.b().k();
                        if (k != null) {
                            Application a2 = shareManager.a();
                            if (a2 != null) {
                                dDImageMessage.mImageUri = FileProvider.getUriForFile(a2, k, new File(str));
                            } else {
                                v92.f();
                            }
                        }
                    }
                }
                dDMediaMessage.mMediaObject = dDImageMessage;
            } else {
                return;
            }
        } else if (shareContent.getShareType() == 2 || shareContent.getShareType() == 3) {
            DDWebpageMessage dDWebpageMessage = new DDWebpageMessage();
            dDWebpageMessage.mUrl = shareContent.getUrl();
            dDMediaMessage.mMediaObject = dDWebpageMessage;
            dDMediaMessage.mTitle = shareContent.getTitle();
            dDMediaMessage.mContent = shareContent.getContent();
            Bitmap h = ShareUtil.h(context, shareContent, 32);
            dDMediaMessage.mThumbData = j01.a(h, true);
            ShareUtil.m(h);
        } else {
            DDTextMessage dDTextMessage = new DDTextMessage();
            dDTextMessage.mText = shareContent.getContent();
            dDMediaMessage.mMediaObject = dDTextMessage;
            dDMediaMessage.mContent = shareContent.getContent();
        }
        SendMessageToDD.Req req = new SendMessageToDD.Req();
        req.mMediaMessage = dDMediaMessage;
        IDDShareApi iDDShareApi = this.a;
        if (iDDShareApi == null) {
            k21.A("iddShareApi");
        }
        if (iDDShareApi != null) {
            iDDShareApi.sendReq(req);
        }
    }

    public final void c(@NotNull Context context, @NotNull ShareContent shareContent, @NotNull ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1593565277")) {
            ipChange.ipc$dispatch("1593565277", new Object[]{this, context, shareContent, shareChannel});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(shareContent, "shareParams");
        k21.i(shareChannel, "shareType");
        ShareManager shareManager = ShareManager.INSTANCE;
        IDDShareApi createDDShareApi = DDShareApiFactory.createDDShareApi(context, shareManager.b().g(), true);
        k21.h(createDDShareApi, "DDShareApiFactory.create…           true\n        )");
        this.a = createDDShareApi;
        if (createDDShareApi == null) {
            k21.A("iddShareApi");
        }
        if (!createDDShareApi.isDDAppInstalled()) {
            String string = context.getString(R$string.dd_not_install);
            k21.h(string, "context.getString(R.string.dd_not_install)");
            ShareUtil.n(string);
            df.a(shareChannel, ShareException.APP_UNINSTALL);
            return;
        }
        IDDShareApi iDDShareApi = this.a;
        if (iDDShareApi == null) {
            k21.A("iddShareApi");
        }
        if (!iDDShareApi.isDDSupportAPI()) {
            String string2 = context.getString(R$string.dd_not_support_api);
            k21.h(string2, "context.getString(R.string.dd_not_support_api)");
            ShareUtil.n(string2);
            df.a(shareChannel, ShareException.APP_UNSUPPORT_VERSION);
            return;
        }
        ShareManager.IApplyPermission f = shareManager.b().f();
        if (f != null) {
            f.requestStoragePermission(new DDApi$share$1(this, context, shareContent, shareChannel), (Activity) context);
        }
    }
}
