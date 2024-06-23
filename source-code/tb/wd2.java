package tb;

import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class wd2<BizResponse> implements IRemoteDataTransformer<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "StandardDataTransformer";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: tb.fb0<BizResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer
    @Nullable
    public fb0<BizResponse> transform(@Nullable DoloresRequest<BizResponse> doloresRequest, @Nullable JSONObject jSONObject, @Nullable Type type) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1550538286")) {
            return (fb0) ipChange.ipc$dispatch("-1550538286", new Object[]{this, doloresRequest, jSONObject, type});
        }
        fb0<BizResponse> fb0 = (fb0<BizResponse>) new fb0();
        if (jSONObject == null || type == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            BizResponseType bizResponseType = BizResponseType.RESULT_SUCCESS;
            fb0.h(bizResponseType.getCode());
            fb0.j(bizResponseType.getDesc());
            IJSONConverter c = ua0.Companion.c();
            if (c == null) {
                c = ah0.INSTANCE;
            }
            String jSONObject2 = jSONObject.toString();
            k21.h(jSONObject2, "jsonObject.toString()");
            fb0.g(c.parseJson(jSONObject2, type));
            if (fb0.a() == null) {
                if (jSONObject2 != null) {
                    if (jSONObject2.length() != 0) {
                        z = false;
                    }
                }
                if (!z) {
                    BizResponseType bizResponseType2 = BizResponseType.PARSE_ERROR;
                    fb0.h(bizResponseType2.getCode());
                    fb0.j(bizResponseType2.getDesc());
                    fb0.i(bizResponseType2.getLocalDes());
                }
            }
        } catch (Exception e) {
            vp.c(TAG, "parse biz response error (" + e.getMessage() + ')');
        }
        vp.a(TAG, "transform:耗时=" + (System.currentTimeMillis() - currentTimeMillis));
        return fb0;
    }
}
