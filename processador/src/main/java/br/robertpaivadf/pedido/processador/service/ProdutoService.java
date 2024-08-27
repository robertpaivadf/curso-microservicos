package br.robertpaivadf.pedido.processador.service;

import br.robertpaivadf.pedido.processador.entity.ItemPedido;
import br.robertpaivadf.pedido.processador.entity.Produto;
import br.robertpaivadf.pedido.processador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public void save(List<ItemPedido> itens) {
        itens.forEach(iten -> {
            produtoRepository.save(iten.getProduto());
        });
    }
}
