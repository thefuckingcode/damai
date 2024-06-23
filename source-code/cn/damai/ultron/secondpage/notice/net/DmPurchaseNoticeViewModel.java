package cn.damai.ultron.secondpage.notice.net;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.ultron.secondpage.notice.bean.DmNoteListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class DmPurchaseNoticeViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String currentIndex;
    private String isConform = "false";
    private String mItemId;
    private MutableLiveData<DmNoteListBean> mPayResultLiveData = new MutableLiveData<>();
    private DmPurchaseNoticeRepository mRepository = new DmPurchaseNoticeRepository();

    public DmPurchaseNoticeViewModel(@NonNull Application application) {
        super(application);
    }

    public int getCurrentIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159836148")) {
            return ((Integer) ipChange.ipc$dispatch("-159836148", new Object[]{this})).intValue();
        }
        try {
            return Integer.valueOf(this.currentIndex).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String getItemId(Intent intent) {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "656459263")) {
            return (String) ipChange.ipc$dispatch("656459263", new Object[]{this, intent});
        }
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            this.mItemId = extras.getString("itemId", "");
            this.currentIndex = extras.getString("index", "0");
            this.isConform = extras.getString("conform", "true");
        }
        return this.mItemId;
    }

    public MutableLiveData<DmNoteListBean> getNoticeLiveData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1194166704")) {
            return this.mPayResultLiveData;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("1194166704", new Object[]{this});
    }

    public boolean isConform() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1398901712")) {
            return !TextUtils.isEmpty(this.isConform) && this.isConform.equals("true");
        }
        return ((Boolean) ipChange.ipc$dispatch("1398901712", new Object[]{this})).booleanValue();
    }

    public void queryNoticeData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569910274")) {
            ipChange.ipc$dispatch("-1569910274", new Object[]{this});
            return;
        }
        this.mRepository.queryPurchaseNoticeInfo(this.mItemId, new DMMtopRequestListener<DmNoteListBean>(DmNoteListBean.class) {
            /* class cn.damai.ultron.secondpage.notice.net.DmPurchaseNoticeViewModel.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "971390438")) {
                    ipChange.ipc$dispatch("971390438", new Object[]{this, str, str2});
                    return;
                }
                DmNoteListBean dmNoteListBean = new DmNoteListBean();
                dmNoteListBean.requestSuccess = false;
                dmNoteListBean.requestFailMsg = str2;
                DmPurchaseNoticeViewModel.this.mPayResultLiveData.setValue(dmNoteListBean);
            }

            public void onSuccess(DmNoteListBean dmNoteListBean) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "51861101")) {
                    ipChange.ipc$dispatch("51861101", new Object[]{this, dmNoteListBean});
                    return;
                }
                DmNoteListBean dmNoteListBean2 = new DmNoteListBean();
                if (dmNoteListBean == null) {
                    dmNoteListBean2.requestSuccess = false;
                } else {
                    dmNoteListBean2.requestSuccess = true;
                    dmNoteListBean2.noticeList = dmNoteListBean.noticeList;
                }
                DmPurchaseNoticeViewModel.this.mPayResultLiveData.setValue(dmNoteListBean2);
            }
        });
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1641730020")) {
            return this.mItemId;
        }
        return (String) ipChange.ipc$dispatch("-1641730020", new Object[]{this});
    }
}
