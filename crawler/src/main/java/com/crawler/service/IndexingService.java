package com.crawler.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.crawler.entity.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class IndexingService implements IIndexingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexingService.class);
    private ElasticsearchClient client;

    @Autowired
    public IndexingService(ElasticsearchClient esClient) {
        this.client = esClient;

    }

    @Override
    public void searchOperation() {
        SearchResponse<Operation> search = null;
        try {
            search = client.search(s -> s
                            .index("operations")
                            .query(q -> q
                                    .term(t -> t
                                            .field("label")
                                            .value(v -> v.stringValue("test"))
                                    )),
                    Operation.class);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Can not search for operation " + e.getMessage());
        }
        System.out.println("length : " + search.hits().hits().size());
        for (Hit<Operation> hit : search.hits().hits()) {
            System.out.println(hit.source());
        }
    }

    @Override
    public void indexOperation(Operation operation) {

        IndexRequest<Operation> req;

        req = IndexRequest.of(b -> b
                .index("operations")
                .document(operation)
        );
        try {
            IndexResponse response = client.index(req);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
