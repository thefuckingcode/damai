package tb;

import android.content.Context;
import com.alient.resource.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class jh0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final jh0 INSTANCE = new jh0();

    private jh0() {
    }

    public final int a(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292195374")) {
            return ((Integer) ipChange.ipc$dispatch("1292195374", new Object[]{this, context})).intValue();
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (g12.e(context) - DisplayUtil.dip2px(context, 25.0f)) / bd2.INSTANCE.d(context, 2);
    }
}
