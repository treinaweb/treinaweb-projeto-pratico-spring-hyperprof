package br.com.treinaweb.hyperprof.core.services.storage.providers.s3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "br.com.treinaweb.hyperprof.core.services.storage.s3")
public class S3ConfigProperties {

    private String accessKey;
    private String secretKey;
    private String bucketName;
    private Regions region;

}
