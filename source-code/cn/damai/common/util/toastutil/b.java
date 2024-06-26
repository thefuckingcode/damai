package cn.damai.common.util.toastutil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: Taobao */
public final class b extends Handler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String NO_SHOW_TEXT = "noShowText";
    public static final String SHOW_TEXT = "showText";
    private volatile Queue<String> a;
    private volatile boolean b;
    private int c = 3500;
    private final Toast d;

    b(Toast toast) {
        super(Looper.getMainLooper());
        this.d = toast;
        this.a = new ArrayBlockingQueue(3);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174743543")) {
            ipChange.ipc$dispatch("-174743543", new Object[]{this, str});
            return;
        }
        Log.e("DMToastUtil", "add_" + str);
        if ((this.a.isEmpty() || !this.a.contains(str)) && !this.a.offer(str)) {
            this.a.poll();
            this.a.offer(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508894425")) {
            ipChange.ipc$dispatch("1508894425", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.c = i;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2116249619")) {
            ipChange.ipc$dispatch("-2116249619", new Object[]{this});
        } else if (!this.b) {
            this.b = true;
            sendEmptyMessage(1);
        }
    }

    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1417673780")) {
            ipChange.ipc$dispatch("1417673780", new Object[]{this, message});
            return;
        }
        int i = message.what;
        if (i == 1) {
            String peek = this.a.peek();
            if (peek != null) {
                String[] split = peek.split(JSMethod.NOT_SET);
                if (this.d.getView() != null && (this.d.getView() instanceof TextView) && split.length > 2 && "showText".equals(split[split.length - 1]) && !TextUtils.isEmpty(split[0])) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < split.length - 2; i2++) {
                        stringBuffer.append(split[i2]);
                    }
                    if (!TextUtils.isEmpty(stringBuffer.toString())) {
                        this.d.setText(stringBuffer.toString());
                    }
                }
                Log.e("DMToastUtil", "show_" + peek);
                this.d.show();
                sendEmptyMessageDelayed(2, (long) (this.c + 300));
                return;
            }
            this.b = false;
        } else if (i == 2) {
            this.a.poll();
            if (!this.a.isEmpty()) {
                sendEmptyMessage(1);
            } else {
                this.b = false;
            }
            Log.e("DMToastUtil", "TYPE_CONTINUE_");
        } else if (i == 3) {
            this.b = false;
            this.a.clear();
            this.d.cancel();
        }
    }
}
