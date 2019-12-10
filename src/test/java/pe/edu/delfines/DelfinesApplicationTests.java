package pe.edu.delfines;



import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	
	
	@Test
	void contextLoads() {
		
		try {
			//Tipo
			Tipo t1 = new Tipo();
			t1.setId("T001");
			t1.setNombre("Presidencial");
			
			Tipo t2 = new Tipo();
			t2.setId("T002");
			t2.setNombre("Basico");
			
			t1 = tipoRepository.save(t1);
			t2 = tipoRepository.save(t2);
			
			//Habitacion
			Habitacion h1 = new Habitacion();
			h1.setNumeroCamas(3);
			h1.setDescripcion("Habitacion amplia con vista al mar");
			h1.setPrecio(200.0f);
			h1.setObservacion("Disponible");
			
			Habitacion h2 = new Habitacion();
			h2.setNumeroCamas(1);
			h2.setDescripcion("Habitacion para persona sola o pareja");
			h2.setPrecio(45.0f);
			h2.setObservacion("Disponible");
			
			h1 = habitacionRepository.save(h1);
			h2 = habitacionRepository.save(h2);
			
			//Cliente
			Cliente alberto = new Cliente();
			alberto.setDocumento("70450770");
			alberto.setNombre("Alberto");
			alberto.setFechaNacimiento(new Date(1997, 4, 29));
			alberto.setLugarNacimiento("La Victoria");
			alberto.setSexo('M');
			alberto.setObservacion("Cumplido");
			
			Cliente carlos = new Cliente();
			carlos.setDocumento("07495819");
			carlos.setNombre("Carlos");
			carlos.setFechaNacimiento(new Date(1995, 11, 10));
			carlos.setLugarNacimiento("Callao");
			carlos.setSexo('M');
			carlos.setObservacion("Deudor");
			
			alberto = clienteRepository.save(alberto);
			carlos = clienteRepository.save(carlos);
			
			//Vendedor
			Vendedor v1 = new Vendedor();
			v1.setId("V001");
			v1.setNombre("Tania");
			v1.setDireccion("Jr. Las Palmas 157");
			v1.setTelefono("985632169");
			v1.setObservacion("Vendedor muy amable y responsable con la atencion");
			v1.setSueldo(1200.0f);
			
			Vendedor v2 = new Vendedor();
			v2.setId("V002");
			v2.setNombre("Lilian");
			v2.setDireccion("Jr. Las Palmas 157");
			v2.setTelefono("923510678");
			v2.setObservacion("Vendedor muy empatico");
			v2.setSueldo(1100.0f);
			
			v1 = vendedorRepository.save(v1);
			v2 = vendedorRepository.save(v2);
			
			//Alquiler
			Alquiler a1 = new Alquiler();
			a1.setPrecio("400.00");
			a1.setFec_entrada(new Date(2019, 12, 9));
			a1.setFec_salida(new Date(2019, 12, 11));
			a1.setEstado("Contrato");
			a1.setObservacion("Avisar");
			
			Alquiler a2 = new Alquiler();
			a2.setPrecio("180.00");
			a2.setFec_entrada(new Date(2019, 12, 9));
			a2.setFec_salida(new Date(2019, 12, 13));
			a2.setEstado("Contrato");
			a2.setObservacion("Desayuno");
			
			a1 = alquilerRepository.save(a1);
			a2 = alquilerRepository.save(a2);
	
			
			//Relacion tipo - habitacion
			t1.addHabitacion(h1);
			t2.addHabitacion(h2);
			
			//Relacion habitacion - alquiler
			h1.addAlquiler(a1);
			h1.addAlquiler(a2);
			
			//Relacion vendedor - alquiler
			v1.addAlquiler(a1);
			v2.addAlquiler(a2);
			
			//Relacion cliente - alquiler
			alberto.addAlquiler(a1);
			carlos.addAlquiler(a2);
			

			//Grabando
			tipoRepository.save(t1);
			tipoRepository.save(t2);
			habitacionRepository.save(h1);
			habitacionRepository.save(h2);
			vendedorRepository.save(v1);
			vendedorRepository.save(v2);
			clienteRepository.save(alberto);
			clienteRepository.save(carlos);
			alquilerRepository.save(a1);
			alquilerRepository.save(a2);
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
