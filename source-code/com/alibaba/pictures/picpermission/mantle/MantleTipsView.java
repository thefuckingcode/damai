package com.alibaba.pictures.picpermission.mantle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.pictures.picpermission.R$id;
import com.alibaba.pictures.picpermission.R$layout;
import com.alibaba.pictures.picpermission.manage.PermissionModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.x9;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/picpermission/mantle/MantleTipsView;", "Ltb/x9;", "<init>", "()V", "permission_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class MantleTipsView extends x9 {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView b;
    private ImageView c;
    private TextView d;

    @Override // tb.x9
    public int b() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "896715209")) {
            return R$layout.mantls_permission_tips_view;
        }
        return ((Integer) ipChange.ipc$dispatch("896715209", new Object[]{this})).intValue();
    }

    @Override // tb.x9
    public void c(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2037647477")) {
            ipChange.ipc$dispatch("2037647477", new Object[]{this, view});
            return;
        }
        k21.i(view, "view");
        super.c(view);
        View findViewById = view.findViewById(R$id.tv_title);
        k21.h(findViewById, "view.findViewById(R.id.tv_title)");
        this.b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.iv_icon);
        k21.h(findViewById2, "view.findViewById(R.id.iv_icon)");
        this.c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R$id.tv_describe);
        k21.h(findViewById3, "view.findViewById(R.id.tv_describe)");
        this.d = (TextView) findViewById3;
    }

    @Override // tb.x9
    public void e(@NotNull PermissionModel permissionModel, boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1602130393")) {
            ipChange.ipc$dispatch("1602130393", new Object[]{this, permissionModel, Boolean.valueOf(z)});
            return;
        }
        k21.i(permissionModel, "permission");
        View a = a();
        k21.f(a);
        a.setVisibility(z ? 0 : 8);
        String title = permissionModel.getTitle();
        if (!(title == null || title.length() == 0)) {
            TextView textView = this.b;
            if (textView == null) {
                k21.A("tvTitle");
            }
            textView.setText(permissionModel.getTitle());
        }
        if (permissionModel.getIconResId() != null) {
            ImageView imageView = this.c;
            if (imageView == null) {
                k21.A("tvIcon");
            }
            Integer iconResId = permissionModel.getIconResId();
            k21.f(iconResId);
            imageView.setImageResource(iconResId.intValue());
        }
        String describe = permissionModel.getDescribe();
        if (!(describe == null || describe.length() == 0)) {
            z2 = false;
        }
        if (!z2) {
            TextView textView2 = this.d;
            if (textView2 == null) {
                k21.A("tvDescribe");
            }
            textView2.setText(permissionModel.getDescribe());
        }
    }
}
