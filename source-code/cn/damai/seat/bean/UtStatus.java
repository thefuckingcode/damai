package cn.damai.seat.bean;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import java.io.Serializable;

/* compiled from: Taobao */
public class UtStatus implements Serializable {
    public final String errorCode;
    public final String errorMsg;
    public final TbParams mParams;
    public final boolean success;

    public UtStatus(boolean z, TbParams tbParams, String str, String str2) {
        this.success = z;
        this.mParams = tbParams;
        this.errorCode = str;
        this.errorMsg = str2;
    }
}
