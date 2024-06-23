package tb;

import com.heytap.mcssdk.constant.MessageConstant$CommandId;

/* compiled from: Taobao */
public class ox {
    public static final ox EVENT_CHAIN_ERROR_ABILITY_EXEC_RESULT_IS_NULL = new ox(2, "event ability callback params is null");
    public static final ox EVENT_CHAIN_ERROR_ABILITY_IS_NULL = new ox(1, "event ability is null");
    public static final ox EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_ABILITY_IS_NULL = new ox(4098, "event atomic execute ability is null");
    public static final ox EVENT_CHAIN_ERROR_ATOMIC_EXECUTE_CONTEXT_IS_NULL = new ox(4097, "event atomic execute context is null");
    public static final ox EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL = new ox(MessageConstant$CommandId.COMMAND_STATISTIC, "event chain execute atomic context is null");
    public static final ox EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL = new ox(MessageConstant$CommandId.COMMAND_SET_ALIAS, "event chain execute atomic eventnode is null");
    public static final ox EVENT_CHAIN_ERROR_EXECUTE_CONTEXT_IS_NULL = new ox(8193, "event chain execute context is null");
    public static final ox EVENT_CHAIN_ERROR_EXECUTE_EVENTCHIAN_CONTEXT_IS_NULL = new ox(MessageConstant$CommandId.COMMAND_UNREGISTER, "event chain execute eventchian context is null");
    public int a;
    public String b;

    public ox(int i, String str) {
        this.a = i;
        this.b = str;
    }
}
