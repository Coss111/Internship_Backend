package bo.edu.ucb.internshipProject.api;

import java.util.*;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.internshipProject.bl.AuthBl;
import bo.edu.ucb.internshipProject.bl.DegreeBl;
import bo.edu.ucb.internshipProject.dto.DegreeDto;
import bo.edu.ucb.internshipProject.dto.ResponseDto;

@RestController
@CrossOrigin(origins = "*")

public class DegreeApi {

    private DegreeBl degreeBl;

    public DegreeApi(DegreeBl degreeBl) {
        this.degreeBl = degreeBl;
    }

    /**
     * Este endpoint retorna todas las etiquetas
     * 
     * @param token El token JWT que se obtuvo al autenticar la aplicación
     * @return
     */

    @GetMapping("/api/v1/degree")
    public ResponseEntity<ResponseDto<List<DegreeDto>>> getAllLabels(
            @RequestHeader("Authorization") String token) {
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<DegreeDto>> responseDto = new ResponseDto<>();
            responseDto.setCode("0001");
            responseDto.setResponse(null);
            responseDto.setErrorMessage("Token invalido");
            return ResponseEntity.status(Response.SC_UNAUTHORIZED).build();
        }
        ResponseDto<List<DegreeDto>> responseDto = new ResponseDto<>();
        responseDto.setCode("0000");
        responseDto.setResponse(this.degreeBl.getAllDegrees());
        return ResponseEntity.status(Response.SC_OK).body(responseDto);

    }
}
