package com.taobao.android.dinamic.asyncrender;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.taobao.android.dinamic.DViewGenerator;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.lang.reflect.Field;
import java.util.List;
import tb.ew2;
import tb.r70;
import tb.ry;
import tb.uv2;
import tb.v00;
import tb.v10;
import tb.vx;
import tb.wz;

/* compiled from: Taobao */
public class DPreRenderTask implements Runnable {
    private static final String TAG = "DPreRenderTask";
    Context context;
    String module;
    List<DinamicTemplate> templateList;

    public DPreRenderTask(Context context2, String str, List<DinamicTemplate> list) {
        this.templateList = list;
        this.module = str;
        this.context = context2.getApplicationContext();
    }

    private void preRenderTemplate(uv2 uv2) {
        List<DinamicTemplate> list = this.templateList;
        if (list != null) {
            for (DinamicTemplate dinamicTemplate : list) {
                DXTemplateItem dXTemplateItem = null;
                ew2 j = DViewGenerator.o(this.module).j(uv2, null, dinamicTemplate);
                if (j.f()) {
                    wz.f(ry.TAG, ry.TAG, "asyncCreateTemplateView success:" + dinamicTemplate.name);
                    v10.c().a(j, dinamicTemplate, this.module);
                } else {
                    String b = j.b().b();
                    wz.f(ry.TAG, ry.TAG, "asyncCreateTemplateView fail:\n" + b);
                    if (TextUtils.isEmpty(b) || (!b.contains(r70.ERROR_CODE_TEMPLATE_FILE_LOST) && !b.contains(r70.ERROR_CODE_TEMPLATE_NOT_FOUND))) {
                        if (dinamicTemplate != null) {
                            dXTemplateItem = transformTemplateToV3(dinamicTemplate);
                        }
                        String str = this.module;
                        DXAppMonitor.q(str, dXTemplateItem, "AsyncRender", "Pre_Render_2.0_Fail", e.V2_PRE_RENDER_FAIL, "asyncCreateTemplateView fail" + j.b().b());
                    }
                }
            }
        }
    }

    private DXTemplateItem transformTemplateToV3(DinamicTemplate dinamicTemplate) {
        if (dinamicTemplate == null) {
            return null;
        }
        try {
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            dXTemplateItem.name = dinamicTemplate.name;
            if (!TextUtils.isEmpty(dinamicTemplate.version)) {
                dXTemplateItem.version = Long.parseLong(dinamicTemplate.version);
            } else {
                dXTemplateItem.version = -1;
            }
            dXTemplateItem.templateUrl = dinamicTemplate.templateUrl;
            return dXTemplateItem;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void run() {
        try {
            Field declaredField = Looper.class.getDeclaredField("sThreadLocal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Looper.getMainLooper());
            if (obj instanceof ThreadLocal) {
                ((ThreadLocal) obj).set(Looper.getMainLooper());
            }
            preRenderTemplate(new uv2(this.context));
        } catch (Throwable th) {
            DXAppMonitor.q(v00.DB_NAME, null, "AsyncRender", "Pre_Render_2.0_Crash", e.V2_PRE_RENDER_CRASH, vx.a(th));
        }
    }
}
