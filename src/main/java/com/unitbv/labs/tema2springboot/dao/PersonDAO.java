package com.unitbv.labs.tema2springboot.dao;

import javax.persistence.EntityManager;

import com.unitbv.labs.tema2springboot.entities.Person;
import com.unitbv.labs.tema2springboot.interfaces.GenericDAO;
import com.unitbv.labs.tema2springboot.util.ConnectionManager;

public class PersonDAO implements GenericDAO<Person> {

	private ConnectionManager cm = new ConnectionManager("MyPersistenceUnit");

	@Override
	public void close() {
		cm.close();
	}

	@Override
	public void createOrUpdate(Person entity) {
		EntityManager em = cm.getEMFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	@Override
	public Person findById(int id) {
		EntityManager em = cm.getEMFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.find(Person.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public Person update(Person entity) {
		EntityManager em = cm.getEMFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public void delete(Person entity) {
		EntityManager em = cm.getEMFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(entity) ? entity : em.merge(entity));  //?
			em.getTransaction().commit();
		} catch (Exception e) {

		} finally {
			em.close();
		}

	}

}
