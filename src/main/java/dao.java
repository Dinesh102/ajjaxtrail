import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dao")
public class dao extends HttpServlet{
    private static final long serialVersionUID = 1L;

   
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
    try {
        Connection con;
        // Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsondb","root","");
        System.out.println("conection");
        List<Country> coun = new ArrayList<Country>();
        PreparedStatement stmt=con.prepareStatement("SELECT `Code`, `Name`, `Continent`, `Region`, `Population`, `Capital` FROM `country`");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Country country = new Country();
            
            country.setCode(rs.getInt("code"));
            country.setName(rs.getString("name"));
            country.setContinent(rs.getString("continent"));
            country.setRegion(rs.getString("region"));
            country.setPopulation(rs.getInt("population"));
            country.setCapital(rs.getString("capital"));
            coun.add(country); 
        }
      
        System.out.println(coun);
        System.out.println();
        String s="country";
        try {
            request.setAttribute("name", s);
              request.setAttribute("countries", coun);
            request.getRequestDispatcher("/table.jsp").include(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
     
     
        System.out.println("check");
        con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
    }


}

}