package tb;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.commonbusiness.util.SystemContactsUtil;
import cn.damai.login.LoginManager;
import cn.damai.login.YouKuTrustListener;
import cn.damai.ultron.utils.DmUltronConstants;
import com.alibaba.android.ultron.trade.event.model.OpenUrlEventModel;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import java.util.ArrayList;

/* compiled from: Taobao */
public class fr extends va {
    private static transient /* synthetic */ IpChange $ipChange;
    private int j;
    private boolean k = false;

    /* compiled from: Taobao */
    public class a implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        a(fr frVar, Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-917982149")) {
                ipChange.ipc$dispatch("-917982149", new Object[]{this});
                return;
            }
            SystemContactsUtil.g(this.a, 39);
        }
    }

    /* compiled from: Taobao */
    public class b implements YouKuTrustListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IDMComponent a;

        b(IDMComponent iDMComponent) {
            this.a = iDMComponent;
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void showLoading(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-799666595")) {
                ipChange.ipc$dispatch("-799666595", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            br.c(DmUltronConstants.SHOW_LOADING_STATE, Boolean.valueOf(z));
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void trustYouKuFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2021918951")) {
                ipChange.ipc$dispatch("-2021918951", new Object[]{this, str, str2});
            } else if (TextUtils.isEmpty(str) || !str.equals("1403")) {
                ToastUtil.f(str2);
                oa0.f().l(fr.this.c.getContext(), str, str2);
            }
        }

        @Override // cn.damai.login.YouKuTrustListener
        public void trustYouKuSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-381349660")) {
                ipChange.ipc$dispatch("-381349660", new Object[]{this});
                return;
            }
            br.c(DmUltronConstants.TRUST_YOUKU_LOGIN, this.a);
        }
    }

    private void n(boolean z, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-969243133")) {
            ipChange.ipc$dispatch("-969243133", new Object[]{this, Boolean.valueOf(z), iDMComponent});
            return;
        }
        c.e().x(ma0.u().t(this.c.getContext()));
        if (z) {
            LoginManager.k().i(this.c.getContext(), 0, new b(iDMComponent));
            return;
        }
        ToastUtil.f("账号已绑定，可在我的-设置-账号安全中进行换绑");
    }

    private void o(IDMComponent iDMComponent) {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1386462966")) {
            ipChange.ipc$dispatch("-1386462966", new Object[]{this, iDMComponent});
            return;
        }
        String str = "";
        if (iDMComponent != null && (iDMComponent instanceof DMComponent)) {
            DMComponent dMComponent = (DMComponent) iDMComponent;
            if (dMComponent.getFields() != null) {
                str = dMComponent.getFields().getString("filterRule");
            }
            dMComponent.getTag();
            dMComponent.getId();
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                IdCardTypes b2 = na0.b(Integer.parseInt(str2));
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contacts", arrayList);
        bundle.putString("bundleName", "dmultron");
        DMNav.from(this.b).withExtras(bundle).forResult(36).toUri(NavUri.b("add_contact"));
    }

    private void p(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113869466")) {
            ipChange.ipc$dispatch("2113869466", new Object[]{this, str});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        DMNav.from(this.b).withExtras(bundle).toUri("damai://webview");
    }

    private void r(jn2 jn2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839329016")) {
            ipChange.ipc$dispatch("-839329016", new Object[]{this, jn2, str});
            return;
        }
        IDMEvent e = e();
        if (e != null && e.getFields() != null) {
            OpenUrlEventModel openUrlEventModel = null;
            try {
                openUrlEventModel = (OpenUrlEventModel) JSON.parseObject(e.getFields().toJSONString(), OpenUrlEventModel.class);
            } catch (Exception unused) {
            }
            if (openUrlEventModel != null) {
                if (TextUtils.isEmpty(str)) {
                    str = openUrlEventModel.getUrl();
                }
                String pageType = openUrlEventModel.getPageType();
                if (TextUtils.isEmpty(pageType)) {
                    q(str, openUrlEventModel.getParams());
                } else if (pageType.equalsIgnoreCase(gl1.TYPE_OPEN_URL_NATIVE)) {
                    q(str, openUrlEventModel.getParams());
                } else if (pageType.equalsIgnoreCase("h5")) {
                    p(str);
                }
                this.c.getTradeEventHandler().n(jn2);
            }
        }
    }

    @Override // tb.va
    public void h(jn2 jn2) {
        String str;
        Activity context;
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-789084442")) {
            ipChange.ipc$dispatch("-789084442", new Object[]{this, jn2});
        } else if (jn2 != null && !this.k) {
            this.k = true;
            this.j = 0;
            IDMComponent a2 = jn2.a();
            if (a2 != null) {
                str = a2.getTag();
            } else {
                str = "";
            }
            if (str != null) {
                if (str.equalsIgnoreCase(ha0.VIEWER_TITLE)) {
                    this.j = 1;
                } else if (str.equalsIgnoreCase("dmItemInfo")) {
                    this.j = 2;
                } else if (str.equalsIgnoreCase("dmDeliveryMachineAddress")) {
                    this.j = 3;
                } else if (str.equalsIgnoreCase("dmContactTitle")) {
                    this.j = 4;
                } else if (str.equalsIgnoreCase("dmLiveAccount")) {
                    this.j = 5;
                }
            }
            this.k = false;
            int i = this.j;
            if (i == 0) {
                r(jn2, "");
            } else if (i == 1) {
                c.e().x(ma0.u().l(this.b));
                o(a2);
            } else if (i == 2) {
                c.e().x(ma0.u().F(this.b));
                r(jn2, "purchase_notice");
            } else if (i == 3) {
                c.e().x(ma0.u().v(this.b));
                r(jn2, "purchase_self_address");
            } else if (i == 4) {
                IPresenter iPresenter = this.c;
                if (iPresenter != null && (context = iPresenter.getContext()) != null) {
                    hp1.a(context, false, "android.permission.READ_CONTACTS", "才能快速填写手机号～", new a(this, context));
                }
            } else if (i == 5) {
                JSONObject fields = a2.getFields();
                if (fields != null && fields.containsKey("liveAccountInfoList") && (jSONArray = fields.getJSONArray("liveAccountInfoList")) != null && jSONArray.size() > 0) {
                    z = false;
                }
                n(z, a2);
            }
        }
    }

    public void q(String str, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925690720")) {
            ipChange.ipc$dispatch("925690720", new Object[]{this, str, jSONObject});
            return;
        }
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            for (String str2 : jSONObject.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = jSONObject.get(str2);
                    if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Integer) obj).intValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Double) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        bundle.putString(str2, (String) obj);
                    }
                }
            }
        }
        if (str.contains("damai://") || str.contains("http")) {
            DMNav.from(this.b).withExtras(bundle).toUri(str);
        } else {
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(str));
        }
    }
}
