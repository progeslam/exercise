package com.jumia.exercise.controller;

import com.jumia.exercise.model.Customer;
import com.jumia.exercise.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@Getter
@Setter
public class CountryController {

    private CountryService countryService;

    /**
     *  handle the init request for the home page
     * @return index page
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * handle form submit after choosing an option and calling the proper service according the chosen option
     * @param code request Param
     * @param model Model object
     * @return
     */
    @PostMapping("/")
    public String getCustomers(@RequestParam("code") String code, Model model) {
        model.addAttribute("code", code);
        List<Customer> countryList = null;
        switch (code) {
            case "Select":
                break;
            case "All":
                countryList = countryService.getAllCustomers();
                break;
            case "Invalid":
                countryList = countryService.getInvalidNumbers();
                break;
            default:
                countryList = countryService.getCustomersByCountry(code);
                break;
        }

        model.addAttribute("countryList", countryList);
        return "index";
    }
}
