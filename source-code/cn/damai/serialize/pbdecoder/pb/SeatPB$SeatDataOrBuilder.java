package cn.damai.serialize.pbdecoder.pb;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: Taobao */
public interface SeatPB$SeatDataOrBuilder extends MessageLiteOrBuilder {
    SeatPB$FloorSeat getFloorSeat(int i);

    int getFloorSeatCount();

    List<SeatPB$FloorSeat> getFloorSeatList();
}
