package com.n0rth.amazontask.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class ResourceLoaderConfig {

    @Value("${init.data.file.path}")
    private String resourceUrl;

    @Bean
    public ResourceLoader resourceLoader() {
        return new DefaultResourceLoader(getClassLoader());
    }

    private ClassLoader getClassLoader() {
        return this.getClass().getClassLoader();
    }

    @Bean
    public Resource resource() {
        return resourceLoader().getResource(resourceUrl);
    }
}

