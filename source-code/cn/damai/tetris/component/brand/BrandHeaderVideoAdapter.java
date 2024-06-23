package cn.damai.tetris.component.brand;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.player.DMVideoPlayer;
import cn.damai.player.controller.home.DMVideoPlayerHomeController;
import cn.damai.player.listener.OnPlayerUTReportListener;
import cn.damai.tetris.component.brand.BrandHeaderContract;
import cn.damai.tetris.component.brand.bean.ProjectDO;
import cn.damai.tetris.component.brand.bean.ProjectVideoBean;
import cn.damai.tetris.component.brand.view.DmPlayerStateController;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.nav.INavUri;
import cn.damai.uikit.nav.NavProxy;
import cn.damai.videoplayer.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.n42;
import tb.v50;
import tb.wk;

/* compiled from: Taobao */
public class BrandHeaderVideoAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<ProjectVideoBean> a;
    private HashMap<Integer, WeakReference<View>> b = new HashMap<>();
    private Context c;
    private DMVideoPlayer d;
    private final View e;
    DmPlayerStateController f;
    private int g = 0;
    BrandHeaderPresenter h;
    ArrayList<VideoInfo> i = new ArrayList<>();
    private OnPlayerUTReportListener j = new b();

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectDO a;

        a(ProjectDO projectDO) {
            this.a = projectDO;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-440045490")) {
                ipChange.ipc$dispatch("-440045490", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, this.a.getId());
            bundle.putString("projectName", this.a.getName());
            bundle.putString("projectImage", this.a.getVerticalPic());
            NavProxy.from(BrandHeaderVideoAdapter.this.c).withExtras(bundle).toUri(INavUri.page(wk.PROJECT_DETAIL_PAGE));
        }
    }

    /* compiled from: Taobao */
    public class b implements OnPlayerUTReportListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void fullScreenBtnClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "132487809")) {
                ipChange.ipc$dispatch("132487809", new Object[]{this, str});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onMuteBtnClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-99698657")) {
                ipChange.ipc$dispatch("-99698657", new Object[]{this, str, Integer.valueOf(i)});
                return;
            }
            BrandHeaderVideoAdapter.this.g = i;
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onPauseOrPlayClick(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-689091819")) {
                ipChange.ipc$dispatch("-689091819", new Object[]{this, str, Integer.valueOf(i)});
            } else if (BrandHeaderVideoAdapter.this.d != null) {
                int i2 = -1;
                VideoInfo videoInfo = null;
                try {
                    i2 = ((Integer) BrandHeaderVideoAdapter.this.d.getTag()).intValue();
                    videoInfo = BrandHeaderVideoAdapter.this.i.get(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (videoInfo == null) {
                    Log.e("BrandHeaderVideoAdapter", "onPauseOrPlayClick error: VideoInfo is null");
                    return;
                }
                BrandHeaderVideoAdapter brandHeaderVideoAdapter = BrandHeaderVideoAdapter.this;
                brandHeaderVideoAdapter.k("", brandHeaderVideoAdapter.i, new ArrayList<>(), i2);
                HashMap hashMap = new HashMap();
                if (!(BrandHeaderVideoAdapter.this.h.getModel() == null || ((BrandHeaderContract.Model) BrandHeaderVideoAdapter.this.h.getModel()).getTrackInfo() == null)) {
                    hashMap.putAll(((BrandHeaderContract.Model) BrandHeaderVideoAdapter.this.h.getModel()).getTrackInfo().getArgsMap());
                }
                if (videoInfo.getProjectInfo() != null) {
                    hashMap.put("item_id", videoInfo.getProjectInfo().id);
                }
                hashMap.put("video_id", videoInfo.getVideoId());
                BrandHeaderPresenter brandHeaderPresenter = BrandHeaderVideoAdapter.this.h;
                brandHeaderPresenter.userTrackClick("video_" + i2, hashMap, true);
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void onSeekBarClick(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "519705180")) {
                ipChange.ipc$dispatch("519705180", new Object[]{this, str});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void playEnd(String str, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1662969452")) {
                ipChange.ipc$dispatch("-1662969452", new Object[]{this, str, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void playStart(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1559811224")) {
                ipChange.ipc$dispatch("-1559811224", new Object[]{this, str});
            }
        }

        @Override // cn.damai.player.listener.OnPlayerUTReportListener
        public void returnSmallScreen(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1645538323")) {
                ipChange.ipc$dispatch("1645538323", new Object[]{this, str});
            }
        }
    }

    public BrandHeaderVideoAdapter(List<ProjectVideoBean> list, Context context, View view, BrandHeaderPresenter brandHeaderPresenter) {
        this.a = list;
        this.h = brandHeaderPresenter;
        for (ProjectVideoBean projectVideoBean : list) {
            VideoInfo transform = projectVideoBean.getVideoDO().transform();
            if (projectVideoBean.getProjectDO() != null) {
                ProjectDO projectDO = projectVideoBean.getProjectDO();
                VideoInfo.ProjectInfo projectInfo = new VideoInfo.ProjectInfo();
                projectInfo.id = projectDO.getId();
                projectInfo.name = projectDO.getName();
                projectInfo.priceStr = projectDO.getPriceStr();
                projectInfo.showTime = projectDO.getShowTime();
                projectInfo.subTitle = projectDO.getSubTitle();
                projectInfo.venueCity = projectDO.getVenueCity();
                projectInfo.verticalPic = projectDO.getVerticalPic();
                transform.setProjectInfo(projectInfo);
            }
            this.i.add(transform);
        }
        this.c = context;
        this.e = view;
    }

    private ProjectVideoBean d(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1153961239")) {
            return (ProjectVideoBean) ipChange.ipc$dispatch("1153961239", new Object[]{this, Integer.valueOf(i2)});
        }
        List<ProjectVideoBean> list = this.a;
        if (list == null) {
            return null;
        }
        return list.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2053748749")) {
            ipChange.ipc$dispatch("-2053748749", new Object[]{this, viewGroup, Integer.valueOf(i2), obj});
            return;
        }
        Log.d("adapterplay", "destroyItem:" + i2);
        this.b.size();
    }

    public ArrayList<VideoInfo> e() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-441477996")) {
            return this.i;
        }
        return (ArrayList) ipChange.ipc$dispatch("-441477996", new Object[]{this});
    }

    public void f(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1348878132")) {
            ipChange.ipc$dispatch("-1348878132", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.d;
        if (dMVideoPlayer != null && dMVideoPlayer.getController() != null) {
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.d.getController().findViewById(R$id.yk_player_voice_btn);
            if (dMIconFontTextView != null) {
                if (this.g == 0) {
                    dMIconFontTextView.setText(this.c.getText(R$string.iconfont_shengyinguan22));
                } else {
                    dMIconFontTextView.setText(this.c.getText(R$string.iconfont_shengyinkai22));
                }
            }
            this.d.mute(this.g);
        }
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685804801")) {
            ipChange.ipc$dispatch("-685804801", new Object[]{this});
            return;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (!(this.b.get(Integer.valueOf(i2)) == null || this.b.get(Integer.valueOf(i2)).get() == null)) {
                ((DMVideoPlayer) this.b.get(Integer.valueOf(i2)).get().getTag()).pause(false);
                ((DMVideoPlayer) this.b.get(Integer.valueOf(i2)).get().getTag()).stop();
                ((DMVideoPlayer) this.b.get(Integer.valueOf(i2)).get().getTag()).release();
                this.b.get(Integer.valueOf(i2)).get().setTag(null);
            }
        }
        this.b.clear();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1113195082")) {
            return ((Integer) ipChange.ipc$dispatch("1113195082", new Object[]{this})).intValue();
        }
        List<ProjectVideoBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void h(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1978418189")) {
            ipChange.ipc$dispatch("1978418189", new Object[]{this, Integer.valueOf(i2)});
        } else if (i2 < this.b.size() && this.b.get(Integer.valueOf(i2)).get() != null) {
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                if (!(this.b.get(Integer.valueOf(i3)) == null || this.b.get(Integer.valueOf(i3)).get() == null)) {
                    if (i2 == i3) {
                        DMVideoPlayer dMVideoPlayer = (DMVideoPlayer) this.b.get(Integer.valueOf(i3)).get().getTag();
                        this.d = dMVideoPlayer;
                        this.f.a(dMVideoPlayer);
                        this.d.setOptHelper(this.f);
                        Log.e("DMVideoPlayerxw", "onSelected :" + i2 + " , state === : " + this.d.getCurrentState());
                        if (this.d.isPlayInited() && this.d.getCurrentState() != 7) {
                            this.d.start();
                            f(this.g);
                        } else if (d(i3) != null) {
                            this.d.setVideoData(this.i.get(i3));
                            f(this.g);
                        }
                    } else {
                        ((DMVideoPlayer) this.b.get(Integer.valueOf(i3)).get().getTag()).pause(false);
                    }
                }
            }
        }
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942274876")) {
            ipChange.ipc$dispatch("-942274876", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.d;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.pause(false);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1468206901")) {
            return ipChange.ipc$dispatch("-1468206901", new Object[]{this, viewGroup, Integer.valueOf(i2)});
        }
        if (this.b.get(Integer.valueOf(i2)) != null) {
            view = this.b.get(Integer.valueOf(i2)).get();
            ((ViewGroup) view.getParent()).removeView(view);
            Log.e("DMVideoPlayerxw", "instantiateItem :" + i2);
        } else {
            view = LayoutInflater.from(this.c).inflate(R$layout.brand_header_video_layout, (ViewGroup) null);
            if (d(i2) == null || d(i2).getProjectDO() == null) {
                view.findViewById(cn.damai.commonbusiness.R$id.brand_header_videotitle).setVisibility(8);
                view.findViewById(cn.damai.commonbusiness.R$id.brand_header_videotitle_arrow).setVisibility(8);
            } else {
                ProjectDO projectDO = d(i2).getProjectDO();
                TextView textView = (TextView) view.findViewById(cn.damai.commonbusiness.R$id.brand_header_videotitle);
                if (!TextUtils.isEmpty(projectDO.getName())) {
                    textView.setVisibility(0);
                    view.findViewById(cn.damai.commonbusiness.R$id.brand_header_videotitle_arrow).setVisibility(0);
                    textView.setText(projectDO.getName());
                    textView.setOnClickListener(new a(projectDO));
                } else {
                    textView.setVisibility(8);
                    view.findViewById(cn.damai.commonbusiness.R$id.brand_header_videotitle_arrow).setVisibility(8);
                }
            }
            DMVideoPlayer dMVideoPlayer = (DMVideoPlayer) view.findViewById(cn.damai.commonbusiness.R$id.brand_header_player);
            DMVideoPlayerHomeController dMVideoPlayerHomeController = new DMVideoPlayerHomeController(this.c);
            dMVideoPlayerHomeController.enableAutoVoice(this.c);
            dMVideoPlayerHomeController.setAutoReport(true);
            if (this.h.getModel() == null || ((BrandHeaderContract.Model) this.h.getModel()).getTrackInfo() == null) {
                dMVideoPlayerHomeController.setSpmData("brand", "top");
            } else {
                dMVideoPlayerHomeController.setSpmData(((BrandHeaderContract.Model) this.h.getModel()).getTrackInfo().trackB, ((BrandHeaderContract.Model) this.h.getModel()).getTrackInfo().trackC);
            }
            dMVideoPlayer.setController(dMVideoPlayerHomeController);
            dMVideoPlayerHomeController.setBottomPadding(v50.a(this.c, -12.0f));
            dMVideoPlayerHomeController.setUTReportListener(this.j);
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            dMVideoPlayer.setVideoPlayerSize(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - n42.a(this.c, 42.0f), n42.a(this.c, 188.0f));
            dMVideoPlayer.stop();
            dMVideoPlayer.setTag(Integer.valueOf(i2));
            Log.e("DMVideoPlayerxw", "setTag :" + i2);
            if (i2 == 0 && d(i2) != null) {
                this.d = dMVideoPlayer;
                DmPlayerStateController dmPlayerStateController = new DmPlayerStateController((RecyclerView) this.e.getParent(), this.e, this.d);
                this.f = dmPlayerStateController;
                this.d.setOptHelper(dmPlayerStateController);
                dMVideoPlayer.setVideoData(this.i.get(i2));
                f(this.g);
            }
            this.b.put(Integer.valueOf(i2), new WeakReference<>(view));
            view.setTag(dMVideoPlayer);
        }
        Log.d("adapterplay", "play:" + i2);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "363392186")) {
            return view == obj;
        }
        return ((Boolean) ipChange.ipc$dispatch("363392186", new Object[]{this, view, obj})).booleanValue();
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-899170088")) {
            ipChange.ipc$dispatch("-899170088", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.d;
        if (dMVideoPlayer != null) {
            dMVideoPlayer.start();
            f(this.g);
        }
    }

    public void k(String str, ArrayList<VideoInfo> arrayList, ArrayList<PicInfo> arrayList2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2015583813")) {
            ipChange.ipc$dispatch("-2015583813", new Object[]{this, str, arrayList, arrayList2, Integer.valueOf(i2)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("projectId", str);
        bundle.putParcelableArrayList("video_info", arrayList);
        bundle.putParcelableArrayList("pic_info", arrayList2);
        bundle.putInt("position", i2);
        DMNav.from(this.c).withExtras(bundle).toUri(NavUri.b("videobrowse"));
    }
}
