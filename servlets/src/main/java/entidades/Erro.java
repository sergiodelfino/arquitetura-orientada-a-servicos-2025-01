package entidades;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Erro {
    private Long status;
    private String mensagem;
    private LocalDateTime horario;
}
