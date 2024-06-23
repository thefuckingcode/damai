package anetwork.channel;

import anetwork.channel.statist.StatisticData;

/* compiled from: Taobao */
public interface NetworkEvent$FinishEvent {
    String getDesc();

    int getHttpCode();

    StatisticData getStatisticData();
}
