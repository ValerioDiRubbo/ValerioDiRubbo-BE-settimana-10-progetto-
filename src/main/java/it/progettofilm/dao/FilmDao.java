package it.progettofilm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import it.progettofilm.entity.Film;

public class FilmDao implements IPersonaDao {

	private EntityManager em = EntityManagerHelper.getEntityManager();
	
	@Override
	public void salva(Film p) {
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	@Override
	public void aggiorna(Film p) {

		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();

	}

	@Override
	public Film trova(int id) {

		Film p = em.find(Film.class, id);
		
		return p;
	}

	@Override
	public List<Film> trovaByRegista(String regista) {

		Query q = em.createQuery("SELECT f from Film f where f.regista = '" +regista+ "'");
		List<Film> listafilm = q.getResultList();
		return listafilm;
	}

	@Override
	public void elimina(int id) {

		em.getTransaction().begin();
		em.remove(em.find(Film.class, id));
		em.getTransaction().commit();
		
	}

	@Override
	public List<Film> trovaTutti() {

		Query q = em.createNamedQuery("trovatutti");
		List<Film> listaPersone= q.getResultList();
		
		return listaPersone;
	}

	
	
}
