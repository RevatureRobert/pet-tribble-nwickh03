package tribble.dao;

import tribble.model.Lab;
import tribble.model.Tribble;
import tribble.util.ConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TribbleDao implements Dao<Tribble, Integer> {


    @Override
    public void create(Tribble tribble) {

        String sql = "INSERT INTO public.tribbles" +
                "(color, lab_id)" +
                "VALUES('?, ?);";
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)){
            ps.setString(1,tribble.getColor());
            ps.setInt(2,tribble.getLab_id());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Tribble read(Integer id) {

        String sql = "SELECT id, color, lab_id" +
                "FROM public.tribbles WHERE id=?;";

        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {


            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Tribble(rs.getInt(1), rs.getString(2), rs.getInt(3));

            } else rs.close();
            return null;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Tribble tribble) {

        String sql = "UPDATE public.tribbles" +
                "SET color=?, lab_id=?" +
                "WHERE id=?;";

        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {

            ps.setString(1, tribble.getColor());
            ps.setInt(2, tribble.getLab_id());
            ps.setInt(3, tribble.getId());
            ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public void delete(Integer integer) {
        String sql = "DELETE FROM public.tribbles" +
                "WHERE id=?;";

        try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {

            ps.setInt(1, integer);

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Tribble> getAll() {

        String sql = "SELECT id, color, lab_id" +
                "FROM public.tribbles;";

        List<Tribble> results = new ArrayList<>();
        try(PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(sql)) {


            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                results.add(new Tribble(rs.getInt(1), rs.getString(2), rs.getInt(3)));

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return results;
    }

}
