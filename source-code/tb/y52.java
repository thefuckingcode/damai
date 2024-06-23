package tb;

import android.content.Context;
import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.musicfestival.model.MusicPageNav;
import cn.damai.user.repertoite.ui.RepertoireDetailFragment;
import cn.damai.user.userprofile.FeedsViewModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class y52 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(BaccountInfo baccountInfo, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1463519929")) {
            ipChange.ipc$dispatch("1463519929", new Object[]{baccountInfo, context});
        } else if (baccountInfo != null && context != null) {
            if (!baccountInfo.type.equals("5")) {
                Bundle bundle = new Bundle();
                bundle.putString(FeedsViewModel.ARG_USERID, baccountInfo.damaiId);
                bundle.putString("usertype", baccountInfo.type);
                DMNav.from(context).withExtras(bundle).toUri(NavUri.b(gr.ARTISTID_THEME));
            } else if (baccountInfo.isMusicType()) {
                MusicPageNav.openH5MusicIpPage(context, baccountInfo.damaiId);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putString(RepertoireDetailFragment.REPERTOIREID, baccountInfo.damaiId);
                DMNav.from(context).withExtras(bundle2).toUri(NavUri.b(wz1.REPERTOITE));
            }
        }
    }
}
