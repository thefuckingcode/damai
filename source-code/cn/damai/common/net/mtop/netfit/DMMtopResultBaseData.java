package cn.damai.common.net.mtop.netfit;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class DMMtopResultBaseData {

    /* compiled from: Taobao */
    public static class BaseMtopResponseData extends BaseOutDo {
        private static transient /* synthetic */ IpChange $ipChange;
        private ResultData data;

        public void setData(ResultData resultData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1505151811")) {
                ipChange.ipc$dispatch("-1505151811", new Object[]{this, resultData});
                return;
            }
            this.data = resultData;
        }

        @Override // mtopsdk.mtop.domain.BaseOutDo
        public ResultData getData() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-638683077")) {
                return this.data;
            }
            return (ResultData) ipChange.ipc$dispatch("-638683077", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static class ResultData implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String result;

        public String getResult() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-56275335")) {
                return this.result;
            }
            return (String) ipChange.ipc$dispatch("-56275335", new Object[]{this});
        }

        public void setResult(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1155339909")) {
                ipChange.ipc$dispatch("1155339909", new Object[]{this, str});
                return;
            }
            this.result = str;
        }
    }
}
