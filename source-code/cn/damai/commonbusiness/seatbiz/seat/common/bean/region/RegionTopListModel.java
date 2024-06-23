package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatPrice;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class RegionTopListModel implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RegionTopListModel> CREATOR = new Parcelable.Creator<RegionTopListModel>() {
        /* class cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionTopListModel.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RegionTopListModel createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1527068405")) {
                return new RegionTopListModel(parcel);
            }
            return (RegionTopListModel) ipChange.ipc$dispatch("-1527068405", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RegionTopListModel[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "868731930")) {
                return new RegionTopListModel[i];
            }
            return (RegionTopListModel[]) ipChange.ipc$dispatch("868731930", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String color;
    private String cts;
    public float cutPrice;
    private List<RegionTopListDetailModel> detail;
    public List<Long> matixIdSet;
    private String ols;
    private String pots;
    private String priceFlag;
    public List<Float> priceSet;
    private long tpId;
    private String tpName;
    private String tpNum;
    private float tpPrice;

    private String getColorStr() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1030455911")) {
            return (TextUtils.isEmpty(this.color) || this.color.length() != 6) ? "FF0000" : this.color.toUpperCase();
        }
        return (String) ipChange.ipc$dispatch("-1030455911", new Object[]{this});
    }

    @Nullable
    public SeatPrice fixedTaoPiao2SeatPrice(List<SeatPrice> list) {
        float f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211085189")) {
            return (SeatPrice) ipChange.ipc$dispatch("211085189", new Object[]{this, list});
        }
        SeatPrice seatPrice = null;
        if (!isOlsValid() || !isFixedTaoPiao() || TextUtils.isEmpty(this.color)) {
            return null;
        }
        if (!f92.d(list) && !f92.d(this.detail)) {
            try {
                seatPrice = list.get(Integer.parseInt(this.detail.get(0).getPref()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SeatPrice seatPrice2 = new SeatPrice();
        long j = this.tpId;
        seatPrice2.priceLevelId = j;
        seatPrice2.maitixPriceId = j;
        String colorStr = getColorStr();
        seatPrice2.priceColor = colorStr;
        seatPrice2.priceColorValue = Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + colorStr);
        seatPrice2.isTopTicket = true;
        if (seatPrice == null) {
            f = -1.0f;
        } else {
            f = seatPrice.priceValue;
        }
        seatPrice2.singlePriceValue = f;
        try {
            seatPrice2.tpNum = Integer.parseInt(this.tpNum);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        seatPrice2.priceValue = this.tpPrice;
        return seatPrice2;
    }

    public String getColor() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1293707950")) {
            return this.color;
        }
        return (String) ipChange.ipc$dispatch("1293707950", new Object[]{this});
    }

    public String getCts() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1861015571")) {
            return this.cts;
        }
        return (String) ipChange.ipc$dispatch("-1861015571", new Object[]{this});
    }

    @Nullable
    public List<RegionTopListDetailModel> getDetail() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-375690429")) {
            return this.detail;
        }
        return (List) ipChange.ipc$dispatch("-375690429", new Object[]{this});
    }

    public String getOls() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-684162559")) {
            return this.ols;
        }
        return (String) ipChange.ipc$dispatch("-684162559", new Object[]{this});
    }

    public String getPots() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2023356791")) {
            return this.pots;
        }
        return (String) ipChange.ipc$dispatch("-2023356791", new Object[]{this});
    }

    public String getPriceFlag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1974085280")) {
            return this.priceFlag;
        }
        return (String) ipChange.ipc$dispatch("1974085280", new Object[]{this});
    }

    public long getTpId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "24992850")) {
            return this.tpId;
        }
        return ((Long) ipChange.ipc$dispatch("24992850", new Object[]{this})).longValue();
    }

    public String getTpName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "681754226")) {
            return this.tpName;
        }
        return (String) ipChange.ipc$dispatch("681754226", new Object[]{this});
    }

    public String getTpNum() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1185461557")) {
            return this.tpNum;
        }
        return (String) ipChange.ipc$dispatch("1185461557", new Object[]{this});
    }

    public float getTpPrice() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1992091880")) {
            return this.tpPrice;
        }
        return ((Float) ipChange.ipc$dispatch("-1992091880", new Object[]{this})).floatValue();
    }

    public boolean isFixedTaoPiao() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1317579332")) {
            return !TextUtils.isEmpty(this.pots) && this.pots.equals("0");
        }
        return ((Boolean) ipChange.ipc$dispatch("1317579332", new Object[]{this})).booleanValue();
    }

    public boolean isModelValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1380502470")) {
            return isOlsValid() && !TextUtils.isEmpty(this.cts) && this.cts.equals("1");
        }
        return ((Boolean) ipChange.ipc$dispatch("1380502470", new Object[]{this})).booleanValue();
    }

    public boolean isOlsValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-502136365")) {
            return !TextUtils.isEmpty(this.ols) && this.ols.equals("0");
        }
        return ((Boolean) ipChange.ipc$dispatch("-502136365", new Object[]{this})).booleanValue();
    }

    public void setColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353358968")) {
            ipChange.ipc$dispatch("-353358968", new Object[]{this, str});
            return;
        }
        this.color = str;
    }

    public void setCts(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438359767")) {
            ipChange.ipc$dispatch("-438359767", new Object[]{this, str});
            return;
        }
        this.cts = str;
    }

    public void setDetail(List<RegionTopListDetailModel> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851288553")) {
            ipChange.ipc$dispatch("1851288553", new Object[]{this, list});
            return;
        }
        this.detail = list;
    }

    public void setOls(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684345237")) {
            ipChange.ipc$dispatch("1684345237", new Object[]{this, str});
            return;
        }
        this.ols = str;
    }

    public void setPots(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407692149")) {
            ipChange.ipc$dispatch("1407692149", new Object[]{this, str});
            return;
        }
        this.pots = str;
    }

    public void setPriceFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-898103338")) {
            ipChange.ipc$dispatch("-898103338", new Object[]{this, str});
            return;
        }
        this.priceFlag = str;
    }

    public void setTpId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686229298")) {
            ipChange.ipc$dispatch("686229298", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.tpId = j;
    }

    public void setTpName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1735547476")) {
            ipChange.ipc$dispatch("-1735547476", new Object[]{this, str});
            return;
        }
        this.tpName = str;
    }

    public void setTpNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585970145")) {
            ipChange.ipc$dispatch("585970145", new Object[]{this, str});
            return;
        }
        this.tpNum = str;
    }

    public void setTpPrice(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "897952012")) {
            ipChange.ipc$dispatch("897952012", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.tpPrice = f;
    }

    public RegionTopListModel() {
    }

    private RegionTopListModel(Parcel parcel) {
        this.tpId = parcel.readLong();
        this.tpName = parcel.readString();
        this.tpPrice = parcel.readFloat();
        this.tpNum = parcel.readString();
        parcel.readTypedList(this.detail, RegionTopListDetailModel.CREATOR);
        this.ols = parcel.readString();
        this.cts = parcel.readString();
    }
}
