package edu.aprender.persistence.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import edu.aprender.persistence.entity.listener.EmpleadoListener;

@EntityListeners(EmpleadoListener.class) // Es para mandar las anotaciones del previa a una clase listener
@Entity // Representa a una tabla de bd
@Table(name="tb_empleado") // Es la tabla que representa esta clase entidad
public class Empleado {
	
//	// Anotaciones para definir una caracteristica de una columna de bd
//	@Id // Indica el atributo que representa la PK de la tabla
//	@Column(name="COD_EMP",unique=true,nullable=false) // Sirve para indicar que el atributo es una columna name: Se va a relacionar con la tabla cuyo campo es COD_EMP, unique: Unicidad de ese atributo, nullable: No permite valore nulos
//	private int id;
	
//	// Usando Estrategias

//	// 1) Identity: Ya no es necesario mandar el id, la bd se encargará de generarla
//	@Id
//	@Column(name="COD_EMP",unique=true,nullable=false) 
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	private int id;

//	// 2) Secuencia: Es una estructura demás de bd. En mysql, para implementar una secuencia se debe crear una tabla y en esa tabla se crea un autoincrmentado de secuencia
//	@Id
//	@Column(name="COD_EMP",unique=true,nullable=false)
//	@GeneratedValue(strategy= GenerationType.TABLE, generator="generador")
//	@TableGenerator(name="generador", table="tb_secuencia", pkColumnName="descripcion",valueColumnName="valor", pkColumnValue="empleado", allocationSize=1)
//	private int id; 

	// 3) AUTO
	@Id
	@Column(name="COD_EMP",unique=true,nullable=false)
	@GeneratedValue(strategy= GenerationType.AUTO, generator="generador")
	@TableGenerator(name="generador", table="tb_secuencia", pkColumnName="descripcion",valueColumnName="valor", pkColumnValue="empleado", allocationSize=1)
	private int id;
	
	// Basic: Es opcional, indica si la columna es un atributo que puede ser almacenada en una bd
	// length: Longitud de caracteres
	// insertable: Indica si este campo puede ser insertable (por defecto es true)
	@Basic
	@Column(name="APE_EMP", length=45, nullable=false, insertable=true, updatable=true)
	private String apellido;
	
	// columnDefinition: Es el fragmento de SQL utlizado para generar el DDL de la columna (depende del manejador de base de datos)
	@Basic
	@Column(name="NOM_EMP",length=45, columnDefinition="unsigned NOT NULL", insertable=true, updatable=true)
	private String nombre;
	
	@Basic
	@Column(name="EDA_EMP",nullable=false, insertable=true, updatable=true)
	private int edad;
	
	@Basic
	@Column(name="ARE_EMP",length=45, nullable=false, insertable=true, updatable=true)
	private String area;
	
	// @Transient: Si queremos que este atributo NO se inserte o se actualize en la bd
	@Transient
	private String nombreCompleto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getNombreCompleto() {
		return getNombre().concat(" ").concat(getApellido());
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	// Sobreescribir el método toString para realizar pruebas unitarias
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", apellido=" + apellido + ", nombre="
				+ nombre + ", edad=" + edad + ", area=" + area
				+ ", nombreCompleto=" + getNombreCompleto() + "]";
	}

}
