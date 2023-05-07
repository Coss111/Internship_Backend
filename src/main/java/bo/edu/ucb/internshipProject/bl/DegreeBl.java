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
                "Administración de Empresas"));
        this.degreeDtoList.add(new DegreeDto(
                2,
                "Administración Turística"));
        this.degreeDtoList.add(new DegreeDto(
                3,
                "Contaduría Pública"));
        this.degreeDtoList.add(new DegreeDto(
                4,
                "Economía"));
        this.degreeDtoList.add(new DegreeDto(
                5,
                "Economía e Inteligencia de Negocios"));
        this.degreeDtoList.add(new DegreeDto(
                6,
                "Ingeniería en Innovación Empresarial"));
        this.degreeDtoList.add(new DegreeDto(
                7,
                "Ingeniería Comercial"));
        this.degreeDtoList.add(new DegreeDto(
                8,
                "Marketing y Medios Digitales"));
        this.degreeDtoList.add(new DegreeDto(
                9,
                "Ingeniería Ambiental"));
        this.degreeDtoList.add(new DegreeDto(
                10,
                "Ingeniería Biomédica"));
        this.degreeDtoList.add(new DegreeDto(
                11,
                "Ingeniería Bioquímica y de Bioprocesos"));
        this.degreeDtoList.add(new DegreeDto(
                12,
                "Ingeniería Civil"));
        this.degreeDtoList.add(new DegreeDto(
                13,
                "Ingeniería en Energía"));
        this.degreeDtoList.add(new DegreeDto(
                14,
                "Ingeniería en Logística y Analítica de la Cadena de Suministro"));
        this.degreeDtoList.add(new DegreeDto(
                15,
                "Ingeniería en Multimedia e Interactividad Digital"));
        this.degreeDtoList.add(new DegreeDto(
                16,
                "Ingeniería Industrial"));
        this.degreeDtoList.add(new DegreeDto(
                17,
                "Ingeniería Química"));
        this.degreeDtoList.add(new DegreeDto(
                18,
                "Ingeniería Mecatrónica"));
        this.degreeDtoList.add(new DegreeDto(
                19,
                "Ingeniería en Sistemas"));
        this.degreeDtoList.add(new DegreeDto(
                20,
                "Ingeniería de Telecomunicaciones"));
        this.degreeDtoList.add(new DegreeDto(
                21,
                "Comunicación Social"));
        this.degreeDtoList.add(new DegreeDto(
                22,
                "Filosofía y Letras"));
        this.degreeDtoList.add(new DegreeDto(
                23,
                "Psicología"));
        this.degreeDtoList.add(new DegreeDto(
                24,
                "Psicopedagogía"));
        this.degreeDtoList.add(new DegreeDto(
                25,
                "Arquitectura"));
        this.degreeDtoList.add(new DegreeDto(
                26,
                "Arquitectura de Interiores"));
        this.degreeDtoList.add(new DegreeDto(
                27,
                "Diseño digital"));
        this.degreeDtoList.add(new DegreeDto(
                28,
                "Diseño Gráfico y Comunicación Visual"));
        this.degreeDtoList.add(new DegreeDto(
                29,
                "Ciencias Políticas y Relaciones Internacionales"));
        this.degreeDtoList.add(new DegreeDto(
                30,
                "Derecho"));
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
