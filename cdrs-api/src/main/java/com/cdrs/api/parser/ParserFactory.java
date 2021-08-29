package com.cdrs.api.parser;

public class ParserFactory
{
        public Parser createParser(String fileExtension)
        {
            if (fileExtension == null || fileExtension.isEmpty())
                return null;
            if ("csv".equals(fileExtension)) {
                return new CsvParser();
            }
            else if ("json".equals(fileExtension)) {
                return new JsonParser();
            }
            else if ("xml".equals(fileExtension)) {
                return new XmlParser();
            }
            return null;
        }
}
