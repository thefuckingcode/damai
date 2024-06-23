package cn.damai.tetris.component.discover.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.tetris.component.discover.mvp.BigVoteContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import tb.a03;
import tb.f92;
import tb.w9;
import tb.za;

/* compiled from: Taobao */
public class BigVotePresenter extends BasePresenter<BigVoteModel, BigVoteView, BaseSection> implements BigVoteContract.Presenter<BigVoteModel, BigVoteView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public BigVotePresenter(BigVoteView bigVoteView, String str, w9 w9Var) {
        super(bigVoteView, str, w9Var);
    }

    public void addCommonMap(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801197177")) {
            ipChange.ipc$dispatch("-1801197177", new Object[]{this, hashMap});
        } else if (getModel() != null && ((BigVoteModel) getModel()).getTrackInfo() != null) {
            Map<String, String> argsMap = ((BigVoteModel) getModel()).getTrackInfo().getArgsMap();
            if (!f92.f(argsMap)) {
                String str = argsMap.get(za.CNT_CONTENT_ID);
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("quanziid", str);
                }
            }
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.BigVoteContract.Presenter
    public void itemClick(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781644677")) {
            ipChange.ipc$dispatch("1781644677", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013380793")) {
            ipChange.ipc$dispatch("1013380793", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114899826")) {
            ipChange.ipc$dispatch("1114899826", new Object[]{this, voteInfoBean});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "推荐");
        f.put("id", voteInfoBean.id);
        addCommonMap(f);
        userTrack(TrackType.click, null, ((BigVoteModel) getModel()).getTrackInfo().trackB, "vote_cancel", "dbtn", f, false);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388173628")) {
            ipChange.ipc$dispatch("-388173628", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "推荐");
        f.put("InteractionId", voteInfoBean.id);
        addCommonMap(f);
        TrackType trackType = TrackType.expose;
        String str = ((BigVoteModel) getModel()).getTrackInfo().trackB;
        userTrack(trackType, view, str, "recommend", "dvote_" + i, f, true);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440170040")) {
            ipChange.ipc$dispatch("440170040", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "推荐");
        f.put("id", voteInfoBean.id);
        f.put(Preloader.KEY_SESSION, voteBean.posInVoteList + "");
        f.put("index", i + "");
        addCommonMap(f);
        TrackType trackType = TrackType.click;
        String str = ((BigVoteModel) getModel()).getTrackInfo().trackB;
        userTrack(trackType, null, str, "recommend", "dvote_" + i, f, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    public void init(BigVoteModel bigVoteModel) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "2099208725")) {
            ipChange.ipc$dispatch("2099208725", new Object[]{this, bigVoteModel});
            return;
        }
        ISection section = getSection();
        if (section != null) {
            Object extra = section.getExtra();
            if (extra instanceof VoteInfoBean) {
                VoteInfoBean voteInfoBean = (VoteInfoBean) extra;
                ((BigVoteView) getView()).setData(voteInfoBean, voteInfoBean.posInFeedList);
                if (z) {
                    VoteInfoBean bean = bigVoteModel.getBean();
                    ((BigVoteView) getView()).setData(bean, bean.posInFeedList);
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }
}
