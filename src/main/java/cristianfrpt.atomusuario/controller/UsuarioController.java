package cristianfrpt.atomusuario.controller;

import cristianfrpt.atomusuario.domain.ValidaCpfResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@Slf4j
@RestController
@Validated
public class UsuarioController {

    @Value("${porcentagem.bloqueio.cpf}")
    private Integer porcentagemBloqueio;

    @GetMapping(value = "/users/{cpf}")
    @ResponseBody
    public ResponseEntity<?> validaCpf(@PathVariable String cpf){
        Random random = new Random();
        ValidaCpfResponse response = new ValidaCpfResponse();

        int randomNumber = random.nextInt(100);

        if(randomNumber < porcentagemBloqueio){
            response.setStatus("UNABLE_TO_VOTE");
        }else{
            response.setStatus("ABLE_TO_VOTE");
        }

        return  ResponseEntity.ok(response);
    }

}
