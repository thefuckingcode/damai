package cn.damai.projectfiltercopy.floatview;

import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.projectfiltercopy.FloatListener;
import cn.damai.projectfiltercopy.bean.Type;
import tb.ni0;

/* compiled from: Taobao */
public interface FloatLayer<T> {
    ni0 getFilterUt();

    FloatListener getListener();

    Type getType();

    View getView();

    void hide();

    void setFilterUt(ni0 ni0);

    void setListener(FloatListener floatListener);

    void show(@Nullable T t);
}
