package com.capitalone.dashboard.repository;

import com.mongodb.ServerAddress;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;

import com.capitalone.dashboard.config.MongoConfig;
import com.mongodb.MongoClient;

import java.net.InetSocketAddress;

public class FongoConfig extends MongoConfig {

    @Override
    @Bean
    public MongoClient mongoClient() {
        MongoServer server = new MongoServer(new MemoryBackend());
        InetSocketAddress serverAddress = server.bind();
        return new MongoClient(new ServerAddress(serverAddress));
    }

    @Override
    protected String getDatabaseName() {
        return "test-db";
    }
}
