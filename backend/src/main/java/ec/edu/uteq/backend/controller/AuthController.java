package ec.edu.uteq.backend.controller;

import ec.edu.uteq.backend.dto.AuthResponse;
import ec.edu.uteq.backend.dto.LoginRequest;
import ec.edu.uteq.backend.dto.RegisterRequest;
import ec.edu.uteq.backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registrar(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

}