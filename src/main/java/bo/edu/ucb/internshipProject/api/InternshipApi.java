package bo.edu.ucb.internshipProject.api;
import java.util.*;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import bo.edu.ucb.internshipProject.bl.AuthBl;
import bo.edu.ucb.internshipProject.dto.ResponseDto;
import bo.edu.ucb.internshipProject.dto.internshipDto;

@RestController
@CrossOrigin(origins = "*")

class InternshipApi {
    private List<internshipDto> internshi = new ArrayList<>();


    /**
     * Este endpoint retorna todas las tareas
     * 
     * @param token El token JWT que se obtuvo al autenticar la aplicación
     * @return
     */

    @GetMapping("/api/v1/internship")
    public ResponseEntity<ResponseDto<List<internshipDto>>> getAllInternship(
        @RequestHeader("Authorization") String token) {
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<internshipDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        ResponseDto<List<internshipDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(internshi);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Este endpoint obitene el detalle de una tarea por ID
     * 
     * @param id    La llave primaria de la tarea
     * @param token El token de autenticación
     * @return
     */

     @GetMapping("/api/v1/internship/{idinternship}")
     public ResponseEntity<ResponseDto<internshipDto>> getTaskById(@PathVariable("idinternship") Integer id,
             @RequestHeader("Authorization") String token) {
         ResponseDto<internshipDto> response = new ResponseDto<>();
         AuthBl authBl = new AuthBl();
         if (!authBl.validateToken(token)) {
             response.setCode("0001");
             response.setResponse(null);
             response.setErrorMessage("Invalid token");
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
         }
         // Buscamos el elemento en la lista
         internshipDto intership = internshi.stream()
                 .filter(t -> t.getIntershipId().equals(id))
                 .findFirst()
                 .orElse(null);
         // Si no existe retornamos un error
         if (intership == null) {
             // FIXME: Cambiar el codigo de error debe retornar 404
             response.setCode("0001");
             response.setResponse(null);
             response.setErrorMessage("Task not found");
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
         } else {
             // Si existe retornamos el elemento
             response.setCode("0000");
             response.setResponse(intership);
             return ResponseEntity.status(HttpStatus.OK).body(response);
         }
     }

     /**
     * Actualiza una tarea por id de tarea.
     * 
     * @param idIntership  La llave primaria de la tarea
     * @param newIntership Los nuevos datos para la tarea
     * @param token   El token que se obtuvo en la autenticación
     * @return
     */

    @GetMapping("/api/v1/internship/{idinternship}")
    public ResponseEntity<ResponseDto<internshipDto>>updateInternshipById(@PathVariable("idinternship") Integer idInternship,
            @RequestBody internshipDto newInternship,
            @RequestHeader("Authorization") String token) {
        ResponseDto<internshipDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        if (newInternship.getIntershipDescription() == null || newInternship.getIntershipDescription().trim().equals("")) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Description is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        internshipDto intership = internshi.stream()
                .filter(t -> t.getIntershipId().equals(idInternship))
                .findFirst()
                .orElse(null);
        
        if (intership == null) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            intership.setIntershipDescription(newInternship.getIntershipDescription());
            response.setCode("0000");
            response.setResponse(intership);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }


    /**
     * Elimina una tarea por id de tarea.
     * 
     * @param idIntership  La llave primaria de la tarea
     * @param token   El token que se obtuvo en la autenticación
     * @return
     */

    @DeleteMapping("/api/v1/internship/{idinternship}")
    public ResponseEntity<ResponseDto<String>>deleteInternshipById(@PathVariable("idinternship") Integer idInternship,
            @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        
        internshipDto intership = internshi.stream()
                .filter(t -> t.getIntershipId().equals(idInternship))
                .findFirst()
                .orElse(null);
        
        if (intership == null) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            internshi.remove(intership);
            response.setCode("0000");
            response.setResponse("Internship deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    /**
     * Crea una nueva tarea
     * 
     * @param newInternship Los datos de la nueva tarea
     * @param token   El token que se obtuvo en la autenticación
     * @return
     */

    @PostMapping("/api/v1/internship")
    public ResponseEntity<ResponseDto<String>> createInternship(@RequestBody internshipDto newInternship,
            @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        if (newInternship.getIntershipDescription() == null || newInternship.getIntershipDescription().trim().equals("")) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Description is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        newInternship.setIntershipId(internshi.size() + 1);
        internshi.add(newInternship);
        response.setCode("0000");
        response.setResponse("Task created");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
