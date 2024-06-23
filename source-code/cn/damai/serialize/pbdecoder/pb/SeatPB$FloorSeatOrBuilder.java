package cn.damai.serialize.pbdecoder.pb;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: Taobao */
public interface SeatPB$FloorSeatOrBuilder extends MessageLiteOrBuilder {
    long getFloorId();

    SeatPB$Seat getSeatList(int i);

    int getSeatListCount();

    List<SeatPB$Seat> getSeatListList();
}
