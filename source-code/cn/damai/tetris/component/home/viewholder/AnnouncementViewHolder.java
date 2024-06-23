package cn.damai.tetris.component.home.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$string;
import cn.damai.tetris.component.home.bean.WarningMessageBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.mvp.CommonBean;
import cn.damai.tetris.mvp.CommonViewHolder;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.f6;
import tb.zw0;

/* compiled from: Taobao */
public class AnnouncementViewHolder extends CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView mAnnouncementArrow;
    private TextView mAnnouncementContent;
    private View mAnnouncementLayout;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new a();
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1895340826")) {
                ipChange.ipc$dispatch("-1895340826", new Object[]{this, view});
                return;
            }
            WarningMessageBean warningMessageBean = (WarningMessageBean) view.getTag();
            if (!TextUtils.isEmpty(warningMessageBean.schema)) {
                zw0.B().p(AnnouncementViewHolder.this.mTrackInfo, warningMessageBean.warningMessage);
                DMNav.from(AnnouncementViewHolder.this.mContext).toUri(warningMessageBean.schema);
            }
            AnnouncementViewHolder.this.mAnnouncementLayout.setVisibility(8);
            d20.T("remove_announcement", "true");
        }
    }

    public AnnouncementViewHolder(View view) {
        super(view);
        this.mContext = view.getContext();
        this.mAnnouncementLayout = this.itemView.findViewById(R$id.homepage_announcement_layout);
        this.mAnnouncementContent = (TextView) this.itemView.findViewById(R$id.homepage_announcement_content);
        this.mAnnouncementArrow = (DMIconFontTextView) this.itemView.findViewById(R$id.homepage_announcement_arrow);
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.tetris.mvp.CommonViewHolder
    public void setData(CommonBean commonBean) {
        String str;
        String B;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1881937767")) {
            ipChange.ipc$dispatch("1881937767", new Object[]{this, commonBean});
        } else if (commonBean != null && (commonBean instanceof WarningMessageBean)) {
            this.mTrackInfo = commonBean.trackInfo;
            WarningMessageBean warningMessageBean = (WarningMessageBean) commonBean;
            String a2 = f6.a(this.mContext);
            if (a2 == null || (str = warningMessageBean.warningMessage) == null || !a2.equals(str) || (B = d20.B("remove_announcement")) == null || !"true".equals(B)) {
                this.mAnnouncementLayout.setVisibility(0);
                TextView textView = this.mAnnouncementContent;
                textView.setText("公告：" + warningMessageBean.warningMessage);
                if (TextUtils.isEmpty(warningMessageBean.schema)) {
                    this.mAnnouncementArrow.setText(this.mContext.getResources().getString(R$string.iconfont_guanbi12));
                    this.mAnnouncementArrow.setOnClickListener(this.mOnClickListener);
                    this.mAnnouncementArrow.setTag(warningMessageBean);
                } else {
                    this.mAnnouncementArrow.setText(this.mContext.getResources().getString(R$string.iconfont_youjiantou12));
                    this.itemView.setOnClickListener(this.mOnClickListener);
                    this.itemView.setTag(warningMessageBean);
                    this.mAnnouncementArrow.setOnClickListener(this.mOnClickListener);
                    this.mAnnouncementArrow.setTag(warningMessageBean);
                }
                d20.T("remove_announcement", "false");
                f6.b(this.mContext, warningMessageBean.warningMessage);
                zw0.B().C(this.mTrackInfo, this.itemView, warningMessageBean.schema);
                return;
            }
            this.mAnnouncementLayout.setVisibility(8);
        }
    }
}
