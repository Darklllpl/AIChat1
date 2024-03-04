package plug.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plug.service.PlugService;

/**
 * @author dell
 */
@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class PlugController {
    private PlugService plugService;

    @Autowired
    public PlugController(PlugService plugService){
        this.plugService = plugService;
    }
}
