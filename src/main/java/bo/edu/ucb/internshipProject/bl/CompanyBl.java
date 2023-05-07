package bo.edu.ucb.internshipProject.bl;

import java.util.ArrayList;
import java.util.List;
import bo.edu.ucb.internshipProject.dto.CompanyDto;
public class CompanyBl {

    private List<CompanyDto> companyDtoList;

    public CompanyBl(){
        this.companyDtoList = new ArrayList<>();
        //this.companyDtoList.add(new CompanyDto(1, "Coca Cola"));
    }
    
}
