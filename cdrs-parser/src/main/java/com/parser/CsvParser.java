package com.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.models.CdrsFileDetails;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
//import com.fasterxml.jackson.data

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvParser extends Parser {

    public CsvParser(Parser successor){
        this.setSuccessor(successor);
    }

    @Override
    public void parse(File file) throws IOException {
        if ( canHandleFile(file, ".csv")){
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(CdrsFileDetails.class).withSkipFirstDataRow(true).withColumnSeparator('#');
            MappingIterator<CdrsFileDetails> personIter = mapper.reader(CdrsFileDetails.class).with(schema).readValues(file);
            List<CdrsFileDetails> people = personIter.readAll();
        }
        else{
            super.parse(file);
        }
    }

}