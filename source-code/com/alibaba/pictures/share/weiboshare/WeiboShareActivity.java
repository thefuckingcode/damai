package com.alibaba.pictures.share.weiboshare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.uc.webview.export.media.MessageID;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.df;
import tb.f90;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0003H\u0014J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016R\u001c\u0010#\u001a\u00020\u000e8\u0006@\u0006XD¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/alibaba/pictures/share/weiboshare/WeiboShareActivity;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/sina/weibo/sdk/share/WbShareCallback;", "Ltb/ur2;", "setupWindowFlags", "sendMultiMessage", "Lcom/sina/weibo/sdk/api/TextObject;", "getTextObj", "Lcom/sina/weibo/sdk/api/ImageObject;", "getImageObj", "Lcom/sina/weibo/sdk/api/WebpageObject;", "getWebpageObj", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "shareParams", "", "getWeiboShareText", "Landroid/graphics/Bitmap;", "bitmap", "", "checkBitmap", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroy", "onComplete", "Lcom/sina/weibo/sdk/common/UiError;", "error", MessageID.onError, "onCancel", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "shareBmp", "Landroid/graphics/Bitmap;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class WeiboShareActivity extends FragmentActivity implements WbShareCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final String TAG = "WeiboShare";
    private Bitmap shareBmp;
    private ShareContent shareParams;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean checkBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1491573911")) {
            return bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1491573911", new Object[]{this, bitmap})).booleanValue();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final ImageObject getImageObj() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365854490")) {
            return (ImageObject) ipChange.ipc$dispatch("-1365854490", new Object[]{this});
        }
        ImageObject imageObject = new ImageObject();
        Bitmap e = ShareUtil.e(this, this.shareParams);
        this.shareBmp = e;
        Bitmap b = e != null ? ShareUtil.b(e, 1000) : null;
        this.shareBmp = b;
        imageObject.setImageData(b);
        return imageObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final TextObject getTextObj() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1245075506")) {
            return (TextObject) ipChange.ipc$dispatch("1245075506", new Object[]{this});
        }
        TextObject textObject = new TextObject();
        String weiboShareText = getWeiboShareText(this.shareParams);
        if (weiboShareText.length() > 130) {
            String substring = weiboShareText.substring(0, 130);
            k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            weiboShareText = substring + "...";
        }
        textObject.text = weiboShareText;
        return textObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0072 A[SYNTHETIC, Splitter:B:32:0x0072] */
    private final WebpageObject getWebpageObj() {
        Throwable th;
        ShareContent shareContent;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-232583210")) {
            return (WebpageObject) ipChange.ipc$dispatch("-232583210", new Object[]{this});
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.title = "";
        webpageObject.description = " ";
        Bitmap h = ShareUtil.h(this, this.shareParams, 16);
        String str = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            if (h != null) {
                try {
                    h.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        shareContent = this.shareParams;
                        if (shareContent != null) {
                        }
                        webpageObject.actionUrl = str;
                        return webpageObject;
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                        }
                        throw th;
                    }
                }
            }
            webpageObject.thumbData = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            e.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            shareContent = this.shareParams;
            if (shareContent != null) {
            }
            webpageObject.actionUrl = str;
            return webpageObject;
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        shareContent = this.shareParams;
        if (shareContent != null) {
            str = shareContent.getUrl();
        }
        webpageObject.actionUrl = str;
        return webpageObject;
    }

    private final String getWeiboShareText(ShareContent shareContent) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1005871600")) {
            return (String) ipChange.ipc$dispatch("1005871600", new Object[]{this, shareContent});
        }
        String str = null;
        String content = shareContent != null ? shareContent.getContent() : null;
        if (content == null || content.length() == 0) {
            if (shareContent != null) {
                str = shareContent.getTitle();
            }
            content = str;
        }
        if (!(content == null || content.length() == 0)) {
            z = false;
        }
        if (!z) {
            return content;
        }
        String v = ShareManager.INSTANCE.b().v();
        if (v == null) {
            v = "";
        }
        return v;
    }

    private final void sendMultiMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899211060")) {
            ipChange.ipc$dispatch("899211060", new Object[]{this});
            return;
        }
        Job unused = f.b(LifecycleOwnerKt.getLifecycleScope(this), f90.b(), null, new WeiboShareActivity$sendMultiMessage$1(this, null), 2, null);
    }

    private final void setupWindowFlags() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751956784")) {
            ipChange.ipc$dispatch("751956784", new Object[]{this});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            requestWindowFeature(1);
            if (i >= 19) {
                getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            }
        }
    }

    @NotNull
    public final String getTAG() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2054442714")) {
            return this.TAG;
        }
        return (String) ipChange.ipc$dispatch("2054442714", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1598112476")) {
            ipChange.ipc$dispatch("1598112476", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        IWBAPI c = ShareManager.INSTANCE.c();
        if (c != null) {
            c.doResultIntent(intent, this);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561108049")) {
            ipChange.ipc$dispatch("561108049", new Object[]{this});
            return;
        }
        df.a(ShareChannel.WEIBO, 1001);
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86005682")) {
            ipChange.ipc$dispatch("86005682", new Object[]{this});
            return;
        }
        df.b(ShareChannel.WEIBO);
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088924133")) {
            ipChange.ipc$dispatch("1088924133", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setupWindowFlags();
        IWBAPI c = ShareManager.INSTANCE.c();
        if (c == null || c.isWBAppInstalled()) {
            Serializable serializableExtra = getIntent().getSerializableExtra("ShareParams");
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.alibaba.pictures.share.common.share.ShareContent");
            this.shareParams = (ShareContent) serializableExtra;
            sendMultiMessage();
            return;
        }
        ShareUtil.n("分享失败，请先安装微博客户端");
        finish();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-212745627")) {
            ipChange.ipc$dispatch("-212745627", new Object[]{this});
            return;
        }
        super.onDestroy();
        ShareUtil.m(this.shareBmp);
        this.shareBmp = null;
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onError(@Nullable UiError uiError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008395706")) {
            ipChange.ipc$dispatch("-2008395706", new Object[]{this, uiError});
        } else if (uiError != null) {
            df.a(ShareChannel.WEIBO, uiError.errorCode);
        } else {
            df.a(ShareChannel.WEIBO, 1003);
            ur2 ur2 = ur2.INSTANCE;
        }
    }
}
