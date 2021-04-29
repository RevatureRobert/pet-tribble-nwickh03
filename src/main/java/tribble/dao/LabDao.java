package tribble.dao;

import tribble.model.Lab;
import tribble.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabDao implements Dao<Lab,Integer> {
    @Override
    public void create(Lab lab) {
        String sql = "INSERT INTO public.labs" +
                "(\"name\", capacity)" +
                "VALUES(?, ?);";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){
            ps.setString(1,lab.getName());
            ps.setInt(2,lab.getCapacity());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public Lab read(Integer id) {
       String sql = "SELECT id, \"name\", capacity" +
               "FROM public.labs WHERE id=?;";

        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {


            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Lab(rs.getInt(1), rs.getString(2), rs.getInt(3));

            } else rs.close();
            return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Lab lab) {

        String sql = "UPDATE public.labs" +
                "SET \"name\"='?', capacity=?" +
                "WHERE id=?;";

        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {

            ps.setString(1, lab.getName());
            ps.setInt(2, lab.getCapacity());
            ps.setInt(3, lab.getId());
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        @Override
    public void delete(Integer integer) {
            String sql = "DELETE FROM public.labs" +
                    "WHERE id=?;";

            try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {

                ps.setInt(1, integer);

                ps.executeUpdate();
        } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    @Override
    public List<Lab> getAll() {
        String sql = "SELECT id, \"name\", capacity" +
                "FROM public.labs;";
        List<Lab> results = new ArrayList<>();

        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {



            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new Lab(rs.getInt(1), rs.getString(2), rs.getInt(3)));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }
}
