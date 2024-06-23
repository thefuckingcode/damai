package com.alibaba.pictures.moimage;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/moimage/IImageUrlFixer;", "", "", "imageUrl", "", "measureWidth", "measureHeight", "autoFix", "addPrefixIfNeeded", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public interface IImageUrlFixer {
    @Nullable
    String addPrefixIfNeeded(@Nullable String str);

    @Nullable
    String autoFix(@Nullable String str, int i, int i2);
}
