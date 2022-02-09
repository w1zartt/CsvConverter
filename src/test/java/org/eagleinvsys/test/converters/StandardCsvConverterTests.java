package org.eagleinvsys.test.converters;

import static org.eagleinvsys.test.converters.util.TestInstance.getConvCollection;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.StandardCsvConverter;
import org.eagleinvsys.test.converters.util.TestInstance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StandardCsvConverterTests {
    CsvConverter spyConverter = Mockito.spy(new CsvConverter());
    StandardCsvConverter converter = new StandardCsvConverter(spyConverter);

    @Test
    void testConvert_ConvertIsSuccessful() {
        List<Map<String, String>> listOfMaps = TestInstance.getListOfMaps();
        String expectedString = "name,age,secondName\n" +
                                "John,20,Doe\n" +
                                "Alice,74,Cooper\n" +
                                "Bob,84,Dylan\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        converter.convert(listOfMaps, outputStream);

        Mockito.verify(spyConverter).convert(Mockito.any(ConvertibleCollection.class),
                                             Mockito.any(OutputStream.class));

        Assertions.assertEquals(expectedString, outputStream.toString());
    }

    @Test
    void testConvert_OutputStreamIsNotAvailable_ThrowException() throws IOException {
        List<Map<String, String>> listOfMaps = TestInstance.getListOfMaps();
        FileOutputStream outputStream = new FileOutputStream("test-result");
        outputStream.close();
        assertThrows(IllegalArgumentException.class,() -> converter.convert(listOfMaps,
                                                                            outputStream));
    }


    // TODO: implement JUnit 5 tests for StandardCsvConverter

}