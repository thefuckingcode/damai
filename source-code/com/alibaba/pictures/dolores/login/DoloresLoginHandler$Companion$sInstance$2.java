package com.alibaba.pictures.dolores.login;

import android.os.Looper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/alibaba/pictures/dolores/login/DoloresLoginHandler;", "invoke", "()Lcom/alibaba/pictures/dolores/login/DoloresLoginHandler;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class DoloresLoginHandler$Companion$sInstance$2 extends Lambda implements Function0<DoloresLoginHandler> {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final DoloresLoginHandler$Companion$sInstance$2 INSTANCE = new DoloresLoginHandler$Companion$sInstance$2();

    DoloresLoginHandler$Companion$sInstance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final DoloresLoginHandler invoke() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603310016")) {
            return (DoloresLoginHandler) ipChange.ipc$dispatch("603310016", new Object[]{this});
        }
        Looper mainLooper = Looper.getMainLooper();
        k21.h(mainLooper, "Looper.getMainLooper()");
        return new DoloresLoginHandler(mainLooper, null);
    }
}
