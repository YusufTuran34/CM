package com.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helpers.MongoDBHelpers;
import com.model.Page;
import com.model.ReqRes.ResponseHeader;
import com.model.ReqRes.page.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageService {

    @Autowired
    MongoDBHelpers mongoDBHelpers;

    @PutMapping("/")
    public CreatePageResponse createPage(@RequestBody CreatePageRequest createPageRequest){
        CreatePageResponse createPageResponse = new CreatePageResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.createPage(createPageRequest.getPage())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        createPageResponse.setResponseHeader(responseHeader);
        return createPageResponse;
    }

    @GetMapping("/")
    public GetPageResponse getPage(@RequestBody GetPageRequest getPageRequest){
        GetPageResponse getPageResponse = new GetPageResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        try {
            Page page = mongoDBHelpers.getPage(getPageRequest.getUrl());
            if(page != null){
                responseHeader.setCode("200");
                responseHeader.setMsg("Success");
            }else {
                responseHeader.setCode("500");
                responseHeader.setMsg("Failed");
            }
            getPageResponse.setPage(page);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        getPageResponse.setResponseHeader(responseHeader);
        return getPageResponse;
    }

    @PostMapping("/")
    public UpdatePageResponse updatePage(@RequestBody UpdatePageRequest updatePageRequest){
        UpdatePageResponse updatePageResponse = new UpdatePageResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.updatePage(updatePageRequest.getPage())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        updatePageResponse.setResponseHeader(responseHeader);
        return updatePageResponse;
    }

    @GetMapping("/small")
    public GetPageSmallBlogResponse getPageSmall(GetPageSmallBlogRequest getPageSmallBlogRequest){
        GetPageSmallBlogResponse getPageSmallBlogResponse = new GetPageSmallBlogResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try {
            List<Page> pages = mongoDBHelpers.getPages();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        getPageSmallBlogResponse.setResponseHeader(responseHeader);
        return getPageSmallBlogResponse;
    }


//    Admin
    @GetMapping("/allPage")
    public List<Page> getPage() throws JsonProcessingException {
        return mongoDBHelpers.getPages();
    }
}
