<%@page language="java" import="java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>

<%!
    //proceso para actualizar la info de cualquier vehículo que esté en la base de datos por el modelo
    Connection con;
    PreparedStatement ps;

    public void jspInit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "RoJoJe");
            ps = con.prepareStatement("UPDATE cars SET marca = ?, año = ?, estilo = ? WHERE modelo = ?");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void jspDestroy() {
        try {
            con.close();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
%>

<%
    String marca = request.getParameter("marcas");
    int anno = Integer.parseInt(request.getParameter("txtanno"));
    String estilo = request.getParameter("estilos");
    String modelo = request.getParameter("txtmodelo");
    
    ps.setString(1, marca);
    ps.setInt(2, anno);
    ps.setString(3, estilo);
    ps.setString(4, modelo);

    ps.executeUpdate();
%>

<%
    request.getRequestDispatcher("autosServlet").forward(request, response);
%>

