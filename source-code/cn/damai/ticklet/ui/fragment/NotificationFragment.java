package cn.damai.ticklet.ui.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.ticklet.bean.TickletStatusNotice;
import cn.damai.ticklet.inteface.TickletPerformCallBack;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import tb.gr;

/* compiled from: Taobao */
public class NotificationFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private TickletPerformCallBack callBack;
    private TickletStatusNotice mStatusNotice;
    private DMIconFontTextView mTvNotificationComplete;
    private TextView mTvNotificationContent;
    private ImageView mTvNotificationImg;
    private TextView mTvNotificationTitle;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1843244934")) {
                ipChange.ipc$dispatch("1843244934", new Object[]{this, view});
                return;
            }
            NotificationFragment.this.callBack.closeNotice();
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-340431993")) {
                ipChange.ipc$dispatch("-340431993", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(NotificationFragment.this.mStatusNotice.getAnnouncementSkipURL())) {
                DMNav.from(NotificationFragment.this.getContext()).toUri(NotificationFragment.this.mStatusNotice.getAnnouncementSkipURL());
                NotificationFragment.this.callBack.closeNotice();
            } else {
                NotificationFragment.this.openImageBrowseActivity();
            }
        }
    }

    /* compiled from: Taobao */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-564294898")) {
                ipChange.ipc$dispatch("-564294898", new Object[]{this, eVar});
            } else if (eVar != null && (bitmap = eVar.b) != null && !bitmap.isRecycled()) {
                NotificationFragment.this.mTvNotificationImg.setImageBitmap(eVar.b);
            }
        }
    }

    private void initExtraData() {
        Serializable serializable;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445331880")) {
            ipChange.ipc$dispatch("-445331880", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null && (serializable = arguments.getSerializable("status_notice")) != null) {
            this.mStatusNotice = (TickletStatusNotice) serializable;
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1327049156")) {
            ipChange.ipc$dispatch("1327049156", new Object[]{this});
            return;
        }
        this.mTvNotificationTitle = (TextView) this.rootView.findViewById(R$id.layer_title);
        this.mTvNotificationComplete = (DMIconFontTextView) this.rootView.findViewById(R$id.layer_close);
        this.mTvNotificationContent = (TextView) this.rootView.findViewById(R$id.project_notification_content_tv);
        this.mTvNotificationImg = (ImageView) this.rootView.findViewById(R$id.project_notification_content_img);
    }

    public static NotificationFragment newInstance(TickletStatusNotice tickletStatusNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259913051")) {
            return (NotificationFragment) ipChange.ipc$dispatch("-259913051", new Object[]{tickletStatusNotice});
        }
        NotificationFragment notificationFragment = new NotificationFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("status_notice", tickletStatusNotice);
        notificationFragment.setArguments(bundle);
        return notificationFragment;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void openImageBrowseActivity() {
        TickletStatusNotice tickletStatusNotice;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927128200")) {
            ipChange.ipc$dispatch("-1927128200", new Object[]{this});
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing() && (tickletStatusNotice = this.mStatusNotice) != null && !TextUtils.isEmpty(tickletStatusNotice.imageUrl)) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            PicInfo picInfo = new PicInfo();
            picInfo.setPicUrl(this.mStatusNotice.imageUrl);
            arrayList.add(picInfo);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", 0);
            DMNav.from(this.mActivity).withExtras(bundle).toUri(gr.e());
        }
    }

    private void setInitializedData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1295160724")) {
            ipChange.ipc$dispatch("-1295160724", new Object[]{this});
            return;
        }
        TickletStatusNotice tickletStatusNotice = this.mStatusNotice;
        if (tickletStatusNotice != null) {
            String popupTitle = tickletStatusNotice.getPopupTitle();
            String popupContent = this.mStatusNotice.getPopupContent();
            this.mTvNotificationTitle.setText(popupTitle);
            this.mTvNotificationContent.setText(popupContent);
            if (!TextUtils.isEmpty(this.mStatusNotice.imageUrl)) {
                this.mTvNotificationImg.setVisibility(0);
                this.mTvNotificationImg.setOnClickListener(new b());
                cn.damai.common.image.a.b().f(this.mStatusNotice.imageUrl, 650, 900).n(new c()).f();
                return;
            }
            this.mTvNotificationImg.setVisibility(8);
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136683974")) {
            ipChange.ipc$dispatch("136683974", new Object[]{this});
            return;
        }
        this.mTvNotificationComplete.setOnClickListener(new a());
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public int getLayoutResource() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "881900455")) {
            return R$layout.ticklet_item_pop_notification_layout;
        }
        return ((Integer) ipChange.ipc$dispatch("881900455", new Object[]{this})).intValue();
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816183935")) {
            ipChange.ipc$dispatch("-816183935", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838962890")) {
            ipChange.ipc$dispatch("1838962890", new Object[]{this});
        }
    }

    /* access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511453293")) {
            ipChange.ipc$dispatch("-511453293", new Object[]{this});
            return;
        }
        initExtraData();
        initViews();
        setupListeners();
        setInitializedData();
    }

    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155360583")) {
            ipChange.ipc$dispatch("-155360583", new Object[]{this, view});
        }
    }

    public void setCallBack(TickletPerformCallBack tickletPerformCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "474302066")) {
            ipChange.ipc$dispatch("474302066", new Object[]{this, tickletPerformCallBack});
            return;
        }
        this.callBack = tickletPerformCallBack;
    }
}
