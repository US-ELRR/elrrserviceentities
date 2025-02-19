package com.deloitte.elrr.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.Identity;

@Repository
public interface IdentityRepository
        extends JpaRepository<Identity, UUID> {

    Identity findByIfi(String ifi);
}
