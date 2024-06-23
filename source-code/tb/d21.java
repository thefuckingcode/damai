package tb;

import android.app.Activity;
import cn.damai.homepage.util.window.PopupCallback;
import com.alibaba.yymidservice.popup.request.bean.PopupDetailBean;
import com.alibaba.yymidservice.popup.request.bean.PopupResponseBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jr1;

/* compiled from: Taobao */
public final class d21 extends pr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private PopupCallback a;

    public d21(@NotNull Activity activity) {
        k21.i(activity, WPKFactory.INIT_KEY_CONTEXT);
    }

    public final void a(@Nullable PopupCallback popupCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-162813735")) {
            ipChange.ipc$dispatch("-162813735", new Object[]{this, popupCallback});
            return;
        }
        this.a = popupCallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        if (r0 == null) goto L_0x0090;
     */
    @Override // com.alibaba.yymidservice.popup.popupcenter.view.PopupViewHandleCallback
    @Nullable
    public <T, K> Object popHandle(@Nullable T t, @Nullable K k, @NotNull Continuation<? super jr1> continuation) {
        ArrayList<PopupDetailBean> arrayList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948049813")) {
            return ipChange.ipc$dispatch("-1948049813", new Object[]{this, t, k, continuation});
        }
        ur2 ur2 = null;
        K k2 = k instanceof jr1 ? k : null;
        if (k2 == null || !k21.d(k2, jr1.b.INSTANCE)) {
            T t2 = t instanceof PopupResponseBean ? t : null;
            if (!(t2 == null || (arrayList = t2.show) == null)) {
                if (arrayList.size() > 0) {
                    if (!k21.d(arrayList.get(0).sceneType + '_' + arrayList.get(0).eventType, nr1.WANT_SEE_UPDATE)) {
                        PopupCallback popupCallback = this.a;
                        if (popupCallback != null) {
                            popupCallback.loadFloat();
                        }
                    }
                    ur2 = ur2.INSTANCE;
                } else {
                    PopupCallback popupCallback2 = this.a;
                    if (popupCallback2 != null) {
                        popupCallback2.loadFloat();
                        ur2 = ur2.INSTANCE;
                    }
                }
            }
            PopupCallback popupCallback3 = this.a;
            if (popupCallback3 != null) {
                popupCallback3.loadFloat();
                ur2 ur22 = ur2.INSTANCE;
            }
            return jr1.c.INSTANCE;
        }
        PopupCallback popupCallback4 = this.a;
        if (popupCallback4 != null) {
            popupCallback4.loadFloat();
        }
        return jr1.c.INSTANCE;
    }
}
