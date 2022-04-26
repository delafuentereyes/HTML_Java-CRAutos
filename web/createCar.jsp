<%@page language="java" import="java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>

<%!
    //proceso para insertar en la base de datos
    Connection con;
    PreparedStatement ps;

    public void jspInit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "RoJoJe");
            ps = con.prepareStatement("INSERT INTO cars VALUES (?, ?, ?, ?)");
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
    String modelo = request.getParameter("txtmodelo");
    int anno = Integer.parseInt(request.getParameter("txtanno"));
    String estilo = request.getParameter("estilos");

    ps.setString(1, marca);
    ps.setString(2, modelo);
    ps.setInt(3, anno);
    ps.setString(4, estilo);

    ps.executeUpdate();
%>

<%
    request.getRequestDispatcher("autosServlet").forward(request, response);
%>

