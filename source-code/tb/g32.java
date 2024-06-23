package tb;

import android.graphics.Matrix;
import com.alipay.sdk.m.s.a;
import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class g32 {
    private double a;
    @NotNull
    private b32 b;
    @NotNull
    private Matrix c;
    @Nullable
    private x22 d;
    @NotNull
    private List<SVGAVideoShapeEntity> e;

    public g32(@NotNull JSONObject jSONObject) {
        boolean z;
        g32 g32 = this;
        k21.j(jSONObject, "obj");
        g32.b = new b32(0.0d, 0.0d, 0.0d, 0.0d);
        g32.c = new Matrix();
        g32.e = m.g();
        g32.a = jSONObject.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject.optJSONObject("layout");
        if (optJSONObject != null) {
            g32.b = new b32(optJSONObject.optDouble(Constants.Name.X, 0.0d), optJSONObject.optDouble(Constants.Name.Y, 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject2.optDouble(c.a, 0.0d);
            double optDouble4 = optJSONObject2.optDouble("d", 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", 0.0d);
            double optDouble6 = optJSONObject2.optDouble(a.s, 0.0d);
            float f = (float) optDouble3;
            z = true;
            float f2 = (float) 0.0d;
            float[] fArr = {(float) optDouble, f, (float) optDouble5, (float) optDouble2, (float) optDouble4, (float) optDouble6, f2, f2, (float) 1.0d};
            g32 = this;
            g32.c.setValues(fArr);
        } else {
            z = true;
        }
        String optString = jSONObject.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z) {
                g32.d = new x22(optString);
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            g32.e = CollectionsKt___CollectionsKt.y0(arrayList);
        }
    }

    public final double a() {
        return this.a;
    }

    @NotNull
    public final b32 b() {
        return this.b;
    }

    @Nullable
    public final x22 c() {
        return this.d;
    }

    @NotNull
    public final List<SVGAVideoShapeEntity> d() {
        return this.e;
    }

    @NotNull
    public final Matrix e() {
        return this.c;
    }

    public final void f(@NotNull List<SVGAVideoShapeEntity> list) {
        k21.j(list, "<set-?>");
        this.e = list;
    }

    public g32(@NotNull FrameEntity frameEntity) {
        k21.j(frameEntity, "obj");
        this.b = new b32(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = new Matrix();
        this.e = m.g();
        Float f = frameEntity.alpha;
        this.a = (double) (f != null ? f.floatValue() : 0.0f);
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f2 = layout.x;
            double floatValue = (double) (f2 != null ? f2.floatValue() : 0.0f);
            Float f3 = layout.y;
            double floatValue2 = (double) (f3 != null ? f3.floatValue() : 0.0f);
            Float f4 = layout.width;
            double floatValue3 = (double) (f4 != null ? f4.floatValue() : 0.0f);
            Float f5 = layout.height;
            this.b = new b32(floatValue, floatValue2, floatValue3, (double) (f5 != null ? f5.floatValue() : 0.0f));
        }
        Transform transform = frameEntity.transform;
        boolean z = true;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f6 = transform.a;
            float floatValue4 = f6 != null ? f6.floatValue() : 1.0f;
            Float f7 = transform.b;
            float floatValue5 = f7 != null ? f7.floatValue() : 0.0f;
            Float f8 = transform.c;
            float floatValue6 = f8 != null ? f8.floatValue() : 0.0f;
            Float f9 = transform.d;
            float floatValue7 = f9 != null ? f9.floatValue() : 1.0f;
            Float f10 = transform.tx;
            float floatValue8 = f10 != null ? f10.floatValue() : 0.0f;
            Float f11 = transform.ty;
            float floatValue9 = f11 != null ? f11.floatValue() : 0.0f;
            fArr[0] = floatValue4;
            fArr[1] = floatValue6;
            fArr[2] = floatValue8;
            fArr[3] = floatValue5;
            fArr[4] = floatValue7;
            fArr[5] = floatValue9;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = !(str.length() <= 0 ? false : z) ? null : str;
            if (str != null) {
                this.d = new x22(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        ArrayList arrayList = new ArrayList(n.q(list, 10));
        for (T t : list) {
            k21.e(t, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(new SVGAVideoShapeEntity((ShapeEntity) t));
        }
        this.e = arrayList;
    }
}
