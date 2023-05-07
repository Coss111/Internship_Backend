package bo.edu.ucb.internshipProject.dto;

public class DegreeDto {
    private Integer degreeId;
    private String name;

    public DegreeDto() {
    }

    public DegreeDto(Integer degreeId, String name) {
        this.degreeId = degreeId;
        this.name = name;
    }

    public Integer getDegreeId() {
        return this.degreeId;
    }

    public void setDegreeId(Integer labelId) {
        this.degreeId = labelId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String toString() {
        return "{" +
                " labelId='" + getDegreeId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }
}
