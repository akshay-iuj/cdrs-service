package com.cdrs.api.parser;

import com.cdrs.api.models.CdrsInputFileDetails;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvParser implements Parser {

    @Override
    public List<CdrsInputFileDetails> parse(File file) throws IOException {
        if ( canHandleFile(file, ".csv")){
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = mapper.schemaFor(CdrsInputFileDetails.class).withSkipFirstDataRow(true).withColumnSeparator('#');
            MappingIterator<CdrsInputFileDetails> personIter = mapper.reader(CdrsInputFileDetails.class).with(schema).readValues(file);
            return personIter.readAll();
        }

        return null;
    }

}