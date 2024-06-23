package tb;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.x;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class x6 {
    public static final x6 INSTANCE = new x6();
    @NotNull
    public static final String P_KEY_ARG = "arg";
    @NotNull
    public static final String P_KEY_DATA = "data";
    @NotNull
    public static final String P_KEY_ERROR_CODE = "errorCode";
    @NotNull
    public static final String P_KEY_ERROR_MSG = "errorMsg";
    @NotNull
    public static final String P_KEY_MODULE = "module";
    @NotNull
    public static final String P_KEY_POINT = "point";
    @NotNull
    public static final String P_KEY_VALUE = "value";
    @NotNull
    public static final String TYPE_COUNTER = "appMonitorCounter";
    @NotNull
    public static final String TYPE_FAIL = "appMonitorFail";
    @NotNull
    public static final String TYPE_SUCCESS = "appMonitorSuccess";

    private x6() {
    }

    @JvmStatic
    public static final void a(@NotNull q qVar, @Nullable r rVar, @NotNull k kVar) {
        q0 f;
        k21.j(qVar, "akCtx");
        k21.j(kVar, "akErrorRet");
        JSONObject jSONObject = null;
        if (!r41.b(rVar != null ? rVar.c() : null, "__callFromThisAlarm__", false)) {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = do2.a("__callFromThisAlarm__", Boolean.TRUE);
            pairArr[1] = do2.a("module", "AbilityKit");
            pairArr[2] = do2.a("point", "ExecuteException");
            Pair[] pairArr2 = new Pair[3];
            j jVar = (j) kVar.a();
            pairArr2[0] = do2.a("errorCode", jVar != null ? Integer.valueOf(jVar.a()) : null);
            j jVar2 = (j) kVar.a();
            pairArr2[1] = do2.a("errorMsg", jVar2 != null ? jVar2.b() : null);
            Pair[] pairArr3 = new Pair[5];
            Context c = qVar.c();
            pairArr3[0] = do2.a("app", c != null ? c.getPackageName() : null);
            h a = qVar.a();
            pairArr3[1] = do2.a(if1.DIMEN_BIZ, (a == null || (f = a.f()) == null) ? null : f.getBusinessID());
            pairArr3[2] = do2.a("namespace", p.b().adjustedBizID(qVar.a()));
            pairArr3[3] = do2.a("abilityType", rVar != null ? rVar.a() : null);
            if (rVar != null) {
                jSONObject = rVar.c();
            }
            pairArr3[4] = do2.a("params", jSONObject);
            Map map = x.m(pairArr3);
            if (map != null) {
                pairArr2[2] = do2.a("arg", new JSONObject(map).toJSONString());
                Map map2 = x.m(pairArr2);
                if (map2 != null) {
                    pairArr[3] = do2.a("data", new JSONObject(map2));
                    Map map3 = x.m(pairArr);
                    if (map3 != null) {
                        JSONObject jSONObject2 = new JSONObject(map3);
                        u0.b(TYPE_FAIL, jSONObject2, qVar, null, false, 8, null);
                        p.a().loge("AbilityKitErr", jSONObject2.toJSONString());
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        }
    }
}
