package bo.edu.ucb.internshipProject.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDto {
    private String email;
    private String phone;
    private String facebook;

    public ContactDto() {
    }

    public String getEmail() { return email; }
    
    public void setEmail(String value) { this.email = value; }

    public String getPhone() { return phone; }
    
    public void setPhone(String value) { this.phone = value; }

    public String getFacebook() { return facebook; }
    
    public void setFacebook(String value) { this.facebook = value; }

    @Override
    public String toString() {
        return "ContactDto{" +
                "email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", facebook='" + getFacebook() + '\'' +
                '}';
    }
}