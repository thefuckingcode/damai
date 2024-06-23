package cn.damai.projectfilter.floatview;

import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.projectfilter.FloatListener;
import cn.damai.projectfilter.bean.Type;
import tb.oi0;

/* compiled from: Taobao */
public interface FloatLayer<T> {
    oi0 getFilterUt();

    FloatListener getListener();

    Type getType();

    View getView();

    void hide();

    void setFilterUt(oi0 oi0);

    void setListener(FloatListener floatListener);

    void show(@Nullable T t);
}
