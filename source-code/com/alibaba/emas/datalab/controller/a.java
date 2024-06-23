package com.alibaba.emas.datalab.controller;

import android.content.Context;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.stage.Stage;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.Map;
import tb.t20;
import tb.yc2;

/* compiled from: Taobao */
public class a {
    public static final String DATALAB_ALGO_UPDATE = "datalab_algo_update";
    public static final String DATALAB_ALGO_ZCACHE = "datalab_algo_zcache";

    /* access modifiers changed from: package-private */
    /* renamed from: com.alibaba.emas.datalab.controller.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public class C0082a implements OConfigListener {
        final /* synthetic */ Context a;

        C0082a(a aVar, Context context) {
            this.a = context;
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if (str.equals(a.DATALAB_ALGO_UPDATE)) {
                String config = OrangeConfig.getInstance().getConfig(str, "algo_update_open", null);
                Log.e("Datalab.Orange", "orange algo update open value is " + config);
                if (config.equals("true")) {
                    com.alibaba.emas.datalab.a.b().b.b = Boolean.TRUE;
                } else {
                    com.alibaba.emas.datalab.a.b().b.b = Boolean.FALSE;
                }
            }
            if (str.equals(a.DATALAB_ALGO_ZCACHE)) {
                t20 t20 = new t20();
                t20.a = "orange";
                Stage stage = Stage.NOTIFY;
                String config2 = OrangeConfig.getInstance().getConfig(str, "config_biz", null);
                Log.e("Datalab.Orange", "orange biz value is " + config2);
                if (config2 == null) {
                    Log.w("Datalab.Orange", "biz value is null");
                    return;
                }
                try {
                    t20.b = DatalabBizType.valueOf(config2);
                } catch (Exception e) {
                    Log.e("Datalab.Orange", "biz type not support ", e);
                }
                String config3 = OrangeConfig.getInstance().getConfig(str, "config_start", "[]");
                Log.e("Datalab.Orange", "orange start value is " + config3);
                if (config3 != null && !config3.equals("[]")) {
                    t20.c = "app.start";
                    t20.d = config3;
                    try {
                        if (yc2.b().a(this.a, t20.b, t20.c) == null) {
                            Log.e("Datalab.Orange", "first cache to sp " + t20.b + " " + t20.c);
                            yc2.b().c(this.a, t20, t20.b, t20.c);
                            com.alibaba.emas.datalab.a.b().b.e(t20);
                        }
                    } catch (Exception e2) {
                        Log.e("Datalab.Orange", "app start event error", e2);
                    }
                }
                String config4 = OrangeConfig.getInstance().getConfig(str, "algo_open", "false");
                Log.e("Datalab.Orange", "orange algo open value is " + config4);
                t20.c = "algo.open";
                t20.d = config4;
                yc2.b().c(this.a, t20, t20.b, t20.c);
            }
        }
    }

    public void a(Context context) throws Exception {
        OrangeConfig.getInstance().registerListener(new String[]{DATALAB_ALGO_UPDATE, DATALAB_ALGO_ZCACHE}, new C0082a(this, context), true);
    }
}
