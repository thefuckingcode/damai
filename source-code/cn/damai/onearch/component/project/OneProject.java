package cn.damai.onearch.component.project;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface OneProject {

    /* compiled from: Taobao */
    public interface Model {
        @NotNull
        ProjectItemBean getProject();
    }

    /* compiled from: Taobao */
    public interface Present {
    }

    /* compiled from: Taobao */
    public interface View {
        @NotNull
        ProjectItemViewHolder getViewHolder();
    }
}
