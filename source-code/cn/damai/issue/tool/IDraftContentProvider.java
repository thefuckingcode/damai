package cn.damai.issue.tool;

import android.app.Activity;
import androidx.annotation.Nullable;
import cn.damai.comment.bean.QueryThemeCliqueInfoBean;
import cn.damai.issue.bean.DraftExtra;
import java.util.List;

/* compiled from: Taobao */
public interface IDraftContentProvider {
    @Nullable
    Activity getDraftActivity();

    List<QueryThemeCliqueInfoBean> getDraftCircle();

    List<QueryThemeCliqueInfoBean> getDraftCircleList();

    @Nullable
    DraftExtra getDraftExtra();

    @Nullable
    String getDraftInput();

    @Nullable
    String getDraftItemType();

    @Nullable
    String getDraftStoreId();

    @Nullable
    String getDraftTheme();

    @Nullable
    String getDraftThemeId();
}
