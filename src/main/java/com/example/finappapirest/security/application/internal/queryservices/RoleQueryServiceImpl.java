package com.example.finappapirest.security.application.internal.queryservices;


import com.example.finappapirest.security.domain.model.entities.Role;
import com.example.finappapirest.security.domain.model.queries.GetAllRolesQuery;
import com.example.finappapirest.security.domain.model.queries.GetRoleByNameQuery;
import com.example.finappapirest.security.domain.services.RoleQueryService;
import com.example.finappapirest.security.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository roleRepository;

    public RoleQueryServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return roleRepository.findByName(query.name());
    }
}
