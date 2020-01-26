package br.com.previsao.configuration;

import com.google.common.base.Predicates;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public JettyServletWebServerFactory embeddedServletContainerFactory() {
        return new JettyServletWebServerFactory();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) //
                .useDefaultResponseMessages(false) //
                .globalResponseMessage(RequestMethod.GET, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.HEAD, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.POST, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.PUT, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.PATCH, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.DELETE, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.OPTIONS, getResponseMessages()) //
                .globalResponseMessage(RequestMethod.TRACE, getResponseMessages()) //
                .select() //
                .apis(Predicates.or(RequestHandlerSelectors.basePackage("br.com.previsao"))) //
                .paths(PathSelectors.any()) //
                .build().apiInfo(getApiInfo());
    }

    private List<ResponseMessage> getResponseMessages() {
        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder().code(HttpStatus.NOT_FOUND.value()).message(HttpStatus.NOT_FOUND.getReasonPhrase()).responseModel(new ModelRef("ExceptionDTO")).build());
        responseMessages.add(new ResponseMessageBuilder().code(HttpStatus.BAD_REQUEST.value()).message(HttpStatus.BAD_REQUEST.getReasonPhrase()).responseModel(new ModelRef("ExceptionDTO")).build());
        responseMessages.add(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).responseModel(new ModelRef("ExceptionDTO")).build());

        return responseMessages;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Previsão do Tempo API", //
                "Aplicativo de Previsaõ do tempo.", //
                "1.0", //
                "http://www.previsao.com/", //
                new Contact("Previsão do Tempo SA", //
                        "http://www.previsao.com/", //
                        "previsao@gmail.com"), //
                "License of API", //
                "" //
                , Collections.emptyList());
    }
}
