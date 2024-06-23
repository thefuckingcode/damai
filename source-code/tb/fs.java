package tb;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import com.youku.youkuplayer.IWaterMarkImageViewWrap;

/* compiled from: Taobao */
public class fs implements IWaterMarkImageViewWrap {
    private static transient /* synthetic */ IpChange $ipChange;
    Context a;

    public fs(Context context) {
        this.a = context;
        new TUrlImageView(context);
    }

    @Override // com.youku.youkuplayer.IWaterMarkImageViewWrap
    public ImageView getWaterMarkImageView() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "881310800")) {
            return new TUrlImageView(this.a);
        }
        return (ImageView) ipChange.ipc$dispatch("881310800", new Object[]{this});
    }

    @Override // com.youku.youkuplayer.IWaterMarkImageViewWrap
    public void setImageUrl(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1336812064")) {
            ipChange.ipc$dispatch("-1336812064", new Object[]{this, imageView, str});
        } else if (imageView instanceof TUrlImageView) {
            TUrlImageView tUrlImageView = (TUrlImageView) imageView;
            if (!TextUtils.isEmpty(str)) {
                tUrlImageView.setImageUrl(str);
            }
        }
    }
}
