package cn.damai.comment.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.uikit.view.NineGridlayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.up2;
import tb.xs0;

/* compiled from: Taobao */
public class NineImgUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public interface OnClickExtraListener {
        void onExtraLister(int i);
    }

    /* compiled from: Taobao */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnClickExtraListener a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Context c;
        final /* synthetic */ ArrayList d;

        a(OnClickExtraListener onClickExtraListener, ArrayList arrayList, Context context, ArrayList arrayList2) {
            this.a = onClickExtraListener;
            this.b = arrayList;
            this.c = context;
            this.d = arrayList2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0084  */
        public void onClick(View view) {
            int i;
            OnClickExtraListener onClickExtraListener;
            IpChange ipChange = $ipChange;
            boolean z = false;
            if (AndroidInstantRuntime.support(ipChange, "1154850604")) {
                ipChange.ipc$dispatch("1154850604", new Object[]{this, view});
            } else if (view.getTag() != null) {
                if (view.getTag() != null) {
                    try {
                        i = Integer.parseInt(view.getTag() + "");
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                    onClickExtraListener = this.a;
                    if (onClickExtraListener != null) {
                        onClickExtraListener.onExtraLister(i);
                    }
                    if (this.b.size() == 1 && this.b.get(0) == null) {
                        z = true;
                    }
                    if (i != 0 && z) {
                        ToastUtil.a().j(xs0.a(), "该视频还在处理中哦~");
                        return;
                    } else if (!z) {
                        NineImgUtil.this.d(this.c, 0, new ArrayList<>(), this.d, i - 1);
                        return;
                    } else {
                        NineImgUtil.this.d(this.c, 0, this.b, this.d, i);
                        return;
                    }
                }
                i = 0;
                onClickExtraListener = this.a;
                if (onClickExtraListener != null) {
                }
                z = true;
                if (i != 0) {
                }
                if (!z) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b {
        private static final NineImgUtil a = new NineImgUtil();
    }

    public static final NineImgUtil a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-962867247") ? (NineImgUtil) ipChange.ipc$dispatch("-962867247", new Object[0]) : b.a;
    }

    public void b(Context context, int i, boolean z, NineGridlayout nineGridlayout, CommentsItemBean commentsItemBean, List<CommentImageInfoBean> list, OnClickExtraListener onClickExtraListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1715990146")) {
            ipChange.ipc$dispatch("1715990146", new Object[]{this, context, Integer.valueOf(i), Boolean.valueOf(z), nineGridlayout, commentsItemBean, list, onClickExtraListener});
            return;
        }
        c(context, i, z, false, nineGridlayout, commentsItemBean, list, onClickExtraListener, null);
    }

    public void c(Context context, int i, boolean z, boolean z2, NineGridlayout nineGridlayout, CommentsItemBean commentsItemBean, List<CommentImageInfoBean> list, OnClickExtraListener onClickExtraListener, Integer num) {
        List<CommentImageInfoBean> list2 = list;
        IpChange ipChange = $ipChange;
        int i2 = 9;
        if (AndroidInstantRuntime.support(ipChange, "-1964292349")) {
            ipChange.ipc$dispatch("-1964292349", new Object[]{this, context, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), nineGridlayout, commentsItemBean, list2, onClickExtraListener, num});
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if ((list2 == null || list.size() <= 0) && (commentsItemBean == null || commentsItemBean.getVideoDO() == null)) {
            nineGridlayout.setVisibility(8);
            return;
        }
        if (!(commentsItemBean == null || commentsItemBean.getVideoDO() == null)) {
            CommentsVideoBean videoDO = commentsItemBean.getVideoDO();
            if (videoDO.isVideoStatusUnReview()) {
                NineGridlayout.Image image = new NineGridlayout.Image("VIDEO_UNDER_REVIEW_URL");
                image.setShowPlay(true);
                arrayList.add(image);
                arrayList2.add(null);
            } else if (!TextUtils.isEmpty(videoDO.getCoverUrl()) && !TextUtils.isEmpty(videoDO.getUrl())) {
                NineGridlayout.Image image2 = new NineGridlayout.Image(videoDO.getCoverUrl() + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
                image2.setShowPlay(true);
                arrayList.add(image2);
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setPicUrl(videoDO.getCoverUrl());
                videoInfo.setVideoUrl(videoDO.getUrl());
                videoInfo.setType(VideoInfo.VideoType.VIDEO_URL);
                videoInfo.setSourceLabel(videoDO.getSourceLabel());
                arrayList2.add(videoInfo);
            }
            i2 = 8;
        }
        if (list2 != null && list.size() > 0) {
            if (list.size() > i2) {
                list2 = list2.subList(0, i2);
            }
            for (CommentImageInfoBean commentImageInfoBean : list2) {
                NineGridlayout.Image image3 = new NineGridlayout.Image(commentImageInfoBean.url + "?x-oss-process=image/resize,m_fill,h_400,w_400,limit_0");
                PicInfo picInfo = new PicInfo();
                picInfo.setPicUrl(commentImageInfoBean.url);
                arrayList3.add(picInfo);
                arrayList.add(image3);
            }
        }
        if (arrayList.size() > 0) {
            nineGridlayout.setHandleSinglePic(z2);
            nineGridlayout.setRadius(num == null ? up2.a(context, 6.0f) : num.intValue());
            nineGridlayout.setGap(up2.a(context, 3.0f));
            nineGridlayout.setTotalWidth(i);
            nineGridlayout.setAutoShrink(z);
            nineGridlayout.updateImages(arrayList);
            nineGridlayout.setListener(new a(onClickExtraListener, arrayList2, context, arrayList3));
            return;
        }
        nineGridlayout.setVisibility(8);
    }

    public void d(Context context, long j, ArrayList<VideoInfo> arrayList, ArrayList<PicInfo> arrayList2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-783796437")) {
            ipChange.ipc$dispatch("-783796437", new Object[]{this, context, Long.valueOf(j), arrayList, arrayList2, Integer.valueOf(i)});
        } else if (context != null) {
            Bundle bundle = new Bundle();
            bundle.putString("projectId", String.valueOf(j));
            bundle.putParcelableArrayList("video_info", arrayList);
            bundle.putParcelableArrayList("pic_info", arrayList2);
            bundle.putInt("position", i);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("videobrowse"));
        }
    }
}
