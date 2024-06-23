package com.alibaba.pictures.share.wxapi;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.share.ShareException;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import io.flutter.wpkbridge.WPKFactory;
import java.io.File;
import java.net.URLEncoder;
import tb.df;
import tb.j01;
import tb.k21;
import tb.ur2;
import tb.v92;

public final class WeixinApi {
    private static transient /* synthetic */ IpChange $ipChange;
    private IWXAPI a;

    private final String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1579031416")) {
            return (String) ipChange.ipc$dispatch("1579031416", new Object[]{this, str});
        } else if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        } else {
            return str + System.currentTimeMillis();
        }
    }

    private final boolean d(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1994341293")) {
            return bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1994341293", new Object[]{this, bitmap})).booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e A[Catch:{ Exception -> 0x00f8 }] */
    private final void e(Context context, IWXAPI iwxapi, ShareContent shareContent, boolean z) {
        Bitmap bitmap;
        boolean z2;
        String shareMode;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2063339176")) {
            ipChange.ipc$dispatch("-2063339176", new Object[]{this, context, iwxapi, shareContent, Boolean.valueOf(z)});
            return;
        }
        try {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            ShareManager shareManager = ShareManager.INSTANCE;
            String str = null;
            wXMiniProgramObject.webpageUrl = shareManager.b().e() == 1 ? shareManager.b().y() : shareContent != null ? shareContent.getUrl() : null;
            if (shareManager.b().j() == ShareManager.EnvModeEnum.ONLINE) {
                wXMiniProgramObject.miniprogramType = 0;
            } else {
                String shareMode2 = shareContent != null ? shareContent.getShareMode() : null;
                if (shareMode2 != null) {
                    if (shareMode2.length() != 0) {
                        z2 = false;
                        if (!z2) {
                            wXMiniProgramObject.miniprogramType = (shareContent == null || (shareMode = shareContent.getShareMode()) == null) ? 0 : Integer.parseInt(shareMode);
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                }
            }
            wXMiniProgramObject.userName = shareContent != null ? shareContent.getMiniUrl() : null;
            StringBuilder sb = new StringBuilder();
            String x = shareManager.b().x();
            if (x == null) {
                x = "/pages/index/index?url=";
            }
            sb.append(x);
            sb.append(URLEncoder.encode(shareContent != null ? shareContent.getUrl() : null));
            wXMiniProgramObject.path = sb.toString();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
            if (shareContent != null) {
                str = shareContent.getTitle();
            }
            wXMediaMessage.title = str;
            Bitmap e = ShareUtil.e(context, shareContent);
            if (shareManager.b().e() == 1) {
                bitmap = ShareUtil.k(e, 128);
            } else {
                bitmap = ShareUtil.d(e, 500, 400);
            }
            wXMediaMessage.thumbData = j01.a(bitmap, true);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = c("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            if (iwxapi != null) {
                iwxapi.sendReq(req);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.tencent.mm.opensdk.openapi.IWXAPI] */
    /* JADX WARN: Type inference failed for: r14v0, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.alibaba.ip.runtime.IpChange] */
    /* JADX WARN: Type inference failed for: r3v11, types: [tb.ur2] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object[]] */
    /* access modifiers changed from: public */
    /* JADX WARNING: Unknown variable types count: 3 */
    private final void f(Context context, IWXAPI iwxapi, ShareContent shareContent, boolean z) {
        WXImageObject wXImageObject;
        String g;
        String str;
        ?? r0 = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(r0, "732955550")) {
            r0.ipc$dispatch("732955550", new Object[]{this, context, iwxapi, shareContent, Boolean.valueOf((boolean) z)});
            return;
        }
        String str2 = null;
        if (shareContent != null && shareContent.getShareType() == 1) {
            Bitmap e = ShareUtil.e(context, shareContent);
            if (!d(e)) {
                Bitmap i = ShareUtil.i(e, 32);
                ShareManager shareManager = ShareManager.INSTANCE;
                String k = shareManager.b().k();
                if (!(k == null || (g = ShareUtil.g(context, e, false, 4, null)) == null)) {
                    Application a2 = shareManager.a();
                    if (a2 != null) {
                        Uri uriForFile = FileProvider.getUriForFile(a2, k, new File(g));
                        if (uriForFile != null) {
                            context.grantUriPermission("com.tencent.mm", uriForFile, 1);
                            str = uriForFile.toString();
                            str2 = ur2.INSTANCE;
                        } else {
                            str = null;
                        }
                        if (str2 == null) {
                            str2 = str;
                        }
                        str2 = str;
                    }
                    v92.f();
                    ur2 ur2 = ur2.INSTANCE;
                    str = str2;
                    str2 = str;
                }
                if (str2 == null || str2.length() == 0) {
                    z2 = true;
                }
                if (!z2) {
                    wXImageObject = new WXImageObject();
                    wXImageObject.imagePath = str2;
                } else {
                    shareContent.setImageMaxSizeKb(1000);
                    wXImageObject = new WXImageObject(ShareUtil.e(context, shareContent));
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
                wXMediaMessage.thumbData = j01.a(i, true);
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = c("img");
                req.message = wXMediaMessage;
                req.scene = z;
                if (iwxapi != 0) {
                    iwxapi.sendReq(req);
                }
                ShareUtil.m(e);
                ShareUtil.m(i);
            }
        } else if ((shareContent != null && shareContent.getShareType() == 2) || (shareContent != null && shareContent.getShareType() == 3)) {
            WXMediaMessage wXMediaMessage2 = new WXMediaMessage(new WXWebpageObject(shareContent.getUrl()));
            wXMediaMessage2.title = shareContent.getTitle();
            wXMediaMessage2.description = shareContent.getContent();
            Bitmap h = ShareUtil.h(context, shareContent, 32);
            wXMediaMessage2.thumbData = j01.a(h, true);
            ShareUtil.m(h);
            SendMessageToWX.Req req2 = new SendMessageToWX.Req();
            req2.transaction = c("webpage");
            req2.message = wXMediaMessage2;
            req2.scene = z == true ? 1 : 0;
            if (iwxapi != 0) {
                iwxapi.sendReq(req2);
            }
        } else if (shareContent == null || shareContent.getShareType() != 4) {
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = shareContent != null ? shareContent.getContent() : null;
            WXMediaMessage wXMediaMessage3 = new WXMediaMessage();
            wXMediaMessage3.mediaObject = wXTextObject;
            if (shareContent != null) {
                str2 = shareContent.getContent();
            }
            wXMediaMessage3.description = str2;
            SendMessageToWX.Req req3 = new SendMessageToWX.Req();
            req3.transaction = c("text");
            req3.message = wXMediaMessage3;
            req3.scene = z;
            if (iwxapi != 0) {
                iwxapi.sendReq(req3);
            }
        } else {
            e(context, iwxapi, shareContent, z);
        }
    }

    public final void g(Context context, ShareContent shareContent, boolean z, ShareChannel shareChannel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981283359")) {
            ipChange.ipc$dispatch("981283359", new Object[]{this, context, shareContent, Boolean.valueOf(z), shareChannel});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(shareContent, "shareParams");
        ShareManager shareManager = ShareManager.INSTANCE;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, shareManager.b().w());
        if (createWXAPI != null) {
            createWXAPI.registerApp(shareManager.b().w());
            if (!createWXAPI.isWXAppInstalled()) {
                String string = context.getString(R$string.weixin_not_install);
                k21.h(string, "context.getString(R.string.weixin_not_install)");
                ShareUtil.n(string);
                df.a(shareChannel, ShareException.APP_UNINSTALL);
                return;
            } else if (createWXAPI.getWXAppSupportAPI() < 570425345) {
                String string2 = context.getString(R$string.weixin_not_support_api);
                k21.h(string2, "context.getString(R.string.weixin_not_support_api)");
                ShareUtil.n(string2);
                df.a(shareChannel, ShareException.APP_UNSUPPORT_VERSION);
                return;
            } else {
                new Thread(new WeixinApi$share$$inlined$apply$lambda$1(this, context, shareChannel, shareContent, z)).start();
                ur2 ur2 = ur2.INSTANCE;
            }
        } else {
            createWXAPI = null;
        }
        this.a = createWXAPI;
    }
}
