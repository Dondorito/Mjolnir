package hibernate;

import java.util.logging.Level;
import java.util.logging.LogManager;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Sesion {
	
	private SessionFactory sf;
	private Session s;
	
	public Sesion() {
		LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
		sf = new Configuration().configure().buildSessionFactory();
		s = sf.getCurrentSession();
	}
	
	public void comenzarTransaccion() {
		s = sf.getCurrentSession();
		
		if(!s.getTransaction().isActive())
			s.beginTransaction();
	}
	
	public void confirmar() {
		s.getTransaction().commit();
	}
	
	public void deshacer() {
		s.getTransaction().rollback();
	}
	
	public void cerrarConexion() {
		s.close();
		sf.close();
	}

	
	public SessionFactory getFabricaSesiones() {
		return sf;
	}

	
	public void setFabricaSesiones(SessionFactory sf) {
		this.sf = sf;
	}

	
	public Session getSesion() {
		return s;
	}

	
	public void setSesion(Session s) {
		this.s = s;
	}
	
	
	
}
