package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import cn.damai.commonbusiness.citycopy.net.CityListResponse;
import com.alibaba.pictures.bricks.channel.bean.LocationInfo;
import com.alibaba.pictures.bricks.channel.bean.NewLocationInfo;
import com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge;
import com.alibaba.pictures.bricks.channel.bridge.OnBizListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.youku.live.livesdk.model.mtop.LiveFullInfo;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.sb;

/* compiled from: Taobao */
public final class ed0 implements ComponentFilterBridge {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1677226571")) {
            return "mtop.damai.mec.aristotle.get";
        }
        return (String) ipChange.ipc$dispatch("1677226571", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getApiVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1377416946")) {
            return LiveFullInfo.VER;
        }
        return (String) ipChange.ipc$dispatch("-1377416946", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getCityId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1622825494")) {
            return "852";
        }
        return (String) ipChange.ipc$dispatch("1622825494", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getCityName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "533054342")) {
            return "北京";
        }
        return (String) ipChange.ipc$dispatch("533054342", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getComboChannel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2036957051")) {
            return "1";
        }
        return (String) ipChange.ipc$dispatch("-2036957051", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public Double[] getDMCoordinates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "722555927")) {
            return null;
        }
        return (Double[]) ipChange.ipc$dispatch("722555927", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public CityListResponse getLocalCityList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2129632373")) {
            return null;
        }
        return (CityListResponse) ipChange.ipc$dispatch("2129632373", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @Nullable
    public String getSpValue(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727506192")) {
            return (String) ipChange.ipc$dispatch("1727506192", new Object[]{this, str});
        }
        k21.i(str, "spKey");
        return null;
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getTtid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1194494603")) {
            return (String) ipChange.ipc$dispatch("1194494603", new Object[]{this});
        }
        String ttid = AppInfoProviderProxy.getTTID();
        k21.h(ttid, "getTTID()");
        return ttid;
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    @NotNull
    public String getUserCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "310813768")) {
            return "";
        }
        return (String) ipChange.ipc$dispatch("310813768", new Object[]{this});
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void reportClick(@NotNull sb.b bVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "180546867")) {
            ipChange.ipc$dispatch("180546867", new Object[]{this, bVar});
            return;
        }
        k21.i(bVar, "builder");
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void reportExposureSingleCustomEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, long j, @Nullable Map<String, String> map, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493503802")) {
            ipChange.ipc$dispatch("1493503802", new Object[]{this, str, str2, str3, str4, Long.valueOf(j), map, Integer.valueOf(i)});
        }
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void requestCityList(@NotNull OnBizListener<CityListResponse> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674867733")) {
            ipChange.ipc$dispatch("-674867733", new Object[]{this, onBizListener});
            return;
        }
        k21.i(onBizListener, "bizListener");
        onBizListener.onBizFail("", DXRecyclerLayout.LOAD_MORE_EMPTY);
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void saveLocationInfo(@NotNull LocationInfo locationInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "860287883")) {
            ipChange.ipc$dispatch("860287883", new Object[]{this, locationInfo});
            return;
        }
        k21.i(locationInfo, "info");
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void saveSpValue(@NotNull String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835715261")) {
            ipChange.ipc$dispatch("-1835715261", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "spKey");
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void setExposureTag(@Nullable View view, @Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-944632888")) {
            ipChange.ipc$dispatch("-944632888", new Object[]{this, view, str, str2, str3, map});
            return;
        }
        k21.i(str2, "moduleName");
        k21.i(str3, "pageName");
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void setNewLocationData(@NotNull NewLocationInfo newLocationInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574507454")) {
            ipChange.ipc$dispatch("-1574507454", new Object[]{this, newLocationInfo});
            return;
        }
        k21.i(newLocationInfo, "newInfo");
    }

    @Override // com.alibaba.pictures.bricks.channel.bridge.ComponentFilterBridge
    public void showPermissionDialog(@NotNull Context context, @NotNull String str, @Nullable List<String> list, boolean z, @Nullable DialogInterface.OnClickListener onClickListener, @Nullable DialogInterface.OnClickListener onClickListener2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500542303")) {
            ipChange.ipc$dispatch("-1500542303", new Object[]{this, context, str, list, Boolean.valueOf(z), onClickListener, onClickListener2});
            return;
        }
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
        k21.i(str, "msg");
    }
}
