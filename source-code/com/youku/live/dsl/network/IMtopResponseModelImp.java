package com.youku.live.dsl.network;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
public class IMtopResponseModelImp<Model extends Serializable> implements IResponseModel<Model>, IMtopResponseAttacher {
    private static transient /* synthetic */ IpChange $ipChange;
    private volatile MtopResponse mtopResponse;
    public MtopBaseBean resultModel;
    private volatile String source;

    public IMtopResponseModelImp(MtopResponse mtopResponse2) {
        this.mtopResponse = mtopResponse2;
    }

    public static <Result> Result deserialize(String str, Class<Result> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735442142")) {
            return (Result) ipChange.ipc$dispatch("-735442142", new Object[]{str, cls});
        }
        try {
            return (Result) JSON.parseObject(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Class getSuperClassGenricType(Class cls, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340302636")) {
            return (Class) ipChange.ipc$dispatch("340302636", new Object[]{cls, Integer.valueOf(i)});
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (i >= actualTypeArguments.length || i < 0 || !(actualTypeArguments[i] instanceof Class)) {
            return Object.class;
        }
        return (Class) actualTypeArguments[i];
    }

    @Override // com.youku.live.dsl.network.IMtopResponseAttacher
    public void attachResponse(MtopResponse mtopResponse2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "26648071")) {
            ipChange.ipc$dispatch("26648071", new Object[]{this, mtopResponse2});
            return;
        }
        this.mtopResponse = mtopResponse2;
    }

    @Override // com.youku.live.dsl.network.IResponseModel
    public Model getModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "330538229")) {
            return (Model) ((Serializable) ipChange.ipc$dispatch("330538229", new Object[]{this}));
        }
        MtopBaseBean mtopBean = getMtopBean();
        if (mtopBean != null) {
            return (Model) ((Serializable) mtopBean.model);
        }
        return null;
    }

    public MtopBaseBean getMtopBean() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559480698")) {
            return (MtopBaseBean) ipChange.ipc$dispatch("559480698", new Object[]{this});
        }
        MtopBaseBean mtopBaseBean = this.resultModel;
        if (mtopBaseBean != null) {
            return mtopBaseBean;
        }
        return null;
    }

    public MtopBaseBean getMtopBeanWithClass(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255676961")) {
            return (MtopBaseBean) ipChange.ipc$dispatch("-255676961", new Object[]{this, cls});
        }
        MtopBaseBean mtopBaseBean = this.resultModel;
        if (mtopBaseBean != null) {
            return mtopBaseBean;
        }
        if (getSource() == null || !isResponseSuccess()) {
            return null;
        }
        MtopBaseBean mtopBaseBean2 = (MtopBaseBean) deserialize(getSource(), MtopBaseBean.class);
        this.resultModel = mtopBaseBean2;
        mtopBaseBean2.model = deserialize(mtopBaseBean2.data, cls);
        return this.resultModel;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public byte[] getRawData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-227304463")) {
            return (byte[]) ipChange.ipc$dispatch("-227304463", new Object[]{this});
        } else if (this.mtopResponse != null) {
            return this.mtopResponse.getBytedata();
        } else {
            return null;
        }
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getRetCode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1944996848")) {
            return this.mtopResponse != null ? this.mtopResponse.getRetCode() : "";
        }
        return (String) ipChange.ipc$dispatch("1944996848", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getRetMessage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1941428070")) {
            return this.mtopResponse != null ? this.mtopResponse.getRetMsg() : "";
        }
        return (String) ipChange.ipc$dispatch("-1941428070", new Object[]{this});
    }

    @Override // com.youku.live.dsl.network.IResponse
    public String getSource() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271998607")) {
            return (String) ipChange.ipc$dispatch("1271998607", new Object[]{this});
        }
        if (this.source == null) {
            try {
                this.source = new String(getRawData());
            } catch (Throwable unused) {
            }
        }
        if (this.source == null) {
            this.source = "";
        }
        return this.source;
    }

    @Override // com.youku.live.dsl.network.IResponse
    public boolean isRequestSuccess() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-321970578")) {
            return this.mtopResponse != null && !this.mtopResponse.isMtopSdkError() && !this.mtopResponse.isMtopServerError();
        }
        return ((Boolean) ipChange.ipc$dispatch("-321970578", new Object[]{this})).booleanValue();
    }

    @Override // com.youku.live.dsl.network.IResponse
    public boolean isResponseSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024619794")) {
            return ((Boolean) ipChange.ipc$dispatch("-1024619794", new Object[]{this})).booleanValue();
        } else if (this.mtopResponse != null) {
            return this.mtopResponse.isApiSuccess();
        } else {
            return false;
        }
    }

    public IMtopResponseModelImp() {
    }

    public static <Result> Result deserialize(String str, Type type) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-19407242")) {
            return (Result) ipChange.ipc$dispatch("-19407242", new Object[]{str, type});
        }
        try {
            return (Result) JSON.parseObject(str, type, new Feature[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
