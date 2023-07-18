package DeveloperAndSoftwareDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDao {
    public static Connection getCon(){
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        }catch(Exception e){System.out.println(e);}
        return con;

    }
    public static int save(Developer a){
        int status=0;
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            PreparedStatement ps=con.prepareStatement("insert into DeveloperAndRespectiveSoftwareDetails(Id,Name,Currently_Working_Software,Finished_Softwares) values(?,?,?,?)");
            ps.setInt(1,Integer.parseInt(a.getId()));
            ps.setString(2,a.getName());
            ps.setString(3,a.getCurrentlyWorkingSoftware());
            ps.setString(4,a.getFinishedSoftwares());
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static List<Developer> view(){
        List<Developer> list=new ArrayList<>();
        try{
            Connection con=getCon();
            PreparedStatement ps=con.prepareStatement("select * from DeveloperAndRespectiveSoftwareDetails;");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Developer a=new Developer();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setCurrentlyWorkingSoftware(rs.getString(3));
                a.setFinishedSoftwares(rs.getString(4));
                list.add(a);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
}