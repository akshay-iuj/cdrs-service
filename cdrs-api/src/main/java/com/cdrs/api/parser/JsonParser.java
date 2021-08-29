package com.cdrs.api.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cdrs.api.models.CdrsInputFileDetails;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class JsonParser implements Parser {


    @Override
    public List<CdrsInputFileDetails> parse(File file) throws IOException, ParseException {
        if ( canHandleFile(file, ".json")){
            ObjectMapper mapper=new ObjectMapper();
            return mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true).readValue(file, new TypeReference<List<CdrsInputFileDetails>>() {});
        }
        return null;
    }

}