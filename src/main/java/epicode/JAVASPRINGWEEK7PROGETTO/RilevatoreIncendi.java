package epicode.JAVASPRINGWEEK7PROGETTO;

public interface RilevatoreIncendi {
	void aggiungiOsservatore(CentroControllo osservatore);

	void rimuoviOsservatore(CentroControllo osservatore);

	void notificaOsservatori();
}
