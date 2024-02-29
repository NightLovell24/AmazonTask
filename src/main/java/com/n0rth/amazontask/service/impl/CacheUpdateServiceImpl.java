package com.n0rth.amazontask.service.impl;

import com.n0rth.amazontask.service.CacheUpdateService;
import com.n0rth.amazontask.service.InitializationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CacheUpdateServiceImpl implements CacheUpdateService {

    private final InitializationService initializationService;

    @Override
    @Scheduled(fixedRateString = "${spring.scheduled.cache-update-period}")
    @CacheEvict(value = {"salesAndTrafficByAsin", "salesAndTrafficByDate", "users"},
            allEntries = true)
    public void updateCache() {
        log.warn("ATTENTION! CACHE RELOADING");
        initializationService.initializeDatabaseFromJsonFile();
    }
}
