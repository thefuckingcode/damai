package cn.damai.tetris.component.star.net;

import java.io.Serializable;

/* compiled from: Taobao */
public class DoTaskResult implements Serializable {
    public TaskDetail taskDetail;
    public int totalAssetsNum;

    /* compiled from: Taobao */
    public class TaskDetail {
        public int applyStatus;

        public TaskDetail() {
        }
    }
}
