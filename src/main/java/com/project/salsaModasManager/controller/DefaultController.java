package com.project.salsaModasManager.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager")
public class DefaultController {
    @ApiOperation(value = "Return an example hello")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "success return method")
    })
    @GetMapping
    public String hello(){
        return "Hello";
    }
}
