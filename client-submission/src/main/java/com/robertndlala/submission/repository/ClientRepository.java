package com.robertndlala.submission.repository;

import org.springframework.data.repository.CrudRepository;

import com.robertndlala.submission.entity.ClientInfo;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientInfo, Long> {
    Boolean existsByIdnumber(long idnumber);

    Optional<ClientInfo> findByIdnumber(long idnumber);

    //Boolean existsByMobile(long Mobile);

    //<ClientInfo> findByMobile(long Mobile);
}