package tb;

import com.alibaba.android.ultron.trade.event.model.AutoJumpOpenUrlEventModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMEvent;

/* compiled from: Taobao */
public class f9 extends gl1 {
    public static final String KEY_STATUS_AUTO_JUMP = "AutoJumpRequest";
    public static final String KEY_STATUS_H5_ASYNC_REQUEST = "H5AsyncRequest";
    public static final String KEY_STATUS_H5_BACK = "H5Back";

    public f9() {
        this.g = 100;
        a();
    }

    @Override // tb.gl1, tb.va
    public void h(jn2 jn2) {
        IDMEvent e = e();
        if (e != null && e.getFields() != null) {
            AutoJumpOpenUrlEventModel autoJumpOpenUrlEventModel = null;
            try {
                autoJumpOpenUrlEventModel = (AutoJumpOpenUrlEventModel) JSON.parseObject(e.getFields().toJSONString(), AutoJumpOpenUrlEventModel.class);
            } catch (Exception unused) {
                tr2.b("AutoJumpOpenUrlSubscriber", "onHandleEvent JSON.parseObject failed");
            }
            if (autoJumpOpenUrlEventModel != null) {
                String pageType = autoJumpOpenUrlEventModel.getPageType();
                String url = autoJumpOpenUrlEventModel.getUrl();
                JSONObject params = autoJumpOpenUrlEventModel.getParams();
                if (pageType == null || url == null) {
                    tr2.b("type is null or url is null", new String[0]);
                    return;
                }
                if (Boolean.TRUE.toString().equals((String) jn2.e("autoJump"))) {
                    int i = this.j + 1;
                    this.j = i;
                    jn2.m(fl1.KEY_REQUEST_CODE, Integer.valueOf(i));
                    char c = 65535;
                    switch (pageType.hashCode()) {
                        case -1968751561:
                            if (pageType.equals(gl1.TYPE_OPEN_URL_NATIVE)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 2285:
                            if (pageType.equals("H5")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 2692129:
                            if (pageType.equals(gl1.TYPE_OPEN_URL_WEEX)) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            tr2.b("AutoJumpOpenUrlSubscriber", "跳转到native页面", url);
                            o(url, params);
                            break;
                        case 1:
                            tr2.b("AutoJumpOpenUrlSubscriber", "跳转到h5页面", url);
                            n(url, params, autoJumpOpenUrlEventModel.getMethod());
                            break;
                        case 2:
                            tr2.b("AutoJumpOpenUrlSubscriber", "跳转到weex页面", url);
                            p(url, params);
                            break;
                    }
                    this.c.getTradeEventHandler().n(jn2);
                    return;
                }
                autoJumpOpenUrlEventModel.setStatus(KEY_STATUS_AUTO_JUMP);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", (Object) KEY_STATUS_AUTO_JUMP);
                k(e(), jSONObject);
                this.c.getTradeEventHandler().m(this.e, this.a.g());
                this.c.getDataManager().respondToLinkage(this.e);
            }
        }
    }
}
