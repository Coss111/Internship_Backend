package bo.edu.ucb.internshipProject.bl;

import java.util.ArrayList;
import java.util.List;
import bo.edu.ucb.internshipProject.dto.DegreeDto;
import bo.edu.ucb.internshipProject.dto.ResponseDto;

public class DegreeBl {
    private List<DegreeDto> degreeDtoList;

    public DegreeBl() {
        this.degreeDtoList = new ArrayList<>();
        this.degreeDtoList.add(new DegreeDto(
                1,
                "Ingenieria de Sistemas"));
        this.degreeDtoList.add(new DegreeDto(
                2,
                "Ingenieria Industrial"));
        this.degreeDtoList.add(new DegreeDto(
                3,
                "Ingenieria Comercial"));
        this.degreeDtoList.add(new DegreeDto(
                4,
                "Ingenieria Civil"));
        this.degreeDtoList.add(new DegreeDto(
                5,
                "Ingenieria Ambiental"));
        this.degreeDtoList.add(new DegreeDto(
                6,
                "Ingenieria Mecanica"));
        this.degreeDtoList.add(new DegreeDto(
                7,
                "Ingenieria Electrica"));
        this.degreeDtoList.add(new DegreeDto(
                8,
                "Ingenieria Electronica"));
        this.degreeDtoList.add(new DegreeDto(
                9,
                "Ingenieria Quimica"));

    }

    public List<DegreeDto> getAllDegrees() {
        return degreeDtoList;
    }

    public DegreeDto getDegreeById(Integer id) {
        DegreeDto degre = degreeDtoList.stream()
                .filter(t -> t.getDegreeId().equals(id))
                .findFirst()
                .orElse(null);
        return degre;
    }

    public DegreeDto updateDegreeById(Integer idDegree, DegreeDto newDegree) {
        DegreeDto degree = degreeDtoList.stream()
                .filter(t -> t.getDegreeId().equals(idDegree))
                .findFirst()
                .orElse(null);
        degree.setName(newDegree.getName());
        return degree;
    }

    public void createDegree(DegreeDto degree) {
        if (degreeDtoList.size() > 0) {
            DegreeDto lastDegree = degreeDtoList.get(degreeDtoList.size() - 1);
            degree.setDegreeId(lastDegree.getDegreeId() + 1);
        } else {
            degree.setDegreeId(1);
        }
        degreeDtoList.add(degree);
    }

    public void deleteDegreeById(Integer idDegree) {
        // Buscamos el elemento en la lista
        DegreeDto degree = degreeDtoList.stream()
                .filter(t -> t.getDegreeId().equals(idDegree))
                .findFirst()
                .orElse(null);
        // Si no existe retornamos un error
        if (degree != null) {
            degreeDtoList.remove(degree);
        }
    }

}
