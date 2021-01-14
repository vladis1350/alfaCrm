package exapmle.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayRequest {

    @JsonProperty("branch_id")
    private int branch_id;
    @JsonProperty("customer_id")
    private int customer_id;
    @JsonProperty("pay_type_id")
    private int pay_type_id;
    @JsonProperty("pay_account_id")
    private int pay_account_id;
    @JsonProperty("pay_item_id")
    private int pay_item_id;
    @JsonProperty("document_date")
    private String document_date;
    @JsonProperty("income")
    private int income;
    @JsonProperty("payer_name")
    private String payer_name;
    @JsonProperty("note")
    private String note;
    @JsonProperty("is_confirmed")
    private boolean is_confirmed;
}
