package cn.damai.tetris.component.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.common.bean.AccountBean;
import cn.damai.tetris.core.IModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.v50;

/* compiled from: Taobao */
public class AccountAlbumAdapter extends RecyclerView.Adapter<b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<AccountBean> a;
    private Context b;
    private AccountAlbumPresenter c;
    int[] d = {R$drawable.bg_account_item_1, R$drawable.bg_account_item_2, R$drawable.bg_account_item_3};

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ AccountBean a;
        final /* synthetic */ int b;
        final /* synthetic */ HashMap c;

        a(AccountBean accountBean, int i, HashMap hashMap) {
            this.a = accountBean;
            this.b = i;
            this.c = hashMap;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "4834441")) {
                ipChange.ipc$dispatch("4834441", new Object[]{this, view});
                return;
            }
            if (this.a.getSchema() != null) {
                DMNav.from(AccountAlbumAdapter.this.b).toUri(this.a.getSchema());
            }
            if (AccountAlbumAdapter.this.c != null) {
                AccountAlbumPresenter accountAlbumPresenter = AccountAlbumAdapter.this.c;
                accountAlbumPresenter.userTrackClick("card_" + this.b, this.c, true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends RecyclerView.ViewHolder {
        public ImageView a;
        public ImageView b;
        public TextView c;
        public TextView d;

        public b(AccountAlbumAdapter accountAlbumAdapter, View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.account_album_item_bg);
            this.b = (ImageView) view.findViewById(R$id.account_album_item_pic);
            this.c = (TextView) view.findViewById(R$id.account_album_item_name);
            this.d = (TextView) view.findViewById(R$id.account_album_item_desc);
        }
    }

    public AccountAlbumAdapter(Context context, List list, AccountAlbumPresenter accountAlbumPresenter) {
        this.b = context;
        this.a = list;
        this.c = accountAlbumPresenter;
    }

    /* renamed from: c */
    public void onBindViewHolder(b bVar, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976019447")) {
            ipChange.ipc$dispatch("-976019447", new Object[]{this, bVar, Integer.valueOf(i)});
            return;
        }
        if (i == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) bVar.itemView.getLayoutParams();
            marginLayoutParams.setMargins(v50.a(this.b, 15.0f), 0, v50.a(this.b, 0.0f), 0);
            bVar.itemView.setLayoutParams(marginLayoutParams);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) bVar.itemView.getLayoutParams();
            marginLayoutParams2.setMargins(v50.a(this.b, 0.0f), 0, v50.a(this.b, 0.0f), 0);
            bVar.itemView.setLayoutParams(marginLayoutParams2);
        }
        AccountBean accountBean = this.a.get(i);
        if (accountBean != null) {
            bVar.a.setImageDrawable(this.b.getResources().getDrawable(this.d[i % 3]));
            cn.damai.uikit.image.a.a().loadinto(accountBean.getHeadPic(), bVar.b);
            bVar.c.setText(accountBean.getName());
            bVar.d.setText(accountBean.getAdditionDescription());
            AccountAlbumPresenter accountAlbumPresenter = this.c;
            if (accountAlbumPresenter != null) {
                ImageView imageView = bVar.a;
                accountAlbumPresenter.userTrackExpose(imageView, "artist_" + i);
            }
            HashMap hashMap = new HashMap();
            AccountAlbumPresenter accountAlbumPresenter2 = this.c;
            if (!(accountAlbumPresenter2 == null || accountAlbumPresenter2.getModel() == null)) {
                IModel model = this.c.getModel();
                if (model.getTrackInfo() != null) {
                    hashMap.putAll(model.getTrackInfo().getArgsMap());
                }
                if (model.getStyleInfo() != null && !TextUtils.isEmpty(model.getStyleInfo().getString("title"))) {
                    hashMap.put("titlelabel", model.getStyleInfo().getString("title"));
                }
                hashMap.put("biz_id", accountBean.getId());
                hashMap.put("biz_type", accountBean.getType());
                AccountAlbumPresenter accountAlbumPresenter3 = this.c;
                View view = bVar.itemView;
                accountAlbumPresenter3.userTrackExpose(view, "card_" + i, hashMap, true);
            }
            bVar.itemView.setOnClickListener(new a(accountBean, i, hashMap));
        }
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1762573325")) {
            return new b(this, LayoutInflater.from(this.b).inflate(R$layout.account_album_item, viewGroup, false));
        }
        return (b) ipChange.ipc$dispatch("1762573325", new Object[]{this, viewGroup, Integer.valueOf(i)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-100419528")) {
            return ((Integer) ipChange.ipc$dispatch("-100419528", new Object[]{this})).intValue();
        }
        List<AccountBean> list = this.a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.a.size();
    }
}
