package com.youku.live.dago.liveplayback.widget.Mapper;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.widget.model.EndPageModel;
import com.youku.live.dago.liveplayback.widget.model.EndPageWrapper;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.network.INetCallback;
import com.youku.live.dsl.network.INetClient;
import com.youku.live.dsl.network.INetRequest;
import com.youku.live.dsl.network.INetResponse;
import java.util.Map;

/* compiled from: Taobao */
public class EndPageDataMapper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DAGO_LIVE_ACTOR_ATTENTION = "mtop.tudou.subscribe.relation.RelationServiceMTOP.create";
    private static final String DAGO_LIVE_END_PAGE_DATA = "mtop.youku.live.biz.pgc.endPage.get";
    private static final String TAG = "EndPageDataMapper";

    /* compiled from: Taobao */
    public interface GetAttentionStateListener {
        void onCompleted(String str);

        void onException();
    }

    /* compiled from: Taobao */
    public interface GetEndPageDataListener {
        void onCompleted(String str);

        void onException();
    }

    public static void getAttentionState(Map<String, String> map, final GetAttentionStateListener getAttentionStateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1871286097")) {
            ipChange.ipc$dispatch("-1871286097", new Object[]{map, getAttentionStateListener});
            return;
        }
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop("mtop.tudou.subscribe.relation.RelationServiceMTOP.create", "1.1", map, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() {
                /* class com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper.AnonymousClass2 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1683117964")) {
                        ipChange.ipc$dispatch("-1683117964", new Object[]{this, iNetResponse});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i(EndPageDataMapper.TAG, "reqRecordInfo  getRetCode = " + iNetResponse.getRetCode());
                    ((ILog) Dsl.getService(ILog.class)).i(EndPageDataMapper.TAG, "reqRecordInfo  getSource = " + iNetResponse.getSource());
                    try {
                        String retCode = iNetResponse.getRetCode();
                        if (!"SUCCESS".equals(retCode)) {
                            if (!"-302".equals(retCode)) {
                                getAttentionStateListener.onException();
                                return;
                            }
                        }
                        getAttentionStateListener.onCompleted(iNetResponse.getSource());
                    } catch (Exception unused) {
                        getAttentionStateListener.onException();
                    }
                }
            });
        }
    }

    public static void getEndPageData(Map<String, String> map, final GetEndPageDataListener getEndPageDataListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1675097383")) {
            ipChange.ipc$dispatch("1675097383", new Object[]{map, getEndPageDataListener});
            return;
        }
        INetRequest createRequestWithMTop = ((INetClient) Dsl.getService(INetClient.class)).createRequestWithMTop(DAGO_LIVE_END_PAGE_DATA, "1.0", map, false, false);
        if (createRequestWithMTop != null) {
            createRequestWithMTop.async(new INetCallback() {
                /* class com.youku.live.dago.liveplayback.widget.Mapper.EndPageDataMapper.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.INetCallback
                public void onFinish(INetResponse iNetResponse) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1703455339")) {
                        ipChange.ipc$dispatch("-1703455339", new Object[]{this, iNetResponse});
                        return;
                    }
                    ((ILog) Dsl.getService(ILog.class)).i(EndPageDataMapper.TAG, "reqRecordInfo  getRetCode = " + iNetResponse.getRetCode());
                    ((ILog) Dsl.getService(ILog.class)).i(EndPageDataMapper.TAG, "reqRecordInfo  getSource = " + iNetResponse.getSource());
                    try {
                        if ("SUCCESS".equals(iNetResponse.getRetCode())) {
                            getEndPageDataListener.onCompleted(iNetResponse.getSource());
                        } else {
                            getEndPageDataListener.onException();
                        }
                    } catch (Exception unused) {
                        getEndPageDataListener.onException();
                    }
                }
            });
        }
    }

    public static EndPageModel transformEndPageData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "834102054")) {
            return (EndPageModel) ipChange.ipc$dispatch("834102054", new Object[]{str});
        } else if (str == null) {
            return null;
        } else {
            try {
                return ((EndPageWrapper) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, EndPageWrapper.class)).data.data;
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
