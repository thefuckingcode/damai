package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.animation.GXIAnimation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class mp0 implements GXIAnimation {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final String KEY_LOOP = "loop";
    @NotNull
    private static final String KEY_LOOP_COUNT = "loopCount";
    @NotNull
    private static final String KEY_URL = "url";
    @NotNull
    private static final String KEY_VALUE = "value";
    @Nullable
    private GXIExpression gxLocalUri;
    @Nullable
    private GXIExpression gxRemoteUri;
    private int loopCount;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final mp0 a(@Nullable String str, @Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String string = jSONObject.getString("value");
            String string2 = jSONObject.getString("url");
            if (string == null && string2 == null) {
                return null;
            }
            GXRegisterCenter.GXIExtensionLottieAnimation l = GXRegisterCenter.Companion.a().l();
            mp0 create = l == null ? null : l.create();
            if (create == null) {
                return null;
            }
            if (string != null) {
                create.setGxLocalUri(yo0.INSTANCE.b(str, string));
            }
            if (string2 != null) {
                create.setGxRemoteUri(yo0.INSTANCE.b(str, string2));
            }
            if (jSONObject.containsKey("loop")) {
                Boolean bool = jSONObject.getBoolean("loop");
                k21.h(bool, "data.getBoolean(KEY_LOOP)");
                if (bool.booleanValue()) {
                    create.setLoopCount(Integer.MAX_VALUE);
                    return create;
                }
            }
            if (jSONObject.containsKey(mp0.KEY_LOOP_COUNT)) {
                create.setLoopCount(jSONObject.getIntValue(mp0.KEY_LOOP_COUNT));
            }
            return create;
        }
    }

    @Override // com.alibaba.gaiax.template.animation.GXIAnimation
    public abstract void executeAnimation(@Nullable GXIExpression gXIExpression, @Nullable GXIExpression gXIExpression2, @NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject);

    @Nullable
    public final GXIExpression getGxLocalUri() {
        return this.gxLocalUri;
    }

    @Nullable
    public final GXIExpression getGxRemoteUri() {
        return this.gxRemoteUri;
    }

    public final int getLoopCount() {
        return this.loopCount;
    }

    public final void setGxLocalUri(@Nullable GXIExpression gXIExpression) {
        this.gxLocalUri = gXIExpression;
    }

    public final void setGxRemoteUri(@Nullable GXIExpression gXIExpression) {
        this.gxRemoteUri = gXIExpression;
    }

    public final void setLoopCount(int i) {
        this.loopCount = i;
    }
}
