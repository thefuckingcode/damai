package cn.damai.mine.mycollect.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class CollectionListResult implements Serializable {
    public List<CollectBean> data;
    public boolean hasNext;
    public int pageNo;
}
