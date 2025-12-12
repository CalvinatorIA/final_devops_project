package com.example.grid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.grid.GridRepository;
import com.example.grid.GridRequest;

@RestController
public class GridController {

    @Autowired
    private GridRepository repo;

    @GetMapping("/grid")
    public String generateGrid(@RequestParam(defaultValue = "10") int width,
                               @RequestParam(defaultValue = "10") int length,
                               @RequestParam(defaultValue = "10") int depth) {
        GridRequest req = new GridRequest();
        req.setWidth(width);
        req.setLength(length);
        req.setDepth(depth);
        repo.save(req);
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