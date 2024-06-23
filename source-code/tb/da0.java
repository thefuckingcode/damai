package tb;

import android.content.Intent;
import android.text.TextUtils;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.util.SystemContactsUtil;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import mtopsdk.common.util.StringUtils;

/* compiled from: Taobao */
public class da0 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    private String m(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203244094")) {
            return (String) ipChange.ipc$dispatch("-203244094", new Object[]{this, addressBean});
        }
        StringBuilder sb = new StringBuilder();
        String str = "";
        String county = (StringUtils.isEmpty(addressBean.getCounty()) || addressBean.getCity().equals(addressBean.getCounty())) ? str : addressBean.getCounty();
        if (!StringUtils.isEmpty(addressBean.getStreet()) && !"暂不选择".equals(addressBean.getStreet())) {
            str = addressBean.getStreet();
        }
        sb.append(addressBean.getProvince());
        sb.append(addressBean.getCity());
        sb.append(county);
        sb.append(str);
        sb.append(addressBean.getAddressDetail());
        return sb.toString();
    }

    private void n(Intent intent) {
        IDMComponent d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1714043770")) {
            ipChange.ipc$dispatch("1714043770", new Object[]{this, intent});
            return;
        }
        String c = SystemContactsUtil.c(this.b, intent.getData());
        IPresenter iPresenter = this.c;
        if (iPresenter != null && (d = ha0.d(iPresenter)) != null && !TextUtils.isEmpty(c)) {
            HashMap hashMap = new HashMap();
            hashMap.put("value", c);
            i(d, hashMap);
            BaseDataManager dataManager = this.c.getDataManager();
            if (dataManager != null) {
                dataManager.respondToLinkage(d);
            }
        }
    }

    private void o(Intent intent) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996851882")) {
            ipChange.ipc$dispatch("996851882", new Object[]{this, intent});
            return;
        }
        IDMComponent b = ha0.b(this.c);
        r(intent, b);
        IPresenter iPresenter = this.c;
        if (iPresenter != null && (dataManager = iPresenter.getDataManager()) != null) {
            dataManager.respondToLinkage(b);
        }
    }

    private void p(Intent intent) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1909999985")) {
            ipChange.ipc$dispatch("1909999985", new Object[]{this, intent});
            return;
        }
        IDMComponent d = ha0.d(this.c);
        s(intent, d);
        IPresenter iPresenter = this.c;
        if (iPresenter != null && (dataManager = iPresenter.getDataManager()) != null) {
            dataManager.respondToLinkage(d);
        }
    }

    private void q(Intent intent) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545165209")) {
            ipChange.ipc$dispatch("1545165209", new Object[]{this, intent});
        } else if (intent != null) {
            IDMComponent l = ha0.l(this.c, intent.getStringExtra("tag_id"));
            t(intent, l);
            IPresenter iPresenter = this.c;
            if (iPresenter != null && (dataManager = iPresenter.getDataManager()) != null) {
                dataManager.respondToLinkage(l);
            }
        }
    }

    private void r(Intent intent, IDMComponent iDMComponent) {
        AddressBean addressBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24258072")) {
            ipChange.ipc$dispatch("-24258072", new Object[]{this, intent, iDMComponent});
            return;
        }
        HashMap hashMap = new HashMap();
        if (!(intent == null || (addressBean = (AddressBean) intent.getParcelableExtra("added_address")) == null)) {
            hashMap.put("addressId", addressBean.getAddressId());
            hashMap.put("phone", addressBean.getMobile());
            hashMap.put("consignee", addressBean.getConsigneeName());
            hashMap.put(ILocatable.ADDRESS, m(addressBean));
        }
        if (hashMap.size() > 0) {
            i(iDMComponent, hashMap);
        }
    }

    private void s(Intent intent, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1286742465")) {
            ipChange.ipc$dispatch("1286742465", new Object[]{this, intent, iDMComponent});
            return;
        }
        HashMap hashMap = new HashMap();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WXTabbar.SELECT_INDEX);
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put(WXTabbar.SELECT_INDEX, stringExtra);
            }
        }
        if (hashMap.size() > 0) {
            i(iDMComponent, hashMap);
        }
    }

    private void t(Intent intent, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-306729831")) {
            ipChange.ipc$dispatch("-306729831", new Object[]{this, intent, iDMComponent});
            return;
        }
        HashMap hashMap = new HashMap();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("selectId");
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put("selectId", stringExtra2);
            }
            String stringExtra3 = intent.getStringExtra(SocialConstants.PARAM_APP_DESC);
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put(SocialConstants.PARAM_APP_DESC, stringExtra3);
            }
        }
        if (hashMap.size() > 0) {
            i(iDMComponent, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410016525")) {
            ipChange.ipc$dispatch("410016525", new Object[]{this, jn2});
        } else if (jn2 != null) {
            try {
                String str = (String) jn2.e("pageType");
                if (!TextUtils.isEmpty(str)) {
                    Intent intent = (Intent) jn2.e("data");
                    if (str.equals(ia0.PAGE_PHONE_CODE)) {
                        p(intent);
                    } else if (str.equals(ia0.PAGE_ADDRESS_LIST)) {
                        o(intent);
                    } else if (str.equals(ia0.PAGE_PROMOTION_LIST)) {
                        q(intent);
                    } else if (str.equals(ia0.PAGE_READ_PHONE)) {
                        n(intent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
