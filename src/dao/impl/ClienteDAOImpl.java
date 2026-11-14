package dao.impl;

import dao.ClienteDAO;
import models.ClienteModel;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public boolean insertar(ClienteModel producto) {
        return false;
    }

    @Override
    public List<ClienteModel> listarTodos() {
        return List.of();
    }

    @Override
    public ClienteModel buscarPorCodigo(String codigo) {
        return null;
    }

    @Override
    public boolean actualizar(ClienteModel producto) {
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        return false;
    }
}
