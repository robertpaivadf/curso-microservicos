package br.com.robertpaivadf.pedidos.api.service;

import br.com.robertpaivadf.pedidos.api.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

//    private final RabbitTemplate rabbitTemplate;
//
//    public PedidoService(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Pedido enfileirarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(exchangeName, "", pedido);
        logger.info("Pedido enfileirado:{}", pedido.toString());
        return pedido;
    }

}
