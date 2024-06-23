package tb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.ultron.view.activity.DmOrderActivity;
import cn.damai.ultron.view.bean.DmUltronPayResultBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;

/* compiled from: Taobao */
public class la0 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        a(la0 la0, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145354713")) {
                ipChange.ipc$dispatch("2145354713", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DmOrderActivity dmOrderActivity = this.a;
            if (dmOrderActivity != null) {
                dmOrderActivity.finish();
            }
        }
    }

    /* compiled from: Taobao */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        b(DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1180031560")) {
                ipChange.ipc$dispatch("-1180031560", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DMNav.from(la0.this.b).withExtras(new Bundle()).toUri(NavUri.b("my_showorder"));
            this.a.finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        JSONObject dataJsonObject;
        DmUltronPayResultBean dmUltronPayResultBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054421716")) {
            ipChange.ipc$dispatch("2054421716", new Object[]{this, jn2});
        } else if (jn2 != null) {
            try {
                MtopResponse mtopResponse = (MtopResponse) jn2.c();
                if (mtopResponse != null && (dataJsonObject = mtopResponse.getDataJsonObject()) != null && (dmUltronPayResultBean = (DmUltronPayResultBean) JSON.parseObject(dataJsonObject.toString(), DmUltronPayResultBean.class)) != null) {
                    DmOrderActivity dmOrderActivity = null;
                    Context context = this.b;
                    if (context instanceof Activity) {
                        dmOrderActivity = (DmOrderActivity) context;
                    }
                    if (dmOrderActivity != null) {
                        if (dmUltronPayResultBean.getPartSuccess()) {
                            DmOrderActivity dmOrderActivity2 = (DmOrderActivity) this.b;
                            DMDialog dMDialog = new DMDialog(this.b);
                            dMDialog.v("部分宝贝购买成功");
                            dMDialog.q("请尽快付款来抢下，未成功宝贝已放回购物车。");
                            dMDialog.n("确定", new b(dmOrderActivity2)).i("取消", new a(this, dmOrderActivity2));
                            return;
                        }
                        na0.c(dmOrderActivity, dmUltronPayResultBean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
