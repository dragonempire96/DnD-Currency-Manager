package de.maximilianmleziva;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DnDCurrencyManagerCLI {

    private static final Options options = new Options();


    public static void main(String[] args) throws IOException {
        DnDCurrencyManagerCLI dnDCurrencyManagerCLI = new DnDCurrencyManagerCLI();
        dnDCurrencyManagerCLI.readCLI(args);
    }

    private void hilfe() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("dnd-currency-manager", options);
    }
    
    CLIStatus readCLI(String[] args) throws IOException {
        options.addOption("h", "help", false, "Zeige diese Hilfe an");
        options.addOption("b", "buy", true, "Kaufe ein Item");
        options.addOption("a", "add", true, "füge gefundenes oder bekommenes Geld, ausserhalb vom handeln, hinzu");
        options.addOption("r", "remove", true, "entferne Geld, ausserhalb vom handeln, von der Liste");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("b")) {
                TextFile.read();
                String player = cmd.getOptionValue("b");
                String item = cmd.getOptionValue("b");
                Buy.buyItem(player, item);
                System.out.println("gekauft: " + item);
                return CLIStatus.BUY;
            }
        } catch (ParseException e) {
            hilfe();
            return CLIStatus.ERROR;
        }

        hilfe();
        return CLIStatus.HELP;
    }
}
