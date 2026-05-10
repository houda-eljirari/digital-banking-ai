package ma.enset.digitalbankingbackend.web;

import lombok.AllArgsConstructor;
import ma.enset.digitalbankingbackend.security.dto.LoginRequest;
import ma.enset.digitalbankingbackend.security.dto.LoginResponse;
import ma.enset.digitalbankingbackend.security.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest loginRequest){

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(),
                                loginRequest.getPassword()
                        )
                );

        String jwt = JwtUtil.generateToken(
                authentication.getName()
        );

        return new LoginResponse(jwt);
    }
}