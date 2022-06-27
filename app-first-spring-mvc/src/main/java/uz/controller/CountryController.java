package uz.controller;

import uz.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.service.DbcService;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(path = "/country")

public class CountryController {
    @Autowired
    DbcService dbcService;
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getCountryList(Model model) throws SQLException, ClassNotFoundException {
        List<Country> countryList = dbcService.getCountryList();
        model.addAttribute("davlatlar", countryList);
        return "country";
    }
}
