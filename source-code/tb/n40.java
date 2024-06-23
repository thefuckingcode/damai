package tb;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.transfer.IDataTransformerFactory;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.playerservice.axp.playinfo.Point;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class n40 implements IDataTransformerFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.dolores.transfer.IDataTransformerFactory
    @NotNull
    public <BizResponse> IRemoteDataTransformer<BizResponse> createDataTransformer(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436959147")) {
            return (IRemoteDataTransformer) ipChange.ipc$dispatch("-436959147", new Object[]{this, doloresRequest});
        }
        String markRequestLabel = doloresRequest != null ? doloresRequest.markRequestLabel() : null;
        if (markRequestLabel != null) {
            switch (markRequestLabel.hashCode()) {
                case -1425371906:
                    if (markRequestLabel.equals("shawshank")) {
                        return new en2();
                    }
                    break;
                case -1335396889:
                    if (markRequestLabel.equals("dengta")) {
                        return new wd2();
                    }
                    break;
                case 66857:
                    if (markRequestLabel.equals("CMS")) {
                        return new wd2();
                    }
                    break;
                case 115060:
                    if (markRequestLabel.equals("tpp")) {
                        return new dn2();
                    }
                    break;
                case 95349688:
                    if (markRequestLabel.equals("damai")) {
                        return new wd2();
                    }
                    break;
                case 1312628413:
                    if (markRequestLabel.equals(Point.STANDARD)) {
                        return new wd2();
                    }
                    break;
            }
        }
        return new wd2();
    }
}
