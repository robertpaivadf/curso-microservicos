package br.robertpaivadf.pedido.processador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="produto")
public class Produto {

    @Id
    private UUID id = UUID.randomUUID();
    private Double valor;
    private String nome;
}
