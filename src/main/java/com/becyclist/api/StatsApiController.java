package com.becyclist.api;

import com.becyclist.model.StatsStorage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StatsApiController implements StatsApi {

    private StatsStorage statsStorage = StatsStorage.getInstance();

    public ResponseEntity<StatsStorage> getStats() {
        return ResponseEntity.ok(statsStorage);
    }
}
