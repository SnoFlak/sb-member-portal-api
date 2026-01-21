package com.sno.api.repositories;

import com.sno.api.entries.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntry, Long> {

    UserEntry findByPublicId(UUID publicId);
    UserEntry findByEmail(String email);
}
