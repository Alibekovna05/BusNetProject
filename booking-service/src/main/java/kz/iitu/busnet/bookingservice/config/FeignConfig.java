package kz.iitu.busnet.bookingservice.config;


import feign.codec.ErrorDecoder;
import kz.iitu.busnet.bookingservice.external.decoder.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}