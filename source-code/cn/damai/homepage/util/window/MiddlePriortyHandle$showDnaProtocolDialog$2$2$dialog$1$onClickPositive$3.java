package cn.damai.homepage.util.window;

import android.content.DialogInterface;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.bean.SetPrivacyPermissionBean;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

/* compiled from: Taobao */
public final class MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1$onClickPositive$3 extends DMMtopRequestListener<SetPrivacyPermissionBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DialogInterface $dialog;
    final /* synthetic */ MainAlertEntity.MainAlertModel $entity;
    final /* synthetic */ MiddlePriortyHandle this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1$onClickPositive$3(MainAlertEntity.MainAlertModel mainAlertModel, MiddlePriortyHandle middlePriortyHandle, DialogInterface dialogInterface, Class<SetPrivacyPermissionBean> cls) {
        super(cls);
        this.$entity = mainAlertModel;
        this.this$0 = middlePriortyHandle;
        this.$dialog = dialogInterface;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741857290")) {
            ipChange.ipc$dispatch("-1741857290", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "errorCode");
        k21.i(str2, "errorMsg");
        this.$dialog.dismiss();
        ToastUtil.f("竟然失败了…请前往“设置-隐私设置”开启～");
    }

    public void onSuccess(@Nullable SetPrivacyPermissionBean setPrivacyPermissionBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-870508452")) {
            ipChange.ipc$dispatch("-870508452", new Object[]{this, setPrivacyPermissionBean});
            return;
        }
        if (this.$entity != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MonitorType.SKIP, true);
            bundle.putString("from_page", "homepage");
            DMNav.from(this.this$0.a).withExtras(bundle).toUri(this.$entity.schema);
        }
        this.$dialog.dismiss();
    }
}
