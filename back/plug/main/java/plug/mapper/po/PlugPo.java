package plug.mapper.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class PlugPo {
    @Id
    private Long id;
}
