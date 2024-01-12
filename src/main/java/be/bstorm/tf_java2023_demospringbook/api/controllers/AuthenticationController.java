package be.bstorm.tf_java2023_demospringbook.api.controllers;

import be.bstorm.tf_java2023_demospringbook.api.models.dtos.UserDTO;
import be.bstorm.tf_java2023_demospringbook.api.models.dtos.UserTokenDTO;
import be.bstorm.tf_java2023_demospringbook.api.models.forms.LoginForm;
import be.bstorm.tf_java2023_demospringbook.api.utils.JwtUtils;
import be.bstorm.tf_java2023_demospringbook.bll.services.security.AuthenticationService;
import be.bstorm.tf_java2023_demospringbook.domain.entities.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserTokenDTO> register(
            @RequestBody LoginForm loginForm
            ){
        User u = authenticationService.register(loginForm.toEntity());
        UserDTO dto = UserDTO.fromEntity(u);
        return ResponseEntity.ok(new UserTokenDTO(dto, jwtUtils.generateToken(u)));
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenDTO> login(
            @RequestBody LoginForm loginForm
    ){
        User u = authenticationService.login(loginForm.toEntity());
        UserDTO dto = UserDTO.fromEntity(u);
        return ResponseEntity.ok(new UserTokenDTO(dto, jwtUtils.generateToken(u)));
    }
}
