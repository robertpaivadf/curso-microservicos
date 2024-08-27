package br.robertpaivadf.pedido.processador.service;

import br.robertpaivadf.pedido.processador.entity.ItemPedido;
import br.robertpaivadf.pedido.processador.entity.Pedido;
import br.robertpaivadf.pedido.processador.repository.PedidoRepository;
import br.robertpaivadf.pedido.processador.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoService  itemPedidoService;

    public void save(Pedido pedido) {
        //salvamos os produtos
        produtoService.save(pedido.getItens());

        //salvamos os itens do pedido
        List<ItemPedido> itemPedidoList = itemPedidoService.save(pedido.getItens());

        //salvamos o pedido
        pedidoRepository.save(pedido);

        //atualiza o item pedido definindo o pedido ao qual ele faz parte
        itemPedidoService.updatedItemPedido(itemPedidoList, pedido);

        logger.info("Pedido salvo com sucesso: {}", pedido.toString());
    }
}
