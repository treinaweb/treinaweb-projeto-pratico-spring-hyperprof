package br.com.treinaweb.hyperprof.api.professores.services;

import br.com.treinaweb.hyperprof.api.common.dtos.MessageResponse;
import br.com.treinaweb.hyperprof.api.professores.dtos.FotoRequest;

public interface ProfessorFotoService {

    MessageResponse atualizarFotoProfessorLogado(FotoRequest fotoRequest);

}
