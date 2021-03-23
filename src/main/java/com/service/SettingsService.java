package com.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helpers.MongoDBHelpers;
import com.model.ReqRes.ResponseHeader;
import com.model.ReqRes.settings.*;
import com.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settings")
public class SettingsService {

    @Autowired
    MongoDBHelpers mongoDBHelpers;

    @GetMapping("/")
    public GetSettingsResponse getSettings(@RequestBody GetSettingsRequest getSettingsRequest){
        GetSettingsResponse getSettingsResponse = new GetSettingsResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        try {
            Settings settings = mongoDBHelpers.getSettings();
            getSettingsResponse.setSettings(settings);
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        getSettingsResponse.setResponseHeader(responseHeader);
        return getSettingsResponse;
    }

    @PostMapping("/")
    public UpdateSettingsResponse updateSettings(@RequestBody UpdateSettingsRequest updateSettingsRequest){
        UpdateSettingsResponse updateSettingsResponse = new UpdateSettingsResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.updateSettings(updateSettingsRequest.getSettings())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        updateSettingsResponse.setResponseHeader(responseHeader);
        return updateSettingsResponse;
    }
    
    @PutMapping("/")
    public CreateSettingsResponse createSettings(@RequestBody CreateSettingsRequest CreateSettingsRequest){
        CreateSettingsResponse CreateSettingsResponse = new CreateSettingsResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.createSettings(CreateSettingsRequest.getSettings())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        CreateSettingsResponse.setResponseHeader(responseHeader);
        return CreateSettingsResponse;
    }
}
