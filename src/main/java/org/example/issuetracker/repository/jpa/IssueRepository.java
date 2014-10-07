package org.example.issuetracker.repository.jpa;

import org.example.issuetracker.model.jpa.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

}
