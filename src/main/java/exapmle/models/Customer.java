package exapmle.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @JsonProperty("id")
    private int id;

    @JsonProperty("customer_id")
    private int customer_id;

    @JsonProperty("group_id")
    private int group_id;

    @JsonProperty("d_date")
    private String d_date;

    @JsonProperty("e_date")
    private String e_date;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", group_id=" + group_id +
                ", d_date='" + d_date + '\'' +
                ", e_date='" + e_date + '\'' +
                '}';
    }
}
