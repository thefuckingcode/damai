package com.youku.player.networkscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class NetworkSchedulerWrapper implements INetworkScheduleInterface {
    private static final int KEY_DUMMY = 0;
    private static final int KEY_NTK = 1;
    private HashMap<Integer, INetworkScheduleInterface> mSchedulers;

    /* compiled from: Taobao */
    private static class NetworkSchedulerWrapperInstance {
        private static final NetworkSchedulerWrapper instance = new NetworkSchedulerWrapper();

        private NetworkSchedulerWrapperInstance() {
        }
    }

    public static NetworkSchedulerWrapper getInstance() {
        return NetworkSchedulerWrapperInstance.instance;
    }

    @Override // com.youku.player.networkscheduler.INetworkScheduleInterface
    public boolean getDomainMappingRule(Map<String, String> map) {
        int size = this.mSchedulers.size() - 1;
        while (size >= 0 && !this.mSchedulers.get(Integer.valueOf(size)).getDomainMappingRule(map)) {
            size--;
        }
        return true;
    }

    public synchronized void registerScheduler(int i, INetworkScheduleInterface iNetworkScheduleInterface) {
        this.mSchedulers.put(Integer.valueOf(i), iNetworkScheduleInterface);
    }

    @Override // com.youku.player.networkscheduler.INetworkScheduleInterface
    public boolean resolveIpsFromDomain(String str, ArrayList<String> arrayList) {
        int size = this.mSchedulers.size() - 1;
        while (size >= 0 && !this.mSchedulers.get(Integer.valueOf(size)).resolveIpsFromDomain(str, arrayList)) {
            size--;
        }
        return true;
    }

    public synchronized void unRegisterScheduler(int i) {
        this.mSchedulers.remove(Integer.valueOf(i));
    }

    private NetworkSchedulerWrapper() {
        HashMap<Integer, INetworkScheduleInterface> hashMap = new HashMap<>();
        this.mSchedulers = hashMap;
        hashMap.put(0, new INetworkScheduleInterface() {
            /* class com.youku.player.networkscheduler.NetworkSchedulerWrapper.AnonymousClass1 */

            @Override // com.youku.player.networkscheduler.INetworkScheduleInterface
            public boolean getDomainMappingRule(Map<String, String> map) {
                return true;
            }

            @Override // com.youku.player.networkscheduler.INetworkScheduleInterface
            public boolean resolveIpsFromDomain(String str, ArrayList<String> arrayList) {
                return true;
            }
        });
    }
}
