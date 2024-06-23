package cn.damai.projectfilter.floatview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class CategoryFloatLayer$1 extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b a;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247399687")) {
            ipChange.ipc$dispatch("-1247399687", new Object[]{this, rect, view, recyclerView, state});
        } else if (recyclerView.getChildAdapterPosition(view) % 2 == 0) {
            rect.right = this.a.g;
        } else {
            rect.left = this.a.g;
        }
    }
}
