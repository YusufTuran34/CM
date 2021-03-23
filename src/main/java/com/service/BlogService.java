package com.service;

import com.helpers.MongoDBHelpers;
import com.model.Blog;
import com.model.ReqRes.ResponseHeader;
import com.model.ReqRes.blog.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogService {

    @Autowired
    MongoDBHelpers mongoDBHelpers;

    @PutMapping("/")
    public CreateBlogResponse createBlog(@RequestBody CreateBlogRequest createBlogRequest){
        CreateBlogResponse createBlogResponse = new CreateBlogResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.createBlog(createBlogRequest.getBlog(),createBlogRequest.getCategoryUrl())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        createBlogResponse.setResponseHeader(responseHeader);
        return createBlogResponse;
    }

    @GetMapping("/")
    public GetBlogResponse getBlog(@RequestBody GetBlogRequest getBlogRequest){
        GetBlogResponse getBlogResponse = new GetBlogResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        Blog blog = mongoDBHelpers.getBlog(getBlogRequest.getBlogUrl(), getBlogRequest.getContentUrl());
        if(blog != null){
            getBlogResponse.setBlog(blog);
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        getBlogResponse.setResponseHeader(responseHeader);
        return getBlogResponse;
    }

    @PostMapping("/")
    public UpdateBlogResponse updateBlog(@RequestBody UpdateBlogRequest updateBlogRequest){
        UpdateBlogResponse updateBlogResponse = new UpdateBlogResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if(mongoDBHelpers.updateBlog(updateBlogRequest.getBlog(),updateBlogRequest.getCategoryUrl())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }
        updateBlogResponse.setResponseHeader(responseHeader);
        return updateBlogResponse;
    }

    @DeleteMapping("/")
    public DeleteBlogResponse deleteBlog(@RequestBody DeleteBlogRequest deleteBlogRequest){
        DeleteBlogResponse deleteBlogResponse = new DeleteBlogResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        return deleteBlogResponse;
    }
}
