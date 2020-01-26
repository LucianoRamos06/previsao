package br.com.previsao.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExceptionDTO {

    private LocalDateTime timeStamp = LocalDateTime.now();
    private Integer status;
    private String error;
    private List<String> messages = new ArrayList<>();
    private String path;

    public static class Builder {

        private Integer status;
        private String error;
        private List<String> messages = new ArrayList<>();
        private String path;

        public Builder(Integer status) {
            this.status = status;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder messages(List<String> messages) {
            this.messages = messages;
            return this;
        }

        public Builder message(String message) {
            this.messages.add(message);
            return this;
        }


        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public ExceptionDTO contruir() {
            return new ExceptionDTO(this.status, this.error, this.messages, this.path);
        }

    }

    private ExceptionDTO(Integer status, String error, List<String> messages, String path) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.messages = messages;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getPath() {
        return path;
    }
}
