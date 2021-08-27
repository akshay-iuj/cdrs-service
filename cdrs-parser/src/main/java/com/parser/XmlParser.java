package com.parser;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.models.CdrsFileDetails;
import com.parser.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlParser extends Parser {

    @Override
    public void parse(File file) throws IOException {
        if ( canHandleFile(file, ".xml")){
            XmlMapper mapper = new XmlMapper();
            MappingIterator<CdrsFileDetails> personIter = mapper.reader(CdrsFileDetails.class).readValues(file);
            List<CdrsFileDetails> people = personIter.readAll();
        }
        else{
            super.parse(file);
        }
    }

}