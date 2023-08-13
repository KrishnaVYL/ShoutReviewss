package com.gfg.shoutreviews.Controller;
import com.gfg.shoutreviews.request.MovieRequest;
import com.gfg.shoutreviews.response.MovieResponse;
import com.gfg.shoutreviews.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test")
    public String test()
    {
        return "Test API Works";
    }

    @PostMapping("movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest)
    {
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(),
                HttpStatus.CREATED);
    }
}
