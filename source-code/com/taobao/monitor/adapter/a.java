package com.taobao.monitor.adapter;

import com.taobao.monitor.procedure.IProcedure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tb.ws1;

/* compiled from: Taobao */
class a {
    private static final C0219a a = new C0219a();

    /* renamed from: com.taobao.monitor.adapter.a$a  reason: collision with other inner class name */
    /* compiled from: Taobao */
    public static class C0219a implements IProcedure {
        final ArrayList<IProcedure> a = new ArrayList<>();

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void addSubProcedure(IProcedure iProcedure) {
            if (iProcedure != null) {
                this.a.add(iProcedure);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void c() {
            this.a.clear();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addBiz(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addBiz(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addBizAbTest(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addBizAbTest(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addBizStage(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addBizStage(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addProperty(String str, Object obj) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addProperty(str, obj);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addPropertyIfAbsent(String str, Object obj) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addPropertyIfAbsent(str, obj);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addStatistic(String str, Object obj) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addStatistic(str, obj);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addSubTask(String str, long j, long j2) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addSubTask(str, j, j2);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure begin() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure end() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure event(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().event(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public boolean isAlive() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure onSubTaskBegin(String str) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSubTaskBegin(str);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure onSubTaskFail(String str, String str2, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSubTaskFail(str, str2, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure onSubTaskSuccess(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSubTaskSuccess(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure parent() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure stage(String str, long j) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().stage(str, j);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure stageIfAbsent(String str, long j) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().stageIfAbsent(str, j);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public String topic() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public String topicSession() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure end(boolean z) {
            throw new UnsupportedOperationException();
        }
    }

    public static IProcedure a() {
        C0219a aVar = a;
        aVar.c();
        aVar.addSubProcedure(ws1.b.getLauncherProcedure());
        aVar.addSubProcedure(ws1.b.getCurrentActivityProcedure());
        aVar.addSubProcedure(ws1.b.getCurrentFragmentProcedure());
        return aVar;
    }
}
