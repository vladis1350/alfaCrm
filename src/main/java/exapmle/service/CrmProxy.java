package exapmle.service;

import exapmle.models.Customer;
import exapmle.models.Lesson;
import exapmle.requests.*;
import exapmle.service.responses.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "ALFACRM-PROXY", url = "https://megalife.s20.online/v2api")
public interface CrmProxy {
    @PostMapping("/auth/login")
    public SetTokenResponse authorization(@RequestBody AuthorizationRequest authorizationRequest);

    @PostMapping("/1/lesson-type/index")
    public LessonTypeResponse sendLessonType(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                             SendLessonTypeRequest sendLessonTypeRequest);

    @PostMapping("/1/lesson/index")
    public LessonIndexResponse sendLesson(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                          LessonIndexRequest lessonIndexRequest);

    @PostMapping("/1/group/index")
    public GroupResponse getGroups(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken);

    @PostMapping("/1/cgi/index")
    public GroupResponse getListParticipantGroup(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                                 @RequestParam(name = "group_id") int groupRequest);

    @PostMapping("/teacher/index")
    public TeacherResponse getListTeachers(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken);

    @PostMapping("/1/customer/create")
    public String createCustomer(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken, CustomerRequest cust);

    @PostMapping("/1/customer/update")
    public String updateCustomer(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                 @RequestParam("id") int id, CustomerRequest cust);

    @PostMapping("/branch/create")
    public String createBranch(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken, BranchRequest cust);

    @PostMapping("/1/cgi/create")
    public String addNewCustomerInGroup(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                        @RequestParam(name = "group_id") int groupRequest,
                                        Customer cust);

    @PostMapping("/1/cgi/delete")
    public String deleteNewCustomerInGroup(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken,
                                        @RequestParam(name = "group_id") int groupRequest,
                                        Customer cust);

    @PostMapping("/1/pay/index")
    public String getListPay(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken);

    @PostMapping("/1/pay/create")
    public String createNewPay(@RequestHeader("X-ALFACRM-TOKEN") String authenticationToken, PayRequest payRequest);
}
