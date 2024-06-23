package com.youku.middlewareservice.provider.task;

/* compiled from: Taobao */
public enum TaskType {
    IO(1),
    NORMAL(2),
    CPU(3),
    RPC(4),
    SCHEDULER(5);
    
    private int value;

    private TaskType(int i) {
        this.value = i;
    }

    public static TaskType fromValue(int i) {
        TaskType[] values = values();
        for (TaskType taskType : values) {
            if (taskType.getValue() == i) {
                return taskType;
            }
        }
        return NORMAL;
    }

    public int getValue() {
        return this.value;
    }
}
