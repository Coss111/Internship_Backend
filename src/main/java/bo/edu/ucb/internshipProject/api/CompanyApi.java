package bo.edu.ucb.internshipProject.api;

import bo.edu.ucb.internshipProject.bl.*;
import bo.edu.ucb.internshipProject.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
class CompanyApi {

    private List<CompanyDto> companies = new ArrayList<>();

    /**
     * Este endpoint retorna todas las compañias
     * @param token El token JWT que se obtuvo al autenticar la aplicación
     * @return
     */
    @GetMapping("/api/v1/company")
    public ResponseEntity<ResponseDto<List<CompanyDto>>> getAllCompanies(
        @RequestHeader("Authorization") String token) {
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<CompanyDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        ResponseDto<List<CompanyDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(companies);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    /**
     * Este endpoint obitene el detalle de una compañia por ID
     * @param id La llave primaria de la compañia
     * @param token El token de autenticación
     * @return
     */
    @GetMapping("/api/v1/company/{idCompany}")
    public ResponseEntity<ResponseDto<CompanyDto>> getCompanyById(@PathVariable("idCompany") Integer id, @RequestHeader("Authorization") String token) {
        ResponseDto<CompanyDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        //Buscamos el elemento en la lista
        CompanyDto company = companies.stream()
                .filter(t -> t.getCompanyId().equals(id))
                .findFirst()
                .orElse(null);
        // Si no existe retornamos un error
        if (company == null) {
            //FIXME: Cambiar el codigo de error debe retornar 404
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("No existe la compañia con el ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            // Si existe retornamos el objeto
            response.setCode("0000");
            response.setResponse(company);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    /**
     * Actualiza una compañia por id de compañia.
     * @param idCompany La llave primaria de la compañia
     * @param newCompany Los nuevos datos para la compañia
     * @param token El token que se obtuvo en la autenticación
     * @return
     */
    @PutMapping("/api/v1/company/{idCompany}")
    public ResponseEntity<ResponseDto<CompanyDto>> updateCompanyById(@PathVariable("idCompany") Integer idCompany, @RequestBody CompanyDto newCompany, @RequestHeader("Authorization") String token) {
        ResponseDto<CompanyDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        //Buscamos el elemento en la lista
        CompanyDto company = companies.stream()
                .filter(t -> t.getCompanyId().equals(idCompany))
                .findFirst()
                .orElse(null);
        // Si no existe retornamos un error
        if (company == null) {
            //  FIXME: Cambiar el codigo de error debe retornar 404
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Compañia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            // Si existe actualizamos el objeto
            company.setCompanyName(newCompany.getCompanyName());
            company.setCompanyDescription(newCompany.getCompanyDescription());
            company.setCompanyDate(newCompany.getCompanyDate());
            company.setCompanyContacts(newCompany.getCompanyContacts());
            company.setCompanyImage(newCompany.getCompanyImage());
            // Si existe retornamos el elemento
            response.setCode("0000");
            response.setResponse(company);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    /**
     * Este metodo permite crear una compañia.
     * @param company Todos los datos de una compañia.
     * @param token El token obtenido en la autenticación
     * @return Retorna un mensaje: "Company created" o error en su defecto.
     */
    @PostMapping("/api/v1/company")
    public ResponseEntity<ResponseDto<String>> createCompany(@RequestBody CompanyDto company, @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }
        // Obtenemos el ultimo elemento de la lista  y le sumamos 1 para obtener el id
        // del nuevo elemento
        if(companies.size() > 0){
            CompanyDto lastCompany = companies.get(companies.size() - 1);
            company.setCompanyId(lastCompany.getCompanyId() + 1);
        } else {
            company.setCompanyId(1);
        }
        companies.add(company);

        response.setCode("0000");
        response.setResponse("Company created");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Este metodo permite eliminar una compañia.
     * @param idCompany La llave primaria de la compañia.
     * @param token El token obtenido en la autenticación
     * @return Retorna un mensaje: "Company deleted" o error en su defecto.
     */
    @DeleteMapping("/api/v1/company/{idCompany}")
    public ResponseEntity<ResponseDto<String>> deleteCompany(@PathVariable("idCompany") Integer idCompany, @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);

        }
        //Buscamos el elemento en la lista
        CompanyDto company = companies.stream()
                .filter(t -> t.getCompanyId().equals(idCompany))
                .findFirst()
                .orElse(null);
        // Si no existe retornamos un error
        if (company == null) {
            //FIXME: Cambiar el codigo de error debe retornar
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Compañia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            companies.remove(company);
            response.setCode("0000");
            response.setResponse("Company deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

}
