package tb;

import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.HashMap;
import java.util.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public class e03 {
    @NotNull
    public static final String BIZ_CODE_DIMEN = "bizCode";
    @NotNull
    public static final String BIZ_MSG_DIMEN = "bizMsg";
    @NotNull
    public static final String BIZ_SCENE_DIMEN = "bizScene";
    @NotNull
    public static final String BIZ_TYPE_DIMEN = "bizType";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String EXTRA_DATA_DIMEN = "extraData";
    @NotNull
    public static final String PAGE_NAME_DIMEN = "pageName";
    @NotNull
    public static final String PAGE_SPM_DIMEN = "pageSpm";
    @NotNull
    public static final String PLATFORM_DIMEN = "platform";
    @NotNull
    public static final String POINT_FAIL_COUNT_MEASURE = "failCount";
    @NotNull
    public static final String POINT_SUCCESS_COUNT_MEASURE = "successCount";
    @NotNull
    public static final String POINT_SUCCESS_MEASURE = "success";
    @NotNull
    public static final String SIGN_CODE_DIMEN = "signCode";
    @NotNull
    public static final String USER_ID_DIMEN = "userId";
    @NotNull
    private static String e = "android";
    @NotNull
    private static String f = "yyModule";
    @NotNull
    private static String g = "yyMoviePoint";
    @Nullable
    private static e03 h;
    @NotNull
    private final String a;
    private boolean b;
    private int c;
    @NotNull
    private final Random d;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final synchronized e03 a() {
            e03 e03;
            if (e03.h == null) {
                e03.h = new e03();
            }
            e03 = e03.h;
            k21.f(e03);
            return e03;
        }
    }

    public e03() {
        this.a = "YYBaseStatMonitor";
        this.c = 100;
        this.d = new Random();
    }

    private final boolean c(int i) {
        return i <= 0 || (i < 100 && !e(i));
    }

    private final boolean e(int i) {
        return this.d.nextInt(100) + 1 <= i;
    }

    public void d(@NotNull MeasureSet measureSet, @NotNull String str, double d2, @Nullable Double d3, @Nullable Double d4) {
        k21.i(measureSet, "set");
        k21.i(str, "name");
        Measure measure = new Measure(str, Double.valueOf(d2));
        if (!(d3 == null || d4 == null)) {
            measure.setRange(d3, d4);
        }
        measureSet.addMeasure(measure);
    }

    public synchronized void f() {
        if (!this.b) {
            Logger.f(f, "iapp monitor register start");
            DimensionSet create = DimensionSet.create();
            create.addDimension("bizType");
            create.addDimension(BIZ_SCENE_DIMEN);
            create.addDimension("bizCode");
            create.addDimension(BIZ_MSG_DIMEN);
            create.addDimension(PAGE_SPM_DIMEN);
            create.addDimension("pageName");
            create.addDimension(SIGN_CODE_DIMEN);
            create.addDimension(EXTRA_DATA_DIMEN);
            create.addDimension("platform");
            create.addDimension("userId");
            MeasureSet create2 = MeasureSet.create();
            k21.h(create2, "measSet");
            d(create2, "success", 0.0d, null, null);
            d(create2, POINT_FAIL_COUNT_MEASURE, 0.0d, null, null);
            d(create2, POINT_SUCCESS_COUNT_MEASURE, 0.0d, null, null);
            AppMonitor.register(f, g, create2, create);
            this.b = true;
            Logger.f(f, "app monitor register end");
        }
    }

    public void g(@NotNull xa xaVar) {
        k21.i(xaVar, "appMonitorPoint");
        f03 f03 = f03.INSTANCE;
        f03.a(this.a, "release: step1");
        if (!c(this.c)) {
            String mPointName = xaVar.getMPointName();
            String bizScene = xaVar.getBizScene();
            String bizCode = xaVar.getBizCode();
            String bizMsg = xaVar.getBizMsg();
            String pageSpm = xaVar.getPageSpm();
            String pageName = xaVar.getPageName();
            int successState = xaVar.getSuccessState();
            int failCount = xaVar.getFailCount();
            int successCount = xaVar.getSuccessCount();
            String a2 = i03.INSTANCE.a();
            HashMap<String, String> extraDataMap = xaVar.getExtraDataMap();
            String signCode = xaVar.getSignCode();
            f();
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("bizType", mPointName);
            create.setValue("bizCode", bizCode);
            create.setValue(BIZ_MSG_DIMEN, bizMsg);
            create.setValue(PAGE_SPM_DIMEN, pageSpm);
            create.setValue("pageName", pageName);
            create.setValue(SIGN_CODE_DIMEN, signCode);
            create.setValue("platform", e);
            create.setValue("userId", a2);
            if (!TextUtils.isEmpty(bizScene)) {
                create.setValue(BIZ_SCENE_DIMEN, bizScene);
            }
            if (extraDataMap != null && extraDataMap.size() > 0) {
                create.setValue(EXTRA_DATA_DIMEN, bh0.INSTANCE.e(extraDataMap));
            }
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("success", (double) successState);
            create2.setValue(POINT_SUCCESS_COUNT_MEASURE, (double) successCount);
            create2.setValue(POINT_FAIL_COUNT_MEASURE, (double) failCount);
            f03.a(this.a, "release: ready-commit");
            AppMonitor.Stat.commit(f, g, create, create2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public e03(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        this();
        k21.i(str, "platform");
        k21.i(str2, "module");
        k21.i(str3, "point");
        e = str;
        f = str2;
        g = str3;
    }
}
