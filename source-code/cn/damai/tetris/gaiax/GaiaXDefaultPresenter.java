package cn.damai.tetris.gaiax;

import android.text.TextUtils;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.BasePresenter;
import cn.damai.tetris.core.nav.NavigatorProxy;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import tb.w9;

/* compiled from: Taobao */
public class GaiaXDefaultPresenter extends BasePresenter<GaiaXDefaultModel, GaiaXDefaultView, BaseNode> implements GaiaXPresenter<GaiaXDefaultModel, GaiaXDefaultView, BaseNode> {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    public class a implements GaiaX.IEventDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.youku.gaiax.GaiaX.IEventDelegate
        public void onEvent(EventParams eventParams) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1655335842")) {
                ipChange.ipc$dispatch("-1655335842", new Object[]{this, eventParams});
                return;
            }
            GaiaXDefaultPresenter.this.dispatchOnClickEvent(eventParams);
        }
    }

    /* compiled from: Taobao */
    public class b implements GaiaX.ITrackDelegate3 {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.youku.gaiax.GaiaX.ITrackDelegate3
        public void onTrack(TrackParams trackParams) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2103419803")) {
                ipChange.ipc$dispatch("2103419803", new Object[]{this, trackParams});
                return;
            }
            GaiaXDefaultPresenter.this.dispatchTrackExpose(trackParams);
        }
    }

    public GaiaXDefaultPresenter(GaiaXDefaultView gaiaXDefaultView, String str, w9 w9Var) {
        super(gaiaXDefaultView, str, w9Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: cn.damai.tetris.gaiax.GaiaXDefaultPresenter */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchOnClickEvent(EventParams eventParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745756291")) {
            ipChange.ipc$dispatch("-1745756291", new Object[]{this, eventParams});
        } else if (eventParams.getData() != null && eventParams.getData().containsKey("value")) {
            String string = eventParams.getData().getString("value");
            if (!TextUtils.isEmpty(string)) {
                if (eventParams.getData().containsKey("spm") && eventParams.getData().containsKey("spmArgs")) {
                    JSONObject jSONObject = eventParams.getData().getJSONObject("spm");
                    JSONObject jSONObject2 = eventParams.getData().getJSONObject("spmArgs");
                    if (jSONObject.containsKey("spmd")) {
                        String string2 = jSONObject.getString("spmd");
                        if (string2.endsWith(JSMethod.NOT_SET)) {
                            string2 = string2 + eventParams.getPosition();
                        }
                        userTrackClick(string2, jSONObject2.getInnerMap(), true);
                    }
                }
                NavigatorProxy.a().toUri(getContext().getActivity(), string);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: cn.damai.tetris.gaiax.GaiaXDefaultPresenter */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchTrackExpose(TrackParams trackParams) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940311520")) {
            ipChange.ipc$dispatch("1940311520", new Object[]{this, trackParams});
        } else if (trackParams.getData() != null && trackParams.getData().containsKey("spm") && trackParams.getData().containsKey("spmArgs")) {
            JSONObject jSONObject = trackParams.getData().getJSONObject("spm");
            JSONObject jSONObject2 = trackParams.getData().getJSONObject("spmArgs");
            if (jSONObject != null && jSONObject.containsKey("spmd")) {
                String string = jSONObject.getString("spmd");
                if (string.endsWith(JSMethod.NOT_SET)) {
                    str = string + trackParams.getPosition();
                } else {
                    str = String.valueOf(trackParams.getPosition());
                }
                userTrackExpose(trackParams.getView(), str, jSONObject2.getInnerMap(), false);
            }
        }
    }

    @Override // cn.damai.tetris.core.msg.IMessage, cn.damai.tetris.core.BasePresenter
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "129587299")) {
            ipChange.ipc$dispatch("129587299", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    public void init(GaiaXDefaultModel gaiaXDefaultModel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527840831")) {
            ipChange.ipc$dispatch("-527840831", new Object[]{this, gaiaXDefaultModel});
            return;
        }
        GaiaX.Params build = new GaiaX.Params.Builder().templateBiz(gaiaXDefaultModel.getBiz()).templateId(getSection().getComponentId()).container(((GaiaXDefaultView) getView()).getGaiaXContainer()).data(gaiaXDefaultModel.getDesireRawJson()).width(gaiaXDefaultModel.getDefaultDesireWidth(getContext().getActivity())).build();
        build.setEventDelegate(new a());
        build.setTrackDelegate3(new b());
        GaiaX.Companion.getInstance().bindView(build);
    }
}
