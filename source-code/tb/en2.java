package tb;

import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.alibaba.pictures.request.BaseMtopRequest;
import com.alibaba.pictures.request.BaseRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: Taobao */
public final class en2<BizResponse> implements IRemoteDataTransformer<BizResponse> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String KEY_RESULT_CODE = "returnCode";
    @NotNull
    public static final String KEY_RESULT_MSG = "returnMessage";
    @NotNull
    public static final String KEY_RESULT_VALUE = "returnValue";
    @NotNull
    public static final String TAG = "TppShawshankDataTransformer";

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    private final void a(String str, DoloresRequest<BizResponse> doloresRequest) {
        String str2;
        String obj;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "433273492")) {
            ipChange.ipc$dispatch("433273492", new Object[]{this, str, doloresRequest});
            return;
        }
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z = false;
                }
            } catch (Exception e) {
                vp.c(TAG, "checkResponseEmpty:" + e.getMessage());
                return;
            }
        }
        if (z || k21.d(str, "[]")) {
            String str3 = "unknown";
            if (doloresRequest instanceof BaseRequest) {
                str2 = ((BaseRequest) doloresRequest).API_NAME;
            } else if (doloresRequest instanceof BaseMtopRequest) {
                str2 = ((BaseMtopRequest) doloresRequest).getApiName();
            } else {
                str2 = doloresRequest instanceof aa ? ((aa) doloresRequest).a : str3;
            }
            HashMap hashMap = new HashMap();
            if (!(doloresRequest == null || (obj = doloresRequest.toString()) == null)) {
                str3 = obj;
            }
            hashMap.put("Request", str3);
            ur2 ur2 = ur2.INSTANCE;
            bb0.a(str2, hashMap);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: tb.fb0<BizResponse> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer
    @Nullable
    public fb0<BizResponse> transform(@Nullable DoloresRequest<BizResponse> doloresRequest, @Nullable JSONObject jSONObject, @Nullable Type type) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1955350591")) {
            return (fb0) ipChange.ipc$dispatch("1955350591", new Object[]{this, doloresRequest, jSONObject, type});
        }
        fb0<BizResponse> fb0 = (fb0<BizResponse>) new fb0();
        if (!(jSONObject == null || type == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                String jSONObject2 = jSONObject.toString();
                k21.h(jSONObject2, "jsonObject.toString()");
                fb0.h(jSONObject.optInt("returnCode", BizResponseType.RESULT_FAIL.getCode()));
                fb0.j(jSONObject.optString("returnMessage"));
                a(jSONObject.optString("returnValue"), doloresRequest);
                IJSONConverter c = ua0.Companion.c();
                if (c == null) {
                    c = ah0.INSTANCE;
                }
                fb0.g(c.parseJson(jSONObject2, type));
                if (fb0.a() == null) {
                    if (jSONObject2 != null) {
                        if (jSONObject2.length() != 0) {
                            z = false;
                        }
                    }
                    if (!z) {
                        BizResponseType bizResponseType = BizResponseType.PARSE_ERROR;
                        fb0.h(bizResponseType.getCode());
                        fb0.j(bizResponseType.getDesc());
                        fb0.i(bizResponseType.getLocalDes());
                    }
                }
            } catch (Exception e) {
                vp.c(TAG, "parse biz response error (" + e.getMessage() + ')');
            }
            vp.a(TAG, "bizReturnCode=" + fb0.b() + ",bizReturnMessage=" + fb0.c());
            StringBuilder sb = new StringBuilder();
            sb.append("transform:耗时=");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            vp.a(wd2.TAG, sb.toString());
        }
        return fb0;
    }
}
