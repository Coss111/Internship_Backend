package bo.edu.ucb.internshipProject.dto;
import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;

public class CompanyDto {
    private String name;
    private String description;
    private OffsetDateTime date;
    private List<ContactDto> contacts;
    private String image;

    public CompanyDto() {
    }
    
    public String getName() { return name; }
    
    public void setName(String value) { this.name = value; }

    public String getDescription() { return description; }
    
    public void setDescription(String value) { this.description = value; }

    public OffsetDateTime getDate() { return date; }
    
    public void setDate(OffsetDateTime value) { this.date = value; }

    public List<ContactDto> getContacts() { return contacts; }
    
    public void setContacts(List<ContactDto> value) { this.contacts = value; }

    public String getImage() { return image; }
    
    public void setImage(String value) { this.image = value; }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", date=" + getDate() +
                ", contacts=" + getContacts() +
                ", image='" + getImage() + '\'' +
                '}';
    }
}

