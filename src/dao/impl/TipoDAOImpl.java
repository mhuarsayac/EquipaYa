package dao.impl;

import dao.TipoDAO;
import models.ClienteModel;
import models.TipoModel;
import services.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDAOImpl implements TipoDAO {
    @Override
    public boolean insertar(TipoModel t) {
        try {
            String sql = "INSERT INTO tipo (id_tipo, nombre) VALUES (?, ?)";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, t.getIdTipo());
            ps.setString(2, t.getNombre());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<TipoModel> listarTodos() {
        List<TipoModel> lista = new ArrayList<>();
        try {
            String sql = "SELECT id_tipo, nombre FROM tipo";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new TipoModel(
                        rs.getString("idTipo"),
                        rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public TipoModel buscarPorCodigo(String idTipo) {
        try {
            String sql = "SELECT * FROM tipo WHERE id_tipo = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, idTipo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new TipoModel(
                        rs.getString("idTipo"),
                        rs.getString("nombre")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(TipoModel t) {
        try {
            String sql = "UPDATE tipo SET nombre = ? WHERE id_tipo = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getIdTipo());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String idTipo) {
        try {
            String sql = "DELETE FROM tipo WHERE idTipo = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, idTipo);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
