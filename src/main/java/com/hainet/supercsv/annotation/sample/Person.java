package com.hainet.supercsv.annotation.sample;

import com.github.mygreen.supercsv.annotation.CsvBean;
import com.github.mygreen.supercsv.annotation.CsvColumn;
import com.github.mygreen.supercsv.annotation.CsvPartial;
import com.github.mygreen.supercsv.annotation.format.CsvDateTimeFormat;
import lombok.Data;

import java.time.LocalDate;

@CsvBean(header = true)
@CsvPartial(columnSize = 5)
@Data
public class Person {

    @CsvColumn(number = 1)
    private String name;

    @CsvColumn(number = 2)
    private int age;

    @CsvColumn(number = 3)
    private LocalDate birthday;

    @CsvColumn(number = 4)
    @CsvDateTimeFormat(pattern = "uuuu/MM/dd")
    private LocalDate birthdayParsed;
}
