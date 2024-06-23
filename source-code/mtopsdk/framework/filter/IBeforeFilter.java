package mtopsdk.framework.filter;

import mtopsdk.framework.domain.MtopContext;

/* compiled from: Taobao */
public interface IBeforeFilter extends IMtopFilter {
    String doBefore(MtopContext mtopContext);
}
