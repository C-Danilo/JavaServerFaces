package br.fepi.si.financeiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*Classe utilizada para criar um EntityManager para todas as classes que necessitarem*/
public class JpaUtil {

		private static EntityManagerFactory emf;
		
		static {
			emf = Persistence.createEntityManagerFactory("FinanceiroPU");
		}
		
		public static EntityManager getEntityManager() {
			return emf.createEntityManager();			
		}
		
}
