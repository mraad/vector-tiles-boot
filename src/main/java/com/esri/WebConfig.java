package com.esri;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

/**
 * https://gist.github.com/dVaffection/24b127a6cbeae49fb48b
 */
@Configuration
public class WebConfig
{
    @Bean
    public Filter shallowEtagHeaderFilter()
    {
        return new ShallowEtagHeaderFilter();
    }
}
