package project.service;



import java.util.List;

import project.model.Borrowtbl;



public interface BorrowService {

    List<Borrowtbl> findAll();
    Borrowtbl save(Borrowtbl borrow);
    void updateById(int bocode, Borrowtbl borrow);
    void deleteById(int bocode);
}