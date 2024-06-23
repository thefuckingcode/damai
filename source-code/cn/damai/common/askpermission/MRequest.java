package cn.damai.common.askpermission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import tb.gp1;
import tb.hp1;
import tb.j02;
import tb.ud2;

/* compiled from: Taobao */
public class MRequest implements IPermissionRequest, IRequestExecutor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final IPermissionChecker a = new ud2();
    private final j02 b;
    private List<String> c;
    private IPermissionAction d;
    private IPermissionAction e;
    private IRationale f;
    private boolean g = true;
    private final IPermissionCallBack h = new IPermissionCallBack() {
        /* class cn.damai.common.askpermission.MRequest.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.common.askpermission.IPermissionCallBack
        public void onPermissionFinish(@NonNull String[] strArr, @NonNull int[] iArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2131485306")) {
                ipChange.ipc$dispatch("2131485306", new Object[]{this, strArr, iArr});
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class cn.damai.common.askpermission.MRequest.AnonymousClass1.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "133689470")) {
                        ipChange.ipc$dispatch("133689470", new Object[]{this});
                        return;
                    }
                    MRequest.this.d();
                }
            }, 100);
        }
    };

    public MRequest(j02 j02) {
        this.b = j02;
    }

    private void b(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-739379114")) {
            ipChange.ipc$dispatch("-739379114", new Object[]{this, list});
            return;
        }
        IPermissionAction iPermissionAction = this.e;
        if (iPermissionAction != null) {
            iPermissionAction.onCall(this.b, list);
        }
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291874587")) {
            ipChange.ipc$dispatch("-1291874587", new Object[]{this});
            return;
        }
        try {
            IPermissionAction iPermissionAction = this.d;
            if (iPermissionAction != null) {
                iPermissionAction.onCall(this.b, this.c);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            b(this.c);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843994558")) {
            ipChange.ipc$dispatch("-843994558", new Object[]{this});
        } else if (this.b.c()) {
            List<String> f2 = f(this.b.b(), this.a, this.c);
            if (f2 == null || f2.size() == 0) {
                c();
            } else if (!e()) {
                b(f2);
            }
        }
    }

    private boolean e() {
        IRationale iRationale;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1771607643")) {
            return ((Boolean) ipChange.ipc$dispatch("1771607643", new Object[]{this})).booleanValue();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.c) {
            if (!hp1.g(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("titlelabel", str);
                hashMap.put("status", hp1.g(str) ? "1" : "0");
                if (!this.b.d(str)) {
                    arrayList.add(str);
                    hashMap.put("type", "1");
                } else {
                    hashMap.put("type", "0");
                }
                if (!hp1.g(str)) {
                    c.e().A(hashMap, gp1.b, gp1.a);
                }
            }
        }
        if (arrayList.size() > 0 && (iRationale = this.f) != null) {
            iRationale.showRationale(arrayList, this, this.b);
        }
        if (arrayList.size() > 0) {
            return true;
        }
        return false;
    }

    private static List<String> f(Context context, IPermissionChecker iPermissionChecker, List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1214667889")) {
            return (List) ipChange.ipc$dispatch("-1214667889", new Object[]{context, iPermissionChecker, list});
        } else if (iPermissionChecker == null || list == null || list.size() <= 0) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!iPermissionChecker.hasPermission(context, str)) {
                    arrayList.add(str);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", str);
                    hashMap.put("status", "1");
                    hashMap.put("type", "0");
                    c.e().A(hashMap, gp1.b, gp1.a);
                }
            }
            return arrayList;
        }
    }

    @Override // cn.damai.common.askpermission.IRequestExecutor
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154426093")) {
            ipChange.ipc$dispatch("154426093", new Object[]{this});
        }
    }

    @Override // cn.damai.common.askpermission.IRequestExecutor
    public void execute() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855686674")) {
            ipChange.ipc$dispatch("-855686674", new Object[]{this});
        } else if (this.b.c()) {
            String[] strArr = new String[this.c.size()];
            this.c.toArray(strArr);
            Activity b2 = this.b.b();
            if (this.g) {
                PermissionDelegateActivity.requestPermission(b2, strArr, this.h);
            } else if (Build.VERSION.SDK_INT >= 23 && b2 != null) {
                b2.requestPermissions(strArr, 1334);
            }
        }
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest onDenied(IPermissionAction iPermissionAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1191027016")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("1191027016", new Object[]{this, iPermissionAction});
        }
        this.e = iPermissionAction;
        return this;
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest onGranted(IPermissionAction iPermissionAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1289465058")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("1289465058", new Object[]{this, iPermissionAction});
        }
        this.d = iPermissionAction;
        return this;
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900289056")) {
            ipChange.ipc$dispatch("-900289056", new Object[]{this, Integer.valueOf(i), strArr, iArr});
        } else if (i == 1334) {
            d();
        }
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest permission(@NonNull String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "282076311")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("282076311", new Object[]{this, strArr});
        } else if (strArr == null || strArr.length == 0) {
            throw new RuntimeException("申请的权限数组为空");
        } else {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.clear();
            this.c.addAll(Arrays.asList(strArr));
            return this;
        }
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public IPermissionRequest showRationale(IRationale iRationale) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284644060")) {
            return (IPermissionRequest) ipChange.ipc$dispatch("-284644060", new Object[]{this, iRationale});
        }
        this.f = iRationale;
        return this;
    }

    @Override // cn.damai.common.askpermission.IPermissionRequest
    public void start() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880236703")) {
            ipChange.ipc$dispatch("-1880236703", new Object[]{this});
            return;
        }
        Activity b2 = this.b.b();
        if (b2 != null) {
            if (this.a.hasPermission(b2, this.c)) {
                c();
            } else {
                execute();
            }
        }
    }
}
