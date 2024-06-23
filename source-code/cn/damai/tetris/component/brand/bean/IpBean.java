package cn.damai.tetris.component.brand.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class IpBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String briefIntroduction;
    public String id;
    public int ipvuv;
    private String itemScore;
    public String pic;
    public String subTitle;

    public String getItemScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-424695541")) {
            return this.itemScore;
        }
        return (String) ipChange.ipc$dispatch("-424695541", new Object[]{this});
    }

    public float getItemScoreFloat() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54716137")) {
            return ((Float) ipChange.ipc$dispatch("54716137", new Object[]{this})).floatValue();
        } else if (TextUtils.isEmpty(this.itemScore)) {
            return 0.0f;
        } else {
            try {
                return Float.parseFloat(this.itemScore);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
    }

    public void setItemScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2049102539")) {
            ipChange.ipc$dispatch("2049102539", new Object[]{this, str});
            return;
        }
        this.itemScore = str;
    }
}
