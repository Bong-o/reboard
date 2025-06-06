package kr.co.green.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import kr.co.green.board.data.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	
	//List<BoardEntity> findAllByOrderByIdDesc();
	
	Page<BoardEntity> findAll(Pageable pageable);
	
	@Modifying
	@Transactional
	@Query("UPDATE BoardEntity b SET b.views = b.views + 1 WHERE b.no = :no")
	void updateViewCount(@Param("no") Long no);

    // 검색이 필요한 경우 이런 식으로도 가능
    //Page<BoardEntity> findByTitleContaining(String keyword, Pageable pageable);

}
