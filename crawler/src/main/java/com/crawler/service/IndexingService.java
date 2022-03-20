package com.crawler.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.crawler.entity.Operation;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;


@Service
public class IndexingService implements IIndexingService {
    // Create the low-level client
    RestClient restClient = RestClient.builder(
            new HttpHost("localhost", 9200)).build();

    // Create the transport with a Jackson mapper
    ElasticsearchTransport transport = new RestClientTransport(
            restClient,new JacksonJsonpMapper());

    // And create the API client
    ElasticsearchClient client = new ElasticsearchClient(transport);


    @Override
    public void serachOperation() {

        SearchResponse<Operation> search =null;
        try {
            search = client.search(s -> s
                            .index("operations")
                            .query(q -> q
                                    .term(t -> t
                                            .field("amount")
                                            .value(v -> v.stringValue("label"))
                                    )),
                    Operation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Hit<Operation> hit : search.hits().hits()) {
            System.out.println(hit.source());
        }
    }

    @Override
    public void saveOperation() {
        IndexRequest<Operation> req;

        req = IndexRequest.of(b -> b
                .index("operations")
                .document(new Operation(2010L, new BigDecimal(20.5), "Buy a chair", new Date(), 3001L, 3002L))
        );
        try {
            IndexResponse response = client.index(req);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
