package cn.damai.projectfilter.listener;

import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.Type;
import java.util.List;

/* compiled from: Taobao */
public interface UiBizListener {
    void onFastFilterChanged(List<FilterBean> list);

    void onMainFilterChanged(Type type);
}
