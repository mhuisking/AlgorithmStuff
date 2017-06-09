package org.huisking;

import org.huisking.model.ZipCodeInterval;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileUtils {

    // Quick hack
    static public Function<String, ZipCodeInterval> mapToZipInterval = (line) -> {
        String[] p = line.split(",");
        return new ZipCodeInterval(Integer.parseInt(p[1]), Integer.parseInt(p[2]));
    };

    static public List<ZipCodeInterval> getIntervalListFromResourceFile(String resourceFileName) throws FileNotFoundException {
        File zipFile = new File(FileUtils.class.getClassLoader().getResource(resourceFileName).getFile());
        InputStream inputStream = new FileInputStream(zipFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return bufferedReader.lines().map(mapToZipInterval).collect(Collectors.toList());
    }
}
