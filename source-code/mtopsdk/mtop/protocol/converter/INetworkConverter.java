package mtopsdk.mtop.protocol.converter;

import mtopsdk.framework.domain.MtopContext;
import mtopsdk.network.domain.Request;

/* compiled from: Taobao */
public interface INetworkConverter {
    Request convert(MtopContext mtopContext);
}
