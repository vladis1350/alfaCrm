package exapmle.service;

import exapmle.models.Customer;
import exapmle.models.Lesson;
import exapmle.models.Teacher;
import exapmle.requests.*;
import exapmle.service.responses.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CrmService {
    @Autowired
    private CrmProxy crmProxy;

    private String token;

    private void initialToken() {
        AuthorizationRequest authorizationRequest = new AuthorizationRequest();

        String email = "fvantop@gmail.com";
        authorizationRequest.setEmail(email);
        String apiKey = "9adb45fe-287d-11eb-9333-0cc47a6ca50e";
        authorizationRequest.setApi_key(apiKey);

        SetTokenResponse setTokenResponse = crmProxy.authorization(authorizationRequest);

        if (setTokenResponse.getToken() != null) {
            log.info("Token received: " + setTokenResponse.getToken());
            token = setTokenResponse.getToken();
        } else {
            log.info("Token not received: " + setTokenResponse.getCode());
        }
    }

    public void createCustomer() {
        initialToken();
        if(isToken()) {
            List<Integer> branch_ids = new ArrayList<>();
            branch_ids.add(1);
            CustomerRequest customerRequest = CustomerRequest.builder()
                    .name("Test customer3")
                    .isStudy(0)
                    .legalType(1)
                    .branch_ids(branch_ids)
                    .build();
            String response = crmProxy.createCustomer(token, customerRequest);
            log.info(response);
        }
    }

    public void updateCustomer() {
        initialToken();
        if(isToken()) {
            CustomerRequest customerRequest = CustomerRequest.builder()
                    .custom_iderip("0007702")
                    .legalType(1)
                    .build();
            String response = crmProxy.updateCustomer(token, 7702, customerRequest);
            log.info(response);
        }
    }

    public void addCustomerInGroup() {
        initialToken();
        LocalDate current = LocalDate.now();
        if(isToken()) {
            Customer customerRequest = Customer.builder()
                    .customer_id(7697)
                    .group_id(133)
                    .d_date(current.toString())
                    .build();
            String response = crmProxy.addNewCustomerInGroup(token, 133, customerRequest);
            log.info(response);
        }
    }

    public void deleteCustomerInGroup() {
        initialToken();
        LocalDate current = LocalDate.now();
        if(isToken()) {
            Customer customerRequest = Customer.builder()
                    .customer_id(7697)
                    .group_id(133)
                    .d_date(current.toString())
                    .build();
            String response = crmProxy.deleteNewCustomerInGroup(token, 133, customerRequest);
            log.info(response);
        }
    }

    public void createNewPay() {
        initialToken();
        LocalDateTime current = LocalDateTime.now();

        if(isToken()) {
            PayRequest payRequest = PayRequest.builder()
                    .branch_id(5)
                    .customer_id(7697)
                    .pay_type_id(1)
                    .pay_account_id(1)
                    .pay_item_id(3)
                    .document_date("03.12.2020")
                    .income(1)
                    .payer_name("Test customer")
                    .note("test pay")
                    .is_confirmed(false)
                    .build();
            String response = crmProxy.createNewPay(token, payRequest);
            log.info(response);
        }
    }

    public void getListPay() {
        initialToken();
        if(isToken()) {
            String response = crmProxy.getListPay(token);
            log.info("List Pay: " + response);
        }
    }

    public void createBranch() {
        initialToken();
        if(isToken()) {
            BranchRequest customerRequest = BranchRequest.builder()
                    .name("test one customer")
                    .is_active(1)
                    .build();
            String response = crmProxy.createBranch(token, customerRequest);
            log.info(response);
        }
    }

    public void getLessonType() {
        initialToken();
        if (isToken()) {
            SendLessonTypeRequest sendLessonTypeRequest = SendLessonTypeRequest.builder()
                    .group_id("1")
                    .build();
            LessonTypeResponse str = crmProxy.sendLessonType(token, sendLessonTypeRequest);
            log.info("LessonType response: " + str);
        }
    }

    public void getLesson() {
        initialToken();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String currentDate = formatter.format(localDate);
        String currentDatePlusFiveDays = formatter.format(localDate.plusDays(10));
        if (isToken()) {
            LessonIndexRequest lesson = LessonIndexRequest.builder()
                    .page("0")
                    .date_from(currentDate)
                    .date_to(currentDatePlusFiveDays)
                    .lessonTypeId(2)
                    .status("1").build();
            LessonIndexResponse lessonIndexResponse = crmProxy.sendLesson(token, lesson);
            if (!lessonIndexResponse.getLessonList().isEmpty()) {
                for (Lesson lesson1 : lessonIndexResponse.getLessonList()) {
                    DayOfWeek dayOfWeek = lesson1.getDate().getDayOfWeek();
                    if (lesson1.getStreaming() instanceof List) {
                        log.info(lesson1.toString());
                    } else if (lesson1.getStreaming() instanceof Boolean) {
                        log.info(lesson1.toString());
                    }
                }
            }
        }
    }

    public void getListTeacher() {
        initialToken();
        if (isToken()) {
            TeacherResponse response = crmProxy.getListTeachers(token);
            for (Teacher teacher : response.getTeachers()) {
                log.info(teacher.toString());
            }
        }
    }

    public void getListParticipantGroup() {
        initialToken();
        if (isToken()) {
            GroupResponse response = crmProxy.getListParticipantGroup(token, 133);
            log.info("List participant group 133: " + response);
        }
    }

    public boolean isToken() {
        return this.token != null;
    }

    public void getGroups() {
        initialToken();
        if (isToken()) {
            GroupResponse response = crmProxy.getGroups(token);
            if (!response.getGroupList().isEmpty()) {
                for (Customer customer : response.getGroupList()) {
                    log.info("Group response: " + customer.toString());
                }
            }
        }
    }
}
