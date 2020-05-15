package br.fepi.si.financeiro.app;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeradorTabelasApp {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		try {
			emf = Persistence.createEntityManagerFactory("FinanceiroPU");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			emf.close();
		}

	}

}
