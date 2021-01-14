package exapmle.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LessonIndexRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("page")
    private String page;

    @JsonProperty("date_from")
    private String date_from;

    @JsonProperty("date_to")
    private String date_to;

    @JsonProperty("status")
    private String status;

    @JsonProperty("lesson_type_id")
    private int lessonTypeId;

    @JsonProperty("subject_id")
    private int subject_id;

}
