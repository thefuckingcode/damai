package cn.damai.launcher.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fb0;

/* compiled from: Taobao */
public class DoloresGlobalInterceptor implements IRequestInterceptor {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> void onAfterProcessData(@NonNull DoloresKernel<T> doloresKernel, @Nullable fb0<T> fb0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1224240789")) {
            ipChange.ipc$dispatch("1224240789", new Object[]{this, doloresKernel, fb0});
        }
    }

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> boolean onPreProcessData(@NonNull DoloresKernel<T> doloresKernel, @Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-797545320")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-797545320", new Object[]{this, doloresKernel, obj})).booleanValue();
    }

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> boolean onPreRequest(@NonNull DoloresKernel<T> doloresKernel, @Nullable DoloresRequest<T> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1618296496")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1618296496", new Object[]{this, doloresKernel, doloresRequest})).booleanValue();
    }

    @Override // com.alibaba.pictures.dolores.business.IRequestInterceptor
    public <T> void onRequestConfig(@NonNull DoloresKernel<T> doloresKernel, @Nullable DoloresRequest<T> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736087671")) {
            ipChange.ipc$dispatch("736087671", new Object[]{this, doloresKernel, doloresRequest});
        }
    }
}
