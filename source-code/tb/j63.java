package tb;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
public class j63 {
    private static volatile boolean a;

    public static void a(i63 i63) {
        String str;
        String str2;
        String str3;
        if (!a) {
            a = true;
            str2 = "videoformat";
            str = "networkType";
            str3 = "speed_test";
            AppMonitor.register("vpm", str3, MeasureSet.create().addMeasure("bandwidth").addMeasure("duration").addMeasure("impairmentOrder").addMeasure("cmdConnectionTime").addMeasure("networkType"), DimensionSet.create().addDimension("id").addDimension("ruleId").addDimension("task_id").addDimension("url").addDimension("detail").addDimension("error_code").addDimension(TableField.PS_ID).addDimension("vvId").addDimension("videoformat"));
        } else {
            str = "networkType";
            str2 = "videoformat";
            str3 = "speed_test";
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("id", i63.b);
        create.setValue("ruleId", i63.c);
        create.setValue("task_id", "" + i63.d);
        create.setValue("url", i63.e);
        create.setValue(TbAuthConstants.IP, i63.f);
        create.setValue("detail", JSON.toJSONString(i63.i));
        create.setValue("error_code", "" + i63.a);
        create.setValue(TableField.PS_ID, i63.j);
        create.setValue("vvId", i63.l);
        create.setValue(str2, i63.m);
        create.setValue("triggerType", i63.o);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("bandwidth", (double) i63.h);
        create2.setValue("duration", (double) i63.g);
        create2.setValue("impairmentOrder", (double) i63.k);
        create2.setValue("cmdConnectionTime", (double) i63.n);
        create2.setValue(str, (double) i63.p);
        AppMonitor.Stat.commit("vpm", str3, create, create2);
        AdapterForTLog.loge("SpeedTest", "stat:bandwidth=" + i63.h + ",task_id=" + i63.d + ",url=" + i63.e + ",error_code=" + i63.a + ",networkType=" + i63.p);
    }
}
