package es.etg.daw.dawes.java.rest.restfull.auth.infraestructure.db.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.auth.infraestructure.db.jpa.entity.UserEntity;


@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{
    public UserEntity findByEmail(String email);
}