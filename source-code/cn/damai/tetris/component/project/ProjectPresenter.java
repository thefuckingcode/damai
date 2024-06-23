package cn.damai.tetris.component.project;

import android.text.TextUtils;
import android.view.View;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.project.ProjectContract;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.qa;
import tb.s50;
import tb.tb2;
import tb.w9;

/* compiled from: Taobao */
public class ProjectPresenter extends BasePresenter<ProjectContract.Model, ProjectContract.View, BaseSection> implements ProjectContract.Presenter<ProjectContract.Model, ProjectContract.View, BaseSection> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TrackInfo mTrackInfo;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectContract.Model a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        a(ProjectContract.Model model, String str, String str2) {
            this.a = model;
            this.b = str;
            this.c = str2;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-432657083")) {
                ipChange.ipc$dispatch("-432657083", new Object[]{this, view});
                return;
            }
            ProjectItemBean bean = this.a.getBean();
            HashMap hashMap = new HashMap();
            if (ProjectPresenter.this.mTrackInfo.getArgsMap() != null) {
                hashMap.putAll(ProjectPresenter.this.mTrackInfo.getArgsMap());
            }
            hashMap.put("titlelabel", this.b);
            if (!TextUtils.isEmpty(bean.id)) {
                hashMap.put("item_id", bean.id);
            }
            hashMap.put("card_type", "4");
            hashMap.put("city", this.c);
            if (!TextUtils.isEmpty(bean.alg)) {
                hashMap.put("alg", bean.alg);
            }
            ProjectPresenter projectPresenter = ProjectPresenter.this;
            TrackType trackType = TrackType.click;
            String str = projectPresenter.mTrackInfo.trackB;
            String str2 = ProjectPresenter.this.mTrackInfo.trackC;
            projectPresenter.userTrack(trackType, view, str, str2, "item_" + this.a.getIndex(), hashMap, true);
            tb2.b(ProjectPresenter.this.getContext().getActivity(), bean.schema, bean.id, bean.name, bean.verticalPic);
        }
    }

    public ProjectPresenter(ProjectView projectView, String str, w9 w9Var) {
        super(projectView, str, w9Var);
    }

    public static boolean isTrackInfoValid(TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1328502487")) {
            return trackInfo != null && !TextUtils.isEmpty(trackInfo.trackB) && !TextUtils.isEmpty(trackInfo.trackC);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1328502487", new Object[]{trackInfo})).booleanValue();
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315077116")) {
            ipChange.ipc$dispatch("-1315077116", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(ProjectContract.Model model) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266770973")) {
            ipChange.ipc$dispatch("1266770973", new Object[]{this, model});
            return;
        }
        TrackInfo trackInfo = model.getTrackInfo();
        this.mTrackInfo = trackInfo;
        String str2 = "";
        if (trackInfo != null) {
            str2 = trackInfo.getString(qa.TRACKKEY_CATEGORY_NAME);
            str = this.mTrackInfo.getString(qa.TRACKKEY_CITY);
        } else {
            str = str2;
        }
        if (model.getBean() != null) {
            ((ProjectContract.View) getView()).getHolder().u(model.getDaojishi());
            ((ProjectContract.View) getView()).getHolder().n(model.getBean(), model.ShowDis());
            if (((ProjectContract.Model) getModel()).getDaojishi() != null) {
                ((ProjectContract.Model) getModel()).getDaojishi().startTimer();
            }
            if (getContext().getActivity().getClass().getName().equals("cn.damai.homepage.MainActivity")) {
                ((ProjectContract.View) getView()).getHolder().s();
                ((ProjectContract.View) getView()).getHolder().B();
                ((ProjectContract.View) getView()).getHolder().w(s50.a(getContext().getActivity(), 76.0f), s50.a(getContext().getActivity(), 101.0f));
            }
            ((ProjectContract.View) getView()).getRootView().setOnClickListener(new a(model, str2, str));
            ProjectItemBean bean = model.getBean();
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", str2);
            if (!TextUtils.isEmpty(bean.id)) {
                hashMap.put("item_id", bean.id);
            }
            hashMap.put("city", str);
            hashMap.put("card_type", "4");
            if (!TextUtils.isEmpty(bean.alg)) {
                hashMap.put("alg", bean.alg);
            }
            String gotMarketUTValue = bean.gotMarketUTValue();
            if (!TextUtils.isEmpty(gotMarketUTValue)) {
                hashMap.put("discount_type", gotMarketUTValue);
            }
            TrackType trackType = TrackType.expose;
            View rootView = ((ProjectContract.View) getView()).getRootView();
            TrackInfo trackInfo2 = this.mTrackInfo;
            String str3 = trackInfo2.trackB;
            String str4 = trackInfo2.trackC;
            userTrack(trackType, rootView, str3, str4, "item_" + model.getIndex(), hashMap, true);
        }
    }
}
