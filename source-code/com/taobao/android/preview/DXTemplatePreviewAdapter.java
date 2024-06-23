package com.taobao.android.preview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.n;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.youku.arch.v3.data.Constants;
import java.util.HashMap;
import tb.ry;
import tb.vx;
import tb.xz;

/* compiled from: Taobao */
public class DXTemplatePreviewAdapter extends RecyclerView.Adapter<PreviewViewHolder> {
    private JSONArray a;
    private RecyclerView b;
    n c;
    Context d;
    private int e = 0;
    private HashMap<Integer, Integer> f = new HashMap<>();
    private HashMap<String, Integer> g = new HashMap<>(128);
    private HashMap<Integer, DXTemplateItem> h = new HashMap<>(128);

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends DXRootView.a {
        final /* synthetic */ DXRootView a;

        a(DXRootView dXRootView) {
            this.a = dXRootView;
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.android.dinamicx.DXRootView.a
        public void c(DXRootView dXRootView) {
            DXTemplatePreviewAdapter.this.c.g().B(dXRootView);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.android.dinamicx.DXRootView.a
        public void d(DXRootView dXRootView) {
            DXTemplatePreviewAdapter.this.c.g().C(dXRootView);
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.android.dinamicx.DXRootView.a
        public void i(@NonNull View view, int i) {
            if (i == 0) {
                DXTemplatePreviewAdapter.this.c.g().B(this.a);
            } else {
                DXTemplatePreviewAdapter.this.c.g().C(this.a);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.taobao.android.dinamicx.DXRootView.a
        public void j(DXRootView dXRootView, int i) {
            if (i == 0) {
                DXTemplatePreviewAdapter.this.c.g().B(dXRootView);
            } else {
                DXTemplatePreviewAdapter.this.c.g().C(dXRootView);
            }
        }
    }

    public DXTemplatePreviewAdapter(Context context, JSONArray jSONArray, RecyclerView recyclerView, n nVar) {
        JSONArray jSONArray2 = new JSONArray();
        this.a = jSONArray2;
        jSONArray2.addAll(jSONArray);
        this.c = nVar;
        this.b = recyclerView;
        this.d = context;
        a();
    }

    private void a() {
        for (int i = 0; i < this.a.size(); i++) {
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            JSONObject jSONObject = (JSONObject) this.a.getJSONObject(i).get(Constants.TEMPLATE);
            if (jSONObject != null) {
                dXTemplateItem.version = Long.parseLong(jSONObject.getString("version"));
                dXTemplateItem.name = jSONObject.getString("name");
                dXTemplateItem.templateUrl = jSONObject.getString("url");
                String identifier = dXTemplateItem.getIdentifier();
                if (this.g.containsKey(identifier)) {
                    this.f.put(Integer.valueOf(i), this.g.get(identifier));
                } else {
                    DXTemplateItem e2 = this.c.e(dXTemplateItem);
                    if (e2 == null) {
                        this.f.put(Integer.valueOf(i), -1);
                    } else {
                        String identifier2 = e2.getIdentifier();
                        if (this.g.containsKey(identifier2)) {
                            this.f.put(Integer.valueOf(i), this.g.get(identifier2));
                        } else {
                            int i2 = this.e + 1;
                            this.e = i2;
                            this.g.put(identifier2, Integer.valueOf(i2));
                            this.h.put(Integer.valueOf(this.e), e2);
                            this.f.put(Integer.valueOf(i), Integer.valueOf(this.e));
                        }
                    }
                }
            }
        }
    }

    public static View c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        return frameLayout;
    }

    private boolean d(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return false;
        }
        if (dXTemplateItem.getFileVersion() == 30000) {
            return true;
        }
        if (dXTemplateItem.getFileVersion() == 20000) {
            return false;
        }
        if (TextUtils.isEmpty(dXTemplateItem.templateUrl) || (!dXTemplateItem.templateUrl.endsWith(".zip") && !dXTemplateItem.templateUrl.contains(".zip"))) {
            return TextUtils.isEmpty(dXTemplateItem.templateUrl) && dXTemplateItem.version >= 0;
        }
        return true;
    }

    private void g(DXRootView dXRootView) {
        this.c.g().I(dXRootView, new a(dXRootView));
    }

    public boolean b() {
        this.g.clear();
        return true;
    }

    /* renamed from: e */
    public void onBindViewHolder(PreviewViewHolder previewViewHolder, int i) {
        if (getItemViewType(i) != -1) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putAll((JSONObject) this.a.get(i));
                xz<DXRootView> n = this.c.n(this.d, jSONObject, (DXRootView) previewViewHolder.itemView, 0, 0, null);
                if (n != null && n.c()) {
                    Log.e(ry.TAG, n.a().c.toString());
                }
            } catch (Exception e2) {
                vx.b(e2);
            }
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) previewViewHolder.itemView.getLayoutParams();
            String string = this.a.getJSONObject(i).getJSONObject(Constants.TEMPLATE).getString("columnType");
            layoutParams.setFullSpan(TextUtils.equals(string, "one") || TextUtils.isEmpty(string));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076  */
    /* renamed from: f */
    public PreviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        ViewGroup.LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        T t;
        Exception e2;
        T t2;
        if (i == -1) {
            view = c(viewGroup.getContext());
        } else {
            DXTemplateItem dXTemplateItem = this.h.get(Integer.valueOf(i));
            if (dXTemplateItem != null) {
                try {
                    xz<DXRootView> c2 = this.c.c(this.d, viewGroup, dXTemplateItem);
                    if (!(c2 == null || (t2 = c2.a) == null)) {
                        t = t2;
                        try {
                            if (d(dXTemplateItem)) {
                                g(t);
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            Log.e(DXTemplatePreviewActivity.PREVIEW_TAG, "createViewHolder failed", e2);
                            view = t;
                            if (view == null) {
                            }
                            PreviewViewHolder previewViewHolder = new PreviewViewHolder(view, null);
                            layoutParams = previewViewHolder.itemView.getLayoutParams();
                            if (layoutParams != null) {
                            }
                            previewViewHolder.itemView.setLayoutParams(layoutParams2);
                            return previewViewHolder;
                        }
                        view = t;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    t = null;
                    Log.e(DXTemplatePreviewActivity.PREVIEW_TAG, "createViewHolder failed", e2);
                    view = t;
                    if (view == null) {
                    }
                    PreviewViewHolder previewViewHolder2 = new PreviewViewHolder(view, null);
                    layoutParams = previewViewHolder2.itemView.getLayoutParams();
                    if (layoutParams != null) {
                    }
                    previewViewHolder2.itemView.setLayoutParams(layoutParams2);
                    return previewViewHolder2;
                }
            }
            view = null;
        }
        if (view == null) {
            view = c(viewGroup.getContext());
            Toast.makeText(viewGroup.getContext(), "Preview template failed", 0).show();
        }
        PreviewViewHolder previewViewHolder22 = new PreviewViewHolder(view, null);
        layoutParams = previewViewHolder22.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams2 = this.b.getLayoutManager().generateLayoutParams(layoutParams);
        } else {
            layoutParams2 = this.b.getLayoutManager().generateDefaultLayoutParams();
        }
        previewViewHolder22.itemView.setLayoutParams(layoutParams2);
        return previewViewHolder22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        JSONArray jSONArray = this.a;
        if (jSONArray != null) {
            return jSONArray.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Integer num = this.f.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public void h(JSONArray jSONArray) {
        JSONArray jSONArray2 = this.a;
        if (jSONArray2 != null) {
            jSONArray2.clear();
            this.a.addAll(jSONArray);
        } else {
            JSONArray jSONArray3 = new JSONArray();
            this.a = jSONArray3;
            jSONArray3.addAll(jSONArray);
        }
        a();
    }
}
