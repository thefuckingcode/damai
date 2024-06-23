package com.tencent.connect.common;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    protected boolean a = false;
    protected Handler b = new Handler() {
        /* class com.tencent.connect.common.AssistActivity.AnonymousClass1 */

        public void handleMessage(Message message) {
            if (message.what == 0 && !AssistActivity.this.isFinishing()) {
                SLog.w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                AssistActivity.this.finish();
            }
        }
    };
    private boolean c = false;
    private String d;
    private QQStayReceiver e;
    private boolean f;

    /* compiled from: Taobao */
    private class QQStayReceiver extends BroadcastReceiver {
        private QQStayReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            Intent intent2 = new Intent();
            intent2.putExtra(Constants.KEY_ACTION, "action_share");
            try {
                Uri uri = (Uri) intent.getParcelableExtra("uriData");
                String uri2 = uri.toString();
                if (!uri2.contains(str)) {
                    str = "?";
                }
                for (String str2 : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                    String[] split = str2.split("=");
                    intent2.putExtra(split[0], split[1]);
                }
                intent2.setData(uri);
            } catch (Exception e) {
                SLog.i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e.getMessage());
                intent2.putExtra("result", "error");
                intent2.putExtra("response", "parse error.");
            }
            AssistActivity.this.setResult(-1, intent2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071  */
    private void a(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString(ALBiometricsKeys.KEY_APP_ID);
        String str4 = "";
        if ("shareToQQ".equals(string2)) {
            str2 = Constants.VIA_SHARE_TO_QQ;
            str3 = "10";
        } else if ("shareToQzone".equals(string2)) {
            str2 = Constants.VIA_SHARE_TO_QZONE;
            str3 = "11";
        } else {
            str = str4;
            if (m.a(this, string3)) {
                IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string2);
                if (listnerWithAction != null) {
                    listnerWithAction.onError(new UiError(-6, Constants.MSG_OPEN_BROWSER_ERROR, null));
                }
                e.a().a(string4, string5, str4, str, "3", "1", string, "0", "2", "0");
                finish();
            } else {
                e.a().a(string4, string5, str4, str, "3", "0", string, "0", "2", "0");
            }
            getIntent().removeExtra("shareH5");
        }
        str = str3;
        str4 = str2;
        if (m.a(this, string3)) {
        }
        getIntent().removeExtra("shareH5");
    }

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i);
        sb.append(" | resultCode: ");
        sb.append(i2);
        sb.append("data = null ? ");
        sb.append(intent == null);
        SLog.i("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra(Constants.KEY_ACTION, "action_login");
            }
            setResultData(i, intent);
            if (!this.f) {
                SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
                finish();
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.connect.common.AssistActivity.AnonymousClass2 */

                public void run() {
                    SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
                    AssistActivity.this.finish();
                }
            }, 200);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0121  */
    public void onCreate(Bundle bundle) {
        int i;
        String str;
        Throwable th;
        getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        boolean z = true;
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f = getIntent().getBooleanExtra(Constants.KEY_RESTORE_LANDSCAPE, false);
        SLog.i("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.f);
        if (getIntent() == null) {
            SLog.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        if (intent == null) {
            i = 0;
        } else {
            i = intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
        }
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra("appid");
        }
        this.d = str;
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.c = bundle.getBoolean("RESTART_FLAG");
            this.a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.c) {
            SLog.d("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            SLog.w("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
        } else if (intent != null) {
            SLog.i("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + i);
            try {
                String queryParameter = intent.getData().getQueryParameter("share_id");
                IntentFilter intentFilter = new IntentFilter(Constants.SHARE_QQ_AND_STAY + queryParameter);
                if (this.e == null) {
                    this.e = new QQStayReceiver();
                }
                registerReceiver(this.e, intentFilter);
            } catch (Exception e2) {
                SLog.i("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e2.getMessage());
            }
            try {
                if (intent.getBooleanExtra(Constants.FOR_RESULT, true)) {
                    startActivityForResult(intent, i);
                } else {
                    startActivity(intent);
                }
            } catch (Exception e3) {
                String message = e3.getMessage();
                SLog.e("openSDK_LOG.AssistActivity", "--onCreate--startActivity exception: " + message);
                SLog.e("openSDK_LOG.AssistActivity", "--onCreate--startActException");
                finish();
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                }
                throw th;
            }
        } else {
            SLog.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        QQStayReceiver qQStayReceiver = this.e;
        if (qQStayReceiver != null) {
            unregisterReceiver(qQStayReceiver);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(Constants.KEY_REQUEST_CODE, -1);
        if (intExtra == 10108) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10109) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_set_emotion");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10110) {
            intent.putExtra(Constants.KEY_ACTION, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10111) {
            intent.putExtra(Constants.KEY_ACTION, "joinGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10112) {
            intent.putExtra(Constants.KEY_ACTION, "bindGroup");
            if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (!isFinishing()) {
                finish();
            }
        } else if (intExtra == 10113) {
            intent.putExtra(Constants.KEY_ACTION, intent.getStringExtra("action"));
            setResult(-1, intent);
            if (!isFinishing()) {
                SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
                finish();
            }
        } else if (intExtra != 10114) {
            intent.putExtra(Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (!isFinishing()) {
                SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
                finish();
            }
        } else {
            intent.putExtra(Constants.KEY_ACTION, intent.getStringExtra("action"));
            setResult(-1, intent);
            if (!isFinishing()) {
                SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
                finish();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onPause");
        this.b.removeMessages(0);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.c && !isFinishing()) {
                finish();
            }
            if (this.a) {
                this.b.sendMessage(this.b.obtainMessage(0));
                return;
            }
            this.a = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        SLog.i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.a);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        SLog.i("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void setResultData(int i, Intent intent) {
        if (intent == null) {
            SLog.w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                e.a().a("", this.d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
            SLog.d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String optString = jSONObject.optString("openid");
                String optString2 = jSONObject.optString(Constants.PARAM_ACCESS_TOKEN);
                String optString3 = jSONObject.optString("proxy_code");
                long optLong = jSONObject.optLong("proxy_expires_in");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    SLog.i("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    e.a().a(optString, this.d, "2", "1", "7", "0");
                } else if (TextUtils.isEmpty(optString3) || optLong == 0) {
                    SLog.w("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    e.a().a("", this.d, "2", "1", "7", "1");
                } else {
                    SLog.i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                    setResult(-1, intent);
                }
            } else {
                SLog.w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e2.printStackTrace();
        }
    }
}
