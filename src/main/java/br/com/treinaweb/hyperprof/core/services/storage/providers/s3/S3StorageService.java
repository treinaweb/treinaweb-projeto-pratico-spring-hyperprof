package br.com.treinaweb.hyperprof.core.services.storage.providers.s3;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.com.treinaweb.hyperprof.core.services.storage.StorageService;
import br.com.treinaweb.hyperprof.core.services.storage.StorageServiceException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class S3StorageService implements StorageService {

    private final S3ConfigProperties configProperties;

    @Override
    public String upload(MultipartFile file) {
        try {
            return tryUpload(file);
        } catch (IOException e) {
            throw new StorageServiceException(e.getLocalizedMessage());
        } catch (AmazonClientException e) {
            throw new StorageServiceException(e.getLocalizedMessage());
        }
    }

    private String tryUpload(MultipartFile file) throws IOException {
        var s3Client = createS3Client();
        createBucketIfNotExists(s3Client);
        var putObjectRequest = createPutObjectRequest(file);
        s3Client.putObject(putObjectRequest);
        return s3Client.getUrl(configProperties.getBucketName(), putObjectRequest.getKey()).toString();
    }

    private PutObjectRequest createPutObjectRequest(MultipartFile file) throws IOException {
        return new PutObjectRequest(
            configProperties.getBucketName(),
            String.format("%s-%s", UUID.randomUUID().toString(), file.getOriginalFilename()),
            file.getInputStream(),
            createObjectMetada(file)
        ).withCannedAcl(CannedAccessControlList.PublicRead);
    }

    private ObjectMetadata createObjectMetada(MultipartFile file) {
        var objectMetada = new ObjectMetadata();
        objectMetada.setContentType(file.getContentType());
        return objectMetada;
    }

    private void createBucketIfNotExists(AmazonS3 s3Client) {
        if (!s3Client.doesBucketExistV2(configProperties.getBucketName())) {
            s3Client.createBucket(configProperties.getBucketName());
        }
    }

    private AmazonS3 createS3Client() {
        var s3Credentials = new BasicAWSCredentials(
            configProperties.getAccessKey(),
            configProperties.getSecretKey()
        );
        var s3CredentialsProvider = new AWSStaticCredentialsProvider(s3Credentials);
        return AmazonS3ClientBuilder.standard()
            .withCredentials(s3CredentialsProvider)
            .withRegion(configProperties.getRegion())
            .build();
    }

}
