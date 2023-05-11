package project.repository;



import java.util.List;

import project.model.Borrowtbl;

import org.springframework.data.jpa.repository.JpaRepository;



public interface BorrowRepository extends JpaRepository<Borrowtbl, Integer> {
    // 데이터베이스에서 전체 레코드를 가져오기
    // SELECT * FROM borrowtbl;
    List<Borrowtbl> findAll();

}