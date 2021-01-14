package exapmle.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lesson {

    @JsonProperty("id")
    private String id;

    @JsonProperty("branch_id")
    private String branch_id;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("time_from")
    private String time_from;

    @JsonProperty("time_to")
    private String time_to;

    @JsonProperty("lesson_type_id")
    private String lesson_type_id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("subject_id")
    private String subject_id;

    @JsonProperty("room_id")
    private String room_id;

    @JsonProperty("streaming")
    private Object streaming;

    @JsonProperty("teacher_ids")
    private List<Integer> teacher_ids;

    @JsonProperty("group_ids")
    private List<Integer> group_ids;

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", branch_id='" + branch_id + '\'' +
                ", date=" + date +
                ", time_from='" + time_from + '\'' +
                ", time_to='" + time_to + '\'' +
                ", lesson_type_id='" + lesson_type_id + '\'' +
                ", status='" + status + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", room_id='" + room_id + '\'' +
                ", streaming=" + streaming +
                ", teacher_ids=" + teacher_ids +
                ", group_ids=" + group_ids +
                '}';
    }
}
