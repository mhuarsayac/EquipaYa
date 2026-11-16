package dao.impl;

import dao.AlquilerDAO;
import models.AlquilerModel;
import models.CrearEquipo;
import models.EquipoModel;
import services.DatabaseConnector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAOImpl implements AlquilerDAO {
    @Override
    public boolean insertar(AlquilerModel producto) {
        try {
            try (Connection cn = DatabaseConnector.conectarBaseDeDatos()) {}
            String sql = "INSERT INTO alquiler (documento,codigo_equipo,fecha_inicio,numero_dias,monto_cobrado,devuelto) VALUES (?,?,?,?,?,'N')";
            Connection connection = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getDocumento());
            ps.setString(2, producto.getCodigo_equipo());
            ps.setString(3, producto.getFecha_inicio());
            ps.setInt(4, producto.getNumero_dias());
            ps.setDouble(5, producto.getMonto_cobrado());
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else  {
                return false;
            }
        }catch(SQLException error){
            error.getMessage();
        }
        return false;
    }

    public List<AlquilerModel> listarTodos() {
        List<AlquilerModel> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alquiler";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new AlquilerModel(
                        rs.getInt("id_alquiler"),
                        rs.getString("documento"),
                        rs.getString("fecha_inicio"),
                        rs.getString("codigo_equipo"),
                        rs.getInt("numero_dias"),
                        rs.getDouble("monto_cobrado"),
                        rs.getString("devuelto")
                        ));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public AlquilerModel buscarPorCodigo(String codigo) {
        try {
            String sql = "SELECT * FROM alquiler WHERE id_alquiler = ?";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if  (rs.next()) {
                AlquilerModel alquiler = new AlquilerModel(
                        rs.getInt("id_alquiler"),
                        rs.getString("documento"),
                        rs.getString("fecha_inicio"),
                        rs.getString("codigo_equipo"),
                        rs.getInt("numero_dias"),
                        rs.getDouble("monto_cobrado"),
                        rs.getString("devuelto")
                );
                return alquiler;
            }

        }catch (SQLException error){
            System.out.println("Error al buscar al alquiler por codigo: " + error.getMessage());
        }

        return null;
    }

    @Override
    public List<AlquilerModel> pendientes() {
        List<AlquilerModel> lista = new ArrayList<>();
        try {
            String sql = "SELECT a.id_alquiler, c.nombre, e.descripcion, a.fecha_inicio, " +
                    "a.numero_dias, a.monto_cobrado, a.devuelto " +
                    "FROM alquiler a " +
                    "JOIN cliente c ON c.documento = a.documento " +
                    "JOIN equipo e ON e.codigo_equipo = a.codigo_equipo " +
                    "WHERE a.devuelto = 'N'";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new AlquilerModel(
                        rs.getInt("id_alquiler"),
                        rs.getString("nombre"),
                        rs.getString("fecha_inicio"),
                        rs.getString("descripcion"),
                        rs.getInt("numero_dias"),
                        rs.getDouble("monto_cobrado"),
                        rs.getString("devuelto")
                ));
            }
        } catch (SQLException error) {
            System.out.println("Error al listar pendientes: " + error.getMessage());
        }
        return lista;
    }

    @Override
    public boolean devolver(String codigoEquipo) {
        try {
            String sql = "UPDATE alquiler SET devuelto = 'S' WHERE codigo_equipo = ? AND devuelto = 'N'";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, codigoEquipo);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException error) {
            System.out.println("Error al devolver: " + error.getMessage());
            return false;
        }
    }

    @Override
    public List<String> facturacionPorTipo() {
        List<String> lista = new ArrayList<>();
        try {
            String sql = "SELECT t.nombre, SUM(a.monto_cobrado) AS total " +
                    "FROM alquiler a " +
                    "JOIN equipo e ON a.codigo_equipo = e.codigo_equipo " +
                    "JOIN tipo t ON e.id_tipo = t.id_tipo " +
                    "GROUP BY t.nombre " +
                    "ORDER BY t.nombre";
            Connection cn = DatabaseConnector.conectarBaseDeDatos();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nombre") + ": S/ " + rs.getDouble("total"));
            }
        } catch (SQLException error) {
            System.out.println("Error en facturacion: " + error.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(AlquilerModel producto) {
        return false;
    }

    @Override
    public boolean eliminar(String codigo) {
        return false;
    }
}
