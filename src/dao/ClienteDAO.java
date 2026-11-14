package dao;

import models.ClienteModel;

import java.util.List;

public interface ClienteDAO extends GenericDAO<ClienteModel, String> {
    List<ClienteModel> buscarPorNombre(String fragmento);
}
