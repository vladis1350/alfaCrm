package exapmle.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("bob")
    private String bob;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("note")
    private String note;

    @JsonProperty("phone")
    private List<String> phone;

}
