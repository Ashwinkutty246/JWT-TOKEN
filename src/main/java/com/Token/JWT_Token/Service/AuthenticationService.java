package com.Token.JWT_Token.Service;

import com.Token.JWT_Token.Dtos.LoginUserDto;
import com.Token.JWT_Token.Dtos.RegisterUserDto;
import com.Token.JWT_Token.Entity.Register;
import com.Token.JWT_Token.Entity.User;
import com.Token.JWT_Token.repository.RegisterRepo;
import com.Token.JWT_Token.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private RegisterRepo registerRepo;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     *
     * @param input
     * @return
     */
    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
//        user.setAge(input.getAge());
//        user.setGender(input.getGender());
//        user.setPhone(input.getPhone());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

    public Register saveRegister(Register register) {
        return registerRepo.save(register);
    }
}


