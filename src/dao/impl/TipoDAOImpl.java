package dao.impl;

import dao.TipoDAO;
import models.TipoModel;

import java.util.List;

public class TipoDAOImpl implements TipoDAO {
    @Override
    public boolean insertar(TipoModel producto) {
        return false;
    }

    @Override
    public List<TipoModel> listarTodos() {
        return List.of();
    }

    @Override
    public TipoModel buscarPorCodigo(String codigo) {
        return null;
    }

    @Override
    public boolean actualizar(TipoModel producto) {
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        return false;
    }
}
