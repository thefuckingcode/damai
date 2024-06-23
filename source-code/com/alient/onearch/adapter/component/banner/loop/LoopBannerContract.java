package com.alient.onearch.adapter.component.banner.loop;

import androidx.exifinterface.media.ExifInterface;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.css.constraint.CssConst;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerContract;", "", ExifInterface.TAG_MODEL, "Presenter", CssConst.CssScenes.VIEW, "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface LoopBannerContract {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerContract$Model;", "", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface Model {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerContract$Presenter;", "", "", "position", "Ltb/ur2;", "onPageChanged", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface Presenter {
        void onPageChanged(int i);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002H&J\u001e\u0010\t\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H&¨\u0006\n"}, d2 = {"Lcom/alient/onearch/adapter/component/banner/loop/LoopBannerContract$View;", "", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "innerAdapter", "Ltb/ur2;", "setAdapter", "", "", "params", "initBannerSetting", "onearch-adapter_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: Taobao */
    public interface View {
        void initBannerSetting(@Nullable Map<String, ? extends Object> map);

        void setAdapter(@Nullable VBaseAdapter<?, ?> vBaseAdapter);
    }
}
