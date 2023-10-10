package org.example;

import java.io.IOException;
import java.io.Serializable;

public interface ILofIO<T>  extends Serializable, AutoCloseable {

    public <T> void writeObjectToFile(T object, String filePath)throws IOException;
    public <T> T readObjectFromFile(String filePath)throws IOException,ClassNotFoundException;
}
