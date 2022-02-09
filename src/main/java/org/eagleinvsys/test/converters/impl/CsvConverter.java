package org.eagleinvsys.test.converters.impl;

import java.io.IOException;
import java.util.Collection;
import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;

import java.io.OutputStream;
import org.eagleinvsys.test.converters.ConvertibleMessage;

public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */

    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
        if (collectionToConvert == null || outputStream == null) {
            throw new IllegalArgumentException("One or more arguments are null");
        }

        Collection<String> headers = collectionToConvert.getHeaders();
        StringBuilder result = new StringBuilder();

        for (String header : headers) {
            result.append(formatToScv(header)).append(",");
        }
        result.deleteCharAt(result.length() - 1);
        result.append("\n");


        for (ConvertibleMessage message : collectionToConvert.getRecords()) {
            for (String s: headers) {
                String element = message.getElement(s);
                result.append(formatToScv(element)).append(",");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("\n");
        }
        try {
            outputStream.write(result.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Output stream is not available");
        }
    }

    private String formatToScv(String value) {
        String result = value;
        if (result.contains("\"") || result.contains(",")
                                  || result.contains(";")
                                  || result.contains("\n")) {

            result = "\"" + result + "\"";
        }
        return result;
    }

}