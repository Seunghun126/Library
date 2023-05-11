package project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.Borrowtbl;
import project.repository.BorrowRepository;
import project.exception.ResourceNotFoundException;



// 실제 서비스를 구현하는 클래스

@Service

public class BorrowServiceImpl implements BorrowService {

    // 필요한 객체의 타입에 따라 빈(Bean)을 주입

   @Autowired

   private BorrowRepository borrowRepository;



   @Override
   public List<Borrowtbl> findAll() {

       List<Borrowtbl> bs = new ArrayList<>();

       // borrowRepository 객체의 findAll()메소드 실행(호출)

       // 실행결과(레코드)를 forEach구문으로 반복하면서 레코드 하나씩을 bs리스트에 add

       borrowRepository.findAll().forEach(e -> bs.add(e));

       return bs;

   }
    
    @Override
    public Borrowtbl save(Borrowtbl borrow){

        borrowRepository.save(borrow);

        return borrow;
    }
    
    @Override
    public void updateById(int bocode, Borrowtbl borrow){
        // bocode와 같은 레코드가 있는지 확인하고 있다면 update 
        // 없다면 수정할 레코드가 없다는 메세지 출력(Exception)
        Borrowtbl b = borrowRepository.findById(bocode).orElseThrow(() -> new ResourceNotFoundException("Borrowtbl","bocode", bocode));
        b.setBkname(borrow.getBkname());
        b.setUserid(borrow.getUserid());
        b.setBrdate(borrow.getBrdate());
        b.setRedate(borrow.getRedate());
        borrowRepository.save(b);
    }
    
    @Override
    public void deleteById(int bocode){
        borrowRepository.deleteById(bocode);
    }
    

}