package tb;

import cn.damai.seatdecoder.common.bean.BaseDecodeResult;
import cn.damai.seatdecoder.common.bean.StaticSeat;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import cn.damai.seatdecoder.seat.bean.SeatDataDecodeResult;
import cn.damai.serialize.pbdecoder.pb.SeatPB$FloorSeat;
import cn.damai.serialize.pbdecoder.pb.SeatPB$Seat;
import cn.damai.serialize.pbdecoder.pb.SeatPB$SeatData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class z62 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static List<StaticStandSeat> a(SeatPB$SeatData seatPB$SeatData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388399544")) {
            return (List) ipChange.ipc$dispatch("-388399544", new Object[]{seatPB$SeatData});
        } else if (seatPB$SeatData == null) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            List<SeatPB$FloorSeat> floorSeatList = seatPB$SeatData.getFloorSeatList();
            for (int i = 0; i < floorSeatList.size(); i++) {
                SeatPB$FloorSeat seatPB$FloorSeat = floorSeatList.get(i);
                if (seatPB$FloorSeat.getSeatListList() != null) {
                    StaticStandSeat staticStandSeat = new StaticStandSeat();
                    staticStandSeat.setStand(Long.valueOf(seatPB$FloorSeat.getFloorId()));
                    ArrayList arrayList2 = new ArrayList();
                    List<SeatPB$Seat> seatListList = seatPB$FloorSeat.getSeatListList();
                    for (int i2 = 0; i2 < seatListList.size(); i2++) {
                        SeatPB$Seat seatPB$Seat = seatListList.get(i2);
                        StaticSeat staticSeat = new StaticSeat();
                        staticSeat.setSid(seatPB$Seat.getSid());
                        staticSeat.setX(seatPB$Seat.getX());
                        staticSeat.setY(seatPB$Seat.getY());
                        staticSeat.setFn(seatPB$Seat.getFn());
                        staticSeat.setRhint(seatPB$Seat.getRhint());
                        staticSeat.setChint(seatPB$Seat.getChint());
                        staticSeat.setPlid(seatPB$Seat.getPlid());
                        staticSeat.setGroupId(seatPB$Seat.getGroupId());
                        staticSeat.setGroupPriceId(seatPB$Seat.getGroupPriceId());
                        staticSeat.setAngle(seatPB$Seat.getAngle());
                        staticSeat.setI(seatPB$Seat.getI());
                        arrayList2.add(staticSeat);
                    }
                    staticStandSeat.setSeats(arrayList2);
                    arrayList.add(staticStandSeat);
                }
            }
            return arrayList;
        }
    }

    public static SeatDataDecodeResult b(String str) {
        byte[] bArr;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780482003")) {
            return (SeatDataDecodeResult) ipChange.ipc$dispatch("1780482003", new Object[]{str});
        }
        SeatDataDecodeResult seatDataDecodeResult = new SeatDataDecodeResult();
        File file = new File(str);
        if (!file.exists()) {
            return seatDataDecodeResult;
        }
        try {
            if (ir0.c(file)) {
                bArr = ir0.b(str);
                if (bArr == null) {
                    seatDataDecodeResult.setResultCode(BaseDecodeResult.DECODE_DECOMPRESS_ERROR);
                    seatDataDecodeResult.setMessage("座位静态数据解压缩失败");
                    return seatDataDecodeResult;
                }
            } else {
                bArr = yh0.a(file);
            }
            if (bArr == null) {
                return seatDataDecodeResult;
            }
            List<StaticStandSeat> c = c(bArr);
            if (c == null) {
                seatDataDecodeResult.setResultCode(BaseDecodeResult.DECODE_SERIALIZE_ERROR);
                seatDataDecodeResult.setMessage(w72.SEAT_STATIC_DATA_SERIALIZE_ERROR_MSG);
            } else {
                seatDataDecodeResult.setResultCode(1);
                seatDataDecodeResult.setResult(c);
            }
            return seatDataDecodeResult;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<StaticStandSeat> c(byte[] bArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630829600")) {
            return (List) ipChange.ipc$dispatch("-1630829600", new Object[]{bArr});
        } else if (bArr == null) {
            return null;
        } else {
            try {
                SeatPB$SeatData P = SeatPB$SeatData.P(bArr);
                if (P == null) {
                    return null;
                }
                return a(P);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
