package tb;

import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.a;
import com.alibaba.poplayer.trigger.page.PageConfigItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class sn1 extends a<PageConfigItem> {
    public static final String KEY_CONFIG_PAGE = "poplayer_config";

    public sn1(IConfigAdapter iConfigAdapter) {
        super(iConfigAdapter, KEY_CONFIG_PAGE, a.KEY_BLACK_LIST);
        cr1.a("PageConfigMgr use " + PageConfigItem.LOG);
    }

    @Override // com.alibaba.poplayer.trigger.a
    public tu2<PageConfigItem> h(Event event) {
        ArrayList arrayList = new ArrayList();
        for (ConfigItemType configitemtype : this.b) {
            cr1.b("PageConfigMgr.findValidConfigs.currentUUID:{%s}.", configitemtype.uuid);
            if (!n(event, configitemtype.pageInfo)) {
                cr1.b("PageConfigMgr.findValidConfigs.currentUUID:{%s}.isMatchUriOrUris fail.", configitemtype.uuid);
            } else if (!e(event, configitemtype.pageInfo)) {
                cr1.b("PageConfigMgr.findValidConfigs.currentUUID:{%s}.checkParamContains fail.", configitemtype.uuid);
            } else {
                arrayList.add(configitemtype);
            }
        }
        return f(event, arrayList);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.List, java.lang.String, java.util.List] */
    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.a
    public void p(List<PageConfigItem> list, String str, List list2) {
        fo1.A().w();
    }

    /* renamed from: x */
    public PageConfigItem r(String str) {
        PageConfigItem pageConfigItem = (PageConfigItem) JSON.parseObject(str, PageConfigItem.class);
        pageConfigItem.pageInfo = t(str, pageConfigItem.uuid);
        return pageConfigItem;
    }

    /* renamed from: y */
    public PageConfigItem s(Event event) {
        Uri parse = Uri.parse(event.originUri);
        if (!"directly".equals(parse.getQueryParameter("openType"))) {
            return null;
        }
        String jSONObject = u(parse).toString();
        PageConfigItem pageConfigItem = (PageConfigItem) JSON.parseObject(jSONObject, PageConfigItem.class);
        pageConfigItem.pageInfo = t(jSONObject, pageConfigItem.uuid);
        return pageConfigItem;
    }
}
