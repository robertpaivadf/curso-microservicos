package br.robertpaivadf.pedido.processador.listener;

import br.robertpaivadf.pedido.processador.entity.Pedido;
import br.robertpaivadf.pedido.processador.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(Pedido pedido) {
        pedido.setStatus(Status.PROCESSADO);
        logger.info("Salvando pedido: {}", pedido.toString());

    }
}
