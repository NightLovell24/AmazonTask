package com.n0rth.amazontask.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.n0rth.amazontask.model.ReportSpecification;
import com.n0rth.amazontask.model.SalesAndTrafficByAsin;
import com.n0rth.amazontask.model.SalesAndTrafficByDate;
import com.n0rth.amazontask.repository.ReportSpecificationRepository;
import com.n0rth.amazontask.repository.SalesAndTrafficByASINRepository;
import com.n0rth.amazontask.repository.SalesAndTrafficByDateRepository;
import com.n0rth.amazontask.service.InitializationService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class InitializationServiceImpl implements InitializationService {

    private final ReportSpecificationRepository reportSpecificationRepository;
    private final SalesAndTrafficByASINRepository byAsinRepository;
    private final SalesAndTrafficByDateRepository byDateRepository;
    private final ObjectMapper objectMapper;

    @Value("${init.data.file.path}")
    private String filePath;


    @PostConstruct
    public void initializeDatabaseFromJsonFile() {
        try {
            ClassPathResource resource = new ClassPathResource(filePath);
            Map<String, Object> map = objectMapper.readValue(resource.getFile(), new TypeReference<>() {
            });

            ReportSpecification reportSpecification = parseObject(ReportSpecification.class,
                    map);


            SalesAndTrafficByDate[] salesAndTrafficByDates =
                    parseObject(SalesAndTrafficByDate[].class, map);

            SalesAndTrafficByAsin[] salesAndTrafficByAsins =
                    parseObject(SalesAndTrafficByAsin[].class, map);


            reportSpecificationRepository.deleteAll();
            byDateRepository.deleteAll();
            byAsinRepository.deleteAll();


            reportSpecificationRepository.save(reportSpecification);
            byDateRepository.saveAll(Arrays.asList(salesAndTrafficByDates));
            byAsinRepository.saveAll(Arrays.asList(salesAndTrafficByAsins));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> T parseObject(Class<T> aClass, Map<String, Object> map) {
        String key = getKeyFromClassName(aClass);
        Object value = map.get(key);
        return objectMapper.convertValue(value, aClass);
    }

    private String getKeyFromClassName(Class<?> aClass) {
        String className = aClass.getSimpleName().replaceAll("\\[]", "");
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }
}
