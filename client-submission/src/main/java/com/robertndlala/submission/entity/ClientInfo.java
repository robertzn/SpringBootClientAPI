package com.robertndlala.submission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import ch.qos.logback.core.net.server.Client;
import lombok.*;

import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "count")
    private Long count;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @NonNull
    @Column(name = "last_name", nullable = false )
    private String last_name;


    @Size( min = 10, max = 10,  message = "ID Number must be 10 Number")
    @Column(name = "Mobile", nullable = false , length = 10, unique = true)
    private Long Mobile;

    @NonNull
    @Size( min = 13, max = 13,  message = "ID Number must be 13 Number")
    @Column(name = "idnumber", nullable = false , length = 13, unique = true)
    private Long idnumber;


    @Column(name = "physical_address", nullable = false)
    private String physical_address;


}
