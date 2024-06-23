package cn.damai.wantsee;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface GuideUtProvider {
    @Nullable
    Map<String, String> getGuideCloseBtnArgMap();

    @Nullable
    Map<String, String> getGuideExposeArgMap();

    @Nullable
    Map<String, String> getGuideGoMineBtnArgMap();

    @NotNull
    String getSpmB();
}
