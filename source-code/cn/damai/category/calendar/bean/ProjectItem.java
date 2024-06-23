package cn.damai.category.calendar.bean;

import cn.damai.category.category.bean.CategoryItemRankBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import java.io.Serializable;

/* compiled from: Taobao */
public class ProjectItem implements Serializable {
    private static final long serialVersionUID = -8894216253807048222L;
    public boolean hasCurrentCity = true;
    public int index;
    public boolean isCurrentCity = true;
    public ProjectItemBean projectItemBean;
    public CategoryItemRankBean rankBean;
    public int type = 4;
}
