package bo.edu.ucb.internshipProject.dto;
import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;

public class CompanyDto {
    private Integer companyId;
    private String companyName;
    private String companyDescription;
    private OffsetDateTime companyDate;
    private List<ContactDto> companyContacts;
    private String companyImage;

    public CompanyDto() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public OffsetDateTime getCompanyDate() {
        return companyDate;
    }

    public void setCompanyDate(OffsetDateTime companyDate) {
        this.companyDate = companyDate;
    }

    public List<ContactDto> getCompanyContacts() {
        return companyContacts;
    }

    public void setCompanyContacts(List<ContactDto> companyContacts) {
        this.companyContacts = companyContacts;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", companyDate=" + companyDate +
                ", companyContacts=" + companyContacts +
                ", companyImage='" + companyImage + '\'' +
                '}';
    }
}

