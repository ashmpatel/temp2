package com.example.testingwebapp.controller;

import com.example.testingwebapp.GridId;
import com.example.testingwebapp.model.SubmtBatchResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
This is a stub controller while DSAAC builds theirs
 */
@Controller
@RequestMapping("v1")
public class DSAACController {

    @PostMapping("/submitgrids")
    public @ResponseBody SubmtBatchResponse submitGrids(@RequestBody GridId gridIds) {
        SubmtBatchResponse test = new SubmtBatchResponse();
        test.setBatchId(10);
        return test;
    }

    @RequestMapping("/health")
    public @ResponseBody String greeting() {
        return "OK";
    }

}
