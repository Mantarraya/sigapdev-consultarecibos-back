package edu.moduloalumno.dao;

import java.util.List;

import edu.moduloalumno.model.AutorizacionEstadoJSON;

public interface IAutorizacionEstadoDAO {

	List<AutorizacionEstadoJSON> getAllAutorizacionEstado();

	AutorizacionEstadoJSON getAutorizacionEstadoById(int id_autorizacion_estado);

	AutorizacionEstadoJSON addAutorizacionEstado(AutorizacionEstadoJSON AutorizacionEstado);

	void updateAutorizacionEstado(AutorizacionEstadoJSON AutorizacionEstado);

	void deleteAutorizacionEstado(int id_autorizacion_estado);

}