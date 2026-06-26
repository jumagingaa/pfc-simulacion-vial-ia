package ec.edu.uteq.backend.service;

import ec.edu.uteq.backend.dto.EscenarioRequest;
import ec.edu.uteq.backend.dto.EscenarioResponse;
import ec.edu.uteq.backend.entity.Escenario;
import ec.edu.uteq.backend.repository.EscenarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscenarioService {

    private final EscenarioRepository escenarioRepository;

    public EscenarioService(EscenarioRepository escenarioRepository) {
        this.escenarioRepository = escenarioRepository;
    }

    public EscenarioResponse crear(EscenarioRequest request) {
        Escenario escenario = new Escenario();
        escenario.setNombre(request.getNombre());
        escenario.setDescripcion(request.getDescripcion());
        escenario.setTipoVia(request.getTipoVia());
        escenario.setNivelDificultad(request.getNivelDificultad());
        escenario.setClima(request.getClima());
        escenario.setDensidadTrafico(request.getDensidadTrafico());

        Escenario guardado = escenarioRepository.save(escenario);

        return convertirAResponse(guardado);
    }

    public List<EscenarioResponse> listar() {
        return escenarioRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .toList();
    }

    public EscenarioResponse buscarPorId(Long id) {
        Escenario escenario = escenarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escenario no encontrado"));

        return convertirAResponse(escenario);
    }

    public EscenarioResponse actualizar(Long id, EscenarioRequest request) {
        Escenario escenario = escenarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escenario no encontrado"));

        escenario.setNombre(request.getNombre());
        escenario.setDescripcion(request.getDescripcion());
        escenario.setTipoVia(request.getTipoVia());
        escenario.setNivelDificultad(request.getNivelDificultad());
        escenario.setClima(request.getClima());
        escenario.setDensidadTrafico(request.getDensidadTrafico());

        Escenario actualizado = escenarioRepository.save(escenario);

        return convertirAResponse(actualizado);
    }

    public void eliminar(Long id) {
        Escenario escenario = escenarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escenario no encontrado"));

        escenarioRepository.delete(escenario);
    }

    private EscenarioResponse convertirAResponse(Escenario escenario) {
        return new EscenarioResponse(
                escenario.getId(),
                escenario.getNombre(),
                escenario.getDescripcion(),
                escenario.getTipoVia(),
                escenario.getNivelDificultad(),
                escenario.getClima(),
                escenario.getDensidadTrafico()
        );
    }
}