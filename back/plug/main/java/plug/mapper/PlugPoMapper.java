package plug.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plug.mapper.po.PlugPo;

@Repository
public interface PlugPoMapper extends JpaRepository<PlugPo, Long> {

}
