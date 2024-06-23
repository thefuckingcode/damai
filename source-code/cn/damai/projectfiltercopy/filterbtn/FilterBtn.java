package cn.damai.projectfiltercopy.filterbtn;

import android.view.View;
import cn.damai.projectfiltercopy.bean.Type;

/* compiled from: Taobao */
public interface FilterBtn {
    Type getType();

    View getView();

    void setState(boolean z);
}
