package tb;

import android.view.View;
import cn.damai.tetris.component.home.bean.BannerResultBean;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.bean.HomePageVideoBean;
import cn.damai.tetris.component.home.bean.HomeStarTourBean;
import cn.damai.tetris.component.home.bean.HomeTitleBean;
import cn.damai.tetris.component.home.bean.WarningMessageBean;
import cn.damai.tetris.component.home.viewholder.AnnouncementViewHolder;
import cn.damai.tetris.component.home.viewholder.BannerViewHolder;
import cn.damai.tetris.component.home.viewholder.RankTopViewHolder;
import cn.damai.tetris.component.home.viewholder.RecentShowViewHolder;
import cn.damai.tetris.component.home.viewholder.StarTourViewHolder;
import cn.damai.tetris.component.home.viewholder.VideoViewHolderV2;
import cn.damai.tetris.component.home.viewholder.WantSeeViewHolder;
import cn.damai.tetris.component.home.viewholder.WaterFlowTitleViewHolder;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.tetris.mvp.ViewHolderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
public class vj2 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static HashMap<String, ViewHolderData> a;

    static {
        HashMap<String, ViewHolderData> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put(wj2.DM_HOME_BANNER_CID, new ViewHolderData(BannerViewHolder.class, BannerResultBean.class));
        a.put("dm_home_warningmessage", new ViewHolderData(AnnouncementViewHolder.class, WarningMessageBean.class));
        a.put("dm_home_mustseerank3", new ViewHolderData(RankTopViewHolder.class, HomePageRankBean.class));
        a.put("dm_home_wantsee", new ViewHolderData(WantSeeViewHolder.class, HomePageRecentBean.class));
        a.put("dm_home_recentproject", new ViewHolderData(RecentShowViewHolder.class, HomePageRecentBean.class));
        a.put("dm_home_tour", new ViewHolderData(StarTourViewHolder.class, HomeStarTourBean.class));
        a.put("dm_home_video", new ViewHolderData(VideoViewHolderV2.class, HomePageVideoBean.class));
        a.put("dm_home_weinituijian_title", new ViewHolderData(WaterFlowTitleViewHolder.class, HomeTitleBean.class));
    }

    public static CommonViewHolder a(String str, View view) {
        Exception e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279824872")) {
            return (CommonViewHolder) ipChange.ipc$dispatch("-1279824872", new Object[]{str, view});
        }
        ViewHolderData viewHolderData = a.get(str);
        T t = null;
        if (viewHolderData == null) {
            return null;
        }
        try {
            T newInstance = viewHolderData.viewHolder.getDeclaredConstructor(View.class).newInstance(view);
            try {
                newInstance.setTClass(viewHolderData.bean);
                return newInstance;
            } catch (Exception e2) {
                e = e2;
                t = newInstance;
                e.printStackTrace();
                return t;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return t;
        }
    }
}
