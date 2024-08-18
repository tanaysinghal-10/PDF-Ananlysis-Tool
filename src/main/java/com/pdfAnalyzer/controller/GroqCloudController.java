package com.pdfAnalyzer.controller;

import com.pdfAnalyzer.service.GroqCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/groqcloud")
public class GroqCloudController {

    @Autowired
    private GroqCloudService groqCloudService;

    @PostMapping("/invoke")
    public String invokeGroqCloud(@RequestParam String content)
    {
        return groqCloudService.invokeGroqCloudApi(content);
    }


    @GetMapping("/invoke")
    public String invokeGroqCloudApi(@RequestParam String content) {
        // Pass only the content to the service method
        return groqCloudService.invokeGroqCloudApi(content);
    }

}