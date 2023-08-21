package com.sample.board.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.uri:}")
    private String uri;

    @Value("${spring.data.mongodb.host:}")
    private String host;

    @Value("${spring.data.mongodb.port:}")
    private int port;

    @Value("${spring.data.mongodb.database:}")
    private String database;

    @Value("${spring.data.mongodb.username:}")
    private String username;

    @Value("${spring.data.mongodb.password:}")
    private String password;

    @Nonnull
    @Override
    protected String getDatabaseName() {
        if (StringUtils.hasText(uri)) {
            return Objects.requireNonNull(new ConnectionString(uri).getDatabase());
        }
        return database;
    }

    @Nonnull
    @Override
    public MongoClient mongoClient() {
        //
        MongoCredential credential = MongoCredential.createCredential(
                username, database, password.toCharArray()
        );

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .retryWrites(true)
                .applyToConnectionPoolSettings(builder -> builder.maxConnectionIdleTime(5000, TimeUnit.MILLISECONDS))
                .applyToClusterSettings(builder -> builder.hosts(List.of(new ServerAddress(host, port))))
                .build();

        return MongoClients.create(settings);
    }

}
