package br.com.treinaweb.hyperprof.api.professores.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.treinaweb.hyperprof.api.common.dtos.MessageResponse;
import br.com.treinaweb.hyperprof.api.professores.dtos.FotoRequest;
import br.com.treinaweb.hyperprof.core.models.AuthenticatedUser;
import br.com.treinaweb.hyperprof.core.repositories.ProfessorRepository;
import br.com.treinaweb.hyperprof.core.services.storage.StorageService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorFotoServiceImpl implements ProfessorFotoService {

    private final StorageService storageService;
    private final ProfessorRepository professorRepository;

    @Override
    public MessageResponse atualizarFotoProfessorLogado(FotoRequest fotoRequest) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var professor = ((AuthenticatedUser) authentication.getPrincipal()).getProfessor();
        var foto = storageService.upload(fotoRequest.getFoto());
        professor.setFotoPerfil(foto);
        professorRepository.save(professor);
        return MessageResponse.builder()
            .message("Foto atualizada com sucesso")
            .build();
    }

}
