package com.example.demo.domain.auth.service;

import com.example.demo.domain.auth.presentation.dto.request.UserSignUpRequest;
import com.example.demo.domain.user.facade.UserFacade;
import com.example.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(UserSignUpRequest request) {
        userFacade.checkExistsEmail(request.getEmail());
        userFacade.checkExistsId(request.getUserId());

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        userRepository.save(request.toEntity(encodedPassword));
    }

}
