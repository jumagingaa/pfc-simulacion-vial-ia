package ec.edu.uteq.backend.controller;

import ec.edu.uteq.backend.dto.SimulacionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulaciones")
public class SimulacionController {

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody SimulacionRequest request) {
        return ResponseEntity.ok("Simulación creada correctamente");
    }

    @GetMapping
    public ResponseEntity<String> listar() {
        return ResponseEntity.ok("Listado de simulaciones");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok("Simulación encontrada: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id,
                                             @RequestBody SimulacionRequest request) {
        return ResponseEntity.ok("Simulación actualizada: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        return ResponseEntity.ok("Simulación eliminada: " + id);
    }
}