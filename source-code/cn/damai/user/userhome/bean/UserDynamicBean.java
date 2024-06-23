package cn.damai.user.userhome.bean;

import cn.damai.tetris.component.discover.bean.NoteBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class UserDynamicBean implements Serializable {
    public List<NoteBean> card;
    public List<UserDynamicContentBean> contentLabelInfo;
    public boolean hasNext;
}
