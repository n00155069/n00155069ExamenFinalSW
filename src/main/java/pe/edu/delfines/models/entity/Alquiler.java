package pe.edu.delfines.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio", length = 10, nullable = false)
	private String precio;
	
	@Column(name = "fechaEntrada", length = 10, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fec_entrada;
	
	@Column(name = "fechaSalida", length = 10, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fec_salida;
	
	@Column(name = "estado", length = 10, nullable = false)
	private String estado;
	
	@Column(name = "observacion", length = 10, nullable = false)
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	
	@JsonIgnoreProperties("alquileres")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Date getFec_entrada() {
		return fec_entrada;
	}

	public void setFec_entrada(Date fec_entrada) {
		this.fec_entrada = fec_entrada;
	}

	public Date getFec_salida() {
		return fec_salida;
	}

	public void setFec_salida(Date fec_salida) {
		this.fec_salida = fec_salida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
	
}
