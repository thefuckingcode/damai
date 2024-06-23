package cn.damai.commonbusiness.search.bean;

import com.alibaba.pictures.bricks.component.project.bean.ProjectItemBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class SearchTourBean implements Serializable {
    public List<SearchTourItem> items;
    public String title;
    public ProjectItemBean topItem;
}
