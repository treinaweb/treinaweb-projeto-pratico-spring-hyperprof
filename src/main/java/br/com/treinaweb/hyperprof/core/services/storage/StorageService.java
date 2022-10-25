package br.com.treinaweb.hyperprof.core.services.storage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String upload(MultipartFile file);

}
