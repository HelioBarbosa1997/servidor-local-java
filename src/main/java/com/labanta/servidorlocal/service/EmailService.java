package com.labanta.servidorlocal.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void enviarEmailBoasVindas(String emailDestino, String nomeUtilizador) {

        //Criar um email simples (texto limpo)
        SimpleMailMessage mensagem = new SimpleMailMessage();

        mensagem.setTo(emailDestino);
        mensagem.setSubject("Bem-vindo ao Marketplace");
        mensagem.setText("Ola " + nomeUtilizador + "!\n\n" + "Ja podes fazer login e explorar os nossos servicos.\n\n" + "Com os melhores comprimentos,\n Equipa do Markerplace");

        //Enviar
        mailSender.send(mensagem);
    }


}
