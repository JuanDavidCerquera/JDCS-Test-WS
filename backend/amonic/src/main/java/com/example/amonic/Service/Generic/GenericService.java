package com.example.amonic.Service.Generic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.DTO.Generic.GenericDto;
import com.example.amonic.DTO.Generic.GenericForeignKey;
import com.example.amonic.DTO.Generic.GenericWhere;
import com.example.amonic.IRepository.Generic.GenericRepository;
import com.example.amonic.IService.Generic.IGenericService;

@Service
public class GenericService  implements IGenericService{

	@Autowired
	private GenericRepository repo;
	
	@Override
	   public List<Map<String, Object>> getGeneric(GenericDto filter) throws Exception {
		
		
        StringBuilder query = new StringBuilder("SELECT ");

        // Añadir los campos al SELECT
        if (filter.getCampos() != null && !filter.getCampos().isEmpty()) {
            for (int i = 0; i < filter.getCampos().size(); i++) {
                query.append(filter.getCampos().get(i));
                if (i < filter.getCampos().size() - 1) {
                    query.append(", ");
                }
            }
        } else {
            query.append("*");
        }

        // Añadir la entidad al FROM
        query.append(" FROM ").append(filter.getEntidad());

        // Añadir las claves foráneas
        if (filter.getForeignKeys() != null && !filter.getForeignKeys().isEmpty()) {
        	
        	//establecer que tipo de JOIN va a realizar
            for (GenericForeignKey fk : filter.getForeignKeys()) {
                query.append(" INNER JOIN ").append(fk.getEntity())
                     .append(" ON ").append(fk.getParametro1())
                     .append(" = ").append(fk.getParametro2());
            }
            
        }

        // Añadir las condiciones al WHERE
        if (filter.getWheres() != null && !filter.getWheres().isEmpty()) {
        	
            query.append(" WHERE ");
            for (int i = 0; i < filter.getWheres().size(); i++) {
            	
            	//dejar escribir todo el where para condiciones especiales
                GenericWhere where = filter.getWheres().get(i);
                query.append(where.getCampo()).append(" ").append(where.getOperador())
                     .append(" ").append(where.getFiltro());
                if (i < filter.getWheres().size() - 1) {
                    query.append(" AND ");
                }
            }
            
        }

        String finalQuery = query.toString();
        System.out.println("Generated Query: " + finalQuery);
		return repo.findCustomData(finalQuery);

      
    }


	
}
