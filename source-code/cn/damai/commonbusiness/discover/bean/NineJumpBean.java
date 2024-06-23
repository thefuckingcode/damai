package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class NineJumpBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATUS_HAS_VIDEO = 20;
    public static final int STATUS_NONE_VIDEO = 18;
    public static final int STATUS_VIDEO_UNDER_REVIEW = 19;
    private final List<GridBean> gridList = new ArrayList();
    public final ArrayList<PicInfo> picInfoList = new ArrayList<>(9);
    public final ArrayList<VideoInfo> videoInfoList;
    public final int videoStatus;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    public NineJumpBean(List<String> list, cn.damai.tetris.component.discover.bean.VideoInfo videoInfo) {
        GridBean gridBean;
        int i;
        List<GridBean> formImgList;
        ArrayList<VideoInfo> arrayList = new ArrayList<>(1);
        this.videoInfoList = arrayList;
        if (videoInfo != null) {
            if (videoInfo.isVideoUnderReviewStatus()) {
                i = 19;
                gridBean = GridBean.fromVideo2(videoInfo);
            } else if (!TextUtils.isEmpty(videoInfo.coverUrl) && !TextUtils.isEmpty(videoInfo.url)) {
                GridBean fromVideo2 = GridBean.fromVideo2(videoInfo);
                VideoInfo videoInfo2 = new VideoInfo();
                videoInfo2.setPicUrl(videoInfo.coverUrl);
                videoInfo2.setVideoUrl(videoInfo.url);
                videoInfo2.setType(VideoInfo.VideoType.VIDEO_URL);
                videoInfo2.setSourceLabel(videoInfo.sourceLabel);
                arrayList.add(videoInfo2);
                gridBean = fromVideo2;
                i = 20;
            }
            this.videoStatus = i;
            if (!f92.d(list)) {
                for (String str : list) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(str);
                    this.picInfoList.add(picInfo);
                }
            }
            formImgList = GridBean.formImgList(list);
            if (gridBean != null) {
                this.gridList.add(gridBean);
            }
            if (f92.d(formImgList)) {
                this.gridList.addAll(formImgList);
                return;
            }
            return;
        }
        i = 18;
        gridBean = null;
        this.videoStatus = i;
        if (!f92.d(list)) {
        }
        formImgList = GridBean.formImgList(list);
        if (gridBean != null) {
        }
        if (f92.d(formImgList)) {
        }
    }

    public int computePosition2NextPage(int i) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-97014205")) {
            return this.videoStatus != 19 ? i : i - 1;
        }
        return ((Integer) ipChange.ipc$dispatch("-97014205", new Object[]{this, Integer.valueOf(i)})).intValue();
    }

    public List<GridBean> getGridList(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091665316")) {
            return (List) ipChange.ipc$dispatch("-2091665316", new Object[]{this, Boolean.valueOf(z)});
        }
        List arrayList = new ArrayList();
        if (!f92.d(this.gridList)) {
            arrayList.addAll(this.gridList);
            int size = arrayList.size();
            if (z && arrayList.size() > 3) {
                List subList = arrayList.subList(0, 3);
                ((GridBean) subList.get(subList.size() - 1)).countRightBottomTag = size - 3;
                arrayList = subList;
            }
            GridBean.ensureItemCountMemberVar(arrayList);
        }
        return arrayList;
    }
}
