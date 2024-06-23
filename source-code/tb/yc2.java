package tb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.fastjson.JSON;

/* compiled from: Taobao */
public class yc2 {

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static yc2 a = new yc2();
    }

    public static yc2 b() {
        return b.a;
    }

    public t20 a(Context context, DatalabBizType datalabBizType, String str) {
        if (context == null) {
            Log.e("Datalab.SpController", "context is null, need init first");
            return null;
        }
        try {
            String string = context.getSharedPreferences(datalabBizType.toString(), 0).getString(str, null);
            if (string != null) {
                return (t20) JSON.parseObject(string, t20.class);
            }
        } catch (Exception e) {
            Log.e("Datalab.SpController", "error happen ", e);
        }
        return null;
    }

    @TargetApi(9)
    public void c(Context context, t20 t20, DatalabBizType datalabBizType, String str) {
        if (context == null) {
            Log.e("Datalab.SpController", "context is null, need init first");
        } else if (t20 == null || datalabBizType == null || str == null) {
            Log.e("Datalab.SpController", "notify is null or name is null");
        } else {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(datalabBizType.toString(), 0).edit();
                edit.putString(str, JSON.toJSONString(t20));
                edit.apply();
            } catch (Exception e) {
                Log.e("Datalab.SpController", "error happen ", e);
            }
        }
    }

    public void d(Context context, DatalabBizType datalabBizType) {
        if (datalabBizType == null) {
            Log.e("Datalab.SpController", "bizType is null");
            return;
        }
        DatalabBizType datalabBizType2 = DatalabBizType.zcache;
        if (datalabBizType.equals(datalabBizType2)) {
            t20 a2 = a(context, datalabBizType2, "app.start");
            Log.w("Datalab.SpController", "appStartEvent result is " + JSON.toJSONString(a2));
            if (a2 != null) {
                try {
                    Log.w("Datalab.SpController", datalabBizType + " app start event notify");
                    com.alibaba.emas.datalab.a.b().b.e(a2);
                } catch (Exception e) {
                    Log.e("Datalab.SpController", "app start event error", e);
                }
            }
        }
    }

    private yc2() {
    }
}
