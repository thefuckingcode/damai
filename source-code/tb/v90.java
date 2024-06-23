package tb;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.address.ui.AddAddressActivity;
import cn.damai.ultron.secondpage.phonecode.bean.DmPhoneCodeBean;
import cn.damai.ultron.view.activity.DMUltronPayDetailBean;
import cn.damai.ultron.view.activity.DmOrderActivity;
import cn.damai.ultron.view.bean.DmDeliveryWayBean;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class v90 extends va {
    private static transient /* synthetic */ IpChange $ipChange;
    private int j = -1;

    private void m(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065653323")) {
            ipChange.ipc$dispatch("-2065653323", new Object[]{this, iDMComponent});
        } else if (iDMComponent != null) {
            boolean u = u(iDMComponent);
            try {
                c.e().x(ma0.u().x(this.b));
            } catch (Exception e) {
                e.printStackTrace();
            }
            IPresenter iPresenter = this.c;
            if (iPresenter != null && iPresenter.getContext() != null) {
                try {
                    ((DmOrderActivity) this.c.getContext()).updateTicketDetailVis(u);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535720669")) {
            ipChange.ipc$dispatch("-1535720669", new Object[]{this});
            return;
        }
        c.e().x(ma0.u().g(this.b));
        Bundle bundle = new Bundle();
        bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 1);
        DMNav.from(this.b).withExtras(bundle).forResult(37).toUri(NavUri.b("addaddress"));
    }

    private void o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "277935630")) {
            ipChange.ipc$dispatch("277935630", new Object[]{this, str});
            return;
        }
        c.e().x(ma0.u().D(this.b));
        Bundle bundle = new Bundle();
        bundle.putString("dm_bundle_address_id", str);
        DMNav.from(this.b).withExtras(bundle).forResult(37).toUri(NavUri.b(ja0.e));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    private void p(IDMComponent iDMComponent) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1106910142")) {
            ipChange.ipc$dispatch("1106910142", new Object[]{this, iDMComponent});
        } else if (iDMComponent != null) {
            String str2 = "";
            JSONObject fields = iDMComponent.getFields();
            if (fields != null) {
                if (fields.containsKey("addressId")) {
                    str2 = fields.getString("addressId");
                }
                if (fields.containsKey("addressStatus")) {
                    str = fields.getString("addressStatus");
                    if (!str.equals("0")) {
                        o(str2);
                        return;
                    } else if (str.equals("1")) {
                        n();
                        return;
                    } else {
                        o(str2);
                        return;
                    }
                }
            }
            str = "0";
            if (!str.equals("0")) {
            }
        }
    }

    private void q(IDMEvent iDMEvent, DMComponent dMComponent) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529837031")) {
            ipChange.ipc$dispatch("529837031", new Object[]{this, iDMEvent, dMComponent});
            return;
        }
        String string = (dMComponent == null || dMComponent.getFields() == null) ? "" : dMComponent.getFields().getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
        List list = null;
        if (iDMEvent != null) {
            JSONObject fields = iDMEvent.getFields();
            if (!(fields == null || (jSONObject = fields.getJSONObject("params")) == null || !jSONObject.containsKey("deliveryWayEntries"))) {
                list = JSON.parseArray(jSONObject.getString("deliveryWayEntries"), DmDeliveryWayBean.class);
            }
            if (xf2.e(list) > 0) {
                c.e().x(ma0.u().i(this.b));
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("param", (ArrayList) list);
                bundle.putString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, string);
                DMNav.from(this.b).withExtras(bundle).forResult(41).toUri(NavUri.b(ja0.b));
            }
        }
    }

    private void r(IDMEvent iDMEvent, IDMComponent iDMComponent) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840032996")) {
            ipChange.ipc$dispatch("-840032996", new Object[]{this, iDMEvent, iDMComponent});
        } else if (iDMEvent != null) {
            JSONObject fields = iDMEvent.getFields();
            String string = (fields == null || (jSONObject = fields.getJSONObject("params")) == null || !jSONObject.containsKey("ticketAddressEntries")) ? "" : jSONObject.getString("ticketAddressEntries");
            if (!TextUtils.isEmpty(string)) {
                c.e().x(ma0.u().A(this.b));
                Bundle bundle = new Bundle();
                bundle.putString("fields", string);
                DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(ja0.d));
            }
        }
    }

    private void s(IDMEvent iDMEvent, IDMComponent iDMComponent) {
        String str;
        String str2;
        JSONObject fields;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434420459")) {
            ipChange.ipc$dispatch("434420459", new Object[]{this, iDMEvent, iDMComponent});
            return;
        }
        if (iDMComponent == null || iDMComponent.getFields() == null) {
            str = "";
            str2 = str;
        } else {
            str2 = iDMComponent.getFields().getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            str = iDMComponent.getTag() + JSMethod.NOT_SET + iDMComponent.getId();
        }
        if (iDMEvent != null && (fields = iDMEvent.getFields()) != null) {
            JSONObject jSONObject = fields.getJSONObject("params");
            if (jSONObject != null && (jSONObject.containsKey("usablePromotionOptions") || jSONObject.containsKey("unusablePromotionOptions"))) {
                String string = jSONObject.getString("usablePromotionOptions");
                String string2 = jSONObject.getString("unusablePromotionOptions");
                if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                    c.e().x(ma0.u().B(this.b));
                    Bundle bundle = new Bundle();
                    bundle.putString("paramvalue", string);
                    bundle.putString("paramvalue_unuse", string2);
                    bundle.putString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, str2);
                    bundle.putString("tag_id", str);
                    IPresenter iPresenter = this.c;
                    if (iPresenter != null && iPresenter.getContext() != null) {
                        try {
                            ((DmOrderActivity) this.c.getContext()).showProFragment(bundle);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (jSONObject != null && jSONObject.containsKey("promotionOptions")) {
                String string3 = jSONObject.getString("promotionOptions");
                if (!TextUtils.isEmpty(string3) || !TextUtils.isEmpty("")) {
                    c.e().x(ma0.u().B(this.b));
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("paramvalue", string3);
                    bundle2.putString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, str2);
                    bundle2.putString("tag_id", str);
                    DMNav.from(this.b).withExtras(bundle2).forResult(49).toUri(NavUri.b(ja0.c));
                }
            }
        }
    }

    private void t(DMComponent dMComponent) {
        JSONObject fields;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664801615")) {
            ipChange.ipc$dispatch("664801615", new Object[]{this, dMComponent});
            return;
        }
        List list = null;
        if (dMComponent != null && (fields = dMComponent.getFields()) != null) {
            String string = fields.containsKey(WXTabbar.SELECT_INDEX) ? fields.getString(WXTabbar.SELECT_INDEX) : "0";
            if (fields.containsKey("list")) {
                list = JSON.parseArray(fields.getString("list"), DmPhoneCodeBean.class);
            }
            Bundle bundle = new Bundle();
            bundle.putString("selectCode", string);
            bundle.putParcelableArrayList("code", (ArrayList) list);
            DMNav.from(this.b).withExtras(bundle).forResult(48).toUri(NavUri.b(ja0.a));
        }
    }

    private boolean u(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1456584060")) {
            return ((Boolean) ipChange.ipc$dispatch("1456584060", new Object[]{this, iDMComponent})).booleanValue();
        }
        HashMap hashMap = new HashMap();
        JSONObject fields = iDMComponent.getFields();
        if (fields == null) {
            return false;
        }
        String string = fields.getString("payDetail");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        DMUltronPayDetailBean dMUltronPayDetailBean = (DMUltronPayDetailBean) JSON.parseObject(string, DMUltronPayDetailBean.class);
        String str = dMUltronPayDetailBean.status;
        if (str == null || str.equals("false")) {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(!z);
        sb.append("");
        dMUltronPayDetailBean.status = sb.toString();
        hashMap.put("payDetail", JSON.toJSON(dMUltronPayDetailBean));
        j(hashMap);
        this.c.getDataManager().respondToLinkage(iDMComponent);
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        DMComponent dMComponent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212886745")) {
            ipChange.ipc$dispatch("212886745", new Object[]{this, jn2});
            return;
        }
        String str = null;
        if (jn2 != null) {
            DMComponent dMComponent2 = (DMComponent) jn2.a();
            dMComponent = dMComponent2;
            str = dMComponent2.getTag();
        } else {
            dMComponent = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("dmDeliverySelectCard")) {
                this.j = 1;
            } else if (str.equals("dmContactPhone")) {
                this.j = 2;
            } else if (str.equals("dmDeliveryAddress")) {
                this.j = 3;
            } else if (str.equals("dmSubmit")) {
                this.j = 4;
            } else if (str.equals("dmPromotion") || str.equals("dmPromotionNew")) {
                this.j = 5;
            } else if (str.equals("dmDeliveryTicketAddress")) {
                this.j = 6;
            }
        }
        switch (this.j) {
            case 1:
                q(e(), dMComponent);
                return;
            case 2:
                t(dMComponent);
                return;
            case 3:
                p(dMComponent);
                return;
            case 4:
                m(jn2.a());
                return;
            case 5:
                s(e(), dMComponent);
                return;
            case 6:
                r(e(), dMComponent);
                return;
            default:
                return;
        }
    }
}
