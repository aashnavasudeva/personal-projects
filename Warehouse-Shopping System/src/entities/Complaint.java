package entities;

import java.time.LocalDate;

public class Complaint {

    private static int counter;
    private String complaintID;
    private LocalDate dateIssued;
    private boolean resolved;
    private LocalDate dateResolved;
    private String complainer;
    private String complainAbout;
    private String itemID;
    private String content;

    /**
     * Entities.Complaint constructor
     * @param content what the complaint is about
     * @param buyerID the buyer who has lodged the complaint
     * @param sellerID the seller of the item the complaint has been lodged about
     * @param itemID the item ID of the item the complaint has been lodged about
     */
    public Complaint(String content, String complainer, String complainAbout, String itemID){
        this.complaintID = String.valueOf(counter);
        counter++;
        this.content = content;
        this.complainer = complainer;
        this.complainAbout = complainAbout;
        this.itemID = itemID;
        this.dateIssued = LocalDate.now();
        this.resolved = false;
        this.dateResolved = null;
    }

    /**
     * Returns whether the complaint has been resolved
     * @return true iff the complaint has been resolved
     */
    public boolean isResolved(){
        return this.resolved;
    }

    /**
     * Sets the date the complaints has been resolved
     * @param curr date complaint was resolved
     */
    public void setDateResolved(LocalDate curr){
        this.dateResolved = curr;
    }

    /**
     * Sets resolved to true if the complaint has been resolved
     */
    public void setResolved(){
        this.resolved = true;
    }

    public String getComplaintID(){
        return this.complaintID;
    }

    public String getComplaintContent(){
        return this.content;
    }
}
