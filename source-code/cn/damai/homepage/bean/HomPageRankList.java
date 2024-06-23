package cn.damai.homepage.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class HomPageRankList implements Serializable {
    public List<Content> content;
    public String mainTitle;
    public String moreText;

    /* compiled from: Taobao */
    public static class Content implements Serializable {
        public String labelName;
        public List<ProjectVos> projectVos;
        public List<RankLists> rankLists;

        /* compiled from: Taobao */
        public static class ProjectVos implements Serializable {
            public String alg;
            public String categoryName;
            public int position;
            public String priceLow;
            public String projectId;
            public String projectName;
            public String projectPic;
            public String schema;
            public String scm;
        }

        /* compiled from: Taobao */
        public static class RankLists implements Serializable {
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
}
