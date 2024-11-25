package dia06.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer romNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public Reservation(){

    }

    public Reservation(Integer romNumber, Date checkout, Date checkin) {
        this.romNumber = romNumber;
        this.checkout = checkout;
        this.checkin = checkin;
    }

    public Integer getRomNumber() {
        return romNumber;
    }

    public void setRomNumber(Integer romNumber) {
        this.romNumber = romNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long durartion(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkin, Date checkout){

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
            return "erro data de atualizcao anterior";
        } else if (checkin.after(checkout)) {
           return "erro data de check-out anterior a de check-in";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
        return "Room" + romNumber + ", " + "check-in: " + sdf.format(checkin) + ", " +
                "check-out: " + sdf.format(checkout) + ", " + durartion() + " nights";
    }
}
