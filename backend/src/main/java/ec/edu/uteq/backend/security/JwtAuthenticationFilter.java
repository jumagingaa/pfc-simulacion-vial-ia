package ec.edu.uteq.backend.security;

import ec.edu.uteq.backend.entity.Usuario;
import ec.edu.uteq.backend.repository.UsuarioRepository;
import ec.edu.uteq.backend.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final TokenBlacklistService tokenBlacklistService;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   UsuarioRepository usuarioRepository,
                                   TokenBlacklistService tokenBlacklistService) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.tokenBlacklistService = tokenBlacklistService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        if (!jwtService.validarToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        String jti = jwtService.extraerJti(token);

        if (tokenBlacklistService.estaRevocado(jti)) {
            filterChain.doFilter(request, response);
            return;
        }

        String email = jwtService.extraerEmail(token);

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElse(null);

        if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            SimpleGrantedAuthority authority =
                    new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getNombre());

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            usuario.getEmail(),
                            null,
                            List.of(authority)
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}