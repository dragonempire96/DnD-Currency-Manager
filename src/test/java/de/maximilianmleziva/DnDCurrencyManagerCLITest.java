package de.maximilianmleziva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class DnDCurrencyManagerCLITest {

    private DnDCurrencyManagerCLI dndCurrencyManagerCLI;

    @Test
    @DisplayName("Leerer Aufruf, zeige Hilfe an.")
    public void test1() throws IOException {
        CLIStatus cliStatus = dndCurrencyManagerCLI.readCLI(new String[]{});
        assertThat(cliStatus).isEqualTo(CLIStatus.HELP);
    }
}