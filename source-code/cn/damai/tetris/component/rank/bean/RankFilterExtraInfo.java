package cn.damai.tetris.component.rank.bean;

import android.text.TextUtils;
import android.util.Pair;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.s41;

/* compiled from: Taobao */
public class RankFilterExtraInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean hasProject = false;
    public String rankProjectLayerId;
    public String rankProjectSectionId;
    public boolean shouldShowOtherCityTip = false;
    public String spmB;

    public static Pair<BaseLayer, BaseSection> findRankProjectBs(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831933132")) {
            return (Pair) ipChange.ipc$dispatch("831933132", new Object[]{baseResponse});
        } else if (baseResponse == null || f92.d(baseResponse.layers)) {
            return null;
        } else {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                BaseLayer next = it.next();
                List<BaseSection> sections = next.getSections();
                if (!f92.d(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals("dm_rank_square_project_vertical_list", baseSection.getComponentId())) {
                            return new Pair<>(next, baseSection);
                        }
                    }
                    continue;
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    public static RankFilterExtraInfo obtainFromBaseRes(BaseResponse baseResponse) {
        GlobalConfig globalConfig;
        boolean z;
        Exception e;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        boolean z3 = false;
        if (AndroidInstantRuntime.support(ipChange, "-1937233209")) {
            return (RankFilterExtraInfo) ipChange.ipc$dispatch("-1937233209", new Object[]{baseResponse});
        }
        RankFilterExtraInfo rankFilterExtraInfo = new RankFilterExtraInfo();
        Pair<BaseLayer, BaseSection> findRankProjectBs = findRankProjectBs(baseResponse);
        if (findRankProjectBs != null) {
            try {
                NodeData item = ((BaseSection) findRankProjectBs.second).getItem();
                if (item != null) {
                    String string = item.getString("cityId");
                    JSONArray jSONArray = item.getJSONArray("itemDOList");
                    boolean z4 = jSONArray != null && jSONArray.size() > 0;
                    try {
                        if (!TextUtils.equals("0", string) || !z4) {
                            z2 = false;
                        }
                        z3 = z4;
                    } catch (Exception e2) {
                        z = z4;
                        e = e2;
                        e.printStackTrace();
                        z3 = z;
                        z2 = false;
                        globalConfig = baseResponse.globalConfig;
                        if (globalConfig != null) {
                        }
                        rankFilterExtraInfo.spmB = "ranklist_square";
                        rankFilterExtraInfo.hasProject = z3;
                        rankFilterExtraInfo.rankProjectLayerId = ((BaseLayer) findRankProjectBs.first).getLayerId();
                        rankFilterExtraInfo.rankProjectSectionId = ((BaseSection) findRankProjectBs.second).getSectionId();
                        rankFilterExtraInfo.shouldShowOtherCityTip = z2;
                        return rankFilterExtraInfo;
                    }
                    globalConfig = baseResponse.globalConfig;
                    if (globalConfig != null || TextUtils.isEmpty(globalConfig.pageName)) {
                        rankFilterExtraInfo.spmB = "ranklist_square";
                    } else {
                        rankFilterExtraInfo.spmB = baseResponse.globalConfig.pageName;
                    }
                    rankFilterExtraInfo.hasProject = z3;
                    rankFilterExtraInfo.rankProjectLayerId = ((BaseLayer) findRankProjectBs.first).getLayerId();
                    rankFilterExtraInfo.rankProjectSectionId = ((BaseSection) findRankProjectBs.second).getSectionId();
                    rankFilterExtraInfo.shouldShowOtherCityTip = z2;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                e.printStackTrace();
                z3 = z;
                z2 = false;
                globalConfig = baseResponse.globalConfig;
                if (globalConfig != null) {
                }
                rankFilterExtraInfo.spmB = "ranklist_square";
                rankFilterExtraInfo.hasProject = z3;
                rankFilterExtraInfo.rankProjectLayerId = ((BaseLayer) findRankProjectBs.first).getLayerId();
                rankFilterExtraInfo.rankProjectSectionId = ((BaseSection) findRankProjectBs.second).getSectionId();
                rankFilterExtraInfo.shouldShowOtherCityTip = z2;
                return rankFilterExtraInfo;
            }
            z2 = false;
            globalConfig = baseResponse.globalConfig;
            if (globalConfig != null) {
            }
            rankFilterExtraInfo.spmB = "ranklist_square";
            rankFilterExtraInfo.hasProject = z3;
            rankFilterExtraInfo.rankProjectLayerId = ((BaseLayer) findRankProjectBs.first).getLayerId();
            rankFilterExtraInfo.rankProjectSectionId = ((BaseSection) findRankProjectBs.second).getSectionId();
            rankFilterExtraInfo.shouldShowOtherCityTip = z2;
        }
        return rankFilterExtraInfo;
    }

    public static RankFilterExtraInfo obtainFromSection(ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1805110721")) {
            return (RankFilterExtraInfo) ipChange.ipc$dispatch("1805110721", new Object[]{iSection});
        }
        RankFilterExtraInfo rankFilterExtraInfo = null;
        if (iSection != null) {
            try {
                if (iSection.getItem() != null) {
                    rankFilterExtraInfo = (RankFilterExtraInfo) s41.d(iSection.getItem().getJSONObject("itemInfo"), RankFilterExtraInfo.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rankFilterExtraInfo == null ? new RankFilterExtraInfo() : rankFilterExtraInfo;
    }
}
