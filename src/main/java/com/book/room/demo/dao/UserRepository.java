package com.book.room.demo.dao;

import com.book.room.demo.dto.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Long> {

    @Query("SELECT U FROM UserDTO U WHERE U.email = :email")
    public Optional<UserDTO> findByEmail(String email);

}
