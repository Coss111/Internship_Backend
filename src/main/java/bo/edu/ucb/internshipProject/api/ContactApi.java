package bo.edu.ucb.internshipProject.api;

import bo.edu.ucb.internshipProject.bl.*;
import bo.edu.ucb.internshipProject.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
class ContactApi {

    private List<ContactDto> contacts = new ArrayList<>();

    /**
     * Este endpoint retorna todos los contactos
     * @param token El token JWT que se obtuvo al autenticar la aplicación
     * @return
     */
    @GetMapping("/api/v1/contact")
    public ResponseEntity<ResponseDto<List<ContactDto>>> getAllContacts(
        @RequestHeader("Authorization") String token) {
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<ContactDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        ResponseDto<List<ContactDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(contacts);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    /**
     * Este endpoint obitene el detalle de una contacto por ID
     * @param id La llave primaria del contacto
     * @param token El token de autenticación
     * @return
     */

    @GetMapping("/api/v1/contact/{idContact}")
    public ResponseEntity<ResponseDto<ContactDto>> getContactById(@PathVariable("idContact") Integer id, @RequestHeader("Authorization") String token) {
        ResponseDto<ContactDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        //Buscamos el elemento en la lista
        ContactDto contact = contacts.stream()
                .filter(t -> t.getContactId().equals(id))
                .findFirst()
                .orElse(null);
        if (contact != null) {
            response.setCode("0000");
            response.setResponse(contact);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.setCode("0002");
            response.setResponse(null);
            response.setErrorMessage("No existe el contacto con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    /**
     * Actualiza un contacto por id de contacto.
     * @param idContact La llave primaria del contacto
     * @param newContact Los nuevos datos para el contacto
     * @param token El token que se obtuvo en la autenticación
     * @return
     */
    @PutMapping("/api/v1/contact/{idContact}")
    public ResponseEntity<ResponseDto<ContactDto>> updateContactById(@PathVariable("idContact") Integer idContact, @RequestBody ContactDto newContact, @RequestHeader("Authorization") String token) {
        ResponseDto<ContactDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        //Buscamos el elemento en la lista
        ContactDto contact = contacts.stream()
                .filter(t -> t.getContactId().equals(idContact))
                .findFirst()
                .orElse(null);
        // Si no existe retornamos un error
        if (contact == null) {
            //  FIXME: Cambiar el codigo de error debe retornar 404
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Compañia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            // Si existe actualizamos el objeto
            contact.setContactEmail(newContact.getContactEmail());
            contact.setContactPhone(newContact.getContactPhone());
            contact.setContactFacebook(newContact.getContactFacebook());
            // Si existe retornamos el elemento
            response.setCode("0000");
            response.setResponse(contact);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    /**
     * Este metodo permite crear un contacto.
     * @param contact Todos los datos del contacto.
     * @param token El token obtenido en la autenticación
     * @return Retorna un mensaje: "Contact created" o error en su defecto.
     */

    @PostMapping("/api/v1/contact")
    final ResponseEntity<ResponseDto<String>> createContact(@RequestBody ContactDto contact, @RequestHeader("Authorization") String token) {
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
        if(contacts.size() > 0) {
            ContactDto lastContact = contacts.get(contacts.size() - 1);
            contact.setContactId(lastContact.getContactId() + 1);
        } else {
            contact.setContactId(1);
        }
        contacts.add(contact);

        response.setCode("0000");
        response.setResponse("Contact created");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * Este metodo permite eliminar un contacto.
     * @param idContact La llave primaria del contacto.
     * @param token El token obtenido en la autenticación
     * @return Retorna un mensaje: "Contact deleted" o error en su defecto.
     */
    @DeleteMapping("/api/v1/contact/{idContact}")
    final ResponseEntity<ResponseDto<String>> deleteContact(@PathVariable("idContact") Integer idContact, @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Token invalido");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        //Buscamos el elemento en la lista
        ContactDto contact = contacts.stream()
                .filter(t -> t.getContactId().equals(idContact))
                .findFirst()
                .orElse(null);
        // Si no existe retornamos un error
        if (contact == null) {
            //FIXME: Cambiar el codigo de error debe retornar
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Contacto no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            // Si existe eliminamos el objeto
            contacts.remove(contact);
            // Si existe retornamos el elemento
            response.setCode("0000");
            response.setResponse("Contact deleted");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}
