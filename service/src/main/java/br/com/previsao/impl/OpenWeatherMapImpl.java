package br.com.previsao.impl;

import br.com.previsao.model.dto.openweathermap.OpenWeatherMapDTO;
import br.com.previsao.model.generic.GenericRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapImpl {

    private final String URL_CITY = "http://openweathermap.org/data/2.5/find?q=$c,$p&appid=b6907d289e10d714a6e88b30761fae22";
    private final String URL_FORECAST = "http://openweathermap.org/data/2.5/forecast?id=$i&appid=b6907d289e10d714a6e88b30761fae22";

    private GenericRequest<OpenWeatherMapDTO> request = new GenericRequest<>();

    public OpenWeatherMapDTO buscarCidades(String cidade, String codPais) {
        String url = URL_CITY.replace("$c", cidade).replace("$p", codPais);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return request.get(url, headers, OpenWeatherMapDTO.class).getBody();
    }

    public OpenWeatherMapDTO privisaoDetalhada(String id) {
        String url = URL_FORECAST.replace("$i", id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return request.get(url, headers, OpenWeatherMapDTO.class).getBody();
    }
}
