package tb;

import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Set;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class pn1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final pn1 INSTANCE = new pn1();
    @NotNull
    private static final ArrayList<String> a;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(DMNav.KRequestCodeReferrer);
        arrayList.add("referrer");
        a = arrayList;
    }

    private pn1() {
    }

    @NotNull
    public final Bundle a(@Nullable Bundle bundle) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862200802")) {
            return (Bundle) ipChange.ipc$dispatch("1862200802", new Object[]{this, bundle});
        }
        Bundle bundle2 = new Bundle();
        PageArgument pageArgument = new PageArgument();
        JSONObject jSONObject = new JSONObject();
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            k21.h(keySet, "keySet()");
            for (T t : keySet) {
                Object obj = bundle.get(t);
                String str = null;
                if (o.s("patternName", t, true)) {
                    pageArgument.patternName = obj != null ? obj.toString() : null;
                } else if (o.w("patternVersion", t, true)) {
                    pageArgument.patternVersion = obj != null ? obj.toString() : null;
                } else if (!a.contains(t)) {
                    jSONObject.put((Object) t, (Object) (obj != null ? obj.toString() : null));
                }
                vc vcVar = vc.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append("Bundle 入参： ");
                sb.append((String) t);
                sb.append(" = ");
                if (obj != null) {
                    str = obj.toString();
                }
                sb.append(str);
                sb.append(' ');
                vcVar.a(sb.toString(), "PageArg");
            }
        }
        pageArgument.args = jSONObject.toJSONString();
        bundle2.putParcelable("KEY_PAGE_ARGS", pageArgument);
        return bundle2;
    }

    @Nullable
    public final PageArgument b(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549888919")) {
            return (PageArgument) ipChange.ipc$dispatch("-1549888919", new Object[]{this, bundle});
        } else if (bundle == null) {
            return null;
        } else {
            try {
                return (PageArgument) bundle.getParcelable("KEY_PAGE_ARGS");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
