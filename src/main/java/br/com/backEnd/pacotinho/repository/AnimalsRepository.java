package br.com.backEnd.pacotinho.repository;

import br.com.backEnd.pacotinho.model.Animals;
import br.com.backEnd.pacotinho.projections.AnimalsCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM animals WHERE id = :id")
    Animals getById(@Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT " +
            "a.id AS id, " +
            "a.name AS name, " +
            "a.instagramURL AS instagramURL, " +
            "a.registration_date AS registrationDate, " +
            "a.priority AS priority, " +
            "a.active AS active, " +
            "iam.pic_byte AS picByte, " +
            "iam.name AS imageName, " +
            "iam.type AS imageType " +
            "FROM " +
            "animals a " +
            "LEFT JOIN animal_image ai ON ai.animal_id = a.id " +
            "LEFT JOIN image_animal_model iam ON iam.id = ai.image_id " +
            "WHERE " +
            "(LOWER(a.name) LIKE LOWER(CONCAT('%', :name ,'%')) OR :name IS NULL)")
    Page<AnimalsCriteria> getByCriteria(@Param("name") String name, Pageable pageable);


}
