package epicode.JAVASPRINGWEEK7PROGETTO;

public class SondaFactory {
	public static SondaIncendi creaSonda(int id, double latitudine, double longitudine) {
		return new SondaIncendi(id, latitudine, longitudine);
	}
}
