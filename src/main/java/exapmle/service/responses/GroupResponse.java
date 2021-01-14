package exapmle.service.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import exapmle.models.Customer;
import lombok.Data;

import java.util.List;

@Data
public class GroupResponse {

    @JsonProperty("total")
    private String total;

    @JsonProperty("count")
    private String count;

    @JsonProperty("page")
    private String page;

    @JsonProperty("items")
    private List<Customer> groupList;

}
