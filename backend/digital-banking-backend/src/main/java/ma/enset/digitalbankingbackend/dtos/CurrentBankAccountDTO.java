package ma.enset.digitalbankingbackend.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentBankAccountDTO extends BankAccountDTO {

    private double overDraft;
}