package tb;

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
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class sm2 extends Handler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String NO_SHOW_TEXT = "noShowText";
    @NotNull
    public static final String SHOW_TEXT = "showText";
    @Nullable
    private final Toast a;
    @NotNull
    private final Queue<String> b = new ArrayBlockingQueue(3);
    private volatile boolean c;
    private int d = 3500;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public sm2(@Nullable Toast toast) {
        super(Looper.getMainLooper());
        this.a = toast;
    }

    public final void a(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-377399934")) {
            ipChange.ipc$dispatch("-377399934", new Object[]{this, str});
            return;
        }
        k21.i(str, "s");
        Log.e("DMToastUtil", "add_" + str);
        if ((this.b.isEmpty() || !this.b.contains(str)) && !this.b.offer(str)) {
            this.b.poll();
            this.b.offer(str);
        }
    }

    public final void b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1739557568")) {
            ipChange.ipc$dispatch("-1739557568", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d = i;
    }

    public final void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761888084")) {
            ipChange.ipc$dispatch("761888084", new Object[]{this});
        } else if (!this.c) {
            this.c = true;
            sendEmptyMessage(1);
        }
    }

    public void handleMessage(@NotNull Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "527582253")) {
            ipChange.ipc$dispatch("527582253", new Object[]{this, message});
            return;
        }
        k21.i(message, "msg");
        int i = message.what;
        if (i == 1) {
            String peek = this.b.peek();
            if (peek != null) {
                Object[] array = StringsKt__StringsKt.z0(peek, new String[]{JSMethod.NOT_SET}, false, 0, 6, null).toArray(new String[0]);
                k21.g(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                Toast toast = this.a;
                k21.f(toast);
                if (toast.getView() != null && (this.a.getView() instanceof TextView) && strArr.length > 2 && k21.d("showText", strArr[strArr.length - 1]) && !TextUtils.isEmpty(strArr[0])) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < strArr.length - 2; i2++) {
                        stringBuffer.append(strArr[i2]);
                    }
                    if (!TextUtils.isEmpty(stringBuffer.toString())) {
                        this.a.setText(stringBuffer.toString());
                    }
                }
                Log.e("DMToastUtil", "show_" + peek);
                this.a.show();
                sendEmptyMessageDelayed(2, (long) (this.d + 300));
                return;
            }
            this.c = false;
        } else if (i == 2) {
            this.b.poll();
            if (!this.b.isEmpty()) {
                sendEmptyMessage(1);
            } else {
                this.c = false;
            }
            Log.e("DMToastUtil", "TYPE_CONTINUE_");
        } else if (i == 3) {
            this.c = false;
            this.b.clear();
            Toast toast2 = this.a;
            k21.f(toast2);
            toast2.cancel();
        }
    }
}
