package com.taobao.android.preview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.R$array;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.monitor.DXFontSize;
import com.taobao.android.dinamicx.n;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.vivo.push.PushClientConstants;
import com.youku.arch.v3.data.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.oy0;
import tb.vy;
import tb.w00;

@Keep
/* compiled from: Taobao */
public class DXTemplatePreviewActivity extends AppCompatActivity implements IDXNotificationListener {
    public static final String FONTSIZE_FLAG = "fontSize";
    public static final String PREVIEW_DINAMIC_MODULE = "preview";
    public static final String PREVIEW_INFO = "previewInfo";
    public static final String PREVIEW_TAG = "DXTemplatePreviewActivity";
    private DXTemplatePreviewAdapter adapter;
    JSONArray array;
    private boolean canScrollVertical = true;
    private int currentLevel;
    n engineRouter;
    LinearLayout linearLayout;
    private RecyclerView rvMainContainer;

    @Keep
    /* compiled from: Taobao */
    public interface DXPreviewInterface extends Serializable {
        void previewEngineDidInitialized(n nVar);
    }

    /* compiled from: Taobao */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            DXTemplatePreviewActivity.this.finish();
            DXTemplatePreviewActivity.this.overridePendingTransition(0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends StaggeredGridLayoutManager {
        b(int i, int i2) {
            super(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, androidx.recyclerview.widget.StaggeredGridLayoutManager
        public boolean canScrollVertically() {
            return DXTemplatePreviewActivity.this.canScrollVertical;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DXTemplatePreviewActivity dXTemplatePreviewActivity = DXTemplatePreviewActivity.this;
            dXTemplatePreviewActivity.downLoadMockData(dXTemplatePreviewActivity.getIntent().getStringExtra(DXTemplatePreviewActivity.PREVIEW_INFO));
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DXTemplatePreviewActivity.this.finish();
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class e extends AsyncTask<String, Void, JSONArray> {
        e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public JSONArray doInBackground(String... strArr) {
            try {
                byte[] download = new oy0().download(strArr[0]);
                String str = download != null ? new String(download) : null;
                if (str == null) {
                    return null;
                }
                DXTemplatePreviewActivity dXTemplatePreviewActivity = DXTemplatePreviewActivity.this;
                dXTemplatePreviewActivity.log("respnese.body =" + str);
                return JSON.parseArray(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.size() <= 0) {
                DXTemplatePreviewActivity.this.showErrorDialog();
                return;
            }
            DXTemplatePreviewActivity.this.log("获取mock数据成功");
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject.containsKey("dx_canScrollVertical")) {
                DXTemplatePreviewActivity.this.canScrollVertical = jSONObject.getBoolean("dx_canScrollVertical").booleanValue();
            }
            DXTemplatePreviewActivity.this.initEngineRouter(jSONArray);
            DXTemplatePreviewActivity.this.gotoImplPreviewInterface(jSONArray);
            DXTemplatePreviewActivity.this.refreshUI(jSONArray);
            DXTemplatePreviewActivity.this.downLoadTemplate(jSONArray);
        }
    }

    /* compiled from: Taobao */
    public static class f {
        public String a;
    }

    private void callMethod(f fVar) {
        if (fVar != null && !TextUtils.isEmpty(fVar.a)) {
            try {
                Class<?> cls = Class.forName(fVar.a);
                cls.getMethod("previewEngineDidInitialized", n.class).invoke(cls.newInstance(), this.engineRouter);
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void downLoadMockData(String str) {
        new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void downLoadTemplate(JSONArray jSONArray) {
        boolean z;
        ArrayList arrayList = new ArrayList(jSONArray.size());
        Iterator<Object> it = jSONArray.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                DXTemplateItem dinamicTemplate = getDinamicTemplate((JSONObject) it.next());
                if (dinamicTemplate != null) {
                    arrayList.add(dinamicTemplate);
                }
                if (!z) {
                    if (this.engineRouter.e(dinamicTemplate) != null) {
                        z = true;
                    }
                }
            }
        }
        log("开始下载模版");
        this.engineRouter.d(arrayList);
        if (z) {
            log("模版已经存在，直接刷新");
            this.adapter.notifyDataSetChanged();
        }
    }

    public static DXTemplateItem getDinamicTemplate(JSONObject jSONObject) {
        DXTemplateItem dXTemplateItem = new DXTemplateItem();
        JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.TEMPLATE);
        if (jSONObject2 == null) {
            return null;
        }
        dXTemplateItem.name = jSONObject2.getString("name");
        dXTemplateItem.version = Long.parseLong(jSONObject2.getString("version"));
        dXTemplateItem.templateUrl = jSONObject2.getString("url");
        return dXTemplateItem;
    }

    private List<f> getPreviewInfoList(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i).getJSONObject("__preview__");
            if (!(jSONObject == null || (jSONArray2 = jSONObject.getJSONArray("android")) == null)) {
                for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        f fVar = new f();
                        fVar.a = jSONObject2.getString(PushClientConstants.TAG_CLASS_NAME);
                        jSONObject2.getString("bundlerPath");
                        arrayList.add(fVar);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gotoImplPreviewInterface(JSONArray jSONArray) {
        log("开始进行组建注册");
        List<f> previewInfoList = getPreviewInfoList(jSONArray);
        if (previewInfoList != null) {
            for (int i = 0; i < previewInfoList.size(); i++) {
                callMethod(previewInfoList.get(i));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L_0x001e;
     */
    private void initEngineRouter(JSONArray jSONArray) {
        String str;
        JSONObject jSONObject;
        if (!(jSONArray == null || (jSONObject = jSONArray.getJSONObject(0).getJSONObject("__preview__")) == null)) {
            str = jSONObject.getString("bizType");
        }
        str = PREVIEW_DINAMIC_MODULE;
        n nVar = new n(new DXEngineConfig.b(str).v(true).w(2).t());
        this.engineRouter = nVar;
        nVar.l(this);
        log("完成engine的初始化 " + this.engineRouter.a());
    }

    private void initRecyclerView() {
        this.rvMainContainer.setLayoutManager(new b(2, 1));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void log(String str) {
        Log.e(PREVIEW_TAG, str + " : " + System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void refreshUI(JSONArray jSONArray) {
        log("refreshUI");
        this.array = jSONArray;
        DXTemplatePreviewAdapter dXTemplatePreviewAdapter = this.adapter;
        if (dXTemplatePreviewAdapter == null) {
            DXTemplatePreviewAdapter dXTemplatePreviewAdapter2 = new DXTemplatePreviewAdapter(this, jSONArray, this.rvMainContainer, this.engineRouter);
            this.adapter = dXTemplatePreviewAdapter2;
            this.rvMainContainer.setAdapter(dXTemplatePreviewAdapter2);
            return;
        }
        dXTemplatePreviewAdapter.h(jSONArray);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("获取mock数据失败，是否重试？").setTitle(PurchaseConstants.NORMAL_WARNING_TITLE);
        builder.setPositiveButton("重试", new c());
        builder.setNegativeButton(PurchaseConstants.PART_SUCCESS_CANCEL, new d());
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_template_preview);
        log("onCreate");
        overridePendingTransition(0, 0);
        this.currentLevel = DXFontSize.b().a();
        this.rvMainContainer = (RecyclerView) findViewById(R$id.rv_main_container);
        this.linearLayout = (LinearLayout) findViewById(R$id.ll);
        ((TextView) findViewById(R$id.dinamic_preview_back)).setOnClickListener(new a());
        Spinner spinner = (Spinner) findViewById(R$id.fontSize_select);
        initEngineRouter(null);
        initRecyclerView();
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, R$array.preview_array, R$layout.fontsize_spinner_item);
        createFromResource.setDropDownViewResource(17367049);
        spinner.setAdapter((SpinnerAdapter) createFromResource);
        spinner.setSelection(this.currentLevel, true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /* class com.taobao.android.preview.DXTemplatePreviewActivity.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                TextView textView = (TextView) view;
                textView.setTextColor(-16777216);
                textView.setGravity(17);
                DXFontSize.b().i(i);
                DXTemplatePreviewActivity dXTemplatePreviewActivity = DXTemplatePreviewActivity.this;
                if (dXTemplatePreviewActivity.array != null) {
                    dXTemplatePreviewActivity.engineRouter.g().R();
                    DXTemplatePreviewActivity dXTemplatePreviewActivity2 = DXTemplatePreviewActivity.this;
                    dXTemplatePreviewActivity2.refreshUI(dXTemplatePreviewActivity2.array);
                    DXTemplatePreviewActivity.this.adapter.notifyDataSetChanged();
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra(PREVIEW_INFO);
            String stringExtra2 = intent.getStringExtra("fontSize");
            if (!TextUtils.isEmpty(stringExtra2) ? Boolean.valueOf(stringExtra2).booleanValue() : false) {
                spinner.setVisibility(0);
            } else {
                spinner.setVisibility(8);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                log("onCreate info :" + stringExtra);
                downLoadMockData(stringExtra);
                return;
            }
            finish();
            log("onCreate info isEmpty");
        } catch (Throwable th) {
            finish();
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
        DXFontSize.b().i(this.currentLevel);
        this.engineRouter.g().A();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        log("onNewIntent");
        try {
            String stringExtra = intent.getStringExtra(PREVIEW_INFO);
            if (!TextUtils.isEmpty(stringExtra)) {
                log("onNewIntent" + stringExtra);
                downLoadMockData(stringExtra);
                return;
            }
            finish();
            log("onNewIntent info isEmpty");
        } catch (Throwable th) {
            finish();
            th.printStackTrace();
        }
    }

    @Override // com.taobao.android.dinamicx.notification.IDXNotificationListener
    public void onNotificationListener(vy vyVar) {
        if (vyVar != null) {
            List<w00> list = vyVar.c;
            if (list == null || list.size() <= 0) {
                List<DXTemplateItem> list2 = vyVar.a;
                if (list2 != null && list2.size() > 0) {
                    log("收到下载新请求开始刷新" + vyVar.a.get(0).toString());
                }
            } else if (vyVar.c.get(0).c == 1000) {
                this.adapter.b();
                log("收到降级刷新请求开始刷新: " + vyVar.c.get(0).c);
            } else {
                log(" 收到 templateUpdateRequestList: " + vyVar.c.get(0).c);
            }
            refreshUI(this.array);
            this.adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        log("onResume");
    }
}
