package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date check_In;
    private Date check_Out;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date check_In, Date check_Out) {
        this.roomNumber = roomNumber;
        this.check_In = check_In;
        this.check_Out = check_Out;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheck_In() {
        return check_In;
    }

    public Date getCheck_Out() {
        return check_Out;
    }

    public long duration() {
        long diff = check_Out.getTime() - check_In.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date check_In, Date check_Out) {
        Date now = new Date();
        if (check_In.before(now) || check_Out.before(now)) {
            return"Reservation dates for update must be future dates.";
        } 
        if (!check_Out.after(check_In)) {
            return"Check-out date must be after check-in date.";

        }

        this.check_In = check_In;
        this.check_Out = check_Out;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(check_In)
                + ", check-out: "
                + sdf.format(check_Out)
                + ", "
                + duration()
                + " nights";
    }
}
