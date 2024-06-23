package cn.damai.tetris.component.star.content.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.login.LoginManager;
import cn.damai.player.DMVideoPlayer;
import cn.damai.tetris.component.star.content.base.bean.ContentItemBean;
import cn.damai.tetris.component.star.content.base.bean.ContentVideoBean;
import cn.damai.tetris.component.star.content.common.ContentPraiseRequest;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.ClickGrayImageView;
import cn.damai.uikit.view.NineGridlayout;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.uikit.view.StrokeLinearLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.utils.OPRUtils;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;
import tb.fn;
import tb.gr;
import tb.od2;
import tb.up2;
import tb.v50;
import tb.xf2;

/* compiled from: Taobao */
public class ContentBaseViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private BasePresenter b;
    private String c;
    private boolean d = false;
    private int e = 0;
    private TextView f;
    private TextView g;
    private TextView h;
    private StrokeLinearLayout i;
    private FrameLayout j;
    private RoundImageView k;
    private ImageView l;
    private TextView m;
    private DMVideoPlayer n;
    private NineGridlayout o;
    private TextView p;
    private TextView q;
    private TextView r;
    private boolean s = true;
    private View t;

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        a(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "807092062")) {
                ipChange.ipc$dispatch("807092062", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getContentId());
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CONTENT_DETAIL));
            Map<String, String> a2 = fn.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.b, a2, true);
        }
    }

    /* compiled from: Taobao */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        b(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "734705504")) {
                ipChange.ipc$dispatch("734705504", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getContentId());
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CONTENT_DETAIL));
            Map<String, String> a2 = fn.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.b, a2, true);
        }
    }

    /* compiled from: Taobao */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;
        final /* synthetic */ ContentItemBean b;
        final /* synthetic */ int c;

        c(List list, ContentItemBean contentItemBean, int i) {
            this.a = list;
            this.b = contentItemBean;
            this.c = i;
        }

        public void onClick(View view) {
            View view2;
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "-1448971423")) {
                ipChange.ipc$dispatch("-1448971423", new Object[]{this, view});
                return;
            }
            if (view instanceof NineGridlayout) {
                view2 = (NineGridlayout) view;
            } else if (view instanceof ClickGrayImageView) {
                view2 = (ClickGrayImageView) view;
            } else {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("images", (ArrayList) this.a);
            if (view2.getTag() != null) {
                try {
                    i = Integer.parseInt(view2.getTag() + "");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            bundle.putInt("location", i);
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("gallery_images"));
            Map<String, String> a2 = fn.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.b.getContentId(), this.b.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.c, a2, true);
        }
    }

    /* compiled from: Taobao */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        d(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "662318946")) {
                ipChange.ipc$dispatch("662318946", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("contentId", this.a.getContentId());
            DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(gr.DISCOVER_CONTENT_DETAIL));
            Map<String, String> a2 = fn.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
            BasePresenter basePresenter = ContentBaseViewHolder.this.b;
            basePresenter.userTrackClick("card_" + this.b, a2, true);
        }
    }

    /* compiled from: Taobao */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ContentItemBean a;
        final /* synthetic */ int b;

        e(ContentItemBean contentItemBean, int i) {
            this.a = contentItemBean;
            this.b = i;
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1521357981")) {
                ipChange.ipc$dispatch("-1521357981", new Object[]{this, view});
                return;
            }
            ContentVideoBean video = this.a.getVideo();
            if (video != null) {
                Bundle bundle = new Bundle();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setPicUrl(video.getPicUrl());
                if (!TextUtils.isEmpty(video.getVid())) {
                    videoInfo.setVid(video.getVid());
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_VID);
                } else if (!TextUtils.isEmpty(video.getVideoUrl())) {
                    videoInfo.setVideoUrl(video.getVideoUrl());
                    videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                }
                arrayList.add(videoInfo);
                bundle.putParcelableArrayList("video_info", arrayList);
                bundle.putInt("position", 0);
                DMNav.from(ContentBaseViewHolder.this.a).withExtras(bundle).toUri(NavUri.b("videobrowse"));
                Map<String, String> a2 = fn.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), this.a.getContentId(), this.a.getCard());
                BasePresenter basePresenter = ContentBaseViewHolder.this.b;
                basePresenter.userTrackClick("card_" + this.b, a2, true);
            }
        }
    }

    /* compiled from: Taobao */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1593744539")) {
                ipChange.ipc$dispatch("-1593744539", new Object[]{this, view});
                return;
            }
            ContentBaseViewHolder.this.D();
        }
    }

    public ContentBaseViewHolder(Context context, LayoutInflater layoutInflater, BasePresenter basePresenter) {
        super(layoutInflater.inflate(R$layout.tetris_dm_base_content_list_item, (ViewGroup) null));
        this.a = context;
        this.b = basePresenter;
        this.q = (TextView) this.itemView.findViewById(R$id.content_item_text_main);
        this.r = (TextView) this.itemView.findViewById(R$id.content_item_text_quanwen);
        this.p = (TextView) this.itemView.findViewById(R$id.content_item_title);
        this.f = (TextView) this.itemView.findViewById(R$id.artist_club_item_date);
        this.h = (TextView) this.itemView.findViewById(R$id.tv_content_free_item_praise_num);
        this.g = (TextView) this.itemView.findViewById(R$id.content_free_praise_icon);
        this.i = (StrokeLinearLayout) this.itemView.findViewById(R$id.sll_content_item_main_container);
        this.j = (FrameLayout) this.itemView.findViewById(R$id.fl_content_item_poster_container);
        this.k = (RoundImageView) this.itemView.findViewById(R$id.image_content_item_poster);
        this.j.setVisibility(8);
        this.l = (ImageView) this.itemView.findViewById(R$id.content_item_poster_video_play_icon);
        this.m = (TextView) this.itemView.findViewById(R$id.content_item_video_time);
        NineGridlayout nineGridlayout = (NineGridlayout) this.itemView.findViewById(R$id.content_item_ninelayout);
        this.o = nineGridlayout;
        nineGridlayout.setVisibility(8);
        this.t = this.itemView.findViewById(R$id.content_item_divide_line);
    }

    private boolean A(String str) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1185594581")) {
            return "1001".equals(str) || OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM.equals(str);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1185594581", new Object[]{this, str})).booleanValue();
    }

    private boolean B() {
        Layout layout;
        int lineCount;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "449844806")) {
            return ((Boolean) ipChange.ipc$dispatch("449844806", new Object[]{this})).booleanValue();
        }
        if (!"2003".equals(this.c) ? !((layout = this.q.getLayout()) == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) : this.q.getText().length() > 140) {
            z = true;
        }
        this.s = z;
        return z;
    }

    private void C(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-259169534")) {
            ipChange.ipc$dispatch("-259169534", new Object[]{this, str, str2, str3});
            return;
        }
        E(this.f, str2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902709222")) {
            ipChange.ipc$dispatch("-902709222", new Object[]{this});
        } else if (this.s) {
            this.r.setText("收起");
            this.q.setMaxLines(10000);
            this.s = false;
        } else {
            this.r.setText("全文");
            this.q.setMaxLines(5);
            this.s = true;
        }
    }

    private void E(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1381857555")) {
            ipChange.ipc$dispatch("1381857555", new Object[]{this, textView, str});
        } else if (!xf2.j(str)) {
            textView.setText(str);
        }
    }

    private static String F(long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675384480")) {
            return (String) ipChange.ipc$dispatch("675384480", new Object[]{Long.valueOf(j2)});
        }
        String str = "";
        long j3 = j2 / DateUtils.MILLIS_PER_MINUTE;
        long round = (long) Math.round(((float) (j2 % DateUtils.MILLIS_PER_MINUTE)) / 1000.0f);
        if (j3 < 10) {
            str = str + "0";
        }
        String str2 = str + j3 + ":";
        if (round < 10) {
            str2 = str2 + "0";
        }
        return str2 + round;
    }

    static /* synthetic */ int g(ContentBaseViewHolder contentBaseViewHolder) {
        int i2 = contentBaseViewHolder.e;
        contentBaseViewHolder.e = i2 + 1;
        return i2;
    }

    static /* synthetic */ int h(ContentBaseViewHolder contentBaseViewHolder) {
        int i2 = contentBaseViewHolder.e;
        contentBaseViewHolder.e = i2 - 1;
        return i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006525588")) {
            ipChange.ipc$dispatch("2006525588", new Object[]{this, str});
            return;
        }
        this.r.setText("全文");
        this.r.setVisibility(8);
        if (B()) {
            this.r.setVisibility(0);
        }
        this.r.setOnClickListener(new f());
    }

    private static String p(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497406068")) {
            return (String) ipChange.ipc$dispatch("497406068", new Object[]{Integer.valueOf(i2)});
        } else if (i2 <= 999) {
            return String.valueOf(i2);
        } else {
            if (i2 <= 9999) {
                DecimalFormat decimalFormat = new DecimalFormat();
                decimalFormat.setMaximumFractionDigits(1);
                decimalFormat.setGroupingSize(0);
                decimalFormat.setRoundingMode(RoundingMode.FLOOR);
                return decimalFormat.format(((double) i2) / 1000.0d) + "k+";
            }
            DecimalFormat decimalFormat2 = new DecimalFormat();
            decimalFormat2.setMaximumFractionDigits(1);
            decimalFormat2.setGroupingSize(0);
            decimalFormat2.setRoundingMode(RoundingMode.FLOOR);
            return decimalFormat2.format(((double) i2) / 10000.0d) + "w+";
        }
    }

    private String r(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-557324462")) {
            return (String) ipChange.ipc$dispatch("-557324462", new Object[]{this, contentItemBean});
        } else if (contentItemBean == null) {
            return null;
        } else {
            if (contentItemBean.getCoverImage() != null) {
                return contentItemBean.getCoverImage();
            }
            if (contentItemBean.getVideo() != null) {
                return contentItemBean.getVideo().getPicUrl();
            }
            if (contentItemBean.getImages() == null || contentItemBean.getImages().size() <= 0) {
                return null;
            }
            return contentItemBean.getImages().get(0);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r7.equals("2001") == false) goto L_0x002f;
     */
    private void s(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        char c2 = 2;
        if (AndroidInstantRuntime.support(ipChange, "-485701178")) {
            ipChange.ipc$dispatch("-485701178", new Object[]{this, contentItemBean});
        } else if (contentItemBean != null && contentItemBean.getCard() != null) {
            String card = contentItemBean.getCard();
            card.hashCode();
            switch (card.hashCode()) {
                case 1507424:
                    if (card.equals("1001")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507425:
                    if (card.equals(OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1537215:
                    break;
                case 1537216:
                    if (card.equals("2002")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1537217:
                    if (card.equals("2003")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                case 3:
                    this.i.setCornerAndStroke(v50.a(this.a, 12.0f), 1, Color.parseColor("#26000000"));
                    return;
                case 2:
                case 4:
                    this.i.setCornerAndStroke(0, 0, -1);
                    return;
                default:
                    return;
            }
        }
    }

    private void t(ContentItemBean contentItemBean, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237179995")) {
            ipChange.ipc$dispatch("237179995", new Object[]{this, contentItemBean, Boolean.valueOf(z)});
        } else if (!z) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
    }

    private void u(ContentItemBean contentItemBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885380288")) {
            ipChange.ipc$dispatch("1885380288", new Object[]{this, contentItemBean, Integer.valueOf(i2)});
        } else if (this.o != null && contentItemBean != null && contentItemBean.getImages() != null && contentItemBean.getImages().size() > 0 && this.o.getVisibility() == 0) {
            List<String> images = contentItemBean.getImages();
            ArrayList arrayList = new ArrayList();
            if (xf2.e(images) > 0) {
                Iterator<String> it = images.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NineGridlayout.Image(it.next() + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0"));
                }
                this.o.setRadius(v50.a(this.a, 6.0f));
                this.o.setGap(v50.a(this.a, 3.0f));
                int d2 = ((int) up2.d(this.a)) - up2.a(this.a, 42.0f);
                if (images.size() == 1) {
                    d2 = (d2 * 2) / 3;
                }
                this.o.setTotalWidth(d2);
                this.o.updateImages(arrayList);
                if (A(contentItemBean.getCard())) {
                    this.o.setListener(new b(contentItemBean, i2));
                } else {
                    this.o.setListener(new c(images, contentItemBean, i2));
                }
            } else {
                this.o.setVisibility(8);
            }
        }
    }

    private void v(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572186811")) {
            ipChange.ipc$dispatch("-1572186811", new Object[]{this, contentItemBean});
            return;
        }
        DMImageCreator c2 = cn.damai.common.image.a.b().c(r(contentItemBean));
        int i2 = R$drawable.uikit_default_image_bg_gradient;
        c2.i(i2).c(i2).g(this.k);
        if (contentItemBean == null || contentItemBean.getVideo() == null) {
            this.m.setVisibility(8);
            return;
        }
        long videoTime = contentItemBean.getVideo().getVideoTime();
        if (videoTime > 0) {
            this.m.setText(F(videoTime));
        } else {
            this.m.setVisibility(8);
        }
    }

    private void w(ContentItemBean contentItemBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34517826")) {
            ipChange.ipc$dispatch("34517826", new Object[]{this, contentItemBean, Integer.valueOf(i2)});
            return;
        }
        String card = contentItemBean.getCard();
        char c2 = 65535;
        switch (card.hashCode()) {
            case 1507424:
                if (card.equals("1001")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1507425:
                if (card.equals(OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1537215:
                if (card.equals("2001")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1537216:
                if (card.equals("2002")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1537217:
                if (card.equals("2003")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            this.j.setVisibility(0);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else if (c2 == 1) {
            this.j.setVisibility(8);
            this.o.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        } else if (c2 == 2 || c2 == 3) {
            this.j.setVisibility(0);
            this.l.setVisibility(0);
            this.o.setVisibility(8);
            this.m.setVisibility(0);
        } else {
            this.j.setVisibility(8);
            this.o.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
        }
        if (this.j.getVisibility() == 0) {
            v(contentItemBean);
        }
        if (this.o.getVisibility() == 0) {
            u(contentItemBean, i2);
        }
    }

    private void x(final ContentItemBean contentItemBean, final int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869913933")) {
            ipChange.ipc$dispatch("1869913933", new Object[]{this, contentItemBean, Integer.valueOf(i2)});
        } else if (contentItemBean.getPraiseInfo() == null) {
            TextView textView = this.g;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            this.d = contentItemBean.getPraiseInfo().getHasPraised();
            this.e = contentItemBean.getPraiseInfo().getPraiseCount();
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            int i3 = this.e;
            if (i3 == 0) {
                this.h.setText("点赞");
                this.h.setTextColor(Color.parseColor("#9c9ca5"));
            } else {
                this.h.setText(p(i3));
                this.h.setTextColor(this.a.getResources().getColor(R$color.text_color_black));
            }
            if (this.d) {
                this.g.setTextColor(Color.parseColor("#FF983A"));
                this.g.setText(this.a.getResources().getString(R$string.iconfont_dianzanmian_));
            } else {
                this.g.setTextColor(this.a.getResources().getColor(R$color.color_nozan));
                this.g.setText(this.a.getResources().getString(R$string.iconfont_dianzan_));
            }
            if (this.g.getVisibility() == 0) {
                BasePresenter basePresenter = this.b;
                TextView textView3 = this.g;
                basePresenter.userTrackExpose(textView3, "favourite_" + i2);
            }
            AnonymousClass2 r0 = new View.OnClickListener() {
                /* class cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1376584865")) {
                        ipChange.ipc$dispatch("-1376584865", new Object[]{this, view});
                    } else if (!TextUtils.isEmpty(contentItemBean.getContentId())) {
                        if (!LoginManager.k().q()) {
                            DMNav.from(ContentBaseViewHolder.this.a).forResult(100).toUri(NavUri.b("login"));
                            return;
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.3f, 1.0f);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.3f, 1.0f);
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 1.0f);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(1000L);
                        animatorSet.setInterpolator(new od2(0.3f));
                        animatorSet.playTogether(ofFloat3, ofFloat, ofFloat2);
                        animatorSet.start();
                        ContentPraiseRequest contentPraiseRequest = new ContentPraiseRequest();
                        contentPraiseRequest.targetId = contentItemBean.getSourceId();
                        String str = "1";
                        contentPraiseRequest.targetType = str;
                        if (!ContentBaseViewHolder.this.d) {
                            str = "0";
                        }
                        contentPraiseRequest.operate = str;
                        if (ContentBaseViewHolder.this.e != 0 || !ContentBaseViewHolder.this.d) {
                            contentPraiseRequest.request(new DMMtopRequestListener<JSONObject>(JSONObject.class) {
                                /* class cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.AnonymousClass2.AnonymousClass1 */
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                                public void onFail(String str, String str2) {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "563011346")) {
                                        ipChange.ipc$dispatch("563011346", new Object[]{this, str, str2});
                                        return;
                                    }
                                    ContentBaseViewHolder.this.d = false;
                                }

                                public void onSuccess(JSONObject jSONObject) {
                                    IpChange ipChange = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange, "1895738579")) {
                                        ipChange.ipc$dispatch("1895738579", new Object[]{this, jSONObject});
                                    } else if (jSONObject != null) {
                                        if (ContentBaseViewHolder.this.d) {
                                            ContentBaseViewHolder.h(ContentBaseViewHolder.this);
                                            if (ContentBaseViewHolder.this.e < 0) {
                                                ContentBaseViewHolder.this.e = 0;
                                            }
                                            if (ContentBaseViewHolder.this.e == 0) {
                                                ContentBaseViewHolder.this.h.setText("赞");
                                            } else {
                                                TextView textView = ContentBaseViewHolder.this.h;
                                                textView.setText(ContentBaseViewHolder.this.e + "");
                                            }
                                            ContentBaseViewHolder.this.h.setTextColor(ContentBaseViewHolder.this.a.getResources().getColor(R$color.text_color_black));
                                            ContentBaseViewHolder.this.g.setTextColor(ContentBaseViewHolder.this.a.getResources().getColor(R$color.color_nozan));
                                            ContentBaseViewHolder.this.g.setText(ContentBaseViewHolder.this.a.getResources().getString(R$string.iconfont_dianzan_));
                                        } else {
                                            ContentBaseViewHolder.g(ContentBaseViewHolder.this);
                                            TextView textView2 = ContentBaseViewHolder.this.h;
                                            textView2.setText(ContentBaseViewHolder.this.e + "");
                                            ContentBaseViewHolder.this.h.setTextColor(ContentBaseViewHolder.this.a.getResources().getColor(R$color.text_color_black));
                                            ContentBaseViewHolder.this.g.setTextColor(Color.parseColor("#FF983A"));
                                            ContentBaseViewHolder.this.g.setText(ContentBaseViewHolder.this.a.getResources().getString(R$string.iconfont_dianzanmian_));
                                        }
                                        ContentBaseViewHolder contentBaseViewHolder = ContentBaseViewHolder.this;
                                        contentBaseViewHolder.d = !contentBaseViewHolder.d;
                                        Map<String, String> a = fn.a(ContentBaseViewHolder.this.b.getModel().getTrackInfo().getArgsMap(), contentItemBean.getContentId(), contentItemBean.getCard());
                                        BasePresenter basePresenter = ContentBaseViewHolder.this.b;
                                        basePresenter.userTrackClick("favorite_" + i2, a, true);
                                    }
                                }
                            });
                        }
                    }
                }
            };
            this.g.setOnClickListener(r0);
            this.h.setOnClickListener(r0);
        }
    }

    private void y(ContentItemBean contentItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336429019")) {
            ipChange.ipc$dispatch("-1336429019", new Object[]{this, contentItemBean});
            return;
        }
        final String card = contentItemBean.getCard();
        if (!TextUtils.isEmpty(contentItemBean.getContent())) {
            this.q.setVisibility(0);
            this.q.setText(contentItemBean.getContent());
            this.q.post(new Runnable() {
                /* class cn.damai.tetris.component.star.content.base.ContentBaseViewHolder.AnonymousClass7 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1192615116")) {
                        ipChange.ipc$dispatch("1192615116", new Object[]{this});
                        return;
                    }
                    ContentBaseViewHolder.this.o(card);
                }
            });
        } else {
            this.q.setVisibility(8);
        }
        if (!TextUtils.isEmpty(contentItemBean.getTitle())) {
            this.p.setVisibility(0);
            this.p.setText(contentItemBean.getTitle());
            return;
        }
        this.p.setVisibility(8);
    }

    private void z(ContentItemBean contentItemBean, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1915645754")) {
            ipChange.ipc$dispatch("-1915645754", new Object[]{this, contentItemBean, Integer.valueOf(i2)});
        } else if (contentItemBean != null && contentItemBean.getVideo() != null) {
            if (A(contentItemBean.getCard())) {
                this.j.setOnClickListener(new d(contentItemBean, i2));
                return;
            }
            this.j.setOnClickListener(new e(contentItemBean, i2));
        }
    }

    public void G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039051286")) {
            ipChange.ipc$dispatch("-2039051286", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.n;
        if (dMVideoPlayer != null && dMVideoPlayer.isPlaying()) {
            this.n.stop();
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217850000")) {
            ipChange.ipc$dispatch("-1217850000", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.n;
        if (dMVideoPlayer != null && dMVideoPlayer.isPause()) {
            this.n.start();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (r0.equals("2003") == false) goto L_0x0036;
     */
    public void n(ContentItemBean contentItemBean, int i2, boolean z) {
        IpChange ipChange = $ipChange;
        char c2 = 4;
        if (AndroidInstantRuntime.support(ipChange, "-1787937906")) {
            ipChange.ipc$dispatch("-1787937906", new Object[]{this, contentItemBean, Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        String card = contentItemBean.getCard();
        this.c = card;
        card.hashCode();
        switch (card.hashCode()) {
            case 1507424:
                if (card.equals("1001")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1507425:
                if (card.equals(OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1537215:
                if (card.equals("2001")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1537216:
                if (card.equals("2002")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1537217:
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 2:
                FrameLayout frameLayout = this.j;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                NineGridlayout nineGridlayout = this.o;
                if (nineGridlayout != null) {
                    nineGridlayout.setVisibility(0);
                    break;
                }
                break;
            case 1:
            case 3:
                FrameLayout frameLayout2 = this.j;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                }
                NineGridlayout nineGridlayout2 = this.o;
                if (nineGridlayout2 != null) {
                    nineGridlayout2.setVisibility(8);
                    break;
                }
                break;
            case 4:
                FrameLayout frameLayout3 = this.j;
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(8);
                }
                NineGridlayout nineGridlayout3 = this.o;
                if (nineGridlayout3 != null) {
                    nineGridlayout3.setVisibility(8);
                    break;
                }
                break;
        }
        C(contentItemBean.getContent(), contentItemBean.getReleaseTime(), r(contentItemBean));
        y(contentItemBean);
        x(contentItemBean, i2);
        t(contentItemBean, z);
        s(contentItemBean);
        w(contentItemBean, i2);
        z(contentItemBean, i2);
        this.i.setOnClickListener(new a(contentItemBean, i2));
    }

    public void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910157154")) {
            ipChange.ipc$dispatch("1910157154", new Object[]{this});
            return;
        }
        DMVideoPlayer dMVideoPlayer = this.n;
        if (dMVideoPlayer != null && dMVideoPlayer.isPlaying()) {
            this.n.stop();
        }
    }
}
