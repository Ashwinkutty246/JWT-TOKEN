package com.Token.JWT_Token.Controller;

import com.Token.JWT_Token.Dtos.LoginUserDto;
import com.Token.JWT_Token.Dtos.RegisterUserDto;
import com.Token.JWT_Token.Entity.Register;
import com.Token.JWT_Token.Entity.User;
import com.Token.JWT_Token.Service.AuthenticationService;
import com.Token.JWT_Token.Service.JwtService;
import com.Token.JWT_Token.responses.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.RegisterableService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    /**
     *
     * @param registerUserDto
     * @return
     */

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public Register inserRegister(@RequestBody Register register) {
        return authenticationService.saveRegister(register);
    }
}

