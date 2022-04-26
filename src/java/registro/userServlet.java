
package registro;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "RoJoJe");
                Statement statement = connection.createStatement();
                
                ResultSet resultSet = statement.executeQuery("select * from user");
                out.print("<table>");
                out.print("<tr>");
                out.print("<th>");
                out.println("Nombre");
                out.print("</th>");
                out.print("<th>");
                out.println("Telefono");
                out.print("</th>");
                out.print("<th>");
                out.println("Email");
                out.print("</th>");
                out.print("</tr>");
                while (resultSet.next()) {
                    out.println("<tr>");
                    out.println("<td>");
                    out.print(resultSet.getString(2));
                    out.println("</td>");
                    out.println("<td>");
                    out.print(resultSet.getString(3));
                    out.println("</td>");
                    out.println("<td>");
                    out.print(resultSet.getString(4));
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.print("</table>");
                
                statement.close();
                connection.close();
                resultSet.close();

            } catch (Exception e) {
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
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {
                //instanciar desde index
                String firstName = request.getParameter("firstName");
                String telefono = request.getParameter("telefono");
                String email = request.getParameter("email");
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "RoJoJe");
                Statement statement = connection.createStatement();
                
                //insertar cosas desde html
                String sql = "INSERT INTO user VALUES (" + "'" + firstName + "', '" + telefono + "', '" + email + "')";
                
                statement.executeUpdate(sql);
                statement.close();
                
                out.print("Usuario creado con éxito");//mostrar mensaje de que se creo
                //dispatcher es para que cuando termine el proceso, me envíe a la index (pag principal)
                RequestDispatcher rd = request.getRequestDispatcher("/index.html");
                rd.include(request, response);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }
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
