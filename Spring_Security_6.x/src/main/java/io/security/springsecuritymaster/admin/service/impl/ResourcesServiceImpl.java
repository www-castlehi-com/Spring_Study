package io.security.springsecuritymaster.admin.service.impl;

import io.security.springsecuritymaster.admin.repositiory.ResourcesRepository;
import io.security.springsecuritymaster.admin.service.ResourcesService;
import io.security.springsecuritymaster.domain.entity.Resources;
import io.security.springsecuritymaster.security.manager.CustomDynamicAuthorizationManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ResourcesServiceImpl implements ResourcesService {

    private final ResourcesRepository resourcesRepository;
    private final CustomDynamicAuthorizationManager authorizationManager;

    @Override
    public Resources getResources(long id) {
        return resourcesRepository.findById(id).orElse(new Resources());
    }

    @Override
    public List<Resources> getResources() {
        return resourcesRepository.findAll(Sort.by(Sort.Order.asc("orderNum")));
    }

    @Override
    public void createResources(Resources resources) {
        resourcesRepository.save(resources);
        authorizationManager.reload();
    }

    @Override
    public void deleteResources(long id) {
        resourcesRepository.deleteById(id);
    }
}
