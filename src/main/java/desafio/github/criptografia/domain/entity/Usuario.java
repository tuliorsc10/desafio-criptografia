package desafio.github.criptografia.domain.entity;

import desafio.github.criptografia.components.UserCrypto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UserDocument")
    @Convert(converter = UserCrypto.class)
    private String document;

    @Column(name = "CreditCardToken")
    @Convert(converter = UserCrypto.class)
    private String card;

    @Column(name = "valor")
    private long valor;
}
