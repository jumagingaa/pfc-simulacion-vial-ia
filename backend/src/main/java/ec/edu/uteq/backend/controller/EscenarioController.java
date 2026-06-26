package ec.edu.uteq.backend.controller;

import ec.edu.uteq.backend.dto.EscenarioRequest;
import ec.edu.uteq.backend.dto.EscenarioResponse;
import ec.edu.uteq.backend.service.EscenarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/escenarios")
@CrossOrigin(origins = "*")
public class EscenarioController {

    private final EscenarioService escenarioService;

    public EscenarioController(EscenarioService escenarioService) {
        this.escenarioService = escenarioService;
    }

    @PostMapping
    public ResponseEntity<EscenarioResponse> crear(@RequestBody EscenarioRequest request) {
        return ResponseEntity.ok(escenarioService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<EscenarioResponse>> listar() {
        return ResponseEntity.ok(escenarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscenarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(escenarioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscenarioResponse> actualizar(@PathVariable Long id,
                                                        @RequestBody EscenarioRequest request) {
        return ResponseEntity.ok(escenarioService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        escenarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}