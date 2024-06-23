package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.alibaba.pictures.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class RelatedInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String type;
    public String value;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r9.equals("2") == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        if (r9.equals("2") == false) goto L_0x0070;
     */
    public int getRelateIconRid(boolean z) {
        IpChange ipChange = $ipChange;
        char c = 1;
        if (AndroidInstantRuntime.support(ipChange, "-67344455")) {
            return ((Integer) ipChange.ipc$dispatch("-67344455", new Object[]{this, Boolean.valueOf(z)})).intValue();
        } else if (TextUtils.isEmpty(this.type)) {
            return -1;
        } else {
            if (z) {
                String str = this.type;
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        if (str.equals("1")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 50:
                        break;
                    case 51:
                        if (str.equals("3")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        return R$drawable.bricks_note_topic_white;
                    case 1:
                    case 2:
                        return R$drawable.bricks_note_v_white;
                    default:
                        return -1;
                }
            } else {
                String str2 = this.type;
                str2.hashCode();
                switch (str2.hashCode()) {
                    case 49:
                        if (str2.equals("1")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 50:
                        break;
                    case 51:
                        if (str2.equals("3")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        return R$drawable.bricks_note_topic_;
                    case 1:
                        return R$drawable.bricks_note_artist;
                    case 2:
                        return R$drawable.bricks_note_brand;
                    default:
                        return -1;
                }
            }
        }
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "774091657")) {
            return !TextUtils.isEmpty(this.value);
        }
        return ((Boolean) ipChange.ipc$dispatch("774091657", new Object[]{this})).booleanValue();
    }
}
