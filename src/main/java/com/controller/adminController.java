package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpers.MongoDBHelpers;
import com.model.NavbarItem;
import com.model.Page;
import com.model.Settings;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class adminController {

    @Autowired
    MongoDBHelpers mongoDBHelpers;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping({"/admin"})
    public String admin(Model model) throws JsonProcessingException {
        model.addAttribute("users"      ,objectMapper.writeValueAsString(mongoDBHelpers.getUsers()));
        model.addAttribute("pages"      ,objectMapper.writeValueAsString(null));
//        mongoDBHelpers.getPages()
        model.addAttribute("settings"   ,objectMapper.writeValueAsString(null));
//        mongoDBHelpers.getSettings()
        model.addAttribute("navbars"    ,objectMapper.writeValueAsString(null));
//        mongoDBHelpers.getNavbarItem()
        return "admin";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping({"/admin/user"})
    @ResponseBody
    public List<User> adminuser() throws JsonProcessingException {
        return mongoDBHelpers.getUsers();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping({"/admin/pages"})
    @ResponseBody
    public List<Page> adminpages() throws JsonProcessingException {
        return mongoDBHelpers.getPages();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping({"/admin/navbar"})
    @ResponseBody
    public List<NavbarItem> adminnavbar() throws JsonProcessingException {
        return mongoDBHelpers.getNavbarItem();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping({"/admin/settings"})
    @ResponseBody
    public Settings adminsettings() throws JsonProcessingException {
        return mongoDBHelpers.getSettings();
    }
}
