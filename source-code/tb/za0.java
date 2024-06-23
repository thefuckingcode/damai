package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.request.BaseMtopRequest;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.LinkedHashMap;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class za0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final za0 INSTANCE = new za0();

    static {
        new LinkedHashMap(10);
    }

    private za0() {
    }

    @Nullable
    public final <BizResponse> DoloresKernel<BizResponse> a(@NotNull DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1177830475")) {
            return (DoloresKernel) ipChange.ipc$dispatch("-1177830475", new Object[]{this, doloresRequest});
        }
        k21.i(doloresRequest, "request");
        if ((doloresRequest instanceof BaseMtopRequest) || (doloresRequest instanceof BaseRequest) || (doloresRequest instanceof IMTOPDataObject) || (doloresRequest instanceof MtopRequest)) {
            return new cb0();
        }
        if (doloresRequest instanceof aa) {
            return new ya0();
        }
        String str = "request : " + doloresRequest.getClass().getSimpleName() + " ,没有对应的请求kernel，需要新写！！！！";
        vp.c("DoloresKernelManager", str);
        bb0.h(doloresRequest.getClass().getSimpleName(), "1001", str, "");
        return null;
    }
}
