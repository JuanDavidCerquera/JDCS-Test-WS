package com.example.amonic.Service.Base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.example.amonic.Entity.Base.ABaseEntity;
import com.example.amonic.IRepository.Base.IBaseRepository;
import com.example.amonic.IService.Base.IBaseService;

public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T> {

	protected abstract IBaseRepository<T, Long> getRepository();

	@Override
	public List<T> all() throws Exception {
		return getRepository().findAll();
	}

	@Override
	public Optional<T> findById(Long id) throws Exception {
		Optional<T> te = getRepository().findById(id);
		if (te.isEmpty()) {
			throw new Exception("registro no encontrado");
		}
		return te;
	}

	@Override
	public T save(T entity) throws Exception {
		try {
			return getRepository().save(entity);
		} catch (Exception e) {
			throw new Exception("no se pudo guardar");
		}
	}

	@Override
	public void update(Long id, T entity) throws Exception {
		Optional<T> te = getRepository().findById(id);
		if (te.isEmpty()) {
			throw new Exception("registro no encontrado");
		}
		T EntityUpdate = te.get();
		String[] ignoreProperties = { "id" };
		BeanUtils.copyProperties(entity, EntityUpdate, ignoreProperties);

		getRepository().save(EntityUpdate);
	}

	@Override
	public void delete(Long id) throws Exception {
		getRepository().deleteById(id);
	}
	
	@Override
	public List<T> getByFilter(T entity) {
		return null;
	}

}
