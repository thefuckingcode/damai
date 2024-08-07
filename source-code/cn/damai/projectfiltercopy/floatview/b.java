package cn.damai.projectfiltercopy.floatview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.commonbusiness.citycopy.model.SitesBean;
import cn.damai.commonbusiness.citycopy.util.CityLocationUtil;
import cn.damai.projectfiltercopy.bean.FilterData;
import cn.damai.projectfiltercopy.bean.SortBean;
import cn.damai.projectfiltercopy.bean.Type;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.picpermission.Permission;
import com.alibaba.pictures.picpermission.custom.IPermissionListener;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.e92;
import tb.jp1;
import tb.kp1;
import tb.l42;
import tb.mg0;
import tb.nl;
import tb.wm2;

/* compiled from: Taobao */
public class b extends a<SortBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final ViewGroup d;
    private TextView e;
    private long f;

    /* compiled from: Taobao */
    public class a implements IPermissionListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SortBean a;

        /* renamed from: cn.damai.projectfiltercopy.floatview.b$a$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0034a implements CityLocationUtil.LocaltionListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C0034a(a aVar) {
            }

            @Override // cn.damai.commonbusiness.citycopy.util.CityLocationUtil.LocaltionListener
            public void onGetLocalFinsih() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "858892801")) {
                    ipChange.ipc$dispatch("858892801", new Object[]{this});
                }
            }

            @Override // cn.damai.commonbusiness.citycopy.util.CityLocationUtil.LocaltionListener
            public void onGetLocalSuccess(SitesBean sitesBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "607711422")) {
                    ipChange.ipc$dispatch("607711422", new Object[]{this, sitesBean});
                }
            }
        }

        /* renamed from: cn.damai.projectfiltercopy.floatview.b$a$b  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class DialogInterface$OnClickListenerC0035b implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            DialogInterface$OnClickListenerC0035b() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "420023009")) {
                    ipChange.ipc$dispatch("420023009", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
                Context context = b.this.a;
                if (context instanceof Activity) {
                    jp1.f((Activity) context);
                }
            }
        }

        /* compiled from: Taobao */
        public class c implements DialogInterface.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            c(a aVar) {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1389604032")) {
                    ipChange.ipc$dispatch("1389604032", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    return;
                }
                dialogInterface.dismiss();
            }
        }

        a(SortBean sortBean) {
            this.a = sortBean;
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionDenied(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1269009031")) {
                ipChange.ipc$dispatch("-1269009031", new Object[]{this, strArr});
            }
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onPermissionGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-252293010")) {
                ipChange.ipc$dispatch("-252293010", new Object[]{this});
                return;
            }
            CityLocationUtil cityLocationUtil = new CityLocationUtil(AppInfoProviderProxy.getApplication(), new C0034a(this));
            cityLocationUtil.o(true);
            cityLocationUtil.m();
            b.this.getListener().onFloatCall(b.this.getType(), new FilterData(this.a));
        }

        @Override // com.alibaba.pictures.picpermission.custom.IPermissionListener
        public void onShowRationale(@NotNull String[] strArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "24950143")) {
                ipChange.ipc$dispatch("24950143", new Object[]{this, strArr});
                return;
            }
            nl.INSTANCE.a().showPermissionDialog(b.this.a, "获取你所在城市的演出赛事信息，帮助你找到附近的演出赛事", Arrays.asList(strArr), false, new DialogInterface$OnClickListenerC0035b(), new c(this));
        }
    }

    public b(Context context, List<SortBean> list) {
        super(context);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(R$layout.copy_item_filter_sort_float, (ViewGroup) null);
        this.d = viewGroup;
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int a2 = l42.a(context, 46.0f);
        if (!e92.d(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                SortBean sortBean = list.get(i);
                sortBean.index = i;
                TextView textView = new TextView(context);
                textView.setLines(1);
                textView.setTextColor(mg0.C_333333);
                textView.setGravity(16);
                textView.setTag(sortBean);
                textView.setText(sortBean.name);
                textView.setOnClickListener(this);
                if (sortBean.isLocationSort()) {
                    this.e = textView;
                }
                this.d.addView(textView, -1, a2);
            }
        }
    }

    private void a(SortBean sortBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1076579983")) {
            ipChange.ipc$dispatch("-1076579983", new Object[]{this, sortBean});
            return;
        }
        new Permission(this.a, new PermissionModel(kp1.a, "位置权限使用说明", Integer.valueOf(R$drawable.permission_location_icon), "用于为你提供所在城市演出和场馆信息及帮助你找到附近的演出")).a(new a(sortBean)).b();
    }

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1055769902")) {
            ipChange.ipc$dispatch("1055769902", new Object[]{this});
            return;
        }
        TextView textView = this.e;
        if (textView != null && (textView.getTag() instanceof SortBean)) {
            SortBean sortBean = (SortBean) this.e.getTag();
            boolean e2 = wm2.INSTANCE.e(this.a);
            if (!sortBean.isLocationSort()) {
                return;
            }
            if (e2) {
                this.e.setText(sortBean.name);
                return;
            }
            this.e.setText(sortBean.name + "(定位失败)");
        }
    }

    /* renamed from: b */
    public void show(SortBean sortBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "66560427")) {
            ipChange.ipc$dispatch("66560427", new Object[]{this, sortBean});
            return;
        }
        this.f = System.currentTimeMillis();
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextView textView = (TextView) this.d.getChildAt(i);
            Object tag = textView.getTag();
            textView.setTextColor((!(tag instanceof SortBean) || sortBean == null) ? false : TextUtils.equals(sortBean.value, ((SortBean) tag).value) ? mg0.C_FF2869 : mg0.C_333333);
        }
        c();
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public Type getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1762801144")) {
            return Type.SORT;
        }
        return (Type) ipChange.ipc$dispatch("1762801144", new Object[]{this});
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public View getView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1474220657")) {
            return this.d;
        }
        return (View) ipChange.ipc$dispatch("-1474220657", new Object[]{this});
    }

    @Override // cn.damai.projectfiltercopy.floatview.FloatLayer
    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299954112")) {
            ipChange.ipc$dispatch("299954112", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f;
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.d.getChildAt(i);
            if (childAt != null && (childAt.getTag() instanceof SortBean)) {
                getFilterUt().w(childAt, (SortBean) childAt.getTag(), i, currentTimeMillis);
            }
        }
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1578751603")) {
            ipChange.ipc$dispatch("1578751603", new Object[]{this, view});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof SortBean) {
            SortBean sortBean = (SortBean) tag;
            getFilterUt().o(sortBean);
            if (!sortBean.isLocationSort()) {
                getListener().onFloatCall(getType(), new FilterData(sortBean));
            } else if (wm2.INSTANCE.e(this.a)) {
                getListener().onFloatCall(getType(), new FilterData(sortBean));
            } else {
                a(sortBean);
            }
        }
    }
}
