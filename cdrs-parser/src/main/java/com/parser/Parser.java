package com.parser;

import java.io.File;
import java.io.IOException;

public class Parser {

    private Parser successor;

    public void parse(File file) throws IOException {
        if ( getSuccessor() != null ){
            getSuccessor().parse(file);
        }
        else{
            System.out.println("Unable to find the correct com.parser for the file: "+file);
        }
    }

    protected boolean canHandleFile(File file, String format){
        return (file == null) || (file.getName().endsWith(format));

    }

    Parser getSuccessor() {
        return successor;
    }

    void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}