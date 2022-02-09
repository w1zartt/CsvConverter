package org.eagleinvsys.test.converters.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;
import org.eagleinvsys.test.converters.impl.StandardConvertibleCollection;
import org.eagleinvsys.test.converters.impl.StandardConvertibleMessage;

public class TestInstance {
    public static List<Map<String, String>> getListOfMaps() {
        List<Map<String, String>> list = new ArrayList<>();
        list.add(new HashMap<>());
        list.add(new HashMap<>());
        list.add(new HashMap<>());

        list.get(0).put("name", "John");
        list.get(0).put("secondName", "Doe");
        list.get(0).put("age", "20");

        list.get(1).put("name", "Alice");
        list.get(1).put("secondName", "Cooper");
        list.get(1).put("age", "74");

        list.get(2).put("name", "Bob");
        list.get(2).put("secondName", "Dylan");
        list.get(2).put("age", "84");

        return list;
    }

    public static ConvertibleCollection getConvCollection() {
        List<Map<String, String>> list = getListOfMaps();
        List<ConvertibleMessage> records = new ArrayList<>();
        Collection<String> headers = list.get(0).keySet();
        for (Map<String, String> map : list) {
            records.add(new StandardConvertibleMessage(map));
        }
        return new StandardConvertibleCollection(headers, records);
    }
}
