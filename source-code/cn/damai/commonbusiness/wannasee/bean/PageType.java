package cn.damai.commonbusiness.wannasee.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import tb.d20;
import tb.f92;

/* compiled from: Taobao */
public enum PageType {
    SHOW("全部演出", 0, "7", -1),
    VALID_SHOW("可购票", 1, "7", 2),
    SCRIPT(ErrControlViewInfo.TYPE_SCRIPT, 2, "25", -1),
    RECORD("现场记录", 3, Constants.VIA_ACT_TYPE_NINETEEN, -1),
    COMPILATION("合辑", 4, "13", -1);
    
    public final String requestType;
    public final int subType;
    public final int tabIndex;
    public final String tabName;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[PageType.values().length];
            a = iArr;
            iArr[PageType.SHOW.ordinal()] = 1;
            a[PageType.VALID_SHOW.ordinal()] = 2;
            a[PageType.RECORD.ordinal()] = 3;
            a[PageType.SCRIPT.ordinal()] = 4;
            a[PageType.COMPILATION.ordinal()] = 5;
        }
    }

    private PageType(String str, int i, String str2, int i2) {
        this.tabName = str;
        this.tabIndex = i;
        this.requestType = str2;
        this.subType = i2;
    }

    public List getListByType(WannaBean wannaBean) {
        RecommendProjects recommendProjects;
        if (wannaBean == null) {
            return null;
        }
        int i = a.a[ordinal()];
        if (i == 1 || i == 2) {
            List<ProjectItemBean> list = wannaBean.items;
            ArrayList arrayList = new ArrayList();
            if (!f92.d(list)) {
                arrayList.addAll(list);
            }
            try {
                if (d20.K() && (recommendProjects = wannaBean.recommendProjects) != null && recommendProjects.isValid()) {
                    int i2 = recommendProjects.index;
                    if (i2 < 0 || i2 > arrayList.size()) {
                        arrayList.add(recommendProjects);
                    } else {
                        arrayList.add(i2, recommendProjects);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        } else if (i == 3) {
            return wannaBean.cards;
        } else {
            if (i == 4) {
                return wannaBean.scriptInfos;
            }
            if (i != 5) {
                return new ArrayList();
            }
            return wannaBean.rankings;
        }
    }

    public String getPageEmptyMsg() {
        int i = a.a[ordinal()];
        if (i == 1 || i == 2) {
            return "你还没有想看的演出哦（-.-）";
        }
        if (i == 3) {
            return "你还没有想看的现场记录哦（-.-）";
        }
        if (i != 4) {
            return i != 5 ? "你还没有想看的内容哦（-.-）" : "你还没有想看的合辑哦（-.-）";
        }
        return "你还没有想玩的剧本哦（-.-）";
    }

    public String getTabName(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.tabName;
        }
        return this.tabName + " " + str;
    }

    public boolean isProject() {
        return this == SHOW;
    }
}
