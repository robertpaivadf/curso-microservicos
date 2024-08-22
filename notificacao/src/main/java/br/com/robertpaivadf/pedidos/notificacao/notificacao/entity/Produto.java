package br.com.robertpaivadf.pedidos.notificacao.notificacao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private UUID id = UUID.randomUUID();
    private Double valor;
    private String nome;
}
