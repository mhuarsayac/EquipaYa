package dao.impl;

import dao.EquipoDAO;
import models.*;
import services.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAOImpl implements EquipoDAO {
    @Override
    public boolean insertar(EquipoModel p) {
        try {
            String sql = "INSERT INTO equipo (codigo_equipo, descripcion, tarifa_diaria, disponible, id_tipo) VALUES (?, ?, ?, ?, ?)";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, p.getCodigoEquipo());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getTarifaDiaria());
            ps.setString(4, p.getDisponible());
            ps.setString(5, p.getIdTipo());
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
    public List<EquipoModel> listarTodos() {
        List<EquipoModel> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipo";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EquipoModel equipo = CrearEquipo.crear(
                        rs.getString("codigo_equipo"),
                        rs.getString("descripcion"),
                        rs.getDouble("tarifa_diaria"),
                        rs.getString("disponible"),
                        rs.getString("id_tipo")
                );

                if (equipo != null){
                    lista.add(equipo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public EquipoModel buscarPorCodigo(String codigo) {
        try {
            String sql = "SELECT * FROM equipo WHERE codigo_equipo = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                EquipoModel equipo = CrearEquipo.crear(
                        rs.getString("codigo_equipo"),
                        rs.getString("descripcion"),
                        rs.getDouble("tarifa_diaria"),
                        rs.getString("disponible"),
                        rs.getString("id_tipo")
                );
                if (equipo != null){
                    return equipo;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(EquipoModel p) {
        try {
            String sql = "UPDATE equipo SET descripcion = ?, tarifa_diaria = ?, disponible = ?, id_tipo = ? WHERE codigo_equipo = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, p.getDescripcion());
            ps.setDouble(2, p.getTarifaDiaria());
            ps.setString(3, p.getDisponible());
            ps.setString(4, p.getIdTipo());
            ps.setString(5, p.getCodigoEquipo());
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
    public boolean eliminar(String codigo) {
        try {
            String sql = "DELETE FROM equipo WHERE codigo_equipo = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
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
