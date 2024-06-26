package cn.damai.tetris.component.discover.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.tetris.component.discover.bean.NoteBean;
import cn.damai.tetris.component.discover.mvp.NoteContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import tb.gr;
import tb.w9;
import tb.wk;
import tb.za;

/* compiled from: Taobao */
public class NotePresenter extends BasePresenter<NoteModel, NoteView, BaseSection> implements NoteContract.Presenter<NoteModel, NoteView, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    public NotePresenter(NoteView noteView, String str, w9 w9Var) {
        super(noteView, str, w9Var);
    }

    public static void fillMap(boolean z, TrackInfo trackInfo, Map<String, String> map, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "272875713")) {
            ipChange.ipc$dispatch("272875713", new Object[]{Boolean.valueOf(z), trackInfo, map, str, str2});
        } else if (trackInfo != null && map != null) {
            String string = trackInfo.getString("usercode");
            String string2 = trackInfo.getString("titlelabel");
            putMap("city", trackInfo.getString("city"), map);
            putMap("titlelabel", string2, map);
            putMap("usercode", string, map);
            if (z) {
                putMap(za.PRE_CONTENT_ID, str2, map);
                putMap(za.PRE_CONTENT_TYPE, str, map);
            }
        }
    }

    public static boolean isTrackInfoValid(TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1383885652")) {
            return trackInfo != null && !TextUtils.isEmpty(trackInfo.trackB) && !TextUtils.isEmpty(trackInfo.trackC);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1383885652", new Object[]{trackInfo})).booleanValue();
    }

    public static void putMap(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360867124")) {
            ipChange.ipc$dispatch("360867124", new Object[]{str, str2, map});
        } else if (map != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.NoteContract.Presenter
    public void editClick(NoteContract.View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898412847")) {
            ipChange.ipc$dispatch("898412847", new Object[]{this, view, noteBean, Integer.valueOf(i)});
            return;
        }
        if (isTrackInfoValid(this.mTrackInfo)) {
            HashMap hashMap = new HashMap();
            if (this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(this.mTrackInfo.getArgsMap());
            }
            putMap("alg", noteBean.alg, hashMap);
            fillMap(false, this.mTrackInfo, hashMap, noteBean.getCardType(), noteBean.id);
            TrackType trackType = TrackType.click;
            View rootView = view.getRootView();
            TrackInfo trackInfo = this.mTrackInfo;
            String str = trackInfo.trackB;
            String str2 = trackInfo.trackC;
            userTrack(trackType, rootView, str, str2, "card_" + i, hashMap, true);
        }
        if (noteBean != null && noteBean.project != null) {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, noteBean.project.id);
            bundle.putString("projectName", noteBean.project.name);
            bundle.putString("projectImage", noteBean.project.verticalPic);
            DMNav.from(getContext().getActivity()).withExtras(bundle).toUri(NavUri.b(wk.PROJECT_DETAIL_PAGE));
        }
    }

    @Override // cn.damai.tetris.component.discover.mvp.NoteContract.Presenter
    public void itemClick(NoteContract.View view, NoteBean noteBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048634")) {
            ipChange.ipc$dispatch("-1048634", new Object[]{this, view, noteBean, Integer.valueOf(i)});
        } else if (noteBean != null && getContext() != null) {
            if (isTrackInfoValid(this.mTrackInfo)) {
                HashMap hashMap = new HashMap();
                if (this.mTrackInfo.getArgsMap() != null) {
                    hashMap.putAll(this.mTrackInfo.getArgsMap());
                }
                putMap("alg", noteBean.alg, hashMap);
                fillMap(false, this.mTrackInfo, hashMap, noteBean.getCardType(), noteBean.id);
                TrackType trackType = TrackType.click;
                View rootView = view.getRootView();
                TrackInfo trackInfo = this.mTrackInfo;
                String str = trackInfo.trackB;
                String str2 = trackInfo.trackC;
                userTrack(trackType, rootView, str, str2, "card_" + i, hashMap, true);
            }
            Activity activity = getContext().getActivity();
            Bundle bundle = new Bundle();
            bundle.putString("contentId", noteBean.id);
            bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
            NavProxy.from(activity).withExtras(bundle).toUri(INavUri.page(gr.DISCOVER_CONTENT_DETAIL));
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "381226759")) {
            ipChange.ipc$dispatch("381226759", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(NoteModel noteModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696921715")) {
            ipChange.ipc$dispatch("696921715", new Object[]{this, noteModel});
            return;
        }
        NoteBean bean = noteModel.getBean();
        this.mTrackInfo = noteModel.getTrackInfo();
        NoteView noteView = (NoteView) getView();
        noteView.setData(bean, bean.pos);
        if (isTrackInfoValid(this.mTrackInfo)) {
            HashMap hashMap = new HashMap();
            if (this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(this.mTrackInfo.getArgsMap());
            }
            putMap("alg", bean.alg, hashMap);
            fillMap(true, this.mTrackInfo, hashMap, bean.getCardType(), bean.id);
            TrackType trackType = TrackType.expose;
            View rootView = noteView.getRootView();
            TrackInfo trackInfo = this.mTrackInfo;
            String str = trackInfo.trackB;
            String str2 = trackInfo.trackC;
            userTrack(trackType, rootView, str, str2, "card_" + bean.pos, hashMap, true);
        }
    }
}
