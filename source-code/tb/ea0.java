package tb;

import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class ea0 extends va {
    private static transient /* synthetic */ IpChange $ipChange;

    private void m(Intent intent, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355647232")) {
            ipChange.ipc$dispatch("-1355647232", new Object[]{this, intent, iDMComponent});
            return;
        }
        HashMap hashMap = new HashMap();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, stringExtra);
            }
            String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_APP_DESC);
            if (!TextUtils.isEmpty(stringExtra2)) {
                hashMap.put(SocialConstants.PARAM_APP_DESC, stringExtra2);
            }
        }
        if (hashMap.size() > 0) {
            i(iDMComponent, hashMap);
        }
    }

    private void n(Intent intent, IDMComponent iDMComponent) {
        Map<String, List<IDMEvent>> eventMap;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1301970147")) {
            ipChange.ipc$dispatch("-1301970147", new Object[]{this, intent, iDMComponent});
            return;
        }
        IDMEvent iDMEvent = null;
        if (iDMComponent != null && (eventMap = iDMComponent.getEventMap()) != null && eventMap.containsKey("chooseDeliveryWays")) {
            List<IDMEvent> list = eventMap.get("chooseDeliveryWays");
            while (true) {
                if (i >= xf2.e(list)) {
                    break;
                } else if (list.get(i).getType().equals("openPopupWindow")) {
                    iDMEvent = list.get(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        HashMap hashMap = new HashMap();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("eventparams");
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put("params", JSON.parseObject(stringExtra));
            }
        }
        if (hashMap.size() > 0) {
            k(iDMEvent, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    @Override // tb.va
    public void h(jn2 jn2) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520915203")) {
            ipChange.ipc$dispatch("1520915203", new Object[]{this, jn2});
        } else if (jn2 != null) {
            try {
                Intent intent = (Intent) jn2.e("data");
                IDMComponent c = ha0.c(this.c);
                jn2.o(new f50(this.e, this.c));
                m(intent, c);
                n(intent, c);
                IPresenter iPresenter = this.c;
                if (iPresenter != null && (dataManager = iPresenter.getDataManager()) != null) {
                    dataManager.respondToLinkage(c, jn2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
