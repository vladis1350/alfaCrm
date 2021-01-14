package exapmle.service.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import exapmle.models.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class TeacherResponse {

    @JsonProperty("total")
    private String total;

    @JsonProperty("count")
    private String count;

    @JsonProperty("page")
    private String page;

    @JsonProperty("items")
    private List<Teacher> teachers;



}
