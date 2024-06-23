package cn.damai.commonbusiness.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;
import tb.lk2;
import tb.xf2;

/* compiled from: Taobao */
public class WeiboShareActivity extends Activity implements WbShareCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Bitmap f;
    private String g;
    private IWBAPI h;

    /* compiled from: Taobao */
    public class a implements WbAuthListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onCancel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1598461512")) {
                ipChange.ipc$dispatch("1598461512", new Object[]{this});
                return;
            }
            WeiboShareActivity.this.finish();
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onComplete(Oauth2AccessToken oauth2AccessToken) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1018235599")) {
                ipChange.ipc$dispatch("-1018235599", new Object[]{this, oauth2AccessToken});
                return;
            }
            WeiboShareActivity.this.g();
        }

        @Override // com.sina.weibo.sdk.auth.WbAuthListener
        public void onError(UiError uiError) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-187706243")) {
                ipChange.ipc$dispatch("-187706243", new Object[]{this, uiError});
                return;
            }
            WeiboShareActivity.this.finish();
        }
    }

    /* compiled from: Taobao */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "15425477")) {
                ipChange.ipc$dispatch("15425477", new Object[]{this, dVar});
                return;
            }
            WeiboShareActivity.this.j(null);
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1711822438")) {
                ipChange.ipc$dispatch("-1711822438", new Object[]{this, eVar});
                return;
            }
            WeiboShareActivity.this.j(eVar.b);
        }
    }

    private ImageObject b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500129712")) {
            return (ImageObject) ipChange.ipc$dispatch("-1500129712", new Object[]{this});
        }
        ImageObject imageObject = new ImageObject();
        if (!TextUtils.isEmpty(this.e)) {
            imageObject.setImageData(BitmapFactory.decodeFile(this.e));
        } else {
            Bitmap bitmap = this.f;
            if (bitmap != null) {
                imageObject.setImageData(bitmap);
            }
        }
        return imageObject;
    }

    private String c() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "761156434")) {
            return this.b;
        }
        return (String) ipChange.ipc$dispatch("761156434", new Object[]{this});
    }

    private TextObject d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1083553252")) {
            return (TextObject) ipChange.ipc$dispatch("-1083553252", new Object[]{this});
        }
        TextObject textObject = new TextObject();
        textObject.text = c();
        textObject.title = this.a;
        textObject.actionUrl = this.d;
        return textObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085 A[SYNTHETIC, Splitter:B:30:0x0085] */
    private WebpageObject e() {
        Bitmap bitmap;
        Throwable th;
        Exception e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1924109760")) {
            return (WebpageObject) ipChange.ipc$dispatch("-1924109760", new Object[]{this});
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.identify = UUID.randomUUID().toString();
        webpageObject.title = "";
        webpageObject.description = this.b;
        if (!TextUtils.isEmpty(this.e)) {
            bitmap = BitmapFactory.decodeFile(this.e);
        } else {
            bitmap = ((BitmapDrawable) getResources().getDrawable(R$drawable.logo)).getBitmap();
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                webpageObject.thumbData = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                e2 = e4;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    e2.printStackTrace();
                    if (byteArrayOutputStream != null) {
                    }
                    webpageObject.actionUrl = this.d;
                    webpageObject.defaultText = this.b;
                    return webpageObject;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e2 = e6;
            e2.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            webpageObject.actionUrl = this.d;
            webpageObject.defaultText = this.b;
            return webpageObject;
        }
        webpageObject.actionUrl = this.d;
        webpageObject.defaultText = this.b;
        return webpageObject;
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416164451")) {
            ipChange.ipc$dispatch("-1416164451", new Object[]{this});
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.a = extras.getString("title");
            this.b = extras.getString("message");
            this.c = extras.getString("imageurl");
            this.d = extras.getString("producturl");
            if (extras.containsKey("sinaSharePath")) {
                this.e = extras.getString("sinaSharePath");
            }
            if (!TextUtils.isEmpty(this.b) && !"bytype".equals(extras.getString("fromWhere", ""))) {
                if (this.b.contains(this.d)) {
                    String str = this.b;
                    this.b = str.substring(0, str.indexOf(this.d));
                }
                if (this.b.length() > 140) {
                    if (this.b.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                        int indexOf = this.b.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                        String substring = this.b.substring(indexOf);
                        this.b = this.b.substring(0, indexOf).substring(0, 140 - this.b.substring(indexOf).length()) + substring;
                    } else {
                        this.b = ("大麦#去现场为所爱#" + this.b).substring(0, 140);
                    }
                } else if (!this.b.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    this.b = "大麦#去现场为所爱#" + this.b;
                }
                if (this.b.length() + 10 > 140) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = this.b;
                    sb.append(str2.substring(0, str2.length() - 10));
                    sb.append("（@大麦官博 发布）");
                    this.b = sb.toString();
                    return;
                }
                this.b += "（@大麦官博 发布）";
            }
        }
    }

    private void h(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189431415")) {
            ipChange.ipc$dispatch("1189431415", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        i(z, z2);
    }

    private void i(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-380256482")) {
            ipChange.ipc$dispatch("-380256482", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (z) {
            weiboMultiMessage.textObject = d();
        }
        if (z2) {
            weiboMultiMessage.imageObject = b();
        }
        weiboMultiMessage.mediaObject = e();
        this.h.shareMessage(this, weiboMultiMessage, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1326975062")) {
            ipChange.ipc$dispatch("1326975062", new Object[]{this, bitmap});
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(this.b)) {
            weiboMultiMessage.textObject = d();
        }
        if (bitmap != null) {
            ImageObject imageObject = new ImageObject();
            imageObject.setImageData(bitmap);
            weiboMultiMessage.imageObject = imageObject;
        }
        weiboMultiMessage.mediaObject = e();
        this.h.shareMessage(this, weiboMultiMessage, false);
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63772333")) {
            ipChange.ipc$dispatch("-63772333", new Object[]{this});
            return;
        }
        cn.damai.common.image.a.b().h(this).c(this.c).n(new c()).e(new b()).f();
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336877492")) {
            ipChange.ipc$dispatch("-1336877492", new Object[]{this});
            return;
        }
        this.h.authorize(this, new a());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|(1:25)) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r5.f = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        if (r2 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006d, code lost:
        r1.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0058 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068 A[SYNTHETIC, Splitter:B:30:0x0068] */
    public void g() {
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1063556895")) {
            ipChange.ipc$dispatch("1063556895", new Object[]{this});
            return;
        }
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.g = getIntent().getExtras().getString("imageModeUrl");
        }
        if (!TextUtils.isEmpty(this.g)) {
            try {
                fileInputStream = new FileInputStream(new File(this.g));
                this.f = BitmapFactory.decodeStream(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                fileInputStream = null;
                Throwable th2 = th;
                if (fileInputStream != null) {
                }
                throw th2;
            }
        }
        if (this.f != null) {
            h(false, true);
            return;
        }
        f();
        if (!TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.c)) {
            h(!TextUtils.isEmpty(this.b), !TextUtils.isEmpty(this.e));
        } else {
            k();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051233978")) {
            ipChange.ipc$dispatch("-2051233978", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        IWBAPI iwbapi = this.h;
        if (iwbapi != null) {
            iwbapi.authorizeCallback(this, i, i2, intent);
            this.h.doResultIntent(intent, this);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onCancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-264932549")) {
            ipChange.ipc$dispatch("-264932549", new Object[]{this});
            return;
        }
        finish();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "829940764")) {
            ipChange.ipc$dispatch("829940764", new Object[]{this});
            return;
        }
        Toast.makeText(this, "微博分享成功", 0).show();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719583045")) {
            ipChange.ipc$dispatch("-1719583045", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.layout_wbshare);
        AuthInfo authInfo = new AuthInfo(this, lk2.c().h(), lk2.d, lk2.e);
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this);
        this.h = createWBAPI;
        createWBAPI.registerApp(this, authInfo);
        this.h.setLoggerEnable(true);
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(this);
        if (readAccessToken == null || xf2.j(readAccessToken.getAccessToken()) || !readAccessToken.isSessionValid()) {
            l();
        } else {
            g();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onError(UiError uiError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1362774864")) {
            ipChange.ipc$dispatch("-1362774864", new Object[]{this, uiError});
            return;
        }
        finish();
    }
}
