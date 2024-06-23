package cn.damai.tetris.component.discover.mvp;

import android.text.TextUtils;
import android.view.View;
import cn.damai.commonbusiness.discover.bean.VoteBean;
import cn.damai.commonbusiness.discover.bean.VoteInfoBean;
import cn.damai.tetris.component.discover.mvp.VoteContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
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
public class VotePresenter extends BasePresenter<VoteModel, VoteView, BaseSection> implements VoteContract.Presenter<VoteModel, VoteView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;

    public VotePresenter(VoteView voteView, String str, w9 w9Var) {
        super(voteView, str, w9Var);
    }

    public void addCommonMap(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1500215153")) {
            ipChange.ipc$dispatch("1500215153", new Object[]{this, hashMap});
        } else if (getModel() != null && ((VoteModel) getModel()).getTrackInfo() != null) {
            Map<String, String> argsMap = ((VoteModel) getModel()).getTrackInfo().getArgsMap();
            if (!f92.f(argsMap)) {
                String str = argsMap.get(za.CNT_CONTENT_ID);
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(za.CNT_CONTENT_ID, str);
                }
            }
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.VoteContract.Presenter
    public void itemClick(VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-606932389")) {
            ipChange.ipc$dispatch("-606932389", new Object[]{this, voteInfoBean, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1031126769")) {
            ipChange.ipc$dispatch("-1031126769", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4CancelVoteClick(VoteInfoBean voteInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523975240")) {
            ipChange.ipc$dispatch("1523975240", new Object[]{this, voteInfoBean});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "推荐");
        f.put("InteractionId", voteInfoBean.id);
        addCommonMap(f);
        userTrackClick("dbtn", f, false);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4VoteCardExposure(View view, VoteInfoBean voteInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1441811538")) {
            ipChange.ipc$dispatch("-1441811538", new Object[]{this, view, voteInfoBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "推荐");
        f.put("InteractionId", voteInfoBean.id);
        addCommonMap(f);
        userTrackExpose(view, "dvote_" + i, f, false);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.VotePanel.VoteUtListener
    public void ut4VoteClick(VoteInfoBean voteInfoBean, VoteBean voteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902628258")) {
            ipChange.ipc$dispatch("1902628258", new Object[]{this, voteInfoBean, voteBean, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = a03.f();
        f.put("titlelabel", "推荐");
        f.put("InteractionId", voteInfoBean.id);
        f.put(Preloader.KEY_SESSION, voteBean.posInVoteList + "");
        f.put("index", i + "");
        addCommonMap(f);
        userTrackClick("dvote_" + i, f, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    public void init(VoteModel voteModel) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1619619469")) {
            ipChange.ipc$dispatch("-1619619469", new Object[]{this, voteModel});
            return;
        }
        ISection section = getSection();
        if (section != null) {
            Object extra = section.getExtra();
            if (extra instanceof VoteInfoBean) {
                VoteInfoBean voteInfoBean = (VoteInfoBean) extra;
                ((VoteView) getView()).setData(voteInfoBean, voteInfoBean.posInFeedList);
                if (z) {
                    VoteInfoBean bean = voteModel.getBean();
                    ((VoteView) getView()).setData(bean, bean.posInFeedList);
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
