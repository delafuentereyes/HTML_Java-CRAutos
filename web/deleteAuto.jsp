<%@page language="java" import="java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>

<%!
    //proceso para borrar contenido de la base de datos por año de fabricación
    Connection con;
    PreparedStatement ps;

    public void jspInit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "RoJoJe");
            ps = con.prepareStatement("DELETE FROM cars WHERE año = ?");
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
    int anno = Integer.parseInt(request.getParameter("anno"));

    ps.setInt(1, anno);

    ps.executeUpdate();
%>

<%
    request.getRequestDispatcher("autosServlet").forward(request, response);
%>