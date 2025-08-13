package jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;


@Entity
public class Message {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)

  private Long id;
  private String content;
  private LocalDateTime createdAt;
  
  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @Override
  public String toString() {
    return "Message [id=" + id + ", content=" + content + ", createdAt=" + createdAt + "]";
  }
}
