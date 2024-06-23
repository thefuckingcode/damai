package tb;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.tetris.component.drama.bean.IDramaBean;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class zb0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Activity activity, IDramaBean iDramaBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-745677287")) {
            ipChange.ipc$dispatch("-745677287", new Object[]{activity, iDramaBean});
        } else if (activity != null && iDramaBean != null && !TextUtils.isEmpty(iDramaBean.getDramaId())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", iDramaBean.getDramaId());
            DMNav.from(activity).withExtras(bundle).toUri(NavUri.b("ipdrama"));
        }
    }

    public static void b(w9 w9Var, IDramaBean iDramaBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "273682661")) {
            ipChange.ipc$dispatch("273682661", new Object[]{w9Var, iDramaBean});
        } else if (w9Var != null) {
            a(w9Var.getActivity(), iDramaBean);
        }
    }

    public static void c(w9 w9Var, ProjectShowBean projectShowBean) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027875628")) {
            ipChange.ipc$dispatch("1027875628", new Object[]{w9Var, projectShowBean});
        } else if (w9Var != null && projectShowBean != null && (activity = w9Var.getActivity()) != null) {
            tb2.b(activity, projectShowBean.schema, projectShowBean.itemId, projectShowBean.name, projectShowBean.verticalPic);
        }
    }

    public static void d(w9 w9Var, String str) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196414850")) {
            ipChange.ipc$dispatch("-1196414850", new Object[]{w9Var, str});
        } else if (!TextUtils.isEmpty(str) && w9Var != null && (activity = w9Var.getActivity()) != null) {
            DMNav.from(activity).toUri(str);
        }
    }
}
