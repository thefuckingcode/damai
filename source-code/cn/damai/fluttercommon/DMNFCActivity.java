package cn.damai.fluttercommon;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import cn.damai.ticket.nfc.NfcUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import tb.er;
import tb.h91;
import tb.qi1;

/* compiled from: Taobao */
public class DMNFCActivity extends DMBaseFlutterActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CHANNEL_NATIVE = "cn.movieshow.app/nfcverify";
    private static final String NFC_READ_FAIL = "2";
    private static final String NFC_READ_OVERTIME = "3";
    private static final String NFC_READ_SUCCESS = "1";
    private final String TAG = DMNFCActivity.class.getSimpleName();
    private final NfcUtil nfcUtil = new NfcUtil();

    /* compiled from: Taobao */
    public class a implements NfcUtil.ReadCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.ticket.nfc.NfcUtil.ReadCallback
        public void onReadError(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-588302746")) {
                ipChange.ipc$dispatch("-588302746", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            DMNFCActivity.this.flutterPlugin("2", new HashMap(), i, str);
            h91.b("DMNFCActivity", str);
        }

        @Override // cn.damai.ticket.nfc.NfcUtil.ReadCallback
        public void onReadOvertime() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1840958490")) {
                ipChange.ipc$dispatch("1840958490", new Object[]{this});
                return;
            }
            DMNFCActivity.this.flutterPlugin("3", new HashMap(), 1000, "验证超时，没有检测到验真芯片");
            DMNFCActivity.this.pauseNfc(false);
            h91.b("DMNFCActivity", "11111超时了");
        }

        @Override // cn.damai.ticket.nfc.NfcUtil.ReadCallback
        public void onReadSuccess(qi1 qi1) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "153151139")) {
                ipChange.ipc$dispatch("153151139", new Object[]{this, qi1});
                return;
            }
            HashMap hashMap = new HashMap();
            if (qi1 != null) {
                hashMap.put("uid", qi1.e());
                hashMap.put("sid", qi1.c());
                hashMap.put("tid", qi1.d());
                hashMap.put("challenge", qi1.a());
                hashMap.put("cipherText", qi1.b());
                DMNFCActivity.this.flutterPlugin("1", hashMap, -1, "");
                h91.b("DMNFCActivity", "111111uid=" + qi1.e() + " sid=" + qi1.c() + " tid=" + qi1.d() + " challenge=" + qi1.b() + "=cipherText=" + qi1.b());
                return;
            }
            hashMap.put("msg", "返回结果为null");
            DMNFCActivity.this.flutterPlugin("2", null, -1, "");
            h91.b("DMNFCActivity", "111111值为null");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void flutterPlugin(String str, Map map, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1971213034")) {
            ipChange.ipc$dispatch("1971213034", new Object[]{this, str, map, Integer.valueOf(i), str2});
            return;
        }
        if (map == null) {
            map = new HashMap();
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("msg", str2);
        }
        HashMap hashMap = new HashMap();
        er.a(i, hashMap);
        hashMap.put("code", str);
        hashMap.put("data", map);
        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL_NATIVE).invokeMethod("vefifyComplete", hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void pauseNfc(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894940442")) {
            ipChange.ipc$dispatch("-894940442", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        NfcUtil nfcUtil2 = this.nfcUtil;
        if (nfcUtil2 != null) {
            if (z) {
                nfcUtil2.j();
            }
            this.nfcUtil.h();
        }
    }

    public NfcUtil getNfcUtil() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1345003044")) {
            return this.nfcUtil;
        }
        return (NfcUtil) ipChange.ipc$dispatch("-1345003044", new Object[]{this});
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1364984780")) {
            ipChange.ipc$dispatch("1364984780", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        this.nfcUtil.n(NfcUtil.TriggerMode.ONCE);
        this.nfcUtil.m(30000);
        this.nfcUtil.g(this, new a());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311138316")) {
            ipChange.ipc$dispatch("311138316", new Object[]{this});
            return;
        }
        h91.a(this.TAG, "MainActivity::onDestroy() --");
        super.onDestroy();
        pauseNfc(true);
    }

    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-31268254")) {
            return ((Boolean) ipChange.ipc$dispatch("-31268254", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            pauseNfc(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    @Override // io.flutter.embedding.android.FlutterActivity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1785009689")) {
            ipChange.ipc$dispatch("-1785009689", new Object[]{this, intent});
            return;
        }
        super.onNewIntent(intent);
        String str = this.TAG;
        h91.a(str, "MainActivity::onNewIntent() --" + intent.getAction());
        this.nfcUtil.i(intent);
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083979056")) {
            ipChange.ipc$dispatch("-2083979056", new Object[]{this});
            return;
        }
        super.onPause();
    }

    @Override // cn.damai.fluttercommon.DMBaseFlutterActivity, com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1468945207")) {
            ipChange.ipc$dispatch("1468945207", new Object[]{this});
            return;
        }
        h91.a(this.TAG, "MainActivity::onResume() --");
        super.onResume();
        this.nfcUtil.k();
    }
}
