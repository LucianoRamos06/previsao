package br.com.previsao.model.dto.openweathermap;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherMapDTO {

    String message;
    String cod;
    Integer count;
    List<CityOpenWeatherMapDTO> list = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<CityOpenWeatherMapDTO> getList() {
        return list;
    }

    public void setList(List<CityOpenWeatherMapDTO> list) {
        this.list = list;
    }


}



