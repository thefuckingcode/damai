package tb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import com.alibaba.android.ultron.vfw.downgrade.IDowngradeSupport;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.AliLogInterface;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.n;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.weex.ui.component.WXImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class p80 implements IViewHolderProvider {
    public static final String KEY_FESTRUE_COMPONT = "componentRender";
    public static final String KEY_FESTRUE_VERSION = "1.0";
    public static final String TAG_DINAMICX_VIEW_COMPONENT = "DinamicXComponent";
    private static final Boolean d = Boolean.FALSE;
    private c a;
    private wv2 b;
    private ViewGroup c;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a implements DialogInterface.OnClickListener {
        final /* synthetic */ View a;
        final /* synthetic */ String b;

        a(p80 p80, View view, String str) {
            this.a = view;
            this.b = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((ClipboardManager) this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.b));
            Toast.makeText(this.a.getContext(), "URL已复制成功！", 0).show();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b implements View.OnLongClickListener {
        final /* synthetic */ Dialog a;

        b(p80 p80, Dialog dialog) {
            this.a = dialog;
        }

        public boolean onLongClick(View view) {
            this.a.show();
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class c {
        private wv2 a;
        private int b = 0;
        private ArrayMap<String, Integer> c = new ArrayMap<>();
        private ArrayMap<Integer, DXTemplateItem> d = new ArrayMap<>();
        private ArrayMap<Integer, ArrayList<IDMComponent>> e = new ArrayMap<>();

        public c(wv2 wv2) {
            this.a = wv2;
        }

        public ArrayList<IDMComponent> a(int i) {
            return this.e.get(Integer.valueOf(i));
        }

        public DXTemplateItem b(int i) {
            return this.d.get(Integer.valueOf(i));
        }

        public int c(IDMComponent iDMComponent) {
            DXTemplateItem a2;
            if (iDMComponent == null || iDMComponent.getContainerInfo() == null || (a2 = ((n80) ((uj2) this.a.getService(uj2.class)).b(iDMComponent.getContainerType())).a(iDMComponent.getContainerInfo().getString("name"))) == null) {
                return -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a2.name);
            sb.append(a2.version);
            Integer num = this.c.get(sb.toString());
            if (num == null) {
                int i = this.b;
                this.b = i + 1;
                num = Integer.valueOf(i);
                this.c.put(sb.toString(), num);
                this.d.put(num, a2);
                ArrayList<IDMComponent> arrayList = new ArrayList<>();
                arrayList.add(iDMComponent);
                this.e.put(num, arrayList);
            } else {
                this.e.get(num).add(iDMComponent);
            }
            return num.intValue();
        }
    }

    public p80(wv2 wv2) {
        this.b = wv2;
        this.a = new c(wv2);
        DTemplateManager.q(this.b.p()).p(DTemplateManager.CacheStrategy.STRATEGY_ALLOW_VERSION_DEGRADE);
        g();
    }

    private View a(View view, DXTemplateItem dXTemplateItem) {
        String str;
        String str2;
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        String str3 = "";
        if (dXTemplateItem != null) {
            String str4 = dXTemplateItem.name;
            str2 = String.valueOf(dXTemplateItem.version);
            str3 = dXTemplateItem.templateUrl;
            str = str4;
        } else {
            str = str3;
            str2 = str;
        }
        AlertDialog.Builder title = new AlertDialog.Builder(view.getContext()).setTitle(str);
        frameLayout.setOnLongClickListener(new b(this, title.setMessage("version: " + str2 + StringUtils.LF + "url: " + str3).setPositiveButton("复制URL", new a(this, view, str3)).create()));
        frameLayout.addView(view);
        return frameLayout;
    }

    private View b(View view, DXTemplateItem dXTemplateItem) {
        String str;
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        String str2 = "";
        if (dXTemplateItem != null) {
            str2 = dXTemplateItem.name;
            str = String.valueOf(dXTemplateItem.version);
        } else {
            str = str2;
        }
        TextView textView = new TextView(view.getContext());
        textView.setText("d: " + str2 + " : " + str);
        textView.setTextColor(858993459);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 48));
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        view.setTag("DXRootView");
        frameLayout.addView(view);
        frameLayout.addView(textView);
        return frameLayout;
    }

    private void c(long j, DXTemplateItem dXTemplateItem) {
        if (d.booleanValue()) {
            String str = dXTemplateItem.name;
            long currentTimeMillis = System.currentTimeMillis() - j;
            AliLogInterface c2 = m4.c();
            if (c2 != null) {
                c2.logd("ultron-view-kit", "templateName: " + str + "\n create duration -------> " + currentTimeMillis);
            }
        }
    }

    private void d(long j, IDMComponent iDMComponent) {
        if (d.booleanValue()) {
            String tag = iDMComponent.getTag();
            String type = iDMComponent.getType();
            String string = iDMComponent.getContainerInfo().getString("name");
            long currentTimeMillis = System.currentTimeMillis() - j;
            tr2.a("ultron-view-kit", "tag: " + tag + ", type: " + type + ", templateName: " + string + "\n bind duration --------> " + currentTimeMillis);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0148  */
    private RecyclerViewHolder e(ViewGroup viewGroup, DXTemplateItem dXTemplateItem, List<IDMComponent> list) {
        Exception e;
        n d2 = this.b.n().d();
        View view = null;
        if (dXTemplateItem != null) {
            try {
                try {
                    xz<DXRootView> c2 = d2.c(viewGroup.getContext(), viewGroup, dXTemplateItem);
                    if (!c2.c()) {
                        T t = c2.a;
                        if (!t30.a(this.b.l())) {
                            view = t;
                        } else if (t != null && this.b.o() == 1001) {
                            view = b(t, dXTemplateItem);
                        } else if (t != null && this.b.o() == 1002) {
                            view = a(t, dXTemplateItem);
                        }
                    } else {
                        tr2.b("DinamicXViewHolderProvider", "createViewHolderInternal", "realTemplate", dXTemplateItem.name, String.valueOf(dXTemplateItem.version));
                        tr2.b("DinamicXViewHolderProvider", "createViewHolderInternal", WXImage.ERRORDESC, e80.a(c2.a()));
                        h(list, true);
                        String k = this.b.k();
                        String a2 = e80.a(c2.a());
                        UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "createViewHolderError", "1.0", k, null, null, "createViewHolderError$" + dXTemplateItem.name, a2);
                        if (t30.a(this.b.l())) {
                            AlertDialog create = new AlertDialog.Builder(this.b.l()).create();
                            create.setTitle("模板create错误");
                            create.setMessage("模板： " + dXTemplateItem.name + StringUtils.LF + a2);
                            create.show();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    h(list, true);
                    String k2 = this.b.k();
                    UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "createViewHolderException", "1.0", k2, null, null, "createViewHolderExp$" + dXTemplateItem.name, e.getMessage());
                    if (view != null) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                h(list, true);
                String k22 = this.b.k();
                UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "createViewHolderException", "1.0", k22, null, null, "createViewHolderExp$" + dXTemplateItem.name, e.getMessage());
                if (view != null) {
                }
            }
        }
        if (view != null) {
            return new RecyclerViewHolder(view);
        }
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(jw2.a(viewGroup.getContext()));
        recyclerViewHolder.d(true);
        return recyclerViewHolder;
    }

    private void g() {
        try {
            this.b.n().f(my.a("handleDinamicXEvent"), new m80());
            this.b.n().g("handleDinamicXEvent", new l80());
        } catch (DinamicException e) {
            tr2.b("registerEventHandler error", e.toString());
        }
    }

    private void h(List<IDMComponent> list, boolean z) {
        if (!(list == null || list.isEmpty())) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).getExtMap().put(IDowngradeSupport.KEY_DOWNGRADE_STATE, Boolean.valueOf(z));
            }
        }
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void bindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent) {
        DXRootView dXRootView;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject containerInfo = iDMComponent.getContainerInfo();
        String str2 = "";
        String string = containerInfo != null ? containerInfo.getString("name") : str2;
        try {
            JSONObject data = iDMComponent.getData();
            int modifiedCount = iDMComponent.getModifiedCount();
            Map<String, Object> a2 = recyclerViewHolder.a(iDMComponent);
            a2.putAll(this.b.m());
            View view = recyclerViewHolder.itemView;
            n d2 = this.b.n().d();
            int f = d00.f();
            int e = d00.e();
            if (view instanceof DXRootView) {
                dXRootView = (DXRootView) view;
            } else {
                dXRootView = (DXRootView) view.findViewWithTag("DXRootView");
            }
            ViewGroup viewGroup = this.c;
            xz<DXRootView> n = d2.n(this.b.l(), data, dXRootView, viewGroup != null ? View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824) : f, e, a2);
            if (dXRootView != null && t30.a(this.b.l())) {
                dXRootView.setImportantForAccessibility(1);
                if (TextUtils.isEmpty(iDMComponent.getTag())) {
                    str = iDMComponent.getId();
                } else {
                    str = iDMComponent.getKey();
                }
                dXRootView.setContentDescription(str);
            }
            if (n != null && n.c()) {
                if (containerInfo != null) {
                    str2 = containerInfo.toJSONString();
                }
                tr2.b("DinamicXViewHolderProvider", "bindData", "error component", iDMComponent.getTag(), iDMComponent.getType(), str2);
                String a3 = e80.a(n.a());
                tr2.b("DinamicXViewHolderProvider", "bindData", WXImage.ERRORDESC, a3);
                String k = this.b.k();
                UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "bindDataError", "1.0", k, null, null, "bindDataError$" + string, a3);
                if (t30.a(this.b.l())) {
                    AlertDialog create = new AlertDialog.Builder(this.b.l()).create();
                    create.setTitle("模板bind错误");
                    create.setMessage("模板： " + string + StringUtils.LF + a3);
                    create.show();
                }
            }
            recyclerViewHolder.e(modifiedCount);
        } catch (Exception e2) {
            tr2.b("DinamicXViewHolderProvider", "bindData", WXImage.ERRORDESC, e2.getMessage());
            String k2 = this.b.k();
            UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "bindDataException", "1.0", k2, null, null, "bindDataExp$" + string, e2.getMessage());
        }
        d(currentTimeMillis, iDMComponent);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public RecyclerViewHolder createViewHolder(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = viewGroup;
        DXTemplateItem b2 = this.a.b(i);
        RecyclerViewHolder e = e(viewGroup, b2, this.a.a(i));
        if (b2 == null) {
            return e;
        }
        c(currentTimeMillis, b2);
        return e;
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void destroy() {
    }

    public DXTemplateItem f(int i) {
        return this.a.b(i);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public int getItemViewType(IDMComponent iDMComponent) {
        return this.a.c(iDMComponent);
    }
}
