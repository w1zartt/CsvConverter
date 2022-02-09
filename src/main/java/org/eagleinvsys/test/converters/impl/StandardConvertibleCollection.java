package org.eagleinvsys.test.converters.impl;

import java.util.Collection;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

public class StandardConvertibleCollection implements ConvertibleCollection {

    private final Collection<String> headers;
    private final Iterable<ConvertibleMessage> records;

    public StandardConvertibleCollection(Collection<String> headers,
                                         Iterable<ConvertibleMessage> records) {
        this.headers = headers;
        this.records = records;
    }

    @Override
    public Collection<String> getHeaders() {
        return headers;
    }

    @Override
    public Iterable<ConvertibleMessage> getRecords() {
        return records;
    }
}
