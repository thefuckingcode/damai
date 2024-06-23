package mtopsdk.framework.filter;

import mtopsdk.framework.domain.MtopContext;

/* compiled from: Taobao */
public interface IAfterFilter extends IMtopFilter {
    String doAfter(MtopContext mtopContext);
}
