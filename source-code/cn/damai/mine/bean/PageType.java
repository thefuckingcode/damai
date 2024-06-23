package cn.damai.mine.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import com.tencent.connect.common.Constants;
import java.util.List;

/* compiled from: Taobao */
public enum PageType {
    RECORD("", 1, Constants.VIA_ACT_TYPE_NINETEEN),
    COMPILATION("", 2, "13");
    
    public final String requestType;
    public final int tabIndex;
    public final String tabName;

    /* compiled from: Taobao */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            int[] iArr = new int[PageType.values().length];
            a = iArr;
            iArr[PageType.RECORD.ordinal()] = 1;
            a[PageType.COMPILATION.ordinal()] = 2;
        }
    }

    private PageType(String str, int i, String str2) {
        this.tabName = str;
        this.tabIndex = i;
        this.requestType = str2;
    }

    public List getListByType(WannaBean wannaBean) {
        if (wannaBean == null) {
            return null;
        }
        int i = a.a[ordinal()];
        if (i == 1) {
            return wannaBean.cards;
        }
        if (i != 2) {
            return wannaBean.items;
        }
        return wannaBean.rankings;
    }

    public String getPageEmptyMsg() {
        return a.a[ordinal()] != 1 ? "你还没有想看的合辑哦（-.-）" : "你还没有想看的现场记录哦（-.-）";
    }

    public String getTabName(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.tabName;
        }
        return this.tabName + " " + str;
    }

    public boolean isProject() {
        return true;
    }
}
