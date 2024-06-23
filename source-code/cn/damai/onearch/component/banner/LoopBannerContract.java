package cn.damai.onearch.component.banner;

import com.youku.arch.v3.adapter.VBaseAdapter;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface LoopBannerContract {

    /* compiled from: Taobao */
    public interface Model {
    }

    /* compiled from: Taobao */
    public interface Presenter {
        void onPageChanged(int i);
    }

    /* compiled from: Taobao */
    public interface View {
        void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter);
    }
}
