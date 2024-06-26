package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.login.LoginManager;
import cn.damai.search.helper.SearchHelper;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class s52 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private ImageView h;
    private View.OnClickListener i = new a(this);

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(s52 s52) {
        }

        public void onClick(View view) {
            BaccountInfo baccountInfo;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1828947428")) {
                ipChange.ipc$dispatch("1828947428", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (R$id.goto_main_page == id || R$id.iv_head_bg_cover == id) {
                br.c(SearchHelper.JUMP_ACCOUNT_MAIN_PAGE, view.getTag());
            } else if (R$id.relation_status == id && (baccountInfo = (BaccountInfo) view.getTag()) != null) {
                if (!baccountInfo.isHasFollow()) {
                    br.c(SearchHelper.ATTENTION_SEARCH_ACCOUNT, baccountInfo);
                } else {
                    br.c(SearchHelper.JUMP_ACCOUNT_MAIN_PAGE, baccountInfo);
                }
            }
        }
    }

    private int a(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356137253")) {
            return ((Integer) ipChange.ipc$dispatch("356137253", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        return ScreenUtil.dip2px(this.a, z ? 136.0f : 112.0f);
    }

    private void d(String str, String str2, boolean z, boolean z2, boolean z3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330775630")) {
            ipChange.ipc$dispatch("1330775630", new Object[]{this, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
            return;
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            if (imageView.getTag() instanceof zq) {
                ((zq) this.b.getTag()).cancel();
            }
            if (z || z3) {
                this.b.setVisibility(8);
            } else {
                DMImageCreator c2 = cn.damai.common.image.a.b().h(this.a).c(str);
                int i2 = R$drawable.uikit_user_default_icon_trans_white;
                zq g2 = c2.i(i2).c(i2).k(new cq()).g(this.b);
                this.b.setVisibility(0);
                this.b.setTag(g2);
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.height = a(z2);
        this.f.setLayoutParams(layoutParams);
        cn.damai.common.image.a b2 = cn.damai.common.image.a.b();
        if (!z) {
            str = str2;
        }
        b2.c(str).i(R$drawable.transparent_bg).c(R$drawable.c_default_bg).k(new pq(this.a, z, z2)).g(this.f);
    }

    public void b(BaccountInfo baccountInfo, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046715598")) {
            ipChange.ipc$dispatch("1046715598", new Object[]{this, baccountInfo, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        this.e.setTag(baccountInfo);
        this.g.setTag(baccountInfo);
        this.f.setTag(baccountInfo);
        if (z2) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        d(baccountInfo.headPic, baccountInfo.backgroundPic, baccountInfo.type.equals("2"), z, baccountInfo.type.equals("3"));
        this.h.setVisibility(baccountInfo.isShowVTag() ? 0 : 8);
        this.h.setImageResource(baccountInfo.type.equals("4") ? R$drawable.user_v_tag_brand : R$drawable.user_v_tag);
        this.c.setText(baccountInfo.name);
        String d2 = SearchHelper.d(baccountInfo);
        if (TextUtils.isEmpty(d2)) {
            this.d.setVisibility(8);
        } else {
            this.d.setText(d2);
            this.d.setVisibility(0);
        }
        if (!LoginManager.k().q() || !baccountInfo.isHasFollow()) {
            this.e.setText("关注");
            this.e.setTextColor(ContextCompat.getColor(this.a, R$color.white));
            this.e.setBackgroundResource(R$drawable.search_unattention_button);
            return;
        }
        this.e.setText("已关注");
        this.e.setTextColor(ContextCompat.getColor(this.a, R$color.white));
        this.e.setBackgroundResource(R$drawable.search_attention_button);
    }

    public void c(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930619771")) {
            ipChange.ipc$dispatch("1930619771", new Object[]{this, context, view});
            return;
        }
        this.a = context;
        this.b = (ImageView) view.findViewById(R$id.iv_account_image);
        this.c = (TextView) view.findViewById(R$id.tv_account_name);
        this.d = (TextView) view.findViewById(R$id.tv_account_count);
        TextView textView = (TextView) view.findViewById(R$id.relation_status);
        this.e = textView;
        textView.setVisibility(8);
        this.g = (TextView) view.findViewById(R$id.goto_main_page);
        this.f = (ImageView) view.findViewById(R$id.iv_head_bg_cover);
        this.h = (ImageView) view.findViewById(R$id.iv_account_arrow);
        this.g.setOnClickListener(this.i);
        this.e.setOnClickListener(this.i);
        this.f.setOnClickListener(this.i);
    }
}
