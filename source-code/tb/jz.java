package tb;

/* compiled from: Taobao */
public class jz extends et {
    public static final String DX_EVENT_PIPELINE_SCHEDULE = "DX_EVENT_PIPELINE_SCHEDULE";
    public int d;
    public int e;
    public boolean f;

    public jz() {
        this.b = DX_EVENT_PIPELINE_SCHEDULE;
    }

    @Override // tb.et
    public boolean a(et etVar) {
        if (etVar != null && (etVar instanceof jz) && this.d == ((jz) etVar).d) {
            return super.a(etVar);
        }
        return false;
    }

    public String toString() {
        return "DXPipelineScheduleEvent{stage=" + this.d + ", sender=" + this.a + ", eventName='" + this.b + '\'' + ", args=" + this.c + '}';
    }
}
