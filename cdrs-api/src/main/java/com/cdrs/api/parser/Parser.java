package com.cdrs.api.parser;

import com.cdrs.api.models.CdrsInputFileDetails;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface Parser {

    public List<CdrsInputFileDetails> parse(File file) throws IOException, ParseException;

    public default boolean canHandleFile(File file, String format){
        return (file == null) || (file.getName().endsWith(format));

    }
}