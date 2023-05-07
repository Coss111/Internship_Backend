package bo.edu.ucb.internshipProject.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class InternshipDto {
    private Integer intershipId;
    private String intershipName;
    private String intershipDescription;
    private String intershipResponsability;
    private String intershipRequirement;
    private OffsetDateTime intershipDate;
    private OffsetDateTime intershipDeadline;
    private List<Integer> intershipCegreeIDS;
    private List<Integer> intershipCompanyID;
    private String intershipImage;

    public InternshipDto() {
    }

    
    public Integer getIntershipId() {
        return intershipId;
    }


    public void setIntershipId(Integer intershipId) {
        this.intershipId = intershipId;
    }


    public String getIntershipName() {
        return intershipName;
    }


    public void setIntershipName(String intershipName) {
        this.intershipName = intershipName;
    }


    public String getIntershipDescription() {
        return intershipDescription;
    }


    public void setIntershipDescription(String intershipDescription) {
        this.intershipDescription = intershipDescription;
    }


    public String getIntershipResponsability() {
        return intershipResponsability;
    }


    public void setIntershipResponsability(String intershipResponsability) {
        this.intershipResponsability = intershipResponsability;
    }


    public String getIntershipRequirement() {
        return intershipRequirement;
    }


    public void setIntershipRequirement(String intershipRequirement) {
        this.intershipRequirement = intershipRequirement;
    }


    public OffsetDateTime getIntershipDate() {
        return intershipDate;
    }


    public void setIntershipDate(OffsetDateTime intershipDate) {
        this.intershipDate = intershipDate;
    }


    public OffsetDateTime getIntershipDeadline() {
        return intershipDeadline;
    }


    public void setIntershipDeadline(OffsetDateTime intershipDeadline) {
        this.intershipDeadline = intershipDeadline;
    }


    public List<Integer> getIntershipCegreeIDS() {
        return intershipCegreeIDS;
    }


    public void setIntershipCegreeIDS(List<Integer> intershipCegreeIDS) {
        this.intershipCegreeIDS = intershipCegreeIDS;
    }


    public List<Integer> getIntershipCompanyID() {
        return intershipCompanyID;
    }


    public void setIntershipCompanyID(List<Integer> intershipCompanyID) {
        this.intershipCompanyID = intershipCompanyID;
    }


    public String getIntershipImage() {
        return intershipImage;
    }


    public void setIntershipImage(String intershipImage) {
        this.intershipImage = intershipImage;
    }


    @Override
    public String toString() {
        return "internshipDto [intershipId=" + intershipId + ", intershipName=" + intershipName
                + ", intershipDescription=" + intershipDescription + ", intershipResponsability="
                + intershipResponsability + ", intershipRequirement=" + intershipRequirement + ", intershipDate="
                + intershipDate + ", intershipDeadline=" + intershipDeadline + ", intershipCegreeIDS="
                + intershipCegreeIDS + ", intershipCompanyID=" + intershipCompanyID + ", intershipImage="
                + intershipImage + "]";
    }
    

    


    



    
}
