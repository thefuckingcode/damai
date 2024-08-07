package cn.damai.tetris.component.home.bean;

import cn.damai.tetris.mvp.CommonBean;
import java.util.List;

/* compiled from: Taobao */
public class HomeTitleBean extends CommonBean {
    private static final long serialVersionUID = -6124889432413646523L;
    public List<Title> mainTitles;
    public String title;

    /* compiled from: Taobao */
    public static class Title {
        public String dispatchCardCode;
        public String groupId;
        public String icon;
        public String jsonIcon;
        public String name;
    }
}
