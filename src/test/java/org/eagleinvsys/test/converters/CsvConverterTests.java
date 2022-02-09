package org.eagleinvsys.test.converters;

import static org.eagleinvsys.test.converters.util.TestInstance.getConvCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.junit.jupiter.api.Test;

class CsvConverterTests {
    CsvConverter converter = new CsvConverter();

    @Test
    void testConvert_OneOfArgumentsIsNull_throwException() {
        ConvertibleCollection collection = getConvCollection();
        assertThrows(IllegalArgumentException.class,() ->converter.convert(collection,
                                                                                  null));
    }

    @Test
    void testConvert_ConvertIsSuccessful() {
        ConvertibleCollection collection = getConvCollection();
        String expectedString = "name,age,secondName\n" +
                                "John,20,Doe\n" +
                                "Alice,74,Cooper\n" +
                                "Bob,84,Dylan\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        converter.convert(collection, outputStream);
        assertEquals(expectedString, outputStream.toString());
    }

    @Test
    void testConvert_OutputStreamIsNotAvailable_ThrowException() throws IOException {
        ConvertibleCollection collection = getConvCollection();
        FileOutputStream outputStream = new FileOutputStream("test-result");
        outputStream.close();
        assertThrows(IllegalArgumentException.class,() -> converter.convert(collection,
                                                                           outputStream));
    }

    // TODO: implement JUnit 5 tests for CsvConverter

}