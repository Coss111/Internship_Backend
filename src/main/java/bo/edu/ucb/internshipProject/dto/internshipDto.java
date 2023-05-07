package bo.edu.ucb.internshipProject.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class internshipDto {
    private Integer interId;
    private String name;
    private String description;
    private String responsability;
    private String requirement;
    private OffsetDateTime date;
    private OffsetDateTime deadline;
    private List<Integer> degreeIDS;
    private List<Integer> companyID;
    private String image;

    public internshipDto() {
    }

    public int getInterId() {
        return interId;
    }

    public void setInterId(Integer interId) {
        this.interId = interId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsability() {
        return responsability;
    }

    public void setResponsability(String responsability) {
        this.responsability = responsability;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public OffsetDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(OffsetDateTime deadline) {
        this.deadline = deadline;
    }

    public List<Integer> getDegreeIDS() {
        return degreeIDS;
    }

    public void setDegreeIDS(List<Integer> degreeIDS) {
        this.degreeIDS = degreeIDS;
    }

    public List<Integer> getCompanyID() {
        return companyID;
    }

    public void setCompanyID(List<Integer> value) {
        this.companyID = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "internshipDto{" +
                "interId='" + getInterId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", responsability='" + getResponsability() + "'" +
                ", requirement='" + getRequirement() + "'" +
                ", date='" + getDate() + "'" +
                ", deadline='" + getDeadline() + "'" +
                ", degreeIDS='" + getDegreeIDS() + "'" +
                ", companyID='" + getCompanyID() + "'" +
                ", image='" + getImage() + "'" +
                "}";
    }
}
