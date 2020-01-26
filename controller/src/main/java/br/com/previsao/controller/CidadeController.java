package br.com.previsao.controller;

import br.com.previsao.model.dto.CidadeDTO;
import br.com.previsao.model.dto.openweathermap.OpenWeatherMapDTO;
import br.com.previsao.service.CidadeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @ResponseBody
    @ApiOperation(value = "Return an entity")
    @GetMapping(value = "/previsao/{nome}/{codPais}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpenWeatherMapDTO> find(@PathVariable("nome") String nome, @PathVariable("codPais") String codPais) throws Exception {
        return new ResponseEntity<>(this.cidadeService.buscarOpenWeatherMap(nome, codPais), HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation(value = "Return an entity")
    @GetMapping(value = "/previsao/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpenWeatherMapDTO> previsao(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<>(this.cidadeService.previsaoOpenWeatherMap(id), HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation(value = "Save an entity")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeDTO> save(@RequestBody @Valid CidadeDTO dto) throws Exception {
        return new ResponseEntity<>(this.cidadeService.save(dto), HttpStatus.OK);
    }


    @ResponseBody
    @ApiOperation(value = "Delete an entity")
    @DeleteMapping(value = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        this.cidadeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation(value = "Return an entity")
    @GetMapping(value = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeDTO> find(@PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(this.cidadeService.find(id), HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation(value = "Return an list of entity")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CidadeDTO>> findAll() throws Exception {
        return new ResponseEntity<>(this.cidadeService.findAll(), HttpStatus.OK);
    }

}
