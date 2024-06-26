package anet.channel.fulltrace;

import anet.channel.fulltrace.IFullTraceAnalysisV3;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.Map;
import tb.c42;

/* compiled from: Taobao */
public class a {
    private static volatile IFullTraceAnalysis a = new C0001a(null);
    private static volatile IFullTraceAnalysisV3 b = new b(null);
    private static boolean c = false;
    private static boolean d = false;

    /* renamed from: anet.channel.fulltrace.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    private static class C0001a implements IFullTraceAnalysis {
        private IFullTraceAnalysis a;

        C0001a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.a = iFullTraceAnalysis;
            boolean unused = a.c = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.c && (iFullTraceAnalysis = this.a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.c = false;
                    ALog.d("anet.AnalysisFactory", "fulltrace commit fail.", null, th, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.c || (iFullTraceAnalysis = this.a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.c = false;
                ALog.d("anet.AnalysisFactory", "createRequest fail.", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public c42 getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.c || (iFullTraceAnalysis = this.a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.c = false;
                ALog.d("anet.AnalysisFactory", "getSceneInfo fail", null, th, new Object[0]);
                return null;
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysis
        public void log(String str, String str2, String str3) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.c && (iFullTraceAnalysis = this.a) != null) {
                try {
                    iFullTraceAnalysis.log(str, str2, str3);
                } catch (Throwable unused) {
                    boolean unused2 = a.c = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace log fail.", null, new Object[0]);
                }
            }
        }
    }

    /* compiled from: Taobao */
    private static class b implements IFullTraceAnalysisV3 {
        private IFullTraceAnalysisV3 a;

        b(IFullTraceAnalysisV3 iFullTraceAnalysisV3) {
            this.a = iFullTraceAnalysisV3;
            boolean unused = a.d = true;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
        public IFullTraceAnalysisV3.ISpan createRequest(Map<String, String> map) {
            IFullTraceAnalysisV3 iFullTraceAnalysisV3;
            if (a.d && (iFullTraceAnalysisV3 = this.a) != null) {
                try {
                    return iFullTraceAnalysisV3.createRequest(map);
                } catch (Throwable unused) {
                    boolean unused2 = a.d = false;
                    ALog.e("anet.AnalysisFactory", "createRequest log fail.", null, new Object[0]);
                }
            }
            return null;
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
        public void finishRequest(IFullTraceAnalysisV3.ISpan iSpan, RequestStatistic requestStatistic) {
            IFullTraceAnalysisV3 iFullTraceAnalysisV3;
            if (a.d && (iFullTraceAnalysisV3 = this.a) != null) {
                try {
                    iFullTraceAnalysisV3.finishRequest(iSpan, requestStatistic);
                } catch (Throwable unused) {
                    boolean unused2 = a.d = false;
                    ALog.e("anet.AnalysisFactory", "finishRequest fail.", null, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
        public void log(IFullTraceAnalysisV3.ISpan iSpan, String str, String str2) {
            IFullTraceAnalysisV3 iFullTraceAnalysisV3;
            if (a.d && (iFullTraceAnalysisV3 = this.a) != null) {
                try {
                    iFullTraceAnalysisV3.log(iSpan, str, str2);
                } catch (Throwable unused) {
                    boolean unused2 = a.d = false;
                    ALog.e("anet.AnalysisFactory", "log fail.", null, new Object[0]);
                }
            }
        }

        @Override // anet.channel.fulltrace.IFullTraceAnalysisV3
        public void setRequestStage(IFullTraceAnalysisV3.ISpan iSpan, String str, long j) {
            IFullTraceAnalysisV3 iFullTraceAnalysisV3;
            if (a.d && (iFullTraceAnalysisV3 = this.a) != null) {
                try {
                    iFullTraceAnalysisV3.setRequestStage(iSpan, str, j);
                } catch (Throwable unused) {
                    boolean unused2 = a.d = false;
                    ALog.e("anet.AnalysisFactory", "setRequestStage fail.", null, new Object[0]);
                }
            }
        }
    }

    public static IFullTraceAnalysis e() {
        return a;
    }

    public static IFullTraceAnalysisV3 f() {
        return b;
    }

    public static void g(IFullTraceAnalysis iFullTraceAnalysis) {
        a = new C0001a(iFullTraceAnalysis);
    }

    public static void h(IFullTraceAnalysisV3 iFullTraceAnalysisV3) {
        b = new b(iFullTraceAnalysisV3);
    }
}
