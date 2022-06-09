package de.maximilianmleziva;

import org.apache.commons.cli.*;

import java.io.IOException;

public class DnDCurrencyManagerCLI {

    private static final Options options = new Options();

    private final CSV csv;

    public DnDCurrencyManagerCLI(CSV csv) {
        this.csv = csv;
    }

    public static void main(String[] args) throws IOException {
        DnDCurrencyManagerCLI dnDCurrencyManagerCLI = new DnDCurrencyManagerCLI(new CSV(true));
        dnDCurrencyManagerCLI.readCLI(args);
    }

    private void hilfe() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("dnd-currency-manager", options);
    }
    
    CLIStatus readCLI(String[] args) throws IOException {
        options.addOption("h", "help", false, "Zeige diese Hilfe an");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            hilfe();
            return CLIStatus.ERROR;
        }

        hilfe();
        return CLIStatus.HELP;
    }
}
