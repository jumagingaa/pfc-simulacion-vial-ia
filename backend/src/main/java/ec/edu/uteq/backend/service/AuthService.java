package ec.edu.uteq.backend.service;

import ec.edu.uteq.backend.dto.AuthResponse;
import ec.edu.uteq.backend.dto.LoginRequest;
import ec.edu.uteq.backend.dto.RegisterRequest;
import ec.edu.uteq.backend.entity.Rol;
import ec.edu.uteq.backend.entity.Usuario;
import ec.edu.uteq.backend.repository.RolRepository;
import ec.edu.uteq.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository,
                       RolRepository rolRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse registrar(RegisterRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Rol rol = rolRepository.findByNombre("CONDUCTOR")
                .orElseThrow(() -> new RuntimeException("Rol CONDUCTOR no existe"));

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setEstado("ACTIVO");
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setRol(rol);

        usuarioRepository.save(usuario);

        String token = jwtService.generarToken(usuario.getEmail());
        String refreshToken = jwtService.generarRefreshToken(usuario.getEmail());

        return new AuthResponse(token, refreshToken);
    }

    public AuthResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        String token = jwtService.generarToken(usuario.getEmail());
        String refreshToken = jwtService.generarRefreshToken(usuario.getEmail());

        return new AuthResponse(token, refreshToken);
    }
}