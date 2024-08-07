package cn.damai.ultron.secondpage.phonecode;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.secondpage.phonecode.bean.DmPhoneCodeBean;
import cn.damai.ultron.utils.DmUltronChooseListenerImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.xf2;

/* compiled from: Taobao */
public class DmPhoneCodeAdapter extends RecyclerView.Adapter<CodeViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmPhoneCodeBean> a;
    private String b;
    private Context c;
    private DmUltronChooseListenerImpl<String> d;

    /* compiled from: Taobao */
    public class CodeViewHolder extends RecyclerView.ViewHolder {
        private View a;
        private TextView b;
        private CheckBox c;

        public CodeViewHolder(DmPhoneCodeAdapter dmPhoneCodeAdapter, View view) {
            super(view);
            this.a = view;
            this.b = (TextView) view.findViewById(R$id.text_name);
            this.c = (CheckBox) view.findViewById(R$id.checkbox);
        }
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1321654360")) {
                ipChange.ipc$dispatch("1321654360", new Object[]{this, view});
                return;
            }
            DmPhoneCodeAdapter.this.d.chooseItemListener(String.valueOf(this.a));
        }
    }

    public DmPhoneCodeAdapter(Context context, List<DmPhoneCodeBean> list, String str, DmUltronChooseListenerImpl<String> dmUltronChooseListenerImpl) {
        this.c = context;
        this.a = list;
        this.b = str;
        this.d = dmUltronChooseListenerImpl;
    }

    /* renamed from: b */
    public void onBindViewHolder(CodeViewHolder codeViewHolder, int i) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1536999764")) {
            ipChange.ipc$dispatch("-1536999764", new Object[]{this, codeViewHolder, Integer.valueOf(i)});
            return;
        }
        DmPhoneCodeBean dmPhoneCodeBean = this.a.get(i);
        if (dmPhoneCodeBean != null) {
            TextView textView = codeViewHolder.b;
            textView.setText(dmPhoneCodeBean.area + " " + dmPhoneCodeBean.code);
            codeViewHolder.c.setOnCheckedChangeListener(null);
            if (!TextUtils.isEmpty(this.b) ? this.b.equals(String.valueOf(i)) : i == 0) {
                z = true;
            }
            codeViewHolder.c.setChecked(z);
            codeViewHolder.a.setOnClickListener(new a(i));
        }
    }

    /* renamed from: c */
    public CodeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1384295478")) {
            return new CodeViewHolder(this, LayoutInflater.from(this.c).inflate(R$layout.ultron_phone_tax_item, viewGroup, false));
        }
        return (CodeViewHolder) ipChange.ipc$dispatch("-1384295478", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "543705607")) {
            return xf2.e(this.a);
        }
        return ((Integer) ipChange.ipc$dispatch("543705607", new Object[]{this})).intValue();
    }
}
