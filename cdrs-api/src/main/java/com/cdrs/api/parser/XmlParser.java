package com.cdrs.api.parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.cdrs.api.models.CdrsInputFileDetails;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class XmlParser implements Parser {



    @Override
    public List<CdrsInputFileDetails> parse(File file) throws IOException, ParseException {
        if ( canHandleFile(file, ".xml")){
            XmlMapper mapper = new XmlMapper();
            MappingIterator<CdrsInputFileDetails> personIter = mapper.reader(CdrsInputFileDetails.class).readValues(file);
            return personIter.readAll();
        }

        return null;
    }

}