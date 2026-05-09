package ma.enset.digitalbankingbackend.dtos;

import lombok.*;
import ma.enset.digitalbankingbackend.enums.OperationType;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountOperationDTO {

    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}