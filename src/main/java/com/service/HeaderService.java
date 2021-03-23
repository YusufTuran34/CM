package com.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helpers.MongoDBHelpers;
import com.model.NavbarItem;
import com.model.ReqRes.ResponseHeader;
import com.model.ReqRes.header.*;
import com.model.ReqRes.settings.GetSettingsRequest;
import com.model.ReqRes.settings.GetSettingsResponse;
import com.model.ReqRes.settings.UpdateSettingsRequest;
import com.model.ReqRes.settings.UpdateSettingsResponse;
import com.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/header")
public class HeaderService {

    @Autowired
    MongoDBHelpers mongoDBHelpers;

    @GetMapping("/")
    public GetHeaderResponse getHeader(@RequestBody GetHeaderRequest getHeaderRequest){
        GetHeaderResponse getHeaderResponse = new GetHeaderResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            Settings settings = mongoDBHelpers.getSettings();
            List<NavbarItem> navbarItems = mongoDBHelpers.getNavbarItem();

            getHeaderResponse.setNavbarItemList(navbarItems);
            getHeaderResponse.setSeo(settings.getSeo());

            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        getHeaderResponse.setResponseHeader(responseHeader);
        return getHeaderResponse;
    }

    @PostMapping("/")
    public UpdateNavbarItemResponse updateNavbarItem(@RequestBody UpdateNavbarItemRequest updateNavbarItemRequest){
        UpdateNavbarItemResponse updateNavbarItemResponse = new UpdateNavbarItemResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if(mongoDBHelpers.updateNavbar(updateNavbarItemRequest.getNavbarItem())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        updateNavbarItemResponse.setResponseHeader(responseHeader);
        return updateNavbarItemResponse;
    }

    @PutMapping("/")
    public CreateNavbarItemResponse createNavbarItem(@RequestBody CreateNavbarItemRequest createNavbarItemRequest){
        CreateNavbarItemResponse createNavbarItemResponse = new CreateNavbarItemResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if(mongoDBHelpers.createNavbar(createNavbarItemRequest.getNavbarItem())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        createNavbarItemResponse.setResponseHeader(responseHeader);
        return createNavbarItemResponse;
    }

    @DeleteMapping("/")
    public DeleteNavbarItemResponse deleteNavbarItem(@RequestBody DeleteNavbarItemRequest deleteNavbarItemRequest){
        DeleteNavbarItemResponse deleteNavbarItemResponse = new DeleteNavbarItemResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if(true){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        deleteNavbarItemResponse.setResponseHeader(responseHeader);
        return deleteNavbarItemResponse;
    }

}
