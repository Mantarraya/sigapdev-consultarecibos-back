package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IAutorizacionEstadoDAO;
import edu.moduloalumno.entity.AutorizacionEstado;
import edu.moduloalumno.rowmapper.AutorizacionEstadoProgramaRowMapper;

@Transactional
@Repository
public class AutorizacionEstadoDAOImpl implements IAutorizacionEstadoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public AutorizacionEstado getAutorizacionEstadoById(int id_autorizacion_estado) {
		String sql = "SELECT * FROM autorizacion_estado WHERE id_autorizacion = ?";
		RowMapper<AutorizacionEstado> rowMapper = new AutorizacionEstadoProgramaRowMapper();
		AutorizacionEstado autorizacionEstado = jdbcTemplate.queryForObject(sql, rowMapper, id_autorizacion_estado);
		return autorizacionEstado;
	}

	@Override
	public List<AutorizacionEstado> getAllAutorizacionEstado() {
		String sql = "SELECT id_alum, cod_alumno, id_programa FROM alumno_alumno_programa";

		RowMapper<AutorizacionEstado> rowMapper = new AutorizacionEstadoProgramaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
}