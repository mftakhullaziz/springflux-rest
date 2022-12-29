package com.example.reactiveSpringSQLService.persistence;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
public class UsersTRec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(value = "user_id")
    private Integer userId;

    @Column(value = "username")
    private String username;

    @Column(value = "name")
    private String name;

    @Column(value = "email")
    private String email;

    @Column(value = "phone")
    private String phone;

    @Column(value = "date_index")
    private Integer dateIndex;

    @Column(value = "creation_at")
    private LocalDateTime creationAt;

    @Column(value = "creation_by")
    private String creationBy;

    @Column(value = "last_updated_at")
    private LocalDateTime lastUpdateAt;

    @Column(value = "last_updated_by")
    private String lastUpdatedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsersTRec that = (UsersTRec) o;
        return userId != null && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

