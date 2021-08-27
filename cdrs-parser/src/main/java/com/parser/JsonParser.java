package com.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.CdrsDbDetails;
import com.models.CdrsFileDetails;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser extends Parser {

    public JsonParser(Parser successor){
        this.setSuccessor(successor);
    }

    @Override
    public void parse(File file) throws IOException {
        if ( canHandleFile(file, ".json")){
            ObjectMapper mapper=new ObjectMapper();
            List<CdrsFileDetails>  example = mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true).readValue(file, new TypeReference<List<CdrsFileDetails>>() {});
        }
        else{
            super.parse(file);
        }

    }

}