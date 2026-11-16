package dao;

import models.AlquilerModel;

import java.util.List;

public interface AlquilerDAO extends GenericDAO<AlquilerModel, String> {
    List<AlquilerModel> pendientes();
    boolean devolver(String codigo);
}

