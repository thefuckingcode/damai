package cn.damai.discover.content.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.model.UserBaseInfoBean;
import cn.damai.commonbusiness.model.UserData;
import cn.damai.discover.content.bean.ContentCommentList;
import cn.damai.discover.content.ui.ContentDetailActivity;
import cn.damai.discover.content.ui.adapter.ContentCommentAdapter;
import cn.damai.discover.content.util.SoftInputUtils;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.im.UserInfoUtil;
import cn.damai.login.LoginManager;
import cn.damai.uikit.view.DMAvatar;
import com.alibaba.pictures.bricks.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Random;
import tb.w71;
import tb.xf2;
import tb.ym2;

/* compiled from: Taobao */
public class ContentCommentViewHolder extends ym2<ContentCommentList> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String[] n = {"📝发条评论，表达自己的态度", "📝爱评论的人运气都不会差哦", "🙌评论区最容易遇到品味相投的TA", "是时候展现你的有趣灵魂了👻", "🛎叮~麦麦向你发送了一个评论邀请", "🤝评论一下，我们就是朋友啦", "💡是不是有想法了？展开说说", "👍评论一下，顶你上去", "☺️我坐好了，你展开说说", "👂放个耳朵，你展开说说"};
    private TextView d;
    private RecyclerView e;
    private ContentCommentAdapter f;
    private TextView g;
    private OnLoadMoreClickListener h;
    private int i = 0;
    private boolean j;
    private ArrayList<ContentCommentList.CommentListItem> k = new ArrayList<>();
    private boolean l;
    private boolean m;

    /* compiled from: Taobao */
    public interface OnCommentClickListener {
        void onClick(View view);
    }

    /* compiled from: Taobao */
    public interface OnLoadMoreClickListener {
        void onClick();
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1431855890")) {
                ipChange.ipc$dispatch("-1431855890", new Object[]{this, view});
                return;
            }
            Context context = ContentCommentViewHolder.this.a;
            if (context instanceof ContentDetailActivity) {
                EditText editText = (EditText) ((ContentDetailActivity) context).findViewById(R$id.content_detail_publisher_input);
                editText.setText("");
                editText.requestFocus();
                SoftInputUtils.c((ContentDetailActivity) ContentCommentViewHolder.this.a);
            }
        }
    }

    public ContentCommentViewHolder(Context context) {
        super(context);
    }

    private void h(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1916372148")) {
            ipChange.ipc$dispatch("1916372148", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        c(true);
        if (!z) {
            this.d.setVisibility(8);
            this.b.findViewById(R$id.comment_list_empty_ll).setVisibility(0);
            return;
        }
        this.d.setVisibility(0);
        this.b.findViewById(R$id.comment_list_empty_ll).setVisibility(8);
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "718290642")) {
            return R$layout.live_content_detail_comment;
        }
        return ((Integer) ipChange.ipc$dispatch("718290642", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "707739039")) {
            ipChange.ipc$dispatch("707739039", new Object[]{this});
            return;
        }
        this.d = (TextView) this.b.findViewById(R$id.live_content_detail_comment_title);
        this.e = (RecyclerView) this.b.findViewById(R$id.live_content_detail_comment_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(1);
        this.e.setLayoutManager(linearLayoutManager);
        ContentCommentAdapter contentCommentAdapter = new ContentCommentAdapter();
        this.f = contentCommentAdapter;
        this.e.setAdapter(contentCommentAdapter);
        TextView textView = (TextView) this.b.findViewById(R$id.live_content_detail_comment_show_all);
        this.g = textView;
        textView.setOnClickListener(this);
        this.b.findViewById(R$id.content_detail_inner_commentinput).setOnClickListener(new a());
        Random random = new Random();
        String[] strArr = n;
        ((TextView) this.b.findViewById(R$id.content_detail_inner_input)).setText(strArr[random.nextInt(strArr.length)]);
        DMAvatar dMAvatar = (DMAvatar) this.b.findViewById(R$id.content_detail_inner_avatar);
        dMAvatar.setAvatarSize(DMAvatar.DMAvatarSize.SIZE_33x33);
        if (LoginManager.k().q()) {
            UserData a2 = UserInfoUtil.a();
            if (a2 == null || a2.getUserBaseInfo() == null) {
                dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
                return;
            }
            UserBaseInfoBean userBaseInfo = a2.getUserBaseInfo();
            if (userBaseInfo == null || TextUtils.isEmpty(userBaseInfo.getHeadImg())) {
                dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
            } else {
                dMAvatar.setAvatar(userBaseInfo.getHeadImg());
            }
            if (userBaseInfo == null || !userBaseInfo.isVip()) {
                dMAvatar.setAvatarCrownVisibility(8);
                dMAvatar.setAvatarBorderVisibility(8);
                return;
            }
            dMAvatar.setAvatarBorderVisibility(0);
            dMAvatar.setAvatarCrownVisibility(0);
            return;
        }
        dMAvatar.setAvatarPlaceholder(R$drawable.mine_account_default);
    }

    public void d(ContentCommentList contentCommentList, boolean z) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1872431797")) {
            ipChange.ipc$dispatch("-1872431797", new Object[]{this, contentCommentList, Boolean.valueOf(z)});
            return;
        }
        ContentCommentAdapter contentCommentAdapter = this.f;
        if (contentCommentAdapter != null) {
            contentCommentAdapter.e(contentCommentList.comments);
            if (this.f.d() <= 0) {
                h(false);
                return;
            }
            int i3 = contentCommentList.totalComment;
            this.i = i3;
            this.d.setText(String.format("共%s条评论", Integer.valueOf(i3)));
            this.m = z;
            TextView textView = this.g;
            if (!z) {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }

    public void e(ContentCommentList.CommentListItem commentListItem) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1625920674")) {
            ipChange.ipc$dispatch("1625920674", new Object[]{this, commentListItem});
            return;
        }
        ContentCommentAdapter contentCommentAdapter = this.f;
        if (contentCommentAdapter != null) {
            contentCommentAdapter.c(commentListItem);
            if (this.f.d() <= 0) {
                h(false);
                return;
            }
            int i3 = this.i + 1;
            this.i = i3;
            this.d.setText(String.format("共%s条评论", Integer.valueOf(i3)));
            TextView textView = this.g;
            if (!this.m) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            c(true);
            h(true);
        }
    }

    public int f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-720179454")) {
            return ((Integer) ipChange.ipc$dispatch("-720179454", new Object[]{this})).intValue();
        }
        View view = this.b;
        if (view == null) {
            return 0;
        }
        return view.getTop();
    }

    public void g(ContentCommentList contentCommentList) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-133773796")) {
            ipChange.ipc$dispatch("-133773796", new Object[]{this, contentCommentList});
        } else if (contentCommentList == null) {
            h(false);
        } else if (xf2.e(contentCommentList.comments) <= 0) {
            h(false);
        } else {
            this.i = contentCommentList.totalComment;
            ArrayList<ContentCommentList.CommentListItem> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < contentCommentList.comments.size(); i2++) {
                if (i2 < 5) {
                    arrayList.add(contentCommentList.comments.get(i2));
                } else {
                    this.k.add(contentCommentList.comments.get(i2));
                }
            }
            this.f.h(arrayList, contentCommentList.sourceId, contentCommentList.sourceType);
            this.d.setText(String.format("共%s条评论", Integer.valueOf(this.i)));
            this.g.setVisibility(this.i > 5 ? 0 : 8);
            this.l = contentCommentList.hasNext;
            if (this.i <= 5) {
                z = true;
            }
            this.m = z;
            this.j = true;
            c(true);
            h(true);
        }
    }

    public void i(OnCommentClickListener onCommentClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585320384")) {
            ipChange.ipc$dispatch("585320384", new Object[]{this, onCommentClickListener});
            return;
        }
        this.f.i(onCommentClickListener);
    }

    public void j(OnLoadMoreClickListener onLoadMoreClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1191254618")) {
            ipChange.ipc$dispatch("-1191254618", new Object[]{this, onLoadMoreClickListener});
            return;
        }
        this.h = onLoadMoreClickListener;
    }

    @Override // tb.ym2
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931952095")) {
            ipChange.ipc$dispatch("-931952095", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        int i2 = 8;
        this.g.setVisibility(8);
        if (this.j) {
            ContentCommentAdapter contentCommentAdapter = this.f;
            if (contentCommentAdapter != null) {
                contentCommentAdapter.e(this.k);
                TextView textView = this.g;
                if (this.l) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                this.j = false;
            } else {
                return;
            }
        } else {
            this.h.onClick();
        }
        this.f.notifyDataSetChanged();
    }

    @Override // tb.ym2, cn.damai.discover.content.ut.LiveUTer
    public void setLiveUt(w71 w71) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219884177")) {
            ipChange.ipc$dispatch("1219884177", new Object[]{this, w71});
            return;
        }
        super.setLiveUt(w71);
        ContentCommentAdapter contentCommentAdapter = this.f;
        if (contentCommentAdapter != null) {
            contentCommentAdapter.setLiveUt(w71);
        }
    }
}
