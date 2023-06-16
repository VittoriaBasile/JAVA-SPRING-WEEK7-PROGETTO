package epicode.JAVASPRINGWEEK7PROGETTO;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GestioneIncendiRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Creazione della sonda e del centro di controllo
		SondaIncendi sonda = SondaFactory.creaSonda(1, 50.123, 10.456);
		SondaIncendi sonda2 = SondaFactory.creaSonda(2, 52.456, 11.678);

		CentroControllo centroControllo = new CentroControlloImpl();

		// Creazione del gestore di comunicazione
		GestoreComunicazione gestoreComunicazione = new GestoreComunicazione(List.of(sonda, sonda2));
		gestoreComunicazione.aggiungiOsservatore(centroControllo);
		sonda.setLivelloFumo(6);
		sonda2.setLivelloFumo(6);
		// Simulazione del rilevamento dell'incendio
		gestoreComunicazione.rilevaIncendio();
	}

}
