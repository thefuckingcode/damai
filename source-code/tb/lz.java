package tb;

import android.content.Context;
import android.view.View;
import com.taobao.android.dinamicx.view.DXRecyclerEmptyView;
import com.taobao.android.dinamicx.widget.f;

/* compiled from: Taobao */
public class lz extends f {
    /* access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXRecyclerEmptyView(context);
    }
}
