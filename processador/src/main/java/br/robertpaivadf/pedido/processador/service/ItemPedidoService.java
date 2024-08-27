package br.robertpaivadf.pedido.processador.service;

import br.robertpaivadf.pedido.processador.entity.ItemPedido;
import br.robertpaivadf.pedido.processador.entity.Pedido;
import br.robertpaivadf.pedido.processador.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public List<ItemPedido> save(List<ItemPedido> itens) {
        return itemPedidoRepository.saveAll(itens);
    }

    public void save(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidoList, Pedido pedido) {
        itemPedidoList.forEach(itemPedido -> {
            itemPedido.setPedido(pedido); //informando ao item o seu pedido
            this.save(itemPedido);
        });
    }
}
