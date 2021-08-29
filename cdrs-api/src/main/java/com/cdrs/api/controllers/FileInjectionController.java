package com.cdrs.api.controllers;

import com.cdrs.api.models.CdrsDbDetails;
import com.cdrs.api.parser.*;
import com.cdrs.api.payload.response.MessageResponse;
import com.cdrs.api.repository.CalculatorRepository;
import com.cdrs.api.repository.CdrsRepository;
import com.cdrs.api.utils.CdrsFileToDbConverter;
import com.cdrs.api.utils.CdrsOutputGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/fileUpload")
public class FileInjectionController {


    @Autowired
    CdrsRepository cdrsRepository;
    @Autowired
    CalculatorRepository calculatorRepository;

    @Value("${path.InputPath}")
    private String inputPath;

    @Value("${path.OutputPath}")
    private String outputPath;

    @GetMapping("/processFile")
    public ResponseEntity<?> processFile() throws IOException, ParseException {
        File[] listOfFiles = new File(inputPath).listFiles();
        ParserFactory parserFactory = new ParserFactory();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File outputFile=new File(outputPath);
        for ( File file : listOfFiles){
            Parser notification = parserFactory.createParser(Files.getFileExtension(file.getName()));
            List<CdrsDbDetails> dbDetails= CdrsFileToDbConverter.mapper(notification.parse(file),file.getName(),calculatorRepository.findAll());
            cdrsRepository.save(dbDetails);
        }
        try {
            writer.writeValue(outputFile, CdrsOutputGenerator.fileGenerator(cdrsRepository.findAll()));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok(ex.getMessage());
        }
        return ResponseEntity.ok(new MessageResponse("Files Uploaded successfully and output file generated."));

    }
}
