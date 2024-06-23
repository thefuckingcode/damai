package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageOption;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.Option;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class zz0 extends ba<ImageData, vz0> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static zz0 d;

    private zz0() {
    }

    public static synchronized zz0 t() {
        synchronized (zz0.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-292828701")) {
                return (zz0) ipChange.ipc$dispatch("-292828701", new Object[0]);
            }
            if (d == null) {
                d = new zz0();
            }
            return d;
        }
    }

    @Override // tb.ba
    public a<ImageData, vz0> e(@NonNull kl1<vz0> kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237377677")) {
            return (a) ipChange.ipc$dispatch("-1237377677", new Object[]{this, kl1});
        } else if (kl1.a().c()) {
            return new SVGRequest(kl1);
        } else {
            return new b(kl1);
        }
    }

    public void r(@Nullable RequestListener<ImageData, vz0> requestListener, ImageOption... imageOptionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124224952")) {
            ipChange.ipc$dispatch("-2124224952", new Object[]{this, requestListener, imageOptionArr});
        } else if (imageOptionArr != null) {
            for (ImageOption imageOption : imageOptionArr) {
                h(imageOption, requestListener);
            }
        }
    }

    public void s(Option<ImageExtra>[] optionArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090219824")) {
            ipChange.ipc$dispatch("-2090219824", new Object[]{this, optionArr});
        } else if (optionArr != null && optionArr.length > 0) {
            for (Option<ImageExtra> option : optionArr) {
                q(option);
            }
        }
    }
}
