package cn.damai.projectfilter.filterbtn;

import android.view.View;
import cn.damai.projectfilter.bean.Type;

/* compiled from: Taobao */
public interface FilterBtn {
    Type getType();

    View getView();

    void setState(boolean z);
}
