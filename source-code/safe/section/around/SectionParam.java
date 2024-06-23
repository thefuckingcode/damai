package safe.section.around;

public class SectionParam {
    private Object a = null;
    private Throwable b = null;
    public Invocation invocation;
    public boolean returnEarly = false;

    public Object getResult() {
        return this.a;
    }

    public Throwable getThrowable() {
        return this.b;
    }

    public boolean hasThrowable() {
        return this.b != null;
    }

    public void setResult(Object obj) {
        this.a = obj;
    }

    public void setThrowable(Throwable th) {
        this.b = th;
    }
}
