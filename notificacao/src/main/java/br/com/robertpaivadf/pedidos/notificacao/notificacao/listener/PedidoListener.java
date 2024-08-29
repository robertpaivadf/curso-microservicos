package br.com.robertpaivadf.pedidos.notificacao.notificacao.listener;

import br.com.robertpaivadf.pedidos.notificacao.notificacao.entity.Pedido;
import br.com.robertpaivadf.pedidos.notificacao.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {

        logger.info("Tentando consumir a mensagem de notificacao");
        //teste de exception
        if(pedido.getValorTotal() > 2000){
            throw new RuntimeException("Valor muito alto");
        }

        logger.info("Enviando notificacao: {}", pedido.toString());
        emailService.enviarEmail(pedido);
    }
}
