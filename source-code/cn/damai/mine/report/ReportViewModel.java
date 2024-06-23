package cn.damai.mine.report;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import cn.damai.homepage.R$string;
import cn.damai.mine.report.arch.SingleLiveEvent;
import cn.damai.mine.report.bean.ReportReason;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.xf2;
import tb.xz1;

/* compiled from: Taobao */
public class ReportViewModel extends AndroidViewModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MAX_INPUT_LENGHT = 50;
    private final SingleLiveEvent<Void> closeEvent = new SingleLiveEvent<>();
    private Context mContext;
    private ReportRepository mRepository;
    private MutableLiveData<String> reason_memo = new MutableLiveData<>();
    private MutableLiveData<List<ReportReason>> reasons;
    private final SingleLiveEvent<Void> selectEvent = new SingleLiveEvent<>();
    public String targetId;
    public int targetType;
    private final SingleLiveEvent<String> toastEvent = new SingleLiveEvent<>();
    public int type;

    /* compiled from: Taobao */
    public class a extends xz1<ReportResponse> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.xz1
        public void a(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-367509777")) {
                ipChange.ipc$dispatch("-367509777", new Object[]{this, str, str2});
                return;
            }
            ReportViewModel.this.toastEvent.setValue(str2);
        }

        /* renamed from: c */
        public void b(ReportResponse reportResponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1358447036")) {
                ipChange.ipc$dispatch("-1358447036", new Object[]{this, reportResponse});
            } else if (reportResponse != null) {
                ReportViewModel.this.toastEvent.setValue(reportResponse.msg);
                ReportViewModel.this.closeEvent.call();
            }
        }
    }

    public ReportViewModel(Application application, ReportRepository reportRepository) {
        super(application);
        this.mContext = application.getApplicationContext();
        this.mRepository = reportRepository;
        MutableLiveData<List<ReportReason>> mutableLiveData = new MutableLiveData<>();
        this.reasons = mutableLiveData;
        mutableLiveData.setValue(this.mRepository.b(this.mContext));
    }

    public SingleLiveEvent<Void> getCloseEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "915444049")) {
            return this.closeEvent;
        }
        return (SingleLiveEvent) ipChange.ipc$dispatch("915444049", new Object[]{this});
    }

    public MutableLiveData<String> getReasonMemo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "440130473")) {
            return this.reason_memo;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("440130473", new Object[]{this});
    }

    public MutableLiveData<List<ReportReason>> getReasons() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-59174046")) {
            return this.reasons;
        }
        return (MutableLiveData) ipChange.ipc$dispatch("-59174046", new Object[]{this});
    }

    public SingleLiveEvent<Void> getSelectEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "621667565")) {
            return this.selectEvent;
        }
        return (SingleLiveEvent) ipChange.ipc$dispatch("621667565", new Object[]{this});
    }

    public SingleLiveEvent<String> getToastEvent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2137898944")) {
            return this.toastEvent;
        }
        return (SingleLiveEvent) ipChange.ipc$dispatch("2137898944", new Object[]{this});
    }

    public void selectReasonItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604166037")) {
            ipChange.ipc$dispatch("-1604166037", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        List<ReportReason> value = this.reasons.getValue();
        this.selectEvent.call();
        if (value != null) {
            int i2 = 0;
            for (ReportReason reportReason : value) {
                if (i2 == i) {
                    reportReason.checked = true;
                } else {
                    reportReason.checked = false;
                }
                i2++;
            }
            this.reasons.setValue(value);
        }
    }

    public void submitReport() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592885729")) {
            ipChange.ipc$dispatch("-1592885729", new Object[]{this});
            return;
        }
        if (this.reason_memo.getValue() == null) {
            this.reason_memo.setValue("");
        }
        if (this.reason_memo.getValue().length() > 50) {
            this.toastEvent.setValue(this.mContext.getResources().getString(R$string.report_toast_memotolong));
            return;
        }
        String str = "";
        int i = 0;
        for (ReportReason reportReason : this.reasons.getValue()) {
            if (reportReason.checked) {
                int i2 = reportReason.reasonType;
                str = reportReason.reasonStr;
                i = i2;
            }
        }
        if (xf2.j(str)) {
            this.toastEvent.setValue(this.mContext.getResources().getString(R$string.report_toast_noselect));
        } else {
            this.mRepository.c(this.targetId, this.type, this.targetType, i, str, this.reason_memo.getValue(), new a());
        }
    }
}
