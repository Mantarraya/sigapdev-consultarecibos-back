package edu.moduloalumno.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.dao.IMatriculaCabDAO;
import edu.moduloalumno.entity.MatriculaCab;
import edu.moduloalumno.rowmapper.MatriculaCabProgramaRowMapper;

@Transactional
@Repository
public class MatriculaCabDAOImpl implements IMatriculaCabDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public MatriculaCab getMatriculaCabBycodAlumno(String cod_alumno) {
		String sql = "SELECT cod_alumno, id_prograna, semestre, ciclo FROM matricula_cab WHERE cod_alumno = ?";
		RowMapper<MatriculaCab> rowMapper = new MatriculaCabProgramaRowMapper();
		MatriculaCab matriculaCab = jdbcTemplate.queryForObject(sql, rowMapper, cod_alumno);
		return matriculaCab;
	}

    public MatriculaCab getMatriculaCabByIdPrograma(Integer id_programa){
        String sql = "SELECT cod_alumno, id_prograna, semestre, ciclo FROM matricula_cab WHERE id_programa = ?";
        RowMapper<MatriculaCab> rowMapper = new MatriculaCabProgramaRowMapper();
		MatriculaCab matriculaCab = jdbcTemplate.queryForObject(sql, rowMapper, id_programa);
		return matriculaCab;
    }

    public MatriculaCab getMatriculaCabBySemestre(String semestre){
        String sql = "SELECT cod_alumno, id_prograna, semestre, ciclo FROM matricula_cab WHERE semestre = ?";
        RowMapper<MatriculaCab> rowMapper = new MatriculaCabProgramaRowMapper();
		MatriculaCab matriculaCab = jdbcTemplate.queryForObject(sql, rowMapper, semestre);
		return matriculaCab;
    }

    public MatriculaCab getMatriculaCabByCiclo(Integer ciclo){
        String sql = "SELECT cod_alumno, id_prograna, semestre, ciclo FROM matricula_cab WHERE ciclo = ?";
        RowMapper<MatriculaCab> rowMapper = new MatriculaCabProgramaRowMapper();
		MatriculaCab matriculaCab = jdbcTemplate.queryForObject(sql, rowMapper, ciclo);
		return matriculaCab;
    }


	@Override
	public List<MatriculaCab> getAllMatriculaCab() {
		String sql = "SELECT cod_alumno, id_prograna, semestre, ciclo FROM matricula_cab";

		RowMapper<MatriculaCab> rowMapper = new MatriculaCabProgramaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public MatriculaCab getMatriculaCabByIdPrograma(int id_programa) {
		return null;
	}

	@Override
	public MatriculaCab getMatriculaCabByCiclo(int ciclo) {
		return null;
	}
}