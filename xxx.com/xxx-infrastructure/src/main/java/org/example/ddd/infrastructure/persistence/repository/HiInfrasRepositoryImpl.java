package org.example.ddd.infrastructure.persistence.repository;

import org.example.ddd.domain.repository.HiDomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HiInfrasRepositoryImpl implements HiDomainRepository {
    @Override
    public String sayHi(String who) {
        return "Hi InfraStructure" + who;
    }
}
