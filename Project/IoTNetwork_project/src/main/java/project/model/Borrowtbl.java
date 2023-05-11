package project.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;



import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

/*** 

    데이터베이스의 borrowtbl 테이블과 자바 Borrowtbl 클래스를 매핑시켜야 함

        - 테이블 <-> 자바클래스

        - 테이블의 필드 <-> 자바클래스의 속성

        - 필드의 속성....

***/

/*** 

    자바 어노테이션(Annotation)

    - "@" 기호를 사용

    - 자바 소스코드에서 사용하는 메타데이터

    ex)

     객체와 테이블 매핑 : @Entity / @Table

     기본키(Primary key) 매핑 : @Id

     필드와 속성매핑 : @Column

     relation 매핑 : @ManyToOne / @JoinColumn

 ***/

@Entity

@Table(name="borrowtbl")

// @Data 어노테이션은 toString, getter, setter 등의 많은 메소드를 포함하고 있음

@Data

// @AllArgsConstructor 어노테이션은 모든 필드 값을 파라미터로 받는 생성자

@AllArgsConstructor

// @NoArgsConstructor 어노테이션은 파라미터가 없는 생성자

@NoArgsConstructor

public class Borrowtbl implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bocode;

    private String bkname;

    private Integer userid;

    private String brdate;

    private String redate;

}
// Serializable(직렬화) : 데이터를 저장하거나 배포하는데 적합하도록 일차원으로 생성하고 다시 원래대로 복귀하는 것
// 직렬화에서 serialVersionUID 버전을 포함시키고 역직렬화 과정에서 자바클래스에 선언된 serialVersionUID버전과 일치하는지 확인