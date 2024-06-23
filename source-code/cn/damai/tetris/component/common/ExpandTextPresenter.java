package cn.damai.tetris.component.common;

import android.text.TextUtils;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.common.ExpandTextContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w9;

/* compiled from: Taobao */
public class ExpandTextPresenter extends BasePresenter<ExpandTextContract.Model, ExpandTextContract.View, BaseSection> implements ExpandTextContract.Presenter<ExpandTextContract.Model, ExpandTextContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public ExpandTextPresenter(ExpandTextView expandTextView, String str, w9 w9Var) {
        super(expandTextView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515908380")) {
            ipChange.ipc$dispatch("1515908380", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(ExpandTextContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-915169891")) {
            ipChange.ipc$dispatch("-915169891", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (!TextUtils.isEmpty(model.getStyleInfo().getString("title"))) {
            ((TextView) ((ExpandTextContract.View) getView()).getRootView().findViewById(R$id.common_exptext_title)).setText(model.getStyleInfo().getString("title"));
        }
        if (!TextUtils.isEmpty(((ExpandTextContract.Model) getModel()).getContent())) {
            ((ExpandTextContract.View) getView()).getContent().setVisibility(0);
            ((ExpandTextContract.View) getView()).getContent().setText(((ExpandTextContract.Model) getModel()).getContent());
            if (!"收起".equals(((ExpandTextContract.View) getView()).getExtBtn().getText())) {
                ((ExpandTextContract.View) getView()).getContent().post(new Runnable() {
                    /* class cn.damai.tetris.component.common.ExpandTextPresenter.AnonymousClass1 */
                    private static transient /* synthetic */ IpChange $ipChange;

                    public void run() {
                        IpChange ipChange = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange, "1983713779")) {
                            ipChange.ipc$dispatch("1983713779", new Object[]{this});
                        } else if (ExpandTextPresenter.this.getView() != null && ((ExpandTextContract.View) ExpandTextPresenter.this.getView()).getContent() != null && ((ExpandTextContract.View) ExpandTextPresenter.this.getView()).getContent().getLayout() != null) {
                            if (((ExpandTextContract.View) ExpandTextPresenter.this.getView()).getContent().getLayout().getEllipsisCount(((ExpandTextContract.View) ExpandTextPresenter.this.getView()).getContent().getLineCount() - 1) > 0) {
                                ((ExpandTextContract.View) ExpandTextPresenter.this.getView()).getExtBtn().setVisibility(0);
                            } else {
                                ((ExpandTextContract.View) ExpandTextPresenter.this.getView()).getExtBtn().setVisibility(8);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        ((ExpandTextContract.View) getView()).getContent().setVisibility(8);
        ((ExpandTextContract.View) getView()).getExtBtn().setVisibility(8);
    }
}
