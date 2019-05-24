package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IAlumnoMatriculaAutorizacionDAO;
import edu.moduloalumno.entity.AlumnoMatriculaAutorizacion;
import edu.moduloalumno.rowmapper.AlumnoMatriculaAutorizacionRowMappper;

@Transactional
@Repository
public class AlumnoMatriculaAutorizacionImpl implements IAlumnoMatriculaAutorizacionDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
    @Override
    public List<AlumnoMatriculaAutorizacion> getAllAlumnoMatriculaAutorizacion(){
        String sql = "TODO";

		RowMapper<AlumnoMatriculaAutorizacion> rowMapper = new AlumnoMatriculaAutorizacionRowMappper();
		return this.jdbcTemplate.query(sql, rowMapper);
    }
    @Override
    public AlumnoMatriculaAutorizacion getAlumnoMatriculaAutorizacionById(int id_autorizacion){
        String sql = "TODO";
		RowMapper<AlumnoMatriculaAutorizacion> rowMapper = new BeanPropertyRowMapper<AlumnoMatriculaAutorizacion>(AlumnoMatriculaAutorizacion.class);
		AlumnoMatriculaAutorizacion alumnoMatriculaAutorizacion = jdbcTemplate.queryForObject(sql, rowMapper, id_autorizacion);
		return alumnoMatriculaAutorizacion;
    }

}