package br.com.robertpaivadf.pedidos.notificacao.notificacao.service;

import br.com.robertpaivadf.pedidos.notificacao.notificacao.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

//    private final JavaMailSender mailSender;
//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("pedidos-api@company.com");
        simpleMailMessage.setTo(pedido.getEmailNotificacao());
        simpleMailMessage.setSubject("Pedido de compra");
        simpleMailMessage.setText(this.gerarMensagem(pedido));
        mailSender.send(simpleMailMessage);
    }

    private String gerarMensagem(Pedido pedido) {
        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = String.valueOf(pedido.getValorTotal());
        String status = pedido.getStatus().name();
        return String.format("Olá %s seu pedido de nº %s no valor de %s, foi realizado com sucesso.  \nStatus: %s.",cliente, pedidoId, valor,status);
    }
}
