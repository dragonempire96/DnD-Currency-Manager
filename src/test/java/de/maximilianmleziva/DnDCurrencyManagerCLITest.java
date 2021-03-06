package de.maximilianmleziva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DnDCurrencyManagerCLITest {

    private DnDCurrencyManagerCLI dndCurrencyManagerCLI;

    @BeforeEach
    void init() {
        this.dndCurrencyManagerCLI = new DnDCurrencyManagerCLI();
    }
    @Test
    @DisplayName("Leerer Aufruf, zeige Hilfe an.")
    public void test1() {
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(new String[]{});
        assertThat(cliStatus).isEqualTo(CLIStatus.HELP);
    }
    @Test
    @DisplayName("Aufruf buy, entfernt Preis des Items.")
    public void test2() {
        String[] arguments = {
                "--buy",
                "Maenix",
                "Langschwert"
        };
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(arguments);
        assertThat(cliStatus).isEqualTo(CLIStatus.BUY);
    }

    @Test
    @DisplayName("Aufruf add, fügt Geld hinzu.")
    public void test3() {
        String[] arguments = {
                "--add",
                "key",
                "1",
                "0",
                "0",
                "0"
        };
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(arguments);
        assertThat(cliStatus).isEqualTo(CLIStatus.ADD);
    }

    @Test
    @DisplayName("Aufruf remove, entfernt Geld.")
    public void test4() {
        String[] arguments = {
                "--remove",
                "key",
                "1",
                "0",
                "0",
                "0"
        };
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(arguments);
        assertThat(cliStatus).isEqualTo(CLIStatus.REMOVE);
    }

    @Test
    @DisplayName("Aufruf init, added Spieler.")
    public void test5() {
        String[] arguments = {
                "--initialize",
                "Maenix",
                "0",
                "41",
                "6",
                "6"
        };
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(arguments);
        assertThat(cliStatus).isEqualTo(CLIStatus.INITIALIZE);
    }

    @Test
    @DisplayName("Aufruf convert, konvertiert Geld.")
    public void test6() {
        String[] arguments = {
                "--initialize",
                "Maenix",
                "40",
                "GM",
                "PM"
        };
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(arguments);
        assertThat(cliStatus).isEqualTo(CLIStatus.CONVERT);
    }
}