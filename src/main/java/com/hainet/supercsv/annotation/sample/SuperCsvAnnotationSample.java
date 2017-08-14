package com.hainet.supercsv.annotation.sample;

import com.github.mygreen.supercsv.io.CsvAnnotationBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SuperCsvAnnotationSample {

    public static void main(String[] args) {
        try (CsvAnnotationBeanReader<Person> csvReader = new CsvAnnotationBeanReader<>(
                Person.class,
                Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("person.csv").toURI()), Charset.forName("UTF-8")),
                CsvPreference.STANDARD_PREFERENCE
        )) {
            for (Person person : csvReader.readAll()) {
                System.out.println(person);
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try (CsvAnnotationBeanReader<Person> csvReader = new CsvAnnotationBeanReader<>(
                Person.class,
                Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("person.csv").toURI()), Charset.forName("UTF-8")),
                CsvPreference.STANDARD_PREFERENCE
        )) {
            String[] headers = csvReader.getHeader(true);

            ArrayList<Person> people = new ArrayList<>();
            Person person = null;
            if ((person = csvReader.read()) != null) {
                System.out.println(person);
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
