package com.prueba.Pruebae.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tablausuario1")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "ID")
    private Long id;
    @Getter @Setter @Column(name = "Nombre")
    private String Nombre;
    @Getter @Setter @Column(name = "Apellido")
    private String Apellido;
    @Getter @Setter @Column(name = "Email")
    private String Email;
    @Getter @Setter @Column(name = "Teléfono")
    private String Telefono;
    @Getter @Setter @Column(name = "Password")
    private String Password;


    }


