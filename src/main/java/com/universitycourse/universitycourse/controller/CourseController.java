package com.universitycourse.universitycourse.controller;


import com.universitycourse.universitycourse.model.Course;
import com.universitycourse.universitycourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

     @Autowired
   private CourseRepository courseRepository ;


          // get all courses
         //http://localhost:9097/getAllCourses
       @GetMapping("/courses")
     public List<Course> getAllCourses(){

        return  courseRepository.findAll();

     }




         // create a course
       @PostMapping("/createCourse")
      public void createCourse(@RequestBody Course course){

            courseRepository.save(course);


      }


            // get details of a course
           //http://localhost:9097/courses/1
         @GetMapping("/courses/{id}")
        public Course getCourseDetail(@PathVariable long id){

          Optional<Course> course  = courseRepository.findById(id);

          if (course.isEmpty()){

           throw  new RuntimeException("course not found  with id" + id);

          }

          return course.get() ;
        }


           // update a course    http://localhost:9097/updatecourse/1


            @PutMapping("/updatecourse/{id}")
            public void updateCourse(@PathVariable long id , @ RequestBody Course course){

                courseRepository.save(course);


            }



    // delete a course    http://localhost:9097/deletecourse/1

      // course are deleted by id


            @DeleteMapping("/deletecourse/{id}")
            public void deleteCourse(@PathVariable long id ){

                courseRepository.deleteById(id);


            }










}
