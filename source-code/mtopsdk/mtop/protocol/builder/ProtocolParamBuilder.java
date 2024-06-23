package mtopsdk.mtop.protocol.builder;

import java.util.Map;
import mtopsdk.framework.domain.MtopContext;

/* compiled from: Taobao */
public interface ProtocolParamBuilder {
    Map<String, String> buildParams(MtopContext mtopContext);
}
