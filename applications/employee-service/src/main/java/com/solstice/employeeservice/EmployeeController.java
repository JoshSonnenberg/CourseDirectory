package com.solstice.employeeservice;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;
    private EmployeePresenter employeePresenter;
    private EurekaClient discoveryClient;
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeController(EurekaClient discoveryClient, EmployeePresenter employeePresenter, EmployeeRepository employeeRepository) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = new RestTemplate();
        this.employeePresenter = employeePresenter;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String greeting() {
        return "Employee Service";
    }

    @GetMapping("/course/{tag}")
    public List<EmployeeInfo> employeesByCourseTag(@PathVariable("tag") String tag) {

        List<String> employeeIds = Arrays.asList(restTemplate.getForObject(fetchCourseServiceUrl() + tag, String[].class));

        if (employeeIds.size() == 0) {
            return null;
        }

        return employeeRepository.getEmployeesByIds(employeeIds)
                .stream()
                .map(employeePresenter::present)
                .collect(toList());
    }

    private String fetchCourseServiceUrl() {
        discoveryClient.getAllKnownRegions();
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("Course-Service", false);
        String courseServiceUrl = instance.getHomePageUrl() + "courses/employeeId/tag/";

        return courseServiceUrl;
    }

}
