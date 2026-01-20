package com.sno.api.repositories;

import com.sno.api.entries.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntry, Long> {
}
