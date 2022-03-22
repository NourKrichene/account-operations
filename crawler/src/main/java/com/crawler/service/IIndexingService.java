package com.crawler.service;

import com.crawler.entity.Operation;

public interface IIndexingService {
    void searchOperation();

    void indexOperation(Operation operation);
}