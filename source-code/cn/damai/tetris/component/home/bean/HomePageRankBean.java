package cn.damai.tetris.component.home.bean;

import android.text.TextUtils;
import cn.damai.tetris.mvp.CommonBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.s71;
import tb.xf2;

/* compiled from: Taobao */
public class HomePageRankBean extends CommonBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 2832511040746010194L;
    public List<Content> content;
    private Map<Integer, List<Content.RankLists>> mDataMap = new HashMap();
    private ArrayList<String> mLabels = new ArrayList<>();
    public String mainTitle;
    public String moreText;

    /* compiled from: Taobao */
    public static class Content implements Serializable {
        private static final long serialVersionUID = 4536303554544785377L;
        public String labelName;
        public List<ProjectVos> projectVos;
        public List<RankLists> rankLists;

        /* compiled from: Taobao */
        public static class ProjectVos implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = -5577181077645389470L;
            public String alg;
            public String categoryName;
            public String guideSubCategoryName;
            public int position;
            public String priceLow;
            public String projectId;
            public String projectName;
            public String projectPic;
            public String schema;
            public String scm;

            public String getCategoryNameCompat() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1820475998")) {
                    return (String) ipChange.ipc$dispatch("1820475998", new Object[]{this});
                } else if (!TextUtils.isEmpty(this.guideSubCategoryName)) {
                    return this.guideSubCategoryName;
                } else {
                    return this.categoryName;
                }
            }
        }

        /* compiled from: Taobao */
        public static class RankLists implements Serializable {
            private static final long serialVersionUID = 7964601925509848513L;
            public String alg;
            public String desc;
            public String id;
            public String pic;
            public int position;
            public String rankType;
            public String scm;
            public String title;
        }
    }

    private Map<Integer, List<Content.RankLists>> parseDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949221873")) {
            return (Map) ipChange.ipc$dispatch("1949221873", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        if (s71.a(this.content)) {
            return this.mDataMap;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.content.size(); i2++) {
            Content content2 = this.content.get(i2);
            if (content2 != null && !TextUtils.isEmpty(content2.labelName) && xf2.e(content2.rankLists) >= 4) {
                hashMap.put(Integer.valueOf(i), content2.rankLists);
                i++;
            }
        }
        return hashMap;
    }

    private ArrayList<String> parseLabels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87929481")) {
            return (ArrayList) ipChange.ipc$dispatch("-87929481", new Object[]{this});
        } else if (s71.a(this.content)) {
            return this.mLabels;
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < this.content.size(); i++) {
                Content content2 = this.content.get(i);
                if (content2 != null && !TextUtils.isEmpty(content2.labelName) && xf2.e(content2.rankLists) >= 4) {
                    arrayList.add(content2.labelName);
                }
            }
            return arrayList;
        }
    }

    public Map<Integer, List<Content.RankLists>> getDataMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807653140")) {
            return (Map) ipChange.ipc$dispatch("1807653140", new Object[]{this});
        }
        Map<Integer, List<Content.RankLists>> map = this.mDataMap;
        if (map == null || map.size() <= 0) {
            return parseDataMap();
        }
        return this.mDataMap;
    }

    public ArrayList<String> getLabels() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "411645492")) {
            return (ArrayList) ipChange.ipc$dispatch("411645492", new Object[]{this});
        } else if (xf2.e(this.mLabels) <= 0) {
            return parseLabels();
        } else {
            return this.mLabels;
        }
    }
}
