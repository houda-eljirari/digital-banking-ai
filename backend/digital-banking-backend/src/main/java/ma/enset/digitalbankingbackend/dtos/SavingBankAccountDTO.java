package ma.enset.digitalbankingbackend.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavingBankAccountDTO extends BankAccountDTO {

    private double interestRate;
}