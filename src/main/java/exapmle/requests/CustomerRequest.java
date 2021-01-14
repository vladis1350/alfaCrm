package exapmle.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_study")
    private int isStudy;

    @JsonProperty("legal_type")
    private int legalType;

    @JsonProperty("branch_ids")
    private List<Integer> branch_ids;

    @JsonProperty("custom_iderip")
    private String custom_iderip;


}
