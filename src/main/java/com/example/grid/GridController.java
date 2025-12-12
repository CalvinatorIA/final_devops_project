package com.example.grid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GridController {

    private static final Logger logger = LoggerFactory.getLogger(GridController.class);

    @Autowired
    private GridService service;

    @GetMapping("/grid")
    public String generateGrid(@RequestParam(defaultValue = "10") int width,
                               @RequestParam(defaultValue = "10") int length,
                               @RequestParam(defaultValue = "10") int depth) {
        GridRequest req = new GridRequest();
        req.setWidth(width);
        req.setLength(length);
        req.setDepth(depth);

        try {
            GridRequest savedReq = service.saveRequest(req);
            logger.info("Saved via service with ID: {}", savedReq.getId());
        } catch (Exception e) {
            logger.error("Failed to save GridRequest: {}", e.getMessage(), e);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < depth; k++) {
                    int l = i + j + k;
                    if (l < 10) {
                        sb.append(" ");
                    }
                    sb.append(l).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}