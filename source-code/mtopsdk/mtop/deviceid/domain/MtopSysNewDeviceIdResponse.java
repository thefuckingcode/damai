package mtopsdk.mtop.deviceid.domain;

import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class MtopSysNewDeviceIdResponse extends BaseOutDo {
    private MtopSysNewDeviceIdResponseData data;

    public void setData(MtopSysNewDeviceIdResponseData mtopSysNewDeviceIdResponseData) {
        this.data = mtopSysNewDeviceIdResponseData;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public MtopSysNewDeviceIdResponseData getData() {
        return this.data;
    }
}
