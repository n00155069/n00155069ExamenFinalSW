package pe.edu.delfines.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.services.TipoService;

@Service
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository tipoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Tipo> findAll() throws Exception {
		return tipoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Tipo> findById(String id) throws Exception {
		return tipoRepository.findById(id);
	}

	@Transactional
	@Override
	public Tipo save(Tipo entity) throws Exception {
		return tipoRepository.save(entity);
	}

	@Transactional
	@Override
	public Tipo update(Tipo entity) throws Exception {
		return tipoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		tipoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		tipoRepository.deleteAll();
	}

}
