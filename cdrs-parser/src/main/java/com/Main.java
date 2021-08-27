package com;

import java.io.File;
import java.io.IOException;

import com.parser.CsvParser;
import com.parser.JsonParser;
import com.parser.Parser;
import com.parser.XmlParser;

public class Main {

    public static void main(String args[]) throws IOException {
        String path = "cdrs-parser/src/main/CDRsRepository";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        //No successor for this handler because this is the last in chain.
        Parser xmlParser = new XmlParser();

        //com.parser.XmlParser is the successor of com.parser.CsvParser.
        Parser csvParser = new CsvParser(xmlParser);

        //com.parser.CsvParser is the successor of com.parser.JsonParser.
        //com.parser.JsonParser is the start of the chain.
        Parser jsonParser = new JsonParser(csvParser);

        //Pass the file name to the first handler in the chain.
        for ( File file : listOfFiles){
            jsonParser.parse(file);
        }


    }

}
