package cn.damai.ticket.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcBarcode;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.media.MessageID;
import tb.qi1;

/* compiled from: Taobao */
public class NfcUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static String[][] i;
    private static IntentFilter[] j;
    private Activity a;
    private NfcAdapter b;
    private PendingIntent c;
    private boolean d;
    private TriggerMode e = TriggerMode.ALWAYS;
    private ReadCallback f;
    private a g;
    private int h = 60000;

    /* compiled from: Taobao */
    public interface ReadCallback {
        void onReadError(int i, String str);

        void onReadOvertime();

        void onReadSuccess(qi1 qi1);
    }

    /* compiled from: Taobao */
    public enum TriggerMode {
        ONCE,
        ALWAYS
    }

    /* compiled from: Taobao */
    private class a extends CountDownTimer {
        public a(long j) {
            super(j, j);
        }

        public void onFinish() {
            Log.i("nfc", "once read overtime");
            NfcUtil.this.d = false;
            if (NfcUtil.this.f != null) {
                NfcUtil.this.f.onReadOvertime();
            }
        }

        public void onTick(long j) {
        }
    }

    static {
        try {
            i = new String[][]{new String[]{NfcA.class.getName()}, new String[]{NfcB.class.getName()}, new String[]{Ndef.class.getName()}, new String[]{MifareClassic.class.getName()}, new String[]{IsoDep.class.getName()}, new String[]{NfcBarcode.class.getName()}, new String[]{MifareUltralight.class.getName()}, new String[]{NfcV.class.getName()}, new String[]{NfcF.class.getName()}, new String[]{NdefFormatable.class.getName()}};
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            try {
                intentFilter.addDataType(IRequestConst.CONTENT_TYPE_TEXT_PLAIN);
            } catch (IntentFilter.MalformedMimeTypeException e2) {
                e2.printStackTrace();
            }
            IntentFilter intentFilter2 = new IntentFilter("android.nfc.action.TECH_DISCOVERED", "*/*");
            intentFilter2.addCategory("android.intent.category.DEFAULT");
            IntentFilter intentFilter3 = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
            intentFilter3.addCategory("android.intent.category.DEFAULT");
            j = new IntentFilter[]{intentFilter, intentFilter2, intentFilter3};
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125149782")) {
            ipChange.ipc$dispatch("-125149782", new Object[]{this});
            return;
        }
        try {
            NfcAdapter nfcAdapter = this.b;
            if (nfcAdapter != null) {
                nfcAdapter.disableForegroundDispatch(this.a);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992765793")) {
            ipChange.ipc$dispatch("992765793", new Object[]{this});
            return;
        }
        try {
            NfcAdapter nfcAdapter = this.b;
            if (nfcAdapter != null) {
                nfcAdapter.enableForegroundDispatch(this.a, this.c, j, i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void l(b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1515480293")) {
            ipChange.ipc$dispatch("-1515480293", new Object[]{this, bVar});
        } else if (bVar.a) {
            this.f.onReadSuccess(bVar.d);
        } else {
            this.f.onReadError(bVar.c, bVar.b);
        }
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321599892")) {
            return ((Boolean) ipChange.ipc$dispatch("-1321599892", new Object[]{this})).booleanValue();
        }
        NfcAdapter nfcAdapter = this.b;
        if (nfcAdapter == null) {
            return false;
        }
        return nfcAdapter.isEnabled();
    }

    public boolean f() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "693143548")) {
            return this.b != null;
        }
        return ((Boolean) ipChange.ipc$dispatch("693143548", new Object[]{this})).booleanValue();
    }

    public void g(Activity activity, ReadCallback readCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1655143162")) {
            ipChange.ipc$dispatch("-1655143162", new Object[]{this, activity, readCallback});
            return;
        }
        Log.i("nfc", "onCreate");
        this.a = activity;
        this.f = readCallback;
        this.b = NfcAdapter.getDefaultAdapter(activity);
        this.c = PendingIntent.getActivity(activity, 0, new Intent(activity, activity.getClass()), 0);
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998485327")) {
            ipChange.ipc$dispatch("-998485327", new Object[]{this});
        } else if (this.e == TriggerMode.ONCE) {
            this.d = false;
            a aVar = this.g;
            if (aVar != null) {
                aVar.cancel();
            }
        }
    }

    public void i(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829310388")) {
            ipChange.ipc$dispatch("-1829310388", new Object[]{this, intent});
            return;
        }
        Log.i("nfc", "onNewIntent");
        if (!TextUtils.equals(intent.getAction(), "android.nfc.action.TECH_DISCOVERED")) {
            Log.i("nfc", "not nfc ticket");
            b bVar = new b();
            bVar.a = false;
            bVar.c = 6;
            bVar.b = "not nfc intent";
            this.f.onReadError(6, "not nfc intent");
        } else if (this.e != TriggerMode.ONCE) {
            l(a.e(intent));
        } else if (this.d) {
            b e2 = a.e(intent);
            a aVar = this.g;
            if (aVar != null) {
                aVar.cancel();
            }
            this.d = false;
            l(e2);
        } else {
            Log.i("nfc", "once mode,not operate");
        }
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065492661")) {
            ipChange.ipc$dispatch("1065492661", new Object[]{this});
            return;
        }
        Log.i("nfc", MessageID.onPause);
        c();
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318320626")) {
            ipChange.ipc$dispatch("318320626", new Object[]{this});
            return;
        }
        Log.i("nfc", "onResume");
        d();
    }

    public void m(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-929612176")) {
            ipChange.ipc$dispatch("-929612176", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        this.h = i2;
    }

    public void n(TriggerMode triggerMode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1997997252")) {
            ipChange.ipc$dispatch("1997997252", new Object[]{this, triggerMode});
            return;
        }
        this.e = triggerMode;
    }

    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1114138285")) {
            ipChange.ipc$dispatch("-1114138285", new Object[]{this});
            return;
        }
        Log.i("nfc", "startOnceRead");
        if (this.e != TriggerMode.ONCE || this.d) {
            Log.i("nfc", "use startOnceRead,should set trigger mode ALWAYS");
            return;
        }
        this.d = true;
        a aVar = new a((long) this.h);
        this.g = aVar;
        aVar.start();
    }
}
