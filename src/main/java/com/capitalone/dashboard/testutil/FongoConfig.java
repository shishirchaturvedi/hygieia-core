package com.capitalone.dashboard.testutil;

import com.capitalone.dashboard.repository.RepositoryPackage;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = RepositoryPackage.class)
public class FongoConfig {

    @Bean(destroyMethod="close")
    public MongoClient mongoClient(MongoServer mongoServer) {
        return new MongoClient(new ServerAddress(mongoServer.getLocalAddress()));
    }

    @Bean(destroyMethod="shutdown")
    public MongoServer mongoServer() {
        MongoServer server = new MongoServer(new MemoryBackend());
        server.bind();
        return server;
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoServer mongoServer) throws Exception {
        return new MongoTemplate(mongoClient(mongoServer), getDatabaseName());
    }
    protected String getDatabaseName() {
        return "test-db";
    }
}
