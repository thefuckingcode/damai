package cn.damai.comment.view;

import android.view.View;
import cn.damai.comment.bean.DmInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface OnItemClickListener {
    void onItemClick(@NotNull View view, int i, @Nullable DmInfo dmInfo);
}
