package com.example.demo.domain.user.facade;

import com.example.demo.domain.user.entity.User;
import com.example.demo.domain.user.exception.ExistsUserEmailException;
import com.example.demo.domain.user.exception.ExistsUserIdException;
import com.example.demo.domain.user.exception.UserNotFoundException;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.global.security.auth.AuthDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentLoginUser() {
        AuthDetails auth = (AuthDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return auth.user();
    }

    @Transactional(readOnly = true)
    public void checkExistsEmail(String email) {
        if (userRepository.existsByEmail(email)){
            throw ExistsUserEmailException.EXCEPTION;
        }
    }

    @Transactional(readOnly = true)
    public void checkExistsId(String userId) {
        if (userRepository.existsByUserId(userId)){
            throw ExistsUserIdException.EXCEPTION;
        }
    }

    @Transactional(readOnly = true)
    public User findUserById(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

}
