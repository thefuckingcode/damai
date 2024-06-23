package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXSectionLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class fx extends dx {
    List<Object> e;
    List f = new JSONArray();
    Map<Integer, List<Integer>> g = new HashMap();
    Map<Integer, Integer> h = new HashMap();

    public fx(DXDataSourceLruManager dXDataSourceLruManager) {
        super(dXDataSourceLruManager);
    }

    private void k(int i, int i2) {
        List<Integer> list = this.g.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            this.g.put(Integer.valueOf(i), list);
        }
        if (list.indexOf(Integer.valueOf(i2)) == -1) {
            list.add(Integer.valueOf(i2));
        }
        this.h.put(Integer.valueOf(i2), Integer.valueOf(i));
    }

    @Override // tb.dx
    public List<DXWidgetNode> c(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, @NonNull JSONObject jSONObject, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        List<DXTemplateWidgetNode> list3 = null;
        for (int i3 = 0; i3 < list2.size(); i3++) {
            list3 = j(dXAbsContainerBaseLayout, list2.get(i3), jSONObject, list, i, i2, falcoSpan);
            if (list3 != null && list3.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list3);
                return arrayList;
            }
        }
        if (list3 != null) {
            return null;
        }
        lz lzVar = new lz();
        lzVar.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(lzVar));
        lzVar.setVisibility(2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(lzVar);
        return arrayList2;
    }

    @Override // tb.dx
    public ArrayList<DXWidgetNode> d(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        this.e = list;
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        if (list2 != null && !list2.isEmpty() && list != null && !list.isEmpty()) {
            int i3 = i;
            while (i3 < i2) {
                Object obj = list.get(i3);
                int size = this.f.size();
                List<DXTemplateWidgetNode> list3 = null;
                int i4 = 0;
                while (i4 < list2.size() && (list3 = j(dXAbsContainerBaseLayout, list2.get(i4), obj, list, i3, size, falcoSpan)) == null) {
                    i4++;
                }
                if (list3 == null || list3.size() == 0) {
                    lz lzVar = new lz();
                    lzVar.setDXRuntimeContext(dXAbsContainerBaseLayout.getDXRuntimeContext().cloneWithWidgetNode(lzVar));
                    lzVar.setVisibility(2);
                    arrayList.add(lzVar);
                    this.f.add(list);
                } else {
                    arrayList.addAll(list3);
                }
                i3++;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<DXTemplateWidgetNode> j(DXAbsContainerBaseLayout dXAbsContainerBaseLayout, DXWidgetNode dXWidgetNode, Object obj, List<Object> list, int i, int i2, FalcoSpan falcoSpan) {
        if (!(dXWidgetNode instanceof DXSectionLayout) || !uz.a(dXWidgetNode, dXWidgetNode.getDXRuntimeContext()) || dXWidgetNode.getChildrenCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = i2;
        for (DXWidgetNode dXWidgetNode2 : dXWidgetNode.getChildren()) {
            if (dXWidgetNode2 instanceof DXTemplateWidgetNode) {
                DXTemplateWidgetNode a = a(dXAbsContainerBaseLayout, dXWidgetNode2, obj, list, i3, falcoSpan, true);
                if (a != null) {
                    this.f.add(obj);
                    k(i, i3);
                    i3++;
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }
}
