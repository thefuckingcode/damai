package cn.damai.trade.newtradeorder.ui.projectdetail.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ItemPics implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ItemPics> CREATOR = new Parcelable.Creator<ItemPics>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.ItemPics.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ItemPics createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1557733323")) {
                return new ItemPics(parcel);
            }
            return (ItemPics) ipChange.ipc$dispatch("1557733323", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ItemPics[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "395639510")) {
                return new ItemPics[i];
            }
            return (ItemPics[]) ipChange.ipc$dispatch("395639510", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public ArrayList<PicInfo> itemPicList;

    public ItemPics() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1134617135")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1134617135", new Object[]{this})).intValue();
    }

    public ArrayList<PicInfo> getItemPicList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1162456228")) {
            return this.itemPicList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-1162456228", new Object[]{this});
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448355452")) {
            ipChange.ipc$dispatch("1448355452", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.itemPicList);
    }

    protected ItemPics(Parcel parcel) {
        this.itemPicList = parcel.createTypedArrayList(PicInfo.CREATOR);
    }
}
