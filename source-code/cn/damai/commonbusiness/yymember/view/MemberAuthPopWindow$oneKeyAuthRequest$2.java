package cn.damai.commonbusiness.yymember.view;

import android.app.Activity;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.yymember.bean.AuthOnekeybindInfo;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class MemberAuthPopWindow$oneKeyAuthRequest$2 extends DMMtopRequestListener<AuthOnekeybindInfo> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ MemberAuthPopWindow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberAuthPopWindow$oneKeyAuthRequest$2(MemberAuthPopWindow memberAuthPopWindow, Class<AuthOnekeybindInfo> cls) {
        super(cls);
        this.this$0 = memberAuthPopWindow;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2007178003")) {
            ipChange.ipc$dispatch("-2007178003", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "s");
        k21.i(str2, "s1");
        Activity activity = this.this$0.activity;
        DamaiBaseActivity damaiBaseActivity = null;
        if (activity == null) {
            k21.A("activity");
            activity = null;
        }
        if (activity instanceof DamaiBaseActivity) {
            damaiBaseActivity = (DamaiBaseActivity) activity;
        }
        if (damaiBaseActivity != null) {
            damaiBaseActivity.stopProgressDialog();
        }
        ToastUtil.f(str2);
    }

    public void onSuccess(@Nullable AuthOnekeybindInfo authOnekeybindInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884819232")) {
            ipChange.ipc$dispatch("884819232", new Object[]{this, authOnekeybindInfo});
            return;
        }
        Activity activity = this.this$0.activity;
        DamaiBaseActivity damaiBaseActivity = null;
        if (activity == null) {
            k21.A("activity");
            activity = null;
        }
        if (activity instanceof DamaiBaseActivity) {
            damaiBaseActivity = (DamaiBaseActivity) activity;
        }
        if (damaiBaseActivity != null) {
            damaiBaseActivity.stopProgressDialog();
        }
        if (authOnekeybindInfo == null) {
            ToastUtil.f("麦麦开小差了，请稍后重试哦");
        } else if (k21.d("0", authOnekeybindInfo.returnCode)) {
            this.this$0.dismiss();
            MemberAuthPopWindow.ICustomDialogEventListener iCustomDialogEventListener = this.this$0.eventListener;
            if (iCustomDialogEventListener != null) {
                iCustomDialogEventListener.dialogItemEvent("success");
            }
            ToastUtil.f("授权成功");
        } else {
            String str = authOnekeybindInfo.returnMessage;
            if (str != null) {
                ToastUtil.f(str);
            }
        }
    }
}
