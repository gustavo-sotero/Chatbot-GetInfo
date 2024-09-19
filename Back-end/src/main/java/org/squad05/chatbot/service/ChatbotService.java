package org.squad05.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.squad05.chatbot.models.ChatbotProcesso;
import org.squad05.chatbot.repositories.ChatbotRepository;

import java.util.List;

@Service
public class ChatbotService {
    @Autowired
    private ChatbotRepository chatbotRepository;

    //Criar um processo
    public ChatbotProcesso criarProcesso(ChatbotProcesso processo) {
        return chatbotRepository.save(processo);
    }

    //Buscar processo por ID
    public ChatbotProcesso buscarProcessoPorId(Long id) {
        return chatbotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Processo não encontrado"));
    }

    //Atualizar um processo
    public ChatbotProcesso atualizarProcesso(Long id, ChatbotProcesso dadosAtualziados){
        ChatbotProcesso processo = buscarProcessoPorId(id);
        processo.setTipoprocesso(dadosAtualziados.getTipoprocesso());
        processo.setDatasolicitacao(dadosAtualziados.getDatasolicitacao());
        processo.setStatus(dadosAtualziados.getStatus());
        processo.setDescricao(dadosAtualziados.getDescricao());

        return chatbotRepository.save(processo);
    }

    //Deletar um processo
    public void deletarProcesso(Long id) {
        ChatbotProcesso processo = buscarProcessoPorId(id);
        chatbotRepository.delete(processo);
    }

    //Listar todos os processos
    public List<ChatbotProcesso> listarTodosProcessos() {
        return chatbotRepository.findAll();
    }
}