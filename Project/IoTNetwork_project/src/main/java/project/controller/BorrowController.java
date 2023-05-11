package project.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import project.model.Borrowtbl;

import project.service.BorrowService;



// @Controller + @ResponseBody

@RestController

// @RequestMapping 어노테이션은 라우팅에 대한 정보를 제공, Client의 요청을 처리하기위해 api URL을 Mapping

@RequestMapping("borrow")

public class BorrowController {
       @Autowired
       private BorrowService borrowService;
       // @GetMapping: HTTP GET 요청을 특정 핸들러 메소드에 매핑하기 위한 어노테이션
       @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
           public ResponseEntity<List<Borrowtbl>> getAllBorrows() {
             List<Borrowtbl> bs = borrowService.findAll();
           // ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
             return new ResponseEntity<List<Borrowtbl>>(bs, HttpStatus.OK);

       }
        // 대출 정보 입력
        @PostMapping
        public ResponseEntity<Borrowtbl> save(@RequestBody Borrowtbl borrow){
            return new ResponseEntity<Borrowtbl>(borrowService.save(borrow), HttpStatus.OK);
    }
        // 대출 정보 수정 => 클라이언트가 수정할 대출 PK를 알려주어야 함
        @PutMapping(value="/{bocode}", produces={MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<Borrowtbl> updateBorrow(@PathVariable("bocode") int bocode, @RequestBody Borrowtbl borrow){
            borrowService.updateById(bocode, borrow);
            return new ResponseEntity<Borrowtbl>(borrow, HttpStatus.OK);
        }

        // 대출 정보 삭제
        @DeleteMapping(value="/{bocode}", produces={MediaType.APPLICATION_JSON_VALUE})
        public ResponseEntity<Void>deleteBorrow(@PathVariable("bocode") int bocode){
            borrowService.deleteById(bocode);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

}