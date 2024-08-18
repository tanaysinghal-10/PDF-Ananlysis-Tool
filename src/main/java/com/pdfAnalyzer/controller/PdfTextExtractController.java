package com.pdfAnalyzer.controller;
import com.pdfAnalyzer.service.PdfTextExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PdfTextExtractController {

    @Autowired
    private PdfTextExtractorService pdfTextExtractorService;

    @PostMapping("/extract-pdf-text")
    @ResponseStatus(HttpStatus.OK)
    public String extractText(@RequestParam("file") MultipartFile file) {
        try {
            // Convert MultipartFile to File
            File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
            file.transferTo(convFile);

            // Extract text from the PDF
            String extractedText = pdfTextExtractorService.extractTextFromPdf(convFile);

            return extractedText;
        } catch (IOException e) {
            return "Failed to extract text: " + e.getMessage();
        }
    }
}