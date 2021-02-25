package com.easy.archetype.framework.file.server.storagestrategy;

import cn.hutool.core.lang.Assert;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.util.IOUtils;
import com.easy.archetype.framework.file.server.FileServerProperties;
import com.easy.archetype.framework.file.server.IFileStorageStrategy;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * minno文件存储
 *
 * @author luyanan
 * @since 2021/2/23
 **/
@RequiredArgsConstructor
public class MinioFileStorageStrategy implements IFileStorageStrategy, InitializingBean {

	private final FileServerProperties fileServerProperties;

	private AmazonS3 amazonS3;

	private FileServerProperties.Oss oss;


	@SneakyThrows
	@Override
	public String upload(String path, String fileName, InputStream is) {
		String objectName = (path + "/" + fileName).replace("/+", "/");
		byte[] bytes = IOUtils.toByteArray(is);
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength((long) is.available());
		objectMetadata.setContentType("application/octet-stream");
		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes)) {
			PutObjectResult putObjectResult = amazonS3.putObject(oss.getBucketName(), objectName, byteArrayInputStream, objectMetadata);
		}
		return objectName;
	}

	@Override
	public boolean removeFile(String path) {
		amazonS3.deleteObject(oss.getBucketName(), path);
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		oss = fileServerProperties.getOss();

		Assert.notNull(oss, "oss配置不能为空");
		ClientConfiguration clientConfiguration = new ClientConfiguration();
		// 设置最大线程数
		clientConfiguration.setMaxConnections(100);
		AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(oss.getEndpoint(), oss.getRegion());

		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(oss.getAccessKey(), oss.getSecretKey());
		AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);
		this.amazonS3 = AmazonS3Client.builder().withEndpointConfiguration(endpointConfiguration)
				.withClientConfiguration(clientConfiguration).withCredentials(awsCredentialsProvider)
				.disableChunkedEncoding()

				/**
				 * true path-style nginx 反向代理和S3默认支持 pathStyle {http://endpoint/bucketname} false
				 * supports virtual-hosted-style 阿里云等需要配置为 virtual-hosted-style
				 * 模式{http://bucketname.endpoint}
				 */
				.withPathStyleAccessEnabled(Boolean.TRUE).build();
	}
}
