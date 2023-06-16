package epicode.JAVASPRINGWEEK7PROGETTO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRilevatoreIncendi {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	@Test
	void testInvocazioneURL() {
		SondaIncendi sonda = SondaFactory.creaSonda(1, 50.123, 10.456);

		CentroControllo centroControllo = new CentroControlloImpl();

		GestoreComunicazione gestoreComunicazione = new GestoreComunicazione(List.of(sonda));
		gestoreComunicazione.aggiungiOsservatore(centroControllo);
		sonda.setLivelloFumo(6);

		// Simulazione del rilevamento dell'incendio
		gestoreComunicazione.rilevaIncendio();

		// Verifica che l'URL sia stata correttamente generata
		String expectedUrl = "http://host/alarm?idsonda=1&lat=50.123&lon=10.456&smokelevel=6";
		// Assumi che il log del percorso completo dell'URL sia stato stampato
		// Controlla se l'output contiene l'URL atteso
		// (nell'implementazione reale, si potrebbe verificare l'effettiva invocazione
		// dell'URL)
		assertTrue(outputStreamCaptor.toString().contains(expectedUrl));

	}
}
