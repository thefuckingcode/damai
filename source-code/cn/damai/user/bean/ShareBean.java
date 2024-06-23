package cn.damai.user.bean;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import tb.f92;
import tb.n42;
import tb.s41;
import tb.tz0;
import tb.xs0;

/* compiled from: Taobao */
public class ShareBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String ipId;
    public String shareImage;
    public String shareSubTitle;
    public String shareTitle;
    public String shareUrl;

    /* compiled from: Taobao */
    public interface OnShareListener {
        void openShareView(Bundle bundle, String str);

        void showLoading(boolean z);

        void toast(String str);
    }

    public static void doIpDramaShare(final ShareBean shareBean, final OnShareListener onShareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1536634624")) {
            ipChange.ipc$dispatch("1536634624", new Object[]{shareBean, onShareListener});
        } else if (shareBean != null && shareBean.isValid() && onShareListener != null) {
            final String str = shareBean.shareImage;
            Application a = xs0.a();
            a.b().f(str, n42.a(a, 111.0f), n42.a(a, 148.0f)).n(new DMImageCreator.DMImageSuccListener() {
                /* class cn.damai.user.bean.ShareBean.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    Bitmap bitmap;
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1615170387")) {
                        ipChange.ipc$dispatch("1615170387", new Object[]{this, eVar});
                        return;
                    }
                    OnShareListener.this.showLoading(false);
                    if (eVar != null && (bitmap = eVar.b) != null) {
                        try {
                            String d = tz0.d(str, bitmap, xs0.a());
                            ShareBean shareBean = shareBean;
                            String str = shareBean.shareTitle;
                            String str2 = shareBean.shareSubTitle;
                            String str3 = shareBean.shareImage;
                            String str4 = shareBean.shareUrl;
                            Bundle bundle = new Bundle();
                            bundle.putString("title", str);
                            bundle.putString("projectName", str);
                            bundle.putString("message", str2);
                            if (!TextUtils.isEmpty(str3)) {
                                bundle.putString("imageurl", str3);
                                bundle.putString("projectImage", str3);
                            }
                            if (!TextUtils.isEmpty(d)) {
                                bundle.putString("sinaSharePath", d);
                            }
                            if (!TextUtils.isEmpty(str4)) {
                                bundle.putString("producturl", str4);
                            }
                            bundle.putBoolean("showGenerateImage", true);
                            bundle.putString("shareType", "chat_h5");
                            bundle.putString("fromWhere", "ipDramaPage");
                            bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_IP_DRAMA_IMAGE);
                            OnShareListener.this.openShareView(bundle, shareBean.ipId);
                        } catch (Exception unused) {
                            OnShareListener.this.toast("分享失败");
                        }
                    }
                }
            }).e(new DMImageCreator.DMImageFailListener() {
                /* class cn.damai.user.bean.ShareBean.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.d dVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "147800126")) {
                        ipChange.ipc$dispatch("147800126", new Object[]{this, dVar});
                        return;
                    }
                    OnShareListener.this.showLoading(false);
                    OnShareListener.this.toast("分享失败");
                }
            }).f();
        }
    }

    public static ShareBean obtainIpDramaShareBean(BaseResponse baseResponse) {
        NodeData item;
        ShareJsonBean shareJsonBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1449966681")) {
            return (ShareBean) ipChange.ipc$dispatch("-1449966681", new Object[]{baseResponse});
        }
        if (baseResponse != null && !f92.d(baseResponse.layers)) {
            Iterator<BaseLayer> it = baseResponse.layers.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (!f92.d(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals("dm_card_ip_info", baseSection.getComponentId()) && (item = baseSection.getItem()) != null && (shareJsonBean = (ShareJsonBean) s41.d(item, ShareJsonBean.class)) != null && shareJsonBean.isValid()) {
                            ShareBean shareBean = new ShareBean();
                            shareBean.shareImage = shareJsonBean.verticalPicList.get(0);
                            String str = TextUtils.isEmpty(shareJsonBean.ipName) ? "" : shareJsonBean.ipName;
                            shareBean.shareTitle = str + "快来看看！";
                            shareBean.shareSubTitle = null;
                            shareBean.ipId = shareJsonBean.id;
                            shareBean.shareUrl = "https://m.damai.cn/app/dmfe/dramas/pages/ip/index.html?ipId=" + shareJsonBean.id;
                            return shareBean;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1779058290")) {
            return !TextUtils.isEmpty(this.shareImage) && !TextUtils.isEmpty(this.shareUrl);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1779058290", new Object[]{this})).booleanValue();
    }
}
