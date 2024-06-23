package cn.damai.user.brand;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.v50;

/* compiled from: Taobao */
public class BrandViewBinding$Decoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;

    BrandViewBinding$Decoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052851868")) {
            ipChange.ipc$dispatch("1052851868", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = v50.a(view.getContext(), 9.0f);
        rect.left = 0;
    }
}
