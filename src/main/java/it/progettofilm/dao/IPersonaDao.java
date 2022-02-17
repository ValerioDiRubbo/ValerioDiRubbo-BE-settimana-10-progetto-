package it.progettofilm.dao;

import java.util.List;

import it.progettofilm.entity.Film;

public interface IPersonaDao {

	public void salva(Film p);
	public void aggiorna(Film p);
	public Film trova(int id);
	public List<Film> trovaByRegista(String regista);
	public void elimina(int id);
	public List<Film> trovaTutti();
}
