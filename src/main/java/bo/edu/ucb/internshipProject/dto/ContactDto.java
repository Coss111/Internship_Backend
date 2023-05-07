package bo.edu.ucb.internshipProject.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDto {
    private Integer contactId;
    private String contactEmail;
    private String contactPhone;
    private String contactFacebook;

    public ContactDto() {
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactFacebook() {
        return contactFacebook;
    }

    public void setContactFacebook(String contactFacebook) {
        this.contactFacebook = contactFacebook;
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "contactId=" + contactId +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactFacebook='" + contactFacebook + '\'' +
                '}';
    }
}