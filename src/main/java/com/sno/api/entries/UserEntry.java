package com.sno.api.entries;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID publicId = UUID.randomUUID();

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, length = 60)
    private String password;

    @Column
    private List<Long> tickets;

    public String getEmail() {
        return email;
    }
    public UUID getPublicId() {
        return publicId;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
