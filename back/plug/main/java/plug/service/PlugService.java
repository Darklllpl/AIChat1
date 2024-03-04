package plug.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plug.dao.PlugDao;

/**
 * @author dell
 */
@Service
@Slf4j
@Transactional
public class PlugService {
    private PlugDao plugDao;

    @Autowired
    public PlugService(PlugDao plugDao){
        this.plugDao = plugDao;
    }
}
