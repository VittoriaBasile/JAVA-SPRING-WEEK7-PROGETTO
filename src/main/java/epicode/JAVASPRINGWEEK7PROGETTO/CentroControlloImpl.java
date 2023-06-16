package epicode.JAVASPRINGWEEK7PROGETTO;

import java.util.List;

public class CentroControlloImpl implements CentroControllo {

	@Override
	public void aggiorna(List<SondaIncendi> sonde) {

		for (SondaIncendi sonda : sonde) {
			int livelloFumo = sonda.getLivelloFumo();
			if (livelloFumo > 5) {
				String url = "http://host/alarm?idsonda=" + sonda.getId() + "&lat=" + sonda.getLatitudine() + "&lon="
						+ sonda.getLongitudine() + "&smokelevel=" + livelloFumo;

				// Log del percorso completo dell'URL
				System.out.println(
						"la sonda con id : " + sonda.getId() + " ha rilevato un livello di fumo maggiore di 5: " + url);
			}
		}
	}

}
