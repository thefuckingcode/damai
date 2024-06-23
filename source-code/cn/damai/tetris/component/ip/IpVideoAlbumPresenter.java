package cn.damai.tetris.component.ip;

import android.text.TextUtils;
import android.view.View;
import cn.damai.tetris.component.ip.IpVideoAlbumContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.uikit.nav.INav;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.tf;
import tb.w9;

/* compiled from: Taobao */
public class IpVideoAlbumPresenter extends BasePresenter<IpVideoAlbumContract.Model, IpVideoAlbumContract.View, BaseSection> implements IpVideoAlbumContract.Presenter<IpVideoAlbumContract.Model, IpVideoAlbumContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-786832379")) {
                ipChange.ipc$dispatch("-786832379", new Object[]{this, view});
                return;
            }
            String str = IpVideoAlbumPresenter.this.mTrackInfo.getArgsMap().get("repertoire_id");
            if (((BasePresenter) IpVideoAlbumPresenter.this).mContext.getActivity() != null && !TextUtils.isEmpty(str)) {
                INav from = NavProxy.from(((BasePresenter) IpVideoAlbumPresenter.this).mContext.getActivity());
                from.toUri(((IpVideoAlbumContract.Model) IpVideoAlbumPresenter.this.getModel()).getVideoInfo().schema + str);
            }
        }
    }

    public IpVideoAlbumPresenter(IpVideoAlbumView ipVideoAlbumView, String str, w9 w9Var) {
        super(ipVideoAlbumView, str, w9Var);
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669252412")) {
            ipChange.ipc$dispatch("-1669252412", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(IpVideoAlbumContract.Model model) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1744448541")) {
            ipChange.ipc$dispatch("1744448541", new Object[]{this, model});
            return;
        }
        this.mTrackInfo = model.getTrackInfo();
        if (getModel() != null && ((IpVideoAlbumContract.Model) getModel()).getVideoInfo() != null) {
            ((IpVideoAlbumContract.View) getView()).initAblum(((IpVideoAlbumContract.Model) getModel()).getVideoInfo().getResult());
            if (((IpVideoAlbumContract.View) getView()).getTitle() != null) {
                tf title = ((IpVideoAlbumContract.View) getView()).getTitle();
                if (!TextUtils.isEmpty(((IpVideoAlbumContract.Model) getModel()).getStyleValue("title"))) {
                    title.g(true);
                    title.c(16);
                    title.f(((IpVideoAlbumContract.Model) getModel()).getStyleValue("title"));
                    if (!TextUtils.isEmpty(((IpVideoAlbumContract.Model) getModel()).getVideoInfo().schema)) {
                        title.d(true);
                        title.e("全部");
                        title.a(new a());
                    } else {
                        title.d(false);
                    }
                    if (!TextUtils.isEmpty(((IpVideoAlbumContract.Model) getModel()).getVideoInfo().latestCount) && !"0".equals(((IpVideoAlbumContract.Model) getModel()).getVideoInfo().latestCount)) {
                        title.b("• " + ((IpVideoAlbumContract.Model) getModel()).getVideoInfo().latestCount + "条更新");
                        return;
                    }
                    return;
                }
                title.g(false);
            }
        }
    }
}
