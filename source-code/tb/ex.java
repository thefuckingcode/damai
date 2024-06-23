package tb;

import androidx.annotation.NonNull;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class ex extends dx {
    public ex(DXDataSourceLruManager dXDataSourceLruManager) {
        super(dXDataSourceLruManager);
    }

    @Override // tb.dx
    public DXWidgetNode b(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull Object obj, List<Object> list, List<DXWidgetNode> list2, int i, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode dXTemplateWidgetNode = null;
        if (list2 != null && !list2.isEmpty()) {
            int i2 = 0;
            while (i2 < list2.size() && (dXTemplateWidgetNode = a(dXAbsContainerBaseLayout, list2.get(i2), obj, list, i, falcoSpan, false)) == null) {
                i2++;
            }
        }
        if (dXTemplateWidgetNode != null) {
            return dXTemplateWidgetNode;
        }
        lz lzVar = new lz();
        lzVar.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(dXAbsContainerBaseLayout));
        lzVar.setVisibility(2);
        return lzVar;
    }

    @Override // tb.dx
    public ArrayList<DXWidgetNode> d(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        if (list2 != null && !list2.isEmpty() && list != null && !list.isEmpty()) {
            int i3 = i;
            while (i3 < i2) {
                Object obj = list.get(i3);
                DXTemplateWidgetNode dXTemplateWidgetNode = null;
                int i4 = 0;
                while (i4 < list2.size() && (dXTemplateWidgetNode = a(dXAbsContainerBaseLayout, list2.get(i4), obj, list, i3, falcoSpan, false)) == null) {
                    i4++;
                }
                if (dXTemplateWidgetNode == null) {
                    lz lzVar = new lz();
                    lzVar.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(lzVar));
                    lzVar.setVisibility(2);
                    arrayList.add(lzVar);
                } else {
                    arrayList.add(dXTemplateWidgetNode);
                }
                i3++;
            }
        }
        return arrayList;
    }
}
