package tb;

import android.util.Log;
import cn.damai.common.AppConfig;
import cn.damai.common.util.ToastUtil;
import cn.damai.tetris.component.common.AccountAlbumContract;
import cn.damai.tetris.component.rank.RankFilterPlugin;
import cn.damai.tetris.componentplugin.AnchorFloatingPlugin;
import cn.damai.tetris.componentplugin.DiscoverFeedPlugin;
import cn.damai.tetris.componentplugin.FilterPanelPlugin;
import cn.damai.tetris.componentplugin.MusicFestivalPlugin;
import cn.damai.tetris.componentplugin.ProjectFilterPlugin;
import cn.damai.tetris.componentplugin.VerticalDramaByMonthPlugin;
import cn.damai.tetris.componentplugin.VoteCardPlugin;
import cn.damai.tetris.core.nav.NavigatorProxy;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.componentplugin.ComponentPluginType;
import cn.damai.tetris.v2.util.LocalDxTemplate;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.image.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public class xj2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(w9 w9Var) {
        DinamicXEngine dXEngine;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041116136")) {
            ipChange.ipc$dispatch("-1041116136", new Object[]{w9Var});
            return;
        }
        try {
            if (AppConfig.v() && w9Var != null) {
                List<String> d = o80.d();
                if (!f92.d(d) && (dXEngine = w9Var.getDXEngine()) != null) {
                    HashMap hashMap = new HashMap();
                    for (String str : d) {
                        DXTemplateItem b = o80.b(str);
                        DXTemplateItem h = dXEngine.h(b);
                        if (h == null || !h.isPreset || h.version != b.version) {
                            hashMap.put(str, b);
                            StringBuilder sb = new StringBuilder();
                            String str2 = "空~";
                            if (h != null) {
                                str2 = ": name=" + h.name + " version=" + h.version + " isPreset=" + h.isPreset;
                            }
                            sb.append("无法映射的cms组件：");
                            sb.append(str);
                            sb.append(",需要的是：name=");
                            sb.append(b.name);
                            sb.append(" version=");
                            sb.append(b.version);
                            sb.append(";但DxEngine返回的是");
                            sb.append(str2);
                            g91.c("LocalCms2Dx", sb.toString());
                        }
                    }
                    if (hashMap.size() > 0) {
                        ToastUtil.i("警告!!!存在CMS组件与Dx内置模板映射关系有误 YuShiLei");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(IImageLoader iImageLoader, TrackProxy.ITrack iTrack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122451678")) {
            ipChange.ipc$dispatch("122451678", new Object[]{iImageLoader, iTrack});
            return;
        }
        qa.a("dm_banner_videoheader_ip");
        qa.a("dm_banner_row1_girl");
        qa.a("dm_banner_with_title");
        qa.a("dm_card_ip_videoalbum");
        qa.a("dm_card_actoralbum");
        qa.a(wj2.DM_COMMON_LOOP_BANNER_CID);
        qa.a(wj2.DM_HOME_BANNER_CID);
        qa.a("live_perform_announce");
        qa.a("dm_livehouse_artist_list");
        qa.a(wj2.DRAMA_CALENDAR_HORIZONTAL_CID);
        qa.a(wj2.DRAMA_LIST_WORTH_TO_SEE);
        qa.a(wj2.DM_COMMON_LOOP_BANNER_CID);
        qa.a("dm_rank_square_rank_header_list");
        qa.a(wj2.DM_FLOATING_ANCHOR_POINT_BAR_CID);
        qa.a("dm_artist_tour_info");
        qa.a("dm_tour_project_more");
        qa.a("dm_artist_group_relate");
        qa.a("dm_common_loop_banner_with_size");
        qa.a("dm_base_content_free_test");
        qa.a(AccountAlbumContract.CID);
        Log.d("launcher", "initTetrisProxy addBlackId new");
        LocalDxTemplate localDxTemplate = new LocalDxTemplate();
        localDxTemplate.name = "damai_musicfestival_brand";
        localDxTemplate.version = 12;
        localDxTemplate.templateUrl = "";
        o80.h(wj2.DX_MUSIC_FESTIVAL_IP_LIST_CID, localDxTemplate);
        LocalDxTemplate localDxTemplate2 = new LocalDxTemplate();
        localDxTemplate2.name = "damai_music_festival_hot_project_list";
        localDxTemplate2.version = 15;
        localDxTemplate2.templateUrl = "";
        o80.h(wj2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID, localDxTemplate2);
        pa.a(new og());
        qa.b(wj2.DISCOVER_FEED_COMPONENT_ID, new s80());
        qa.b(wj2.DISCOVER_FEED_V2_COMPONENT_ID, new r80());
        qa.b(wj2.CIRCLE_FEED_COMPONENT_ID, new zh());
        qa.b("dm_rank_square_project_vertical_list", new xw1());
        qa.b(wj2.CATEGORY_LIST_COMPONENT_ID, new hg());
        qa.b(wj2.DX_MUSIC_FESTIVAL_HOT_PROJECT_LIST_CID, new zf1());
        qa.b(wj2.DX_MUSIC_FESTIVAL_IP_LIST_CID, new ag1());
        qa.b("damai_brand_show_representation", new rc());
        qa.b("dm_home_video", new kx0());
        qa.b("damai_home_grabticket_notice", new zv0());
        qa.b(wj2.DRAMA_CALENDAR_VERTICAL_CID, new iv2());
        qa.b(wj2.PROJECT_BROADCAST_HORIZONTAL_LIST, new lt1());
        qa.b(wj2.DM_CARD_PROJECT_BROADCAST_CID, new mt1());
        qa.b(wj2.DM_PROJECT_FILTER_PANEL_CID, new bu1());
        qa.b(wj2.DM_PROJECT_LIST_BELOW_FILTER_PANEL_CID, new cu1());
        qa.b(wj2.PROJECT_FILTER_OPTION_C_ID, new bu1());
        qa.b(wj2.RANK_FILTER_VIEW_C_ID, new yw1());
        qa.c(wj2.DISCOVER_FEED_COMPONENT_ID, new t80());
        qa.c(wj2.DISCOVER_FEED_V2_COMPONENT_ID, new t80());
        qa.c(wj2.CIRCLE_FEED_COMPONENT_ID, new fi());
        qa.c("dm_rank_square_project_vertical_list", new dx1());
        qa.c(wj2.DM_FLOATING_ANCHOR_POINT_BAR_CID, new re2());
        ComponentPluginType componentPluginType = ComponentPluginType.ONE_CID_2_ONE_PLUGIN;
        ComponentPlugin.registerPlugin(wj2.DM_PROJECT_FILTER_PANEL_CID, componentPluginType, FilterPanelPlugin.class);
        ComponentPlugin.registerPlugin(wj2.DM_FLOATING_ANCHOR_POINT_BAR_CID, componentPluginType, AnchorFloatingPlugin.class);
        ComponentPluginType componentPluginType2 = ComponentPluginType.ONE_SECTION_2_ONE_PLUGIN;
        ComponentPlugin.registerPlugin(wj2.DRAMA_CALENDAR_VERTICAL_CID, componentPluginType2, VerticalDramaByMonthPlugin.class);
        ComponentPlugin.registerPlugin(wj2.MUSIC_FESTIVAL_MAP_COMPONENT_ID, componentPluginType2, MusicFestivalPlugin.class);
        ComponentPlugin.registerPlugin(wj2.DISCOVER_FEED_V2_COMPONENT_PLUGIN_ID, componentPluginType, DiscoverFeedPlugin.class);
        ComponentPlugin.registerPlugin(wj2.VOTE_C_ID, componentPluginType, VoteCardPlugin.class);
        ComponentPlugin.registerPlugin(wj2.PROJECT_FILTER_OPTION_C_ID, componentPluginType2, ProjectFilterPlugin.class);
        ComponentPlugin.registerPlugin(wj2.RANK_FILTER_VIEW_C_ID, componentPluginType2, RankFilterPlugin.class);
        try {
            a.b(iImageLoader);
            TrackProxy.b(iTrack);
            NavigatorProxy.b(new ch1());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TetrisProxyInit", " ======= TetrisProxyInit ERROR ====== ");
        }
    }
}
