package edu.aprender.persistence.entity.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

import edu.aprender.persistence.entity.Empleado;
import edu.aprender.test.EmpleadoTest;

public class EmpleadoListener {

	static  Logger logger = Logger.getLogger(EmpleadoTest.class.getName());

	@PrePersist
	public void listener_before_insert(Empleado empleado){
		logger.debug("@PrePersist: "+empleado.toString());
	}
	
	@PreUpdate
	public void listener_before_update(Empleado empleado){
		logger.debug("@PreUpdate: "+empleado.toString());
	}
	
	@PreRemove
	public void listener_before_delete(Empleado empleado){
		logger.debug("@PreRemove: "+empleado.toString());
	}
	
	@PostLoad
	public void listener_after_query(Empleado empleado){
		logger.debug("@PostLoad: "+empleado.toString());
	}
	
	@PostPersist
	public void listener_after_insert(Empleado empleado){
		logger.debug("@PostPersist: "+empleado.toString());
	}
	
	@PostUpdate
	public void listener_after_update(Empleado empleado){
		logger.debug("@PostUpdate: "+empleado.toString());
	}
	
	@PostRemove
	public void listener_after_delete(Empleado empleado){
		logger.debug("@PostRemove: "+empleado.toString());
	}
	
}
