package com.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.helpers.MongoDBHelpers;
import com.model.ReqRes.ResponseHeader;
import com.model.ReqRes.user.*;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserService {

    @Autowired
    MongoDBHelpers mongoDBHelpers;

    @PutMapping("/")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest){
        CreateUserResponse createUserResponse = new CreateUserResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.createUser(createUserRequest.getUser())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        createUserResponse.setResponseHeader(responseHeader);
        return createUserResponse;
    }

    @GetMapping("/")
    public GetUserResponse getUser(@RequestBody GetUserRequest getUserRequest){
        GetUserResponse getUserResponse = new GetUserResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        try {
            User user = mongoDBHelpers.getUser(getUserRequest.getUserId());
            if(user != null){
                responseHeader.setCode("200");
                responseHeader.setMsg("Success");
                getUserResponse.setUser(user);
            }else {
                responseHeader.setCode("500");
                responseHeader.setMsg("Failed");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        getUserResponse.setResponseHeader(responseHeader);
        return getUserResponse;
    }

    @PostMapping("/")
    public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        UpdateUserResponse updateUserResponse = new UpdateUserResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        if(mongoDBHelpers.updateUser(updateUserRequest.getUser())){
            responseHeader.setCode("200");
            responseHeader.setMsg("Success");
        }else {
            responseHeader.setCode("500");
            responseHeader.setMsg("Failed");
        }

        updateUserResponse.setResponseHeader(responseHeader);
        return updateUserResponse;
    }

    @DeleteMapping("/")
    public DeleteUserResponse deleteUser(@RequestBody DeleteUserRequest deleteUserRequest){
        DeleteUserResponse deleteUserResponse = new DeleteUserResponse();
        ResponseHeader responseHeader = new ResponseHeader();

        return deleteUserResponse;
    }


//    Admin
    @GetMapping("/allUser")
    public List<User> getUsers() throws JsonProcessingException {
        return mongoDBHelpers.getUsers();
    }

}
