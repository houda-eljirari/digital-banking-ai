package ma.enset.digitalbankingbackend.dtos;

import lombok.*;
import ma.enset.digitalbankingbackend.enums.AccountStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDTO {

    private String type;
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private Long customerId;
    private String customerName;
}