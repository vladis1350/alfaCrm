package exapmle.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_active")
    private int is_active;

}
