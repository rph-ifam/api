package com.example.api_client.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="cep")
    @NotBlank(message = "Cep é obrigatório")
    @Length(message="Cep com no máximo 8 caracteres",max=8)
    String cep;

    @Column(name="rua")
    @NotBlank(message = "Rua é obrigatório")
    @Length(message="Rua com no máximo 50 caracteres",max=50)
    String rua;

    @Column(name="bairro")
    @NotBlank(message = "Bairro é obrigatório")
    @Length(message="Bairro com 50 caracteres",max=50)
    String bairro;

    @Column(name="numero")
    @NotBlank(message = "Número é obrigatório")
    @Length(message="Número com 50 caracteres",max=50)
    Integer numero;

    @Column(name="cidade")
    @NotBlank(message = "Cidade é obrigatório")
    @Length(message="Cidade com 50 caracteres",max=50)
    String cidade;

    @Column(name="uf")
    @NotBlank(message = "UF é obrigatório")
    @Length(message="UF com 2 caracteres",max=2)
    String uf;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Client client;

}

