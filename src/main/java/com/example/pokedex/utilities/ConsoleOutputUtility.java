package com.example.pokedex.utilities;

public class ConsoleOutputUtility {
    OutputFormat outputFormat;
    MultipleFormatGenerator formatsGenerator;
    public ConsoleOutputUtility(OutputFormat outputFormat, MultipleFormatGenerator formatsGenerator) {
        this.outputFormat = outputFormat;
        this.formatsGenerator = formatsGenerator;
    }

    public void makeOutput() {
        if (this.outputFormat == OutputFormat.TEXT) {
            System.out.println(formatsGenerator.generateHumanReadableText());
        } else if (this.outputFormat == OutputFormat.HTML) {
            System.out.println(formatsGenerator.generateHTML());
        } else if (this.outputFormat == OutputFormat.CSV) {
            System.out.println(formatsGenerator.generateCSV());
        }
    }
}
