package entities;

import java.util.Date;

public class Expenses {
    private String reason;
    private String paidBy;
    private Date paidOn;
    private double amt;

    public Expenses(String reason, String paidBy, Date paidOn, double amount) {
        this.amt = amount;
        this.reason = reason;
        this.paidBy = paidBy;
        this.paidOn = paidOn;
    }

    public  void changeAmt(double amt) {
        this.amt = amt;
    }

    public String getReason(){
        return this.reason;
    }

    public String getPaidBy(){
        return this.paidBy;
    }

    public Date getPaidOn(){
        return this.paidOn;
    }

    public double getAmt(){
        return this.amt;
    }
}
