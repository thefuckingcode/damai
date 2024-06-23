package cn.damai.homepage.util.window;

import android.content.DialogInterface;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.R$string;
import cn.damai.homepage.bean.SetPrivacyPermissionBean;
import cn.damai.homepage.request.SetupPermissionListRequest;
import cn.damai.uikit.view.DMProtocolDialog;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tb.a03;
import tb.ax0;
import tb.k21;
import tb.sq2;

/* compiled from: Taobao */
public final class MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1 implements DMProtocolDialog.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Map<String, JSONObject> a;
    final /* synthetic */ MiddlePriortyHandle b;
    final /* synthetic */ sq2 c;
    final /* synthetic */ MainAlertEntity.MainAlertModel d;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<java.lang.String, ? extends com.alibaba.fastjson.JSONObject> */
    /* JADX WARN: Multi-variable type inference failed */
    MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1(Map<String, ? extends JSONObject> map, MiddlePriortyHandle middlePriortyHandle, sq2 sq2, MainAlertEntity.MainAlertModel mainAlertModel) {
        this.a = map;
        this.b = middlePriortyHandle;
        this.c = sq2;
        this.d = mainAlertModel;
    }

    @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
    public void onClickNegative() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "396669082")) {
            ipChange.ipc$dispatch("396669082", new Object[]{this});
            return;
        }
        Map<String, JSONObject> map = this.a;
        if (map != null) {
            this.c.closeUt(a03.f(), map);
            return;
        }
        c.e().x(ax0.I().z(String.valueOf(this.d.circleId), "1", 1, null));
    }

    @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
    public void onClickPositive(@NotNull DialogInterface dialogInterface, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1410543620")) {
            ipChange.ipc$dispatch("1410543620", new Object[]{this, dialogInterface, Boolean.valueOf(z)});
            return;
        }
        k21.i(dialogInterface, "dialog");
        if (z) {
            Map<String, JSONObject> map = this.a;
            if (map != null) {
                this.c.confirmUt(a03.f(), map);
            } else {
                c.e().x(ax0.I().z(String.valueOf(this.d.circleId), "1", 0, null));
            }
            SetupPermissionListRequest setupPermissionListRequest = new SetupPermissionListRequest();
            HashMap hashMap = new HashMap();
            hashMap.put("2", "1");
            setupPermissionListRequest.setupPermissionMap = hashMap;
            setupPermissionListRequest.request(new MiddlePriortyHandle$showDnaProtocolDialog$2$2$dialog$1$onClickPositive$3(this.d, this.b, dialogInterface, SetPrivacyPermissionBean.class));
            return;
        }
        ToastUtil.i(this.b.a.getString(R$string.homepage_dna_dialog_tip));
    }

    @Override // cn.damai.uikit.view.DMProtocolDialog.OnClickListener
    public void onProtocolClick(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "819508689")) {
            ipChange.ipc$dispatch("819508689", new Object[]{this, str});
            return;
        }
        k21.i(str, "linkUrl");
        DMNav.from(this.b.a).toUri(str);
    }
}
