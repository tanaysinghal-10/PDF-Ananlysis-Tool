package com.pdfAnalyzer.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PdfTextExtractorService {

    public String extractTextFromPdf(File file) throws IOException {
        // Load the PDF document
        try (PDDocument document = PDDocument.load(file)) {
            // Create a PDFTextStripper object to extract text
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Extract the text and return it
            return pdfStripper.getText(document);
        }
    }
}