package tb;

import androidx.annotation.NonNull;
import cn.damai.common.askpermission.IPermissionAction;
import cn.damai.common.askpermission.IPermissionRequest;
import cn.damai.common.askpermission.IRationale;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;

/* compiled from: Taobao */
public class m61 implements IPermissionRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    private final j02 a;
    private IPermissionAction b;
    private String[] c;

    public m61(j02 j02) {
        this.a = j02;
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest onDenied(IPermissionAction iPermissionAction) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-410139031")) {
            return this;
        }
        return (IPermissionRequest) ipChange.ipc$dispatch("-410139031", new Object[]{this, iPermissionAction});
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest onGranted(IPermissionAction iPermissionAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102042143")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("-1102042143", new Object[]{this, iPermissionAction});
        }
        this.b = iPermissionAction;
        return this;
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907558465")) {
            ipChange.ipc$dispatch("907558465", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        }
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest permission(@NonNull String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296326456")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("296326456", new Object[]{this, strArr});
        }
        this.c = strArr;
        return this;
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest showRationale(IRationale iRationale) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1510889851")) {
            return this;
        }
        return (IPermissionRequest) ipChange.ipc$dispatch("-1510889851", new Object[]{this, iRationale});
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035764832")) {
            ipChange.ipc$dispatch("-1035764832", new Object[]{this});
            return;
        }
        IPermissionAction iPermissionAction = this.b;
        if (iPermissionAction != null) {
            iPermissionAction.onCall(this.a, Arrays.asList(this.c));
        }
    }
}
