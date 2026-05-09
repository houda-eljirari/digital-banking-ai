package ma.enset.digitalbankingbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.digitalbankingbackend.enums.OperationType;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AccountOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date operationDate;

    private double amount;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    private String description;

    @ManyToOne
    private BankAccount bankAccount;
}