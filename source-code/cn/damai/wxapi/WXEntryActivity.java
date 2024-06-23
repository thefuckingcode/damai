package cn.damai.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import cn.damai.common.AppConfig;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.screenshot.ScreenShotDetector;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.open.oauth.wechat.WechatAuthRespHandler;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.SNSAuth;
import com.taobao.android.sns4android.TokenModel;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import tb.bk2;
import tb.fx2;
import tb.g91;
import tb.lk2;
import tb.yt2;
import tb.z10;

/* compiled from: Taobao */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String APP_ID_CRYPT = "qu1pe0lqy2H+MnEtd89\\/rch4lvA7kPSd";
    public static final String APP_SECRET = "d8c945e2efaee7a7bb4ca5eb1c913eaa";
    public static final String MINI_ID = "gh_8f607e128043";
    private static final int THUMB_SIZE = 150;
    public static final int TIMELINE_SUPPORTED_VERSION = 553779201;
    public static final String WX_GET_TOKEN_URL = "￼https://api.weixin.qq.com/sns/oauth2/access_token";
    public static int mWXfrom;
    public IWXAPI api;
    byte[] arraybyte;
    Bitmap bitmap;
    Bundle bundle;
    private String fromWhere;
    Handler handler = new Handler() {
        /* class cn.damai.wxapi.WXEntryActivity.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-980091731")) {
                ipChange.ipc$dispatch("-980091731", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            WXEntryActivity.this.shareMessage();
        }
    };
    private Bitmap imageBitmap;
    private String imageModeUrl;
    String imageurl = null;
    String message;
    private boolean miniprogram;
    String producturl;
    private long projectId;
    String sinaSharePath = null;
    private String snsType = "weixin";
    String title;
    int way = 0;

    private byte[] Bitmap2Bytes(Bitmap bitmap2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077672811")) {
            return (byte[]) ipChange.ipc$dispatch("1077672811", new Object[]{this, bitmap2});
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String buildTransaction(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898597954")) {
            return (String) ipChange.ipc$dispatch("898597954", new Object[]{this, str});
        } else if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        } else {
            return str + System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void fixImgSize(int i, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1001374635")) {
            ipChange.ipc$dispatch("-1001374635", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        double d = (double) i;
        double width = (double) this.bitmap.getWidth();
        double d2 = (d * 1.0d) / width;
        double d3 = (double) i2;
        double height = (double) this.bitmap.getHeight();
        double max = Math.max(d2, (1.0d * d3) / height);
        if (max == d2) {
            i3 = 0;
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, i, (int) (height * max), false);
        } else {
            i3 = 0;
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, (int) (width * max), i2, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.bitmap, i3, i3, i, i2);
        this.bitmap = createBitmap;
        if (Bitmap2Bytes(createBitmap).length > 130000) {
            fixImgSize((int) (d * 0.9d), (int) (d3 * 0.9d));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4.imageBitmap = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a2, code lost:
        if (r1 != null) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a4, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ad, code lost:
        r5 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0 A[SYNTHETIC, Splitter:B:28:0x00b0] */
    private void initExtras(Intent intent) {
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503192174")) {
            ipChange.ipc$dispatch("1503192174", new Object[]{this, intent});
            return;
        }
        Bundle extras = intent.getExtras();
        this.bundle = extras;
        if (extras != null) {
            this.title = extras.getString("title");
            this.message = this.bundle.getString("message");
            this.imageurl = this.bundle.getString("imageurl");
            this.producturl = this.bundle.getString("producturl");
            this.fromWhere = this.bundle.getString("fromWhere");
            this.projectId = this.bundle.getLong("projectId");
            this.way = this.bundle.getInt("way");
            this.miniprogram = this.bundle.getBoolean("miniprogram", false);
            String string = getIntent().getExtras().getString("imageModeUrl");
            this.imageModeUrl = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    fileInputStream = new FileInputStream(new File(this.imageModeUrl));
                    this.imageBitmap = BitmapFactory.decodeStream(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception unused) {
                    fileInputStream = null;
                } catch (Throwable th) {
                    fileInputStream = null;
                    Throwable th2 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
            if (getIntent().getExtras().containsKey("sinaSharePath")) {
                this.sinaSharePath = getIntent().getExtras().getString("sinaSharePath");
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImgFromUrl$0(DMImageCreator.d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1514865419")) {
            ipChange.ipc$dispatch("-1514865419", new Object[]{this, dVar});
            return;
        }
        share(this.way);
        finish();
    }

    private void onRespLogin(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1442758423")) {
            ipChange.ipc$dispatch("-1442758423", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            Log.i("WXTest", "onResp ERR_AUTH_DENIED");
            SNSAuth.invokeError(this.snsType, -1, getResources().getString(R$string.aliuser_SNS_platform_auth_fail));
        } else if (i == -2) {
            Log.i("WXTest", "onResp ERR_USER_CANCEL ");
            SNSAuth.getListener().onCancel(this, this.snsType);
        } else if (i != 0) {
            Log.i("WXTest", "onResp default errCode " + baseResp.errCode);
        } else {
            Log.i("WXTest", "onResp OK");
            if (baseResp instanceof SendAuth.Resp) {
                String str = ((SendAuth.Resp) baseResp).code;
                Log.i("WXTest", "onResp code = " + str);
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.snsType = this.snsType;
                TokenModel tokenModel = new TokenModel();
                tokenModel.authToken = str;
                tokenModel.consumerKey = lk2.c().k();
                sNSSignInAccount.token = JSON.toJSONString(tokenModel);
                sNSSignInAccount.app_id = lk2.c().k();
                SNSAuth.invokeTokenLogin(sNSSignInAccount);
            } else {
                SNSAuth.invokeError(this.snsType, -1, getResources().getString(R$string.aliuser_SNS_platform_auth_fail));
            }
        }
        finish();
    }

    private void onRespShare(BaseResp baseResp) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-792313121")) {
            ipChange.ipc$dispatch("-792313121", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            str = bk2.b(this, R$string.data_string_010);
        } else if (i == -2) {
            str = bk2.b(this, R$string.errcode_cancel);
        } else if (i != 0) {
            str = bk2.b(this, R$string.data_string_011);
        } else {
            str = bk2.b(this, R$string.errcode_success);
        }
        ToastUtil.i(str);
        finish();
    }

    public static void setWXType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487104774")) {
            ipChange.ipc$dispatch("-1487104774", new Object[]{Integer.valueOf(i)});
            return;
        }
        mWXfrom = i;
    }

    private void shareMiniProgram(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-493818464")) {
            ipChange.ipc$dispatch("-493818464", new Object[]{this, str});
            return;
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = this.producturl;
        wXMiniProgramObject.miniprogramType = 0;
        if (AppConfig.v()) {
            wXMiniProgramObject.userName = "gh_8f607e128043";
        } else {
            wXMiniProgramObject.userName = "gh_8f607e128043";
        }
        wXMiniProgramObject.path = "" + str;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = this.title;
        wXMediaMessage.description = this.message;
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            wXMediaMessage.thumbData = Bitmap2Bytes(bitmap2);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = wXMediaMessage;
        req.scene = 0;
        this.api.sendReq(req);
    }

    public boolean checkSharetype() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-422595689")) {
            return this.api.getWXAppSupportAPI() >= 553779201;
        }
        return ((Boolean) ipChange.ipc$dispatch("-422595689", new Object[]{this})).booleanValue();
    }

    public void loadImgFromUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194260166")) {
            ipChange.ipc$dispatch("194260166", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            a.b().c(str).n(new DMImageCreator.DMImageSuccListener() {
                /* class cn.damai.wxapi.WXEntryActivity.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    Bitmap bitmap;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1429897897")) {
                        ipChange.ipc$dispatch("1429897897", new Object[]{this, eVar});
                    } else if (eVar != null && (bitmap = eVar.b) != null) {
                        WXEntryActivity wXEntryActivity = WXEntryActivity.this;
                        wXEntryActivity.bitmap = bitmap;
                        if (bitmap != null) {
                            if (wXEntryActivity.miniprogram) {
                                WXEntryActivity.this.fixImgSize(500, 400);
                            } else {
                                WXEntryActivity wXEntryActivity2 = WXEntryActivity.this;
                                wXEntryActivity2.bitmap = yt2.f(wXEntryActivity2.bitmap, 100000);
                            }
                            WXEntryActivity.this.bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(yt2.g(WXEntryActivity.this.bitmap, 90, 130000)), null, null);
                            WXEntryActivity wXEntryActivity3 = WXEntryActivity.this;
                            wXEntryActivity3.share(wXEntryActivity3.way);
                            return;
                        }
                        wXEntryActivity.share(wXEntryActivity.way);
                        ToastUtil a = ToastUtil.a();
                        WXEntryActivity wXEntryActivity4 = WXEntryActivity.this;
                        a.j(wXEntryActivity4, bk2.b(wXEntryActivity4, R$string.data_string_012));
                    }
                }
            }).e(new fx2(this)).f();
        }
    }

    public void onCreate(Bundle bundle2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1226464235")) {
            ipChange.ipc$dispatch("1226464235", new Object[]{this, bundle2});
            return;
        }
        super.onCreate(bundle2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(83);
        linearLayout.setBackgroundDrawable(null);
        setContentView(linearLayout);
        this.api = WXAgent.createWxApi();
        if (AppConfig.v()) {
            this.api.registerApp(z10.a(WXAgent.APP_ID_DEBUG_CRYPT));
        } else {
            this.api.registerApp(z10.a(WXAgent.APP_ID_CRYPT));
        }
        this.api.handleIntent(getIntent(), this);
        initExtras(getIntent());
        if (this.title != null && mWXfrom != 1) {
            this.handler.sendEmptyMessage(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251202027")) {
            ipChange.ipc$dispatch("251202027", new Object[]{this});
            return;
        }
        super.onDestroy();
        ScreenShotDetector.k().z(false);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774891782")) {
            ipChange.ipc$dispatch("1774891782", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        g91.g("aa", "onnewintent");
        this.bundle = intent.getExtras();
        setIntent(intent);
        this.api.handleIntent(intent, this);
        finish();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942919252")) {
            ipChange.ipc$dispatch("1942919252", new Object[]{this, baseReq});
            return;
        }
        baseReq.getType();
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "645487200")) {
            ipChange.ipc$dispatch("645487200", new Object[]{this, baseResp});
            return;
        }
        int i = baseResp.errCode;
        if (i == -4) {
            Log.i("WXTest", "onResp ERR_AUTH_DENIED");
            WechatAuthRespHandler.getInstance().handleWechatFail();
        } else if (i == -2) {
            Log.i("WXTest", "onResp ERR_USER_CANCEL ");
            WechatAuthRespHandler.getInstance().handleWechatFail();
        } else if (i != 0) {
            Log.i("WXTest", "onResp default errCode " + baseResp.errCode);
        } else {
            Log.i("WXTest", "onResp OK");
            if (baseResp instanceof SendAuth.Resp) {
                WechatAuthRespHandler.getInstance().handleWechatAuthCode(((SendAuth.Resp) baseResp).code);
            } else {
                WechatAuthRespHandler.getInstance().handleWechatFail();
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026840200")) {
            ipChange.ipc$dispatch("-1026840200", new Object[]{this});
            return;
        }
        super.onResume();
        ScreenShotDetector.k().z(true);
    }

    public void openWchart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627986387")) {
            ipChange.ipc$dispatch("1627986387", new Object[]{this});
            return;
        }
        this.api.openWXApp();
    }

    public void share(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340065604")) {
            ipChange.ipc$dispatch("-340065604", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            if (this.bitmap == null) {
                this.bitmap = ((BitmapDrawable) getResources().getDrawable(R$drawable.logo)).getBitmap();
            }
            if (GenerateImageUtil.TYPE_FROMWHERE_PEOJECT_DETAIL.equals(this.fromWhere) && this.way == 0 && TextUtils.isEmpty(this.imageModeUrl)) {
                StringBuilder sb = new StringBuilder();
                sb.append("/pages/home/index?url=");
                sb.append(URLEncoder.encode("/pages/detail/item?id=" + this.projectId));
                shareMiniProgram(sb.toString());
                finish();
            } else if (this.miniprogram) {
                shareMiniProgram("/pages/home/index?url=" + URLEncoder.encode(this.producturl));
                finish();
            } else {
                WXWebpageObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = this.producturl;
                WXMediaMessage wXMediaMessage = null;
                Bitmap bitmap2 = this.imageBitmap;
                if (bitmap2 != null) {
                    wXMediaMessage = new WXMediaMessage(new WXImageObject(bitmap2));
                } else if (this.bitmap != null) {
                    wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                    wXMediaMessage.title = this.title;
                    if (i == 0) {
                        wXMediaMessage.description = this.message;
                    }
                    byte[] Bitmap2Bytes = Bitmap2Bytes(this.bitmap);
                    this.arraybyte = Bitmap2Bytes;
                    wXMediaMessage.thumbData = Bitmap2Bytes;
                    wXMediaMessage.setThumbImage(this.bitmap);
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = buildTransaction("testapp");
                req.message = wXMediaMessage;
                if (i != 0) {
                    req.scene = 1;
                }
                this.api.sendReq(req);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
            ToastUtil.i(bk2.b(this, R$string.data_string_009));
        }
    }

    public void shareMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810926020")) {
            ipChange.ipc$dispatch("-810926020", new Object[]{this});
            return;
        }
        try {
            if (yt2.b(this, true)) {
                if (!TextUtils.isEmpty(this.imageModeUrl)) {
                    share(this.way);
                } else if (TextUtils.isEmpty(this.imageurl)) {
                    share(this.way);
                } else {
                    loadImgFromUrl(this.imageurl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
