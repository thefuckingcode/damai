package cn.damai.discover.main.bean;

import cn.damai.tetris.component.discover.bean.NoteBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class FollowBean implements Serializable {
    private static final long serialVersionUID = -2158182927187014891L;
    public List<NoteBean> contentList;
    public int dataType;
    public FollowPeopleBean focusUserInfo;
    public String nextRow;
    public List<FollowRecommendBean> recommendUserLists;
}
