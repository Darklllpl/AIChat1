package plug.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import plug.mapper.PlugPoMapper;

@Repository
public class PlugDao {

    private PlugPoMapper plugPoMapper;

    @Autowired
    public PlugDao(PlugPoMapper plugPoMapper) {
        this.plugPoMapper = plugPoMapper;
    }
}
