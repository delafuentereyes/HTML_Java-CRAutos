package auto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesus
 */
public class autosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "RoJoJe");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");

            out.print("<html lang=\"en\">");
            out.print("<head>");
            out.print("<meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">");
            out.print("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ\" crossorigin=\"anonymous\"></script>");
            out.print("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN\" crossorigin=\"anonymous\"></script>");
            out.print("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js\" integrity=\"sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/\" crossorigin=\"anonymous\"></script>");
            out.print("<title> CRAutos | Autos disponibles </title>");
            out.print("</head>");
            out.print("<body style='background-color: #474C5B;'>");

            out.print("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\"  style='background-color: black;'>");
            out.print("     <a class=\"navbar-brand\"  style='background-color: black; color: red;' href=\"#\"> CRAutos </a>");
            out.print("     <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
            out.print("         <span class=\"navbar-toggler-icon\"></span>");
            out.print("     </button>");
            out.print("     <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
            out.print("         <ul class=\"navbar-nav mr-auto\">");
            out.print("             <li class=\"nav-item active\">");
            out.print("                 <a class=\"nav-link\" href=\"menu.html\"> Inicio </a>");
            out.print("             </li>");
            out.print("         </ul>");
            out.print("         <form class=\"d-flex\">");
            out.print("             <input class=\"form-control me-2\" type=\"search\" placeholder=\"buscar auto...\" aria-label=\"Search\">");
            out.print("             <button class=\"btn btn-outline-success\" type=\"submit\"> Buscar </button>");
            out.print("         </form>");
            out.print("     </div>");
            out.print("</nav>");
            out.print("<div class=\"container\">");
            out.print("<table class=\"table table-dark\">");
            out.print("  <thead>");
            out.print("    <tr>");
            out.print("      <th scope=\"col\">Marca</th>");
            out.print("      <th scope=\"col\">Modelo</th>");
            out.print("      <th scope=\"col\">Año</th>");
            out.print("      <th scope=\"col\">Estilo</th>");
            out.print("    </tr>");
            out.print("  </thead>");
            out.print("  <tbody>");

            while (resultSet.next()) {
                out.print("    <tr onclick=" + "verDetalle(" + "'" + resultSet.getString(1) + "'," + "'" + resultSet.getString(2) + "'," + resultSet.getInt(3) + ",'" + resultSet.getString(4) + "'" + ")>");
                out.print("      <th scope=\"row\">" + resultSet.getString(1) + "</th>");
                out.print("      <td>" + resultSet.getString(2) + "</td>");
                out.print("      <td>" + resultSet.getInt(3) + "</td>");
                out.print("      <td>" + resultSet.getString(4) + "</td>");
                out.print("    </tr>");
            }

            out.print(" </tbody>");
            out.print("</table>");
            out.print("<a href='añadir.html' style='color: red;'> Añadir otro auto </a>"); 
            out.print("</div>");
            out.print(" <script type='text/javascript'>");
            out.print("     function verDetalle(marca, modelo, anno, estilo){");
            out.print("         window.location.href = 'editAuto.jsp?marca=' + marca  + '&modelo=' + modelo + '&anno=' + anno + '&estilo=' + estilo;");
            out.print("     }");
            out.print(" </script>");
            out.print("</body>");
            out.print("</html>");

            statement.close();
            resultSet.close();
        } catch (Exception e) {
            {
                out.println(e.getMessage());
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
