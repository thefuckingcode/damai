package cn.damai.homepage.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class HomePageDetailedList implements Serializable {
    public List<DetailedListItem> content;
    public List<DetailedListItem> discount;
    public String mainTitle;

    /* compiled from: Taobao */
    public static class DetailedListItem {
        public String backgroundPic;
        public String detailedListId;
        public int position;
        public String projectPic;
        public String schema;
        public String subTitle;
        public String title;
        public String total;
        public String type;
    }
}
