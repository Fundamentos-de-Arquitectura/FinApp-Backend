package com.example.finappapirest.security.application.internal.queryservices;

import com.example.finappapirest.security.domain.model.aggregates.User;
import com.example.finappapirest.security.domain.model.queries.GetAllUsersQuery;
import com.example.finappapirest.security.domain.model.queries.GetUserByIdQuery;
import com.example.finappapirest.security.domain.services.UserQueryService;
import com.example.finappapirest.security.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }
}
