package cn.damai.tetris.component.ip;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.tetris.component.ip.IpVideoHeaderContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cs;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public class IpVideoHeaderPresenter extends BasePresenter<IpVideoHeaderContract.Model, IpVideoHeaderContract.View, BaseSection> implements IpVideoHeaderContract.Presenter<IpVideoHeaderContract.Model, IpVideoHeaderContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public IpVideoHeaderPresenter(IpVideoHeaderView ipVideoHeaderView, String str, w9 w9Var) {
        super(ipVideoHeaderView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, final Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1166220676")) {
            ipChange.ipc$dispatch("-1166220676", new Object[]{this, Integer.valueOf(i), obj});
        } else if (getView() != null && ((IpVideoHeaderContract.View) getView()).getManager() != null) {
            if (i != 2000) {
                switch (i) {
                    case 11001:
                        if (obj instanceof Boolean) {
                            ((Boolean) obj).booleanValue();
                            return;
                        }
                        return;
                    case 11002:
                        ((IpVideoHeaderContract.View) getView()).getRootView().postDelayed(new Runnable() {
                            /* class cn.damai.tetris.component.ip.IpVideoHeaderPresenter.AnonymousClass1 */
                            private static transient /* synthetic */ IpChange $ipChange;

                            public void run() {
                                IpChange ipChange = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange, "957065363")) {
                                    ipChange.ipc$dispatch("957065363", new Object[]{this});
                                    return;
                                }
                                cs.d().g();
                                ((IpVideoHeaderContract.View) IpVideoHeaderPresenter.this.getView()).setMuteIcon(-1);
                            }
                        }, 500);
                        return;
                    case 11003:
                        cs.d().f();
                        cs.d().n();
                        return;
                    case 11004:
                        cs.d().f();
                        ((IpVideoHeaderContract.View) getView()).getManager().j();
                        return;
                    default:
                        return;
                }
            } else {
                final IpVideoHeaderContract.Model model = (IpVideoHeaderContract.Model) this.mModel;
                if (model.getVideoInfo() == null) {
                    return;
                }
                if (!TextUtils.isEmpty(model.getVideoInfo().getVid()) || !TextUtils.isEmpty(model.getVideoInfo().getVideoUrl())) {
                    ((IpVideoHeaderContract.View) getView()).getRootView().post(new Runnable() {
                        /* class cn.damai.tetris.component.ip.IpVideoHeaderPresenter.AnonymousClass2 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "760551858")) {
                                ipChange.ipc$dispatch("760551858", new Object[]{this});
                                return;
                            }
                            ((IpVideoHeaderContract.View) IpVideoHeaderPresenter.this.getView()).toogleAnim((RecyclerView) obj);
                        }
                    });
                    ((IpVideoHeaderContract.View) getView()).getRootView().postDelayed(new Runnable() {
                        /* class cn.damai.tetris.component.ip.IpVideoHeaderPresenter.AnonymousClass3 */
                        private static transient /* synthetic */ IpChange $ipChange;

                        public void run() {
                            IpChange ipChange = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange, "564038353")) {
                                ipChange.ipc$dispatch("564038353", new Object[]{this});
                                return;
                            }
                            ((IpVideoHeaderContract.View) IpVideoHeaderPresenter.this.getView()).hideTip();
                            ((IpVideoHeaderContract.View) IpVideoHeaderPresenter.this.getView()).setVideoInfo(model.getVideoInfo());
                        }
                    }, 500);
                }
            }
        }
    }

    public void init(IpVideoHeaderContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45634527")) {
            ipChange.ipc$dispatch("-45634527", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (model.getVideoInfo() == null) {
            ((IpVideoHeaderContract.View) getView()).showTip();
            return;
        }
        View rootView = ((IpVideoHeaderContract.View) getView()).getRootView();
        int i = R$id.cover_half_bottom;
        if (rootView.findViewById(i) != null) {
            if (!(((IpVideoHeaderContract.Model) getModel()).getVideoInfo() == null || ((IpVideoHeaderContract.Model) getModel()).getTrackInfo() == null)) {
                ((IpVideoHeaderContract.Model) getModel()).getTrackInfo().put(za.PRE_CONTENT_ID, (Object) ((IpVideoHeaderContract.Model) getModel()).getVideoInfo().getVid());
                ((IpVideoHeaderContract.Model) getModel()).getTrackInfo().put(za.PRE_CONTENT_TYPE, (Object) "video");
            }
            userTrackExpose(((IpVideoHeaderContract.View) getView()).getRootView().findViewById(i), "video");
        }
    }
}
