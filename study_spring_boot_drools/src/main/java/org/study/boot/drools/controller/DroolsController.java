package org.study.boot.drools.controller;

//import org.kie.api.runtime.KieSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: DroolsController
 * Description: Drools引擎测试
 * Date:     2019/3/24 22:38
 * History:
 * <version> 1.0
 * @author lin
 */
@RequestMapping("/drools")
@RestController
public class DroolsController {

    @RequestMapping(value = "index")
    public String droolsDemo() throws Exception {
//        KieSession session = KieSessionUtils.getAllRules();
//        session.insert(new Double(1));
//        session.fireAllRules();
      return  "ok";
    }
}
