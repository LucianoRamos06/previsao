package br.com.previsao.controller.advice;

import br.com.previsao.model.dto.ExceptionDTO;
import br.com.previsao.model.exception.generic.EntityInvalidaException;
import br.com.previsao.model.exception.generic.EntityNaoEncontradaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalHandlerException {

    private static final Logger logger = LoggerFactory.getLogger(GlobalHandlerException.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleTesteException(HttpServletRequest request, MethodArgumentNotValidException ex){
        List<String> messageList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(e -> messageList.add(e.getDefaultMessage()));
        ExceptionDTO dto = contruir(HttpStatus.NOT_ACCEPTABLE, request, messageList);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(dto);
    }

    @ExceptionHandler(EntityInvalidaException.class)
    public ResponseEntity<Object> handleTesteException(HttpServletRequest request, EntityInvalidaException ex){
        List<String> messageList = new ArrayList<>();
        messageList.add(ex.getMessage());
        ExceptionDTO dto = contruir(HttpStatus.BAD_REQUEST, request, messageList);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(EntityNaoEncontradaException.class)
    public ResponseEntity<Object> handleTesteException(HttpServletRequest request, EntityNaoEncontradaException ex){
        List<String> messageList = new ArrayList<>();
        messageList.add(ex.getMessage());
        ExceptionDTO dto = contruir(HttpStatus.NOT_FOUND, request, messageList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleTesteException(HttpServletRequest request, Exception ex){
        List<String> messageList = new ArrayList<>();
        messageList.add("Erro interno do servidor");
        ExceptionDTO dto = contruir(HttpStatus.INTERNAL_SERVER_ERROR, request, messageList);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }

    /**
     * Método que contrói as dto's de exceptions
     * @param status
     * @param request
     * @param messagens
     * @return
     */
    private ExceptionDTO contruir(HttpStatus status, HttpServletRequest request, List<String> messagens) {
        return new ExceptionDTO
                .Builder(status.value())
                .error(status.getReasonPhrase())
                .messages(messagens)
                .path(request.getContextPath() + request.getServletPath())
                .contruir();
    }
}
