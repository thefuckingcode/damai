package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class f32 {
    @Nullable
    private final String a;
    @NotNull
    private final List<g32> b;

    public f32(@NotNull JSONObject jSONObject) {
        SVGAVideoShapeEntity sVGAVideoShapeEntity;
        k21.j(jSONObject, "obj");
        this.a = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    g32 g32 = new g32(optJSONObject);
                    if ((!g32.d().isEmpty()) && (sVGAVideoShapeEntity = (SVGAVideoShapeEntity) k.P(g32.d())) != null && sVGAVideoShapeEntity.e() && arrayList.size() > 0) {
                        g32.f(((g32) k.b0(arrayList)).d());
                    }
                    arrayList.add(g32);
                }
            }
        }
        this.b = CollectionsKt___CollectionsKt.y0(arrayList);
    }

    @NotNull
    public final List<g32> a() {
        return this.b;
    }

    @Nullable
    public final String b() {
        return this.a;
    }

    public f32(@NotNull SpriteEntity spriteEntity) {
        List<g32> list;
        SVGAVideoShapeEntity sVGAVideoShapeEntity;
        k21.j(spriteEntity, "obj");
        this.a = spriteEntity.imageKey;
        List<FrameEntity> list2 = spriteEntity.frames;
        if (list2 != null) {
            list = new ArrayList<>(n.q(list2, 10));
            g32 g32 = null;
            for (T t : list2) {
                k21.e(t, AdvanceSetting.NETWORK_TYPE);
                g32 g322 = new g32((FrameEntity) t);
                if ((!g322.d().isEmpty()) && (sVGAVideoShapeEntity = (SVGAVideoShapeEntity) k.P(g322.d())) != null && sVGAVideoShapeEntity.e() && g32 != null) {
                    g322.f(g32.d());
                }
                list.add(g322);
                g32 = g322;
            }
        } else {
            list = m.g();
        }
        this.b = list;
    }
}
