package com.pdfAnalyzer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;

@Service
public class PdfAnalyzerService {

    @Autowired
    private PdfTextExtractorService pdfTextExtractorService;

    @Autowired
    private GroqCloudService groqCloudService;

    private static final String ANALYZE = "Give the analysis and summary of text below";


    public String getAnalysis(File file) throws IOException {


        // Extract text from the PDF
        String extractTextFromPdf = pdfTextExtractorService.extractTextFromPdf(file);

        // For Prompt
        String content = ANALYZE + "\n" + extractTextFromPdf;

        return groqCloudService.invokeGroqCloudApi(content);

    }

}
