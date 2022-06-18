package de.maximilianmleziva;

import org.apache.commons.cli.*;

import java.io.IOException;
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
        Option buyOption = new Option("b", "buy", true, "Kaufe ein Item");
        buyOption.setArgs(2);
        buyOption.setValueSeparator(',');
        options.addOption(buyOption);
        Option addOption = new Option("a", "add", true, "füge gefundenes oder bekommenes Geld, ausserhalb vom handeln, hinzu");
        addOption.setArgs(5);
        options.addOption(addOption);
        addOption.setValueSeparator(',');
        Option removeOption = new Option("r", "remove", true, "entferne Geld, ausserhalb vom handeln, von der Liste");
        removeOption.setArgs(5);
        removeOption.setValueSeparator(',');
        options.addOption(removeOption);
        Option initOption = new Option("i", "initialize", true, "Füge einen Spieler hinzu");
        initOption.setArgs(5);
        initOption.setValueSeparator(',');
        options.addOption(initOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            if (cmd.hasOption("b")) {
                TextFile.read();
                String[] buyArgs = cmd.getOptionValues("b");
                String player = buyArgs[0];
                String item = buyArgs[1];
                //Buy.buyItem(player, item);
                System.out.println("gekauft: " + item);
                return CLIStatus.BUY;
            } else if (cmd.hasOption("a")) {
                TextFile.read();
                String[] options = cmd.getOptionValues("a");
                String player = options[0];
                List<Integer> money = List.of(Integer.parseInt(options[1]),
                        Integer.parseInt(options[2]),
                        Integer.parseInt(options[3]),
                        Integer.parseInt(options[4]));
                Currency.add(player, money);
                System.out.println("Hinzugefügt: " + options[1] + "PM" + options[2] + "GM" + options[3] + "SM" + options[4] + "CM");
                return CLIStatus.ADD;
            } else if (cmd.hasOption("r")) {
                TextFile.read();
                String[] options = cmd.getOptionValues("r");
                String player = options[0];
                List<Integer> money = List.of(Integer.parseInt(options[1]),
                        Integer.parseInt(options[2]),
                        Integer.parseInt(options[3]),
                        Integer.parseInt(options[4]));
                Currency.remove(player, money);
                System.out.println("Entfernt: " + options[1] + "PM" + options[2] + "GM" + options[3] + "SM" + options[4] + "CM");
                return CLIStatus.REMOVE;
            } else if (cmd.hasOption("i")) {
                TextFile.read();
                String[] options = cmd.getOptionValues("i");
                String player = options[0];
                List<Integer> money = List.of(Integer.parseInt(options[1]),
                        Integer.parseInt(options[2]),
                        Integer.parseInt(options[3]),
                        Integer.parseInt(options[4]));
                CurrencyMap.updateMap(player, money);
                System.out.println("Character" + player + "hinzugefügt!");
                return CLIStatus.INITIALIZE;
            }
        } catch (ParseException e) {
            hilfe();
            return CLIStatus.ERROR;
        }

        hilfe();
        return CLIStatus.HELP;
    }
}
