package com.alibaba.poplayerconsole.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.poplayer.Domain;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.utils.Monitor;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import com.alibaba.poplayerconsole.lib.Window;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import tb.hn1;
import tb.jl1;

/* compiled from: Taobao */
public class PopLayerInfoLogView extends LinearLayout implements ILogView {
    private int[] mConfigDomains = {2, 3, 1};
    private Spinner mConfigSpinner;
    private int mCurrentConfigDomain = 2;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class a extends ClickableSpan {
        final /* synthetic */ Map a;
        final /* synthetic */ String b;

        a(Map map, String str) {
            this.a = map;
            this.b = str;
        }

        public void onClick(View view) {
            String str;
            Map map = this.a;
            List<BaseConfigItem> list = (List) ((Monitor.a) map.get(this.b + hn1.MONITOR_CONFIG_ITEMS)).b;
            AlertDialog create = new AlertDialog.Builder(PopLayerInfoLogView.this.getContext().getApplicationContext(), 3).setTitle("Current Configuration Items").create();
            ScrollView scrollView = new ScrollView(create.getContext());
            LinearLayout linearLayout = new LinearLayout(create.getContext());
            linearLayout.setPadding(20, 20, 20, 20);
            TextView textView = new TextView(create.getContext());
            textView.setTextSize(14.0f);
            if (list == null || list.size() <= 0) {
                str = "Configuration item list is null";
            } else {
                StringBuilder sb = new StringBuilder();
                for (BaseConfigItem baseConfigItem : list) {
                    sb.append(baseConfigItem.uuid);
                    sb.append(":\r\n");
                    sb.append(baseConfigItem.toString());
                    sb.append("\n\r\n");
                }
                str = sb.toString();
            }
            textView.setText(str);
            linearLayout.addView(textView);
            scrollView.addView(linearLayout);
            create.setView(scrollView);
            create.getWindow().setType(2003);
            create.show();
        }
    }

    public PopLayerInfoLogView(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.console_poplayer_info, (ViewGroup) this, true);
        this.mConfigSpinner = (Spinner) findViewById(R$id.configset_switch);
        String[] strArr = new String[this.mConfigDomains.length];
        for (int i = 0; i < this.mConfigDomains.length; i++) {
            strArr[i] = Domain.toString(this.mConfigDomains[i]) + "ConfigSet";
        }
        this.mConfigSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, R$layout.console_spinner_text, strArr));
        this.mConfigSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /* class com.alibaba.poplayerconsole.view.PopLayerInfoLogView.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (PopLayerInfoLogView.this.mCurrentConfigDomain != PopLayerInfoLogView.this.mConfigDomains[i]) {
                    PopLayerInfoLogView popLayerInfoLogView = PopLayerInfoLogView.this;
                    popLayerInfoLogView.mCurrentConfigDomain = popLayerInfoLogView.mConfigDomains[i];
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void addStatus(SpannableStringBuilder spannableStringBuilder, String str, String str2, Object obj, Object obj2) {
        int length = spannableStringBuilder.length();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str).append(jl1.CONDITION_IF_MIDDLE);
        }
        if (obj == null) {
            obj = new ForegroundColorSpan(-3355444);
        }
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        int length2 = spannableStringBuilder.length();
        if (str2 == null) {
            str2 = "Null";
        }
        spannableStringBuilder.append((CharSequence) str2).append('\n');
        int i = str2 == null ? SupportMenu.CATEGORY_MASK : -7829368;
        if (obj2 == null) {
            obj2 = new ForegroundColorSpan(i);
        }
        spannableStringBuilder.setSpan(obj2, length2, spannableStringBuilder.length(), 33);
    }

    private void updateConfigSet(Map<String, Monitor.a> map) {
        String str;
        String str2;
        String str3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String domain = Domain.toString(this.mCurrentConfigDomain);
        Monitor.a aVar = map.get(domain + hn1.MONITOR_CONFIG_SET);
        if (aVar != null) {
            Object obj = aVar.b;
            if (obj == null) {
                str3 = null;
            } else {
                str3 = obj.toString();
            }
            addStatus(spannableStringBuilder, "", str3, null, new a(map, domain));
        }
        if (this.mCurrentConfigDomain == 1) {
            List list = (List) map.get(domain + hn1.MONITOR_WHITELIST).b;
            if (list == null) {
                str2 = null;
            } else {
                str2 = Arrays.toString(list.toArray());
            }
            addStatus(spannableStringBuilder, "WhiteList", str2, null, null);
        }
        List list2 = (List) map.get(domain + hn1.MONITOR_BLACKLIST).b;
        if (list2 == null) {
            str = null;
        } else {
            str = Arrays.toString(list2.toArray());
        }
        addStatus(spannableStringBuilder, "BlackList", str, null, null);
        TextView textView = (TextView) findViewById(R$id.configset);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
    }

    private void updateCurrentPopLayer(Map<String, Monitor.a> map) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mCurrentConfigDomain == 2) {
            PopLayerViewContainer d = e.f().d();
            if (d == null) {
                addStatus(spannableStringBuilder, "Popped List", null, null, null);
            } else {
                ArrayList<View> all = d.getCanvas().all();
                if (!all.isEmpty()) {
                    int size = all.size();
                    addStatus(spannableStringBuilder, "Popped List", "" + size, null, null);
                    for (int i = 0; i < size; i++) {
                        View view = all.get(i);
                        if (view instanceof PopLayerBaseView) {
                            String str = jl1.ARRAY_START_STR + i + jl1.ARRAY_END_STR;
                            StringBuilder sb = new StringBuilder();
                            sb.append(view.getClass().getSimpleName());
                            sb.append("-");
                            sb.append(view.getVisibility() == 0 ? "visible" : 8 == view.getVisibility() ? "gone" : DAttrConstant.VISIBILITY_INVISIBLE);
                            addStatus(spannableStringBuilder, str, sb.toString(), null, null);
                            spannableStringBuilder.append((CharSequence) ((PopLayerBaseView) view).getInfo()).append('\n');
                        } else {
                            addStatus(spannableStringBuilder, "【" + i + "】", "unknow type layer.", null, null);
                        }
                    }
                }
            }
        } else {
            addStatus(spannableStringBuilder, "Popped List", "Unsupport Domain.", null, null);
        }
        TextView textView = (TextView) findViewById(R$id.current_poplayer);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
    }

    private void updatePopLayerInfo(Map<String, Monitor.a> map) {
        String str;
        String str2;
        String str3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Object obj = map.get("version").b;
        if (obj == null) {
            str = null;
        } else {
            str = obj.toString();
        }
        addStatus(spannableStringBuilder, "Version", str, null, null);
        Object obj2 = map.get(hn1.MONITOR_ADAPTER_VERSION).b;
        if (obj2 == null) {
            str2 = null;
        } else {
            str2 = obj2.toString();
        }
        addStatus(spannableStringBuilder, "AdapterVersion", str2, null, null);
        WeakReference weakReference = (WeakReference) map.get("page").b;
        addStatus(spannableStringBuilder, "NativePage", weakReference.get() == null ? null : weakReference.get().getClass().getName(), null, null);
        Object obj3 = map.get(hn1.MONITOR_NATIVE_URL).b;
        if (obj3 == null) {
            str3 = null;
        } else {
            str3 = obj3.toString();
        }
        addStatus(spannableStringBuilder, "NativeUrl", str3, null, null);
        spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length() - 1);
        ((TextView) findViewById(R$id.status)).setText(spannableStringBuilder);
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void destoryView() {
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public String getTitle() {
        return "PopLayer Info";
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public View getView() {
        return this;
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void update(Window window) throws Throwable {
        Map<String, Monitor.a> d = com.alibaba.poplayerconsole.a.d();
        updatePopLayerInfo(d);
        updateConfigSet(d);
        updateCurrentPopLayer(d);
    }

    public void updateDomain(int i) {
        this.mCurrentConfigDomain = i;
        int i2 = 0;
        while (true) {
            int[] iArr = this.mConfigDomains;
            if (i2 < iArr.length) {
                if (i == iArr[i2]) {
                    this.mConfigSpinner.setSelection(i2);
                }
                i2++;
            } else {
                return;
            }
        }
    }
}
