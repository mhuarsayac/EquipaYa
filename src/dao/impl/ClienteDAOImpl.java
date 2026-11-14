package dao.impl;

import dao.ClienteDAO;
import models.ClienteModel;
import services.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public boolean insertar(ClienteModel c) {
        try {
            String sql = "INSERT INTO cliente (documento, nombre, telefono) VALUES (?, ?, ?)";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getDocumento());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTelefono());
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
    public List<ClienteModel> listarTodos() {
        List<ClienteModel> lista = new ArrayList<>();
        try {
            String sql = "SELECT documento, nombre, telefono FROM cliente";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new ClienteModel(
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public ClienteModel buscarPorCodigo(String documento) {
        try {
            String sql = "SELECT * FROM cliente WHERE documento = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, documento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ClienteModel(
                        rs.getString("documento"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(ClienteModel c) {
        try {
            String sql = "UPDATE cliente SET nombre = ?, telefono = ? WHERE documento = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getTelefono());
            ps.setString(3, c.getDocumento());
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
    public boolean eliminar(String documento) {
        try {
            String sql = "DELETE FROM cliente WHERE documento = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, documento);
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
