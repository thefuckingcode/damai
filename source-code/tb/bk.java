package tb;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/* compiled from: Taobao */
public class bk extends p1 {
    public bk() {
        new Rect();
    }

    @Override // com.alibaba.android.vlayout.a, tb.p1
    public void checkAnchorInfo(RecyclerView.State state, VirtualLayoutManager.c cVar, LayoutManagerHelper layoutManagerHelper) {
        if (cVar.c) {
            cVar.a = getRange().e().intValue();
        } else {
            cVar.a = getRange().d().intValue();
        }
    }
}
